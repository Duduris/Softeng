package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.CustomerModel;
import gui.CustomerPanel;

public class CustomerController {

	private CustomerPanel gui;
	private CustomerModel model;
	
	public CustomerController(CustomerPanel gui, CustomerModel model) {
		this.gui = gui;
		gui.btnSearchListener(new BtnSearchListener());
		
		this.model = model;
	}
	
	class BtnSearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Search
			 */
			model.setQuery(gui.getTracking());
			gui.setTrackingInfo(model.retTrackigInfo());
			

		}
	}
	
}
