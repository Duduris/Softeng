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
	private String parameters[] = { "None","Fragile", "Delivered","To be Delivered","Damaged", "Wrong Address", "Unavailable" };
	private JButton btnExportAll;
	private JPanel panel;
	private JFreeChart chart;
	private DefaultPieDataset pieDataset;
	

	public AdministratorPanel() {
		setLayout(new MigLayout("hidemode 3", "[grow][40]", "[40][40][grow]"));

		comboBox = new JComboBox<Object>(parameters);
		add(comboBox, "cell 0 0,alignx left,aligny center");
		
		btnExportAll = new JButton("Export All");
		add(btnExportAll, "cell 1 0,grow");

		panel = new JPanel();
		panel.setLayout(new CardLayout(0, 0));
		add(panel, "cell 0 1 1 2,grow");
		
		
	}
	
	public void btnExportListener(ActionListener e) {
		btnExportAll.addActionListener(e);
	}
	
	public void comboBxListener(ActionListener e) {
		comboBox.addActionListener(e);
	}

	public String getItemStatus() {
		return comboBox.getSelectedItem().toString();
	}
	
	public void setChart(DefaultPieDataset dataset) {
	    panel.removeAll(); 
		pieDataset = dataset;
		chart = ChartFactory.createPieChart3D("Statistics",pieDataset, true, true, true);
		ChartPanel chpan = new ChartPanel(chart);
		panel.add(chpan);
		revalidate();
	}
	
	public void clear() {
		panel.removeAll();
		comboBox.setSelectedIndex(0);
		revalidate();
	}
	
	

}
