package zadaci;

import java.util.Scanner;

public class TablicaMnozenja {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Upisite n: ");
		int n=sc.nextInt();
		
		System.out.print("* |	");
		
		for(int i=0; i<n; ++i)
			System.out.print(i+1 + "	");
		
		System.out.println();
		
		for(int i=0; i<n; i++)
			System.out.print("---------");
		
		System.out.println();
		
		for(int i=1; i<=n; ++i) {
			System.out.printf("%3d |", i);
			for(int j=1; j<=n; ++j) {
				System.out.print("	" + i*j);
			}
			System.out.println();
		}
		sc.close();
	}
}