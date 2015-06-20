package chickenSoup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ship.*;

public class Level extends JFrame  {
	
	
	int[][] level1 = {{11, 2, 3, 1, 1, 3, 2, 1}, {3, 1, 2, 2, 2, 2, 1, 3},
			{2, 3, 9, 7, 3, 1, 3, 2}, {1, 2, 3, 4, 4, 3, 2, 1}}; 
	
	private ChickenMatrix chicks;
	private ShipPanel shipPanel;
	private SpaceShip ship;
	private int level;
	private ContentPanel lvlPanel;
	private Map<Integer, int[][]> levels;
	private int curX;
	
    public Level (int level) {
    	this.level = level;
//    	initLevels();
//    	chicks = new ChickenMatrix(levels.get(level));
       	ship = new SpaceShip();
    	chicks = new ChickenMatrix(level1);
    	shipPanel = new ShipPanel(ship);
    	shipPanel.add(ship.getLabel());
    	ship.setPanel(shipPanel);
    	setFocusable(true);
       	setDefaultCloseOperation(EXIT_ON_CLOSE);
        lvlPanel = new ContentPanel(new ImageIcon("pictures//stars.gif").getImage(), chicks, shipPanel);
    
    	setLocationRelativeTo(null);
    	getContentPane().add(lvlPanel);

    	KeyListener listener = new KeyListener() {

    		@SuppressWarnings("deprecation")
			@Override
    		public void keyPressed(KeyEvent event) {
    			   int key = event.getKeyCode();
    			   if (key == KeyEvent.VK_LEFT) {
    				   if(ship.getLabel().getLocation().x-10 > 0){
    				   	   ship.getLabel().setLocation(ship.getLabel().getLocation().x-10, 0);
    				   }
    			   }

    			   if (key == KeyEvent.VK_RIGHT) {	
    				   if(ship.getLabel().getLocation().x-10 < lvlPanel.getWidthOfSky()-100){
				   	   	   ship.getLabel().setLocation(ship.getLabel().getLocation().x+10, 0);
    				   }
    				
    			    }
    			    
    			    if (key == KeyEvent.VK_SPACE) {
    			    	curX = ship.getLabel().getX();
    			    	lvlPanel.shot(curX);
    			    	ship.getLabel().setLocation(curX,0);

    			    	
    			    }
    		}
    		
    		@Override
    		public void keyReleased(KeyEvent event) {
    			 int key = event.getKeyCode();
    			 if (key == KeyEvent.VK_SPACE) {
    				 ship.getLabel().setLocation(curX,0);
 			    	
 			    }
    			
    		}
    		
    		@Override
    		public void keyTyped(KeyEvent event) {
    		}
    			
    	};
    	
    	addKeyListener(listener);
    	pack();
    }
    
    public void initLevels() {
    	int[][] arr = {{1,2},{3,4}};
    	levels.put(1, arr);
    }
    
    public ChickenMatrix getMatrix() {
    	return this.chicks;
    }
  

}
	

