package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.jfree.data.general.DefaultPieDataset;

import gui.AdministratorPanel;

public class AdministratorController {
	
	private AdministratorPanel gui;

	public AdministratorController(AdministratorPanel gui) {
		this.gui = gui;
		gui.btnExportListener(new BtnExportListener());
		gui.btnExitListener(new BtnExitListener());
		gui.comboBxListener(new ComboBoxListener());
	}
	
	class ComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * ComboBox
			 */
			String selection;
			DefaultPieDataset dataset;
			selection = gui.getItemStatus();
			
			if (!selection.equals("None")){
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();

					String url = "jdbc:mysql://83.212.109.15/db1";
					String username = "root";
					String pass = "36966";
					Connection conn = DriverManager.getConnection(url, username, pass);
					Statement stm = conn.createStatement();

					int idall = 0;
					int idquery = 0;
					String query = "tracking=true";

					ResultSet rs = stm.executeQuery("select id from metaforiki");
					while(rs.next()) {
						idall++;
					}

					if (selection.equals("Fragile"))
						query = "fragile=1";
					if (selection.equals("Delivered"))
						query = "status='delivered'";
					if (selection.equals("To be Delivered"))
						query = "status='undelivered'";
					if (selection.equals("Damaged"))
						query = "status='damaged'";
					if (selection.equals("Unavailable"))
						query = "status='unavailable'";
					if (selection.equals("Wrong Address"))
						query = "status='wrong address'";
					
					rs = stm.executeQuery("select id from metaforiki where "+query);
					
					while(rs.next()) {
						idquery++;
					}
					dataset = new DefaultPieDataset();
					
					dataset.setValue(selection, idquery);
					dataset.setValue("OK",idall - idquery);

					rs.close();
					stm.close();
					conn.close();
					
					gui.setChart(dataset);

				}catch(Exception e1){
					e1.printStackTrace();
				}
			}

		}
	}
	
	class BtnExportListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Export
			 */

		}
	}
	
	class BtnExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Exit
			 */

		}
	}
}
