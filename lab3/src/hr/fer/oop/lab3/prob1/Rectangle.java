package hr.fer.oop.lab3.prob1;
import hr.fer.oop.lab3.pic.Picture;
import hr.fer.oop.lab3.pic.PictureDisplay;

public class Rectangle implements Drawable {
	protected int a; //width
	protected int b; //height
	public Rectangle(int a,int b) {
		if (a>=0 && b>=0) {
			this.a=a;
			this.b=b;
		}
		else throw new IllegalArgumentException("Wrong input");
	}
	public Rectangle(Rectangle other) {
		this.a=other.a;
		this.b=other.b;
	}
	@Override
	public void drawOnPicture(Picture pic) {
		int emptyHeight = pic.getHeight() / 2 - (b)/ 2
				, emptyWidth = pic.getWidth() / 2 - (a) / 2;		
		for(int y = 0; y < pic.getHeight(); y++ ) {
			for(int x = 0; x < pic.getWidth(); x++ ) {
				if(y >= emptyHeight 
						&& y < emptyHeight + b 
						&& x >= emptyWidth 
						&& x < emptyWidth + a) {
					pic.turnPixelOn(x, y);					
				}
			}
		}		
	}
	public static void main(String[] args) { 
		int [][] tests = new int[][] { {150, 50, 15, 3}, {150, 50, 0, 0} };
		for(int[] test : tests) {
			System.out.println(new StringBuilder("Picture(w:")
					.append(Integer.toString(test[0]))
					.append(",h:")
					.append(Integer.toString(test[1]))
					.append("), Rectangle(w:")
					.append(Integer.toString(test[2]))
					.append(",h:")
					.append(Integer.toString(test[3]))
					.append("):")
					);
			Picture p = new Picture(test[0], test[1]);
			Rectangle r = new Rectangle(test[2], test[3]);
			r.drawOnPicture(p);
			PictureDisplay.showPicture(p);

		}
	}

}
