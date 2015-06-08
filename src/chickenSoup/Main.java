package chickenSoup;

import chickens.BlueChicken;
import chickens.Chicken;
import chickens.RedChicken;

public class Main {
	
	public static void main (String[] args) {
		
		
		Chicken red = new RedChicken();
		Chicken blue = new BlueChicken();
		
		Shot black = new BlackShot();
		Shot red2 = new RedShot();
		
		black.shooting(red);
		black.shooting(blue);
		red2.shooting(red);
		red2.shooting(blue);
		
	}

}
