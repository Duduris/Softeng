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

public class IpalilosPanel2 extends JPanel {

	private static final long serialVersionUID = 1;

	public IpalilosPanel2() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		/*
		 * Tab 1
		 */
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New Packet", null, panel, null);
		panel.setLayout(new MigLayout("", "[125.00][100.00,grow][100.00,grow]", "[30][30][30][30][30][30][30][125.00,grow][30]"));
		
		JLabel lblName = new JLabel("Name");
		panel.add(lblName, "cell 0 0,alignx center,aligny center");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		panel.add(formattedTextField, "cell 1 0 2 1,grow");
		
		JLabel lblSurname = new JLabel("Surname");
		panel.add(lblSurname, "cell 0 1,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		panel.add(formattedTextField_1, "cell 1 1 2 1,grow");
		
		JLabel lblAddress = new JLabel("Address");
		panel.add(lblAddress, "cell 0 2,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		panel.add(formattedTextField_2, "cell 1 2 2 1,grow");
		
		JLabel lblPostalCode = new JLabel("Postal Code");
		panel.add(lblPostalCode, "cell 0 3,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		panel.add(formattedTextField_3, "cell 1 3 2 1,grow");
		
		JLabel lblCountry = new JLabel("Country");
		panel.add(lblCountry, "cell 0 4,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		panel.add(formattedTextField_4, "cell 1 4 2 1,grow");
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		panel.add(lblPhoneNumber, "cell 0 5,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_5 = new JFormattedTextField();
		panel.add(formattedTextField_5, "cell 1 5 2 1,grow");
		
		JLabel lblFragile = new JLabel("Fragile");
		panel.add(lblFragile, "cell 0 6,alignx center,aligny center");
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		panel.add(chckbxNewCheckBox, "cell 1 6");
		
		JLabel lblComments = new JLabel("Comments");
		panel.add(lblComments, "cell 0 7,alignx center,aligny center");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane, "cell 1 7 2 1,grow");
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		JButton btnClear = new JButton("Clear");
		panel.add(btnClear, "cell 1 8,alignx left,growy");
		
		JButton btnSubmit = new JButton("Submit");
		panel.add(btnSubmit, "cell 2 8,alignx right,growy");
		
		/* 
		 * Tab 2
		 */
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Search", null, panel_1, null);
		panel_1.setLayout(new MigLayout("", "[125.00][100.00,grow]", "[30][30][30][30][30][30][30][30][125.00,grow]"));
		
		JLabel lblName1 = new JLabel("Name");
		panel_1.add(lblName1, "cell 0 1,alignx center,aligny center");
		
		JFormattedTextField formattedTextField1 = new JFormattedTextField();
		panel_1.add(formattedTextField1, "cell 1 0,grow");
		
		JLabel lblSurname1 = new JLabel("Surname");
		panel_1.add(lblSurname1, "cell 0 2,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_11 = new JFormattedTextField();
		panel_1.add(formattedTextField_11, "cell 1 1,grow");
		
		JLabel lblAddress1 = new JLabel("Address");
		panel_1.add(lblAddress1, "cell 0 3,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_21 = new JFormattedTextField();
		panel_1.add(formattedTextField_21, "cell 1 2,grow");
		
		JLabel lblPostalCode1 = new JLabel("Postal Code");
		panel_1.add(lblPostalCode1, "cell 0 4,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_31 = new JFormattedTextField();
		panel_1.add(formattedTextField_31, "cell 1 3,grow");
		
		JLabel lblCountry1 = new JLabel("Country");
		panel_1.add(lblCountry1, "cell 0 5,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_41 = new JFormattedTextField();
		panel_1.add(formattedTextField_41, "cell 1 4,grow");
		
		JLabel lblPhoneNumber1 = new JLabel("Phone Number");
		panel_1.add(lblPhoneNumber1, "cell 0 6,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_51 = new JFormattedTextField();
		panel_1.add(formattedTextField_51, "cell 1 5,grow");
		
		JLabel lblTracking = new JLabel("Tracking Number");
		panel_1.add(lblTracking, "cell 0 0,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_6 = new JFormattedTextField();
		panel_1.add(formattedTextField_6, "cell 1 6,grow");
		
		JButton btnClear_1 = new JButton("Clear");
		panel_1.add(btnClear_1, "flowx,cell 1 7,growy");
		
		JButton btnSearch = new JButton("Search");
		panel_1.add(btnSearch, "cell 1 7,growy");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane_1, "cell 1 8,grow");
		scrollPane_1.setVisible(false);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 11));

	}
}
