package hr.fer.oop.lab3.exceptions;

public class TeamNameNullException extends TeamCreationException{
	
	private static final long serialVersionUID = 1L;

	public TeamNameNullException(){
		super("Team name must not be null!");
	}

}
