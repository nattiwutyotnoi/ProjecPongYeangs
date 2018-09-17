package com.pongyeang.owner_editregisterprofile;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class EditRegisterProfileManager {

	public void editRegisterProfile(Login login) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call owner_editprofile(?,?,?,?,?,?,?,?,?)";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัติ
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, login.getOwner().getOwnerFirstname());
			cstmt.setString(2, login.getOwner().getOwnerzLastname());
			cstmt.setString(3, login.getOwner().getIdcard());
			cstmt.setString(4, login.getOwner().getBithday());
			cstmt.setString(5, login.getOwner().getPhone());
			cstmt.setString(6, login.getOwner().getEmail());
			cstmt.setString(7, login.getUsername());
			cstmt.setString(8, login.getPassword());
			cstmt.executeUpdate();

			conn.commit();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
	}

	public VillageCategory getListVaillage() {
		VillageCategory villagecategory = new VillageCategory();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "Select villagecategory.villageID,villagecategory.villageName,villagecategory.villageDetail from villagecategory ";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				villagecategory.setVillageID(rs.getInt(1));
				villagecategory.setVillageName(rs.getString(2));
				villagecategory.setVillageDetail(rs.getString(3));
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
		return villagecategory;
	}

	public Category getListCategory() {
		Category category = new Category();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select categoryID,categoryName from category;";
		try {

			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				category.setCategoryID(rs.getString(1));
				category.setCategoryName(rs.getString(2));
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
		return category;
	}

	public Vector<SubCategoryTravel> getListTravelSubCategory() {
		Vector<SubCategoryTravel> vectorsubcategorytravel = new Vector<>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select subcategorytravelID,subcategorytravelName from subcategorytravel where categoryID = 1; ";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				SubCategoryTravel subcategorytravel = new SubCategoryTravel();
				subcategorytravel.setSubcategorytravelID(rs.getString(1));
				subcategorytravel.setSubcategorytravelName(rs.getString(2));
				vectorsubcategorytravel.add(subcategorytravel);
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
		return vectorsubcategorytravel;

	}

	public Vector<SubCategoryHotel> getListHotelSubCategory() {
		Vector<SubCategoryHotel> vectorsubcategoryhotel = new Vector<>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select subcategoryhotelID,subcategoryhotelName from subcategoryhotel where categoryID = 2;";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				SubCategoryHotel subcategoryhotel = new SubCategoryHotel();
				subcategoryhotel.setSubcategoryhotelID(rs.getString(1));
				subcategoryhotel.setSubcategoryhotelName(rs.getString(2));
				vectorsubcategoryhotel.add(subcategoryhotel);
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
		return vectorsubcategoryhotel;
	}

	public Vector<SubCategoryRestaurants> getListRestaurantsSubCategory() {
		Vector<SubCategoryRestaurants> vectorsubcategoryrestaurants = new Vector<>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select subcategoryrestaurantsID,subcategoryrestaurantsName from subcategoryrestaurants where categoryID = 3;";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				SubCategoryRestaurants subcategoryrestaurants = new SubCategoryRestaurants();
				subcategoryrestaurants.setSubcategoryrestaurantID(rs.getString(1));
				subcategoryrestaurants.setSubcategoryrestaurantName(rs.getString(2));
				vectorsubcategoryrestaurants.add(subcategoryrestaurants);
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
		return vectorsubcategoryrestaurants;
	}

	public SubCategoryTravel getEditListTravelSubCategory() {
		SubCategoryTravel subcategorytravel = new SubCategoryTravel();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select subcategorytravelID,subcategorytravelName from subcategorytravel where categoryID = 1; ";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				subcategorytravel.setSubcategorytravelID(rs.getString(1));
				subcategorytravel.setSubcategorytravelName(rs.getString(2));
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
		return subcategorytravel;

	}

	public SubCategoryHotel getEditListHotelSubCategory() {
		SubCategoryHotel subcategoryhotel = new SubCategoryHotel();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select subcategoryhotelID,subcategoryhotelName from subcategoryhotel where categoryID = 2;";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				subcategoryhotel.setSubcategoryhotelID(rs.getString(1));
				subcategoryhotel.setSubcategoryhotelName(rs.getString(2));
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
		return subcategoryhotel;
	}

	public SubCategoryRestaurants getEditListRestaurantsSubCategory() {
		SubCategoryRestaurants subcategoryrestaurants = new SubCategoryRestaurants();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select subcategoryrestaurantsID,subcategoryrestaurantsName from subcategoryrestaurants where categoryID = 3;";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				subcategoryrestaurants.setSubcategoryrestaurantID(rs.getString(1));
				subcategoryrestaurants.setSubcategoryrestaurantName(rs.getString(2));
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
		return subcategoryrestaurants;
	}

	public Owner getListTravelDetail(Login login) {
		Owner owner = new Owner();
		SubCategoryTravel subCategoryTravel = new SubCategoryTravel();
		Vector<TravelDetail> vecotrTravelDetail = new Vector<TravelDetail>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select traveldetail.traveldetailID,traveldetail.traveldetailName,traveldetail.traveldetailData"
				+ ",traveldetail.traveldetailTitle,traveldetail.statisticsvisit,traveldetail.subcategoryhotelID,"
				+ "owner.ownerFirstname, owner.ownerLastname, owner.idcard, owner.birthday,"
				+ " owner.phone, owner.email, owner.datecreate"
				+ "from traveldetail inner join owner on(traveldetail.ownerID=owner.ownerID)" + " where ownerID = ? ;";
		try {

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, login.getOwner().getOwnerID());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				owner.getTravledetail().setTraveldetailID(rs.getInt(1));
				owner.getTravledetail().setTraveldetailData(rs.getString(2));
				owner.getTravledetail().setTraveldetailName(rs.getString(3));
				owner.getTravledetail().setTraveldetailData(rs.getString(4));
				owner.getTravledetail().setTraveldetailTitel(rs.getString(5));
				subCategoryTravel.setSubcategorytravelID(rs.getString(6));
				owner.setOwnerID(rs.getInt(7));
				owner.setOwnerFirstname(rs.getString(8));
				owner.setOwnerzLastname(rs.getString(9));
				owner.setIdcard(rs.getString(10));
				owner.setBithday(rs.getString(11));
				owner.setPhone(rs.getString(12));
				owner.setEmail(rs.getString(13));
				owner.setDatecreate(rs.getString(14));

				vecotrTravelDetail.add(owner.getTravledetail());
				subCategoryTravel.setVectortraveldetail(vecotrTravelDetail);
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
		return owner;
	}
}
