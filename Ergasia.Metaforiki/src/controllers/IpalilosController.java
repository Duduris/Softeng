package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import gui.IpalilosPanel;

public class IpalilosController {

	private IpalilosPanel gui;
	
	public IpalilosController(IpalilosPanel gui) {
		this.gui = gui;
		gui.btnClearListener(new BtnClearListener());
		gui.btnSubmitListener(new BtnSubmitListener());
		gui.btnSearchListener(new BtnSearchListener());
		gui.btnClear2Listener(new BtnClear2Listener());
		
	}
	
	class BtnClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Panel1 Clear
			 */
			
			gui.clearTextBoxesPacket();

		}
	}
	
	class BtnSubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Panel1 Submit
			 */
			
			
			
			//prepei na mpei sto adistixo model dokimastika gia tora na kanoume doulia
			
			 String[] text = new String[8];
			 boolean[] warning = new boolean[6];
			 
			 text = gui.getTextBoxesPacket();
			 
			 for (int i = 0; i < 5; i++)
				 if (text[i].length() == 0 )
					 warning[5] = true;
			 
			 warning[0] = !text[0].matches("[a-zA-Z\\s]*");
			 warning[1] = !text[1].matches("[a-zA-Z\\s]*");
			 warning[2] = !text[3].matches("\\d{5}|\\d{5}");
			 warning[3] = !text[4].matches("[a-zA-Z\\s]*");
			 warning[4] = !text[5].matches("\\d{10}|\\d{7}");
			
			 gui.displayWarningsP1(warning);
			 
			 boolean ready = true;
			 
			 for (int i = 0; i < 6; i++) {
				 if (warning[i] == true) {
					 ready = false;
					 break;
				 }
			 }
			 
			 if (ready == true) {
				 try {
					 Class.forName("com.mysql.jdbc.Driver").newInstance();

					 String url = "jdbc:mysql://83.212.109.15/db1";
					 String username = "root";
					 String pass = "36966";
					 /*
					  * O pinakas gia reference - den mporousa na sindtho stin alli vasi...
					  * create table metaforiki (
					  * id int, name varchar(20), surname varchar(20),
					  * address varchar(50), postalcode int, country varchar(20),
					  * phone varchar(10), fragile tinyint(1), tracking varchar(14),
					  * comments tinytext,
					  * status enum('undelivered','delivered','damaged','unavailable','wrong address') not null default 'undelivered',
					  * date datetime
					  * );
					  */
					 Connection conn = DriverManager.getConnection(url, username, pass);
					 Statement stm = conn.createStatement();
					 
					 int id = 0;
					 String sqldiavasmaid = "select id from metaforiki";
					 ResultSet rs = stm.executeQuery(sqldiavasmaid);
					 while(rs.next()) {
						 id = rs.getInt("id");
					 }
					 
					 String sqldiavasmatn = "select tracking from metaforiki";
					 ResultSet rs1 = stm.executeQuery(sqldiavasmatn);
					 int min = 000000000;
					 int max = 999999999;
					 int x=0,y=10;
					 Random r = new Random();
					 int trackingnumber;
					 trackingnumber = r.nextInt(max - min + 1) + min;
					 while (rs1.next()){
						 if(rs1.getString("tracking").regionMatches(3, Integer.toString(trackingnumber), 11, 13)){
							 trackingnumber = r.nextInt(max - min + 1) + min;
						 }
					 }

					 String sqlgrapsimo = "insert into metaforiki values(?,?,?,?,?,?,?,?,?,?,?,?)";
					 PreparedStatement ps = conn.prepareStatement(sqlgrapsimo);
					 ps.setInt(1, id + 1);
					 ps.setString(2, text[0]);
					 ps.setString(3, text[1]);
					 ps.setString(4, text[2]);
					 ps.setInt(5, Integer.parseInt(text[3]));
					 ps.setString(6, text[4]);
					 ps.setString(7, text[5]);
					 if (text[6].equals("t"))
						 ps.setInt(8, 1);
					 else
						 ps.setInt(8, 0);
					 ps.setString(9, Integer.toString(trackingnumber));
					 ps.setString(10, text[7]);
					 java.sql.Date date = getCurrentJavaSqlDate();
					 ps.setString(11, "undelivered");
					 ps.setDate(12, date);
					 ps.executeUpdate();

					 gui.setTrackingNumb("RE"+Integer.toString(trackingnumber)+"GR");
						
						
				 }catch(Exception e1){
					 e1.printStackTrace();
				 }
			 }

		}
		
		public java.sql.Date getCurrentJavaSqlDate() {
		    java.util.Date today = new java.util.Date();
		    return new java.sql.Date(today.getTime());
		}
	}
	
	class BtnSearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Panel2 Search
			 */

		}
	}
	
	class BtnClear2Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Panel2 Clear
			 */

		}
	}
}
