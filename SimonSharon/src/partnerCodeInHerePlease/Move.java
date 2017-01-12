package partnerCodeInHerePlease;

import gui.simon.ButtonInterfaceSharonWong;
import gui.simon.MoveInterfaceSharonWong;

public class Move implements  simonSharon.MoveInterfaceSharonWong {

	
	private simonSharon.ButtonInterfaceSharonWong b;

	
	public Move(simonSharon.ButtonInterfaceSharonWong button) {
		this.b=button;
		
	}

	@Override
	public simonSharon.ButtonInterfaceSharonWong getButton() {
		
		return b;
	}

}
