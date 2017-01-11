package com.dta.tp;

public class FigureUtil {
	
	private static final int SIZE_MIN = 1;
	private static final int SIZE_MAX = 20;
	
	private static final int X_MIN = 0;
	private static final int X_MAX = 50;
	
	private static final int Y_MIN = 0;
	private static final int Y_MAX = 50;

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
	
	public static Point[] getPoints(Figure... figures){
		int nbPoint = 0;
		for(Figure f : figures){
			nbPoint+= f.getPoints().length;
		}
		Point[] points = new Point[nbPoint];
		int index = 0;
		for(Figure f : figures){
			Point[] temps = f.getPoints();
			for(int i=0;i<temps.length;i++, index++){
				points[index]= temps[i];
			}
		}
		return points;
	}
	
}
