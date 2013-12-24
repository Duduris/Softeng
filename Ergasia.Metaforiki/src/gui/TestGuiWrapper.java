package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import models.CustomerModel;
import controllers.CustomerController;
import controllers.IpalilosController;
import controllers.LoginController;
import controllers.MetaforeasController;
import controllers.AdministratorController;

public class TestGuiWrapper {

	public static void main(String[] args) {
		  JFrame frame = new JFrame("Metaforiki");
		  
		  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //diavazei tin analisi tis othonis
		  
		  frame.setBounds(0,0,(int) (screenSize.width/2.5), screenSize.height/2); //orizei to megethos tou parathirou sto /2.5 tis analisis y kai /3 sto x
		  frame.setLocation((screenSize.width - frame.getSize().width)/2 , (screenSize.height - frame.getSize().height)/2); //to vazei sto kendro tis othonis
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  /*
		   * Epilogi Gui
		   */
		  //IpalilosPanel2 gui = new IpalilosPanel2();
		  
		  //LoginPanel gui = new LoginPanel();
		  //LoginController guicont = new LoginPanelController(gui);
		  
		  AdministratorPanel gui = new AdministratorPanel();
		  AdministratorController guicont = new AdministratorController(gui);
		  
		  //MetaforeasPanel gui = new MetaforeasPanel();
		  //MetaforeasController guicont = new MetaforeasController(gui);
		  		  
		  //IpalilosPanel gui = new IpalilosPanel();
		  //IpalilosController guicont = new IpalilosController(gui);
		  
		  //Proti dokimi sto MVC
		  
		 
		  //CustomerPanel gui = new CustomerPanel();
		  //CustomerModel model = new CustomerModel();
		  //CustomerController guicont = new CustomerController(gui/*, model*/);
		 
		  
		  frame.add(gui);
		  frame.setVisible(true);
		  
	}
	
	
}
