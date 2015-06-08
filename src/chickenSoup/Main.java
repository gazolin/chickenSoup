package chickenSoup;

import shots.BlackShot;
import shots.Shot;
import shots.YellowShot;
import chickens.BlueChicken;
import chickens.Chicken;
import chickens.RedChicken;

public class Main {
	
	public static void main (String[] args) {
		
		
		Chicken red = new RedChicken();
		Chicken blue = new BlueChicken();
		
		Shot black = new BlackShot();
		Shot yellow = new YellowShot();
		
		black.shooting(red);
		black.shooting(blue);
		yellow.shooting(red);
		yellow.shooting(blue);
		Level1 lvl1 = new Level1();
		lvl1.setVisible(true);
		lvl1.setLocationRelativeTo(null);
		
		
	}

}
