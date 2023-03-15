package tuan02_bai01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JPanel centerPanel = new JPanel();
	JTextField txtMaSo = new JTextField(10);
	JButton btnSaveFile = new JButton("Save file");
	JButton btnReadFile = new JButton("Read file");
	JButton btnTim = new JButton("Tìm");
	JButton btnThem = new JButton("Thêm");
	JButton btnXoaTrang = new JButton("Xóa trắng");
	JButton btnXoa = new JButton("Xóa");
	JButton btnLuu = new JButton("Lưu");
	JTextField txtMaNV = new JTextField(20);
	JTextField txtHo = new JTextField(10);
	JTextField txtTen = new JTextField(10);
	JTextField txtTuoi = new JTextField(10);
	JTextField txtTienLuong = new JTextField(20);
	JRadioButton radNam = new JRadioButton("Nam");
	JRadioButton radNu = new JRadioButton("Nữ");
	JTable tbl;

	DefaultTableModel model;
	DanhSachNhanVien list = new DanhSachNhanVien();

	public GUI() {
		// North panel
		JPanel northPanel = new JPanel();
		JLabel mainTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
		mainTitle.setFont(new Font("Arial", Font.BOLD, 20));
		mainTitle.setForeground(Color.blue);
		northPanel.add(mainTitle);

		// Center panel (Box)

		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();

		JLabel lbMaNV = new JLabel("Mã nhân viên: ");
		JLabel lbHo = new JLabel("Họ: ");
		JLabel lbTen = new JLabel("Tên nhân viên: ");
		JLabel lbTuoi = new JLabel("Tuổi: ");
		JLabel lbTienLuong = new JLabel("Tiền lương: ");
		JLabel lbPhai = new JLabel("Phái: ");

		b1.add(lbMaNV);
		b1.add(txtMaNV);

		lbHo.setPreferredSize(lbMaNV.getPreferredSize());
		b2.add(lbHo);
		b2.add(txtHo);
		b2.add(lbTen);
		b2.add(txtTen);

		lbTuoi.setPreferredSize(lbMaNV.getPreferredSize());
		b3.add(lbTuoi);
		b3.add(txtTuoi);
		b3.add(lbPhai);
		ButtonGroup group = new ButtonGroup();
		group.add(radNam);
		group.add(radNu);
		b3.add(radNam);
		b3.add(radNu);

		lbTienLuong.setPreferredSize(lbMaNV.getPreferredSize());
		b4.add(lbTienLuong);
		b4.add(txtTienLuong);

		b.add(b1);
		b.add(Box.createVerticalStrut(10));
		b.add(b2);
		b.add(Box.createVerticalStrut(10));
		b.add(b3);
		b.add(Box.createVerticalStrut(10));
		b.add(b4);
		b.add(Box.createVerticalStrut(10));

		centerPanel.add(b);

		// Center Panel (Table)
		createTable();

		// South panel
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

		// South - left
		JPanel left = new JPanel();
		left.setBorder(BorderFactory.createLineBorder(Color.gray));
		left.add(new JLabel("Nhập mã số cần tìm"));
		left.add(txtMaSo);
		left.add(btnTim);

		// South - right
		JPanel right = new JPanel();
		right.setBorder(BorderFactory.createLineBorder(Color.gray));
		right.add(btnSaveFile);
		right.add(btnReadFile);
		right.add(btnThem);
		right.add(btnXoaTrang);
		right.add(btnXoa);
		right.add(btnLuu);

		split.add(left);
		split.add(right);

		add(centerPanel, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		add(split, BorderLayout.SOUTH);

		// Action listener
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);
		btnTim.addActionListener(this);
		btnSaveFile.addActionListener(this);
		btnReadFile.addActionListener(this);
	}

	public void createTable() {
		String[] cols = { "Mã NV", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương" };
		model = new DefaultTableModel(cols, 0);
		tbl = new JTable(model);
		tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane tablePane = new JScrollPane(tbl);
		centerPanel.add(tablePane);

		tbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Set dữ liệu
				int row = tbl.getSelectedRow();
				txtMaNV.setText(tbl.getModel().getValueAt(row, 0).toString());
				txtHo.setText(tbl.getModel().getValueAt(row, 1).toString());
				txtTen.setText(tbl.getModel().getValueAt(row, 2).toString());
				txtTuoi.setText(tbl.getModel().getValueAt(row, 4).toString());
				if (tbl.getModel().getValueAt(row, 3).toString().equalsIgnoreCase("Nam")) {
					radNam.setSelected(true);
					radNu.setSelected(false);
				} else {
					radNam.setSelected(false);
					radNu.setSelected(true);
				}
				txtTienLuong.setText(Integer.toString(list.ls.get(row).getTienLuong()));
			}
		});
	}

	// Read txt file
	public DanhSachNhanVien readTxtFile(String part) throws IOException {
		File f = new File(part);

		if (f.exists()) {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] data = line.split(",");
				NhanVien nv = new NhanVien(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]),
						Integer.parseInt(data[5]));
				list.themNhanVien(nv);
			}
			sc.close();
		} else {
			f.createNewFile();
		}
		return list;
	}

	// Write txt file
	public void writeTxtFile(DanhSachNhanVien ds) {

	}

	// Read binary file
	public DanhSachNhanVien readBinFile() {
		return list;

	}

	// Write Binary file
	public void writeBinFile() throws IOException {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream("test.dat");
			oos = new ObjectOutputStream(fos);

			oos.writeObject(list);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			fos.close();
			oos.close();
		}
	}

	public boolean checkNhapLieu() {
		if (txtMaNV.getText().equals("") || txtHo.getText().equals("") || txtTen.getText().equals("")
				|| txtTuoi.getText().equals("") || txtTienLuong.getText().equals("")) {
			return false;
		}

		if (!radNam.isSelected() && !radNu.isSelected()) {
			return false;
		}

		return true;
	}

	public void refreshTable() {
		model.setRowCount(0);
		txtMaNV.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		txtTienLuong.setText("");
		txtMaNV.grabFocus();
		String[] options = { "Nam", "Nữ" };
		JComboBox<String> combobox = new JComboBox<String>(options);

		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "US"));

		TableColumn phaiColumn = tbl.getColumnModel().getColumn(3);
		phaiColumn.setCellEditor(new DefaultCellEditor(combobox));

		for (NhanVien nv : list.ls) {
			Object[] data = { nv.getMaNV(), nv.getHoNV(), nv.getTenSV(), nv.getPhai(), nv.getTuoi(),
					nf.format(nv.getTienLuong()) };
			combobox.setSelectedItem(nv.getPhai());
			model.addRow(data);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnThem)) {
			if (checkNhapLieu()) {
				if (list.timNhanVien(txtMaNV.getText()) == -1) {
					list.themNhanVien(new NhanVien(txtMaNV.getText(), txtHo.getText(), txtTen.getText(),
							(radNam.isSelected() ? "Nam" : "Nữ"), Integer.parseInt(txtTuoi.getText()),
							Integer.parseInt(txtTienLuong.getText())));
					JOptionPane.showMessageDialog(this, "Đã thêm thành công!");
				} else {
					JOptionPane.showMessageDialog(this, "Đã có mã nhân viên này trong hệ thống!");
				}
				refreshTable();
			} else {
				JOptionPane.showMessageDialog(this, "Dữ liệu chưa đúng định dạng!");
			}
		} else if (o.equals(btnXoaTrang)) {
			txtMaNV.setText("");
			txtHo.setText("");
			txtTen.setText("");
			txtTuoi.setText("");
			txtTienLuong.setText("");
			txtMaNV.grabFocus();
			JOptionPane.showMessageDialog(this, "Đã xóa trắng các trường, mời nhập lại!");
		} else if (o.equals(btnXoa)) {
			if (tbl.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Phải chọn dòng cần xóa");
			} else {
				if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa dòng này không", "Canh bao",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					list.xoaNhanVien(tbl.getSelectedRow());
					refreshTable();
				}
			}
		} else if (o.equals(btnLuu)) {
			if (tbl.getSelectedRowCount() == 0) {
				JOptionPane.showMessageDialog(this, "Phải chọn một dòng nào đó để chỉnh sửa!");
				return;
			}

			if (list.timNhanVien(txtMaNV.getText()) == -1) {
				int row = tbl.getSelectedRow();
				list.ls.get(row).setMaNV(txtMaNV.getText());
				list.ls.get(row).setHoNV(txtHo.getText());
				list.ls.get(row).setTenSV(txtTen.getText());
				if (radNam.isSelected()) {
					list.ls.get(row).setPhai("Nam");
				} else {
					list.ls.get(row).setPhai("Nu");
				}
				list.ls.get(row).setTuoi(Integer.parseInt(txtTuoi.getText()));
				list.ls.get(row).setTienLuong(Integer.parseInt(txtTienLuong.getText()));
				JOptionPane.showMessageDialog(this, "Đã cập nhật thành công!");
				refreshTable();
			} else {
				JOptionPane.showMessageDialog(this, "Đã có mã nhân viên này trong hệ thống!");
			}
		} else if (o.equals(btnTim)) {
			if (!txtMaSo.getText().equals("")) {
				int index = list.timNhanVien(txtMaSo.getText());

				if (index != -1) {
					tbl.setRowSelectionInterval(index, index);
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên có mã " + txtMaSo.getText());
				}

			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập vào mã số cần tìm!");
			}
		} else if (o.equals(btnSaveFile)) {
			JOptionPane.showMessageDialog(this, "Đã lưu file!");
		} else if (o.equals(btnReadFile)) {
			JOptionPane.showMessageDialog(this, "Đã đọc file!");
		}
	}

}
