package chickens;

import chickenSoup.BlackShot;
import chickenSoup.RedShot;

public class RedChicken extends Chicken {

	@Override
	public void visit(RedShot shot) {
		System.out.println("Red shot red chicken");
		
	}

	@Override
	public void visit(BlackShot shot) {
		System.out.println("black shot red chicken");
		
	}

}
