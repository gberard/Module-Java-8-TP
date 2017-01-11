package com.dta.test;

class TpJava06 {
	public static void main(String args[]){
		int nb = Integer.parseInt(args[0]);
		int fact = 1;
		for(int i=0;i<nb;i++){
			fact = fact * (i+1);
		}
		System.out.println(fact);
	}
}
