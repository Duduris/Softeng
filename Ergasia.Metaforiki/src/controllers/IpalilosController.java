package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.IpalilosPanel;

public class IpalilosController {

	private IpalilosPanel gui;
	
	public IpalilosController(IpalilosPanel gui) {
		this.gui = gui;
		gui.btnClearListener(new BtnClearListener());
		gui.btnSubmitListener(new BtnSubmitListener());
		gui.btnSearchListener(new BtnSearchListener());
		gui.btnClear2Listener(new BtnClear2Listener());
		
	}
	
	class BtnClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Panel1 Clear
			 */

		}
	}
	
	class BtnSubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Panel1 Submit
			 */

		}
	}
	
	class BtnSearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Panel2 Search
			 */

		}
	}
	
	class BtnClear2Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Panel2 Clear
			 */

		}
	}
}
