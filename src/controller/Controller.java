package controller;

import model.Logic;
import processing.core.PApplet;

public class Controller {

	private PApplet app;
	private Logic logic;
	
	public Controller (PApplet app) {
		
		logic = new Logic(app);
		this.app = app;
	}
	
	public void sortList(char key) {
		
		logic.sortList(key);
	}

	public void paint() {
		
		logic.paint();
	}

}
