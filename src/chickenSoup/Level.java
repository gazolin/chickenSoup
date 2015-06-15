package chickenSoup;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

import ship.*;
import shots.ShotAnimation;


public class Level extends JFrame implements ActionListener  {
	
	
	int[][] level1 = {{11, 2, 3, 1, 1, 3, 2, 1}, {3, 1, 2, 2, 2, 2, 1, 3},
			{2, 3, 9, 7, 3, 1, 3, 2}, {1, 2, 3, 4, 4, 3, 2, 1}}; 
	
	private Timer timer;
	private ChickenMatrix chicks;
	private ShipPanel shipPanel;
	private SpaceShip ship;
	private int level;
	private ContentPanel lvlPanel;
	private Map<Integer, int[][]> levels;
	private int x, y;
	private final int delay = 200;
	
    public Level (int level) {
    	x = 0; y = 0;
		timer = new Timer(delay,this);
		timer.start();
    	this.level = level;
//    	initLevels();
//    	chicks = new ChickenMatrix(levels.get(level));
       	ship = new SpaceShip();
    	chicks = new ChickenMatrix(level1);
    	shipPanel = new ShipPanel(ship);
    	shipPanel.add(ship);
    	ship.setPanel(shipPanel);
    	setFocusable(true);
       	setDefaultCloseOperation(EXIT_ON_CLOSE);
        lvlPanel = new ContentPanel(new ImageIcon("pictures//stars.gif").getImage(), chicks, shipPanel);
    
    	setLocationRelativeTo(null);
    	getContentPane().add(lvlPanel);

    	KeyListener listener = new KeyListener() {

    		@Override
    		public void keyPressed(KeyEvent event) {
    			   int key = event.getKeyCode();
    			   if (key == KeyEvent.VK_LEFT) {
    				   if(ship.getLabel().getLocation().x-10 > 0)
    					   ship.getLabel().move(ship.getLabel().getLocation().x-10, 0);   
    			   }

    			   if (key == KeyEvent.VK_RIGHT) {	
//    				   System.out.println(ship.getLabel().getLocation().x-10);
    				   if(ship.getLabel().getLocation().x-10 < lvlPanel.getSizeOfSky()-100)
    					   ship.getLabel().move(ship.getLabel().getLocation().x+10, 0);
    			    }
    			    
    			    if (key == KeyEvent.VK_SPACE) {
    			    	System.out.println("piewpiew!");
    			    	lvlPanel.add(new ShotAnimation(lvlPanel).getLabel());
    			    	lvlPanel.revalidate();
    			    	
    			    	ship.shot();
    			    }
    		}
    		
    		@Override
    		public void keyReleased(KeyEvent event) {
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
  
    public void paintComponent(Graphics g) {
	    g.drawImage(new ImageIcon("pictures//shot.png").getImage(), 0, 0, null);
	  }
	

	  public void actionPerformed(ActionEvent e){
		if (e.getSource() == timer){
			x = x + 5;  y = y + 5;
			repaint();
	       }
	  }

}
	

