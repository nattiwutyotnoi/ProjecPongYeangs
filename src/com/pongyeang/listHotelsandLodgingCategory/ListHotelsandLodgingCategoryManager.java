package com.pongyeang.listHotelsandLodgingCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class ListHotelsandLodgingCategoryManager {

	public Vector<SubCategoryHotel> getListSubCategoryHotel() {
		Vector<SubCategoryHotel> vectorHotel = new Vector<>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "Select subcategoryhotelID, subcategoryhotelName, subcategoryhotelImage from subcategoryhotel;";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				SubCategoryHotel subCategoryHotel = new SubCategoryHotel();
				subCategoryHotel.setSubcategoryhotelID(rs.getString(1));
				subCategoryHotel.setSubcategoryhotelName(rs.getString(2));
				subCategoryHotel.setSubcategoryhotelImage(rs.getString(3));
				vectorHotel.add(subCategoryHotel);
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
		return vectorHotel;
	}
}
