package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.CustomerPanel;

public class CustomerPanelController {

	private CustomerPanel gui;
	
	public CustomerPanelController(CustomerPanel gui) {
		this.gui = gui;
		gui.btnSearchListener(new BtnSearchListener());
	}
	
	class BtnSearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Search
			 */

		}
	}
	
}
