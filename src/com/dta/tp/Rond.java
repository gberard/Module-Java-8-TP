package com.dta.tp;

public class Rond extends Figure implements Surfacable {
	
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

	@Override
	public double surface() {
		return this.rayon * this.rayon * Math.PI;
	}

	@Override
	public Point[] getPoints() {
		return new Point[]{centre};
	}
	
}
