package com.dta.tp;

import java.util.Collection;
import java.util.HashSet;

public class Rond extends Figure implements Surfacable {
	
	private Point centre;
	private int rayon;
	
	public Rond(Point centre, int rayon){
		this.centre = centre;
		this.rayon = rayon;
	}
	
	public String toString(){
		return "[ROND "+centre+" "+rayon+"]";
	}
	
	@Override
	public Point getCentre() {
		return centre;
	}

	@Override
	public double surface() {
		return this.rayon * this.rayon * Math.PI;
	}

	@Override
	public Collection<Point> getPoints() {
		// Il n'y a pas de doublon, il n'y a pas d'ordre
		Collection<Point> collection = new HashSet<Point>();
		collection.add(centre);
		return collection;
	}

	@Override
	public boolean couvre(Point p) {
		int x2 = (p.getX() - centre.getX()) * (p.getX() - centre.getX());
		int y2 = (p.getY() - centre.getY()) * (p.getY() - centre.getY());
		int d = (int) Math.round(Math.sqrt( x2 + y2 ));
		return d <= rayon;
	}
	
}
