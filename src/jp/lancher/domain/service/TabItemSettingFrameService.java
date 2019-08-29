package jp.lancher.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import jp.lancher.client.models.TabItemModel;
import jp.lancher.client.models.TabModel;
import jp.lancher.domain.object.Tab;
import jp.lancher.domain.object.TabItem;
import jp.lancher.domain.repository.TabItemRepository;

public class TabItemSettingFrameService {

	private TabItemRepository tabItemRepository = new TabItemRepository();

	public List<TabItemModel> getInitData() throws Exception {

		List<TabItemModel> models = new ArrayList<TabItemModel>();
		List<TabItem> tabItems = tabItemRepository.findAll();

		for (TabItem item : tabItems) {
			TabItemModel model = new TabItemModel();
			model.setTabId(item.getTabId());
			model.setRno(item.getRno());
			model.setName(item.getName());
			model.setPath(item.getPath());
			models.add(model);
		}

		return models;
	}

	public void regist(Vector vec) throws Exception {

		List<TabItem> items = new ArrayList<TabItem>();

		for (int i = 0; i < vec.size(); i++) {

			Vector v = (Vector) vec.get(i);

			String tabId = (String) v.get(0);
			int rno = (int) v.get(1);
			String name = (String) v.get(2);
			String path = (String) v.get(3);

			TabItem item = new TabItem();
			item.setTabId(tabId);
			item.setRno(rno);
			item.setName(name);
			item.setPath(path);
			items.add(item);
		}
		tabItemRepository.update(items);

	}

}
