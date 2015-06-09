package chickenSoup;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Level1 extends JFrame implements ActionListener  {
	
	private ChickenMatrix chicks;
    public Level1() {
    	
    	chicks = new ChickenMatrix();
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	ContentPanel panel = new ContentPanel(new ImageIcon("stars.gif").getImage(), chicks);
    	setLocationRelativeTo(null);
    	getContentPane().add(panel);
    	

    	chicks.setVisible(true);
    	setVisible(true);
    	pack();
    	
    	

    }
    
    public ChickenMatrix getMatrix() {
    	return this.chicks;
    }
  
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
	

