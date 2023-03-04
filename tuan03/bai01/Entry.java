package bai01;

import javax.swing.JFrame;

public class Entry {
	public static void main(String[] args) {
		GUI gui = new GUI();

		gui.setTitle("^-^");
		gui.setSize(800, 600);
		gui.setLocationRelativeTo(null);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setResizable(false);
		gui.setVisible(true);
	}
}
