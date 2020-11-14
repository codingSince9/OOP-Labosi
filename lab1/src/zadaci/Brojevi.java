package zadaci;

import java.util.Scanner;
import java.util.Random;

public class Brojevi {
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		Scanner sc=new Scanner(System.in);
		int dg=Integer.parseInt(args[0]);
		int gg=Integer.parseInt(args[1]);
		String kraj;
		char odgovor;
		
		while(true) {
			if(dg>gg) {
				System.out.println("Varanje!");
				System.exit(0);
			}
			
			int razlika=gg-dg+1;
			int random=rand.nextInt(razlika);
			int broj=dg+random;
			
			System.out.println("Jeli vas broj: " + broj + " ?");
			System.out.println("Vas odgovor: v(veci), m(manji), !(pogodak)");
			kraj=sc.nextLine().trim();
			odgovor=kraj.charAt(0);
			
			do {
				
				if(odgovor=='v') {
					dg=broj-1;
					break;
				}
				
				else if(odgovor=='m') {
					gg=broj-1;
					break;
				}
				
				else if(odgovor=='!') {
					System.out.println("Pogodio sam, vas broj je: " + broj);
					System.exit(0);
				}
				
				else {
					System.out.println("Krivi unos pokusajte ponovo.");
					kraj=sc.nextLine().trim();
					odgovor=kraj.charAt(0);
				}
				
			}while(odgovor!='!' || odgovor!='v' || odgovor!='m');
			
		}
		
//		sc.close();
		
	}
}