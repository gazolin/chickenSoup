package chickens;

import javax.swing.ImageIcon;

import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;
import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;

public class OrangeChicken extends Chicken {

	public OrangeChicken(Cord cord, ChickenMatrix matrix) {
		super(cord, matrix);
		this.kind = "orange";
		this.label.setIcon(new ImageIcon("pictures//orange.png"));
	}

	@Override
	public boolean visit(RedShot shot) {
		this.die();
		return true;
	}

	@Override
	public boolean visit(BlueShot shot) {
		return false;
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
