package com.dta.tp;

public class Segment extends Figure {
	
	private Point debut, fin;
	
	public Segment(Point p, int longeur, boolean horizontal){
		debut = new Point(p.getX(), p.getY());
		fin = new Point(p.getX() + (horizontal?longeur:0), p.getY() + (horizontal?0:longeur));
	}
	
	public Point getDebut(){
		return debut;
	}
	
	public Point getFin(){
		return fin;
	}
	
	public String toString(){
		return "[SEG "+getDebut()+" "+getFin()+" ]";
	}
	
	@Override
	public Point getCentre() {
		int x = (getDebut().getX() + getFin().getX()) / 2;
		int y = (getDebut().getY() + getFin().getY()) / 2;
		return new Point(x, y);
	}

	@Override
	public Point[] getPoints() {
		return new Point[]{debut, fin};
	}
	
}
