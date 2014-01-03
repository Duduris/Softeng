package additional;

import gui.AdministratorPanel;
import gui.CustomerPanel;
import gui.IpalilosPanel;
import gui.LoginPanel;
import gui.MetaforeasPanel;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JButton;

import models.AdministratorModel;
import models.CustomerModel;
import models.MetaforeasModel;
import controllers.AdministratorController;
import controllers.CustomerController;
import controllers.IpalilosController;
import controllers.LoginController;
import controllers.MetaforeasController;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPanel {
	
	private static CardLayout card;
	private static JMenuBar menuBar;
	private static JButton btnNewButton;

	public static void main(String[] args) {
		
		  final JFrame frame = new JFrame("Metaforiki");
		  
		  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //diavazei tin analisi tis othonis
		  
		  frame.setBounds(0,0,(int) (screenSize.width/2.5), screenSize.height/2); //orizei to megethos tou parathirou sto /2.5 tis analisis y kai /3 sto x
		  frame.setLocation((screenSize.width - frame.getSize().width)/2 , (screenSize.height - frame.getSize().height)/2); //to vazei sto kendro tis othonis
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  menuBar = new JMenuBar();
		  frame.setJMenuBar(menuBar);
		  
		  btnNewButton = new JButton("Logout");
		  menuBar.add(btnNewButton);
		  frame.getContentPane().setLayout(new CardLayout(0, 0));
		  
		  final LoginPanel login = new LoginPanel();
		  final IpalilosPanel ipalilos = new IpalilosPanel();
		  final MetaforeasPanel metaforeas = new MetaforeasPanel();
		  final CustomerPanel customer = new CustomerPanel();
		  final AdministratorPanel admin = new AdministratorPanel();
		  
		  final MetaforeasModel metmod = new MetaforeasModel();
		  final CustomerModel logmod = new CustomerModel();
		  final AdministratorModel adminmod = new AdministratorModel();
		  
		  final LoginController logcont = new LoginController(login);
		  final IpalilosController ipalcont = new IpalilosController(ipalilos);
		  final MetaforeasController metcont = new MetaforeasController(metaforeas, metmod);
		  final CustomerController custcont = new CustomerController(customer, logmod);
		  final AdministratorController admincont = new AdministratorController(admin ,adminmod);
		  
		  
		  frame.getContentPane().add(login, "Log");
		  frame.getContentPane().add(ipalilos, "Employee");
		  frame.getContentPane().add(metaforeas, "Courier");
		  frame.getContentPane().add(customer, "Customer");
		  frame.getContentPane().add(admin, "Administrator");
		  
		  card = (CardLayout) frame.getContentPane().getLayout();
		  card.show(frame.getContentPane(), "Log");
		  
		  menuBar.setVisible(false);
		  
		  frame.setVisible(true);
		  
		  btnNewButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  card.show(frame.getContentPane(), "Log");
				  ipalcont.clear();
				  admincont.clear();
				  custcont.clear();
				  metcont.clear();
				  menuBar.setVisible(false);
			  }
		  });
		  login.btnSingIn.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent arg0) {
				  card.show(frame.getContentPane(), logcont.changePanel());
				  menuBar.setVisible(true);
			  }
		  });

	}

}
