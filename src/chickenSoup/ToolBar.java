package chickenSoup;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ToolBar extends JPanel implements ActionListener {
	
	private JLabel shotsText;
	private JLabel shotsLabel;
	private JLabel blackIcon;
	private JLabel redIcon;
	private JLabel blueIcon;
	private JLabel yellowIcon;

	private int shots;
	private JLabel timeLabel;
	private JLabel timeText;
	private int time;
	private Timer timer;
	
	//newGame.setFont(newGame.getFont().deriveFont(22.0f));
	
	public ToolBar() {

		shotsText = new JLabel("shots: ");
		shotsText.setFont(shotsText.getFont().deriveFont(22.0f));
		
		timeText = new JLabel("time: ");
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
		add(Box.createHorizontalStrut(400));
		initShots();

		
	}
	
	public void increaseShots(boolean normal) {
		if(normal){
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			time++;
			timeLabel.setText(time + "");
		}
	}
	
	private void initShots(){
		blackIcon = new JLabel();
		redIcon = new JLabel();
		blueIcon = new JLabel();
		yellowIcon = new JLabel();
		
		ImageIcon img = new ImageIcon("pictures//blackShot.png");
		blackIcon.setIcon(img);
		blackIcon.setVisible(true);
		blackIcon.setBackground(Color.MAGENTA);
		blackIcon.setOpaque(true);
		ImageIcon img1 = new ImageIcon("pictures//redShot.png");
		redIcon.setIcon(img1);
		redIcon.setBackground(Color.MAGENTA);
		redIcon.setVisible(true);
		
		ImageIcon img2 = new ImageIcon("pictures//blueShot.png");
		blueIcon.setIcon(img2);
		blueIcon.setBackground(Color.MAGENTA);
		blueIcon.setVisible(true);
		
		ImageIcon img3 = new ImageIcon("pictures//yellowShot.png");
		yellowIcon.setIcon(img3);
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
		switch (serial){
			
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
	
}
