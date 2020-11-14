package hr.fer.oop.lab3.prob1;
import hr.fer.oop.lab3.pic.Picture;
import hr.fer.oop.lab3.pic.PictureDisplay;

public class EquilateralTriangle implements Drawable {
	protected double side;
	public EquilateralTriangle(double side) {
		if(side >= 0) { 
			this.side = side;
		} else {
			throw new IllegalArgumentException("Can't instatiate triangles with a negative side length");
		}
	}
	public EquilateralTriangle(EquilateralTriangle original) { 
		this.side = original.side;
	}
	@Override
	public void drawOnPicture(Picture pic) {
		double sqt = Math.sqrt(3); //just to save some space... 
		// y0 = tan(120) x + C0 = - sqrt(3)*x + C0; y1 = tan(60) x + C1 = sqrt(3) + C1:
		double C0 = (pic.getHeight() + sqt * pic.getWidth()) / 2 - side * sqt / 4;
		double C1 = (pic.getHeight() - sqt * pic.getWidth()) / 2 - side * sqt / 4;;
		for(int y = 0; y < pic.getHeight(); y++) {
			for(int x = 0; x < pic.getWidth(); x++) { 
				if((y < pic.getHeight()/2 + side * sqt / 4) 
						&& (y > -sqt * x + C0) 
						&& (y > sqt * x + C1)
						) {					
					pic.turnPixelOn(x, y);
				}
			}
		}
	}

	public static void main(String[] args) { 
		int [][] tests = new int[][] { {100, 100, 50}, {150, 50, 0} };
		for(int[] test : tests) {
			System.out.println(new StringBuilder("Picture(w:")
					.append(Integer.toString(test[0]))
					.append(",h:")
					.append(Integer.toString(test[1]))
					.append("), Triangle(s:")
					.append(Integer.toString(test[2]))					
					.append("):")
					);
			try {
				Picture p = new Picture(test[0], test[1]);
				EquilateralTriangle t = new EquilateralTriangle(test[2]);
				t.drawOnPicture(p);
				PictureDisplay.showPicture(p);
			}
			catch(Exception e) { 
				e.printStackTrace();
			}
		}
	}

}
