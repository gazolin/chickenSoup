package chickenSoup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ship.*;


public class Level extends JFrame implements ActionListener  {
	
	
	int[][] level1 = {{11, 2, 3, 1, 1, 3, 2, 1}, {3, 1, 2, 2, 2, 2, 1, 3},
			{2, 3, 9, 7, 3, 1, 3, 2}, {1, 2, 3, 4, 4, 3, 2, 1}}; 
	
	private ChickenMatrix chicks;
	private ShipPanel shipPanel;
	private SpaceShip ship;
	private int level;
	private ContentPanel lvlPanel;
	private Map<Integer, int[][]> levels;
	
    public Level (int level) {
    	this.level = level;
//    	initLevels();
//    	chicks = new ChickenMatrix(levels.get(level));
    	ship = new SpaceShip();
    	chicks = new ChickenMatrix(level1);
    	shipPanel = new ShipPanel(ship);
    	shipPanel.add(ship);
    	setFocusable(true);
       	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	lvlPanel = new ContentPanel(new ImageIcon("stars.gif").getImage(), chicks, shipPanel);
    	setLocationRelativeTo(null);
    	getContentPane().add(lvlPanel);
    	chicks.setVisible(true);
    	

    	KeyListener listener = new KeyListener() {

    		@Override
    		public void keyPressed(KeyEvent event) {
    			   int key = event.getKeyCode();
    			   if (key == KeyEvent.VK_LEFT) {
    				   if(ship.getLabel().getLocation().x-10 > 0)
    					   ship.getLabel().move(ship.getLabel().getLocation().x-10, 0);   
    			   }

    			   if (key == KeyEvent.VK_RIGHT) {	
    				   System.out.println(ship.getLabel().getLocation().x-10);
    				   if(ship.getLabel().getLocation().x-10 > 100)
    					   ship.getLabel().move(ship.getLabel().getLocation().x+10, 0);
    			    }
    			    
    			    if (key == KeyEvent.VK_SPACE) {
    			    	System.out.println("piewpiew!");
    			    }
    		   
    		   printEventInfo("Key Pressed", event);
    		}
    		
    		@Override
    		public void keyReleased(KeyEvent event) {
    		    printEventInfo("Key Released", event);
    		}
    		
    		@Override
    		public void keyTyped(KeyEvent event) {
    		    printEventInfo("Key Typed", event);
    		}
    		
    		private void printEventInfo(String str, KeyEvent e) {
    		    System.out.println(str);
    		    int code = e.getKeyCode();
    		    System.out.println("   Code: " + KeyEvent.getKeyText(code));
    		    System.out.println("   Char: " + e.getKeyChar());
    		    int mods = e.getModifiersEx();
    		    System.out.println("    Mods: "+ KeyEvent.getModifiersExText(mods));
    		    System.out.println("    Location: "+ keyboardLocation(e.getKeyLocation()));
    		    System.out.println("    Action? " + e.isActionKey());
    		}
    		
    		private String keyboardLocation(int keybrd) {
    		    switch (keybrd) {
    		    case KeyEvent.KEY_LOCATION_RIGHT:
    		    	return "Right";
    		    case KeyEvent.KEY_LOCATION_LEFT:
    		    	return "Left";
    		    case KeyEvent.KEY_LOCATION_NUMPAD:
    		    	return "NumPad";
    		    case KeyEvent.KEY_LOCATION_STANDARD:
    		    	return "Standard";
    		    case KeyEvent.KEY_LOCATION_UNKNOWN: 
    		
    		    default:
    		    	return "Unknown";
    		    }
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
  
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
	

