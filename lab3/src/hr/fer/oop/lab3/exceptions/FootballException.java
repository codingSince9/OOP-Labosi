package hr.fer.oop.lab3.exceptions;

public class FootballException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public FootballException(String message){
		super(message);
	}

	public FootballException() {
		super("Error in project!");
	}
}
