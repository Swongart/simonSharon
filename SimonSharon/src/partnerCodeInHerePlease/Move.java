package partnerCodeInHerePlease;

import gui.simon.ButtonInterfaceSharonWong;
import gui.simon.MoveInterfaceSharonWong;

public class Move implements MoveInterfaceSharonWong {
	private ButtonInterfaceSharonWong b;
	public Move(ButtonInterfaceSharonWong b) {
		this.b=b;
		
	}

	@Override
	public ButtonInterfaceSharonWong getButton() {
		
		return b;
	}

}
