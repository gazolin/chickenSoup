package chickenSoup;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Rules extends JFrame {
	
	public Rules(){
		setIconImage(new ImageIcon("pictures//flu.png").getImage());
		setResizable(false);
		setDefaultCloseOperation(1);
		getContentPane().add(new RulesPanel(new ImageIcon("pictures//rules.png").getImage()));	
		setVisible(true);
		pack();
		setLocationRelativeTo(null);

	}
}
