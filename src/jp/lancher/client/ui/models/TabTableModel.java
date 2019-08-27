package jp.lancher.client.ui.models;

import javax.swing.table.DefaultTableModel;

public class TabTableModel extends DefaultTableModel {

	private boolean[] columnEditables = {false, false, false};
	
	private Class[] columnTypes = {Integer.class, String.class, String.class};
	
	private String[] columnNames = {"番号","名前","パス"};
	
	public TabTableModel() {
		init();
	}
	
	private void init() {
		
	}
	
	
	
	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		return super.isCellEditable(row, column);
	}
	/*
	new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"\u756A\u53F7", "\u540D\u524D", "\u30D1\u30B9"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(0).setMinWidth(40);
		table.getColumnModel().getColumn(0).setMaxWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMaxWidth(150);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setMinWidth(200);
		table.getColumnModel().getColumn(2).setMaxWidth(200);
	*/
}
