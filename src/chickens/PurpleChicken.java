package chickens;

import javax.swing.ImageIcon;

import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;
import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;

public class PurpleChicken extends Chicken {

	public PurpleChicken(Cord cord, ChickenMatrix matrix) {
		super(cord, matrix);
		this.kind = "purple";

		label.setIcon(new ImageIcon("pictures//purple.png"));	
	}

	@Override
	public boolean visit(RedShot shot) {
		this.die();
		return true;
	}

	@Override
	public boolean visit(BlueShot shot) {
		this.die();
		return true;
	}

	@Override
	public boolean visit(YellowShot shot) {
		return false;
	}
	
	@Override
	public boolean visit(BlackShot shot) {
		return false;
	}


}
