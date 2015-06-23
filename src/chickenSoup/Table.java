package chickenSoup;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Table {

	private final int SIZE = 5;
	private final String fileName = "table\\table.txt";
	
	private static Table table = null;
	private DateFormat dateFormat;
	
	private String[] games;
	
	private Table() {
		games = new String[SIZE];
		dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	}
	
	public static Table table() {
		if (table == null) {
			table = new Table();
		}
		return table;
	}
	
	public void addToTable(String name, int score) {
		read();
		
		String date = dateFormat.format(new Date());
		String line = name + "\t" + score + "\t" + date;
		
		for (int i = SIZE - 1; i > 0; i--) {
			games[i] = games[i-1];
		}
		games[0] = line;
		
		write(gamesString());
	}
	
	public String gamesString() {
		String ans = "";
		for (int i = 0; i < SIZE; i++) {
			ans += (games[i] != null) ? games[i] + "\n" : "";
		}
		return ans;
	}
	
	public void showTable() {
		read();
		
		final JDialog dialog = new JDialog();
		dialog.setSize(270,310);
		dialog.setLayout(new GridLayout(7, 3));
		
		JLabel nameLabel = new JLabel("NAME");
		nameLabel.setFont(nameLabel.getFont().deriveFont(16.0f));
		JLabel scoreLabel = new JLabel("SCORE");
		scoreLabel.setFont(scoreLabel.getFont().deriveFont(16.0f));
		JLabel timeLabel = new JLabel("TIME");
		timeLabel.setFont(timeLabel.getFont().deriveFont(16.0f));
		
		dialog.add(nameLabel);
		dialog.add(scoreLabel);
		dialog.add(timeLabel);
		
		for (int i= 0; i < SIZE; i++) {
			if (games[i] == null)
				continue;
			StringTokenizer tokenizer = new StringTokenizer(games[i], "\t");
			dialog.add(new JLabel(tokenizer.nextToken()));
			dialog.add(new JLabel(tokenizer.nextToken()));
			dialog.add(new JLabel(tokenizer.nextToken()));
		}
		
		JButton exit = new JButton("MENU");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialog.dispose();				
			}
		});
		dialog.add(new JLabel());
		dialog.add(exit);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}
	
	public void write(String toWrite) {
		BufferedWriter out;
		
		try {
			out = new BufferedWriter(new FileWriter(fileName));
			out.write(toWrite);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void read() {
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(fileName));

			for (int i = 0; i < SIZE; i++) {
				games[i] = in.readLine();
			}
			
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
