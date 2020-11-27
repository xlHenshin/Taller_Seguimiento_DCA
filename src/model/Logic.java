package model;

import java.util.Collections;
import java.util.LinkedList;

import exception.Infection;
import exception.Thirty;
import processing.core.PApplet;

public class Logic {

	private PApplet app;
	
	private String [] file;
	private LinkedList<People> people;
	private LinkedList<Indicator> indicator;
	
	private ColorComparator colorCompare;
	
	public Logic (PApplet app) {
		
		this.app = app;
		
		file= app.loadStrings("../resources/file");
		people= new LinkedList<People>();
		indicator= new LinkedList<Indicator>();
		colorCompare= new ColorComparator();
		
		
		
		//========================================
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
		
		//========================================
		
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
		
		try {
			infection();
		} catch (Infection e) {
			// TODO Auto-generated catch block
			System.out.println("Nuevo infectado");
		}
		
		indicator();
	}
	
	public void indicator() {
		
		int infected = 0;
		int healthy = 0;
		int recovered = 0;
		
		for (int i = 0; i < people.size(); i++) {

			if (people.get(i).isHealthy()) {
				recovered++;
			} else if (people.get(i).isInfected()) {
				infected++;
			} else {
				healthy++;
			}
		}
		
		for (int i = 0; i < indicator.size(); i++) {
			
			indicator.get(i).setColor(1);
			indicator.get(i).setCounter(infected);
			indicator.get(i).setColor(3);
			indicator.get(i).setCounter(recovered);
			
			if (indicator.get(i) instanceof InfectedIndicator) {
				
				indicator.get(i).setColor(1);
				indicator.get(i).setCounter(infected);
				
			} else if (indicator.get(i) instanceof RecoveredIndicator) {
				
				indicator.get(i).setColor(3);
				indicator.get(i).setCounter(recovered);
				
			} else {
				
				indicator.get(i).setColor(2);
				indicator.get(i).setCounter(healthy);
			}
		}
		
		if (infected == 30) {
			try {
				throw new Thirty("30% de la población está infectada");
			} catch (Thirty e) {
				System.out.println("30% de la población está infectada");
			}
		}
		
	}
	
	

	public void sortList(char key) {
		
		switch (key) {
		case 'n':
			System.out.println("==============");
			System.out.println("Sort By Number");
			System.out.println("==============");
			
			Collections.sort(indicator);
			break;
			
		case 'p':
			System.out.println("==============");
			System.out.println("Sort By Color");
			System.out.println("==============");
			
			Collections.sort(indicator, colorCompare);
			break;

		default:
			break;
		}
	}
	
	public void infection () throws Infection{
		
		for (int i = 0; i < people.size(); i++) {
			for (int j = 0; j < people.size(); j++) {
				
				float probability = app.random(0, 100);

				if (probability < 20) {
					
					if (PApplet.dist(people.get(i).getPosX(), people.get(i).getPosY(), 
							people.get(j).getPosX(), people.get(j).getPosY()) < people.get(j).getSize()) {

						if (people.get(j) instanceof Healthy == people.get(i) instanceof Healthy) {

							people.get(i).getDirX();
							people.get(i).getDirY();
							people.get(j).getDirX();
							people.get(j).getDirY();

						} else if (people.get(j) instanceof Healthy
								&& people.get(i).isHealthy()==false &&  people.get(i).isInfected())  {

							people.add(new Infected(true, false, app));
							people.remove(people.get(j));

							throw new Infection("Nuevo infectado");

						}
					}
				}
			}
		}
		
	}

}
