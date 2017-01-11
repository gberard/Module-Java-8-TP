package com.dta.tp;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public abstract class Figure implements Comparable<Figure>, Serializable {
	
	private static final long serialVersionUID = -5458801387012177734L;
	
	private static int nextID = 1;
	private final String id = getType() + (nextID++);
	private Couleur couleur;
	
	public String getId(){
		return id;
	}
	
	protected Figure(Couleur c){
		couleur = c;
	}
	
	protected abstract String getType();
	
	public abstract Point getCentre();
	
	public abstract Collection<Point> getPoints();
	
	public abstract boolean couvre(Point p);
	
	public Couleur getCouleur(){
		return couleur;
	}
	
	public void affiche(){
		System.out.println(this.toString());
	}
	
	public double distanceOrigine(){
		Optional<Double> distance = getPoints().stream()
				.map(p -> p.distanceOrigine())
				.max((d1,d2) -> d1>d2 ? -1 : 1 );
		if(distance.isPresent()){
			return distance.get();
		} else {
			return Double.POSITIVE_INFINITY;
		}
	}
	
	public int compareTo(Figure f){
		if(this.equals(f)){
			return 0;
		}
		double d1 = this.distanceOrigine();
		double d2 = f.distanceOrigine();
		return (d1-d2) > 0 ? -1 : 1;
	}
	
}
