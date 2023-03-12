package week01;

import javax.swing.JDialog;

public class DemoJDialog extends JDialog {
	public DemoJDialog() {
		setTitle("Demo JDialog");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300, 200);
		setResizable(false);
	}

	public static void main(String[] args) {
		new DemoJDialog().setVisible(true);
	}
}
