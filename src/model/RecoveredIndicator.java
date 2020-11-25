package model;

import processing.core.PApplet;

public class RecoveredIndicator extends Indicator{

	public RecoveredIndicator(PApplet app) {
		super(app);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(int posY) {
		// TODO Auto-generated method stub
		
		app.fill(0);
		app.text("Personas recuperadas: "+ counter, 50 , posY);
	}

}
