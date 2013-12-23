package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import models.CustomerModel;
import gui.CustomerPanel;

public class CustomerController {

	private CustomerPanel gui;

	// private CustomerModel model;

	public CustomerController(CustomerPanel gui/* , CustomerModel model */) {
		this.gui = gui;
		gui.btnSearchListener(new BtnSearchListener());

		// this.model = model;
	}

	class BtnSearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Search
			 */
			
			//omios tha metaferthoun sto adistixo model
			
			String tracking = gui.getTracking();
			if (!tracking.isEmpty()) {
				try {
					
					String query;
					
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					String url = "jdbc:mysql://83.212.109.15/db1";
					String username = "root";
					String pass = "36966";

					Connection conn = DriverManager.getConnection(url, username, pass);
					Statement stm = conn.createStatement();

					String sql = "select * from metaforiki where tracking='"+ tracking + "'";

					ResultSet rs = stm.executeQuery(sql);

					if (rs.next()) {
						String name = rs.getString("name");
						String surname = rs.getString("surname");
						String country = rs.getString("country");
						String comments = rs.getString("comments");
						String status = rs.getString("status");
						String date = rs.getString("date");

						query = "To be delivered to:\t" + surname + " " + name
								+ "\n" + "Destination:\t\t" + country + "\n"
								+ "Posted:\t\t" + date;
					}else{
						query = "Tracking: "+tracking+" was not found";
					}
					rs.close();
					stm.close();
					conn.close();
					
					gui.setTrackingInfo(query);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}else{
				gui.showWarning();
			}

		}
	}

}
