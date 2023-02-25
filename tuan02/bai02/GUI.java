package bai02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class GUI extends JFrame implements ActionListener {
	JButton btnClose = new JButton("Đóng chương trình");
	JButton btnChan = new JButton("Tô đen số chẵn");
	JButton btnLe = new JButton("Tô đen số lẻ");
	JButton btnNguyenTo = new JButton("Tô đen số nguyên tố");
	JButton btnBoToDen = new JButton("Bỏ tô đen");
	JButton btnXoaToDen = new JButton("Xóa các giá trị đang tô đen");
	JButton btnTongGiaTri = new JButton("Tổng giá trị trong JList");
	JButton btnNhap = new JButton("Nhập");
	JTextField txtNhap = new JTextField(8);
	JCheckBox chkSoAm = new JCheckBox("Cho nhập số âm");
	JList list;
	
	public GUI() {
		this.setTitle("Thao tác trên JList");
		this.setSize(650, 450);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createGUI();
	}
	
	public void createGUI() {
		// North Panel
		JPanel northPanel = new JPanel();
		JLabel mainTitle = new JLabel("Thao tác trên JList - Checkbox");
		mainTitle.setFont(new Font("Arial", Font.BOLD, 30));
		mainTitle.setForeground(Color.BLUE);
		northPanel.add(mainTitle);
		
		// Center Panel
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(null);
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		centerPanel.add(leftPanel);
		centerPanel.add(rightPanel);
		
		// Center - Left Panel
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		Box b = Box.createVerticalBox();
		TitledBorder leftBorder = new TitledBorder(new LineBorder(Color.red), "Chọn tác vụ");
		leftPanel.setBounds(0, 0, 250, 325);
		leftPanel.setBorder(leftBorder);
		b.add(btnChan);
		b.add(Box.createVerticalStrut(10));
		b.add(btnLe);
		b.add(Box.createVerticalStrut(10));
		b.add(btnNguyenTo);
		b.add(Box.createVerticalStrut(10));
		b.add(btnBoToDen);
		b.add(Box.createVerticalStrut(10));
		b.add(btnXoaToDen);
		b.add(Box.createVerticalStrut(10));
		b.add(btnTongGiaTri);
		b.add(Box.createVerticalStrut(10));
		leftPanel.add(b);
		
		
		// Center - Right Panel
		TitledBorder rightBorder = new TitledBorder(new LineBorder(Color.red), "Nhập thông tin");
		rightPanel.setBounds(250, 0, 382, 325);
		rightPanel.setBorder(rightBorder);
		
		JPanel p1 = new JPanel();
		p1.add(btnNhap);
		p1.add(txtNhap);
		p1.add(chkSoAm);
		
		// JList
		DefaultListModel model = new DefaultListModel();
		list = new JList(model);
		JScrollPane listPane = new JScrollPane(list);
		listPane.setPreferredSize(new Dimension(360, 255));
		
		rightPanel.add(p1);
		rightPanel.add(listPane);
		
		// South Panel
		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.LIGHT_GRAY);
		southPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
		southPanel.add(btnClose);
		
		// Add panel
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if (o.equals(btnClose)) {
			System.exit(0);
		} else if (o.equals(btnNhap)) {
			if (txtNhap.getText().equals("") || !isNumber(txtNhap.getText())) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập vào một số nguyên!");
			} else {
				if (!chkSoAm.isSelected() && Integer.parseInt(txtNhap.getText()) < 0) {
					JOptionPane.showMessageDialog(this, "Không cho phép nhập số âm!");
				} else {
					list.add
				}
			}
		}
	}
	
	public boolean isNumber(String txt) {
		try {
			int num = Integer.parseInt(txt);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		new GUI().setVisible(true);
	}
}
