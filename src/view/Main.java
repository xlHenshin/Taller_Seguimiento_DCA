package view;

import controller.Controller;
import processing.core.PApplet;

public class Main extends PApplet{

	private Controller controller;
	
	public static void main(String[] args) {
		
		PApplet.main("view.Main");
	}
	
	public void settings() {
		
		size(500,500);
	}
	
	public void setup() {
		
		controller = new Controller(this);
	}
	
	public void draw() {
		
		background(255);
		
	}
	
	public void keyPressed() {
		
		controller.sortList(key);
	}
}
