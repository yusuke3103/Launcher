package jp.lancher.client.ui;

import java.util.List;

import javax.swing.JPanel;

import jp.lancher.domain.service.MainFrameService;
import jp.lancher.models.TabItemModel;
import jp.lancher.models.TabModel;

public class TabItemPanel extends JPanel {

	private MainFrameService service = new MainFrameService();
	private TabModel tabModel = null;

	/**
	 * コンストラクタ
	 * 
	 * @param tabModel
	 */
	public TabItemPanel(TabModel tabModel) throws Exception {
		this.tabModel = tabModel;
		this.setSize(300, 120);
		setLayout(null);

		init();
	}

	/**
	 * 初期化処理
	 * @throws Exception
	 */
	private void init() throws Exception {
		List<TabItemModel> models = service.getTabItems();
		for (int i = 0; i < models.size(); i++) {
			Button btn = new Button(models.get(i));
			if (i >= 5) {
				btn.setBounds((i - 5) * 60, 60, 60, 60);
			} else {
				btn.setBounds(i * 60, 0, 60, 60);
			}
			add(btn);
		}
	}

}
