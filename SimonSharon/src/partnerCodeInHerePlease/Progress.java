package partnerCodeInHerePlease;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.Components.Component;
import gui.simon.ProgressInterfaceSharonWong;

public class Progress extends Component implements ProgressInterfaceSharonWong {
	//fields
	private boolean gameOver;
	
	
	public Progress(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
		gameOver=false;
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// TODO Auto-generated method stub

	}

}
