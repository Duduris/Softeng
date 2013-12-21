package gui;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 3;
	private JPasswordField pwdPass;
	private String usertypes[] = {"Administrator", "Customer", "Clerk", "Courier"};
	private JButton btnSingIn;

	public LoginPanel() {
		setOpaque(false);
		setLayout(new MigLayout("", "[grow][200][grow]", "[grow][40][40][40][40][40][grow]"));
		
		JLabel lblMetaforikiLogin = new JLabel("METAFORIKI LOGIN");
		lblMetaforikiLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(lblMetaforikiLogin, "cell 1 1,alignx center,aligny center");
		
		JComboBox<Object> comboBox = new JComboBox<Object>(usertypes);
		comboBox.setSelectedIndex(1);
		add(comboBox, "cell 1 2,grow");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		add(formattedTextField, "cell 1 3,grow");
		
		pwdPass = new JPasswordField();
		add(pwdPass, "cell 1 4,grow");
		
		btnSingIn = new JButton("Sing In");

		add(btnSingIn, "cell 1 5,grow");
		
		//String value=comboBox.getSelectedItem().toString();
		
	}
	
	public void btnSingInListener(ActionListener act){
		btnSingIn.addActionListener(act);
	}

}