package com.dta.test;

import com.dta.tp.Carre;
import com.dta.tp.Figure;
import com.dta.tp.FigureUtil;
import com.dta.tp.Point;
import com.dta.tp.Rectangle;
import com.dta.tp.Rond;
import com.dta.tp.Segment;
import com.dta.tp.Surfacable;

public class TpJava {
	public static void main(String args[]){
		
		Point p1 = new Point(5,2);
		System.out.println(p1);
		System.out.println(p1.getX());
		System.out.println(p1.getY());
		
		Rond rd1 = new Rond(p1, 4);
		rd1.affiche();
		
		Rectangle rt1 = new Rectangle( new Point(10,3) , 2, 6);
		rt1.affiche();
		
		Point p0 = new Point();
		System.out.println(p0);
		
		Rond rd2 = FigureUtil.getRandomRond();
		System.out.println(rd2);
		
		Rond rd3 = FigureUtil.getRandomRond();
		System.out.println(rd3);
		
		Rectangle rt2 = FigureUtil.getRandomRectangle();
		System.out.println(rt2);
		
		Rectangle rt3 = FigureUtil.getRandomRectangle();
		System.out.println(rt3);
		
		Point p2 = new Point(6,1);
		Point p3 = new Point(5,1);
		Point p4 = new Point(6,2);
		Point p5 = new Point(6,1);
		System.out.println( p2.Equals(p3) ); // false
		System.out.println( p3.Equals(p4) ); // false
		System.out.println( p4.Equals(p5) ); // false
		System.out.println( p5.Equals(p2) ); // true
		
		Carre c1 = new Carre(p3, 5);
		System.out.println(c1);
		
		Figure f1 = FigureUtil.getRandomFigure();
		f1.affiche();
		
		Figure f2 = FigureUtil.getRandomFigure();
		f2.affiche();
		
		Figure f3 = FigureUtil.getRandomFigure();
		f3.affiche();
		
		Segment s1 = new Segment( new Point(20, 20), 5 , true );
		s1.affiche();
		Segment s2 = new Segment( new Point(20, 20), 5 , false );
		s2.affiche();
		
		System.out.println(rd1.surface());
		System.out.println(rt1.surface());
		System.out.println(c1.surface());
		
		Surfacable sr1 = FigureUtil.getRandomSurfacable();
		System.out.println(sr1 + " -> " + sr1.surface());
		
		Surfacable sr2 = FigureUtil.getRandomSurfacable();
		System.out.println(sr2 + " -> " + sr2.surface());
		
		Surfacable sr3 = FigureUtil.getRandomSurfacable();
		System.out.println(sr3 + " -> " + sr3.surface());
		
		Point points[] = FigureUtil.getPoints(rd1, rd2, rd3, rt1, rt2, rt3, c1, f1, f2, f3, s1, s2);
		System.out.print("Points : ");
		for(Point p : points){
			System.out.print(p);
			System.out.print(" ");
		}
		System.out.print("\n");
	}
}
