package models;

import java.util.Observable;

public class CustomerModel extends Observable {
	
	private String tracking;
	private String query = "Test    dfgdgdffffffffffffffffffgdfgdgdfg rtr	fdgd	fsdfgdfg";
	
	public CustomerModel() {

	}
	
	public void setQuery(String tracking) {
		this.tracking = tracking;
		setChanged();
		notifyObservers(this.tracking);

	}
	
	public String retTrackigInfo() {
		return query;
	}
}
