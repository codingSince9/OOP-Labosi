package hr.fer.oop.lab1.labos;

import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
	
	public static void main(String[] args) {
		
		Random rand=new Random();
		Scanner sc=new Scanner(System.in);
		int dg=Integer.parseInt(args[0]);
		int gg=Integer.parseInt(args[1]);
		String kraj;
		char odgovor;
		
		while(true){
			
			if(dg>gg) {
				System.out.println("Krivi unos ili varate.");
				System.exit(0);
			}
			
			int razlika=gg-dg+1;
			int random=rand.nextInt(razlika);
			int broj=dg+random;
			
			System.out.println("Da li je vas broj: " + broj);
			System.out.println("Odgovor: ");
			kraj=sc.nextLine().trim();
			odgovor=kraj.charAt(0);
			
			if(odgovor=='v') {
				dg=broj+1;
			}
			
			else if(odgovor=='m') {
				gg=broj-1;
			}
			
			
			
			else if(odgovor=='!') {
				System.out.println("Pogodio sam, vas broj je: " + broj);
				break;
			}
			
			else {
				System.out.println("Unijeli ste krivi znak, pokusajte ponovo.");
				System.exit(0);
			}
		}
		sc.close();
		GuessTheNumber hello1=new GuessTheNumber();
		}
	
	public void hello() {
		
	}
}

