package tuan01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Bai02 extends JFrame implements ActionListener {
	private JTextArea textA = new JTextArea();
	private JButton buttonGenerate = new JButton("Generate");
	private JTextField txtNhap = new JTextField();

	public Bai02() {
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
		txtNhap.setBounds(50, 30, 200, 30);
		buttonGenerate.setBounds(250, 30, 100, 30);
		add(txtNhap);
		add(buttonGenerate);

		// Textarea
		JScrollPane pane = new JScrollPane(textA);
		pane.setBounds(50, 80, 300, 240);
		add(pane);

		// Add action listener
		buttonGenerate.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(buttonGenerate)) {
			if (!isNumber(txtNhap) || Integer.parseInt(txtNhap.getText()) <= 0) {
				textA.setText("Dữ liệu không hợp lệ, hãy nhập một số nguyên dương");
			} else {
				int n = Integer.parseInt(txtNhap.getText());

				String result = "";

				int count = 0, num = 2;
				while (count < n) {
					if (isPrime(num)) {
						result += (num + "\n");
						count++;
					}
					num++;
				}

				textA.setText(result);
			}
		}

	}

	public boolean isNumber(JTextField tf) {
		boolean result;
		try {
			Integer.parseInt(tf.getText());

			return true;
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		new Bai02().setVisible(true);
	}
}
