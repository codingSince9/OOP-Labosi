package hr.fer.oop.lab3.prob1;

import hr.fer.oop.lab3.pic.Picture;
import hr.fer.oop.lab3.pic.PictureDisplay;


public class EquilateralTriangleFast extends EquilateralTriangle {

	public EquilateralTriangleFast(double side) {
		super(side);		
	}
	
	public EquilateralTriangleFast(EquilateralTriangle original) { 
		super(original);
	}

	@Override
	public void drawOnPicture(Picture pic) {
		double sqt = Math.sqrt(3); //just to save some space
		// half of altitude: v/2 = a * sqrt(3) / 4
		double v2 = side * sqt / 4;
		// y0 = tan(120) x + C0 = - sqrt(3)*x + C0; y1 = tan(60) x + C1 = sqrt(3) + C1:
		double C0 = (pic.getHeight() + sqt * pic.getWidth()) / 2 - v2;
		double C1 = (pic.getHeight() - sqt * pic.getWidth()) / 2 - v2;

		int ym = pic.getHeight() / 2 - (int) Math.round(v2);
		for(int y = ym > 0 ? ym : 0; y < Tools.minEq(pic.getHeight() / 2 + (int)v2, pic.getHeight()); y++) {
			int x0 = (int) Math.round((C0 -y) / sqt );
			int x1 = (int) Math.round(( y - C1) / sqt);
			//rounding corner-cases:
			x0 = x0 > 0 ? x0 : 0;
			x0 = x0 < pic.getWidth() ? x0 : pic.getWidth() - 1;
			x1 = x1 > 0 ? x1 : 0;
			x1 = x1 < pic.getHeight() ? x1 : pic.getHeight() - 1;
			pic.drawLine(x0 , Tools.minEq(x1, pic.getWidth()), y);
		}
	}
	public static void main(String[] args) { 
		int [][] tests = new int[][] { {50, 50, 30}, {150, 150, 50} };
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
				EquilateralTriangle t = new EquilateralTriangleFast(test[2]);
				t.drawOnPicture(p);
				PictureDisplay.showPicture(p);
			}
			catch(Exception e) { 
				e.printStackTrace();
			}
		}
	}

}
