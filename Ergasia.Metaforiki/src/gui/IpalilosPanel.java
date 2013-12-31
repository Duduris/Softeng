package gui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import additional.TableColumnAdjuster;

public class IpalilosPanel extends JPanel {

	private static final long serialVersionUID = 1;
	
	private JTabbedPane tabbedPane;

	private JFormattedTextField formattedTextField;
	private JFormattedTextField formattedTextField_1;
	private JFormattedTextField formattedTextField_2;
	private JFormattedTextField formattedTextField_3;
	private JFormattedTextField formattedTextField_4;
	private JFormattedTextField formattedTextField_5;
	private JFormattedTextField formattedTextField_6;
	private JCheckBox chckbxNewCheckBox;
	private JTextArea textArea;
	private JButton btnClear;
	private JButton btnSubmit;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel2;
	private JLabel lblNewLabel3;
	private JLabel lblNewLabel4;
	private JLabel lblNewLabel5;
	private JLabel lblNewLabel6;
	private JLabel lblTrackNum;
	
	
	private JFormattedTextField formattedTextField1;
	private JFormattedTextField formattedTextField_11;
	private JFormattedTextField formattedTextField_21;
	private JFormattedTextField formattedTextField_31;
	private JFormattedTextField formattedTextField_41;
	private JFormattedTextField formattedTextField_51;
	private JFormattedTextField formattedTextField_61;
	private JButton btnClear_1;
	private JButton btnSearch;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JLabel lblSearchWarnig1;
	private JLabel lblSearchWarnig2;
	private JLabel lblSearchWarnig3;
	private JLabel lblSearchWarnig4;
	private JLabel lblSearchWarnig5;
	private JLabel lblSearchWarnig6;
	private JLabel lblSearchWarnig7;
	private DefaultTableModel tm;
	private TableColumnAdjuster tca;
	private String[] columnNames = { "First Name", "Last Name", "Address", "Postal Code","Country","Phone","Fragile","Tracking","Comments", "Status" };
	private JButton btnExport;
	private JLabel lblNotFound;
	private JButton btnSubmitTable;
	private JLabel lblSuccessful;
	

