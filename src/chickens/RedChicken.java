package chickens;

import javax.swing.ImageIcon;

import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;
import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;

public class RedChicken extends Chicken {

	public RedChicken(Cord cord, ChickenMatrix chickens) {
		super(cord, chickens);	
		this.kind = "red";
		button.setIcon(new ImageIcon("red.png"));
	}

	@Override
	public void visit(RedShot shot) {
		System.out.println("Red shot red chicken");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		this.kill();
	}

	@Override
	public void visit(BlackShot shot) {
		System.out.println("black shot red chicken");
		
	}

	@Override
	public void visit(BlueShot blueShot) {
		System.out.println("blue shot red chicken");
		
		for (int i = 0; i < 2; i++) {
			Chicken chicken = this.chickens.getChickenByKind("purple");
			if (chicken != null) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				chicken.kill();
			}
		}
		
	}

	@Override
	public void visit(YellowShot yellowShot) {
		System.out.println("yellow shot red chicken");
		
		for (int i = 0; i < 2; i++) {
			Chicken chicken = this.chickens.getChickenByKind("orange");
			if (chicken != null) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				chicken.kill();
			}
		}
	}
}
