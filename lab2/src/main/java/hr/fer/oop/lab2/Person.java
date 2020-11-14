package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;

public abstract class Person {
	private String name = Constants.DEFAULT_PLAYER_NAME;
	private String country = Constants.DEFAULT_COUNTRY;
	private int emotion = Constants.DEFAULT_EMOTION;
	
	/**
	 * Constructor that sets persons name, country and emotion
	 * @param name
	 * @param country
	 * @param emotion
	 * @author Fran Vlahović
	 */
	public Person(String name, String country, int emotion) {
		if(name!=null)
			this.name=name;
		else System.err.println("Ime ne smije biti null");
		
		if(country!=null)
			this.country=country;
		else System.err.println("Zemlja ne smije biti null");
		
		setEmotion(emotion);
	}
	
	/**
	 * Empty constructor
	 * @author Fran Vlahović
	 */
	public Person() {
		super();
	}

	/**
	 * Gets the persons name
	 * @return name
	 * @author Fran Vlahović
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the persons country
	 * @return country
	 * @author Fran Vlahović
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Gets the persons emotion
	 * @return emotion
	 * @author Fran Vlahović
	 */
	public int getEmotion() {
		return emotion;
	}

	/**
	 * Method that sets the emotion to the specified value if the said value if the value is within the boundaries
	 * @param emotion
	 * @author Fran Vlahović
	 */
	public void setEmotion(int emotion) {
		if(emotion>=Constants.MIN_EMOTION && emotion<=Constants.MAX_EMOTION)
			this.emotion = emotion;
		else {
//			if(emotion>Constants.MAX_EMOTION)
//        		this.emotion=Constants.MAX_EMOTION;
//        	else
//        		this.emotion=Constants.MIN_EMOTION;
			this.emotion=Constants.DEFAULT_EMOTION;
			System.err.println("Emocija je izvan trazenog raspona");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}