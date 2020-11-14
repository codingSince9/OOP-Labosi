package zadaci;

public class Palindrom {
	
	static boolean isPalindrome(String provjera) {
		int duljina=provjera.length();
		for(int i=0; i<duljina/2; ++i) {
			if(provjera.charAt(i)!=provjera.charAt(duljina-i-1)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String rijec;
		
		if(args.length==0) {
			System.out.println("Niste unijeli rijec.");
			System.exit(0);
		}
		
		rijec=args[0];
		
		if(isPalindrome(rijec)) {
			System.out.println("Rijec je palindrom.");
		}
		
		else {
			System.out.println("Rijec nije palindrom.");
		}
	}
}