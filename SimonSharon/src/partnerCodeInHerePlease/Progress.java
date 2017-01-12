package partnerCodeInHerePlease;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.Components.Component;
import gui.simon.ProgressInterfaceSharonWong;

public class Progress extends Component implements ProgressInterfaceSharonWong{
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
		

	}

}
