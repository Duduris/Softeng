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
import java.awt.Color;

public class CustomerPanel extends JPanel {

	private static final long serialVersionUID = 5;
	
	private JFormattedTextField textField;
	private JTextArea textArea;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JLabel lblInputATracking;
	private JLabel lblWrongFormatMust;

	public CustomerPanel() {
		setLayout(new MigLayout("hidemode 3", "[grow][100][grow]", "[grow][40][40][40][]0[]0[][40][grow]"));
		
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
		
		lblInputATracking = new JLabel("Input a Tracking Number ");
		lblInputATracking.setForeground(Color.RED);
		lblInputATracking.setVisible(false);
		add(lblInputATracking, "cell 1 4,h 15");
		
		lblWrongFormatMust = new JLabel("Wrong Format: must be RBxxxxxxxxxGR");
		lblWrongFormatMust.setVisible(false);
		lblWrongFormatMust.setForeground(Color.RED);
		add(lblWrongFormatMust, "cell 1 5");
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane, "cell 1 6,height 100,grow");
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		btnSearch = new JButton("Search");
		add(btnSearch, "cell 1 7,alignx center,growy");

	}
	
	public void btnSearchListener(ActionListener e) {
		btnSearch.addActionListener(e);
	}
	
	public String getTracking() {
		return textField.getText();
	}
	
	public void setTrackingInfo(String info) {
		scrollPane.setVisible(true);
		lblInputATracking.setVisible(false);
		lblWrongFormatMust.setVisible(false);
		textArea.setText(info);
		revalidate();
	}
	public void showWarning(int i) {
		if(i == 1){
			lblInputATracking.setVisible(true);
			lblWrongFormatMust.setVisible(false);
		}else{
			lblInputATracking.setVisible(false);
			lblWrongFormatMust.setVisible(true);
		}
		scrollPane.setVisible(false);
		revalidate();
	}
	
	public void clearAll() {
		scrollPane.setVisible(false);
		lblInputATracking.setVisible(false);
		lblWrongFormatMust.setVisible(false);
		textArea.setText("");
		textField.setText("");
		revalidate();
	}

}
