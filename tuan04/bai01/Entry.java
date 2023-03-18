package tuan04.bai01;

import javax.swing.JFrame;

public class Entry {
	public static void main(String[] args) throws Exception {
		GUI g = new GUI();

		g.setTitle("Quản lý sách");
		g.setSize(900, 500);
		g.setLocationRelativeTo(null);
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.setResizable(false);
		g.setVisible(true);
	}
}
