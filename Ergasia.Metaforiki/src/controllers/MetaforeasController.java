package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import gui.MetaforeasPanel;

public class MetaforeasController {
	
	private MetaforeasPanel gui;
	
	public MetaforeasController(MetaforeasPanel gui){
		this.gui = gui;
		gui.btnSubmitListener(new BtnSumitListener());
		gui.btnMapListener(new BtnMapListener());
		gui.btnConnectListener(new BtnConnectListener());
		
	}
	
	class BtnSumitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Submit
			 */
			String combobx;
			int id = 0;
			combobx = gui.getItemStatus();
			if (combobx.equals("OK"))
				combobx = "DELIVERED";
			id = gui.getTableRow();
			
			if (id >= 0){
				id++;
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();

					String url = "jdbc:mysql://83.212.109.15/db1";
					String username = "root";
					String pass = "36966";

					Connection conn = DriverManager.getConnection(url, username, pass);

					String sqlgrapsimo = "update metaforiki set status='"+combobx.toLowerCase()+"' where id="+id;
					PreparedStatement ps = conn.prepareStatement(sqlgrapsimo);
					ps.executeUpdate();

					ps.close();
					conn.close();
					gui.updateStatus(combobx);

				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		}
	}
	
	class BtnMapListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Map
			 */

		}
	}
	
	class BtnConnectListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Connect
			 */
			
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				String url = "jdbc:mysql://83.212.109.15/db1";
				String username = "root";
				String pass = "36966";

				Connection conn = DriverManager.getConnection(url, username, pass);
				Statement stm = conn.createStatement();

				String[] tablerow = new String [4];
				
				//kanonika o kathe metaforeas den tha kanei select ola.. alla analoga me to postal code
				
				String sqldiavasmaid = "select * from metaforiki order by id";
				ResultSet rs = stm.executeQuery(sqldiavasmaid);
				
				gui.clearTable();
				
				while(rs.next()) {
					tablerow[0] = rs.getString("name");
					tablerow[1] = rs.getString("surname");
					tablerow[2] = rs.getString("address");
					tablerow[3] = rs.getString("status").toUpperCase();
					
					gui.setTableData(tablerow);
				}
				rs.close();
				stm.close();
				conn.close();

			}catch(Exception e1){
				e1.printStackTrace();
			}

		}
	}
	
}
