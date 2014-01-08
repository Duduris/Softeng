package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import models.MetaforeasModel;
import gui.MetaforeasPanel;

public class MetaforeasController {
	
	private MetaforeasPanel gui;
	private MetaforeasModel model;
	
	public MetaforeasController(MetaforeasPanel gui, MetaforeasModel model){
		this.gui = gui;
		gui.btnSubmitListener(new BtnSumitListener());
		gui.btnMapListener(new BtnMapListener());
		gui.btnConnectListener(new BtnConnectListener());
		gui.btnMoreListener(new BtninfoListener());
		
		this.model = model;
		model.addPanelObserver(new PanelObserver());
		model.addTBRObserver(new TBRObserver());
		
	}
	
	class BtnSumitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Submit
			 */
			gui.clearMap();
			gui.switchPanel(1);
			gui.updateStatus(model.Submit(gui.getItemStatus(), gui.getTableRow()));
			
		}
	}
	
	class BtninfoListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * info
			 */
			gui.clearMap();
			gui.setInfo(model.Info(gui.getTableRow(), gui.getPanel()));

		}
	}
	
	class BtnMapListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Map
			 */
			gui.clearMap();
			gui.setGmap(model.Map(gui.getTableRow(), gui.getPanel(), gui.getGmapSize()));

		}
	}
	
	class BtnConnectListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Connect
			 */
			gui.switchPanel(1);
			model.switchpanel.set(1);;
			gui.clearMap();
			gui.clearTable();
			model.Connect();
			
		}
	}
	
	class PanelObserver implements Observer {
		public void update(Observable obs, Object arg) {
			gui.switchPanel(model.switchpanel.get());
		}
	}
	
	class TBRObserver implements Observer {
		public void update(Observable obs, Object arg) {
			gui.setTableData(model.tbrow.get());
		}
	}
	
	public void clear(){
		gui.clearAll();
	}
}
