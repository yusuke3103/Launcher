package jp.lancher.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.lancher.domain.object.Tab;
import jp.lancher.domain.utils.DBUtil;

public class TabRepository {

	public List<Tab> getAll() throws Exception {

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

}
