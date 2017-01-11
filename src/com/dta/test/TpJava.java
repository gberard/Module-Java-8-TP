package com.dta.test;

import com.dta.tp.FigureUtil;
import com.dta.tp.Point;
import com.dta.tp.Rectangle;
import com.dta.tp.Rond;

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
		
	}
}
