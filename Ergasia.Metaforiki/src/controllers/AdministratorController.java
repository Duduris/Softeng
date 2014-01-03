package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.AdministratorModel;
import gui.AdministratorPanel;

public class AdministratorController {
	
	private AdministratorPanel gui;
	private AdministratorModel model;

	public AdministratorController(AdministratorPanel gui ,AdministratorModel model) {
		this.gui = gui;
		gui.btnExportListener(new BtnExportListener());
		gui.comboBxListener(new ComboBoxListener());
		
		this.model = model;
	}
	
	class ComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * ComboBox
			 */
			gui.setChart(model.ComboBox(gui.getItemStatus()));

		}
	}
	
	class BtnExportListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Export
			 */
			model.Export();
		}
	}
	
	public void clear() {
		gui.clear();
	}
	

}
