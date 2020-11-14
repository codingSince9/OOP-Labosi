package hr.fer.oop.lab1.prob3;

public class PrimeNumbers {
	
	public static void main(String[] args) {
		
		int n = Integer.parseInt(args[0]);
		int i=0, j=1;
		
		System.out.println("Your requested calculation of first " + n + " prime numbers.");
		
		while(i<n) {
			++j;							//j ide do beskonacno
			int jeliProst=1;
			
			for(int c = 1; c<=j/2; ++c) {
				if(j%c==0) {
					++jeliProst;
				}
			}
			if(jeliProst<=2) {
				System.out.println(j);
				++i;
			}
		}
	}
}
