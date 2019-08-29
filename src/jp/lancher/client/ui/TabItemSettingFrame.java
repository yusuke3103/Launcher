package jp.lancher.client.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.lancher.client.models.TabItemModel;
import jp.lancher.client.ui.models.TabItemTableModel;
import jp.lancher.domain.service.TabItemSettingFrameService;

public class TabItemSettingFrame extends JFrame {

	private JPanel inputPanel = new JPanel();
	private JPanel tablePanel = new JPanel();
	private JPanel btnPanel = new JPanel();
	private final JTable table = new JTable();
	private final JButton btnNewButton = new JButton("New button");
	private final JButton button = new JButton("New button");
	private final JTextField txtRno = new JTextField();
	private final JTextField txtName = new JTextField();
	private final JLabel lblNewLabel = new JLabel("番号");
	private final JLabel lblNewLabel_1 = new JLabel("名前");
	private final JPanel panel = new JPanel();
	private JTextField txtPath;
	private TabItemSettingFrameService service = new TabItemSettingFrameService();

	private int selectedRow = -1;

	public TabItemSettingFrame() {

		setSize(450, 530);
		txtName.setBounds(134, 44, 298, 26);
		txtName.setColumns(10);
		txtRno.setBounds(134, 6, 197, 26);
		txtRno.setColumns(1);
		setResizable(false);
		init();
	}

	private void init() {

		this.initInputPanel();

		this.initTablePanel();

		this.initBtnPanel();

		this.initData();
	}

	private void initData() {
		try {
			List<TabItemModel> models = service.getInitData();
			for (TabItemModel tabItemModel : models) {
				((TabItemTableModel)table.getModel()).addRow(tabItemModel);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initInputPanel() {
		getContentPane().setLayout(null);
		panel.setLayout(null);
		panel.setBounds(6, 6, 438, 40);
		getContentPane().add(panel);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(139, 6, 293, 27);
		panel.add(comboBox);

		JLabel lblNewLabel_2 = new JLabel("TAB");
		lblNewLabel_2.setBounds(6, 10, 61, 16);
		panel.add(lblNewLabel_2);
		inputPanel.setBounds(6, 58, 438, 153);

		getContentPane().add(inputPanel);
		inputPanel.setLayout(null);
		button.setBounds(6, 120, 426, 29);
		inputPanel.add(button);
		inputPanel.add(txtRno);
		inputPanel.add(txtName);
		lblNewLabel.setBounds(6, 11, 61, 16);
		inputPanel.add(lblNewLabel);
		lblNewLabel_1.setBounds(6, 49, 61, 16);
		inputPanel.add(lblNewLabel_1);

		txtPath = new JTextField();
		txtPath.setBounds(134, 82, 298, 26);
		inputPanel.add(txtPath);
		txtPath.setColumns(10);

		JLabel label = new JLabel("パス");
		label.setBounds(6, 87, 61, 16);
		inputPanel.add(label);
	}

	private void initTablePanel() {
		tablePanel.setBounds(6, 223, 438, 218);
		table.setModel(new TabItemTableModel());
		table.removeColumn(table.getColumnModel().getColumn(0));
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {
					return;
				}

				selectedRow = table.getSelectedRow();
				txtRno.setText(String.valueOf(
						((TabItemTableModel) table.getModel()).getValueAt(selectedRow, TabItemTableModel.ColumnName.RNO)));
				txtName.setText(String.valueOf(
						((TabItemTableModel) table.getModel()).getValueAt(selectedRow, TabItemTableModel.ColumnName.NAME)));
				txtPath.setText(String.valueOf(
						((TabItemTableModel) table.getModel()).getValueAt(selectedRow, TabItemTableModel.ColumnName.PATH)));
			}
		});
		getContentPane().add(tablePanel);
		tablePanel.setLayout(new BorderLayout(0, 0));
		tablePanel.add(table);
		tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
	}

	private void initBtnPanel() {
		btnPanel.setBounds(6, 453, 438, 40);
		getContentPane().add(btnPanel);
		btnPanel.setLayout(null);
		btnNewButton.setBounds(315, 6, 117, 29);
		btnPanel.add(btnNewButton);
	}
}
