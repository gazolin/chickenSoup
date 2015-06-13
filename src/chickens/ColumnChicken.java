package chickens;

import java.util.Set;

import javax.swing.ImageIcon;

import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;
import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;

public class ColumnChicken extends Chicken {
	
	public ColumnChicken(Cord cord, ChickenMatrix matrix) {
		super(cord, matrix);
		this.kind = "column";
		this.label.setIcon(new ImageIcon("pictures//column.png"));
	}

	@Override
	public void visit(RedShot shot) {
		System.out.println("Red shot green chicken");
		
	}

	@Override
	public void visit(BlueShot shot) {
		System.out.println("blue shot green chicken");
		
	}

	@Override
	public void visit(YellowShot shot) {
		System.out.println("yellow shot green chicken");
		
	}
	
	@Override
	public void visit(BlackShot shot) {
		System.out.println("black shot green chicken");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int j = this.cord.getJ();
		Set<Chicken> col = this.matrix.getChickensInCol(j);
		for (Chicken chicken : col) {
			if (chicken.isAlive()) {
				chicken.die();
			}
		}
		
	}

}
