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
				people.add(new Infected(true, true, app));
			}

		}
		
		System.out.println(people.size());
	}
	
	public void paint() {
		
		for (int l = 0; l < people.size(); l++) {
			people.get(l).paint();
			Thread nuevoH = new Thread(people.get(l));
			nuevoH.start();
		}
	}

	public void sortList(char key) {
		
		
	}

}
