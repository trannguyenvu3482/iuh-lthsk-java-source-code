package tuan03_bai01;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class TableNhanVien extends JFrame {
	private DefaultTableModel model;
	private JTable tbl;

	public TableNhanVien(PhongBan p) {
		String[] cols = { "Mã", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương" };
		model = new DefaultTableModel(cols, 0);
		for (NhanVien n : p.getLs()) {
			String[] data = { n.getMaNV(), n.getHoNV(), n.getTenSV(), n.getPhai(), Integer.toString(n.getTuoi()),
					Integer.toString(n.getTienLuong()) };
			model.addRow(data);
		}

		tbl = new JTable(model);
		tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		setTitle(p.getTenPhongBan());
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		JScrollPane tablePane = new JScrollPane(tbl);
		add(tablePane);

	}
}
