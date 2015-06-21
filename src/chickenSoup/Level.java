package chickenSoup;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ship.ShipPanel;
import ship.SpaceShip;
import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.Shot;
import shots.YellowShot;

@SuppressWarnings("serial")
public class Level extends JFrame  {
	
	
	int[][] level1 = {{1, 2, 3, 1, 1, 3, 2, 1}, {3, 1, 2, 2, 2, 2, 1, 3},
			{2, 3, 1, 3, 3, 1, 3, 2}, {1, 2, 3, 4, 4, 3, 2, 1}}; 
	
	int[][] level2 = {{5, 5, 5, 6, 6, 4, 4, 4}, {3, 9, 1, 1, 1, 1, 9, 3},
			{3, 1, 2, 2, 2, 2, 1, 3}, {6, 5, 4, 3, 3, 4, 5, 6}}; 
	
	int[][] level3 = {{5, 5, 5, 3, 3, 4, 4, 4}, {5, 8, 5, 2, 2, 6, 6, 6},
			{5, 5, 5, 1, 1, 6, 8, 6}, {4, 4, 4, 8, 4, 6, 6, 6}}; 
	
	int[][] level4 = {{5, 5, 4, 4, 5, 5, 4, 4}, {6, 7, 6, 7, 6, 7, 6, 7},
			{4, 3, 5, 2, 4, 3, 5, 2}, {1, 1, 1, 1, 1, 1, 1, 1}}; 
	
	int[][] level5 = {{11, 2, 3, 1, 1, 3, 2, 1}, {3, 1, 2, 2, 2, 2, 1, 3},
			{2, 3, 9, 7, 3, 1, 3, 2}, {1, 2, 3, 4, 4, 3, 2, 1}}; 
	
	int[][] level6 = {{11, 2, 3, 1, 1, 3, 2, 1}, {3, 1, 2, 2, 2, 2, 1, 3},
			{2, 3, 9, 7, 3, 1, 3, 2}, {1, 2, 3, 4, 4, 3, 2, 1}}; 
	
	private ChickenMatrix chicks;
	private ShipPanel shipPanel;
	private SpaceShip ship;
	private ContentPanel lvlPanel;
	private int curX;
	private Shot currShot;
	private ToolBar toolBar;
	private int level;
	private int totalScore;
	private int shotType;
	private boolean isShot;
	
    public Level (int level, int totalScore) {
    	this.level = level;   
    	this.shotType = 1;
    	this.totalScore = totalScore;
    	currShot = new BlackShot();
       	ship = new SpaceShip();
    	chicks = createChickenMatrix(level);
    	shipPanel = new ShipPanel(ship, new ImageIcon("pictures//stars.gif").getImage().getWidth(null));
    	
    	setFocusable(true);
       	setDefaultCloseOperation(EXIT_ON_CLOSE);
       	
       	toolBar = new ToolBar();
        lvlPanel = new ContentPanel(new ImageIcon("pictures//stars.gif").getImage(), chicks, shipPanel, this, toolBar);
    
    	setLocationRelativeTo(null);
    	
    	getContentPane().setLayout(new BorderLayout());
    	getContentPane().add(toolBar, BorderLayout.NORTH);
    	getContentPane().add(lvlPanel, BorderLayout.CENTER);

    	KeyListener listener = new KeyListener() {

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
    			    	if(!isShot){
	    			    	isShot = true;
	    			    	curX = ship.getLabel().getX();
	    			    	lvlPanel.shot(curX, shotType);
    			    	}
    			    }
    			    
    			    if (key == KeyEvent.VK_1 || key == KeyEvent.VK_NUMPAD1) {
    			    	currShot = new BlackShot();
    			    	shotType = 1;
    			    	toolBar.setShot(1);
    			    }
    			    
    			    if (key == KeyEvent.VK_2 || key == KeyEvent.VK_NUMPAD2) {
    			    	currShot = new RedShot();
    			    	shotType = 2;
    			    	toolBar.setShot(2);
    			    }
    			    
    			    if (key == KeyEvent.VK_3 || key == KeyEvent.VK_NUMPAD3) {
    			    	currShot = new BlueShot();
    			    	shotType = 3;
    			    	toolBar.setShot(3);
    			    }
    			    
    			    if (key == KeyEvent.VK_4 || key == KeyEvent.VK_NUMPAD4) {
    			    	currShot = new YellowShot();
    			    	shotType = 4;
    			    	toolBar.setShot(4);
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
    
    public ChickenMatrix createChickenMatrix(int level) {
    	ChickenMatrix matrix = null;
    	switch (level) {
		case 1:
			matrix = new ChickenMatrix(level1, this);
			break;
		case 2:
			matrix = new ChickenMatrix(level2, this);
			break;
		case 3:
			matrix = new ChickenMatrix(level3, this);
			break;
		case 4:
			matrix = new ChickenMatrix(level4, this);
			break;
		case 5:
			matrix = new ChickenMatrix(level5, this);
			break;
		case 6:
			matrix = new ChickenMatrix(level6, this);
			break;

		default:
			break;
		}
    	
    	return matrix;	
    }
    
    public ChickenMatrix getMatrix() {
    	return this.chicks;
    }
    
    public Shot getShot() {
    	return currShot;
    }

	public void levelEnds() {
		int[] meas = toolBar.levelEnds();
		int shots = meas[0];
		int time = meas[1];
		int score = 600 - 10 * shots - time;
		int finalScore = Math.max(0, score);
		totalScore += finalScore;
		
		final JDialog dialog = new JDialog(this, "Level " + level  + " ended", true);
		dialog.setSize(200,400);
		dialog.setLayout(new BorderLayout());

		JPanel panel = new JPanel(new GridLayout(4, 1));
		panel.add(new JLabel("level time: " + time, SwingConstants.CENTER), BorderLayout.CENTER);
		panel.add(new JLabel("level shots: " + shots, SwingConstants.CENTER), BorderLayout.CENTER);
		panel.add(new JLabel("level score: " + finalScore, SwingConstants.CENTER), BorderLayout.CENTER);
		panel.add(new JLabel("total score: " + totalScore, SwingConstants.CENTER), BorderLayout.CENTER);

		dialog.add(panel);
		
		JButton button = new JButton();
		
		if (level == 6) {
			button.setText("OK");
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dialog.dispose();
				}
			});
		}
		else {
			button.setText("NEXT LEVEL");
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dialog.dispose();
					Level nextLevel = new Level(level + 1, totalScore);
					nextLevel.setVisible(true);
					nextLevel.setLocationRelativeTo(null);
				}
			});
		}

		dialog.add(button, BorderLayout.PAGE_END);

		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		this.dispose();
	}
  
	public void resetIsShot(){
		isShot = false;
	}

}
	

