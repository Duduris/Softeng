package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Logingui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logingui frame = new Logingui();
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
	public Logingui() {
		setTitle("LogIn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDiaxiristis = new JButton("Diaxiristis");
		btnDiaxiristis.setBounds(69, 62, 135, 52);
		contentPane.add(btnDiaxiristis);
		
		JButton btnYpallilos = new JButton("Ypallilos");
		btnYpallilos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnYpallilos.setBounds(219, 62, 135, 52);
		contentPane.add(btnYpallilos);
		
		JButton btnMetaforeas = new JButton("Metaforeas");
		btnMetaforeas.setBounds(69, 125, 135, 52);
		contentPane.add(btnMetaforeas);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(219, 135, 135, 32);
		contentPane.add(comboBox);
	}
}
