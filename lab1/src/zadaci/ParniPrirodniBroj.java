package zadaci;

public class ParniPrirodniBroj {
	
	public static void main(String[] args) {
		
		int n=Integer.parseInt(args[0]);
		int i=0, j=0, l=0, k=0;;
		int[] primarni = new int[100];
		
		if(n%2==0) {
			while(true) {
				++j;							//j ide do beskonacno
				int jeliProst=1;
				
				for(int c = 1; c<=j/2; ++c) {
					if(j%c==0) {
						++jeliProst;
					}
				}
				if(jeliProst<=2) {
					primarni[i]=j;
					++i;
					
				}
				
				if(primarni.length>=2) {
					for(k=0; k<primarni.length; ++k) {
						for(l=k; l<primarni.length; ++l) {
							
							if(primarni[k]+primarni[l]==n) {
								System.out.println("2 primarna broja koja sacinjavaju " + n + " su " + primarni[k] + " , " + primarni[l]);
								System.exit(0);
							}
						}
					}
				}
			}
		}
		
		else {
			System.out.println("Broj nije prirodan ili paran");
		}
	}
}