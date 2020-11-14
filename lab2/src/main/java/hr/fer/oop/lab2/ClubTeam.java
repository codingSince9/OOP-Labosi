package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;

public class ClubTeam extends Team {
	private int reputation=Constants.DEFAULT_REPUTATION;
	
	/**
	 * Constructor that sets the club teams name, formation and its reputation
	 * @param name
	 * @param formation
	 * @param reputation
	 * @author Fran Vlahović
	 */
		
	public ClubTeam(String name, Formation formation, int reputation) {
		super(name, formation, Constants.MAX_NO_PLAYERS_CLUB);
		setReputation(reputation);
	}
	
	/**
	 * Constructor that sets the club teams default max player size
	 * @author Fran Vlahović
	 */
	public ClubTeam() {
        super(Constants.MAX_NO_PLAYERS_CLUB);
	}	
	
	/**
	 * Method that sets the reputation of the team to the specified value if the said value if the value is within the boundaries
	 * @param reputation
	 * @author Fran Vlahović
	 */
	public void setReputation(int reputation) {
        if (reputation >= Constants.MIN_REPUTATION && reputation <= Constants.MAX_REPUTATION)
            this.reputation = reputation;
        else {
//        	if(reputation>Constants.MAX_REPUTATION)
//        		this.reputation=Constants.MAX_REPUTATION;
//        	else
//        		this.reputation=Constants.DEFAULT_REPUTATION;
        	this.reputation=Constants.DEFAULT_REPUTATION;
        	System.err.println("Reputacija je izvan raspona");
        }
    }
	/**
	 * Gets the reputation of a team
	 * @return reputation
	 * @author Fran Vlahović
	 */
	public int getReputation() {
		return reputation;
	}

	/**
	 * If the team is a club team, then the player needs to have his playing skill higher than the teams reputation in order to be registered
	 * @return true if player is registered, false otherwise
	 * @author Fran Vlahović
	 */
	@Override
	public boolean registerPlayer(FootballPlayer player) {
		if(player==null)
			return false;
		if(reputation>player.getPlayingSkill() || getRegisteredPlayers().size()>=getRegisteredPlayers().getMaxSize())
			return false;
		getRegisteredPlayers().add(player);
		return false;
	}
	
	/**
	 * Calculates and returns calculated team rating :
	 * 70% of a skill sum of registered players + 30% of the emotion sum of registered players
	 * @param skillRating 
	 * @param emotionRating
	 * @return skillRating + emotionRating
	 * @author Fran Vlahović
	 */
	@Override
	public double calculateRating() {
		double skillRating=getRegisteredPlayers().calculateSkillSum() * Constants.SEVENTY_PERCENT;
		double emotionRating=getRegisteredPlayers().calculateEmotionSum() * Constants.THIRTY_PERCENT;
		return skillRating + emotionRating;
	}
}