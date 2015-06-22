package chickens;

import java.awt.Color;
import java.awt.Dimension;

//import javafx.scene.layout.Border;








import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import shots.ShotAnimation;
import sun.audio.AudioData;
import sun.audio.AudioDataStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;


public abstract class Chicken implements Visitor {

	protected Cord cord;
	protected ChickenMatrix matrix;
	protected JLabel label;
	protected String kind;
	protected boolean alive;
	
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
		AudioPlayer player = AudioPlayer.player;;
		AudioStream stream;
		AudioDataStream sound;
		AudioData data = null;
		try {
			stream = new AudioStream(new FileInputStream("music//glass.wav"));
			data = stream.getData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sound = new AudioDataStream(data);
		player.start(sound);
//		this.button.setIcon(new ImageIcon("explosion.png"));
		this.label.setVisible(false);
		
		//matrix.remove(this.label);	//added this so later we can shoot where no chicken exists (maybe just need a flag)
		this.matrix.reduceCount();
		this.alive = false;
	}

	public boolean checkForHit(JLabel shot) {
		
		
		return false;
	}

}
