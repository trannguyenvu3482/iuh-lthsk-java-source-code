package week01;

import javax.swing.JFrame;

public class DemoJFrame2 extends JFrame {
	public DemoJFrame2() {
		setTitle("Demo JFrame 2");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

	public static void main(String[] args) {
		new DemoJFrame2().setVisible(true);
	}
}
