package hr.fer.oopj.lab4.data;

public class ProsjecnaVrijednost implements Obrada<String,Integer>{
	private int brojac;
	private double suma;
	
	@Override
	public boolean obradi(String key, Integer value) {
		if (key==null || value==null) 
			return false;
		++brojac;
		suma+=value;
		return true;
		
	}
	public double prosjek() {
		double vrijednostProsjeka=suma/brojac;
		return vrijednostProsjeka;
	}

}