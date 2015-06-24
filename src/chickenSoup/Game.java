package chickenSoup;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

@SuppressWarnings("serial")
public class Game extends JFrame {
	

	private AudioPlayer player;
	private AudioStream stream;
	private ContinuousAudioDataStream loop;
	private AudioData data = null;
	
	
	public Game() {
		
		this.player = AudioPlayer.player;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(new GamePanel(new ImageIcon("pictures//stars.gif").getImage(), this));	
		setVisible(true);
		playMusic();	
		pack();
		setLocationRelativeTo(null);
	}
	
	
	private void playMusic() {
		
		try {
			stream = new AudioStream(new FileInputStream("music//POL-minuet-short.wav"));
			data = stream.getData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		loop = new ContinuousAudioDataStream(data);
		player.start(loop);
	}
	
	public void killMusic(){
	
		player.stop(loop);
		
	}
	

}
	
	

