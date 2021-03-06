package simonSharon;

import java.awt.Color;

import java.util.ArrayList;

import gui.Components.Action;
import gui.Components.ClickableScreen;
import gui.Components.TextLabel;
import gui.Components.Visible;
import partnerCodeInHerePlease.Progress;
import partnerCodeInHerePlease.Button;
import partnerCodeInHerePlease.Move;
public class SimonScreenSharonWong extends ClickableScreen implements Runnable {
	//fields

	private TextLabel label;
	private ButtonInterfaceSharonWong[] buttons;
	private ProgressInterfaceSharonWong progress;
	private ArrayList<MoveInterfaceSharonWong> sequence;
	
	private int roundNum;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int last;
	
	
	public SimonScreenSharonWong(int width, int height) {
		super(width, height);
		
		Thread simonStart = new Thread(this);
		simonStart.start();
	}

	@Override
	public void run() {
		label.setText("");
	    nextRound();

	}

	private void nextRound() {
		acceptingInput = false;
		roundNum++;
		sequence.add(randomMove());
		progress.setRound(roundNum);
		progress.setSequenceSize(sequence.size());
		changeText("Simon's turn");
		label.setText("");
		playSequence();
		changeText("Your turn");
		acceptingInput = true;
		sequenceIndex = 0;
		
	}

	private void playSequence() {
		
		ButtonInterfaceSharonWong b = null;
		for(int i =0; i<sequence.size();i++){
			if(b!=null)b.dim();
			
			b = sequence.get(i).getButton();
			b.highlight();
			try {
				Thread.sleep((long)(2000*(2.0/(roundNum+2))));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		b.dim();
		
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		addButtons(viewObjects);
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceSharonWong>();
		//add 2 moves to start
		last = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNum = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
		
	}

	private MoveInterfaceSharonWong randomMove() {
		//buttons = new ButtonInterfaceSharonWong[5];
		//code that randomly selects a ButtonInterfaceX
		int rand = (int)(Math.random()*buttons.length);
		//if its equal then select rand again
		while(rand == last){
			rand = (int) (Math.random()*buttons.length);
		}
		last = rand;
		return new Move(buttons[rand]);
	}

	

	private void addButtons(ArrayList<Visible> viewObjects) {
		
		int numberOfButtons = 5;
		Color[] buttonColor = {Color.blue, Color.red,Color.green,Color.orange,Color.yellow};
		String[] names = {"blue", "red", "green", "orange", "yellow"};

		buttons = new ButtonInterfaceSharonWong[numberOfButtons];
		//place all buttons
		for(int i =0; i < numberOfButtons; i++){
			buttons[i] = getAButton();
			buttons[i].setColor(buttonColor[i]);
			buttons[i].setName(names[i]);
			buttons[i].setX(150*i);
			buttons[i].setY(250+i);
			final ButtonInterfaceSharonWong b = buttons[i];
			b.setAction(new Action(){
				
				public void act(){
					if(acceptingInput){
						Thread blink = new Thread(new Runnable(){
							public void run(){
								b.highlight();
								try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
							}
						});
						blink.start();
						if(b == sequence.get(sequenceIndex).getButton()){
							sequenceIndex++;
						}else{
							progress.getOver();
						}
						if(sequenceIndex == sequence.size()){
							Thread nextRound = new Thread(SimonScreenSharonWong.this);
							nextRound.start(); 
						}
					}
				}
			});
			viewObjects.add(b);
		}
	}

	
	private void changeText(String string) {
		try{
			label.setText(string);
			Thread.sleep(500);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	private ButtonInterfaceSharonWong getAButton() {
		return new Button();
	}
	private ProgressInterfaceSharonWong getProgress() {
		return new Progress();
	}	
	
}


