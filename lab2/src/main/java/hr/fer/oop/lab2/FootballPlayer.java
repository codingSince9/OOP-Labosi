package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.PlayingPosition;

public class FootballPlayer extends Person {
	private int playingSkill=Constants.DEFAULT_PLAYING_SKILL;
	private PlayingPosition playingPosition=Constants.DEFAULT_PLAYING_POSITION;
	
	/**
	 * Constructor that sets the players name, country, emotion, playing skill and its playing position
	 * @param name
	 * @param country
	 * @param emotion
	 * @param playingSkill
	 * @param playingPosition
	 * @author Fran Vlahović
	 */
	public FootballPlayer(String name, String country, int emotion, int playingSkill, PlayingPosition playingPosition){
		super(name, country, emotion);
		setPlayingSkill(playingSkill);
		setPlayingPosition(playingPosition);
	}
	
	/**
	 * Constructor that sets the players default name, country, emotion, and his default playing skill
	 * @author Fran Vlahović
	 */
	public FootballPlayer(){
		super(Constants.DEFAULT_PLAYER_NAME, Constants.DEFAULT_COUNTRY, Constants.DEFAULT_EMOTION);
        this.playingSkill=Constants.DEFAULT_PLAYING_SKILL;
        this.playingPosition=Constants.DEFAULT_PLAYING_POSITION;
        
    }
	
	/**
	 * Method that sets the playing skill to the specified value if the said value if the value is within the boundaries
	 * @param playingSkill
	 * @author Fran Vlahović
	 */
	public void setPlayingSkill(int playingSkill) {
        if (playingSkill >= Constants.MIN_PLAYING_SKILL && playingSkill <= Constants.MAX_PLAYING_SKILL)
            this.playingSkill = playingSkill;
        else {
//        	if(playingSkill>Constants.MAX_PLAYING_SKILL)
//        		this.playingSkill=Constants.MAX_PLAYING_SKILL;
//        	else
//        		this.playingSkill=Constants.MIN_PLAYING_SKILL;
        	this.playingSkill=Constants.DEFAULT_PLAYING_SKILL;
        	System.err.println("Igraceva vjestina je izvan raspona");
        }
    }

	/**
	 * Method that sets the playing position to the specified value if the said value if the value is within the boundaries
	 * @param playingPosition
	 */
    public void setPlayingPosition(PlayingPosition playingPosition) {
        if(playingPosition!=null)
            this.playingPosition = playingPosition;
        else System.err.println("Igraceva pozicija ne smije biti null");
    }

    /**
     * Gets the playing skill of the specified player
     * @return playingSkill
     * @author Fran Vlahović
     */
    public int getPlayingSkill() {
        return playingSkill;
    }

    /**
     * Gets the playing position of a team
     * @return playingPosition
     * @author Fran Vlahović
     */
    public PlayingPosition getPlayingPosition() {
        return playingPosition;
    }
}