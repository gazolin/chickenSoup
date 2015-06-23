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
	public void visit(RedShot shot) {
		this.die();
	}

	@Override
	public void visit(BlueShot shot) {
		this.die();
		
	}

	@Override
	public void visit(YellowShot shot) {
		
	}
	
	@Override
	public void visit(BlackShot shot) {
		
	}


}
