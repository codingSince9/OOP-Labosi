package hr.fer.oop.lab4.second;

public class Artikl implements Comparable<Artikl> {

	private final String naziv;
	private final Double cijena;

	public Artikl(String naziv, Double cijena) {
		this.naziv = naziv;
		this.cijena = cijena;
	}

	public String getNaziv() {
		return naziv;
	}

	public Double getCijena() {
		return cijena;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cijena == null) ? 0 : cijena.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artikl other = (Artikl) obj;
		if (cijena == null) {
			if (other.cijena != null)
				return false;
		} else if (!cijena.equals(other.cijena))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artikl [naziv=" + naziv + ", cijena=" + cijena + "]";
	}

	public int compareTo(Artikl other) {
		return getNaziv().compareToIgnoreCase(other.getNaziv());
	}
}
