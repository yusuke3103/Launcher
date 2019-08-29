package jp.lancher.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import jp.lancher.client.models.TabModel;
import jp.lancher.domain.object.Tab;
import jp.lancher.domain.repository.TabRepository;

public class TabSettingFrameService {

	private TabRepository tabRepository = new TabRepository();

	public List<TabModel> getInitData() throws Exception {

		List<TabModel> models = new ArrayList<TabModel>();
		List<Tab> tabs = tabRepository.findAll();

		for (Tab tab : tabs) {
			TabModel model = new TabModel();
			model.setId(tab.getId());
			model.setName(tab.getName());
			model.setTabId(tab.getTabId());
			models.add(model);
		}

		return models;
	}

	public void regist(Vector vec) throws Exception {

		List<Tab> tabs = new ArrayList<Tab>();

		

		for (int i = 0; i < vec.size(); i++) {
			
			Vector v = (Vector) vec.get(i);
			
			int id = (int) v.get(0);
			String name = (String) v.get(2);

			Tab tab = new Tab();
			tab.setId(id);
			tab.setName(name);
			tabs.add(tab);
		}
		tabRepository.update(tabs);

	}

}
