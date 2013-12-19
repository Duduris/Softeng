package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class MetaforeasGui extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MetaforeasGui frame = new MetaforeasGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 
	String[] columnNames = {"First Name",
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
	};
	
	*/
	public MetaforeasGui() {
		setTitle("Metaforeas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][][][][][][][][][][][][][][][][]", "[grow][][][][][][][][][]"));
		
		table = new JTable();//data,columnNames
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowVerticalLines(false);
		contentPane.add(table, "cell 0 0 18 10,grow");
		
		JButton button = new JButton("Submit");
		contentPane.add(button, "cell 18 3 1 2,grow");
		
		JButton btnSubmit = new JButton("Exit");
		contentPane.add(btnSubmit, "cell 18 7 1 3,grow");
	}

}
