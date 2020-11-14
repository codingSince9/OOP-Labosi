package hr.fer.oop.lab3.exceptions;

public class TeamFormationNullException extends TeamCreationException{
	
	private static final long serialVersionUID = 1L;

	public TeamFormationNullException(){
		super("Team formation must not be null!");
	}
}
