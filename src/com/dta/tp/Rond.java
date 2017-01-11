package com.dta.tp;

public class Rond extends Figure {
	
	private Point centre;
	private int rayon;
	
	public Rond(Point centre, int rayon){
		this.centre = centre;
		this.rayon = rayon;
	}
	
	public String toString(){
		return "[ROND "+centre+" "+rayon+"]";
	}
	
	@Override
	public Point getCentre() {
		return centre;
	}
	
}
