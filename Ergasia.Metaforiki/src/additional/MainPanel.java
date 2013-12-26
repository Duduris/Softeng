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
		  
		  btnNewButton = new JButton("Back");
		  menuBar.add(btnNewButton);
		  frame.getContentPane().setLayout(new CardLayout(0, 0));
		  
		  LoginPanel login = new LoginPanel();
		  IpalilosPanel ipalilos = new IpalilosPanel();
		  MetaforeasPanel metaforeas = new MetaforeasPanel();
		  CustomerPanel customer = new CustomerPanel();
		  AdministratorPanel admin = new AdministratorPanel();
		  
		  final LoginController logcont = new LoginController(login);
		  IpalilosController ipalcont = new IpalilosController(ipalilos);
		  MetaforeasController metcont = new MetaforeasController(metaforeas);
		  CustomerController custcont = new CustomerController(customer);
		  AdministratorController admincont = new AdministratorController(admin);
		  
		  
		  frame.getContentPane().add(login, "Log");
		  frame.getContentPane().add(ipalilos, "Clerk");
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
