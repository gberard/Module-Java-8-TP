
public class Point {
	
	public static final int INIT_X = 25;
	public static final int INIT_Y = 25;
	
	private int x,y;
	
	public Point(){
		this(INIT_X, INIT_Y);
	}
	
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
