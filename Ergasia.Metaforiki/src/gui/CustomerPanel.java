package gui;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JFormattedTextField;

public class CustomerPanel extends JPanel {

	private static final long serialVersionUID = 5;
	
	private JFormattedTextField textField;
	private JTextArea textArea;
	private JButton btnSearch;
	private JScrollPane scrollPane;

	public CustomerPanel() {
		setLayout(new MigLayout("hidemode 3", "[grow][100][grow]", "[grow][40][40][40][][40][grow]"));
		
		JLabel lblNewLabel = new JLabel(" Track n Trace ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		add(lblNewLabel, "cell 1 1,alignx center,aligny center");
		
		JLabel lblTypeThe = new JLabel("Type the shipping number and press Search");
		add(lblTypeThe, "cell 1 2,alignx center,growy");
		
		textField = new JFormattedTextField();
		add(textField, "cell 1 3,grow, hidemode 3");
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane, "cell 1 4,grow, h 100");
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		btnSearch = new JButton("Search");
		add(btnSearch, "cell 1 5,alignx center,growy");

	}
	
	public void btnSearchListener(ActionListener e) {
		btnSearch.addActionListener(e);
	}
	
	public String getTracking() {
		return textField.getText();
	}
	
	public void setTrackingInfo(String info) {
		scrollPane.setVisible(true);
		textArea.setText(info);
		revalidate();
	}

}