	public IpalilosPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);

		/*
		 * Tab 1
		 */

		JPanel panel = new JPanel();
		tabbedPane.addTab("New Packet", null, panel, null);
		panel.setLayout(new MigLayout("hidemode 3", "[125.00][100.00,grow][100.00,grow]", "[30]2[]2[30]2[]2[30]2[]2[30]2[]2[30]2[]2[30]2[]2[30]2[]2[125.00,grow][][30]"));

		JLabel lblName = new JLabel("Name");
		panel.add(lblName, "cell 0 0,alignx center,aligny center");

		formattedTextField = new JFormattedTextField();
		panel.add(formattedTextField, "cell 1 0 2 1,grow");
		
		lblNewLabel = new JLabel("Name takes only letters");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setVisible(false);
		panel.add(lblNewLabel, "cell 1 1,h 15");

		JLabel lblSurname = new JLabel("Surname");
		panel.add(lblSurname, "cell 0 2,alignx center,aligny center");

		formattedTextField_1 = new JFormattedTextField();
		panel.add(formattedTextField_1, "cell 1 2 2 1,grow");
		
		lblNewLabel2 = new JLabel("Surname takes only letters");
		lblNewLabel2.setForeground(Color.RED);
		lblNewLabel2.setVisible(false);
		panel.add(lblNewLabel2, "cell 1 3,h 15");

		JLabel lblAddress = new JLabel("Address");
		panel.add(lblAddress, "cell 0 4,alignx center,aligny center");

		formattedTextField_2 = new JFormattedTextField();
		panel.add(formattedTextField_2, "cell 1 4 2 1,grow");

		JLabel lblPostalCode = new JLabel("Postal Code");
		panel.add(lblPostalCode, "cell 0 6,alignx center,aligny center");

		formattedTextField_3 = new JFormattedTextField();
		panel.add(formattedTextField_3, "cell 1 6 2 1,grow");
		
		lblNewLabel3 = new JLabel("Postal Code must be 5-digit number");
		lblNewLabel3.setForeground(Color.RED);
		lblNewLabel3.setVisible(false);
		panel.add(lblNewLabel3, "cell 1 7, h 15");

		JLabel lblCountry = new JLabel("Country");
		panel.add(lblCountry, "cell 0 8,alignx center,aligny center");

		formattedTextField_4 = new JFormattedTextField();
		panel.add(formattedTextField_4, "cell 1 8 2 1,grow");
		
		lblNewLabel4 = new JLabel("Country takes only letters");
		lblNewLabel4.setForeground(Color.RED);
		lblNewLabel4.setVisible(false);
		panel.add(lblNewLabel4, "cell 1 9,height 15");

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		panel.add(lblPhoneNumber, "cell 0 10,alignx center,aligny center");

		formattedTextField_5 = new JFormattedTextField();
		panel.add(formattedTextField_5, "cell 1 10 2 1,grow");
		
		lblNewLabel5 = new JLabel("Phone must be 10-digit number");
		lblNewLabel5.setForeground(Color.RED);
		lblNewLabel5.setVisible(false);
		panel.add(lblNewLabel5, "cell 1 11,h 15");

		JLabel lblFragile = new JLabel("Fragile");
		panel.add(lblFragile, "cell 0 12,alignx center,aligny center");

		chckbxNewCheckBox = new JCheckBox("");
		panel.add(chckbxNewCheckBox, "cell 1 12");
		
		lblNewLabel6 = new JLabel("All Fileds except Comments are mandatory");
		lblNewLabel6.setForeground(Color.RED);
		lblNewLabel6.setVisible(false);
		panel.add(lblNewLabel6, "cell 1 13,height 15");

		JLabel lblComments = new JLabel("Comments");
		panel.add(lblComments, "cell 0 14,alignx center,aligny center");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane, "cell 1 14 2 1,grow");

		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		lblTrackNum = new JLabel("The tracking number for this package is: ");
		lblTrackNum.setVisible(false);
		panel.add(lblTrackNum, "cell 1 15,alignx trailing,h 30");
		
		formattedTextField_6 = new JFormattedTextField();
		formattedTextField_6.setVisible(false);
		panel.add(formattedTextField_6, "cell 2 15,growx,h 30");

		btnClear = new JButton("Clear");
		panel.add(btnClear, "cell 1 16,alignx left,growy");

		btnSubmit = new JButton("Submit");
		panel.add(btnSubmit, "cell 2 16,alignx right,growy");

		/*
		 * Tab 2
		 */

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Search", null, panel_1, null);
		panel_1.setLayout(new MigLayout("hidemode 3", "[125.00][100.00,grow]", "[30]2[]2[30]2[]2[30]2[]2[30][30]2[]2[30]2[]2[30][][][30]2[]2[grow][]"));
		
		lblSearchWarnig1 = new JLabel("Tracking Warning");
		lblSearchWarnig1.setForeground(Color.RED);
		panel_1.add(lblSearchWarnig1, "cell 1 1");

		JLabel lblName1 = new JLabel("Name");
		panel_1.add(lblName1, "cell 0 2,alignx center,aligny center");

		formattedTextField1 = new JFormattedTextField();
		panel_1.add(formattedTextField1, "cell 1 0,grow");
		
		lblSearchWarnig2 = new JLabel("Name takes only letters");
		lblSearchWarnig2.setForeground(Color.RED);
		panel_1.add(lblSearchWarnig2, "cell 1 3");

		JLabel lblSurname1 = new JLabel("Surname");
		panel_1.add(lblSurname1, "cell 0 4,alignx center,aligny center");

		formattedTextField_11 = new JFormattedTextField();
		panel_1.add(formattedTextField_11, "cell 1 2,grow");
		
		lblSearchWarnig3 = new JLabel("Surname takes only letters");
		lblSearchWarnig3.setForeground(Color.RED);
		panel_1.add(lblSearchWarnig3, "cell 1 5");

		JLabel lblAddress1 = new JLabel("Address");
		panel_1.add(lblAddress1, "cell 0 6,alignx center,aligny center");

		formattedTextField_21 = new JFormattedTextField();
		panel_1.add(formattedTextField_21, "cell 1 4,grow");

		JLabel lblPostalCode1 = new JLabel("Postal Code");
		panel_1.add(lblPostalCode1, "cell 0 7,alignx center,aligny center");

		formattedTextField_31 = new JFormattedTextField();
		panel_1.add(formattedTextField_31, "cell 1 6,grow");
		
		lblSearchWarnig4 = new JLabel("Postal Code must be 5-digit number");
		lblSearchWarnig4.setForeground(Color.RED);
		panel_1.add(lblSearchWarnig4, "cell 1 8");

		JLabel lblCountry1 = new JLabel("Country");
		panel_1.add(lblCountry1, "cell 0 9,alignx center,aligny center");

		formattedTextField_41 = new JFormattedTextField();
		panel_1.add(formattedTextField_41, "cell 1 7,grow");
		
		lblSearchWarnig5 = new JLabel("Country takes only letters");
		lblSearchWarnig5.setForeground(Color.RED);
		panel_1.add(lblSearchWarnig5, "cell 1 10");

		JLabel lblPhoneNumber1 = new JLabel("Phone Number");
		panel_1.add(lblPhoneNumber1, "cell 0 11,alignx center,aligny center");

		formattedTextField_51 = new JFormattedTextField();
		panel_1.add(formattedTextField_51, "cell 1 9,grow");

		JLabel lblTracking = new JLabel("Tracking Number");
		panel_1.add(lblTracking, "cell 0 0,alignx center,aligny center");

		formattedTextField_61 = new JFormattedTextField();
		panel_1.add(formattedTextField_61, "cell 1 11,grow");
		
		lblSearchWarnig6 = new JLabel("Phone must be 10-digit number");
		lblSearchWarnig6.setForeground(Color.RED);
		panel_1.add(lblSearchWarnig6, "cell 1 12");
		
		lblSearchWarnig7 = new JLabel("Fill at least one Field");
		lblSearchWarnig7.setForeground(Color.RED);
		panel_1.add(lblSearchWarnig7, "cell 1 13");

		btnClear_1 = new JButton("Clear");
		panel_1.add(btnClear_1, "flowx,cell 1 14,growy");

		btnSearch = new JButton("Search");
		panel_1.add(btnSearch, "cell 1 14,growy");
		
        tm = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = 1L;

			@Override
            public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }

            @Override
            public boolean isCellEditable(int row, int column) {
            	/*
            	 * To Tracking den einai editable column 7
            	 */
            	if (column == 7)
            		return false;
            	else
            		return true;
            }
        };
		
		lblNotFound = new JLabel("Nothing was Found!");
		lblNotFound.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNotFound.setForeground(Color.BLUE);
		panel_1.add(lblNotFound, "cell 1 15, h 50");
		table = new JTable(tm){
			private static final long serialVersionUID = 1L;

			public boolean getScrollableTracksViewportWidth()
            {
                return getPreferredSize().width < getParent().getWidth();
            }
		};
		
		scrollPane_1 = new JScrollPane(table);
		panel_1.add(scrollPane_1, "cell 1 16,grow");
		scrollPane_1.setVisible(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tca = new TableColumnAdjuster(table);
		
		btnExport = new JButton("Export");
		panel_1.add(btnExport, "cell 1 14,growy");
		
		lblSuccessful = new JLabel("Successful");
		lblSuccessful.setForeground(Color.BLUE);
		panel_1.add(lblSuccessful, "flowx,cell 1 17,alignx right,growy");
		
		btnSubmitTable = new JButton("Submit Changes");
		panel_1.add(btnSubmitTable, "cell 1 17,alignx right,growy");
		btnExport.setVisible(false);
		
		lblSearchWarnig1.setVisible(false);
		lblSearchWarnig2.setVisible(false);
		lblSearchWarnig3.setVisible(false);
		lblSearchWarnig4.setVisible(false);
		lblSearchWarnig5.setVisible(false);
		lblSearchWarnig6.setVisible(false);
		lblSearchWarnig7.setVisible(false);
		lblSuccessful.setVisible(false);
		lblNotFound.setVisible(false);
		btnSubmitTable.setVisible(false);

	}

	/*
	 * Panel1
	 */
	
	public void btnClearListener(ActionListener e) {
		btnClear.addActionListener(e);
	}

	public void btnSubmitListener(ActionListener e) {
		btnSubmit.addActionListener(e);
	}
	
	public String[] getTextBoxesPacket() {
		String[] values = new String[8];
		
		values[0] = formattedTextField.getText();
		values[1] = formattedTextField_1.getText();
		values[2] = formattedTextField_2.getText();
		values[3] = formattedTextField_3.getText();
		values[4] = formattedTextField_4.getText();
		values[5] = formattedTextField_5.getText();
		if (chckbxNewCheckBox.isSelected())
			values[6] = "t";
		else 
			values[6] = "f";
		values[7] = textArea.getText();
		
		return values;
	}
	
	public void clearTextBoxesPacket() {
		formattedTextField.setText("");
		formattedTextField_1.setText("");
		formattedTextField_2.setText("");
		formattedTextField_3.setText("");
		formattedTextField_4.setText("");
		formattedTextField_5.setText("");
		formattedTextField_6.setText("");
		formattedTextField_6.setVisible(false);
		chckbxNewCheckBox.setSelected(false);
		textArea.setText("");
		lblNewLabel.setVisible(false);
		lblNewLabel2.setVisible(false);
		lblNewLabel3.setVisible(false);
		lblNewLabel4.setVisible(false);
		lblNewLabel5.setVisible(false);
		lblNewLabel6.setVisible(false);
		lblTrackNum.setVisible(false);
	}
	
	public void displayWarningsP1(boolean[] warning) {
		lblNewLabel.setVisible(warning[0]);
		lblNewLabel2.setVisible(warning[1]);
		lblNewLabel3.setVisible(warning[2]);
		lblNewLabel4.setVisible(warning[3]);
		lblNewLabel5.setVisible(warning[4]);
		lblNewLabel6.setVisible(warning[5]);
		revalidate();
		
	}
	
	public void setTrackingNumb(String track) {
		formattedTextField_6.setText(track);
		lblTrackNum.setVisible(true);
		formattedTextField_6.setVisible(true);
		revalidate();
	}

	/*
	 * Panel 2
	 */
	
	public void btnSearchListener(ActionListener e) {
		btnSearch.addActionListener(e);
	}

	public void btnClear2Listener(ActionListener e) {
		btnClear_1.addActionListener(e);
	}
	
	public void btnExportListener(ActionListener e) {
		btnExport.addActionListener(e);
	}
	
	public void btnSubmitTableListener(ActionListener e) {
		btnSubmitTable.addActionListener(e);
	}
	
  
    
	
	public String[] getTextBoxesSearch() {
		String[] values = new String[7];
		
		values[0] = formattedTextField1.getText();
		values[1] = formattedTextField_11.getText();
		values[2] = formattedTextField_21.getText();
		values[3] = formattedTextField_31.getText();
		values[4] = formattedTextField_41.getText();
		values[5] = formattedTextField_51.getText();
		values[6] = formattedTextField_61.getText();
		
		return values;
	}
	
	public void clearTextBoxesSearch() {
		formattedTextField1.setText("");
		formattedTextField_11.setText("");
		formattedTextField_21.setText("");
		formattedTextField_31.setText("");
		formattedTextField_41.setText("");
		formattedTextField_51.setText("");
		formattedTextField_61.setText("");
		scrollPane_1.setVisible(false);
		lblSearchWarnig1.setVisible(false);
		lblSearchWarnig2.setVisible(false);
		lblSearchWarnig3.setVisible(false);
		lblSearchWarnig4.setVisible(false);
		lblSearchWarnig5.setVisible(false);
		lblSearchWarnig6.setVisible(false);
		lblSearchWarnig7.setVisible(false);
		btnExport.setVisible(false);
		btnSubmitTable.setVisible(false);
		lblNotFound.setVisible(false);
		lblSuccessful.setVisible(false);
		revalidate();
	}
	
	public void updateStatus(Object[] db) {
		scrollPane_1.setVisible(true);
		tm.addRow(db);
		tca.adjustColumns();
		btnExport.setVisible(true);
		revalidate();
	}
	
	public void displayWarningsP2(boolean[] warning) {
		lblSearchWarnig1.setVisible(warning[0]);
		lblSearchWarnig2.setVisible(warning[1]);
		lblSearchWarnig3.setVisible(warning[2]);
		lblSearchWarnig4.setVisible(warning[4]);
		lblSearchWarnig5.setVisible(warning[5]);
		lblSearchWarnig6.setVisible(warning[6]);
		lblSearchWarnig7.setVisible(warning[7]);
		revalidate();
	}
	
	public void clearTable() {
		scrollPane_1.setVisible(false);
		btnSubmitTable.setVisible(false);
		tm.setRowCount(0);
		lblSuccessful.setVisible(false);
		revalidate();
	}
	
	public DefaultTableModel retTable(){
		/*
		 * Dimiourgei adigrafo tou table gia to neo parathiro
		 */
	    final DefaultTableModel copy = new DefaultTableModel(tm.getRowCount(), 0);
	    for (int column = 0; column < tm.getColumnCount(); column++) {
	        copy.addColumn(tm.getColumnName(column));
	        for (int row = 0; row < tm.getRowCount(); row++)
	            copy.setValueAt(tm.getValueAt(row, column), row, column);
	    }
	    return copy;
	}
	
	public void clearAll() {
		tabbedPane.setSelectedIndex(0);
		lblNotFound.setVisible(false);
		btnSubmitTable.setVisible(false);
		lblSuccessful.setVisible(false);
	}
	
	public void notFound(boolean ok){
		lblNotFound.setVisible(ok);
		btnExport.setVisible(!ok);
		btnSubmitTable.setVisible(!ok);
	}
	public void submmited (boolean ok) throws InterruptedException{	
		lblSuccessful.setVisible(ok);
			
	}

}
