package gui;

import java.awt.Dimension;
import javax.swing.JFrame;

public class TestGuiWrapper {

	public static void main(String[] args) {
		  JFrame frame = new JFrame("Metaforiki");
		  frame.setSize(600, 600);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  /*
		   * Epilogi Gui
		   */
		  //IpalilosPanel gui = new IpalilosPanel();
		  //MetaforeasPanel gui = new MetaforeasPanel();
		  //LoginPanel gui = new LoginPanel();
		  AdministratorPanel gui = new AdministratorPanel();
		  
		  /*gui.setPreferredSize(new Dimension(600,400));
		  frame.getContentPane().add(gui);
		  frame.pack();
		  frame.setVisible(true);
		  */
		  frame.add(gui);
		  frame.setVisible(true);
		  
	}
	
	
}
