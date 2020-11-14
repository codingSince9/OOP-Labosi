package hr.fer.oop.lab1.prob1;
import java.util.Scanner;

public class Rectangle {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double width=-1;
		double height=-1;
		String widthLine=new String();
		String heightLine=new String();
		
		if(args.length!=2) {
			System.out.println("Invalid number of arguments was provided.");
			System.exit(0);
		}
		
		width=Double.parseDouble(args[0]);
		height=Double.parseDouble(args[1]);
		
		if(width<0) {
			while(width<0) {
				System.out.println("The width must not be negative.");
				System.out.println("Please provide width: ");
				
				widthLine = sc.nextLine();
				if(widthLine.isEmpty()) {
					System.out.println("The input must not be blank.");
				}
				else
					width=Double.parseDouble(widthLine);
			}
		}
		
		if(height<0) {
			while(height<0) {
				System.out.println("The height must not be negative.");
				System.out.println("Please provide height: ");
				
				heightLine = sc.nextLine();
				if(heightLine.isEmpty()) {
					System.out.println("The input must not be blank.");
				}
				else
					height=Double.parseDouble(heightLine);
			}
		}
		
		double area = width * height;
		double perimeter = 2*width + 2*height;
		System.out.println("You have specified a rectangle of width " + width + " and height " + height + ". Its area is " + area + " and its perimeter is " + perimeter);
		sc.close();
	}
}