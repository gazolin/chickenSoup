package chickenSoup;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import chickens.BlueChicken;
import chickens.Chicken;
import chickens.OrangeChicken;
import chickens.RedChicken;
import chickens.YellowChicken;

public class ChickenMatrix extends JPanel  {
	
	private Map<Integer, Map<Integer, Chicken>> allChickens;

	public ChickenMatrix () {
		setLayout(new GridLayout(4, 8));
		setOpaque(false);
		
		int[][] level1 = {{1, 2, 3, 1, 1, 3, 2, 1}, {3, 1, 2, 2, 2, 2, 1, 3},
				{2, 3, 1, 3, 3, 1, 3, 2}, {1, 2, 3, 4, 4, 3, 2, 1}}; 
		
		Chicken chicken;
		Cord cord;
		Map<Integer, Chicken> row;
		allChickens = new HashMap<Integer, Map<Integer, Chicken>>();
		
		/* initiate the matrix */
		for (int i = 0; i < 4; i++) {
			row = new HashMap<Integer, Chicken>();	
			for (int j = 0; j < 8; j++) {
				cord = new Cord(i, j);
				chicken = createTheChiken(level1[i][j], cord);		
				row.put(j, chicken);
				add(chicken.getButton());		//what is it? what is add?
			}
			allChickens.put(i,row);
		}
		/*init level 1/2/3/4*/
		initLevel(1);
	}
	
	public Chicken createTheChiken (int color, Cord cord) {
		Chicken chicken = null;
		switch(color) {
			case 1:
				chicken = new RedChicken(cord, this);
				break;
			case 2:
				chicken = new BlueChicken(cord, this);
				break;
			case 3:
				chicken = new YellowChicken(cord, this);
				break;
			case 4:
				chicken = new OrangeChicken(cord, this);
				break;
		}
		return chicken;
	}
	
	private void initLevel(int num) {
		switch (num){
		case 1:
			initLeve1();
			break;
		/*case 2:
			initLeve2();
			break;
		case 3:
			initLeve3();
			break;
		case 4:
			initLeve4();
			break;
		*/
		}
	}
	
	private void initLeve1(){
		
		Color red = Color.red;
		Color blue = Color.blue;
		Color yellow = Color.yellow;
		Color orange = Color.orange;
		
		int[][] color = {{1, 2, 3, 1, 1, 3, 2, 1}, {3, 1, 2, 2, 2, 2, 1, 3},
				{2, 3, 1, 3, 3, 1, 3, 2}, {1, 2, 3, 4, 4, 3, 2, 1}}; 
		Cord curCord = new Cord(0,0);
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 8; j++) {
				
				
				
				getChickenByCord(new Cord(i,j)).setIconByColor(color[i][j]);
			}
		}
		
	}
	
	public Chicken getChickenByCord(Cord cord) {
		//if (!isInBounds(cord))
			//return null;
		return allChickens.get(cord.getI()).get(cord.getJ());
	}
	
}
