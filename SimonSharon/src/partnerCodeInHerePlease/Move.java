package partnerCodeInHerePlease;

import gui.simon.ButtonInterfaceSharonWong;
import gui.simon.MoveInterfaceSharonWong;

public class Move implements MoveInterfaceSharonWong {
	private ButtonInterfaceSharonWong b;
	public Move(ButtonInterfaceSharonWong b) {
		this.b=b;
		// TODO Auto-generated constructor stub
	}

	@Override
	public ButtonInterfaceSharonWong getButton() {
		
		return b;
	}

}
