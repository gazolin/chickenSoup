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
		
		this.kind = "purple";
		label.setIcon(new ImageIcon("pictures//yellow.png"));
	}

	@Override
	public void visit(RedShot shot) {
		System.out.println("Red shot yellow chicken");
		for (int i = 0; i < 2; i++) {
			Chicken chicken = this.matrix.getChickenByKind("orange");
			if (chicken != null) {
			
				chicken.die();
			}
		}
		
	}

	@Override
	public void visit(BlueShot shot) {
		System.out.println("blue shot yellow chicken");
		for (int i = 0; i < 2; i++) {
			Chicken chicken = this.matrix.getChickenByKind("orange");
			if (chicken != null) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				chicken.die();
			}
		}
		
	}

	@Override
	public void visit(YellowShot shot) {
		System.out.println("yellow shot yellow chicken");
		this.die();
	}

	@Override
	public void visit(BlackShot shot) {
		System.out.println("black shot yellow chicken");
		
	}
}
