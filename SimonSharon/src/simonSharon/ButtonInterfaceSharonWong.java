package simonSharon;

import java.awt.Color;

import gui.Components.Action;
import gui.Components.Clickable;

public interface ButtonInterfaceSharonWong extends Clickable {
	void setColor(Color color);

	void setX(int i);

	void setY(int i);
	
	void setAction(Action a);

	void highlight();

	void dim();

	void setName(String string);

	
}
