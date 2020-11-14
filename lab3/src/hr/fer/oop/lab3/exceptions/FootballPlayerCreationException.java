package hr.fer.oop.lab3.exceptions;


public class FootballPlayerCreationException extends FootballException{
	
	private static final long serialVersionUID = 1L;

	public FootballPlayerCreationException(){
		super();
	}
	public FootballPlayerCreationException(String message){
		super(message);
	}
	

}
