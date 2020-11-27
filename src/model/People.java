package model;

import processing.core.PApplet;

public abstract class People implements Runnable{

	protected PApplet app;
	
	protected int posX, posY, size;
	protected int dirX, dirY;
	protected float r, speed;
	protected boolean infected, healthy;
	
	public People(boolean infected, boolean healthy, PApplet app) {
		
		this.app=app;
		this.infected = infected;
		this.healthy = healthy;
		posX = (int) (app.random(1, 700));
		posY = (int) (app.random(1, 799));
		size = 7;
		
		r = app.random(0,1);
		
		dirX=1;
		if (r < 0.5) {
			
			dirX *=-1;
		} else if(r >= 0.5) {
			
			dirX *=1;
		}
		dirY = 1;
		speed= 1;
	
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
		
		if (posX <= 0) {
			dirX *= -1;
		}
		
		if (posX >= 800) {
			dirX *= -1;
		}
		 
		if (posY <= 0 || posY >= 800) {
			
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
