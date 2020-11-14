package hr.fer.oop.lab3.exceptions;

public class FootballPlayerPlayingSkillException extends FootballPlayerCreationException{
	
	private static final long serialVersionUID = 1L;

	public FootballPlayerPlayingSkillException(String message, int lowB, int upB) {
		super(message + " " + lowB + " - " + upB);
	}

}
