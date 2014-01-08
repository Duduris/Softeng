package controllers;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JTable;
import models.IpalilosModel;
import additional.TableColumnAdjuster;
import gui.IpalilosPanel;

public class IpalilosController {

	private IpalilosPanel gui;
	private IpalilosModel model;
	private JFrame frame;
	
	public IpalilosController(IpalilosPanel gui ,IpalilosModel model) {
		this.gui = gui;
		gui.btnClearListener(new BtnClearListener());
		gui.btnSubmitListener(new BtnSubmitListener());
		gui.btnSearchListener(new BtnSearchListener());
		gui.btnClear2Listener(new BtnClear2Listener());
		gui.btnExportListener(new BtnExportListener());
		gui.btnSubmitTableListener(new BtnSubmitTableListener());
		
		this.model = model;
		model.addPanel1WaringObserver(new Panel1WarningObserver());
		model.addPanel2WaringObserver(new Panel2WarningObserver());
		model.addPanel2SearchObserver(new Panel2SearchObserver());
		model.addPanel2FoundObserver(new Panel2FoundObserver());
		
	}
	
	class BtnClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Panel1 Clear
			 */
			
			gui.clearTextBoxesPacket();

		}
	}
	
	class BtnSubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Panel1 Submit
			 */
			
			gui.setTrackingNumb(model.Panel1Submit(gui.getTextBoxesPacket()));
			
		}
		
	}
	
	class BtnSearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Panel2 Search
			 */
			
			gui.clearTable();
			model.Panel2Search(gui.getTextBoxesSearch());
			model.getTableRow(gui.retTable());

		}
	}
	
	class BtnClear2Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Panel2 Clear
			 */
			gui.clearTextBoxesSearch();

		}
	}
	
	class BtnExportListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Panel2 Export
			 */
			frame = new JFrame("Demata");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			JTable table = new JTable(gui.retTable());
			TableColumnAdjuster tca = new TableColumnAdjuster(table);
			frame.setType(Type.POPUP);
			frame.add(table);
			tca.adjustColumns();
			frame.pack();
			frame.setVisible(true);

		}
	}
	
	class BtnSubmitTableListener implements  ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Panels 2 Submit
			 */
			
			gui.submmited(model.Panel2Submit(gui.retTable()));
			
		}
	}
	
	
	class Panel1WarningObserver implements Observer {
		public void update(Observable obs, Object arg) {
			gui.displayWarningsP1(model.warningP1.get());
		}
	}
	
	class Panel2WarningObserver implements Observer {
		public void update(Observable obs, Object arg) {
			gui.displayWarningsP2(model.warningP2.get());
		}
	}
	
	class Panel2SearchObserver implements Observer {
		public void update(Observable obs, Object arg) {
			gui.updateStatus(model.tbrP2.get());
		}
	}
	
	class Panel2FoundObserver implements Observer {
		public void update(Observable obs, Object arg) {
			gui.notFound(model.foundP2.get());
		}
	}
	
	
	public void clear() {
		gui.clearTable();
		gui.clearTextBoxesPacket();
		gui.clearTextBoxesSearch();
		gui.clearAll();
		if (frame != null)
			frame.dispose();
	}
	
}
