package controllers;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JTable;

import additional.TableColumnAdjuster;
import gui.IpalilosPanel;

public class IpalilosController {

	private IpalilosPanel gui;
	private JFrame frame;
	private JTable table;
	private JTable copytable;
	
	public IpalilosController(IpalilosPanel gui) {
		this.gui = gui;
		gui.btnClearListener(new BtnClearListener());
		gui.btnSubmitListener(new BtnSubmitListener());
		gui.btnSearchListener(new BtnSearchListener());
		gui.btnClear2Listener(new BtnClear2Listener());
		gui.btnExportListener(new BtnExportListener());
		gui.btnSubmitTableListener(new BtnSubmitTableListener());
		
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
			 
			 warning[0] = !text[0].matches("[a-zA-Zá-ùÁ-Ù\\s]*");
			 warning[1] = !text[1].matches("[a-zA-Zá-ùÁ-Ù\\s]*");
			 warning[2] = !text[3].matches("\\d{5}|\\d{5}");
			 warning[3] = !text[4].matches("[a-zA-Zá-ùÁ-Ù\\s]*");
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

					 String url = "jdbc:mysql://83.212.109.15/db1?characterEncoding=UTF-8";
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

					 Random r = new Random();
					 String trackingnumber = String.format("%09d", r.nextInt(1000000000));
					 while (rs1.next()){
						 if(rs1.getString("tracking").regionMatches(3, trackingnumber, 11, 13)){
							 trackingnumber = String.format("%09d", r.nextInt(1000000000));
						 }
					 }
					 trackingnumber = "RE"+trackingnumber+"GR";

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
					 ps.setString(9, trackingnumber);
					 ps.setString(10, text[7]);
					 ps.setString(11, "undelivered");
					 ps.setTimestamp(12, new Timestamp(System.currentTimeMillis()));
					 ps.executeUpdate();

					 gui.setTrackingNumb(trackingnumber);
					 
			         rs.close();
			         stm.close();
			         conn.close();
						
						
				 }catch(Exception e1){
					 e1.printStackTrace();
				 }
			 }

		}
		
	}
	
	class BtnSearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Panel2 Search
			 */
			String[] text = new String[7];
			boolean[] warning = new boolean[8];
			gui.clearTable();
			text = gui.getTextBoxesSearch();
			
			int i, count = 0;
			for (i = 0; i < 7; i++)
				if (text[i].length() == 0 )
					count++;
			warning[7] = (count == i)?true:false;	
					
			if (!warning[7]){		
				warning[0] = !text[0].matches("[A-Za-z]{2}\\d{9}[A-Za-z]{2}|\\d{0}");
				warning[1] = !text[1].matches("[a-zA-Zá-ùÁ-Ù\\s]*");
				warning[2] = !text[2].matches("[a-zA-Zá-ùÁ-Ù\\s]*");
				warning[3] = !text[3].matches("[a-zA-Zá-ùÁ-Ù\\s]*");
				warning[4] = !text[4].matches("\\d{5}|\\d{0}");
				warning[5] = !text[5].matches("[a-zA-Zá-ùÁ-Ù\\s]*");
				warning[6] = !text[6].matches("\\d{10}|\\d{0}");
			}
			gui.displayWarningsP2(warning);
			
			boolean ready = true;
			
			for (i = 0; i < 8; i++)
				if (warning[i])
					ready = false;
			
			if (ready){
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();

					String url = "jdbc:mysql://83.212.109.15/db1?characterEncoding=UTF-8";
					String username = "root";
					String pass = "36966";
					
					Connection conn = DriverManager.getConnection(url, username, pass);
					Statement stm = conn.createStatement();

					String database[] = { " tracking="," name="," surname="," address="," postalcode="," country="," phone=" }; 
					String x = "select * from metaforiki where";
					String y = " and";
					boolean first = true;
					
					for (i = 0; i < 7; i++){
						if (!text[i].isEmpty()){
							if (first == true){
								x += database[i] +"'"+ text[i]+"'";
								first = false;
							}else{
								x += y + database[i] +"'"+ text[i]+"'";
							}
						}
					}
					
					String[] responce = new String[10];
					ResultSet rs = stm.executeQuery(x);
					int y1 =0;
					while (rs.next()){
						y1++;
						for (i = 0; i < 10; i++)
							responce[i] = rs.getString(i+2);
						gui.updateStatus(responce);
					}
					if (y1 == 0)
						gui.notFound(true);
					else 
						gui.notFound(false);
					
					copytable = new JTable(gui.retTable());
					

				}catch(Exception e1){
					e1.printStackTrace();
				}
				
			}

		}
	}
	
	class BtnClear2Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Panel2 Clear
			 */
			gui.clearTextBoxesSearch();

		}
	}
	
	class BtnExportListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Panel2 Export
			 */
			frame = new JFrame("Demata");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			JTable table = new JTable(gui.retTable());
			TableColumnAdjuster tca = new TableColumnAdjuster(table);
			frame.setType(Type.POPUP);
			frame.add(table);
			tca.adjustColumns();
			frame.pack();
			frame.setVisible(true);

		}
	}
	
	class BtnSubmitTableListener implements  ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Panels 2 Submit
			 */
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				String url = "jdbc:mysql://83.212.109.15/db1?characterEncoding=UTF-8";
				String username = "root";
				String pass = "36966";
				
				Connection conn = DriverManager.getConnection(url, username, pass);
				Statement stm = conn.createStatement();

				String x = "update metaforiki set";
				String y = " where tracking=";
				String database[] = { " name="," surname="," address="," postalcode="," country="," phone="," fragile="," tracking="," comments="," status=" };
				int count;
				String response = "";
				
				table = new JTable(gui.retTable());

				Object tablecell;
				Object table2cell;
				

				for (int i = 0; i < table.getRowCount(); i++ ) {
					response ="";
					response += x;
					count = 0;
					for (int j = 0 ; j < 10; j++) {
						tablecell = copytable.getValueAt(i, j);
						table2cell = table.getValueAt(i, j); // to kenourio
						if (tablecell != table2cell) {
							count++;
							if (count == 1)
								response += database[j] +"'"+table2cell+"'";
							else 
								response += "," + database[j] +"'"+table2cell+"'";
						}
					}
					response += y +"'"+ table.getValueAt(i, 7)+"'";
					if (count > 0)
						stm.executeUpdate(response);
						gui.submmited(true);
				}
			}catch(Exception e1){
				e1.printStackTrace();
			}
			
		}
	}
	
	public void clear() {
		gui.clearTable();
		gui.clearTextBoxesPacket();
		gui.clearTextBoxesSearch();
		gui.clearAll();
		if (frame != null)
			frame.dispose();
	}
	
}
