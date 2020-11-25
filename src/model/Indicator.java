package model;

import processing.core.PApplet;

public abstract class Indicator {

	protected PApplet app;
	
	protected int counter;
	
	public Indicator(PApplet app) {
		
		this.app=app;
		counter= 0;
	}
	
	public abstract void paint(int posY);

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
}
