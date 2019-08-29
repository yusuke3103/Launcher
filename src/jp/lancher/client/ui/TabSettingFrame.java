package jp.lancher.client.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.lancher.App;
import jp.lancher.client.models.TabModel;
import jp.lancher.client.ui.models.TabTableModel;
import jp.lancher.domain.service.TabSettingFrameService;

public class TabSettingFrame extends JFrame {

	private JTextField txtTabId = new JTextField();
	private JTextField txtTabName = new JTextField();
	private JTable table = new JTable();

	private JPanel panel_3 = new JPanel();
	private JButton btnOk = new JButton("OK");
	private JPanel tablePanel = new JPanel();
	private JButton btn = new JButton("確定");
	private JPanel inputPanel = new JPanel();
	private JLabel lblTabId = new JLabel("タブID");
	private JLabel lblTabName = new JLabel("タブ名");
	private JTextField txtId = new JTextField();
	private JLabel lblId = new JLabel("ID");

	private int selectedRow = -1;

	private TabSettingFrameService service = new TabSettingFrameService();

	public TabSettingFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(440, 358);
		getContentPane().setLayout(null);

		// 初期化
		this.init();
	}
	

	/**
	 * 初期化
	 */
	private void init() {

		// 入力パネル初期化
		this.initInputPanel();
		// テーブルパネル
		this.initTablePanel();
		// ボタンパネル
		this.initBtnPanel();
		// 初期データ設定
		this.setInitData();
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					App.mainFrame.reload();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	/**
	 * 入力パネル初期化
	 */
	private void initInputPanel() {

		// InputPanel設定
		inputPanel.setBounds(6, 6, 428, 152);
		inputPanel.setLayout(null);

		// ID
		lblId.setBounds(6, 11, 61, 16);
		inputPanel.add(lblId);

		// ID
		txtId.setEditable(false);
		txtId.setText("1");
		txtId.setBounds(79, 6, 44, 26);
		txtId.setColumns(10);
		inputPanel.add(txtId);

		// タブID
		lblTabId.setBounds(6, 49, 61, 16);
		inputPanel.add(lblTabId);

		// タブID
		txtTabId.setEditable(false);
		txtTabId.setText("5A80461C-FA21-4A11-B7BD-285CC7AA0551");
		txtTabId.setBounds(79, 44, 343, 26);
		txtTabId.setColumns(10);
		inputPanel.add(txtTabId);

		// タブ名
		lblTabName.setBounds(6, 87, 61, 16);
		inputPanel.add(lblTabName);

		// タブ名
		txtTabName.setText("タブ名４５");
		txtTabName.setBounds(79, 82, 86, 26);
		txtTabName.setColumns(10);
		inputPanel.add(txtTabName);

		// 確定ボタン
		btn.setBounds(6, 115, 416, 29);
		btn.setActionCommand("EXECUTE");
		btn.addActionListener(new IActionListener());
		inputPanel.add(btn);

		getContentPane().add(inputPanel);
	}

	/**
	 * テーブルパネル初期化
	 */
	private void initTablePanel() {

		// TablePanelの設定
		tablePanel.setBounds(6, 170, 428, 105);
		tablePanel.setLayout(new BorderLayout(0, 0));

		// テーブル
		table.setModel(new TabTableModel());
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {
					return;
				}
				selectedRow = table.getSelectedRow();
				txtId.setText(String
						.valueOf(((TabTableModel) table.getModel()).getValueAt(selectedRow, TabTableModel.ColumnName.ID)));
				txtTabId.setText(String.valueOf(
						((TabTableModel) table.getModel()).getValueAt(selectedRow, TabTableModel.ColumnName.TAB_ID)));
				txtTabName.setText(String
						.valueOf(((TabTableModel) table.getModel()).getValueAt(selectedRow, TabTableModel.ColumnName.NAME)));
			}
		});

		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(0).setMinWidth(40);
		table.getColumnModel().getColumn(0).setMaxWidth(40);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(290);
		table.getColumnModel().getColumn(1).setMinWidth(290);
		table.getColumnModel().getColumn(1).setMaxWidth(290);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(99);
		table.getColumnModel().getColumn(2).setMinWidth(99);
		table.getColumnModel().getColumn(2).setMaxWidth(99);

		tablePanel.add(table);
		tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);

		getContentPane().add(tablePanel);
	}

	/**
	 * ボタンパネル初期化
	 */
	private void initBtnPanel() {
		panel_3.setBounds(6, 287, 428, 40);
		panel_3.setLayout(null);

		btnOk.setBounds(305, 6, 117, 29);
		panel_3.add(btnOk);
		btnOk.setActionCommand("REGIST");
		btnOk.addActionListener(new IActionListener());

		getContentPane().add(panel_3);
	}

	private void setInitData() {
		try {
			List<TabModel> tabs = service.getInitData();
			for (TabModel tab : tabs) {
				((TabTableModel) table.getModel()).addRow(tab);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setSampleData() {
		for (int i = 0; i < 5; i++) {
			TabModel model = new TabModel();
			model.setId(i + 1);
			model.setTabId(UUID.randomUUID().toString());
			model.setName("タブ１２３");
			((TabTableModel) table.getModel()).addRow(model);
		}
	}

	class IActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("actionPerformed");
			String command = e.getActionCommand();
			switch (command) {
			case "REGIST":
				regist();
				break;
			case "EXECUTE":
				exec();
				break;
			default:
				break;
			}

		}

		private void regist() {
			try {
				System.out.println("regist");
				TabTableModel model = (TabTableModel) table.getModel();
				Vector vec = model.getDataVector();
				service.regist(vec);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private void exec() {
			
			if (selectedRow == -1) {
				return;
			}

			TabTableModel model = (TabTableModel) table.getModel();
			model.setValueAt(txtTabName.getText(), selectedRow, TabTableModel.ColumnName.NAME);
		}

	}
}
