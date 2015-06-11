package chickenSoup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

    	KeyListener listener = new KeyListener() {

    		@Override
    		public void keyPressed(KeyEvent event) {
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
	

