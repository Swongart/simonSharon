package simonSharon;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.Components.Component;

public class ProgressSharonWong extends Component implements ProgressInterfaceSharonWong {
	//fields
	private boolean gameOver;
	
	
	public ProgressSharonWong(int x, int y, int w, int h) {
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
