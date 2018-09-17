package com.pongyeang.listTravelCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class ListTravelCategoryManager {

	public Vector<SubCategoryTravel> getListTravelCategoryTravel() {
		Vector<SubCategoryTravel> vectorTravel = new Vector<>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select subcategorytravelID, subcategorytravelName, subcategorytravelImage from subcategorytravel;";
			try {
				stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					SubCategoryTravel subCategoryTravel = new SubCategoryTravel();
					subCategoryTravel.setSubcategorytravelID(rs.getString(1));
					subCategoryTravel.setSubcategorytravelName(rs.getString(2));
					subCategoryTravel.setSubcategoryhotelImage(rs.getString(3));
					vectorTravel.add(subCategoryTravel);
				}
				rs.close();
			}catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			} finally {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException ex) {
					ExceptionUtil.messageException(new Throwable(), ex);
				}
			}
		return vectorTravel;
	}
}
