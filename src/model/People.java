package model;

import processing.core.PApplet;

public abstract class People implements Runnable{

	protected PApplet app;
	
	protected int posX, posY, size, speed;
	protected float dirX, dirY;
	protected boolean infected, healthy;
	
	public People(boolean infected, boolean healthy, PApplet app) {
		
		this.app=app;
		this.infected = infected;
		this.healthy = healthy;
		posX = (int) (app.random(200, 600));
		posY = (int) (app.random(200, 600));
		size = 7;
		dirX = app.random(-1, 1);
		dirY = 1;
		speed= 2;
	
	}
	
	public void paint() {
	
		
		if(healthy == true && infected ==true){
				
			app.fill(0,0,255);
			app.ellipse(posX, posY, size, size);
			
		}else if (infected == true) {
		
			app.fill(255,0,0);
			app.ellipse(posX, posY, size, size);
		
		}else {
			
			app.fill(0,255,0);
			app.ellipse(posX, posY, size, size);
			
		}
	}
	
	public void move() {
		
		if(dirX == 0) {
			dirX+=1;
		}
		
		posX += dirX * speed;
		posY += dirY * speed;

		if (dirX == 1) {
			if (posX <= 200 || posX >= 600) {
				dirX *= -1;
			}
		}
		
		if (posX <= 200 || posX >= 600) {
			dirX *= -1;
		}
		 
		if (posY <= 200 || posY >= 600) {
			
			dirY *= -1;
		}
	}
	
	public void run() {
		
		move();
		
		if(infected) {
			
			try {
				
				Thread.sleep(14000);
				healthy=true;
				
			} catch (InterruptedException e) {
				// TODO: handle exception
				
				e.printStackTrace();
			}
		}
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public float getDirX() {
		return dirX;
	}

	public void setDirX(int dirX) {
		this.dirX = dirX;
	}

	public float getDirY() {
		return dirY;
	}

	public void setDirY(int dirY) {
		this.dirY = dirY;
	}

	public boolean isInfected() {
		return infected;
	}

	public void setInfected(boolean infected) {
		this.infected = infected;
	}

	public boolean isHealthy() {
		return healthy;
	}

	public void setHealthy(boolean healthy) {
		this.healthy = healthy;
	}
	
	
	
}
