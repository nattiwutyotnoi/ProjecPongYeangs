package com.pongyeang.listRestaurantsandshopsSubCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class ListRestaurantsandshopsSubCategoryManager {
	private int noOfRecords;

	public SubCategoryRestaurants getListRestaurantsandshopsSubCategory(String restaurantsSubID, int offset,
			int noOfRecords) {
		SubCategoryRestaurants subCategoryRestaurants = new SubCategoryRestaurants();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select subcategoryrestaurantsID,subcategoryrestaurantsName "
				+ "from subcategoryrestaurants where subcategoryrestaurantsID = ? ;";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, restaurantsSubID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				subCategoryRestaurants.setSubcategoryrestaurantID(rs.getString(1));
				subCategoryRestaurants.setSubcategoryrestaurantName(rs.getString(2));
				subCategoryRestaurants
						.setVectorrestaurantsdetail(this.getDetailRestataurant(restaurantsSubID, offset, noOfRecords));

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

		return subCategoryRestaurants;
	}

	public Vector<RestaurantsDetail> getDetailRestataurant(String RestaurantsSubID, int offset, int noOfRecords) {
		Vector<RestaurantsDetail> vrestaurants = new Vector<RestaurantsDetail>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select SQL_CALC_FOUND_ROWS restaurantsdetail.restaurantsdetailID,restaurantsdetail.restaurantsdetailName,"
				+ "restaurantsdetail.restaurantsdetailData,restaurantsdetail.restaurantsdetailTitle,"
				+ "restaurantsdetail.opentime,restaurantsdetail.pricerange,restaurantsdetail.amenities,"
				+ "restaurantsdetail.statisticsvisit,address.addressID,address.datecreate,address.statusapproved "
				+ "from restaurantsdetail inner join address on address.addressID = restaurantsdetail.addressID "
				+ "where restaurantsdetail.subcategoryrestaurantsID = ? and address.statusapproved='yes' "
				+ "order by  restaurantsdetail.statisticsvisit desc limit ? , ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, RestaurantsSubID);
			stmt.setInt(2, offset);
			stmt.setInt(3, noOfRecords);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				RestaurantsDetail restaurantsDetail = new RestaurantsDetail();
				restaurantsDetail.setRestaurantsdetailID(rs.getInt(1));
				restaurantsDetail.setRestaurantsdetailName(rs.getString(2));
				restaurantsDetail.setRestaurantsdetailData(rs.getString(3));
				restaurantsDetail.setRestaurantsdetailTitel(rs.getString(4));
				restaurantsDetail.setOpentime(rs.getString(5));
				restaurantsDetail.setPricerange(rs.getString(6));
				restaurantsDetail.setAmenities(rs.getString(7));
				restaurantsDetail.setStatisticsvisit(rs.getInt(8));

				restaurantsDetail.getAddress().setAddressID(rs.getInt(9));
				restaurantsDetail.getAddress().setDatecreate(rs.getString(10));
				restaurantsDetail.getAddress().setStatusapproved(rs.getString(11));
				restaurantsDetail.getAddress().setVectorimages(this.getImgListRastataurants(restaurantsDetail.getAddress().getAddressID()));

				vrestaurants.add(restaurantsDetail);
			}
			rs.close();
			rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if (rs.next())
				this.noOfRecords = rs.getInt(1);
			if (stmt != null)
				stmt.close();
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
		return vrestaurants;
	}

	public Vector<Images> getImgListRastataurants(int addressID) {
		Vector<Images> listimges = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select address.addressID,image.imageID,image.imageName,image.imageDetail "
				+ "from address inner join image on image.addressID = address.addressID where address.addressID= ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, addressID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Images imges = new Images();
				imges.setImageID(rs.getInt(2));
				imges.setImageName(rs.getString(3));
				imges.setImageDetail(rs.getString(4));
				listimges.add(imges);
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

		return listimges;
	}

	public int getNoOfRecords() {
		return noOfRecords;
	}
}
