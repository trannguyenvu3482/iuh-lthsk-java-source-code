package tuan01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Bai03 extends JFrame implements ActionListener {
	private JButton buttonGiai = new JButton("Giải");
	private JButton buttonXoa = new JButton("Xóa");
	private JButton buttonThoat = new JButton("Thoát");
	private JTextField txtA = new JTextField();
	private JTextField txtB = new JTextField();
	private JTextField txtKQ = new JTextField();
	private JRadioButton btnCong = new JRadioButton("Cộng");
	private JRadioButton btnTru = new JRadioButton("Trừ");
	private JRadioButton btnNhan = new JRadioButton("Nhân");
	private JRadioButton btnChia = new JRadioButton("Chia");

	public Bai03() {
		this.setTitle("Cộng - Trừ - Nhân - Chia");
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		createGUI();
	}

	private void createGUI() {
		// North panel
		JPanel northPanel = new JPanel();
		JLabel title = new JLabel("Cộng Trừ Nhân Chia");
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Arial", Font.BOLD, 20));
		northPanel.add(title);

		// Center panel
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(null);
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();

		// Left center panel
		leftPanel.setBackground(Color.LIGHT_GRAY);
		leftPanel.setBounds(0, 10, 100, 300);
		leftPanel.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));

		buttonGiai.setPreferredSize(new Dimension(80, 30));
		buttonXoa.setPreferredSize(new Dimension(80, 30));
		buttonThoat.setPreferredSize(new Dimension(80, 30));
		leftPanel.add(buttonGiai);
		leftPanel.add(buttonXoa);
		leftPanel.add(buttonThoat);

		centerPanel.add(leftPanel);

		// Right center panel
		rightPanel.setBounds(100, 10, 385, 300);
		rightPanel.setLayout(null);
		rightPanel.setBorder(BorderFactory.createTitledBorder("Tính toán"));

		int x = 40, y = 10, width = 100, height = 50;
		JLabel labelA = new JLabel("Nhập a: ");
		labelA.setBounds(x, y, width, height);
		JLabel labelB = new JLabel("Nhập b: ");
		y += 50;
		labelB.setBounds(x, y, width, height);
		y += 150;
		JLabel labelKQ = new JLabel("Kết quả: ");
		labelKQ.setBounds(x, y, width, height);

		rightPanel.add(labelA);
		rightPanel.add(labelB);
		rightPanel.add(labelKQ);

		x = 100;
		y = 20;
		width = 250;
		height = 30;
		txtA.setBounds(x, y, width, height);
		y += 50;
		txtB.setBounds(x, y, width, height);
		y += 150;
		txtKQ.setBounds(x, y, width, height);
		txtKQ.setEditable(false);
		rightPanel.add(txtA);
		rightPanel.add(txtB);
		rightPanel.add(txtKQ);

		JPanel panelPhepToan = new JPanel();
		panelPhepToan.setLayout(new GridLayout(2, 2));
		panelPhepToan.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		panelPhepToan.setBounds(100, 100, 250, 100);

		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(btnCong);
		btnGroup.add(btnTru);
		btnGroup.add(btnNhan);
		btnGroup.add(btnChia);

		panelPhepToan.add(btnCong);
		panelPhepToan.add(btnTru);
		panelPhepToan.add(btnNhan);
		panelPhepToan.add(btnChia);

		// Mặc định chọn chế độ Cộng
		btnCong.setSelected(true);

		rightPanel.add(panelPhepToan);

		centerPanel.add(rightPanel);

		// South panel
		JPanel southPanel = new JPanel();
		southPanel.setPreferredSize(new Dimension(400, 50));
		southPanel.setBackground(Color.PINK);

		JPanel bluePanel = new JPanel();
		bluePanel.setBackground(Color.BLUE);
		bluePanel.setPreferredSize(new Dimension(20, 20));

		JPanel redPanel = new JPanel();
		redPanel.setBackground(Color.RED);
		redPanel.setPreferredSize(new Dimension(20, 20));

		JPanel yellowPanel = new JPanel();
		yellowPanel.setBackground(Color.YELLOW);
		yellowPanel.setPreferredSize(new Dimension(20, 20));

		southPanel.add(bluePanel);
		southPanel.add(redPanel);
		southPanel.add(yellowPanel);

		// Add panels to Border layout
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		add(centerPanel, BorderLayout.CENTER);

		// Add action listeners
		buttonGiai.addActionListener(this);
		buttonXoa.addActionListener(this);
		buttonThoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		// Xử lí các button
		if (o.equals(buttonThoat)) {
			System.exit(0);
		} else if (o.equals(buttonXoa)) {
			txtA.setText("");
			txtB.setText("");
			txtKQ.setText("");
			txtA.grabFocus();
		} else if (o.equals(buttonGiai)) {
			if (!isNumber(txtA) || !isNumber(txtB)) {
				txtKQ.setText("Sai định dạng nhập");
			} else {
				double a = Double.parseDouble(txtA.getText());
				double b = Double.parseDouble(txtB.getText());

				if (btnCong.isSelected()) {
					txtKQ.setText(Double.toString(a + b));
				} else if (btnTru.isSelected()) {
					txtKQ.setText(Double.toString(a - b));
				} else if (btnNhan.isSelected()) {
					txtKQ.setText(Double.toString(a * b));
				} else if (btnChia.isSelected()) {
					txtKQ.setText(Double.toString(a / b));
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
		new Bai03().setVisible(true);
	}
}
