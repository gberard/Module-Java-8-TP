package com.dta.tp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class FigureUtil {
	
	private static final int SIZE_MIN = 1;
	private static final int SIZE_MAX = 20;
	
	private static final int X_MIN = 0;
	private static final int X_MAX = 99;
	
	private static final int Y_MIN = 0;
	private static final int Y_MAX = 99;

	// Création d'un constructeur private afin d'interdire l'instanciation de cette classe.
	private FigureUtil(){}
	
	private static int getRandomInteger(int min, int max){
		return (int) Math.round(Math.random() * (max - min)) + min;
	}
	
	private static Point getRandomPoint(int x_min, int x_max, int y_min, int y_max){
		int x = getRandomInteger(x_min, x_max);
		int y = getRandomInteger(y_min, y_max);
		return new Point(x,y);
	}
	
	public static Rond getRandomRond(){
		int rayon = getRandomInteger(SIZE_MIN / 2, SIZE_MAX / 2);
		Point centre = getRandomPoint(X_MIN, X_MAX, Y_MIN, Y_MAX);
		return new Rond(centre, rayon);
	}
	
	public static Rectangle getRandomRectangle(){
		int largeur = getRandomInteger(SIZE_MIN, SIZE_MAX);
		int hauteur = getRandomInteger(SIZE_MIN, SIZE_MAX);
		Point basGauche = getRandomPoint(X_MIN, X_MAX, Y_MIN, Y_MAX);
		return new Rectangle(basGauche, largeur, hauteur);
	}
	
	public static Carre getRandomCarre(){
		int cote = getRandomInteger(SIZE_MIN, SIZE_MAX);
		Point basGauche = getRandomPoint(X_MIN, X_MAX, Y_MIN, Y_MAX);
		return new Carre(basGauche, cote);
	}
	
	public static Segment getRandomSegment(){
		Point debut = getRandomPoint(X_MIN, X_MAX, Y_MIN, Y_MAX);
		int longeur = getRandomInteger(SIZE_MIN, SIZE_MAX);
		boolean horizontal = getRandomInteger(0, 1) > 0.5;
		return new Segment(debut, longeur, horizontal);
	}
	
	public static Figure getRandomFigure(){
		int choix = getRandomInteger(0, 3);
		switch(choix){
		case 0 : 
			return getRandomRond();
		case 1 : 
			return getRandomCarre();
		case 2 : 
			return getRandomSegment();
		default : 
			return getRandomRectangle();
		}
		
	}
	
	public static Surfacable getRandomSurfacable(){
		int choix = getRandomInteger(0, 2);
		switch(choix){
		case 0 : 
			return getRandomRond();
		case 1 : 
			return getRandomCarre();
		default : 
			return getRandomRectangle();
		}
		
	}
	
	public static Collection<Point> getPoints(Figure... figures){
		// Il peut y avoir des doublons
		Collection<Point> points = new ArrayList<Point>();
		for(Figure f : figures){
			points.addAll(f.getPoints());
		}
		return points;
	}
	
	public static Collection<Figure> genere(int nb){
		Collection<Figure> collection = new ArrayList<Figure>();
		for(int i=0;i<nb;i++){
			collection.add(getRandomFigure());
		}
		return collection;
	}
	
	public static Figure getFigureEn(Point p, Dessin d){
		Iterator<Figure> iterator = d.getFigures().iterator();
		while(iterator.hasNext()){
			Figure f = iterator.next();
			if(f.couvre(p)){
				return f;
			}
		}
		return null;
	}
	
}
