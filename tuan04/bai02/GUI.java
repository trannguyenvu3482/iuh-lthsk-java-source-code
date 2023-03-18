package tuan04.bai02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.table.TableColumn;

public class GUI extends JFrame implements ActionListener {
	private JButton btnAdd = new JButton("Add");
	private JButton btnClear = new JButton("Clear");
	private JButton btnUpdate = new JButton("Update");
	private JButton btnDelete = new JButton("Delete");
	private JButton btnSearch = new JButton("Search");
	private JTextField txtCountry = new JTextField(20);
	private JTextField txtCapital = new JTextField(20);
	private JTextField txtPopulation = new JTextField(20);
	private JComboBox<String> boxDemocracy = new JComboBox<String>();
	private JPanel middlePanel = new JPanel();
	private JTable tbl;
	private DefaultTableModel model;
	private ListCountry list = new ListCountry();

	public GUI() throws Exception {
		// North panel
		JPanel northPanel = new JPanel();
		JLabel northTitle = new JLabel("Using JTable Component");
		northTitle.setForeground(Color.BLUE);
		northTitle.setFont(new Font("Arial", Font.BOLD, 20));

		northPanel.add(northTitle);

		// Middle panel
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));

		JLabel lblCountry = new JLabel("Enter country: ");
		JLabel lblCapital = new JLabel("Enter capital: ");
		JLabel lblPopulation = new JLabel("Enter population: ");
		JLabel lblDemocracy = new JLabel("Enter democracy: ");

		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();

		lblCountry.setPreferredSize(lblDemocracy.getPreferredSize());
		b1.add(lblCountry);
		b1.add(txtCountry);
		b1.add(Box.createHorizontalStrut(450));

		lblCapital.setPreferredSize(lblDemocracy.getPreferredSize());
		b2.add(lblCapital);
		b2.add(txtCapital);

		lblPopulation.setPreferredSize(lblDemocracy.getPreferredSize());
		b3.add(lblPopulation);
		b3.add(txtPopulation);

		b4.add(lblDemocracy);
		boxDemocracy.addItem("true");
		boxDemocracy.addItem("false");
		b4.add(boxDemocracy);
		b4.add(Box.createHorizontalStrut(450));

		b.add(Box.createVerticalStrut(10));
		b.add(b1);
		b.add(Box.createVerticalStrut(10));
		b.add(b2);
		b.add(Box.createVerticalStrut(10));
		b.add(b3);
		b.add(Box.createVerticalStrut(10));
		b.add(b4);
		b.add(Box.createVerticalStrut(10));

		middlePanel.add(b);

		// Create table
		createTable();

		// South panel
		JPanel southPanel = new JPanel();
		southPanel.add(btnAdd);
		southPanel.add(btnClear);
		southPanel.add(btnUpdate);
		southPanel.add(btnDelete);
		southPanel.add(btnSearch);

		// Add panels to frame
		add(northPanel, BorderLayout.NORTH);
		add(middlePanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);

		// Add action listeners to buttons
		btnAdd.addActionListener(this);
		btnClear.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSearch.addActionListener(this);

		// Load txt file
		loadTxtFile();

		// Table event listener
		tbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tbl.getSelectedRow() != -1) {
					txtCountry.setText((String) model.getValueAt(tbl.getSelectedRow(), 0));
					txtCapital.setText((String) model.getValueAt(tbl.getSelectedRow(), 1));
					txtPopulation.setText((String) model.getValueAt(tbl.getSelectedRow(), 2));
					
					
					boxDemocracy.setSelectedItem(model.getValueAt(tbl.getSelectedRow(), 3));
			}}
		});
	}

	public void createTable() {
		String[] cols = { "Country", "Capital", "Population", "Democracy" };
		model = new DefaultTableModel(cols, 0);
		tbl = new JTable(model);
		tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane tablePane = new JScrollPane(tbl);

		middlePanel.add(tablePane);
	}

	public void refreshTable() {
		model.setRowCount(0);

		JCheckBox checkBox = new JCheckBox("", true);
		TableColumn demoCol = tbl.getColumnModel().getColumn(3);
		demoCol.setCellEditor(new DefaultCellEditor(checkBox));

		for (Country c : list.getLs()) {

			Object[] data = { c.getName(), c.getCapital(), Integer.toString(c.getPopulation()),
					Boolean.toString(c.isDemocracy()) };

			checkBox.setSelected(c.isDemocracy());
			model.addRow(data);
		}
	}

	public void loadTxtFile() {
		try {
			File f = new File("./src/data/Countries.txt");

			if (f.exists()) {
				Scanner sc = new Scanner(f);

				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					String[] data = line.split(",");

					list.themCountry(
							new Country(data[0], data[1], Integer.parseInt(data[2]), Boolean.parseBoolean(data[3])));
				}
				sc.close();
				refreshTable();
				JOptionPane.showMessageDialog(this, "Đã load file thành công");
			} else {
				f.createNewFile();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Đã có lỗi trong lúc load file");
		}
	}
	
	public void saveTxtFile() {
		try {
			File f = new File("./src/data/Countries.txt");
			FileWriter writer = new FileWriter(f);
			
			for (Country c : list.getLs()) {
				String s = c.getName() + "," + c.getCapital() + "," + c.getPopulation() + "," + c.isDemocracy();
				writer.write(s);
				writer.write("\n");
			}
			
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clearFields() {
		txtCountry.setText("");
		txtCapital.setText("");
		txtPopulation.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnAdd)) {

		} else if (o.equals(btnClear)) {
			clearFields();
			JOptionPane.showMessageDialog(this, "Đã xóa các trường");
		} else if (o.equals(btnUpdate)) {

		} else if (o.equals(btnDelete)) {

		} else if (o.equals(btnSearch)) {
			String input = JOptionPane.showInputDialog(this, "Nhập vào tên quốc gia muốn tìm");
			Country c = list.findCountry(input);

			if (c != null) {
				tbl.setRowSelectionInterval(list.getLs().indexOf(c), list.getLs().indexOf(c));
			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy quốc gia " + input);
			}
		}

	}
}
