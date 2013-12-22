package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.AdministratorPanel;

public class AdministratorController {
	
	private AdministratorPanel gui;

	public AdministratorController(AdministratorPanel gui) {
		this.gui = gui;
		gui.btnExportListener(new BtnExportListener());
		gui.btnExitListener(new BtnExitListener());
		
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