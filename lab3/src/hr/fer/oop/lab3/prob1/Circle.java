package hr.fer.oop.lab3.prob1;

import hr.fer.oop.lab3.pic.Picture;
import hr.fer.oop.lab3.pic.PictureDisplay;

public class Circle implements Drawable {
	protected double radius;
	public Circle(double radius) {
		if (radius>=0) {
			this.radius=radius;
		}
		else {
			throw new IllegalArgumentException("Can't instatiate triangles with a negative side length");
		}
	}
	public Circle(Circle original) {
		this.radius=original.radius;
	}

	@Override
	public void drawOnPicture(Picture pic) {
		int cY = pic.getHeight() / 2
				, cX = pic.getWidth() / 2;
		for( int y = 0; y < pic.getHeight(); y++ ) {
			for(int x = 0; x < pic.getWidth(); x++) {
				if(Math.pow(x - cX, 2) + Math.pow(y - cY,  2) < Math.pow(radius, 2) ){
					pic.turnPixelOn(x,  y);
				}
			}
		}

	}
	public static void main(String[] args) { 
		int[][] tests = { {80, 50, 1}, {80, 50, 0} };

		for(int[] test : tests) { 
			System.out.println(new StringBuilder("Picture(w:")
					.append(test[0])
					.append(", h:")
					.append(test[1])
					.append("), Circle(r:")
					.append(test[2])
					.append("):"));
			try {
				Picture p = new Picture(test[0], test[1]);
				Circle c = new Circle(test[2]);
				c.drawOnPicture(p);
				PictureDisplay.showPicture(p);
			}
			catch(Exception e) { 
				e.printStackTrace();
			}
		}

	}

}
