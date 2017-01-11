package com.dta.test;

class TpJava02 {
	public static void main(String args[]){
		System.out.println("Avec 1234");
		int entier = 1234;
		float decimal = entier;
		System.out.println(entier);
		System.out.println(decimal);
		
		System.out.println("Avec 123456789");
		entier = 123456789;
		decimal = entier;
		System.out.println(entier);
		System.out.println(decimal);
		
		System.out.println("Valeurs spéciales");
		float x = 15;
		float z = 0;
		float y = -123;
		float a = x/z; // division par zéro !!
		float b = y/z; // division par zéro négative !!
		float c = a/b; // utilisation de valeur résultat de division par zéro !!
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
	}
}
