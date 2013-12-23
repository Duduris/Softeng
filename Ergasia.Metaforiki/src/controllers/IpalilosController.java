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
			
			//prepei na mpei sto adistixo model dokimastika gia tora
			
			 String[] text = new String[8];
			 boolean[] warning = new boolean[6];
			 
			 text = gui.getTextBoxesPacket();
			 
			 for (int i = 0; i < 5; i++)
				 if (text[i].length() == 0 )
					 warning[5] = true;
			 
			 warning[0] = !text[0].matches("[a-zA-Z\\s]*");
			 warning[1] = !text[1].matches("[a-zA-Z\\s]*");
			 warning[2] = !text[3].matches("\\d{5}|\\d{5}");
			 warning[3] = !text[4].matches("[a-zA-Z\\s]*");
			 warning[4] = !text[5].matches("\\d{10}|\\d{7}");
			
			 gui.displayWarningsP1(warning);

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
