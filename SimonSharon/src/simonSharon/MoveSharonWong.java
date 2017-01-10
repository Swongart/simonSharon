package simonSharon;

public class MoveSharonWong implements MoveInterfaceSharonWong {
	private ButtonInterfaceSharonWong button;
	public MoveSharonWong(ButtonInterfaceSharonWong b) {
		this.button=b;
		// TODO Auto-generated constructor stub
	}

	@Override
	public ButtonInterfaceSharonWong getButton() {
		// TODO Auto-generated method stub
		return button;
	}

}
