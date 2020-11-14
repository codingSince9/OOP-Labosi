package hr.fer.oop.lab3.prob1;

import hr.fer.oop.lab3.pic.Picture;
import hr.fer.oop.lab3.pic.PictureDisplay;

public class CircleFast extends Circle {
	public CircleFast(double radius) {
		super(radius);		
	}
	
	public CircleFast(Circle original) { 
		super(original);
	}
	
	
	@Override
	public void drawOnPicture(Picture pic) {
		int cY = pic.getHeight() / 2;
		int minY = cY - (int) radius;
		
		for( int y = minY > 0 ? minY : 0; y < Tools.minEq((int)( cY + radius * 2 ), pic.getHeight()); y++ ) {
			double sq = Math.sqrt(Math.pow(radius, 2) - Math.pow(y - pic.getHeight() / 2,  2));
			int x0 = (int) (pic.getWidth()/2 - sq);
			int x1 = (int) (pic.getWidth()/2 + sq);
			pic.drawLine(x0 >= 0 ? x0 : 0, Tools.minEq(x1, pic.getWidth()), y);
		}
	}


	public static void main(String[] args) { 
		int[][] tests = { {250, 250, 100}, {250, 250, 50} };

		for(int[] test : tests) { 
			System.out.println(new StringBuilder("Picture(w:")
					.append(test[0])
					.append(", h:")
					.append(test[1])
					.append("), CircleFast(r:")
					.append(test[2])
					.append("):"));
			try {
				Picture p = new Picture(test[0], test[1]);
				Circle c = new CircleFast(test[2]);
				c.drawOnPicture(p);
				PictureDisplay.showPicture(p);
			}
			catch(Exception e) { 
				e.printStackTrace();
			}
		}

	}

}
