package simonSharon;

import gui.GUIApplication;

public class SimonGameSharonWong extends GUIApplication {

	public SimonGameSharonWong(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		SimonScreenSharonWong simonScreen = new SimonScreenSharonWong (getWidth(),getHeight());
		setScreen(simonScreen);
	}
	public static void main(String[] args){
		SimonGameSharonWong simonGame = new SimonGameSharonWong(800,600);
		Thread game = new Thread(simonGame); 
		game.start(); 
	}

}
