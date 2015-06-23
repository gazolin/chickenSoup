package chickens;

import javax.swing.ImageIcon;

import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;
import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;

public class GreenChicken extends Chicken {
	
	public GreenChicken(Cord cord, ChickenMatrix matrix) {
		super(cord, matrix);
		this.kind = "green";
		this.label.setIcon(new ImageIcon("pictures//green.png"));
	}

	@Override
	public void visit(RedShot shot) {
		
	}

	@Override
	public void visit(BlueShot shot) {
		this.die();
	}

	@Override
	public void visit(YellowShot shot) {
		this.die();
	}
	
	@Override
	public void visit(BlackShot shot) {
		
	}
}
