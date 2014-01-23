package gui;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 3;
	
	private JPasswordField pwdPass;
	private String usertypes[] = {"Administrator", "Customer", "Employee", "Courier"};
	public JButton btnSingIn;
	private JComboBox<Object> comboBox;
	private JFormattedTextField formattedTextField;

	public LoginPanel() {
		setOpaque(false);
		setLayout(new MigLayout("", "[grow][200][grow]", "[grow][40][40][40][40][40][grow]"));
		
		ImageIcon image = new ImageIcon("image/a.png"); 
		
		JLabel lblMetaforikiLogin = new JLabel(image);
		lblMetaforikiLogin.setBackground(Color.WHITE);
		lblMetaforikiLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(lblMetaforikiLogin, "cell 1 1,alignx center,aligny center");
		
		comboBox = new JComboBox<Object>(usertypes);
		comboBox.setSelectedIndex(1);
		add(comboBox, "cell 1 2,grow");
		
		formattedTextField = new JFormattedTextField();
		add(formattedTextField, "cell 1 3,grow");
		
		pwdPass = new JPasswordField();
		add(pwdPass, "cell 1 4,grow");
		
		btnSingIn = new JButton("Sign In");

		add(btnSingIn, "cell 1 5,grow");
		
		
	}
	
	public void btnSingInListener(ActionListener act) {
		btnSingIn.addActionListener(act);
	}
	
	public String getUserType() {
		return comboBox.getSelectedItem().toString();
	}
	
	public String getUserName() {
		return formattedTextField.getText();
	}
	
	public void clear() {
		formattedTextField.setText("");
		pwdPass.setText("");
	}
	
	@SuppressWarnings("deprecation")
	public String getPass() {
		//return pwdPass.getPassword();
		return pwdPass.getText();
	}

}
