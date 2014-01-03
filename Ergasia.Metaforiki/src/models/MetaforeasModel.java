package models;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import additional.GreekToGreeklish;
import additional.ObservableInt;
import additional.ObservableStringArray;

public class MetaforeasModel extends Observable{
	
	private ObservableInt switchpa = new ObservableInt();
	private ObservableStringArray tbrow = new ObservableStringArray();
	
	public MetaforeasModel() {}
	
	public String Submit(String combobx, int id) {
		
		if (combobx.equals("OK"))
			combobx = "DELIVERED";
		
		if (id >= 0){
			id++;
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				String url = "jdbc:mysql://83.212.109.15/db1?characterEncoding=UTF-8";
				String username = "root";
				String pass = "36966";

				Connection conn = DriverManager.getConnection(url, username, pass);

				String sqlgrapsimo = "update metaforiki set status='"+combobx.toLowerCase()+"' where id="+id;
				PreparedStatement ps = conn.prepareStatement(sqlgrapsimo);
				ps.executeUpdate();

				ps.close();
				conn.close();
				
				return combobx;

			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		return combobx;
	}
	
	public String Info(int id, int pa){
		
		pa = (pa > 2)? 1: 3;
		if (pa != 3)
			switchpa.set(pa);
		
		if (pa == 3 && id >= 0){
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				String url = "jdbc:mysql://83.212.109.15/db1?characterEncoding=UTF-8";
				String username = "root";
				String pass = "36966";

				Connection conn = DriverManager.getConnection(url, username, pass);
				Statement stm = conn.createStatement();
				
				switchpa.set(pa);
				id++;
				
				String sqldiavasmaid = "select * from metaforiki where id="+id;
				ResultSet rs = stm.executeQuery(sqldiavasmaid);
				
				rs.next();
				
				String info = "Packet Information\n\n";
				
				info +="Tracking Number:\t"+ rs.getString("tracking")+"\n";
				info +="Posted on:\t"+ rs.getString("date")+"\n";
				info +="Status:\t\t"+ rs.getString("status").toUpperCase()+"\n";
				info +="\nDestination\n\n";
				info +="Name:\t\t"+ rs.getString("name")+"\n";
				info +="Surname:\t\t"+ rs.getString("surname")+"\n";
				info +="Address:\t\t"+ rs.getString("address")+"\n";
				info +="Postal Code:\t"+ rs.getString("postalcode")+"\n";
				info +="Country:\t\t"+ rs.getString("country")+"\n";
				info +="\nComments\n\n"+ rs.getString("comments");
				
				rs.close();
				stm.close();
				conn.close();
				
				return info;

			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	public ImageIcon Map(int id, int pa, int[] dim) {
		
		pa = (pa == 2)? 1: 2;
		if (pa != 2)
			switchpa.set(pa);
		
		if (pa == 2 && id >= 0){
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				String url = "jdbc:mysql://83.212.109.15/db1?characterEncoding=UTF-8";
				String username = "root";
				String pass = "36966";

				Connection conn = DriverManager.getConnection(url, username, pass);
				Statement stm = conn.createStatement();

				switchpa.set(pa);
				id++;
				
				String x = Integer.toString(dim[0]-10);
				String y = Integer.toString(dim[1]-10); 
				
				String sqldiavasmaid = "select * from metaforiki where id="+id;
				ResultSet rs = stm.executeQuery(sqldiavasmaid);
				
				rs.next();

				String address = rs.getString("address").replaceAll(" ", "+");
				String postalcode = rs.getString("postalcode");
				String country = rs.getString("country").replaceAll(" ", "+");;
				
				address = GreekToGreeklish.convert(address);
				country = GreekToGreeklish.convert(country);
				
				String imageUrl = "http://maps.googleapis.com/maps/api/staticmap?";
				imageUrl += "center="+address+","+postalcode+","+country;
				imageUrl +=	"&zoom=16&size="+y+"x"+x+"&maptype=roadmap";
				imageUrl += "&markers=color:red%7Clabel:A%7C"+address+","+postalcode+","+country;
				imageUrl += "&sensor=false";
				
				try {
					URL url1;
					url1 = new URL(imageUrl);
					ImageIcon img = new ImageIcon(new ImageIcon(url1).getImage());
					return img;
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
			}catch(Exception e1){
				e1.printStackTrace();
			}

		}
		return null;
	}
	
	public void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String url = "jdbc:mysql://83.212.109.15/db1?characterEncoding=UTF-8";
			String username = "root";
			String pass = "36966";

			Connection conn = DriverManager.getConnection(url, username, pass);
			Statement stm = conn.createStatement();

			String[] tablerow = new String [4];
			
			//kanonika o kathe metaforeas den tha kanei select ola.. alla analoga me to postal code
			
			String sqldiavasmaid = "select * from metaforiki order by id";
			ResultSet rs = stm.executeQuery(sqldiavasmaid);
			
			
			while(rs.next()) {
				tablerow[0] = rs.getString("name");
				tablerow[1] = rs.getString("surname");
				tablerow[2] = rs.getString("address");
				tablerow[3] = rs.getString("status").toUpperCase();
				
				tbrow.set(tablerow);
			}
			rs.close();
			stm.close();
			conn.close();

		}catch(Exception e1){
			e1.printStackTrace();
		}

	}
	
	
	public int getPanel() {
		return switchpa.get();
	}
	
	public void resetPanel() {
		switchpa.set(1);
	}
	
    public void addPanelObserver(Observer controller) {
    	switchpa.addObserver(controller);
    }
    
    public String[] getTableRow() {
    	return tbrow.get();
    }
    
    public void addTBRObserver(Observer controller) {
    	tbrow.addObserver(controller);
    }

}
