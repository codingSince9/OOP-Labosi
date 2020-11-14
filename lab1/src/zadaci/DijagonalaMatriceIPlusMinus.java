package zadaci;

import java.util.Scanner;

public class DijagonalaMatriceIPlusMinus {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Upisite broj kvadratne matrice: ");
		int n = sc.nextInt();
		int matrica[][]=new int[n][n];
		int suma=0;
		
		for(int i=0; i<n; ++i)
			for(int j=0; j<n; ++j)
				matrica[i][j]=sc.nextInt();
		
		for(int i=0; i<n; ++i)
			for(int j=0; j<n; ++j)
				if(i==j)
					suma+=matrica[i][j];
		System.out.println("Suma dijagonale matrice je: " + suma);
		
		System.out.println("Zamjena svih neparnih brojeva nulama...");
		
		for(int i=0; i<n; ++i)
			for(int j=0; j<n; ++j)
				if(matrica[i][j]%2!=0)
					matrica[i][j]=0;
		
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j)
				System.out.print(matrica[i][j] + " ");
			System.out.println();
		}
		
		sc.close();
	}
}