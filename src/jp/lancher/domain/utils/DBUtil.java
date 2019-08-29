package jp.lancher.domain.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {

	private static Connection getConnection() throws Exception {
		Class.forName("org.sqlite.JDBC");
		return DriverManager.getConnection("jdbc:sqlite:Resources/data.db");
	}

	public static List<Map<String, Object>> executeQuery(String sql, Object[] params) throws Exception {

		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		Connection con = null;
		PreparedStatement stmt = null;
		try {

			con = getConnection();
			stmt = con.prepareStatement(sql);

			int i = 0;
			for (Object param : params) {
				stmt.setObject(++i, param);
			}

			ResultSet rs = stmt.executeQuery();

			int colCnt = rs.getMetaData().getColumnCount();

			String[] colNames = new String[colCnt];
			for (int cnt = 0; cnt < colCnt; cnt++) {
				colNames[cnt] = rs.getMetaData().getColumnName(cnt + 1);
			}

			while (rs.next()) {
				
				Map<String, Object> map = new HashMap<String, Object>();
				
				for (String name : colNames) {
					map.put(name, rs.getObject(name));
				}
				
				results.add(map);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			if (con != null) {
				con.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return results;
	}

	public static void execute(String sql, Object[] params) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			
			con = getConnection();
			stmt = con.prepareStatement(sql);
			
			int i = 0;
			for (Object param : params) {
				stmt.setObject(++i, param);
			}
			
			stmt.execute();
			System.out.println(sql + "[" + Arrays.toString(params) + "]");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
