package com.dta.tp;

import java.io.Serializable;

public class Carre extends Rectangle implements Serializable{
	
	private static final long serialVersionUID = 6423085694867492502L;

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
