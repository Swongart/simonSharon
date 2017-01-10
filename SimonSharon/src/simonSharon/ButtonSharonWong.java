package simonSharon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.Components.Action;
import gui.Components.Component;

public class ButtonSharonWong extends Component implements ButtonInterfaceSharonWong {

	private Action action;
	private Color color;
	private boolean isOn;

	public ButtonSharonWong(int x, int y) {
		super(x,y,50,50);
		
	}

	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void act() {
		this.action.act();
	}

	@Override
	public void setColor(Color color) {
		this.color=color;
	}

	@Override
	public void setX(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setY(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAction(Action a) {
		this.action = a;
	}

	@Override
	public void highlight() {
		isOn = true;
		update();
	}

	@Override
	public void dim() {
		isOn = false;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		//update button graphics(set colors when on[highlighted] & grey when off [dim])
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(isOn)
			g.setColor(this.color);
		else
			g.setColor(Color.gray);
		//g.fillOval
		//g.setColor
		//g.drawOval
		
	}

}
