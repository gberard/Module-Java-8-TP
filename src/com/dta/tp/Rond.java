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
	
}
