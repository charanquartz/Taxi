package customer;

import java.util.Random;

public class GenerateRandomNumber {
	
	public static String getRandomNumberString() {
	    
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	   
	    return String.format("%06d", number);
	}
	

}
