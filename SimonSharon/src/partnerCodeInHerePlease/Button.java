package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.Components.Action;
import gui.Components.Component;
import gui.simon.ButtonInterfaceSharonWong;

public class Button extends Component implements  simonSharon.ButtonInterfaceSharonWong {

	private Action action;
	private Color color;
	private boolean isOn;
	private String name;
	private static int x;
	private static int y;

	public Button() {
		super(x,y,50,50);
		
	}

	
	public boolean isHovered(int x, int y) {
		double distance = Math.sqrt(Math.pow(x-(getX()+50/2), 2)+Math.pow(y-(getY()+50/2), 2));
		return  distance < 50/2;
	}

	
	public void act() {
		this.action.act();
	}

	
	public void setColor(Color color) {
		this.color=color;
		update();
	}


	
	public void setAction(Action a) {
		this.action = a;
	}

	
	public void highlight() {
		isOn = true;
		update();
	}

	
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
			g.setColor(color);
		else
			g.setColor(Color.gray);
			g.fillOval(0, 0, 50, 50);
			g.setColor(Color.BLACK);
			g.drawOval(0, 0, 49, 49);
		
	}
	@Override
	public void setX(int i) {
		x = i;

	}

	@Override
	public void setY(int i) {
		y = i;

	}


	public void setName(String s){
		this.name = s;
	}

}
