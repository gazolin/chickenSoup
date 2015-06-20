package chickenSoup;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class Game extends JFrame implements ActionListener {
	
	private JButton newGame;
	private JSpinner spinner;
	
	
	public Game() {
		super("Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		newGame = new JButton("NEW GAME");
		newGame.addActionListener(this);
		
		SpinnerNumberModel levelModel = new SpinnerNumberModel(1, 1, 6, 1);
		spinner = new JSpinner(levelModel);
		JPanel tPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tPane.setMaximumSize(new Dimension(250, 50));
		tPane.setMinimumSize(new Dimension(250, 50));
		tPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel label = new JLabel("Level:");
		tPane.add(label);
		tPane.add(spinner);
		tPane.add(newGame);
		
		getContentPane().add(tPane);
		
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(newGame)) {
			int level = (Integer)spinner.getValue();
			Level lvl1 = new Level(level);
			lvl1.setVisible(true);
			lvl1.setLocationRelativeTo(null);
			this.dispose();
		}		
	}
}
	
	

