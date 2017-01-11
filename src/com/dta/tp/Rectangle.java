package com.dta.tp;

import java.util.Collection;
import java.util.HashSet;

public class Rectangle extends Figure implements Surfacable {
	
	private Point basGauche, basDroit, hautGauche, hautDroit;
	
	public Rectangle(Point p, int largeur, int hauteur){
		basGauche = new Point( p.getX() , p.getY() );
		basDroit = new Point( p.getX() + largeur , p.getY() );
		hautGauche = new Point( p.getX() , p.getY() + hauteur );
		hautDroit = new Point( p.getX() + largeur , p.getY() + hauteur );
	}
	
	public Point getPointBasGauche(){
		return basGauche;
	}
	
	public Point getPointBasDroit(){
		return basDroit;
	}
	
	public Point getPointHautGauche(){
		return hautGauche;
	}
	
	public Point getPointHautDroit(){
		return hautDroit;
	}
	
	protected String getType(){
		return "RECT";
	}
	
	public String toString(){
		return "["+getType()+" "+getPointBasDroit()+" "+getPointBasGauche()+" "+getPointHautGauche()+" "+getPointHautDroit()+" ]";
	}
	
	@Override
	public Point getCentre() {
		int x = (this.getPointBasDroit().getX() + this.getPointHautGauche().getX() ) / 2;
		int y = (this.getPointBasDroit().getY() + this.getPointHautGauche().getY() ) / 2;
		return new Point(x, y);
	}

	@Override
	public double surface() {
		int largeur = this.getPointHautDroit().getX() - this.getPointBasGauche().getX();
		int hauteur = this.getPointHautDroit().getY() - this.getPointBasGauche().getY();
		return largeur * hauteur;
	}

	@Override
	public Collection<Point> getPoints() {
		// Il n'y a pas de doublon, il n'y a pas d'ordre
		Collection<Point> collection = new HashSet<Point>();
		collection.add(getPointBasDroit());
		collection.add(getPointBasGauche());
		collection.add(getPointHautGauche());
		collection.add(getPointHautDroit());
		return collection;
	}

	@Override
	public boolean couvre(Point p) {
		if(p.getX() < getPointBasGauche().getX()){
			return false;
		}
		if(p.getX() > getPointHautDroit().getX()){
			return false;
		}
		if(p.getY() < getPointBasGauche().getY()){
			return false;
		}
		if(p.getY() > getPointHautDroit().getY()){
			return false;
		}
		return true;
	}
	
	public boolean equals(Object o){
		if(o instanceof Rectangle){
			Rectangle r = (Rectangle) o;
			return this.getPointBasDroit().equals(r.getPointBasDroit())
					&& this.getPointHautGauche().equals(r.getPointHautGauche());
		} else {
			return false;
		}
	}
	
}
