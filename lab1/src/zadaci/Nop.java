package zadaci;

public class Nop {
	public static void main(String[] args) {
	        String input;
	        int numOfNops = 0;
	        if (args.length == 0) {
	            System.out.println("Input string must not be blank...");
	            return;
	        } else {
	            input = args[0];
	        }
	      
	        numOfNops = countNops(input);
	        System.out.println(numOfNops);
	    }
	  
	    public static int countNops(String input) {
	        int nopCounter = 0;
	        for (int i = 0; i < input.length(); i++) {
	            char c = input.charAt(i);
	            if (c >= 'A' && c <= 'Z') {
	                if ((i+nopCounter) % 4 != 0) {
	                    nopCounter += 4 - ((i + nopCounter ) % 4);
	                }
	            }
	        }
	        return nopCounter;
	    }
	}