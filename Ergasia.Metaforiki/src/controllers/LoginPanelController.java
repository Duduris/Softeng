package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.LoginPanel;

public class LoginPanelController {
	private LoginPanel loginpanel;
	
	public LoginPanelController(LoginPanel loginpanel) {
		this.loginpanel = loginpanel;
		loginpanel.btnSingInListener(new BtnSingInListener());
	}
	
	class BtnSingInListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Test");
		}
	}
}
