package gui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
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
		
		final JFormattedTextField formattedTextField = new JFormattedTextField();
		panel.add(formattedTextField, "cell 1 0 2 1,grow");
		
		JLabel lblSurname = new JLabel("Surname");
		panel.add(lblSurname, "cell 0 1,alignx center,aligny center");
		
		final JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		panel.add(formattedTextField_1, "cell 1 1 2 1,grow");
		
		JLabel lblAddress = new JLabel("Address");
		panel.add(lblAddress, "cell 0 2,alignx center,aligny center");
		
		final JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		panel.add(formattedTextField_2, "cell 1 2 2 1,grow");
		
		JLabel lblPostalCode = new JLabel("Postal Code");
		panel.add(lblPostalCode, "cell 0 3,alignx center,aligny center");
		
		final JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		panel.add(formattedTextField_3, "cell 1 3 2 1,grow");
		
		JLabel lblCountry = new JLabel("Country");
		panel.add(lblCountry, "cell 0 4,alignx center,aligny center");
		
		final JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		panel.add(formattedTextField_4, "cell 1 4 2 1,grow");
		
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
		
		final JTextArea TextArea = new JTextArea();
		TextArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
		TextArea.setLineWrap(true);
		scrollPane.setViewportView(TextArea);
		
		
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				formattedTextField.setText("");
				formattedTextField_1.setText("");
				formattedTextField_2.setText("");
				formattedTextField_3.setText("");
				formattedTextField_4.setText("");
				formattedTextField_5.setText("");
				chckbxNewCheckBox.setSelected(false);
				TextArea.setText("");
			}
		});
		panel.add(btnClear, "cell 1 8,alignx left,growy");
		
		
		
		JButton btnSubmit = new JButton("Submit");
		panel.add(btnSubmit, "cell 2 8,alignx right,growy");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//elegxos gia tixon null sta Jtextboxes gia null kai arithmous sta string
				if (formattedTextField.getText().length() >= 1 & formattedTextField_1.getText().length() >= 1 & formattedTextField_2.getText().length() >= 1 & formattedTextField_3.getText().length() >= 1 & formattedTextField_4.getText().length() >= 1 & formattedTextField_5.getText().length() >= 1)
				{
					if(formattedTextField_5.getText().matches("^[1000000000-9999999999]+$")){
						if(formattedTextField_3.getText().matches("^[10000-99999]+$")){
							if(formattedTextField.getText().matches("^[a-zA-Z]+$")){
								if(formattedTextField_1.getText().matches("^[a-zA-Z]+$")){							
									if(formattedTextField_4.getText().matches("^[a-zA-Z]+$")){
									
							
						
				try{
					
					
					
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
					String sqldiavasmatr = "select * from demata";
					ResultSet rs1 = stm.executeQuery(sqldiavasmatr);
					int min = 0000000;
					int max = 9999999;
					int x=0,y=10;
					Random r = new Random();
					int trackingnumber;
					trackingnumber = r.nextInt(max - min + 1) + min;
					while (rs1.next()){
					if(rs1.getInt("trackingnumber")==trackingnumber){
						trackingnumber = r.nextInt(max - min + 1) + min;
						}
					}
					
					
					//if (trackingnumber==rs.getInt("trackingnumber"))
					
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
					ps.setString(3, formattedTextField.getText());
					ps.setString(4, formattedTextField_1.getText());
					ps.setString(5, formattedTextField_2.getText());
					ps.setInt(6, Integer.parseInt(formattedTextField_3.getText()));
					ps.setString(7, formattedTextField_4.getText());
					ps.setInt(8, Integer.parseInt(formattedTextField_5.getText()));
					ps.setInt(9, ckeck);
					ps.setString(10, TextArea.getText());
					ps.setInt(11, katastasi);
					java.sql.Date date = getCurrentJavaSqlDate();
				    ps.setDate(12, date);
					ps.executeUpdate();
					
					formattedTextField.setText("");
					formattedTextField_1.setText("");
					formattedTextField_2.setText("");
					formattedTextField_3.setText("");
					formattedTextField_4.setText("");
					formattedTextField_5.setText("");
					chckbxNewCheckBox.setSelected(false);
					TextArea.setText("");
					
					JOptionPane.showMessageDialog(null,"The tracking number for \n this package is: " + trackingnumber,"Wanring",JOptionPane.WARNING_MESSAGE);;
					
					}catch(Exception e){
				e.printStackTrace();
					}
									}else JOptionPane.showMessageDialog(null,"Field Country takes only letters","Wanring",JOptionPane.WARNING_MESSAGE);;
								}else JOptionPane.showMessageDialog(null,"Field Surname takes only letters","Wanring",JOptionPane.WARNING_MESSAGE);;
							
							}else JOptionPane.showMessageDialog(null,"Field Name takes only letters","Wanring",JOptionPane.WARNING_MESSAGE);;
					}else JOptionPane.showMessageDialog(null,"Field PostalCode takes only 5-digit numbers","Wanring",JOptionPane.WARNING_MESSAGE);;
					
						
						}else JOptionPane.showMessageDialog(null,"Field Phone takes only 10-digit numbers","Wanring",JOptionPane.WARNING_MESSAGE);;
				}
				
				else JOptionPane.showMessageDialog(null,"All the fields are mandatory! \n (Except for comments)","Wanring",JOptionPane.WARNING_MESSAGE);;
			}
			
			});
		
		
		/* 
		 * Tab 2
		 */
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Search", null, panel_1, null);
		panel_1.setLayout(new MigLayout("", "[125.00][100.00,grow]", "[30][30][30][30][30][30][30][30][125.00,grow]"));
		
		JLabel lblName1 = new JLabel("Name");
		panel_1.add(lblName1, "cell 0 1,alignx center,aligny center");
		
		final JFormattedTextField formattedTextField1 = new JFormattedTextField();
		panel_1.add(formattedTextField1, "cell 1 0,grow");
		
		JLabel lblSurname1 = new JLabel("Surname");
		panel_1.add(lblSurname1, "cell 0 2,alignx center,aligny center");
		
		final JFormattedTextField formattedTextField2 = new JFormattedTextField();
		panel_1.add(formattedTextField2, "cell 1 1,grow");
		
		JLabel lblAddress1 = new JLabel("Address");
		panel_1.add(lblAddress1, "cell 0 3,alignx center,aligny center");
		
		final JFormattedTextField formattedTextField3 = new JFormattedTextField();
		panel_1.add(formattedTextField3, "cell 1 2,grow");
		
		JLabel lblPostalCode1 = new JLabel("Postal Code");
		panel_1.add(lblPostalCode1, "cell 0 4,alignx center,aligny center");
		
		final JFormattedTextField formattedTextField4 = new JFormattedTextField();
		panel_1.add(formattedTextField4, "cell 1 3,grow");
		
		JLabel lblCountry1 = new JLabel("Country");
		panel_1.add(lblCountry1, "cell 0 5,alignx center,aligny center");
		
		final JFormattedTextField formattedTextField5 = new JFormattedTextField();
		panel_1.add(formattedTextField5, "cell 1 4,grow");
		
		JLabel lblPhoneNumber1 = new JLabel("Phone Number");
		panel_1.add(lblPhoneNumber1, "cell 0 6,alignx center,aligny center");
		
		final JFormattedTextField formattedTextField6 = new JFormattedTextField();
		panel_1.add(formattedTextField6, "cell 1 5,grow");
		
		JLabel lblTracking = new JLabel("Tracking Number");
		panel_1.add(lblTracking, "cell 0 0,alignx center,aligny center");
		
		final JFormattedTextField formattedTextField7 = new JFormattedTextField();
		panel_1.add(formattedTextField7, "cell 1 6,grow");
		
		JButton btnClear_1 = new JButton("Clear");
		btnClear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formattedTextField1.setText("");
				formattedTextField2.setText("");
				formattedTextField3.setText("");
				formattedTextField4.setText("");
				formattedTextField5.setText("");
				formattedTextField6.setText("");
				formattedTextField7.setText("");
			}
		});
		panel_1.add(btnClear_1, "flowx,cell 1 7,growy");
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String trackingnumber = formattedTextField1.getText();
				String name = formattedTextField2.getText();
				String surname = formattedTextField3.getText();
				String address = formattedTextField4.getText();
				String tk = formattedTextField5.getText();
				String country = formattedTextField6.getText();
				String phonenumber = formattedTextField7.getText();
				
				int z=0;
				if (formattedTextField1.getText().length() >= 1 || formattedTextField2.getText().length() >= 1 || formattedTextField3.getText().length() >= 1 || formattedTextField4.getText().length() >= 1 || formattedTextField5.getText().length() >= 1 || formattedTextField6.getText().length() >= 1 || formattedTextField7.getText().length() >= 1){
					if(formattedTextField1.getText().matches("^[10000000-99999999]+$")){
						if(formattedTextField5.getText().matches("^[10000-99999]+$")){
							if(formattedTextField7.getText().matches("^[1000000000-9999999999]+$")){
					
					if(formattedTextField2.getText().matches("^[a-zA-Z]+$")){
						if(formattedTextField3.getText().matches("^[a-zA-Z]+$")){
							if(formattedTextField6.getText().matches("^[a-zA-Z]+$")){
						
					String x ="select * from demata where ";
					
					if(formattedTextField1.getText().length() >= 1){
						x = x + "trackingnumber=" + trackingnumber;
						z = 1;
					}
					if(formattedTextField2.getText().length() >= 1 & z==1){
						x = x + " And onoma=" + "'"  + name + "'" ;	
					}else if (formattedTextField2.getText().length() >= 1){
						x = x + " onoma=" + "\"" + name + "\"";
						z=1;
						}else {
							z=2;
							}
					if(formattedTextField3.getText().length() >= 1 & z==1){
						x = x + " And epitheto=" + "\""  + surname + "\"" ;	
					}else if (formattedTextField3.getText().length() >= 1){
						x = x + " epitheto=" + "\""  + surname + "\"" ;
						z=1;
						}
					if(formattedTextField4.getText().length() >= 1 & z==1){
						x = x + " And address=" + "\"" + address + "\"" ;	
					}else if (formattedTextField4.getText().length() >= 1){
						x = x + " address=" + "\""  + address + "\"" ;
						z=1;
						}
					if(formattedTextField5.getText().length() >= 1 & z==1){
						x = x + " And tk=" + tk;	
					}else if (formattedTextField5.getText().length() >= 1){
						x = x + " tk=" + tk;
						z=1;
						}
					if(formattedTextField6.getText().length() >= 1 & z==1){
						x = x + " And xwra=" + "\""  + country + "\"" ;	
					}else if (formattedTextField6.getText().length() >= 1){
						x = x + " xwra=" + "\""  + country + "\"" ;
						z=1;
						}
					if(formattedTextField7.getText().length() >= 1 & z==1){
						x = x + " And phone=" + phonenumber;	
					}else if (formattedTextField7.getText().length() >= 1){
						x = x + " phone=" + phonenumber;
						z=1;
						}
				
					System.out.println(x);
					TableFromDatabase c =new TableFromDatabase(x);
			        c.pack();
			        c.setVisible(true);
							}
							else JOptionPane.showMessageDialog(null,"The Country field takes only letters","Wanring",JOptionPane.WARNING_MESSAGE);;
						}
						else JOptionPane.showMessageDialog(null,"The Surname field takes only letters","Wanring",JOptionPane.WARNING_MESSAGE);;	
					}
					else JOptionPane.showMessageDialog(null,"The Name field takes only letters","Wanring",JOptionPane.WARNING_MESSAGE);;
				} 
								else JOptionPane.showMessageDialog(null,"The PhoneNumber field takes only 10-digit numbers","Wanring",JOptionPane.WARNING_MESSAGE);;
							}else JOptionPane.showMessageDialog(null,"The PostalCode field takes only 5-digit numbers","Wanring",JOptionPane.WARNING_MESSAGE);;
					}else JOptionPane.showMessageDialog(null,"The TrackingNumber field takes only 8-digit numbers","Wanring",JOptionPane.WARNING_MESSAGE);;
				}
				else JOptionPane.showMessageDialog(null,"Fill at least one Field","Wanring",JOptionPane.WARNING_MESSAGE);;
				
			}
		});
		panel_1.add(btnSearch, "cell 1 7,growy");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane_1, "cell 1 8,grow");
		scrollPane_1.setVisible(false);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		JButton Everything = new JButton("Show Everything");
		Everything.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql ="Select * from demata";
				TableFromDatabase c =new TableFromDatabase(sql);
		        c.pack();
		        c.setVisible(true);
				
			}
		});
		panel_1.add(Everything, "cell 1 7");

	}
}
