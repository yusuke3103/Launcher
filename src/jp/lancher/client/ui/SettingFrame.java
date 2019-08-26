package jp.lancher.client.ui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;

public class SettingFrame extends JFrame {
	private JTextField txtTabId;
	private JTextField txtTabName;
	private JTable table;

	public SettingFrame() {
		this.setSize(299, 316);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 6, 266, 83);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtTabId = new JTextField();
		txtTabId.setBounds(79, 6, 181, 26);
		panel_1.add(txtTabId);
		txtTabId.setColumns(10);
		
		JLabel lblTabId = new JLabel("タブID");
		lblTabId.setBounds(6, 11, 61, 16);
		panel_1.add(lblTabId);
		
		txtTabName = new JTextField();
		txtTabName.setBounds(79, 44, 181, 26);
		panel_1.add(txtTabName);
		txtTabName.setColumns(10);
		
		JLabel lblTabName = new JLabel("タブ名");
		lblTabName.setBounds(6, 49, 61, 16);
		panel_1.add(lblTabName);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 202, 266, 40);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(143, 6, 117, 29);
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(6, 101, 266, 89);
		panel.add(panel_3);
		
		table = new JTable();
		table.setModel(new DefaultTableModel() {
			
		});
		panel_3.add(table);
	}
}
