package hr.fer.oop.lab1.prob4;

public class PrimeFactorization {
	
	public static void main(String[] args) {
		
		int n = Integer.parseInt(args[0]);
		int i=0, j=0, primeSum=1;
		
		for(i=2; i<=n; ++i) {
			if(n%i==0) {
				n/=i;
				System.out.println(j+1 + ". " + i);
				while(n%i==0) {
					n/=i;
					++j;
					System.out.println(j+1 + ". " + i);
				}
				++j;
				primeSum*=i;
				if(primeSum==n) {
					System.out.println(j+1 + ". " + i);
					break;
				}
			}
		}
		
	}
}