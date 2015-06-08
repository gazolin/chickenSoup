package chickens;

import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;

public class BlueChicken extends Chicken {

	@Override
	public void visit(RedShot shot) {
		System.out.println("Red shot blue chicken");
		
	}

	@Override
	public void visit(BlackShot shot) {
		System.out.println("black shot blue chicken");
		
	}

	@Override
	public void visit(BlueShot blueShot) {
		System.out.println("blue shot blue chicken");
		
	}

	@Override
	public void visit(YellowShot yellowShot) {
		System.out.println("yellow shot blue chicken");
		
	}

}
