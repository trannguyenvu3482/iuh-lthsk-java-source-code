package tuan04.bai02;

import javax.swing.JFrame;

public class Entry {
	public static void main(String[] args) throws Exception {
		GUI g = new GUI();

		g.setTitle("Using JTable Component & IO Stream");
		g.setSize(800, 500);
		g.setLocationRelativeTo(null);
		g.setResizable(false);
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.setVisible(true);
	}
}
