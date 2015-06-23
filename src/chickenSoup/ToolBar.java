package chickenSoup;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class ToolBar extends JPanel implements ActionListener {
	
	private JLabel shotsText;
	private JLabel shotsLabel;
	private JLabel blackIcon;
	private JLabel redIcon;
	private JLabel blueIcon;
	private JLabel yellowIcon;
	private JLabel timeLabel;
	private JLabel timeText;
	private JLabel lvlName;
	private JLabel muteLabel;

	private int shots;
	private int time;
	private Timer timer;	
	private Level level;
	
	public ToolBar(Level lvl) {
		
		this.level = lvl;

		lvlName = new JLabel("Level: " + lvl.getLevel());
		lvlName.setFont(lvlName.getFont().deriveFont(22.0f));
		
		shotsText = new JLabel("Shots: ");
		shotsText.setFont(shotsText.getFont().deriveFont(22.0f));
		
		timeText = new JLabel("Time: ");
		timeText.setFont(timeText.getFont().deriveFont(22.0f));
		
		shots = 0;
		shotsLabel = new JLabel(shots + "");
		shotsLabel.setFont(shotsLabel.getFont().deriveFont(22.0f));
		
		time = 0;
		timeLabel = new JLabel(time + "");
		timeLabel.setFont(timeLabel.getFont().deriveFont(22.0f));
		
		timer = new Timer(1000, this);
		timer.start();
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(shotsText);
		add(shotsLabel);
		add(Box.createHorizontalStrut(100));
		add(timeText);
		add(timeLabel);
		add(Box.createHorizontalStrut(150));
		add(lvlName);
		add(Box.createHorizontalStrut(180));
		initShots();
		add(Box.createHorizontalStrut(10));
		initMute();

	}
	
	public void increaseShots(boolean normal) {
		if(normal) {
			shots++;
			shotsLabel.setText(shots + "");
		}
	}
	
	public int[] levelEnds() {
		timer.stop();
		
		int[] ans = new int[2];
		ans[0] = shots;
		ans[1] = time;
		
		return ans;		
	}

	private void initMute() {
		ImageIcon muteImg = new ImageIcon("pictures//mute.png");
		muteLabel = new JLabel();
		muteLabel.setIcon(muteImg);
		muteLabel.setVisible(true);
		
		muteLabel.addMouseListener(new MouseListener() {			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				level.inverseMute();				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
			
		add(muteLabel);
	}
	
	private void initShots(){
		blackIcon = new JLabel();
		redIcon = new JLabel();
		blueIcon = new JLabel();
		yellowIcon = new JLabel();
		
		ImageIcon black = new ImageIcon("pictures//blackShot.png");
		blackIcon.setIcon(black);
		blackIcon.setVisible(true);
		blackIcon.setBackground(Color.MAGENTA);
		blackIcon.setOpaque(true);
		
		ImageIcon red = new ImageIcon("pictures//redShot.png");
		redIcon.setIcon(red);
		redIcon.setBackground(Color.MAGENTA);
		redIcon.setVisible(true);
		
		ImageIcon blue = new ImageIcon("pictures//blueShot.png");
		blueIcon.setIcon(blue);
		blueIcon.setBackground(Color.MAGENTA);
		blueIcon.setVisible(true);
		
		ImageIcon yellow = new ImageIcon("pictures//yellowShot.png");
		yellowIcon.setIcon(yellow);
		yellowIcon.setBackground(Color.MAGENTA);
		yellowIcon.setVisible(true);
		
		add(blackIcon);
		add(Box.createHorizontalStrut(30));

		add(redIcon);
		add(Box.createHorizontalStrut(30));

		add(blueIcon);
		add(Box.createHorizontalStrut(30));

		add(yellowIcon);
		
	}
	
	public void setShot (int serial){
		switch (serial) {

		case 1:
			blackIcon.setOpaque(true);
			redIcon.setOpaque(false);
			blueIcon.setOpaque(false);
			yellowIcon.setOpaque(false);
			break;
		case 2:
			blackIcon.setOpaque(false);
			redIcon.setOpaque(true);
			blueIcon.setOpaque(false);
			yellowIcon.setOpaque(false);
			break;

		case 3:
			blackIcon.setOpaque(false);
			redIcon.setOpaque(false);
			blueIcon.setOpaque(true);
			yellowIcon.setOpaque(false);
			break;

		case 4:
			blackIcon.setOpaque(false);
			redIcon.setOpaque(false);
			blueIcon.setOpaque(false);
			yellowIcon.setOpaque(true);
			break;
		}

		repaint();	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			time++;
			timeLabel.setText(time + "");
		}
	}
	
}
