package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.MetaforeasPanel;

public class MetaforeasController {
	
	private MetaforeasPanel gui;
	
	public MetaforeasController(MetaforeasPanel gui){
		this.gui = gui;
		gui.btnSubmitListener(new BtnSumitListener());
		gui.btnMapListener(new BtnSumitListener());
		gui.btnExitListener(new BtnSumitListener());
		
	}
	
	class BtnSumitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Submit
			 */
			String[] a = {"erer","gfgfdg","gfgdf"};
			gui.setTableData(a);
		}
	}
	
	class BtnMapListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Map
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
