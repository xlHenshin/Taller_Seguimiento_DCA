package model;

import processing.core.PApplet;

public class InfectedIndicator extends Indicator {

	public InfectedIndicator(PApplet app) {
		super(app);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(int posY) {
		// TODO Auto-generated method stub
		
		app.fill(255,0,0);
		app.text("Personas infectadas: "+ counter, 50 , posY);
	}

}
