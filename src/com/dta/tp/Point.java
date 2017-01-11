package com.dta.tp;

public class Point {
	
	public static final int INIT_X = 25;
	public static final int INIT_Y = 25;
	
	private static final Point origine = new Point();
	
	private int x,y;
	
	public Point(){
		this(INIT_X, INIT_Y);
	}
	
	public Point(int abscisse, int ordonnee){
		x = abscisse;
		y = ordonnee;
	}
	
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
	
	public String toString(){
		return "["+getX()+";"+getY()+"]";
	}
	
	public boolean equals(Object o){
		if(o instanceof Point){
			Point p = (Point) o;
			return (p.getX() == this.getX())&&(p.getY() == this.getY());
		} else {
			return false;
		}
	}

	public double distanceOrigine() {
		int x2 = (origine.getX() - this.getX()) * (origine.getX() - this.getX());
		int y2 = (origine.getY() - this.getY()) * (origine.getY() - this.getY());
		return Math.sqrt( x2 + y2 );
	}
	
}
