package controllers;
import gui.LoginPanel;

public class LoginController {
	
	private LoginPanel loginpanel;
	
	public LoginController(LoginPanel loginpanel) {
		this.loginpanel = loginpanel;
	}
	
	public String changePanel(){
		return loginpanel.getUserType();
	}
	
}
