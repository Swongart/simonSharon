package partnerCodeInHerePlease;

import gui.simon.ButtonInterfaceSharonWong;
import gui.simon.MoveInterfaceSharonWong;

public class Move implements  simonSharon.MoveInterfaceSharonWong {

	
	private ButtonInterfaceSharonWong b;

	
	public Move(ButtonInterfaceSharonWong button) {
		this.b=button;
		
	}

	@Override
	public ButtonInterfaceSharonWong getButton() {
		
		return b;
	}

}
