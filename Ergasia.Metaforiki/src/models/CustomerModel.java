package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Observable;

public class CustomerModel extends Observable {
	
	private String tracking;
	private String query;
	
	public CustomerModel() {

	}
	
	public void setQuery(String tracking) {
		this.tracking = tracking;
		/*setChanged();
		notifyObservers(this.tracking);*/
		
	}
	
	public String retTrackigInfo() {
		return query;
	}
}
