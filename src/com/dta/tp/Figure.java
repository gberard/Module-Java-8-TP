package com.dta.tp;

import java.util.Collection;

public abstract class Figure implements Comparable<Figure> {
	
	public abstract Point getCentre();
	
	public abstract Collection<Point> getPoints();
	
	public abstract boolean couvre(Point p);
	
	public void affiche(){
		System.out.println(this.toString());
	}
	
	public double distanceOrigine(){
		double distance = Double.POSITIVE_INFINITY;
		for(Point p : getPoints()){
			if(p.distanceOrigine()<distance){
				distance = p.distanceOrigine();
			}
		}
		return distance;
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
