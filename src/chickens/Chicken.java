package chickens;

import java.awt.Color;
import java.awt.Dimension;

//import javafx.scene.layout.Border;








import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import shots.ShotAnimation;
import sun.audio.AudioData;
import sun.audio.AudioDataStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;


public abstract class Chicken implements Visitor, ActionListener {

	protected Cord cord;
	protected ChickenMatrix matrix;
	protected JLabel label;
	protected String kind;
	protected boolean alive;
	private Timer timer;
	private int explodeTime;
	
	public Chicken(Cord cord, ChickenMatrix matrix) {
		this.cord = cord;
		this.matrix = matrix;
		alive = true;
		label = new JLabel();
	}
	
	public JLabel getLabel() {
		return this.label;
	}
	
	public Cord getCord(){
		return cord;
	}
	
	public String getKind() {
		return this.kind;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void die() {	
		this.label.setVisible(true);
		this.label.setIcon(new ImageIcon("pictures//explosion.png"));
		timer = new Timer(10, this);
		timer.start();
		
		this.matrix.reduceCount();
		this.alive = false;
		
	}

	public boolean checkForHit(JLabel shot) {
		return false;
	}
	
	public void actionPerformed(ActionEvent e) {
		explodeTime += timer.getDelay();
		if(explodeTime == 100){
			this.label.setVisible(false);
			timer.stop();
		
		}
	}

}
