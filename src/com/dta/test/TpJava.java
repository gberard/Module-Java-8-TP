package com.dta.test;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import com.dta.tp.Carre;
import com.dta.tp.Dessin;
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
		System.out.println( p2.equals(p3) ); // false
		System.out.println( p3.equals(p4) ); // false
		System.out.println( p4.equals(p5) ); // false
		System.out.println( p5.equals(p2) ); // true
		
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
		
		Collection<Point> points = FigureUtil.getPoints(rd1, rd2, rd3, rt1, rt2, rt3, c1, f1, f2, f3, s1, s2);
		System.out.println("Points : " + points);
		
		Collection<Figure> figures = FigureUtil.genere(50);
		System.out.println(figures);
		
		Dessin dessin = new Dessin();
		for(Figure f : figures){
			dessin.add(f);
		}
		
		Optional<Figure> couverte = FigureUtil.getFigureEn(new Point(), dessin);
		if(!couverte.isPresent()){
			System.out.println("Rien");
		} else {
			couverte.get().affiche();
		}
		
		System.out.println(rt1.equals(rt1)); // true
		System.out.println(rt1.equals(rt2)); // false
		System.out.println(rt1.equals(new Rectangle(new Point(10,3), 2, 6))); // true
		
		System.out.println(FigureUtil.trieProcheOrigine(dessin));
		System.out.println(FigureUtil.trieDominant(dessin));
		
		Optional<Figure> f4 = FigureUtil.get("ROND10");
		System.out.println(f4);
		Optional<Figure> f5 = FigureUtil.get("CARRE10");
		System.out.println(f5);
		Optional<Figure> f6 = FigureUtil.get("RECT10");
		System.out.println(f6);
		Optional<Figure> f7 = FigureUtil.get("SEG10");
		System.out.println(f7);
		
		Dessin d2 = new Dessin();
		FigureUtil.genere(10).stream()
								.forEach(f -> d2.add(f));
		try {
			FigureUtil.imprime(d2);
			FigureUtil.sauvegarde(d2);
			System.out.println(FigureUtil.charge("/tmp/monDessin7499603493539879543.save").getFigures());
		} catch(IOException e){
			System.out.println("Erreur (1) durant le traitement : "+e.getMessage());
		} catch(ClassNotFoundException e){
			System.out.println("Erreur (2) durant le traitement : "+e.getMessage());
		}
	}
}
