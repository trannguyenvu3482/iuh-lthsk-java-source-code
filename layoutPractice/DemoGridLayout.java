package week01;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DemoGridLayout extends JFrame {
	public DemoGridLayout() {
		setTitle("Demo Grid Layout");
		setSize(300, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		setLayout(new GridLayout(7, 3, 5, 5)); // 7 rows, 3 columns, h = 5, v = 5
		for (int i = 1; i <= 20; i++) {
			add(new JButton("Button " + i));
		}
	}

	public static void main(String[] args) {
		new DemoGridLayout().setVisible(true);
	}
}
