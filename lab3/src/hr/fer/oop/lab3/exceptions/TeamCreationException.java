package hr.fer.oop.lab3.exceptions;

public class TeamCreationException extends FootballException{
	private static final long serialVersionUID = 1L;

	public TeamCreationException(){
		super("Error in project!");
	}
	public TeamCreationException(String message){
		super(message);
	}
	
}
