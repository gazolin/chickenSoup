package chickenSoup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class GamePanel extends JPanel implements ActionListener{

	private Image img;
	private JLabel logo;
	private JSpinner spinner;
	private JButton newGame;
	private JButton table;
	private Game game;

	
	
	public GamePanel(Image img, Game game){
		
		this.img =img;
		this.game = game;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		
		
		logo = new JLabel();
		logo.setIcon(new ImageIcon("pictures//logo.png"));
	
		table = new JButton("WINNER TABLE");
		table.setFont(new Font("lucida sans regular", Font.BOLD, 22));
		table.addActionListener(this);
		
		newGame = new JButton();
		newGame.setIcon(new ImageIcon("pictures//playnowgreen.png"));
		newGame.addActionListener(this);
		SpinnerNumberModel levelModel = new SpinnerNumberModel(1, 1, 6, 1);
		spinner = new JSpinner(levelModel);
	
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(logo);
		logo.setAlignmentX(CENTER_ALIGNMENT);
		
		add(Box.createVerticalStrut(50));
		
		spinner.setMaximumSize(new Dimension(50, 50));
		spinner.setMinimumSize(new Dimension(50, 50));
		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinner);
	    JTextField tf = editor.getTextField();
	    tf.setHorizontalAlignment(JTextField.CENTER);
	    tf.setFont(new Font("lucida sans regular", Font.BOLD, 22));
	    spinner.setEditor(editor);
	    JLabel lvlLabel = new JLabel("Play from Lvl: ");
		lvlLabel.setFont(new Font("lucida sans regular", Font.BOLD, 22));
		lvlLabel.setForeground(Color.yellow);
		JPanel lvlPicker = new JPanel();
		//lvlPicker.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		lvlPicker.add(lvlLabel);
		lvlPicker.add(spinner);
		lvlPicker.setOpaque(false);
		lvlPicker.setMaximumSize(new Dimension(200, 100));
		lvlPicker.setMinimumSize(new Dimension(200, 100));
		
		add(lvlPicker);

		newGame.setAlignmentX(CENTER_ALIGNMENT);
		newGame.setBackground(Color.MAGENTA);
		newGame.setOpaque(false);
		newGame.setBorderPainted(false);
		
		add(newGame);
		
		add(Box.createVerticalStrut(100));
		table.setAlignmentX(CENTER_ALIGNMENT);
		add(table);
		setVisible(true);
	
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(newGame)) {
			int level = (Integer)spinner.getValue();
			Level lvl1 = new Level(level, 0, false);
			lvl1.setVisible(true);
			lvl1.setLocationRelativeTo(null);
			game.killMusic();
			game.dispose();
		}
		
		if (e.getSource().equals(table)) {
			Table.table().showTable();
		}
	}
	
}
