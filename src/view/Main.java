package view;

import controller.Controller;
import processing.core.PApplet;

public class Main extends PApplet{

	private Controller controller;
	
	public static void main(String[] args) {
		
		PApplet.main("view.Main");
	}
	
	public void settings() {
		
		size(800,800);
	}
	
	public void setup() {
		
		controller = new Controller(this);
	}
	
	public void draw() {
		
		background(255);
		controller.paint();
		paintInformation();
	}
	
	public void paintInformation() {
		
		fill(0);
		text("Presione las siguientes teclas para ordenar:", 300 , 50);
		text("N = Número de personas", 300 , 70);
		text("P = Color de indicadores", 300 , 90);
	}
	
	public void keyPressed() {
		
		controller.sortList(key);
	}
}
