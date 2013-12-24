package gui;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import additional.TableColumnAdjuster;

public class MetaforeasPanel extends JPanel {

	private static final long serialVersionUID = 2;
	
	private String[] problem = { "OK", "DAMAGED", "UNAVAILABLE", "WRONG ADDRESS" };
	private JTable table;
	private DefaultTableModel tm;
	private JComboBox<Object> comboBox;
	private JButton btnMap;
	private JButton btnSubmit;
	private JButton btnConn;
	private CardLayout card;
	private TableColumnAdjuster tca;

	private String[] columnNames = { "First Name", "Last Name", "Address", "Status" };
	private JScrollPane scrollPane;

	public MetaforeasPanel() {

		setLayout(new MigLayout("", "[427.00,grow][70.00]",
				"[60][grow][60][grow][60]"));

		btnMap = new JButton("Map");
		add(btnMap, "cell 1 2,grow");

		btnSubmit = new JButton("Submit");
		add(btnSubmit, "cell 1 4,grow");

		btnConn = new JButton("Connect");
		add(btnConn, "cell 1 0,grow");

		comboBox = new JComboBox<Object>(problem);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		comboBox.setRenderer(dlcr);
		add(comboBox, "cell 0 4,grow");

		JPanel panel = new JPanel(new CardLayout());
		add(panel, "cell 0 0 1 4,grow");

		JPanel tablepanel = new JPanel();
		tablepanel.setLayout(new MigLayout("", "[grow]", "[grow]"));

		panel.add(tablepanel, "p1");
		
		
		scrollPane = new JScrollPane();
		tablepanel.add(scrollPane, "cell 0 0,grow");
		table = new JTable(new DefaultTableModel(columnNames, 0));
		scrollPane.setViewportView(table);
		tm = (DefaultTableModel) table.getModel();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tca = new TableColumnAdjuster(table);
		table.setRowHeight(50);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setShowVerticalLines(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		JPanel mappanel = new JPanel();
		mappanel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		panel.add(mappanel, "p2");

		card = (CardLayout) panel.getLayout();
		card.show(panel, "p1");

	}

	public void btnMapListener(ActionListener e) {
		btnMap.addActionListener(e);
	}

	public void btnSubmitListener(ActionListener e) {
		btnSubmit.addActionListener(e);
	}

	public void btnConnectListener(ActionListener e) {
		btnConn.addActionListener(e);
	}

	public String getItemStatus() {
		return comboBox.getSelectedItem().toString();
	}

	public int getTableRow() {
		return table.getSelectedRow();
	}

	public void setTableData(Object[] db) {
		tm.addRow(db);
		tca.adjustColumns();
	}
	
	public void updateStatus(String value) {
		tm.setValueAt(value, table.getSelectedRow(), 3);
		tca.adjustColumns();
	}
	
	public void clearTable() {
		tm.setRowCount(0);
	}

}
