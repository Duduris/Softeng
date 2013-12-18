package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.List;
import javax.swing.ListSelectionModel;
import java.awt.Checkbox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IpalilosGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IpalilosGui frame = new IpalilosGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IpalilosGui() {
		setTitle("Metaforiki");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 489);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmTrack = new JMenuItem("Track");
		mnFile.add(mntmTrack);
		
		JMenu mnNewMenu = new JMenu("Help");
		menuBar.add(mnNewMenu);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 588, 429);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Kataxorisi Paketou", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(36, 12, 27, 14);
		panel.add(lblName);
		
		JFormattedTextField frmtdtxtfldOnoma = new JFormattedTextField();
		frmtdtxtfldOnoma.setBounds(96, 7, 223, 23);
		frmtdtxtfldOnoma.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel.add(frmtdtxtfldOnoma);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(29, 37, 42, 14);
		panel.add(lblSurname);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(96, 34, 223, 20);
		formattedTextField.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel.add(formattedTextField);
		
		JLabel lblStreet = new JLabel("Address");
		lblStreet.setBounds(30, 64, 39, 14);
		panel.add(lblStreet);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(96, 58, 223, 26);
		formattedTextField_1.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel.add(formattedTextField_1);
		
		JLabel lblStreetNumber = new JLabel("Postal Code");
		lblStreetNumber.setBounds(21, 98, 57, 14);
		panel.add(lblStreetNumber);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setBounds(96, 88, 223, 33);
		formattedTextField_2.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel.add(formattedTextField_2);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(30, 131, 39, 14);
		panel.add(lblCountry);
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setBounds(96, 125, 223, 25);
		formattedTextField_3.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel.add(formattedTextField_3);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(15, 161, 70, 14);
		panel.add(lblPhoneNumber);
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		formattedTextField_4.setBounds(96, 154, 223, 28);
		formattedTextField_4.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel.add(formattedTextField_4);
		
		JLabel lblFragile = new JLabel("Fragile");
		lblFragile.setBounds(34, 197, 32, 14);
		panel.add(lblFragile);
		
		Checkbox checkbox = new Checkbox("");
		checkbox.setBounds(96, 193, 19, 22);
		panel.add(checkbox);
		
		JLabel lblComments = new JLabel("Comments");
		lblComments.setBounds(25, 254, 50, 14);
		panel.add(lblComments);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(96, 226, 223, 101);
		panel.add(textArea);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnClear.setBounds(96, 352, 65, 23);
		panel.add(btnClear);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(254, 352, 65, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Search", null, panel_1, null);
	}
}
