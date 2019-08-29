package jp.lancher.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.lancher.domain.object.TabItem;
import jp.lancher.domain.utils.DBUtil;

public class TabItemRepository {

	public List<TabItem> findAll() throws Exception {

		List<TabItem> tabItems = new ArrayList<TabItem>();

		try {

			String sql = "SELECT * FROM M_TAB_ITEM";
			Object[] params = new Object[0];

			List<Map<String, Object>> results = DBUtil.executeQuery(sql, params);

			for (Map<String, Object> map : results) {
				TabItem tabItem = new TabItem();
				tabItem.setTabId((String) map.get("TAB_ID"));
				tabItem.setRno((int) map.get("RNO"));
				tabItem.setName((String) map.get("NAME"));
				tabItem.setPath((String) map.get("PATH"));
				tabItems.add(tabItem);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

		return tabItems;
	}

	public void update(List<TabItem> items) {
		try {

			String sql = "UPDATE SET NAME = ?, PATH = ? FROM M_TAB_ITEM WHERE TAB_ID = ? AND RNO = ?";

			for (TabItem item : items) {
			
				Object[] params = new Object[4];
				params[0] = item.getName();
				params[1] = item.getPath();
				params[2] = item.getTabId();
				params[3] = item.getRno();

				DBUtil.execute(sql, params);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

}
