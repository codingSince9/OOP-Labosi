package zadaci;

import java.util.Random;
import java.util.Scanner;

public class KamenSkarePapir {

	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("Niste unijeli broj pobjeda.");
			System.exit(0);
		}

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(args[0]);
		String[] kompjuter = {"kamen", "skare", "papir"};
		String korisnik;
		int brPobjedaKomp = 0, brPobjedaKorisnika = 0;

		while (brPobjedaKomp < n && brPobjedaKorisnika < n) {
			
			System.out.println("Upisite znak: ");
			korisnik = sc.nextLine();
			int randomBroj = new Random().nextInt(kompjuter.length);
			String komp=(kompjuter[randomBroj]);
			System.out.println("Odabrali ste: " + korisnik + " a CPU je odabrao: " + komp);

			if ((korisnik.equals("kamen") && komp.equals("skare")) || (korisnik.equals("skare") && komp.equals("papir"))
					|| (korisnik.equals("papir") && komp.equals("kamen"))) {
				++brPobjedaKorisnika;
				System.out.println("Pobijedio je korisnik, rezultat je: " + brPobjedaKomp + " , " + brPobjedaKorisnika);
			}
				

			else if ((komp.equals("kamen") && korisnik.equals("skare")) || (komp.equals("skare") && korisnik.equals("papir"))
					|| (komp.equals("papir") && korisnik.equals("kamen"))) {
				++brPobjedaKomp;
				System.out.println("Pobijedio je korisnik, rezultat je: " + brPobjedaKomp + " , " + brPobjedaKorisnika);
			}
			
			else {
				System.out.println("CPU je odabrao: " + komp + " a vi ste odabrali: " + (korisnik.equals("kamen")||korisnik.equals("skare")||korisnik.equals("papir")?korisnik:"krivi znak, pokusajte ponovo."));
			}
		}

		if (brPobjedaKomp == n)
			System.out.println("Kompjuter je pobijedio.");

		else
			System.out.println("Korisnik je pobijedio.");

		sc.close();
	}
}