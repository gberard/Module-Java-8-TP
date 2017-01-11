package com.dta.tp;

public class Rectangle extends Figure {
	
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
	
}
