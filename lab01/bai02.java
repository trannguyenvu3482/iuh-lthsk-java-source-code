package lab01;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class bai02 extends JFrame {
	public bai02() {
		this.setTitle("Primes");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		createGUI();
	}

	private void createGUI() {
		setLayout(null);

		// Text field and button
		JTextField txtNhap = new JTextField();
		txtNhap.setBounds(50, 30, 200, 30);
		JButton buttonGenerate = new JButton("Generate");
		buttonGenerate.setBounds(250, 30, 100, 30);
		add(txtNhap);
		add(buttonGenerate);

		// Textarea
		JScrollPane pane = new JScrollPane(new JTextArea());
		pane.setBounds(50, 80, 300, 240);
		add(pane);
	}

	public static void main(String[] args) {
		new bai02().setVisible(true);
	}
}
