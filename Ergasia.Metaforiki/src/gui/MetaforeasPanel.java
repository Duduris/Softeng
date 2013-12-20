package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;

public class MetaforeasPanel extends JPanel {

	private static final long serialVersionUID = 2;
	private JTable table;
	
	/*String[] columnNames = {"First Name",
			"Last Name",
			"Sport",
			"# of Years",
			"Vegetarian"};
	Object[][] data = {
			{"Kathy", "Smith","Snowboarding", new Integer(5), new Boolean(false)},
			{"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
			{"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
			{"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},
			{"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)}
	};*/

	public MetaforeasPanel() {
		setLayout(new MigLayout("", "[427.00,grow][70.00]", "[60][grow][60][grow][60]"));
		
		table = new JTable(); //data,columnNames
		table.setRowHeight(20);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setShowVerticalLines(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(table, "cell 0 0 1 5,grow");
		
		JButton btnMap = new JButton("Map");
		add(btnMap, "cell 1 0,grow");
		
		JButton btnSubmit = new JButton("Submit");
		add(btnSubmit, "cell 1 2,grow");
		
		JButton btnExit = new JButton("Exit");
		add(btnExit, "cell 1 4,grow");
		
	}
}
