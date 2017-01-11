package com.dta.tp;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

public class Rond extends Figure implements Surfacable, Serializable{
	
	private static final long serialVersionUID = -6680982631033885326L;
	
	private Point centre;
	private int rayon;
	
	public Rond(Point centre, int rayon){
		this(Couleur.getCouleurDefaut(), centre, rayon);
	}
	
	public Rond(Couleur c, Point centre, int rayon){
		super(c);
		this.centre = centre;
		this.rayon = rayon;
	}
	
	protected String getType(){
		return "ROND";
	}
	
	public String toString(){
		return "["	+getType()
					+" "
					+getCouleur().getCode()
					+" "
					+centre
					+" "
					+rayon
					+"]";
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
	
	public boolean equals(Object o){
		if(o instanceof Rond){
			Rond r = (Rond) o;
			return this.centre.equals(r.centre) && (this.rayon == r.rayon) && (this.getCouleur() == r.getCouleur());
		} else {
			return false;
		}
	}
}
