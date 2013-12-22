package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

import controllers.LoginPanelController;

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
		  IpalilosPanel2 gui = new IpalilosPanel2();
		  //MetaforeasPanel gui = new MetaforeasPanel();
		  //LoginPanel gui = new LoginPanel();
		  //AdministratorPanel gui = new AdministratorPanel();
		  //IpalilosPanel gui = new IpalilosPanel();
		  
		  //LoginPanelController guicont = new LoginPanelController(gui);
		  
		  gui.setPreferredSize(new Dimension(600,400));
		  frame.getContentPane().add(gui);
		  frame.pack();
		  frame.setVisible(true);
		  
		  frame.add(gui);
		  frame.setVisible(true);
		  
	}
	
	
}
