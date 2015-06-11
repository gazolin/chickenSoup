package chickenSoup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ship.SpaceShip;


public class Level extends JFrame implements ActionListener  {
	
	
	int[][] level1 = {{11, 2, 3, 1, 1, 3, 2, 1}, {3, 1, 2, 2, 2, 2, 1, 3},
			{2, 3, 9, 7, 3, 1, 3, 2}, {1, 2, 3, 4, 4, 3, 2, 1}}; 
	
	private ChickenMatrix chicks;
	private SpaceShip ship;
	private int level;
	private Map<Integer, int[][]> levels;
	
    public Level (int level) {
    	this.level = level;
//    	initLevels();
//    	chicks = new ChickenMatrix(levels.get(level));
    	chicks = new ChickenMatrix(level1);
    	ship = new SpaceShip();


    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	ContentPanel panel = new ContentPanel(new ImageIcon("stars.gif").getImage(), chicks, ship);
    	setLocationRelativeTo(null);
    	getContentPane().add(panel);
    	
    	chicks.setVisible(true);
    	setVisible(true);
    	pack();
    }
    
    public void initLevels() {
    	int[][] arr = {{1,2},{3,4}};
    	levels.put(1, arr);
    }
    
    public ChickenMatrix getMatrix() {
    	return this.chicks;
    }
  
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
	

