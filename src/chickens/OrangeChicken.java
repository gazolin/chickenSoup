package chickens;

import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;

public class OrangeChicken extends Chicken {

	@Override
	public void visit(RedShot shot) {
		System.out.println("Red shot orange chicken");
		
	}

	@Override
	public void visit(BlackShot shot) {
		System.out.println("black shot orange chicken");
		
	}

	@Override
	public void visit(BlueShot blueShot) {
		System.out.println("blue shot orange chicken");
		
	}

	@Override
	public void visit(YellowShot yellowShot) {
		System.out.println("yellow shot orange chicken");
		
	}
}
