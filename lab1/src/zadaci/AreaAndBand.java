package zadaci;

import java.util.Scanner;

public class AreaAndBand{
	
	public static double distance(Point jedan, Point dva) {
		double distance=Math.sqrt((jedan.x-dva.x)*(jedan.x-dva.x)+(jedan.y-dva.y)*(jedan.y-dva.y));
		return distance;
	}
	
	public static void area(Point jedan, Point dva, Point tri) {
		double povrsina=distance(jedan, dva)*distance(dva, tri);
		System.out.println("Povrsina pravokutnika je: " + povrsina);
	}
	
	public static void band(Point jedan, Point dva, Point tri) {
		double opseg=2*(distance(jedan, dva) + distance(dva, tri));
		System.out.println("Opseg je: " + opseg);
	}
	
	public static void mirrorY(Point jedan, Point dva) {
		jedan.x=-jedan.x;
		dva.x=-dva.x;
		System.out.println("Koordinate tocaka nakon zrcaljenja su: (" + jedan.x + ", " + jedan.y + ")" + " (" + dva.x + ", " + dva.y + ")");
	}
	
	public static boolean checkIfRectangle(Point jedan, Point dva, Point tri, Point cetri) {
		double dijag1=distance(jedan, tri);
		double dijag2=distance(dva, cetri);
		if(dijag1==dijag2)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Upisite x, y za prvu tocku.");
		int x=sc.nextInt();
		int y=sc.nextInt();
		Point prvi=new Point(x, y);
		
		System.out.println("Upisite x, y za drugu tocku.");
		x=sc.nextInt();
		y=sc.nextInt();
		Point drugi=new Point(x, y);
		
		System.out.println("Upisite x, y za trecu tocku.");
		x=sc.nextInt();
		y=sc.nextInt();
		Point treci=new Point(x, y);
		
		System.out.println("Upisite x, y za cetvrtu tocku.");
		x=sc.nextInt();
		y=sc.nextInt();
		Point cetvrti=new Point(x, y);
		
		area(prvi, drugi, treci);
		band(prvi, drugi, treci);
		mirrorY(prvi, drugi);
		if(checkIfRectangle(prvi, drugi, treci, cetvrti))
			System.out.println("Oblik je pravokutnik.");
		else
			System.out.println("Oblik nije pravokutnik.");
		
		sc.close();
	}
}