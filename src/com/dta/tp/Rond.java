package com.dta.tp;

public class Rond {
	
	private Point centre;
	private int rayon;
	
	public Rond(Point centre, int rayon){
		this.centre = centre;
		this.rayon = rayon;
	}
	
	public String toString(){
		return "[ROND "+centre+" "+rayon+"]";
	}
	
	public void affiche(){
		System.out.println(this.toString());
	}
	
}
