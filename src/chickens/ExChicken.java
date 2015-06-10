package chickens;

import java.util.Set;

import javax.swing.ImageIcon;

import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;
import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;

public class ExChicken extends Chicken {
	
	public ExChicken(Cord cord, ChickenMatrix matrix) {
		super(cord, matrix);
		this.kind = "ex";
		this.button.setIcon(new ImageIcon("ex.png"));
	}

	@Override
	public void visit(RedShot shot) {
		System.out.println("Red shot ex chicken");
		
	}

	@Override
	public void visit(BlueShot shot) {
		System.out.println("blue shot ex chicken");
		
	}

	@Override
	public void visit(YellowShot shot) {
		System.out.println("yellow shot ex chicken");
		
	}
	
	@Override
	public void visit(BlackShot shot) {
		System.out.println("black shot ex chicken");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		
		Set<Chicken> ex = this.matrix.getChickensInEx(cord);
		for (Chicken chicken : ex) {
			if (chicken.isAlive()) {
				chicken.die();
			}
		}
		this.die();
		
		
		
	}

}
