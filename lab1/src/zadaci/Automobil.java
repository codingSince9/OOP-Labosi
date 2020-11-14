package zadaci;

public class Automobil {
	
	private double maxKapacitet;
	private double brojLitara;
	private double prijedeniKilometri;
	private double potrosnjaGoriva;
	
	public Automobil(double rezervoar, double prijedeno, double kolicinaGoriva, double potrosnja) {
		this.maxKapacitet=rezervoar;
		this.brojLitara=kolicinaGoriva;
		this.prijedeniKilometri=prijedeno;
		this.potrosnjaGoriva=potrosnja;
	}
	
	public void Vozi(double km) {
		double moguciKm=this.brojLitara/(this.potrosnjaGoriva/100.);
		
		if(moguciKm>km) {
			this.prijedeniKilometri+=km;
			this.brojLitara-=(this.potrosnjaGoriva/100.)*km;
			System.out.println("Auto je presao: " + Math.round(km) + " kilometara.");
		}
		
		else {
			this.prijedeniKilometri+=moguciKm;
			this.brojLitara=0;
			System.out.println("Auto je presao: " + Math.round(moguciKm) + " kilometara.");
		}
	}
	
	public void Natoci(double litra) {
		if(brojLitara+litra>maxKapacitet) {
			this.brojLitara=this.maxKapacitet;
			System.out.println("Unijeli ste previse litara pa je natoceno do vrha spremnika. Broj litara u spremniku je: " + this.brojLitara);
		}
		else {
			brojLitara+=litra;
			System.out.println("Natoceno je " + litra + " litara. Sada u spremniku ima " + this.brojLitara + " litara.");
		}
	}
	
	public void Status() {
		System.out.println("Auto je ukupno presao: " + this.prijedeniKilometri + " kilometara.");
		System.out.println("Postotak goriva u spremniku je: " + (this.brojLitara/this.maxKapacitet)*100 + "%");
		System.out.println("Auto moze prijeci jos: " + Math.round((this.brojLitara/(this.potrosnjaGoriva/100.))) + " kilometara.");
	}
	
	public static void main(String[] args) {
		Automobil golfDvica= new Automobil(50, 400, 15, 7);
		golfDvica.Vozi(150);
		golfDvica.Natoci(10);
		golfDvica.Status();
        golfDvica.Vozi(206);
        golfDvica.Natoci(100);
        golfDvica.Status();
	}
}