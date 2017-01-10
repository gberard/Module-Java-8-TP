
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
	}
}
