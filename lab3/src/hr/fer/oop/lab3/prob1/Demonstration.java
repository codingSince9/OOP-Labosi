package hr.fer.oop.lab3.prob1;
import hr.fer.oop.lab3.pic.Picture;
import hr.fer.oop.lab3.pic.PictureDisplay;

public class Demonstration {

	public static void main(String[] args) {
		Picture p = new Picture(1000, 500);
		Drawable[] ds = { new Rectangle(40, 40)
				, new RectangleFast(90, 6)
				, new Circle(25)
				, null
				, new EquilateralTriangle(25)
				, new EquilateralTriangleFast(49) 
		};
		ds[3] = new CircleFast((Circle)ds[2]);
		
		for(Drawable d : ds) { 
			d.drawOnPicture(p);
		}
		PictureDisplay.showPicture(p);
	}

}