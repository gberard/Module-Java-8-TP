
public class Point {
	private int x,y;
	
	public Point(int abscisse, int ordonnee){
		x = abscisse;
		y = ordonnee;
	}
	
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
	
	public String toString(){
		return "["+getX()+";"+getY()+"]";
	}

}
