package hr.fer.oop.lab1;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


public class MyFirstProgram {
	
	public static void calculateStatistics(String[] args) {
		DescriptiveStatistics statistics = new DescriptiveStatistics();
		for (int i = 0; i < args.length; i++) {
		String arg = args[i];
		int argLength = arg.length();
		statistics.addValue(argLength);
		}
		System.out.println("Prosjecna duljina znakova argumenata: "+ statistics.getMean());
		System.out.println("MIN:" + statistics.getMin() + " MAX:" + statistics.getMax());
		}
	
	public static void cluelessMethod(String[] args) {
		String result = "";
		int step = 0;
		for (int i = 0; i < args.length; i++) {
			step++;
			String arg = args[i];
//			int argLength = arg.length();
//			String upperCase = arg.toUpperCase();
			result += " " + arg;
			if ((i + 1) < args.length) {
				System.out.println ("Korak " + step + ": " + result);
				result = "";
			}
		}
		System.out.println("Argumenti programa su: " + result);
		}
	
	public static void main(String[] args) {
		System.out.println("Moj prvi program!");
		for (int i = 0; i < args.length; i++) {
			int argNo = i + 1;
			System.out.println("" + argNo + ". argument programa = " + args[i]);
			}
		cluelessMethod(args);
		calculateStatistics(args);
		}
}
