package model;

import processing.core.PApplet;

public abstract class People implements Runnable{

	protected PApplet app;
	
	protected int posX, posY, size, dirX, dirY;
	protected boolean infected, healthy;
	
	public People(boolean infected, boolean healthy, PApplet app) {
		
		this.app=app;
		this.infected = infected;
		this.healthy = healthy;
		posX = (int) (app.random(0, 500));
		posY = (int) (app.random(0, 500));
		size = 7;
	
	}
	
	public void paint() {
		
		if(healthy == true && infected ==true){
				
			app.fill(0,0,255);
			app.ellipse(posX, posY, size, size);
			
		}else if(infected) {
		
			app.fill(255,0,0);
			app.ellipse(posX, posY, size, size);
		
		}else {
			
			app.fill(0,255,0);
			app.ellipse(posX, posY, size, size);
			
		}
	}
	
	public void move() {
		
		dirX = (int) app.random(-2, 3);
		dirY = (int) app.random(-2, 3);
		posX += dirX;
		posY += dirY;

		if (posX <= 40 || posX >= app.width - 40) {
			dirX *= -1;
			dirY *= -1;
		} 
		if (posY <= 20|| posY >= app.height - 60) {
			dirX *= -1;
			dirY *= -1;
		}
	}
	
	public void run() {
		
	}
	
}
