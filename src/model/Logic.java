package model;

import java.util.LinkedList;

import processing.core.PApplet;

public class Logic {

	private PApplet app;
	
	private String [] file;
	private LinkedList<People> people;
	private LinkedList<Indicator> indicator;
	
	
	public Logic (PApplet app) {
		
		this.app = app;
		
		file= app.loadStrings("../resources/file");
		people= new LinkedList<People>();
		indicator= new LinkedList<Indicator>();
		
		for (int i = 0; i < file.length; i++) {

			String[] data = file[i].split(":");
			System.out.println(data[0]);

			String tipo = data[0];
			int tam = Integer.parseInt(data[1]);

			if (tipo.equals("sanas")) {
				for (int s = 0; s < tam; s++) {
					people.add(new Healthy(false, false, app));
				}
			} else if (tipo.equals("infectadas")) {
				people.add(new Infected(true, false, app));
			} else {
				people.add(new Healthy(true, true, app));
			}

		}
		
		System.out.println(people.size());
		
		createIndicator();
		
	}
	
	public void createIndicator() {
		
		indicator.add(new HealthyIndicator(app));
		indicator.add(new InfectedIndicator(app));
		indicator.add(new RecoveredIndicator(app));
		System.out.println(indicator.size());
	}
	
	public void paint() {
		
		for (int i = 0; i < people.size(); i++) {
			people.get(i).paint();
			Thread newPerson = new Thread(people.get(i));
			newPerson.start();
		}
		
		for (int i = 0; i < indicator.size(); i++) {
			indicator.get(i).paint((i*20)+50);
		}
	}
	
	

	public void sortList(char key) {
		
	}
	
	public void infection () {
		
		for (int i = 0; i < people.size(); i++) {
			
		}
		
	}

}
