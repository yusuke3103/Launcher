package jp.lancher.client.ui.models;

import java.util.Arrays;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import jp.lancher.client.models.TabModel;

public class TabTableModel extends DefaultTableModel {

	public static class ColumnName {
		public static final String ID = "番号";
		public static final String TAB_ID = "タブID";
		public static final String NAME = "名前";

		public static String[] values() {
			return new String[] { ID, TAB_ID, NAME };
		}
	}

	private static boolean[] columnEditables = { false, false, false };

	private static String[] columnNames = ColumnName.values();

	/**
	 * コンストラクター
	 */
	public TabTableModel() {
		
		super();
		
		setColumnIdentifiers(columnNames);
	}

	/**
	 * 初期化処理
	 */
	private void init() {
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}

	public boolean isCellEditable(String colName) {
		return columnEditables[getColumnIndex(colName)];
	}

	private int getColumnIndex(String name) {
		return Arrays.asList(columnNames).indexOf(name);
	}

	@Override
	public void addRow(Object[] rowData) {
		super.addRow(rowData);
	}

	/**
	 * 列追加
	 * @param model
	 */
	public void addRow(TabModel model) {
		super.addRow(new Object[] { model.getId(), model.getTabId(), model.getName() });
	}

	public void setValueAt(Object aValue, int row, String name) {
		super.setValueAt(aValue, row, getColumnIndex(name));
	}
	
	public Object getValueAt(int row, String name) {
		return super.getValueAt(row, getColumnIndex(name));
	}
	
	
	
}
