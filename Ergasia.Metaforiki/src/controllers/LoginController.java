package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.LoginPanel;

public class LoginController {
	
	private LoginPanel loginpanel;
	
	public LoginController(LoginPanel loginpanel) {
		this.loginpanel = loginpanel;
		loginpanel.btnSingInListener(new BtnSingInListener());
	}
	
	class BtnSingInListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * An Patithike to Singin Test
			 */
			String test = loginpanel.getUserType() + " " + loginpanel.getUserName() + " " +  loginpanel.getPass();
			System.out.println(test);
		}
	}
	
	public String changePanel(){
		return loginpanel.getUserType();
	}
	
	/*
	 * Test
	public void panelListener(ActionListener act) {
		loginpanel.btnSingIn.addActionListener(act);
	}
	*/
}
