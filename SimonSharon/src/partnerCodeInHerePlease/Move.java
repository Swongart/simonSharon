package partnerCodeInHerePlease;

import gui.simon.ButtonInterfaceSharonWong;
import gui.simon.MoveInterfaceSharonWong;

public class Move implements MoveInterfaceSharonWong {
	private ButtonInterfaceSharonWong button;
	public Move(ButtonInterfaceSharonWong b) {
		this.button=b;
		// TODO Auto-generated constructor stub
	}

	@Override
	public ButtonInterfaceSharonWong getButton() {
		// TODO Auto-generated method stub
		return button;
	}

}
