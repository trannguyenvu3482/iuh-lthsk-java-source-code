package week01;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DemoFlowLayout extends JFrame {
	public DemoFlowLayout() {
		setTitle("Demo Flow Layout");
		setSize(300, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new FlowLayout());
		for (int i = 1; i <= 20; i++) {
			add(new JButton("Button " + i));
		}
	}

	public static void main(String[] args) {
		new DemoFlowLayout().setVisible(true);
	}
}
