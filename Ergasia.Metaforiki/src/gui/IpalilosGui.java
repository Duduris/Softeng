package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Checkbox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

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
		panel.setLayout(new MigLayout("", "[110.00px][112.00px][47.00][130.00px]", "[][][][][][][][101px][23px]"));
		
		JLabel lblName = new JLabel("Name");
		panel.add(lblName, "cell 0 0,alignx center,aligny center");
		
		JFormattedTextField frmtdtxtfldOnoma = new JFormattedTextField();
		frmtdtxtfldOnoma.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel.add(frmtdtxtfldOnoma, "cell 1 0 3 1,grow");
		
		JLabel lblSurname = new JLabel("Surname");
		panel.add(lblSurname, "cell 0 1,alignx center,aligny center");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel.add(formattedTextField, "cell 1 1 3 1,growx,aligny top");
		
		JLabel lblStreet = new JLabel("Address");
		panel.add(lblStreet, "cell 0 2,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel.add(formattedTextField_1, "cell 1 2 3 1,grow");
		
		JLabel lblStreetNumber = new JLabel("Postal Code");
		panel.add(lblStreetNumber, "cell 0 3,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel.add(formattedTextField_2, "cell 1 3 3 1,grow");
		
		JLabel lblCountry = new JLabel("Country");
		panel.add(lblCountry, "cell 0 4,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel.add(formattedTextField_3, "cell 1 4 3 1,grow");
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		panel.add(lblPhoneNumber, "cell 0 5,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		formattedTextField_4.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel.add(formattedTextField_4, "cell 1 5 3 1,grow");
		
		JLabel lblFragile = new JLabel("Fragile");
		panel.add(lblFragile, "cell 0 6,alignx center,aligny center");
		
		Checkbox checkbox = new Checkbox("");
		panel.add(checkbox, "cell 1 6,alignx left,aligny top");
		
		JLabel lblComments = new JLabel("Comments");
		panel.add(lblComments, "cell 0 7,alignx center,aligny center");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane, "cell 1 7 3 1,grow");
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setPreferredSize(new Dimension(10, 16));
		textArea.setAutoscrolls(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnClear, "cell 1 8,growx,aligny top");
		
		JButton btnNewButton = new JButton("Submit");
		panel.add(btnNewButton, "cell 3 8,growx,aligny top");
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Search", null, panel_1, null);
		panel_1.setLayout(new MigLayout("", "[95.00px][grow]", "[23.00px][][][][][][][42.00][274.00,grow][121.00]"));
		
		JLabel label = new JLabel("Name");
		panel_1.add(label, "cell 0 0,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_5 = new JFormattedTextField();
		formattedTextField_5.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel_1.add(formattedTextField_5, "cell 1 0,grow");
		
		JLabel label_1 = new JLabel("Surname");
		panel_1.add(label_1, "cell 0 1,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_6 = new JFormattedTextField();
		formattedTextField_6.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel_1.add(formattedTextField_6, "cell 1 1,grow");
		
		JLabel label_2 = new JLabel("Address");
		panel_1.add(label_2, "cell 0 2,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_7 = new JFormattedTextField();
		formattedTextField_7.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel_1.add(formattedTextField_7, "cell 1 2,grow");
		
		JLabel lblPostalCode = new JLabel("Postal Code");
		panel_1.add(lblPostalCode, "cell 0 3,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_8 = new JFormattedTextField();
		formattedTextField_8.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel_1.add(formattedTextField_8, "cell 1 3,grow");
		
		JLabel lblPhone = new JLabel("Phone Number");
		panel_1.add(lblPhone, "cell 0 4,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_9 = new JFormattedTextField();
		formattedTextField_9.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel_1.add(formattedTextField_9, "cell 1 4,grow");
		
		JLabel lblCountry_1 = new JLabel("Country");
		panel_1.add(lblCountry_1, "cell 0 5,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_10 = new JFormattedTextField();
		formattedTextField_10.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel_1.add(formattedTextField_10, "cell 1 5,grow");
		
		JLabel lblTrackingNumber = new JLabel("Tracking Number");
		panel_1.add(lblTrackingNumber, "cell 0 6,alignx center,aligny center");
		
		JFormattedTextField formattedTextField_11 = new JFormattedTextField();
		formattedTextField_11.setFocusLostBehavior(JFormattedTextField.PERSIST);
		panel_1.add(formattedTextField_11, "cell 1 6,grow");
		
		JButton btnClear_1 = new JButton("Clear");
		panel_1.add(btnClear_1, "flowx,cell 1 7,growy");
		
		JButton btnSearch = new JButton("Search");
		panel_1.add(btnSearch, "cell 1 7,growy");
		
		JTextArea txtrTest = new JTextArea();
		txtrTest.setVisible(false);
		txtrTest.setText("Test");
		txtrTest.setEditable(false);
		panel_1.add(txtrTest, "cell 1 8,grow");
	}
}
