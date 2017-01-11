package com.dta.tp;

public enum Couleur {
	Rouge('R'), Vert('V'), Bleu('B'), Jaune('J'), Noir('N');
	private char code;
	Couleur(char c){
		code = c;
	}
	public String getCode(){
		return "" + code;
	}
	public static final Couleur getCouleurDefaut(){
		return Couleur.Noir;
	}
}
