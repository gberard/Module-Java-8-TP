package com.dta.tp;

import java.util.Collection;
import java.util.HashSet;

public class Segment extends Figure {
	
	private Point debut, fin;
	
	public Segment(Point p, int longeur, boolean horizontal){
		debut = new Point(p.getX(), p.getY());
		fin = new Point(p.getX() + (horizontal?longeur:0), p.getY() + (horizontal?0:longeur));
	}
	
	public Point getDebut(){
		return debut;
	}
	
	public Point getFin(){
		return fin;
	}
	
	public String toString(){
		return "[SEG "+getDebut()+" "+getFin()+" ]";
	}
	
	@Override
	public Point getCentre() {
		int x = (getDebut().getX() + getFin().getX()) / 2;
		int y = (getDebut().getY() + getFin().getY()) / 2;
		return new Point(x, y);
	}

	@Override
	public Collection<Point> getPoints() {
		// Il n'y a pas de doublon, il n'y a pas d'ordre
		Collection<Point> collection = new HashSet<Point>();
		collection.add(debut);
		collection.add(fin);
		return collection;
	}

	@Override
	public boolean couvre(Point p) {
		if(p.getX() < getDebut().getX()){
			return false;
		}
		if(p.getX() > getFin().getX()){
			return false;
		}
		if(p.getY() < getDebut().getY()){
			return false;
		}
		if(p.getY() > getFin().getY()){
			return false;
		}
		return true;
	}
	
}
