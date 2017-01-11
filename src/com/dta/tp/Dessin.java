package com.dta.tp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Dessin implements Serializable {
	
	private static final long serialVersionUID = -6704371684267864941L;
	
	// L'ordre est important, puisqu'une figure dessiné avant une autre sera au dessus.
	private List<Figure> figures = new ArrayList<Figure>();
	
	public Dessin(){
	}
	
	public boolean add(Figure f){
		return figures.add(f);
	}
	
	public Collection<Figure> getFigures(){
		return figures;
	}
	
}
