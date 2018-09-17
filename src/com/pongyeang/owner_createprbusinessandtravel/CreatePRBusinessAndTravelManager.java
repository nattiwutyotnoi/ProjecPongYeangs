package com.pongyeang.owner_createprbusinessandtravel;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class CreatePRBusinessAndTravelManager {
	private Category categorys = new Category();
	private Address address = new Address();

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Category getCategorys() {
		return categorys;
	}

	public void setCategorys(Category categorys) {
		this.categorys = categorys;
	}

	public Vector<Category> getListCategory() {
		Vector<Category> vectorcategory = new Vector<>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select categoryID,categoryName from category;";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Category category = new Category(rs.getString(1), rs.getString(2));
				vectorcategory.add(category);
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
		return vectorcategory;
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

	public Vector<SubCategoryRestaurants> getListRastutaurantsSubCategory() {
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

	public int getMaxAddressID() {
		int addressID = 1;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select max(addressID) from address;";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				addressID = rs.getInt(1) + 1;
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

		return addressID;
	}

	public int getMaxTravelDetailID() {
		int traveldetailID = 1;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select max(traveldetailID) from traveldetail;";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				traveldetailID = rs.getInt(1) + 1;
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
		return traveldetailID;
	}

	public int getMaxHotelDetailID() {
		int hoteldetailID = 1;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select max(hoteldetailID) from hoteldetail;";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				hoteldetailID = rs.getInt(1) + 1;
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
		return hoteldetailID;
	}

	public int getMaxReataurantsDetailID() {
		int reataurantsdetailID = 1;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select max(restaurantsdetailID) from restaurantsdetail;";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				reataurantsdetailID = rs.getInt(1) + 1;
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
		return reataurantsdetailID;
	}

	public void addPRBusinessAndTravel_TravelDetail(Login login, Category categorys) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call owner_createprbusinessandtravel_TravelDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัต
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, login.getOwner().getTravledetail().getTraveldetailID());
			cstmt.setString(2, login.getOwner().getTravledetail().getTraveldetailName());
			cstmt.setString(3, login.getOwner().getTravledetail().getTraveldetailData());
			cstmt.setString(4, login.getOwner().getTravledetail().getTraveldetailTitel());
			cstmt.setInt(5, 0);
			cstmt.setString(6, categorys.getVectorsubcategorytravel().get(0).getSubcategorytravelID());
			cstmt.setInt(7, login.getOwner().getOwnerID());
			cstmt.setInt(8, login.getOwner().getTravledetail().getAddress().getAddressID());
			cstmt.setString(9, login.getOwner().getTravledetail().getAddress().getAddressno());
			cstmt.setString(10, login.getOwner().getTravledetail().getAddress().getVillageno());
			cstmt.setString(11, login.getOwner().getTravledetail().getAddress().getAlley());
			cstmt.setString(12, login.getOwner().getTravledetail().getAddress().getStreet());
			cstmt.setString(13, login.getOwner().getTravledetail().getAddress().getSubdistrict());
			cstmt.setString(14, login.getOwner().getTravledetail().getAddress().getDistrict());
			cstmt.setString(15, login.getOwner().getTravledetail().getAddress().getProvince());
			cstmt.setString(16, login.getOwner().getTravledetail().getAddress().getZipcode());
			cstmt.setString(17, login.getOwner().getTravledetail().getAddress().getMapimage());
			cstmt.setString(18, login.getOwner().getTravledetail().getAddress().getMapimagedetail());
			cstmt.setString(19, login.getOwner().getTravledetail().getAddress().getLatitude());
			cstmt.setString(20, login.getOwner().getTravledetail().getAddress().getLongtitude());
			cstmt.setString(21, login.getOwner().getTravledetail().getTelephone());
			cstmt.setString(22, login.getOwner().getTravledetail().getFacebook());
			cstmt.setString(23, login.getOwner().getTravledetail().getLine());
			cstmt.setString(24, login.getOwner().getTravledetail().getTwitter());
			cstmt.setString(25, login.getOwner().getTravledetail().getWebsite());
			cstmt.setInt(26, login.getOwner().getTravledetail().getAddress().getVillageCategoryID().getVillageID());
			cstmt.setInt(27, login.getOwner().getTravledetail().getTraveldetailID());
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

	public void addPRBusinessAndTravel_HotelDetail(Login login, Category categorys) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call owner_createprbusinessandtravel_HotelDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัต
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, login.getOwner().getHoteldetail().getHoteldetailID());
			cstmt.setString(2, login.getOwner().getHoteldetail().getHoteldetailName());
			cstmt.setString(3, login.getOwner().getHoteldetail().getHoteldetailData());
			cstmt.setString(4, login.getOwner().getHoteldetail().getHoteldetailTitel());
			cstmt.setString(5, login.getOwner().getHoteldetail().getOpentime());
			cstmt.setString(6, login.getOwner().getHoteldetail().getCheckincheckout());
			cstmt.setString(7, login.getOwner().getHoteldetail().getHotelprice());
			cstmt.setString(8, login.getOwner().getHoteldetail().getRoomofnumber());
			cstmt.setString(9, login.getOwner().getHoteldetail().getAmenities());
			cstmt.setInt(10, 0);
			cstmt.setString(11, categorys.getVectorsubcategoryhotel().get(0).getSubcategoryhotelID());
			cstmt.setInt(12, login.getOwner().getOwnerID());
			cstmt.setInt(13, login.getOwner().getHoteldetail().getAddress().getAddressID());
			cstmt.setString(14, login.getOwner().getHoteldetail().getAddress().getAddressno());
			cstmt.setString(15, login.getOwner().getHoteldetail().getAddress().getVillageno());
			cstmt.setString(16, login.getOwner().getHoteldetail().getAddress().getAlley());
			cstmt.setString(17, login.getOwner().getHoteldetail().getAddress().getStreet());
			cstmt.setString(18, login.getOwner().getHoteldetail().getAddress().getSubdistrict());
			cstmt.setString(19, login.getOwner().getHoteldetail().getAddress().getDistrict());
			cstmt.setString(20, login.getOwner().getHoteldetail().getAddress().getProvince());
			cstmt.setString(21, login.getOwner().getHoteldetail().getAddress().getZipcode());
			cstmt.setString(22, login.getOwner().getHoteldetail().getAddress().getMapimage());
			cstmt.setString(23, login.getOwner().getHoteldetail().getAddress().getMapimagedetail());
			cstmt.setString(24, login.getOwner().getHoteldetail().getAddress().getLatitude());
			cstmt.setString(25, login.getOwner().getHoteldetail().getAddress().getLongtitude());
			cstmt.setString(26, login.getOwner().getHoteldetail().getTelephone());
			cstmt.setString(27, login.getOwner().getHoteldetail().getFacebook());
			cstmt.setString(28, login.getOwner().getHoteldetail().getLine());
			cstmt.setString(29, login.getOwner().getHoteldetail().getTwitter());
			cstmt.setString(30, login.getOwner().getHoteldetail().getWebsite());
			cstmt.setInt(31, login.getOwner().getHoteldetail().getAddress().getVillageCategoryID().getVillageID());
			cstmt.setInt(32, login.getOwner().getHoteldetail().getHoteldetailID());
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

	public void addPRBusinessAndTravel_ReatauarantslDetail(Login login, Category categorys) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call owner_createprbusinessandtravel_ReataurantsDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัต
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, login.getOwner().getRestaurantsdetail().getRestaurantsdetailID());
			cstmt.setString(2, login.getOwner().getRestaurantsdetail().getRestaurantsdetailName());
			cstmt.setString(3, login.getOwner().getRestaurantsdetail().getRestaurantsdetailData());
			cstmt.setString(4, login.getOwner().getRestaurantsdetail().getRestaurantsdetailTitel());
			cstmt.setString(5, login.getOwner().getRestaurantsdetail().getOpentime());
			cstmt.setString(6, login.getOwner().getRestaurantsdetail().getPricerange());
			cstmt.setString(7, login.getOwner().getRestaurantsdetail().getAmenities());
			cstmt.setInt(8, 0);
			cstmt.setString(9, categorys.getVectorsubcategoryrestaurants().get(0).getSubcategoryrestaurantID());
			cstmt.setInt(10, login.getOwner().getOwnerID());
			cstmt.setInt(11, login.getOwner().getRestaurantsdetail().getAddress().getAddressID());
			cstmt.setString(12, login.getOwner().getRestaurantsdetail().getAddress().getAddressno());
			cstmt.setString(13, login.getOwner().getRestaurantsdetail().getAddress().getVillageno());
			cstmt.setString(14, login.getOwner().getRestaurantsdetail().getAddress().getAlley());
			cstmt.setString(15, login.getOwner().getRestaurantsdetail().getAddress().getStreet());
			cstmt.setString(16, login.getOwner().getRestaurantsdetail().getAddress().getSubdistrict());
			cstmt.setString(17, login.getOwner().getRestaurantsdetail().getAddress().getDistrict());
			cstmt.setString(18, login.getOwner().getRestaurantsdetail().getAddress().getProvince());
			cstmt.setString(19, login.getOwner().getRestaurantsdetail().getAddress().getZipcode());
			cstmt.setString(20, login.getOwner().getRestaurantsdetail().getAddress().getMapimage());
			cstmt.setString(21, login.getOwner().getRestaurantsdetail().getAddress().getMapimagedetail());
			cstmt.setString(22, login.getOwner().getRestaurantsdetail().getAddress().getLatitude());
			cstmt.setString(23, login.getOwner().getRestaurantsdetail().getAddress().getLongtitude());
			cstmt.setString(24, login.getOwner().getRestaurantsdetail().getTelephone());
			cstmt.setString(25, login.getOwner().getRestaurantsdetail().getFacebook());
			cstmt.setString(26, login.getOwner().getRestaurantsdetail().getLine());
			cstmt.setString(27, login.getOwner().getRestaurantsdetail().getTwitter());
			cstmt.setString(28, login.getOwner().getRestaurantsdetail().getWebsite());
			cstmt.setInt(29,
					login.getOwner().getRestaurantsdetail().getAddress().getVillageCategoryID().getVillageID());
			cstmt.setInt(30, login.getOwner().getRestaurantsdetail().getRestaurantsdetailID());
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

	public void addPRBusinessAndTravel_Images(Address address) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call owner_createprbusinessandtravel_Images(?,?,?)";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัต
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			for (int i = 0; i < address.getVectorimages().size(); i++) {
				cstmt.setString(1, address.getVectorimages().get(i).getImageName());
				cstmt.setString(2, address.getVectorimages().get(i).getImageDetail());
				cstmt.setInt(3, address.getAddressID());
			}

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

	public Owner getCreatePRBusinessAndTravel(Login login) {
		Owner owner = new Owner();
		Category category = new Category();
		Vector<Images> listimages = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt_travle = null;
		PreparedStatement stmt_hotel = null;
		PreparedStatement stmt_resturants = null;
		try {
			Vector<SubCategoryTravel> listsubCategoryTravel = new Vector<>();
			SubCategoryTravel subCategoryTravel = new SubCategoryTravel();
			Vector<TravelDetail> listtravelDetail = new Vector<>();
			String sql = "select traveldetail.traveldetailID,traveldetail.traveldetailName,traveldetail.traveldetailData,"
					+ "traveldetail.traveldetailTitle,traveldetail.statisticsvisit ,traveldetail.ownerID,"
					+ "traveldetail.subcategorytravelID,subcategorytravel.subcategorytravelName,"
					+ "subcategorytravel.categoryID,category.categoryName,"
					+ "address.addressID,address.addressno, address.villageno,address.alley,address.street,address.subdistrict,address.district,"
					+ "address.province,address.zipcode,address.mapimage,address.mapimagedetail,date_format(address.datecreate,'%d/%m/%Y'),address.latitude,"
					+ "address.longtitude,traveldetail.telephone,traveldetail.facebook,traveldetail.line,"
					+ "traveldetail.twitter,traveldetail.website,image.imageID,image.imageName,image.imageDetail,"
					+ "villagecategory.villageID,villagecategory.villageName from traveldetail "
					+ "inner join owner on traveldetail.ownerID = owner.ownerID "
					+ "inner join subcategorytravel on traveldetail.subcategorytravelID = subcategorytravel.subcategorytravelID "
					+ "inner join category on subcategorytravel.categoryID = category.categoryID "
					+ "inner join address on address.addressID = traveldetail.addressID "
					+ "inner join image on image.addressID = address.addressID "
					+ "inner join villagecategory on address.villageID = villagecategory.villageID "
					+ "where owner.OwnerID = ? ;";
			stmt_travle = conn.prepareStatement(sql);
			stmt_travle.setInt(1, login.getOwner().getOwnerID());
			ResultSet rs = stmt_travle.executeQuery();
			while (rs.next() && login.getOwner().getOwnerID() == rs.getInt(6)) {
				owner.getTravledetail().setTraveldetailID(rs.getInt(1));
				owner.getTravledetail().setTraveldetailName(rs.getString(2));
				owner.getTravledetail().setTraveldetailData(rs.getString(3));
				owner.getTravledetail().setTraveldetailTitel(rs.getString(4));
				owner.getTravledetail().setStatisticsvisit(rs.getInt(5));
				owner.setOwnerID(rs.getInt(6));
				category.getVectorsubcategorytravel().add(new SubCategoryTravel(rs.getString(7), rs.getString(8), ""));
				category.setCategoryID(rs.getString(9));
				category.setCategoryName(rs.getString(10));
				owner.getTravledetail().getAddress().setAddressID(rs.getInt(11));
				owner.getTravledetail().getAddress().setAddressno(rs.getString(12));
				owner.getTravledetail().getAddress().setVillageno(rs.getString(13));
				owner.getTravledetail().getAddress().setAlley(rs.getString(14));
				owner.getTravledetail().getAddress().setStreet(rs.getString(15));
				owner.getTravledetail().getAddress().setSubdistrict(rs.getString(16));
				owner.getTravledetail().getAddress().setDistrict(rs.getString(17));
				owner.getTravledetail().getAddress().setProvince(rs.getString(18));
				owner.getTravledetail().getAddress().setZipcode(rs.getString(19));
				owner.getTravledetail().getAddress().setMapimage(rs.getString(20));
				owner.getTravledetail().getAddress().setMapimagedetail(rs.getString(21));
				owner.getTravledetail().getAddress().setDatecreate(rs.getString(22));
				owner.getTravledetail().getAddress().setLatitude(rs.getString(23));
				owner.getTravledetail().getAddress().setLongtitude(rs.getString(24));
				owner.getTravledetail().setTelephone(rs.getString(25));
				owner.getTravledetail().setFacebook(rs.getString(26));
				owner.getTravledetail().setLine(rs.getString(27));
				owner.getTravledetail().setTwitter(rs.getString(28));
				owner.getTravledetail().setWebsite(rs.getString(29));
				owner.getTravledetail().getAddress().getVectorimages()
						.add(new Images(rs.getInt(30), rs.getString(31), rs.getString(32)));
				owner.getTravledetail().getAddress().getVillageCategoryID().setVillageID(rs.getInt(33));
				owner.getTravledetail().getAddress().getVillageCategoryID().setVillageName(rs.getString(34));
				listimages.add(owner.getTravledetail().getAddress().getVectorimages().get(0));
				listsubCategoryTravel.add(category.getVectorsubcategorytravel().get(0));
				listtravelDetail.add(owner.getTravledetail());
			}
			subCategoryTravel.setVectortraveldetail(listtravelDetail);
			category.setVectorsubcategorytravel(listsubCategoryTravel);
			// owner.setTravledetail(travelDetail);
			rs.close();

			Vector<SubCategoryHotel> listsubCategoryHotel = new Vector<>();
			SubCategoryHotel subCategoryHotel = new SubCategoryHotel();
			Vector<HotelDetail> listhotelDetail = new Vector<>();
			String sql2 = " select hoteldetail.hoteldetailID,hoteldetail.hoteldetailName,"
					+ "hoteldetail.hoteldetailData,hoteldetail.hoteldetailTitle,hoteldetail.opentime,"
					+ "hoteldetail.checkincheckout,hoteldetail.roomofnumber,hoteldetail.hotelprice,"
					+ "hoteldetail.amenities,hoteldetail.statisticsvisit,hoteldetail.ownerID,"
					+ "hoteldetail.subcategoryhotelID,subcategoryhotel.subcategoryhotelName, category.categoryID,category.categoryName,"
					+ "address.addressID,address.addressno, address.villageno,address.alley,address.street,address.subdistrict,address.district,"
					+ "address.province,address.zipcode,address.mapimage,address.mapimagedetail,date_format(address.datecreate,'%d/%m/%Y'),address.latitude,"
					+ "address.longtitude,hoteldetail.telephone,hoteldetail.facebook,hoteldetail.line,"
					+ "hoteldetail.twitter,hoteldetail.website,image.imageID,image.imageName,image.imageDetail,"
					+ "villagecategory.villageID,villagecategory.villageName from hoteldetail "
					+ " inner join owner on hoteldetail.ownerID = owner.ownerID "
					+ "inner join subcategoryhotel on hoteldetail.subcategoryhotelID = subcategoryhotel.subcategoryhotelID "
					+ " inner join category on subcategoryhotel.categoryID = category.categoryID "
					+ "inner join address on address.addressID = hoteldetail.addressID "
					+ "inner join villagecategory on address.villageID = villagecategory.villageID "
					+ "inner join image on image.addressID = address.addressID where owner.OwnerID = ? ;";
			stmt_hotel = conn.prepareStatement(sql2);
			stmt_hotel.setInt(1, login.getOwner().getOwnerID());
			ResultSet rs2 = stmt_hotel.executeQuery();
			while (rs2.next() && login.getOwner().getOwnerID() == rs2.getInt(11)) {
				owner.getHoteldetail().setHoteldetailID(rs2.getInt(1));
				owner.getHoteldetail().setHoteldetailName(rs2.getString(2));
				owner.getHoteldetail().setHoteldetailData(rs2.getString(3));
				owner.getHoteldetail().setHoteldetailTitel(rs2.getString(4));
				owner.getHoteldetail().setOpentime(rs2.getString(5));
				owner.getHoteldetail().setCheckincheckout(rs2.getString(6));
				owner.getHoteldetail().setRoomofnumber(rs2.getString(7));
				owner.getHoteldetail().setHotelprice(rs2.getString(8));
				owner.getHoteldetail().setAmenities(rs2.getString(9));
				owner.getHoteldetail().setStatisticsvisit(rs2.getInt(10));
				owner.setOwnerID(rs2.getInt(11));
				category.getVectorsubcategoryhotel().add(new SubCategoryHotel(rs.getString(12), rs.getString(13), ""));
				category.setCategoryID(rs2.getString(14));
				category.setCategoryName(rs2.getString(15));
				owner.getHoteldetail().getAddress().setAddressID(rs2.getInt(16));
				owner.getHoteldetail().getAddress().setAddressno(rs2.getString(17));
				owner.getHoteldetail().getAddress().setVillageno(rs2.getString(18));
				owner.getHoteldetail().getAddress().setAlley(rs2.getString(19));
				owner.getHoteldetail().getAddress().setStreet(rs2.getString(20));
				owner.getHoteldetail().getAddress().setSubdistrict(rs2.getString(21));
				owner.getHoteldetail().getAddress().setDistrict(rs2.getString(22));
				owner.getHoteldetail().getAddress().setProvince(rs2.getString(23));
				owner.getHoteldetail().getAddress().setZipcode(rs2.getString(24));
				owner.getHoteldetail().getAddress().setMapimage(rs2.getString(25));
				owner.getHoteldetail().getAddress().setMapimagedetail(rs2.getString(26));
				owner.getHoteldetail().getAddress().setDatecreate(rs2.getString(27));
				owner.getHoteldetail().getAddress().setLatitude(rs2.getString(28));
				owner.getHoteldetail().getAddress().setLongtitude(rs2.getString(29));
				owner.getHoteldetail().setTelephone(rs2.getString(30));
				owner.getHoteldetail().setFacebook(rs2.getString(31));
				owner.getHoteldetail().setLine(rs2.getString(32));
				owner.getHoteldetail().setTwitter(rs2.getString(33));
				owner.getHoteldetail().setWebsite(rs2.getString(34));
				owner.getHoteldetail().getAddress().getVectorimages()
						.add(new Images(rs2.getInt(35), rs2.getString(36), rs2.getString(37)));
				owner.getHoteldetail().getAddress().getVillageCategoryID().setVillageID(rs2.getInt(38));
				owner.getHoteldetail().getAddress().getVillageCategoryID().setVillageName(rs2.getString(39));
				listimages.add(owner.getHoteldetail().getAddress().getVectorimages().get(0));
				listhotelDetail.add(owner.getHoteldetail());
				listsubCategoryHotel.add(category.getVectorsubcategoryhotel().get(0));
			}
			subCategoryHotel.setVectorhoteldetail(listhotelDetail);
			category.setVectorsubcategoryhotel(listsubCategoryHotel);
			rs2.close();

			Vector<SubCategoryRestaurants> listsubCategoryRestaurants = new Vector<>();
			Vector<RestaurantsDetail> listrestaurantsDetails = new Vector<>();
			SubCategoryRestaurants subCategoryRestaurants = new SubCategoryRestaurants();
			String sql3 = "select restaurantsdetail.restaurantsdetailID,restaurantsdetail.restaurantsdetailName,"
					+ "restaurantsdetail.restaurantsdetailData,restaurantsdetail.restaurantsdetailTitle,"
					+ "restaurantsdetail.opentime,restaurantsdetail.pricerange,restaurantsdetail.amenities,"
					+ "restaurantsdetail.statisticsvisit,restaurantsdetail.ownerID,"
					+ "subcategoryrestaurants.subcategoryrestaurantsID,subcategoryrestaurants.subcategoryrestaurantsName,"
					+ "subcategoryrestaurants.categoryID,category.categoryName,"
					+ "address.addressID,address.addressno, address.villageno,address.alley,address.street,address.subdistrict,address.district,"
					+ "address.province,address.zipcode,address.mapimage,address.mapimagedetail,date_format(address.datecreate,'%d/%m/%Y'),address.latitude,"
					+ "address.longtitude,restaurantsdetail.telephone,restaurantsdetail.facebook,restaurantsdetail.line,"
					+ "restaurantsdetail.twitter,restaurantsdetail.website,image.imageID,image.imageName,image.imageDetail,"
					+ "villagecategory.villageID,villagecategory.villageName from restaurantsdetail "
					+ "inner join owner on restaurantsdetail.ownerID = owner.ownerID "
					+ "inner join address on address.addressID = restaurantsdetail.addressID "
					+ " inner join subcategoryrestaurants on restaurantsdetail.subcategoryrestaurantsID = subcategoryrestaurants.subcategoryrestaurantsID "
					+ "inner join category on subcategoryrestaurants.categoryID = category.categoryID "
					+ "inner join villagecategory on address.villageID = villagecategory.villageID "
					+ "inner join image on image.addressID = address.addressID where owner.OwnerID = ? ;";
			stmt_resturants = conn.prepareStatement(sql3);
			stmt_resturants.setInt(1, login.getOwner().getOwnerID());
			ResultSet rs3 = stmt_resturants.executeQuery();
			while (rs3.next() && login.getOwner().getOwnerID() == rs3.getInt(9)) {
				owner.getRestaurantsdetail().setRestaurantsdetailID(rs3.getInt(1));
				owner.getRestaurantsdetail().setRestaurantsdetailName(rs3.getString(2));
				owner.getRestaurantsdetail().setRestaurantsdetailData(rs3.getString(3));
				owner.getRestaurantsdetail().setRestaurantsdetailTitel(rs3.getString(4));
				owner.getRestaurantsdetail().setOpentime(rs3.getString(5));
				owner.getRestaurantsdetail().setPricerange(rs3.getString(6));
				owner.getRestaurantsdetail().setAmenities(rs3.getString(7));
				owner.getRestaurantsdetail().setStatisticsvisit(rs3.getInt(8));
				owner.setOwnerID(rs3.getInt(9));
				category.getVectorsubcategoryrestaurants()
						.add(new SubCategoryRestaurants(rs3.getString(10), rs3.getString(11), ""));
				category.setCategoryID(rs3.getString(12));
				category.setCategoryName(rs3.getString(13));
				owner.getRestaurantsdetail().getAddress().setAddressID(rs3.getInt(14));
				owner.getRestaurantsdetail().getAddress().setAddressno(rs3.getString(15));
				owner.getRestaurantsdetail().getAddress().setVillageno(rs3.getString(16));
				owner.getRestaurantsdetail().getAddress().setAlley(rs3.getString(17));
				owner.getRestaurantsdetail().getAddress().setStreet(rs3.getString(18));
				owner.getRestaurantsdetail().getAddress().setSubdistrict(rs3.getString(19));
				owner.getRestaurantsdetail().getAddress().setDistrict(rs3.getString(20));
				owner.getRestaurantsdetail().getAddress().setProvince(rs3.getString(21));
				owner.getRestaurantsdetail().getAddress().setZipcode(rs3.getString(22));
				owner.getRestaurantsdetail().getAddress().setMapimage(rs3.getString(23));
				owner.getRestaurantsdetail().getAddress().setMapimagedetail(rs3.getString(24));
				owner.getRestaurantsdetail().getAddress().setDatecreate(rs3.getString(25));
				owner.getRestaurantsdetail().getAddress().setLatitude(rs3.getString(26));
				owner.getRestaurantsdetail().getAddress().setLongtitude(rs3.getString(27));
				owner.getRestaurantsdetail().setTelephone(rs3.getString(28));
				owner.getRestaurantsdetail().setFacebook(rs3.getString(29));
				owner.getRestaurantsdetail().setLine(rs3.getString(30));
				owner.getRestaurantsdetail().setTwitter(rs3.getString(31));
				owner.getRestaurantsdetail().setWebsite(rs3.getString(32));
				owner.getRestaurantsdetail().getAddress().getVectorimages()
						.add(new Images(rs3.getInt(33), rs3.getString(34), rs3.getString(35)));
				owner.getRestaurantsdetail().getAddress().getVillageCategoryID().setVillageID(rs3.getInt(36));
				owner.getRestaurantsdetail().getAddress().getVillageCategoryID().setVillageName(rs3.getString(37));
				listimages.add(owner.getRestaurantsdetail().getAddress().getVectorimages().get(0));
				owner.getRestaurantsdetail().getAddress().setVillageCategoryID(owner.getRestaurantsdetail().getAddress().getVillageCategoryID());
				listrestaurantsDetails.add(owner.getRestaurantsdetail());
				listsubCategoryRestaurants.add(category.getVectorsubcategoryrestaurants().get(0));
			}
			subCategoryRestaurants.setVectorrestaurantsdetail(listrestaurantsDetails);
			category.setVectorsubcategoryrestaurants(listsubCategoryRestaurants);

			rs3.close();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmt_travle.close();
				stmt_hotel.close();
				stmt_resturants.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return owner;

	}

	public Vector<VillageCategory> getListVaillage() {
		Vector<VillageCategory> vectorvillagecategoery = new Vector<>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "Select villagecategory.villageID,villagecategory.villageName,villagecategory.villageDetail from villagecategory ";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				VillageCategory villagecategory = new VillageCategory(rs.getInt(1), rs.getString(2), rs.getString(3));
				vectorvillagecategoery.add(villagecategory);
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
		return vectorvillagecategoery;
	}
}
