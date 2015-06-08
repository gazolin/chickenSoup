package chickens;

import chickenSoup.BlackShot;
import chickenSoup.RedShot;

public class BlueChicken extends Chicken {

	@Override
	public void visit(RedShot shot) {
		System.out.println("Red shot blue chicken");
		
	}

	@Override
	public void visit(BlackShot shot) {
		System.out.println("black shot blue chicken");
		
	}

}
