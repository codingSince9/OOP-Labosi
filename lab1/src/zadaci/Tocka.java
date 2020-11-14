package zadaci;

public class Tocka {
	private double x, y;
	
	public Tocka(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public boolean vecaUdaljenost(Tocka t) {
		boolean istina=false;
		istina=Math.sqrt((t.x*t.x) + (t.y*t.y)) > Math.sqrt((this.x*this.x) + (this.y*this.y));
		return istina;
	}
}
