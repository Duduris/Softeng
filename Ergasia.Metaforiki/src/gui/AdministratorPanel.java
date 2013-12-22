package gui;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.CardLayout;
import java.awt.event.ActionListener;

public class AdministratorPanel extends JPanel {

	private static final long serialVersionUID = 4;
	private JComboBox<Object> comboBox;
	private String teststring[] = { "Fragile", "Delivered" };
	private JButton btnExit;
	private JButton btnExportAll;
	
	private DefaultPieDataset pieDataset;
	

	public AdministratorPanel() {
		setLayout(new MigLayout("", "[grow][40]", "[40][40][grow]"));

		comboBox = new JComboBox<Object>(teststring);
		add(comboBox, "cell 0 0,alignx left,aligny center");

		btnExit = new JButton("Exit");
		add(btnExit, "cell 1 0,grow");
		
		btnExportAll = new JButton("Export All");
		add(btnExportAll, "cell 1 1,grow");

		JPanel panel = new JPanel();
		add(panel, "cell 0 1 1 2,grow");
		panel.setLayout(new CardLayout(0, 0));
		
		pieDataset = new DefaultPieDataset();

		pieDataset.setValue("One", new Integer(10));
		pieDataset.setValue("Two", new Integer(20));
		pieDataset.setValue("Three", new Integer(30));
		pieDataset.setValue("Four", new Integer(10));
		pieDataset.setValue("Five", new Integer(20));
		pieDataset.setValue("Six", new Integer(10));
		JFreeChart chart = ChartFactory.createPieChart3D("3D Chart",pieDataset, true, true, true);

		ChartPanel chpan = new ChartPanel(chart);
		panel.add(chpan);

	}
	
	public void btnExportListener(ActionListener e) {
		btnExportAll.addActionListener(e);
	}

	public void btnExitListener(ActionListener e) {
		btnExit.addActionListener(e);
	}

	public String getItemStatus() {
		return comboBox.getSelectedItem().toString();
	}
	
	public void setChart(DefaultPieDataset Dataset) {
		pieDataset = Dataset;
	}


}
