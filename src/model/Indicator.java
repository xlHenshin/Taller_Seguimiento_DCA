package model;

import processing.core.PApplet;

public abstract class Indicator implements Comparable<Indicator> {

	protected PApplet app;
	
	protected int counter, color;
	
	public Indicator(PApplet app) {
		
		this.app=app;
		counter= 0;
		color=0;
	}
	
	public abstract void paint(int posY);
	
	public int compareTo(Indicator o) {
		return o.getCounter()-this.getCounter();
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	
	
	
}
