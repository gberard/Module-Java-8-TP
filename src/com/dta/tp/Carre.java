package com.dta.tp;

public class Carre {
	
	private Point basGauche, basDroit, hautGauche, hautDroit;
	
	public Carre(Point p, int cote){
		basGauche = new Point( p.getX() , p.getY() );
		basDroit = new Point( p.getX() + cote, p.getY() );
		hautGauche = new Point( p.getX() , p.getY() + cote );
		hautDroit = new Point( p.getX() + cote , p.getY() + cote );
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
		return "[CARRE "+getPointBasDroit()+" "+getPointBasGauche()+" "+getPointHautGauche()+" "+getPointHautDroit()+" ]";
	}
	
	public void affiche(){
		System.out.println(this.toString());
	}
	
}
