package com.dta.tp;

public class Carre extends Rectangle{
	
	public Carre(Point p, int cote){
		super(p, cote, cote);
	}
	
	public Carre(Couleur c, Point p, int cote){
		super(c, p, cote, cote);
	}
	
	protected String getType(){
		return "CARRE";
	}
	
}
