package jp.lancher.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.lancher.domain.object.Tab;
import jp.lancher.domain.utils.DBUtil;

public class TabRepository {

	public List<Tab> findAll() throws Exception {

		List<Tab> tabs = new ArrayList<Tab>();

		try {

			String sql = "SELECT * FROM M_TAB";
			Object[] params = new Object[0];

			List<Map<String, Object>> results = DBUtil.executeQuery(sql, params);

			for (Map<String, Object> map : results) {
				Tab tab = new Tab();
				tab.setId((int) map.get("ID"));
				tab.setTabId((String) map.get("TAB_ID"));
				tab.setName((String) map.get("NAME"));
				tabs.add(tab);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

		return tabs;
	}

	public void update(List<Tab> tabs) throws Exception {
		
		String sql = "UPDATE M_TAB SET NAME = ? WHERE ID = ?";
		
		try {

			for (Tab tab : tabs) {
				
				Object[] params = new Object[2];
				params[0] = tab.getName();
				params[1] = tab.getId();
				
				DBUtil.execute(sql, params);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

		}

	}

}
