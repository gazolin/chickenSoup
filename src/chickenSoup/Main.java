package chickenSoup;

import shots.BlackShot;
import shots.RedShot;
import shots.Shot;
import shots.YellowShot;
import chickens.BlueChicken;
import chickens.Chicken;
import chickens.RedChicken;

public class Main {
	
	public static void main (String[] args) {
				
		Shot black = new BlackShot();
		Shot yellow = new YellowShot();
		Shot red = new RedShot();
		Shot blue = new BlackShot();

		Level1 lvl1 = new Level1();
		lvl1.setVisible(true);
		lvl1.setLocationRelativeTo(null);
		
		ChickenMatrix matrix = lvl1.getMatrix();
		Cord cord = new Cord(0, 0);
		red.shooting(matrix.getChickenByCord(cord));
		black.shooting(matrix.getChickenByCord(cord));
		black.shooting(matrix.getChickenByCord(new Cord(2, 2)));
		yellow.shooting(matrix.getChickenByCord(new Cord(0, 3)));

	}

}
