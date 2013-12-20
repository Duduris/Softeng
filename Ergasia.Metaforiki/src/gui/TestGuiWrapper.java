package gui;

import java.awt.Dimension;
import javax.swing.JFrame;

public class TestGuiWrapper {

	public static void main(String[] args) {
		  JFrame frame = new JFrame("Frame in Java Swing");
		  frame.setSize(600, 600);
		  
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  //IpalilosPanel gui = new IpalilosPanel();
		  MetaforeasPanel gui = new MetaforeasPanel();
		  
		  /*gui.setPreferredSize(new Dimension(600,400));
		  frame.getContentPane().add(gui);
		  frame.pack();
		  frame.setVisible(true);
		  */
		  frame.add(gui);
		  frame.setVisible(true);
		  
	}
	
	
}
