package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.Components.Component;
import gui.simon.ProgressInterfaceSharonWong;

public class Progress extends Component implements simonSharon.ProgressInterfaceSharonWong{
	//fields
	private boolean gameOver;
	private String round;
	private String sequence;
	
	public void setRound(int roundNumber) {
		round = "Round " + roundNumber;
		update();
		
	}
	
	public void getOver() {
		gameOver = true;
		update();
		
	}
	
	public void setSequenceSize(int size) {
		sequence = "Sequence length "+size;
		update();
	}


	
	
	public Progress() {
		super(60, 60, 120, 50);
		gameOver=false;
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		FontMetrics fm = g.getFontMetrics();
		if(gameOver){
			g.setColor(new Color(255,55,90));
			g.fillRect(0, 0, 120, 50);
			g.setColor(Color.white);
			String go = "GAME OVER!";
			g.drawString(go, (120 - fm.stringWidth(go))/2, 20);
			g.drawString(sequence, (50 - fm.stringWidth(sequence))/2, 40);

		}else{
			g.setColor(new Color(220,255,230));
			g.fillRect(0, 0, 120, 50);
			g.setColor(Color.black);
			g.drawRect(0, 0, 120-1, 50-1);
			if(round !=null && sequence != null){

				g.drawString(round, (120 - fm.stringWidth(round))/2, 20);
				g.drawString(sequence, (120 - fm.stringWidth(sequence))/2, 40);
			}
		}

	}

}
