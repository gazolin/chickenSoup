package chickenSoup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		System.out.println(ans);
		return ans;
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
