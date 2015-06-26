package chickenSoup;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JPanel;

import chickens.BlueChicken;
import chickens.Chicken;
import chickens.CircleChicken;
import chickens.ColumnChicken;
import chickens.ExChicken;
import chickens.FluChicken;
import chickens.GreenChicken;
import chickens.OrangeChicken;
import chickens.PlusChicken;
import chickens.PurpleChicken;
import chickens.RedChicken;
import chickens.RowChicken;
import chickens.XorChicken;
import chickens.YellowChicken;

@SuppressWarnings("serial")
public class ChickenMatrix extends JPanel  {
	
	private final int WIDTH = 8;
	private final int HEIGHT = 4;
	
	private Map<Integer, Map<Integer, Chicken>> allChickens;
	private int chickensCount;
	private Level level;

	public ChickenMatrix (int[][] init, Level level) {
		this.level = level;
		setLayout(new GridLayout(4, 8));
		setOpaque(false);	
		Chicken chicken;
		Cord cord;
		Map<Integer, Chicken> row;
		chickensCount = HEIGHT * WIDTH;
		allChickens = new HashMap<Integer, Map<Integer, Chicken>>();
		
		/* initiate the matrix */
		for (int i = 0; i < HEIGHT; i++) {
			row = new HashMap<Integer, Chicken>();	
			for (int j = 0; j < WIDTH; j++) {
				cord = new Cord(i, j);
				chicken = createTheChiken(init[i][j], cord);		
				row.put(j, chicken);
				this.add(chicken.getLabel());	
			}
			allChickens.put(i,row);
		}
	}

	
	public Chicken createTheChiken (int kind, Cord cord) {
		Chicken chicken = null;
		switch(kind) {
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
			case 5:
				chicken = new PurpleChicken(cord, this);
				break;
			case 6:
				chicken = new GreenChicken(cord, this);
				break;
			case 7:
				chicken = new ExChicken(cord, this);
				break;
			case 8:
				chicken = new PlusChicken(cord, this);
				break;
			case 9:
				chicken = new CircleChicken(cord, this);
				break;
			case 10:
				chicken = new ColumnChicken(cord, this);
				break;
			case 11:
				chicken = new RowChicken(cord, this);
				break;
			case 12:
				chicken = new XorChicken(cord, this);
				break;
			case 13:
				chicken = new FluChicken(cord, this);
				break;
		}
		return chicken;
	}
	
	public void reduceCount() {
		chickensCount --;
		
		if (chickensCount == 0) {
			level.levelEnds();
		}
	}

	public Chicken getChickenByKind(String kind) {
		Chicken chicken = null;
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				chicken = getChickenByCord(new Cord(i, j));
				if (kind.equals(chicken.getKind()) && chicken.isAlive()) {
					return chicken;
				}
			}
		}	
		return null;
	}
	
	private boolean isInBounds(Cord cord) {
		return cord.getI() > -1 && cord.getI() < HEIGHT && cord.getJ() > -1 && cord.getJ() < WIDTH;
	}
	
	private Chicken getChickenByCord(int x, int y) {
		return getChickenByCord(new Cord(x,y));
	}
	
	private Chicken getChickenByCord(Cord cord) {
		if (!isInBounds(cord))
			return null;
		return allChickens.get(cord.getI()).get(cord.getJ());
	}
	
	public Set<Chicken> getChickensInRow(int row) {
		Set<Chicken> ans = new HashSet<Chicken>();
		for (Chicken chicken : allChickens.get(row).values()) {
			if (chicken != null) {
				ans.add(chicken);
			}
		}
		return ans;
	}
	
	public Set<Chicken> getChickensInCol(int col) {
		Set<Chicken> ans = new HashSet<Chicken>();
		Chicken chicken;
		for (int i = 0; i < HEIGHT; i++) {
			chicken = allChickens.get(i).get(col);
			if (chicken != null) {
				ans.add(chicken);
			}
		}
		return ans;
	}
	
	public Set<Chicken> getAllChickenSet() {
		Set<Chicken> ans = new HashSet<Chicken>();
		for (Map <Integer, Chicken> row : allChickens.values()) {
			ans.addAll(row.values());
		}
		return ans;
	}
	
	public Set<Chicken> getAllTheChickensAround(Cord cord) {
		Set<Chicken> ans = new HashSet<Chicken>();
		Chicken chicken;
		int i = cord.getI();
		int j = cord.getJ();
		
		if ((chicken = getChickenByCord(i-1, j-1)) != null)
			ans.add(chicken);
		if ((chicken = getChickenByCord(i-1, j)) != null)
			ans.add(chicken);
		if ((chicken = getChickenByCord(i-1, j+1)) != null)
			ans.add(chicken);
		if ((chicken = getChickenByCord(i, j-1)) != null)
			ans.add(chicken);
		if ((chicken = getChickenByCord(i, j+1)) != null)
			ans.add(chicken);
		if ((chicken = getChickenByCord(i+1, j-1)) != null)
			ans.add(chicken);
		if ((chicken = getChickenByCord(i+1, j)) != null)
			ans.add(chicken);
		if ((chicken = getChickenByCord(i+1, j+1)) != null)
			ans.add(chicken);
						
		return ans;
	}
	
	public Set<Chicken> getChickensInEx(Cord cord) {
		Set<Chicken> ans = new HashSet<Chicken>();
		Chicken chicken;
		int i = cord.getI();
		int j = cord.getJ();
		
		if ((chicken = getChickenByCord(i-1, j-1)) != null)
			ans.add(chicken);
		if ((chicken = getChickenByCord(i-2, j-2)) != null)
			ans.add(chicken);
		if ((chicken = getChickenByCord(i-1, j+1)) != null)
			ans.add(chicken);
		if ((chicken = getChickenByCord(i-2, j+2)) != null)
			ans.add(chicken);
		if ((chicken = getChickenByCord(i+1, j-1)) != null)
			ans.add(chicken);
		if ((chicken = getChickenByCord(i+2, j-2)) != null)
			ans.add(chicken);
		if ((chicken = getChickenByCord(i+1, j+1)) != null)
			ans.add(chicken);
		if ((chicken = getChickenByCord(i+2, j+2)) != null)
			ans.add(chicken);
						
		return ans;
	}
	
	public Set<Chicken> getLowerChickens() {
		Set<Chicken> ans = new HashSet<Chicken>();
		Chicken chicken;
		for (int col = 0; col < WIDTH; col++) {
			chicken = getLowerChickenInColumn(col);
			if (chicken != null) {
				ans.add(chicken);
			}
		}
		return ans;
	}
	
	private Chicken getLowerChickenInColumn(int col) {
		Chicken chicken = null;
		for (int i = HEIGHT-1; i > -1; i--) {
			chicken = getChickenByCord(i, col);
			if (chicken.isAlive()) {
				return chicken;
			}
		}
		return chicken;		
	}
	
}
