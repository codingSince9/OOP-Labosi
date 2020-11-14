package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Formation;
import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.ManageableTeam;
import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;

public abstract class Team implements ManageableTeam{
	private String name=Constants.DEFAULT_TEAM_NAME;
	private Formation formation=Constants.DEFAULT_FORMATION;
	private SimpleFootballPlayerCollectionImpl registeredPlayers;
	private SimpleFootballPlayerCollection startingEleven = new SimpleFootballPlayerCollectionImpl(Constants.STARTING_ELEVEN_SIZE);
	
	/**
	 * Constructor that sets the teams name, formation and the number of registered players
	 * @param name
	 * @param formation
	 * @param registeredPlayersSize
	 * @author Fran Vlahović
	 */
	public Team(String name, Formation formation, int registeredPlayersSize) {
		this.registeredPlayers = new SimpleFootballPlayerCollectionImpl(registeredPlayersSize);
		
		if(name!=null)
			this.name=name;
		else System.err.println("Ime ne smije biti null");
		
		setFormation(formation);
	}
	
	/**
	 * Constructor that sets the teams number of registered players
	 * @param registeredPlayersSize
	 * @author Fran Vlahović
	 */
	public Team(int registeredPlayersSize){
        this.registeredPlayers = new SimpleFootballPlayerCollectionImpl(registeredPlayersSize);
    }
	
	/**
	 * Adds the player to the starting eleven if the player is a part of the registered players, 
	 * if he already isn't a part of the starting eleven and if there is
	 * enough space left for the player to be registered
	 * @return true if the player is registered, false otherwise
	 * @author Fran Vlahović
	 */
	@Override
	public boolean addPlayerToStartingEleven(FootballPlayer player) {
		if(this.registeredPlayers.contains(player) && !this.startingEleven.contains(player) && this.startingEleven.size()<Constants.STARTING_ELEVEN_SIZE) {
			this.startingEleven.add(player);
			return true;
	}
		return false;
	}
	
	/**
	 * Checks if the player is registered by going into another method
	 * @return true if player is inside the collection, false otherwise
	 * @author Fran Vlahović
	 */
	@Override
	public boolean isPlayerRegistered(FootballPlayer player) {
		return this.registeredPlayers.contains(player);		
	}
	
	/**
	 * Gets registered players
	 * @return registeredPlayers
	 * @author Fran Vlahović
	 */
	@Override
	public SimpleFootballPlayerCollection getRegisteredPlayers() {
		return this.registeredPlayers;
	}
	
	/**
	 * Gets starting eleven
	 * @return startingEleven
	 * @author Fran Vlahović
	 */
	@Override
	public SimpleFootballPlayerCollection getStartingEleven() {
		return this.startingEleven;
	}
	
	/**
	 * Sets the formation if the formation is not null
	 * @author Fran Vlahović
	 */
	@Override
	public void setFormation(Formation formation) {
		if(formation!=null)
			this.formation=formation;
		else System.err.println("Formacija ne smije biti null");
		
	}
	
	/**
	 * Gets the formation of a team
	 * @return formation
	 * @author Fran Vlahović
	 */
	@Override
	public Formation getFormation() {
		return this.formation;
	}
	
	/**
	 * Clears starting eleven
	 * @author Fran Vlahović
	 */
	@Override
	public void clearStartingEleven() {
		this.startingEleven.clear();		
	}	
}