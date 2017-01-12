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
	
	/*
	 * int roundNumber
		boolean acceptingInput
		int sequenceIndex
		int lastSelectedButton
	
	*/
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
		ProgressInterfaceSharonWong.setRound(roundNum);
		ProgressInterfaceSharonWong.setSequenceSize(sequence.size());
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
			
			
//			if(b != null){
//				b.dim();
//			}
//			if (b==sequence.get(sequenceIndex).getButton()){
//				sequenceIndex++;
//			}
//			else{
//				ProgressInterfaceSharonWong.getOver();
//			}
//			b.highlight();
//			try {
//				Thread.sleep((long) (1000*(5.0)/roundNum));
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
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
		buttons = new ButtonInterfaceSharonWong[5];
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
		Color[] buttonColor = {Color.blue, Color.red,Color.pink,Color.orange,Color.yellow};
		//place all buttons
		for(int i =0; i < numberOfButtons; i++){
			final ButtonInterfaceSharonWong b = getAButton();
			b.setColor(buttonColor[i]);
			b.setX(160 + (int)(100*Math.cos(i*2*Math.PI/(numberOfButtons))));
			b.setY(200 + (int)(100*Math.cos(i*2*Math.PI/(numberOfButtons))));
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
							ProgressInterfaceSharonWong.getOver();
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
	/*
	 * 
	 * Methods to be finished:
	 * 
	 */
	
	private ButtonInterfaceSharonWong getAButton() {
		return new Button();
	}
	private ProgressInterfaceSharonWong getProgress() {
		return new Progress();
	}	
	
}


