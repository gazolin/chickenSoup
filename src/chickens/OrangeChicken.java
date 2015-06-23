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
	public void visit(RedShot shot) {
		this.die();
	}

	@Override
	public void visit(BlueShot shot) {
		
	}

	@Override
	public void visit(YellowShot shot) {
		this.die();
	}
	

	@Override
	public void visit(BlackShot shot) {
		
	}
}
