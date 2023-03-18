package tuan03_bai01;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class GUI extends JFrame {
	JTree tree;
	PhongBan dsPhongKyThuat = new PhongBan("001", "Phòng kỹ thuật");
	DefaultTableModel model;
	JTable tbl;
	JDialog dialog = new JDialog();
	private static CongTy c = new CongTy();

	public GUI() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Danh sách phòng ban");

		for (PhongBan p : c.getLsPhongBan()) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(p.getTenPhongBan());
			root.add(node);
		}

		// Create tree using root
		tree = new JTree(root);
		add(new JScrollPane(tree));

		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					DefaultMutableTreeNode clickedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					if (clickedNode != null) {
						PhongBan p = c.findPhongBan(clickedNode.toString());
						TableNhanVien frame = new TableNhanVien(p);
						frame.setVisible(true);
					} else {

					}
				}
			}
		});
	}

	public static void main(String[] args) {
		c.themPhongBan("001", "Phòng kỹ thuật");
		c.themPhongBan("002", "Phòng hành chính");
		c.themPhongBan("003", "Phòng nhân sự");
		c.themPhongBan("004", "Phòng Marketing");
		c.themPhongBan("005", "Phòng bảo vệ");

		c.findPhongBan("Phòng kỹ thuật").themNhanVien(new NhanVien("001", "Tran", "Nguyen Vu", "Nam", 29, 2000));
		c.findPhongBan("Phòng kỹ thuật").themNhanVien(new NhanVien("002", "Tran", "Nguyen Vu", "Nam", 29, 2000));
		c.findPhongBan("Phòng kỹ thuật").themNhanVien(new NhanVien("003", "Tran", "Nguyen Vu", "Nam", 29, 2000));

		c.findPhongBan("Phòng hành chính").themNhanVien(new NhanVien("001", "Tran", "Nguyen Vu", "Nam", 29, 2000));
		c.findPhongBan("Phòng hành chính").themNhanVien(new NhanVien("002", "Tran", "Nguyen Vu", "Nam", 29, 2000));
		c.findPhongBan("Phòng hành chính").themNhanVien(new NhanVien("003", "Tran", "Nguyen Vu", "Nam", 29, 2000));

		c.findPhongBan("Phòng nhân sự").themNhanVien(new NhanVien("001", "Tran", "Nguyen Vu", "Nam", 29, 2000));
		c.findPhongBan("Phòng nhân sự").themNhanVien(new NhanVien("002", "Tran", "Nguyen Vu", "Nam", 29, 2000));
		c.findPhongBan("Phòng nhân sự").themNhanVien(new NhanVien("003", "Tran", "Nguyen Vu", "Nam", 29, 2000));

		c.findPhongBan("Phòng Marketing").themNhanVien(new NhanVien("001", "Tran", "Nguyen Vu", "Nam", 29, 2000));
		c.findPhongBan("Phòng Marketing").themNhanVien(new NhanVien("002", "Tran", "Nguyen Vu", "Nam", 29, 2000));
		c.findPhongBan("Phòng Marketing").themNhanVien(new NhanVien("003", "Tran", "Nguyen Vu", "Nam", 29, 2000));

		c.findPhongBan("Phòng bảo vệ").themNhanVien(new NhanVien("001", "Tran", "Nguyen Vu", "Nam", 29, 2000));
		c.findPhongBan("Phòng bảo vệ").themNhanVien(new NhanVien("001", "Tran", "Nguyen Vu", "Nam", 29, 2000));
		c.findPhongBan("Phòng bảo vệ").themNhanVien(new NhanVien("001", "Tran", "Nguyen Vu", "Nam", 29, 2000));

		GUI gui = new GUI();
		gui.setTitle("^-^");
		gui.setSize(800, 600);
		gui.setLocationRelativeTo(null);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setResizable(false);
		gui.setVisible(true);
	}
}