package hr.fer.oop.lab1.prob2;

public class Roots {
	
	public static void main(String[] args) {
	
		if(args.length!=3) {
			System.out.println("krivi broj argumeata.");
			System.exit(0);
		}
		
		double re=Double.parseDouble(args[0]);
		double im=Double.parseDouble(args[1]);
		int root=Integer.parseInt(args[2]);
		
		if(root<2) {
			System.out.println("Krivi n");
			System.exit(0);
		}
		
		double kut=Math.atan2(im, re);
		double modul=Math.sqrt(re*re + im*im);
		
		for(int i=0; i<root; ++i) {
			
			double re2=Math.pow(modul, 1.0/root)*Math.cos((kut+2*Math.PI*i)/root);
			double im2=Math.pow(modul, 1.0/root)*Math.sin((kut+2*Math.PI*i)/root);
			
			System.out.println(i+1 + ". " + Math.round(re2) + (im2<0? "" : "+") + Math.round(im2) + "i ");
		}
	}	
}