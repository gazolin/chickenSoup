package chickens;

import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;

public class YellowChicken extends Chicken {

	@Override
	public void visit(RedShot shot) {
		System.out.println("Red shot yellow chicken");
		
	}

	@Override
	public void visit(BlackShot shot) {
		System.out.println("black shot yellow chicken");
		
	}

	@Override
	public void visit(BlueShot blueShot) {
		System.out.println("blue shot yellow chicken");
		
	}

	@Override
	public void visit(YellowShot yellowShot) {
		System.out.println("yellow shot yellow chicken");
		
	}
}
