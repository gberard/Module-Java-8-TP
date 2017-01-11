package com.dta.tp;

public abstract class Figure {
	
	public abstract Point getCentre();
	
	public abstract Point[] getPoints();
	
	public void affiche(){
		System.out.println(this.toString());
	}
	
}
