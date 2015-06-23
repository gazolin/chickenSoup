package chickens;

import javax.swing.ImageIcon;

import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;
import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;

public class RedChicken extends Chicken {

	public RedChicken(Cord cord, ChickenMatrix matrix) {
		super(cord, matrix);	
		this.kind = "red";
		label.setIcon(new ImageIcon("pictures//red.png"));
	}

	@Override
	public void visit(RedShot shot) {	
		this.die();
	}

	@Override
	public void visit(BlueShot shot) {
		for (int i = 0; i < 2; i++) {
			Chicken chicken = this.matrix.getChickenByKind("purple");
			if (chicken != null) {
		
				chicken.die();
			}
		}		
	}

	@Override
	public void visit(YellowShot shot) {
		for (int i = 0; i < 2; i++) {
			Chicken chicken = this.matrix.getChickenByKind("orange");
			if (chicken != null) {
			
				chicken.die();
			}
		}
	}

	@Override
	public void visit(BlackShot shot) {
		
	}
}
