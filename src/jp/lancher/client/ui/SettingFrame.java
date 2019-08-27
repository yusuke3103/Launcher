package jp.lancher.client.ui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import jp.lancher.client.ui.models.TabTableModel;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;

public class SettingFrame extends JFrame {
	private JTextField txtTabId = new JTextField();
	private JTextField txtTabName = new JTextField();
	private JTable table = new JTable();

	JPanel panel_2 = new JPanel();
	JButton btnNewButton = new JButton("New button");
	JPanel panel_3 = new JPanel();
	
	private JPanel panel = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JLabel lblTabId = new JLabel("タブID");
	private JLabel lblTabName = new JLabel("タブ名");
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
	
	public SettingFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(299, 316);
		
		
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		
		panel_1.setBounds(6, 6, 270, 83);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		txtTabId.setBounds(79, 6, 181, 26);
		panel_1.add(txtTabId);
		txtTabId.setColumns(10);
		
		
		lblTabId.setBounds(6, 11, 61, 16);
		panel_1.add(lblTabId);
		
		
		txtTabName.setBounds(79, 44, 181, 26);
		panel_1.add(txtTabName);
		txtTabName.setColumns(10);
		
		
		lblTabName.setBounds(6, 49, 61, 16);
		panel_1.add(lblTabName);
		
		panel_2.setBounds(6, 202, 270, 40);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		btnNewButton.setBounds(143, 6, 117, 29);
		panel_2.add(btnNewButton);
		
		panel_3.setBounds(6, 101, 270, 89);
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		table.setModel(new TabTableModel());
		panel_3.add(table);
		panel_3.add(table.getTableHeader(), BorderLayout.NORTH);
	}
}
