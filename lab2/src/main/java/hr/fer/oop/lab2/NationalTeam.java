package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Formation;
import hr.fer.oop.lab2.welcomepack.Constants;

public class NationalTeam extends Team{
	private String country=Constants.DEFAULT_COUNTRY;
	
	/**
	 * Constructor that sets the teams name, formation and country
	 * @param name
	 * @param formation
	 * @param country
	 * @author Fran Vlahović
	 */
	public NationalTeam(String name, Formation formation, String country) {
		super(name, formation, Constants.MAX_NO_PLAYERS_NATIONAL);
		if(country!=null)
			this.country=country;
		else System.err.println("Drzava ne smije biti null");
	}
	
	/**
	 * Constructor that sets the nationals team size to the default max size
	 * @author Fran Vlahović
	 */
	public NationalTeam(){
        super(Constants.MAX_NO_PLAYERS_NATIONAL);
    }

	/**
	 * If the team is a national team, then the player needs to have the same country as the national team
	 * @return true if player is registered, false otherwise
	 * @author Fran Vlahović
	 */
	@Override
    public boolean registerPlayer(FootballPlayer player) {
        if(player==null)
            return false;
        if(!player.getCountry().equals(country) || getRegisteredPlayers().size()>=getRegisteredPlayers().getMaxSize())
            return false;

        getRegisteredPlayers().add(player);
        return true;
    }

	/**
	 * Calculates and returns calculated team rating :
	 * 30% of a skill sum of registered players + 70% of the emotion sum of registered players
	 * @param skillRating 
	 * @param emotionRating
	 * @return skillRating + emotionRating
	 * @author Fran Vlahović
	 */
	@Override
	public double calculateRating() {
		double skillRating=getRegisteredPlayers().calculateSkillSum() * Constants.THIRTY_PERCENT;
		double emotionRating=getRegisteredPlayers().calculateEmotionSum() * Constants.SEVENTY_PERCENT;
		return skillRating + emotionRating;
	}
}