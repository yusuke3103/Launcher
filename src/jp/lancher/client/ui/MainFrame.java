package jp.lancher.client.ui;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import jp.lancher.client.models.TabModel;
import jp.lancher.domain.service.MainFrameService;

public class MainFrame extends JFrame {

	/** タブ */
	private JTabbedPane tabPanel = new JTabbedPane();
	/** プロセス */
	private MainFrameService service = new MainFrameService();

	/**
	 * コンストラクタ
	 * @throws Exception
	 */
	public MainFrame() throws Exception {
		this.setResizable(false);
		this.setSize(315, 180);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(tabPanel);

		init();
	}

	/**
	 * 初期化
	 * @throws Exception
	 */
	private void init() throws Exception {

		List<TabModel> tabs = service.getTabs();

		for (TabModel tab : tabs) {
			tabPanel.addTab(tab.getName(), null, new TabItemPanel(tab), null);
		}
	}

	/**
	 * 再読込み
	 * @throws Exception
	 */
	public void reload() throws Exception {
		tabPanel.removeAll();
		init();
	}

}
