package tuan04.bai01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame implements ActionListener {
	private JButton btnThem = new JButton("Thêm");
	private JButton btnXoaRong = new JButton("Xóa rỗng");
	private JButton btnSua = new JButton("Sửa");
	private JButton btnXoa = new JButton("Xóa");
	private JTextField txtMaSach = new JTextField(10);
	private JTextField txtTuaSach = new JTextField(20);
	private JTextField txtNamXB = new JTextField(20);
	private JTextField txtSoTrang = new JTextField(20);
	private JTextField txtISBN = new JTextField(20);
	private JTextField txtTacGia = new JTextField(20);
	private JTextField txtNhaXB = new JTextField(20);
	private JTextField txtDonGia = new JTextField(20);
	private JComboBox<String> boxTim = new JComboBox<String>();
	private JTable tbl;
	private DefaultTableModel model;
	private ListSach list = new ListSach();

	public GUI() throws Exception {
		setLayout(null);
		// Top panel
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 885, 200);
		topPanel.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();

		JLabel lblMaSach = new JLabel("Mã sách: ");
		JLabel lblTuaSach = new JLabel("Tựa sách: ");
		JLabel lblNamXB = new JLabel("Năm xuất bản: ");
		JLabel lblSoTrang = new JLabel("Số trang: ");
		JLabel lblISBN = new JLabel("International Standard Book Number (ISBN): ");
		JLabel lblTacGia = new JLabel("Tác giả: ");
		JLabel lblNhaXB = new JLabel("Nhà xuất bản: ");
		JLabel lblDonGia = new JLabel("Đơn giá: ");

		lblMaSach.setPreferredSize(lblNhaXB.getPreferredSize());
		b1.add(lblMaSach);
		b1.add(txtMaSach);
		b1.add(Box.createHorizontalStrut(500));

		lblTuaSach.setPreferredSize(lblNhaXB.getPreferredSize());
		b2.add(lblTuaSach);
		b2.add(txtTuaSach);
		b2.add(Box.createHorizontalStrut(30));
		lblTacGia.setPreferredSize(lblNhaXB.getPreferredSize());
		b2.add(lblTacGia);
		b2.add(txtTacGia);

		b3.add(lblNamXB);
		b3.add(txtNamXB);
		b3.add(Box.createHorizontalStrut(30));
		b3.add(lblNhaXB);
		b3.add(txtNhaXB);

		lblSoTrang.setPreferredSize(lblNhaXB.getPreferredSize());
		b4.add(lblSoTrang);
		b4.add(txtSoTrang);
		b4.add(Box.createHorizontalStrut(30));
		lblDonGia.setPreferredSize(lblNhaXB.getPreferredSize());
		b4.add(lblDonGia);
		b4.add(txtDonGia);

		b5.add(lblISBN);
		b5.add(txtISBN);
		b5.add(Box.createHorizontalStrut(452));

		b.add(Box.createVerticalStrut(15));
		b.add(b1);
		b.add(Box.createVerticalStrut(10));
		b.add(b2);
		b.add(Box.createVerticalStrut(10));
		b.add(b3);
		b.add(Box.createVerticalStrut(10));
		b.add(b4);
		b.add(Box.createVerticalStrut(10));
		b.add(b5);
		b.add(Box.createVerticalStrut(15));

		topPanel.add(b);

		// Mid panel
		JPanel middlePanel = new JPanel();
		middlePanel.setBounds(50, 200, 785, 50);

		JLabel lblTim = new JLabel("Tìm theo mã sách");

		middlePanel.add(btnThem);
		middlePanel.add(btnXoaRong);
		middlePanel.add(btnSua);
		middlePanel.add(btnXoa);
		middlePanel.add(lblTim);
		middlePanel.add(boxTim);

		// Bottom panel
		JScrollPane bottomPanel;
		String[] cols = { "Mã sách", "Tựa sách", "Tác giả", "Năm xuất bản", "Nhà xuất bản", "Số trang", "Đơn giá",
				"ISBN" };
		model = new DefaultTableModel(cols, 0);
		tbl = new JTable(model);
		tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bottomPanel = new JScrollPane(tbl);
		bottomPanel.setBounds(0, 250, 885, 210);
		bottomPanel.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));

		// Add all panels to JFrame
		add(topPanel);
		add(middlePanel);
		add(bottomPanel);

		// Add event listener for buttons
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);

		loadFile("./src/data/DanhMucSach.txt");

		// Table handler
		tbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMaSach.setText((String) model.getValueAt(tbl.getSelectedRow(), 0));
				txtTuaSach.setText((String) model.getValueAt(tbl.getSelectedRow(), 1));
				txtTacGia.setText((String) model.getValueAt(tbl.getSelectedRow(), 2));
				txtNamXB.setText((String) model.getValueAt(tbl.getSelectedRow(), 3));
				txtNhaXB.setText((String) model.getValueAt(tbl.getSelectedRow(), 4));
				txtSoTrang.setText((String) model.getValueAt(tbl.getSelectedRow(), 5));
				txtDonGia.setText((String) model.getValueAt(tbl.getSelectedRow(), 6));
				txtISBN.setText((String) model.getValueAt(tbl.getSelectedRow(), 7));
			}
		});

		// Combobox handler
		boxTim.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				Sach s = list.timSach((String) e.getItem());
				if (s != null) {
					tbl.setRowSelectionInterval(list.getLs().indexOf(s), list.getLs().indexOf(s));
					
					if (tbl.getSelectedRow() != -1) {
						txtMaSach.setText((String) model.getValueAt(tbl.getSelectedRow(), 0));
						txtTuaSach.setText((String) model.getValueAt(tbl.getSelectedRow(), 1));
						txtTacGia.setText((String) model.getValueAt(tbl.getSelectedRow(), 2));
						txtNamXB.setText((String) model.getValueAt(tbl.getSelectedRow(), 3));
						txtNhaXB.setText((String) model.getValueAt(tbl.getSelectedRow(), 4));
						txtSoTrang.setText((String) model.getValueAt(tbl.getSelectedRow(), 5));
						txtDonGia.setText((String) model.getValueAt(tbl.getSelectedRow(), 6));
						txtISBN.setText((String) model.getValueAt(tbl.getSelectedRow(), 7));
					}
				}
			}
		});
	}
	
	public void loadFile(String directory) throws Exception {
		// Add data to database, show to table using txt file
				File f = new File(directory);
				
				if (f.exists()) {
					Scanner sc = new Scanner(f);
					while (sc.hasNextLine()) {
						String line = sc.nextLine();
						String[] data = line.split(";");
						list.themSach(new Sach(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4],
								Integer.parseInt(data[5]), Double.parseDouble(data[6]), data[7]));
					}
					JOptionPane.showMessageDialog(this, "Đã nhập file thành công");
					sc.close();
				} else {
					JOptionPane.showMessageDialog(this, "Nhập file không thành công");
					f.createNewFile();
				}

				for (Sach s : list.getLs()) {
					String[] data = { s.getMaSach(), s.getTuaSach(), s.getTacGia(), Integer.toString(s.getNamXB()),
							s.getNhaXB(), Integer.toString(s.getSoTrang()), Double.toString(s.getDonGia()), s.getISBN() };
					model.addRow(data);

					boxTim.addItem(data[0]);
				}
	}
	
	public void saveFile(String directory) {
		try {
			File f = new File(directory);
			FileWriter writer = new FileWriter(f);
			
			for (Sach s : list.getLs()) {
				String st = s.getMaSach() + ";" + s.getTuaSach() + ";" + s.getTacGia() + ";" + s.getNamXB() + ";" + s.getNhaXB() + ";" + s.getSoTrang() + ";" + s.getDonGia() + ";" + s.getISBN();
				writer.write(st);
				writer.write("\n");
			}
			
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void refreshTable() {
		boxTim.removeAllItems();
		model.setRowCount(0);

		for (Sach s : list.getLs()) {
			String[] data = { s.getMaSach(), s.getTuaSach(), s.getTacGia(), Integer.toString(s.getNamXB()),
					s.getNhaXB(), Integer.toString(s.getSoTrang()), Double.toString(s.getDonGia()), s.getISBN() };
			model.addRow(data);
			boxTim.addItem(data[0]);
		}
	}

	public boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void xoaRong() {
		txtMaSach.setText("");
		txtTuaSach.setText("");
		txtNamXB.setText("");
		txtSoTrang.setText("");
		txtISBN.setText("");
		txtTacGia.setText("");
		txtNhaXB.setText("");
		txtDonGia.setText("");
	}

	public boolean checkInputFields() {
		if (txtMaSach.getText().equals("") || txtTuaSach.getText().equals("") || txtNamXB.getText().equals("")
				|| txtSoTrang.getText().equals("") || txtISBN.getText().equals("") || txtTacGia.getText().equals("")
				|| txtNhaXB.getText().equals("") || txtDonGia.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Không trường nào được phép rỗng");
			return false;
		}

		if (!isNumber(txtSoTrang.getText()) || !isNumber(txtNamXB.getText())) {
			JOptionPane.showMessageDialog(this, "Số trang và năm xuất bản phải là số");
			return false;
		}

		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnThem)) {
			if (!checkInputFields())
				return;

			try {
				boolean result = list.themSach(new Sach(txtMaSach.getText(), txtTuaSach.getText(), txtTacGia.getText(),
						Integer.parseInt(txtNamXB.getText()), txtNhaXB.getText(),
						Integer.parseInt(txtSoTrang.getText()), Double.parseDouble(txtDonGia.getText()),
						txtISBN.getText()));

				if (result) {
					saveFile("./src/data/DanhMucSach.txt");
					JOptionPane.showMessageDialog(this, "Đã thêm dữ liệu thành công");
					xoaRong();
				} else {
					JOptionPane.showMessageDialog(this, "Đã có lỗi trong lúc thêm");
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}

			refreshTable();

		} else if (o.equals(btnXoa)) {
			if (tbl.getSelectedRow() != -1) {
				int selection = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dòng này?", "Xác nhận", JOptionPane.YES_NO_OPTION);

				if (selection == JOptionPane.YES_OPTION) {
					Sach s = list.timSach((String) model.getValueAt(tbl.getSelectedRow(), 0));
					list.xoaSach(s);
					saveFile("./src/data/DanhMucSach.txt");
					JOptionPane.showMessageDialog(this, "Đã xóa thành công");
					tbl.removeRowSelectionInterval(tbl.getSelectedRow(), tbl.getSelectedRow());
					xoaRong();
					refreshTable();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Phải chọn một dòng để xóa");
			}
		} else if (o.equals(btnXoaRong)) {
			xoaRong();
		} else if (o.equals(btnSua)) {
			if (tbl.getSelectedRow() != -1) {
				if (!checkInputFields())
					return;

				try {
					list.getLs().get(tbl.getSelectedRow()).setMaSach(txtMaSach.getText());
					list.getLs().get(tbl.getSelectedRow()).setTuaSach(txtTuaSach.getText());
					list.getLs().get(tbl.getSelectedRow()).setNamXB(Integer.parseInt(txtNamXB.getText()));
					list.getLs().get(tbl.getSelectedRow()).setSoTrang(Integer.parseInt(txtSoTrang.getText()));
					list.getLs().get(tbl.getSelectedRow()).setISBN(txtISBN.getText());
					list.getLs().get(tbl.getSelectedRow()).setTacGia(txtTacGia.getText());
					list.getLs().get(tbl.getSelectedRow()).setNhaXB(txtNhaXB.getText());
					list.getLs().get(tbl.getSelectedRow()).setDonGia(Double.parseDouble(txtDonGia.getText()));

					JOptionPane.showMessageDialog(this, "Đã sửa thành công");
					xoaRong();
					refreshTable();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "Đã có lỗi trong lúc sửa, hãy kiểm tra lại dữ liệu");
				}

			} else {
				JOptionPane.showMessageDialog(this, "Phải chọn một dòng để sửa");
			}
		}
	}
}