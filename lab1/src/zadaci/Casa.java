package zadaci;

public class Casa {
	
	private int zapremninaCase;
	private int brKockiLeda;
	private int kolicinaVode;
	private int ukupnaKolicinaVode;
	
	public Casa(int maxKolicinaCase, int brKocki, int kolVode) {
		this.zapremninaCase=maxKolicinaCase;
		this.brKockiLeda=brKocki;
		this.kolicinaVode=kolVode;
	}
	
	public void dodajVodu(int brMililitara) {
		
		ispisPrije();
		System.out.println("Dodaje se: " + brMililitara + " mililitara.");
		
		if(zapremninaCase<(this.kolicinaVode+brMililitara+this.brKockiLeda*50)) {
			System.out.println("Prelijevanje!");
			brMililitara=prelijevanje(this.kolicinaVode, brMililitara, this.kolicinaVode);
			this.kolicinaVode+=brMililitara;
			ispisNakon();
		}
		else {
			this.kolicinaVode+=brMililitara;
		}
		this.ukupnaKolicinaVode=this.kolicinaVode+(this.brKockiLeda*50);
		System.out.println("Broj mililitara u casi je: " + this.kolicinaVode + " a broj kocaka: " + this.brKockiLeda + " , ukupno u casi ima: " + this.ukupnaKolicinaVode + " mililitara");
		mozeDodati();
	}
	
	public void dodajKockeLeda(int dodajKocke) {
		
		ispisPrije();
		System.out.println("Dodaje se: " + dodajKocke + " kocaka leda.");
		
		if(this.zapremninaCase<(this.kolicinaVode+(dodajKocke*50)+(this.brKockiLeda*50))) {
			System.out.println("Prelijevanje!");
			dodajKocke=prelijevanje(dodajKocke, this.kolicinaVode, this.kolicinaVode);
			this.brKockiLeda+=dodajKocke;
			ispisNakon();
		}
		else {
			this.brKockiLeda+=dodajKocke;
		}
		this.ukupnaKolicinaVode=this.kolicinaVode+(this.brKockiLeda*50);
		System.out.println("Broj mililitara u casi je: " + this.kolicinaVode + " a broj kocaka: " + this.brKockiLeda + " , ukupno u casi ima: " + this.ukupnaKolicinaVode + " mililitara");
		mozeDodati();
	}
	
	private int prelijevanje(int dodajKocke, int brMililitara, int kolicinaVode) {
		
//		prelijevanje zbog leda
		
		if(brMililitara==kolicinaVode) {
			while(true) {
				if(zapremninaCase<(kolicinaVode+dodajKocke*50+this.brKockiLeda*50))
					--dodajKocke;
				else
					break;
			}
			System.out.println("Novi broj Kocaka koji ce se dodati je: " + dodajKocke);
			return dodajKocke;
		}
		
//		prelijevanje zbog vode
		
		if(dodajKocke==kolicinaVode) {
			while(true) {
				if(zapremninaCase<(kolicinaVode+brMililitara+this.brKockiLeda*50)) 
					--brMililitara;
				else
					break;
			}
			System.out.println("Novi broj Mililitara koji ce se dodati je: " + brMililitara);
		}
		return brMililitara;
	}
	
	private void ispisPrije() {
		System.out.println("Stanje case prije dodavanja: " + this.brKockiLeda + " kocki leda + " + this.kolicinaVode + " mililitara.");
	}
	
	private void ispisNakon() {
		System.out.println("Stanje case nakon dodavanja: " + this.brKockiLeda + " kocki leda + " + this.kolicinaVode + " mililitara.");
	}
	
	private void mozeDodati() {
		System.out.println("Moze se jos dodati " + (this.zapremninaCase-this.ukupnaKolicinaVode)/50 + " kocaka leda, ili " + (this.zapremninaCase-this.ukupnaKolicinaVode) + " mililitara.");
	}
	
	public static void main(String[] args) {
		Casa karo = new Casa(1000, 2, 300);
		karo.dodajKockeLeda(11);
		karo.dodajVodu(57);
	}
}