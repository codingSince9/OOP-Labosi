package zadaci;

public class UdaljenostTocaka {
	
	public static void main(String[] args) {
		Tocka t1=new Tocka(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
		Tocka t2=new Tocka(Double.parseDouble(args[2]), Double.parseDouble(args[3]));
		
		System.out.println(t1.vecaUdaljenost(t2));
	}
}