package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Manager;
import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;

/**
 * Class that implemets Simple Football Player Collection and overrides all of its methods
 * @author Fran Vlahović
 */
public class SimpleFootballPlayerCollectionImpl implements SimpleFootballPlayerCollection{
	
	private FootballPlayer[] players;
	private int playersSize=0;
	
	/**
	 * Constructor that sets the size of the players
	 * @param size
	 */
	public SimpleFootballPlayerCollectionImpl(int size) {
        players=new FootballPlayer[size];
    }
	
	/**Returns a number of players in a collection
	 * @return playersSize
	 * @author Fran Vlahović
	 */
	@Override
	public int size() {
        int size = 0;
        for (FootballPlayer p1 : players) {
            if (p1 != null) {
                size++;
            }
        }
        return size;
    }
	
	/**Checks if player is inside a collection
	 * @return true if player is inside the collection, false otherwise
	 * @author Fran Vlahović
	 */
	@Override
	public boolean contains(FootballPlayer player) {
		if(player==null)
			return false;
		
		for(FootballPlayer p1 :players) {
			if(p1!=null) {
				if(player.equals(p1)) {
					return true;
				}
			}
		}
		return false;
	}

	/**Adds a specified player to a collection
	 * @return true if player is registered; false otherwise
	 * @author Fran Vlahović
	 */
	@Override
	public boolean add(FootballPlayer player) {
		if(!contains(player)) {
			for (int i = 0; i < players.length; i++) {
                if (players[i] == null) {
                    players[i] = player;
                    playersSize++;
                    return true;
                }
            }
		}
		System.out.println("Igrac vec postoji u kolekciji.");
		return false;
	}

	/**
	 * Removes all the players from a collection
	 * @author Fran Vlahović
	 */
	@Override
	public void clear() {
		for (int i = 0; i < playersSize; i++) {
			players[i]=null;
		}
		
//		for(FootballPlayer p1 : players) {
//			p1=null;
//		}
		playersSize=0;
	}

	/**
	 * Gets maximum specified size of a collection
	 * @return players.length
	 * @author Fran Vlahović
	 */
	@Override
	public int getMaxSize() {
		return players.length;
	}

	/**
	 * Adds up emotions from all players inside a collection
	 * @return emotionSum
	 * @author Fran Vlahović
	 */
	@Override
	public int calculateEmotionSum() {
		int emotionSum=0;
		for(FootballPlayer p1: players) {
			if(p1!=null)
				emotionSum+=p1.getEmotion();
		}
		return emotionSum;
	}

	/**
	 * Adds up skills from all palyers inside a collection
	 * @return skillSum
	 * @author Fran Vlahović
	 */
	@Override
	public int calculateSkillSum() {
		int skillSum=0;
		for(FootballPlayer p1: players) {
			if(p1!=null)
				skillSum+=p1.getPlayingSkill();
		}
		return skillSum;
	}

	/**
	 * @return players
	 * @author Fran Vlahović
	 */
	@Override
	public FootballPlayer[] getPlayers() {
		return players;
	}
	
	public void printPlayers() {
    	System.out.println("\n\n");
    	for(FootballPlayer p : this.players) {
    		System.out.format("%6s %6s %3d %3d %s\n", p.getName(),
    				p.getCountry(), p.getEmotion(), p.getPlayingSkill(),
    				p.getPlayingPosition());
    	}
    	System.out.println("\n\n");
    }
	
}