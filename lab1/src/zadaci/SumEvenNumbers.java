package zadaci;

public class SumEvenNumbers {
	
	public static void main(String[] args) {
		
		int prvi=Integer.parseInt(args[0]);
		int drugi=Integer.parseInt(args[1]);
		int broj=0;
		int suma=0;
		
		for(int i=0; i<4; ++i) {
			broj=prvi%10;
			
			if(broj%2==0) {
				suma+=broj;
			}
			
			prvi/=10;
		}
		
		for(int i=0; i<4; ++i) {
			broj=drugi%10;
			
			if(broj%2==0) {
				suma+=broj;
			}
			
			drugi/=10;
		}
		
		System.out.println("Input: " + args[0] + " " + args[1] + " Output: " + suma);
		
	}
}