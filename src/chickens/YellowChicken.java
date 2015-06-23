package chickens;

import javax.swing.ImageIcon;

import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;
import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;

public class YellowChicken extends Chicken {

	public YellowChicken(Cord cord, ChickenMatrix matrix) {
		super(cord, matrix);
		
		this.kind = "yellow";
		label.setIcon(new ImageIcon("pictures//yellow.png"));
	}

	@Override
	public boolean visit(RedShot shot) {
		boolean died = false;
		for (int i = 0; i < 2; i++) {
			Chicken chicken = this.matrix.getChickenByKind("orange");
			if (chicken != null) {
				chicken.die();
				died = true;
			}
		}
		return died;
	}

	@Override
	public boolean visit(BlueShot shot) {
		boolean died = false;
		for (int i = 0; i < 2; i++) {
			Chicken chicken = this.matrix.getChickenByKind("green");
			if (chicken != null) {
				chicken.die();
				died = true;
			}
		}
		return died;
	}

	@Override
	public boolean visit(YellowShot shot) {
		this.die();
		return true;
	}

	@Override
	public boolean visit(BlackShot shot) {
		return false;
	}
}
