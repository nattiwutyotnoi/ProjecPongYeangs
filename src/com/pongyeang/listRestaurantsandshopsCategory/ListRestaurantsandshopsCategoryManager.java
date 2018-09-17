package com.pongyeang.listRestaurantsandshopsCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class ListRestaurantsandshopsCategoryManager {
	public Vector<SubCategoryRestaurants> getListSubCategoryRestaurantsandshops() {
		Vector<SubCategoryRestaurants> vectorsubCategoryRestaurants = new Vector<>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "Select subcategoryrestaurantsID,subcategoryrestaurantsName,subcategoryrestaurantsImage"
				+ " from subcategoryrestaurants;";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				SubCategoryRestaurants subCategoryRestaurants = new SubCategoryRestaurants();
				subCategoryRestaurants.setSubcategoryrestaurantID(rs.getString(1));
				subCategoryRestaurants.setSubcategoryrestaurantName(rs.getString(2));
				subCategoryRestaurants.setSubcategoryrestaurantimage(rs.getString(3));
				vectorsubCategoryRestaurants.add(subCategoryRestaurants);
			}
			rs.close();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return vectorsubCategoryRestaurants;
	}
}
