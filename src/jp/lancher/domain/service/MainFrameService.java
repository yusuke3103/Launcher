package jp.lancher.domain.service;

import java.util.ArrayList;
import java.util.List;

import jp.lancher.domain.object.Tab;
import jp.lancher.domain.object.TabItem;
import jp.lancher.domain.repository.TabItemRepository;
import jp.lancher.domain.repository.TabRepository;
import jp.lancher.models.TabItemModel;
import jp.lancher.models.TabModel;

public class MainFrameService {

	private TabRepository tabRepository = new TabRepository();
	private TabItemRepository tabItemRepository = new TabItemRepository();

	public List<TabModel> getTabs() throws Exception {

		List<TabModel> models = new ArrayList<TabModel>();
		List<Tab> tabs = tabRepository.getAll();

		for (Tab tab : tabs) {
			TabModel model = new TabModel();
			model.setId(tab.getId());
			model.setName(tab.getName());
			model.setTabId(tab.getTabId());
			models.add(model);
		}

		return models;
	}
	
	public List<TabItemModel> getTabItems() throws Exception {

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
}
