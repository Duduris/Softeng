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
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;


public class IpalilosPanel2 extends JPanel {
	
	public static java.sql.Date getCurrentJavaSqlDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	  }
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
		
		final JFormattedTextField frmtdtxtfldAsdsd = new JFormattedTextField();
		panel.add(frmtdtxtfldAsdsd, "cell 1 0 2 1,grow");
		
		JLabel lblSurname = new JLabel("Surname");
		panel.add(lblSurname, "cell 0 1,alignx center,aligny center");
		
		final JFormattedTextField frmtdtxtfldSdfafdsf = new JFormattedTextField();
		panel.add(frmtdtxtfldSdfafdsf, "cell 1 1 2 1,grow");
		
		JLabel lblAddress = new JLabel("Address");
		panel.add(lblAddress, "cell 0 2,alignx center,aligny center");
		
		final JFormattedTextField frmtdtxtfldDfsgsdfsdfasf = new JFormattedTextField();
		panel.add(frmtdtxtfldDfsgsdfsdfasf, "cell 1 2 2 1,grow");
		
		JLabel lblPostalCode = new JLabel("Postal Code");
		panel.add(lblPostalCode, "cell 0 3,alignx center,aligny center");
		
		final JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		panel.add(formattedTextField_3, "cell 1 3 2 1,grow");
		
		JLabel lblCountry = new JLabel("Country");
		panel.add(lblCountry, "cell 0 4,alignx center,aligny center");
		
		final JFormattedTextField frmtdtxtfldFdssdfg = new JFormattedTextField();
		panel.add(frmtdtxtfldFdssdfg, "cell 1 4 2 1,grow");
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		panel.add(lblPhoneNumber, "cell 0 5,alignx center,aligny center");
		
		final JFormattedTextField formattedTextField_5 = new JFormattedTextField();
		formattedTextField_5.setText("");
		panel.add(formattedTextField_5, "cell 1 5 2 1,grow");
		
		JLabel lblFragile = new JLabel("Fragile");
		panel.add(lblFragile, "cell 0 6,alignx center,aligny center");
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("");
		panel.add(chckbxNewCheckBox, "cell 1 6");
		
		
		JLabel lblComments = new JLabel("Comments");
		panel.add(lblComments, "cell 0 7,alignx center,aligny center");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane, "cell 1 7 2 1,grow");
		
		final JTextArea txtrDfcsbnfhgGhetrgGh = new JTextArea();
		txtrDfcsbnfhgGhetrgGh.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtrDfcsbnfhgGhetrgGh.setLineWrap(true);
		scrollPane.setViewportView(txtrDfcsbnfhgGhetrgGh);
		
		
		
		JButton btnClear = new JButton("Clear");
		panel.add(btnClear, "cell 1 8,alignx left,growy");
		
		
		/*
		final String name = frmtdtxtfldAsdsd.getText(); //Name
		final String surname = frmtdtxtfldSdfafdsf.getText(); //Surname
		final String address = frmtdtxtfldDfsgsdfsdfasf.getText(); //Address
		final int tk = Integer.parseInt(formattedTextField_3.getText()); //Postal Code
		final String xwra = frmtdtxtfldFdssdfg.getText(); //Country
		final int phone = Integer.parseInt(formattedTextField_5.getText()); // Phone
		final boolean checkbox = chckbxNewCheckBox.isSelected();//checkbox
		final String comment = txtrDfcsbnfhgGhetrgGh.getText(); //Comment
		*/
		
		
		JButton btnSubmit = new JButton("Submit");
		panel.add(btnSubmit, "cell 2 8,alignx right,growy");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					
					//elegxos gia tixon null sta Jtextboxes
					//grafw sti vasi
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					
					String url = "jdbc:mysql://83.212.112.80/foo";
					String username = "root";
					String pass = "1234";
					
					Connection conn = DriverManager.getConnection(url, username, pass);
					Statement stm = conn.createStatement();
					
					int id2=15;
					String sqldiavasma = "select * from demata";
					ResultSet rs = stm.executeQuery(sqldiavasma);
					while(rs.next()){
						id2 = rs.getInt("id");
						}
					
					
					//tyxaio tracking number Elegxos me epanalipsi an yparxei eidh
					int min = 0000000;
					int max = 9999999;
					Random r = new Random();
					int trackingnumber = r.nextInt(max - min + 1) + min;
					
					//Arxiki katastasi (Mi paradomeno)
					int katastasi = 0;
					
					//fragile
					int ckeck = 0;
					if (chckbxNewCheckBox.isSelected()) {
						ckeck = 1;
						}
					String sqlgrapsimo = "insert into demata values(?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps = conn.prepareStatement(sqlgrapsimo);
					System.out.println(id2 + 1);
					ps.setInt(1, id2 + 1);
					ps.setInt(2, trackingnumber);
					ps.setString(3, frmtdtxtfldAsdsd.getText());
					ps.setString(4, frmtdtxtfldSdfafdsf.getText());
					ps.setString(5, frmtdtxtfldDfsgsdfsdfasf.getText());
					ps.setInt(6, Integer.parseInt(formattedTextField_3.getText()));
					ps.setString(7, frmtdtxtfldFdssdfg.getText());
					ps.setInt(8, Integer.parseInt(formattedTextField_5.getText()));
					ps.setInt(9, ckeck);
					ps.setString(10, txtrDfcsbnfhgGhetrgGh.getText());
					ps.setInt(11, katastasi);
					java.sql.Date date = getCurrentJavaSqlDate();
				    ps.setDate(12, date);
					ps.executeUpdate();
					
					
					}catch(Exception e){
				e.printStackTrace();
			}}
			});
		
		
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
