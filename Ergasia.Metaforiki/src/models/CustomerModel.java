package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Observable;
import java.util.Observer;
import additional.ObservableObject;

public class CustomerModel extends Observable {
		
	public ObservableObject<Integer> warning = new ObservableObject<>();
	public ObservableObject<String> trackinginfo = new ObservableObject<>();
	
	public CustomerModel() { }
	
	public void Search(String tracking){
		
		if (tracking.isEmpty()) {
			warning.set(1);
		}else if (!tracking.matches("[A-Za-z]{2}\\d{9}[A-Za-z]{2}|\\d{0}")){
			warning.set(2);
		}else{
			try {
				
				String query;
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				String url = "jdbc:mysql://83.212.109.15/db1?characterEncoding=UTF-8";
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
					//String comments = rs.getString("comments");
					//String status = rs.getString("status");
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
				
				trackinginfo.set(query);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
    public void addWaringObserver(Observer controller) {
    	warning.addObserver(controller);
    }
    
    public void addTrackingInfoObserver(Observer controller) {
    	trackinginfo.addObserver(controller);
    }

}
