package chickens;

import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;

public class GreenChicken extends Chicken {

	@Override
	public void visit(RedShot shot) {
		System.out.println("Red shot green chicken");
		
	}

	@Override
	public void visit(BlackShot shot) {
		System.out.println("black shot green chicken");
		
	}

	@Override
	public void visit(BlueShot blueShot) {
		System.out.println("blue shot green chicken");
		
	}

	@Override
	public void visit(YellowShot yellowShot) {
		System.out.println("yellow shot green chicken");
		
	}
}
