package com.dta.tp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FigureUtil {
	
	private static final int SIZE_MIN = 1;
	private static final int SIZE_MAX = 20;
	
	private static final int X_MIN = 0;
	private static final int X_MAX = 99;
	
	private static final int Y_MIN = 0;
	private static final int Y_MAX = 99;
	
	private static final Map<String, Figure> ids = new HashMap<String, Figure>();

	// Création d'un constructeur private afin d'interdire l'instanciation de cette classe.
	private FigureUtil(){}
	
	private static Couleur getRandomCouleur(){
		Couleur values[] = Couleur.values();
		int index = getRandomInteger(0, values.length-1);
		return values[index];
	}
	
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
		Couleur couleur = getRandomCouleur();
		Rond rond = new Rond(couleur, centre, rayon);
		ids.put(rond.getId(), rond);
		return rond;
	}
	
	public static Rectangle getRandomRectangle(){
		int largeur = getRandomInteger(SIZE_MIN, SIZE_MAX);
		int hauteur = getRandomInteger(SIZE_MIN, SIZE_MAX);
		Point basGauche = getRandomPoint(X_MIN, X_MAX, Y_MIN, Y_MAX);
		Couleur couleur = getRandomCouleur();
		Rectangle rectangle = new Rectangle(couleur, basGauche, largeur, hauteur);
		ids.put(rectangle.getId(), rectangle);
		return rectangle;
	}
	
	public static Carre getRandomCarre(){
		int cote = getRandomInteger(SIZE_MIN, SIZE_MAX);
		Point basGauche = getRandomPoint(X_MIN, X_MAX, Y_MIN, Y_MAX);
		Couleur couleur = getRandomCouleur();
		Carre carre = new Carre(couleur, basGauche, cote);
		ids.put(carre.getId(), carre);
		return carre;
	}
	
	public static Segment getRandomSegment(){
		Point debut = getRandomPoint(X_MIN, X_MAX, Y_MIN, Y_MAX);
		int longueur = getRandomInteger(SIZE_MIN, SIZE_MAX);
		boolean horizontal = getRandomInteger(0, 1) > 0.5;
		Couleur couleur = getRandomCouleur();
		Segment segment = new Segment(couleur, debut, longueur, horizontal);
		ids.put(segment.getId(), segment);
		return segment;
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
	
	public static Optional<Figure> getFigureEn(Point p, Dessin d){
		return d.getFigures().stream()
			.filter(f -> f.couvre(p))
			.findFirst();
	}
	
	public static List<Object> trieProcheOrigine(Dessin dessin){
		return dessin.getFigures().stream()
				.sorted()
				.collect(Collectors.toList());
	}
	
	public static List<Surfacable> trieDominant(Dessin dessin){
		return dessin.getFigures().stream()
				.filter(f -> f instanceof Surfacable)
				.map(x -> (Surfacable) x)
				.sorted( (f1,f2) -> f1.surface() > f2.surface() ? -1 : 1)
				.collect(Collectors.toList());
	}
	
	public static Optional<Figure> get(String id){
		if(ids.containsKey(id)){
			return Optional.of(ids.get(id));
		} else {
			return Optional.empty();
		}
	}
	
	public static void imprime(Dessin d) throws IOException {
		File file = File.createTempFile("monDessin", ".dessin");
		PrintWriter sortie = new PrintWriter(new FileOutputStream(file));
		d.getFigures().stream()
						.forEach(f -> sortie.println(f));
		for(int x=X_MIN;x<X_MAX;x++){
			sortie.print("=");
		}
		sortie.println();
		for(int y=Y_MIN;y<Y_MAX;y++){
			for(int x=X_MIN;x<X_MAX;x++){
				Optional<Figure> figure = getFigureEn(new Point(x,y),d);
				if(figure.isPresent()){
					sortie.print(figure.get().getCouleur().getCode());
				} else {
					sortie.print(" ");
				}
			}
			sortie.println();
		}
		System.out.println("Impression sous " + file.getAbsolutePath());
		sortie.close();
	}
	
	public static void sauvegarde(Dessin d) throws IOException {
		File file = File.createTempFile("monDessin", ".save");
		ObjectOutputStream sortie = new ObjectOutputStream(new FileOutputStream(file));
		sortie.writeObject(d);
		System.out.println("Sauvegarde sous " + file.getAbsolutePath());
		sortie.close();
	}
	
	public static Dessin charge(String filename) throws IOException, ClassNotFoundException {
		Dessin dessin;
		try {
			ObjectInputStream sortie = new ObjectInputStream(new FileInputStream(filename));
			dessin = (Dessin) sortie.readObject();
			sortie.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé : " + e.getMessage());
			dessin = new Dessin();
		}
		return dessin;
	}
	
}
