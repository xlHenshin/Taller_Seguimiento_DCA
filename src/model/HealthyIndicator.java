package model;

import processing.core.PApplet;

public class HealthyIndicator extends Indicator {

	public HealthyIndicator(PApplet app) {
		super(app);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(int posY) {
		// TODO Auto-generated method stub
		
		app.fill(0);
		app.text("Personas sanas: "+ counter, 50 , posY);
	}

}
