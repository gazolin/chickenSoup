package chickenSoup;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Game extends JFrame {

	public Game() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(new GamePanel(new ImageIcon("pictures//stars.gif").getImage(), this));	
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}


	

}
	
	

