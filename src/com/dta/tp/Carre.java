package com.dta.tp;

public class Carre extends Rectangle{
	
	public Carre(Point p, int cote){
		super(p, cote, cote);
	}
	
	public String toString(){
		return "[CARRE "+getPointBasDroit()+" "+getPointBasGauche()+" "+getPointHautGauche()+" "+getPointHautDroit()+" ]";
	}
	
}
