package bai01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree;

public class GUI extends JFrame implements ActionListener {
	JTree tree;
	DanhSachNhanVien dsPhongToChuc = new DanhSachNhanVien();
	DanhSachNhanVien dsPhongKyThuat = new DanhSachNhanVien();
	DefaultTableModel model;
	JTable tbl;
	JDialog dialog;

	public GUI() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Danh sách phòng ban");
		DefaultMutableTreeNode nodeToChuc = new DefaultMutableTreeNode("Phòng tổ chức");
		DefaultMutableTreeNode nodeKyThuat = new DefaultMutableTreeNode("Phòng kỹ thuật");
		// add the child nodes to the root node
		root.add(nodeToChuc);
		root.add(nodeKyThuat);
		tree = new JTree(root);
		add(new JScrollPane(tree));
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				TreePath selPath = e.getNewLeadSelectionPath();
				Object o = selPath.getLastPathComponent();
				if (o.equals(nodeToChuc)) {
					showTable(o);
				} else {
					showTable(o);
				}
			}
		});
	}
	
	public void showTable(Object object) {
		String[] cols = { "Mã", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương" };
		model = new DefaultTableModel(cols, 0);
		tbl = new JTable(model);
		tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane tablePane = new JScrollPane(tbl);
		
		
		
		dialog = new JDialog(this, object.toString());
		
		dialog.setSize(600, 400);
		dialog.setLocationRelativeTo(null);
		dialog.setResizable(false);
		dialog.add(tablePane);
		dialog.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
