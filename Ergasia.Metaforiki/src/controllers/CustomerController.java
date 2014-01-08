package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import models.CustomerModel;
import gui.CustomerPanel;

public class CustomerController {

	private CustomerPanel gui;
	private CustomerModel model;

	public CustomerController(CustomerPanel gui , CustomerModel model ) {
		this.gui = gui;
		gui.btnSearchListener(new BtnSearchListener());
		
		this.model = model;
		model.addWaringObserver(new WarningObserver());
		model.addTrackingInfoObserver(new TrackingObserver());
	}

	class BtnSearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			model.Search(gui.getTracking());		

		}
	}
	
	class WarningObserver implements Observer {
		public void update(Observable obs, Object arg) {
			gui.showWarning(model.warning.get());
		}
	}
	
	class TrackingObserver implements Observer {
		public void update(Observable obs, Object arg) {
			gui.setTrackingInfo(model.trackinginfo.get());
		}
	}
	  
	public void clear() {
		gui.clearAll();
	}
	
	

}
