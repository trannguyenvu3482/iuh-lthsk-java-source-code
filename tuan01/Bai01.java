package tuan01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bai01 extends JFrame implements ActionListener {
	private JButton buttonGiai = new JButton("Giải");
	private JButton buttonXoa = new JButton("Xóa rỗng");
	private JButton buttonThoat = new JButton("Thoát");
	private JTextField txtA = new JTextField();
	private JTextField txtB = new JTextField();
	private JTextField txtC = new JTextField();
	private JTextField txtKQ = new JTextField();

	public Bai01() {
		this.setTitle("^-^");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		createGUI();
	}

	public void createGUI() {
		// North panel
		JPanel northPanel = new JPanel();
		JLabel tieuDe = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC 2");
		tieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		northPanel.setBackground(Color.CYAN);
		northPanel.add(tieuDe);

		// Center panel
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(null);

		int x = 30, y = 10, width = 100, height = 50;

		JLabel labelA = new JLabel("Nhập a:");
		labelA.setBounds(x, y, width, height);
		centerPanel.add(labelA);

		JLabel labelB = new JLabel("Nhập b:");
		y += 50;
		labelB.setBounds(x, y, width, height);
		centerPanel.add(labelB);

		JLabel labelC = new JLabel("Nhập c:");
		y += 50;
		labelC.setBounds(x, y, width, height);
		centerPanel.add(labelC);

		JLabel labelKQ = new JLabel("Ket qua: ");
		y += 50;
		labelKQ.setBounds(x, y, width, height);
		centerPanel.add(labelKQ);

		x = 130;
		y = 20;
		width = 200;
		height = 30;

		txtA.setBounds(x, y, width, height);
		centerPanel.add(txtA);

		y += 50;
		txtB.setBounds(x, y, width, height);
		centerPanel.add(txtB);

		y += 50;
		txtC.setBounds(x, y, width, height);
		centerPanel.add(txtC);

		y += 50;
		txtKQ.setBounds(x, y, width, height);
		centerPanel.add(txtKQ);
		txtKQ.setEditable(false);

		// South panel
		JPanel southPanel = new JPanel();
		// Border
		southPanel.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));

		// Buttons

		southPanel.add(buttonGiai);
		southPanel.add(buttonXoa);
		southPanel.add(buttonThoat);

		buttonGiai.addActionListener(this);
		buttonXoa.addActionListener(this);
		buttonThoat.addActionListener(this);

		this.add(northPanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(southPanel, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(buttonThoat)) {
			System.exit(0);
		} else if (o.equals(buttonXoa)) {
			txtA.setText("");
			txtB.setText("");
			txtC.setText("");
			txtKQ.setText("");
			txtA.grabFocus();
		} else if (o.equals(buttonGiai)) {
			if (!isNumber(txtA) || !isNumber(txtB) || !isNumber(txtC)) {
				txtKQ.setText("Sai định dạng nhập");
			} else {
				int a = Integer.parseInt(txtA.getText());
				int b = Integer.parseInt(txtB.getText());
				int c = Integer.parseInt(txtC.getText());

				float delta = (b * b) - (4 * a * c);

				if (delta < 0) {
					txtKQ.setText("Phương trình vô nghiệm");
				} else if (delta == 0) {
					txtKQ.setText("Nghiệm kép x1 = x2 = " + (-b * 1.0 / (2 * a)));
				} else {
					double x1 = (-b + Math.sqrt(a)) / (2 * a);
					double x2 = (-b - Math.sqrt(a)) / (2 * a);

					txtKQ.setText("2 nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2);
				}
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

	public static void main(String[] args) {
		new Bai01().setVisible(true);
	}
}
