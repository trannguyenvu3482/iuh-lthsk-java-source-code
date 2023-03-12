package week01;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DemoBorderLayout extends JFrame {
	private JButton bn = new JButton("North"), bs = new JButton("South"), be = new JButton("East"),
			bw = new JButton("West"), bc = new JButton("Center");

	public DemoBorderLayout() {
		setTitle("Demo Border Layout");
		setSize(300, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		add(BorderLayout.NORTH, bn);
		add(BorderLayout.WEST, bw);
		add(BorderLayout.SOUTH, bs);
		add(BorderLayout.EAST, be);
		add(BorderLayout.CENTER, bc);

		bn.setBackground(Color.red);
		bn.setForeground(Color.white);
		be.setBackground(Color.blue);
		be.setForeground(Color.white);
		bs.setBackground(Color.red);
		bs.setForeground(Color.white);
		bw.setBackground(Color.blue);
		bw.setForeground(Color.white);
		bc.setBackground(Color.yellow);
		bc.setForeground(Color.black);
	}

	public static void main(String[] args) {
		new DemoBorderLayout().setVisible(true);
	}
}
