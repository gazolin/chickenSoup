package chickenSoup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ToolBar extends JPanel implements ActionListener {
	
	private JLabel shotsText;
	private JLabel shotsLabel;
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
	}
	
	public void increaseShots() {
		shots++;
		shotsLabel.setText(shots + "");
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
	
}
