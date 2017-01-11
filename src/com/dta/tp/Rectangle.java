package com.dta.tp;

public class Rectangle {
	
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
	
	public String toString(){
		return "[RECT "+getPointBasDroit()+" "+getPointBasGauche()+" "+getPointHautGauche()+" "+getPointHautDroit()+" ]";
	}
	
	public void affiche(){
		System.out.println(this.toString());
	}
	
}
