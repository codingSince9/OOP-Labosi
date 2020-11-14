package hr.fer.oop.lab1.prob5;

public class Shapes {
	
	public static void plusMinusPlus() {
		System.out.println("+--------+");
	}
	
	public static void leftRight() {
		System.out.println("\\        /");
		System.out.println(" \\______/");
	}	
	
	public static void rightLeft() {
		System.out.println("  ______");
		System.out.println(" /      \\");
		System.out.println("/        \\");
	}
	
	public static void main(String[] args) {
		plusMinusPlus();
		leftRight();
		rightLeft();
		plusMinusPlus();
		System.out.println();
		rightLeft();
		leftRight();
		System.out.println();
		leftRight();
		plusMinusPlus();
		rightLeft();
		plusMinusPlus();
	}
}
