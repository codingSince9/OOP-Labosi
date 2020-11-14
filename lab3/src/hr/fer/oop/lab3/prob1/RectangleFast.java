package hr.fer.oop.lab3.prob1;

import hr.fer.oop.lab3.pic.Picture;
import hr.fer.oop.lab3.pic.PictureDisplay;

public class RectangleFast extends Rectangle {

	public RectangleFast(int width, int heigth) {
		super(width, heigth);		
	}

	@Override
	public void drawOnPicture(Picture pic) { 
		int emptyHeight = pic.getHeight() / 2 - (b)/ 2
				, emptyWidth = pic.getWidth() / 2 - (a) / 2;		
		for(int y = emptyHeight; y < Tools.minEq(emptyHeight + b, pic.getHeight()); y++ ) {
			pic.drawLine(emptyWidth,  Tools.minEq(emptyWidth + a - 1, pic.getWidth()),  y);
		}		
	}
	
	public static void main(String[] args) { 
		int [][] tests = new int[][] { {150, 50, 15, 3}, {150, 150, 100, 50} };
		for(int[] test : tests) {
			System.out.println(new StringBuilder("Picture(w:")
					.append(Integer.toString(test[0]))
					.append(",h:")
					.append(Integer.toString(test[1]))
					.append("), RectangleFast(w:")
					.append(Integer.toString(test[2]))
					.append(",h:")
					.append(Integer.toString(test[3]))
					.append("):")
					);
			Picture p = new Picture(test[0], test[1]);
			RectangleFast r = new RectangleFast(test[2], test[3]);
			r.drawOnPicture(p);
			PictureDisplay.showPicture(p);
		}

	}


}
