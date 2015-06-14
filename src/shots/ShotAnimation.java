package shots;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import chickenSoup.ContentPanel;

public class ShotAnimation extends JLabel implements ActionListener {
	  private Timer timer;
	  private int x, y;
	  private final int delay = 200;
	  private JLabel label;
	  private ImageIcon img;
	  private ContentPanel sky;
	  
	  public ShotAnimation(ContentPanel sky){
		this.sky = sky;
		img = new ImageIcon("pictures//shot.png");
		label = new JLabel();
		label.setIcon(img);
		label.setVisible(true);
		x = 0; y = 0;
		timer = new Timer(delay,this);
		timer.start();
	  } 
	  public JLabel getLabel(){
		  return label;
	  }
	  public void paintComponent(Graphics g){
		super.paintComponent(g);
		drawShot(g);
	  }
	  private void drawShot(Graphics g) {
		    g.drawImage(img.getImage(), x, y, sky);
		    Toolkit.getDefaultToolkit().sync();
	  }
	  
	  public void actionPerformed(ActionEvent e){
		if (e.getSource() == timer){
			x = x + 5;  y = y + 5;
			repaint();
	       }
	  }


}
