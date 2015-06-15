package shots;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import chickenSoup.ContentPanel;

public class ShotAnimation extends JLabel {

	  private JLabel label;
	  private ImageIcon img;
	  private ContentPanel sky;
	  
	  public ShotAnimation(ContentPanel sky){
		this.sky = sky;
		img = new ImageIcon("pictures//shot.png");
		label = new JLabel();
		label.setIcon(img);
		label.setVisible(true);
	  } 
	  public JLabel getLabel(){
		  return label;
	  }



}
