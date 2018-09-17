package com.pongyeang.owner_editprbusinessandtravel;

import java.sql.*;
import java.util.Vector;
import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class EditPRBusinessAndTravelManager {

	public void editPRBusinessAndTravel_TravelDetail(Login login, VillageCategory villageCategory, Category category) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call owner_editprbusinessandtravel_TravelDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัติ
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, login.getOwner().getTravledetail().getTraveldetailID());
			cstmt.setString(2, login.getOwner().getTravledetail().getTraveldetailName());
			cstmt.setString(3, login.getOwner().getTravledetail().getTraveldetailData());
			cstmt.setString(4, login.getOwner().getTravledetail().getTraveldetailTitel());
			cstmt.setInt(5, login.getOwner().getTravledetail().getStatisticsvisit());
			cstmt.setString(6, category.getVectorsubcategorytravel().get(0).getSubcategorytravelID());
			cstmt.setInt(7, login.getOwner().getOwnerID());
			cstmt.setInt(8, villageCategory.getVectoraddress().get(0).getAddressID());
			cstmt.setString(9, villageCategory.getVectoraddress().get(0).getAddressno());
			cstmt.setString(10, villageCategory.getVectoraddress().get(0).getVillageno());
			cstmt.setString(11, villageCategory.getVectoraddress().get(0).getAlley());
			cstmt.setString(12, villageCategory.getVectoraddress().get(0).getStreet());
			cstmt.setString(13, villageCategory.getVectoraddress().get(0).getSubdistrict());
			cstmt.setString(14, villageCategory.getVectoraddress().get(0).getDistrict());
			cstmt.setString(15, villageCategory.getVectoraddress().get(0).getProvince());
			cstmt.setString(16, villageCategory.getVectoraddress().get(0).getZipcode());
			cstmt.setString(17, villageCategory.getVectoraddress().get(0).getMapimage());
			cstmt.setString(18, villageCategory.getVectoraddress().get(0).getMapimagedetail());
			cstmt.setString(19, villageCategory.getVectoraddress().get(0).getLatitude());
			cstmt.setString(20, villageCategory.getVectoraddress().get(0).getLongtitude());
			cstmt.setString(21, login.getOwner().getTravledetail().getTelephone());
			cstmt.setString(22, login.getOwner().getTravledetail().getFacebook());
			cstmt.setString(23, login.getOwner().getTravledetail().getLine());
			cstmt.setString(24, login.getOwner().getTravledetail().getTwitter());
			cstmt.setString(25, login.getOwner().getTravledetail().getWebsite());
			cstmt.setString(26, villageCategory.getVectoraddress().get(0).getStatusapproved());
			cstmt.setInt(27, villageCategory.getVillageID());
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

	public void editPRBusinessAndTravel_HotelDetail(Login login, VillageCategory villageCategory, Category category) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call owner_editprbusinessandtravel_HotelDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัติ
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
			cstmt.setInt(10, login.getOwner().getHoteldetail().getStatisticsvisit());
			cstmt.setString(11, category.getVectorsubcategoryhotel().get(0).getSubcategoryhotelID());
			cstmt.setInt(12, login.getOwner().getOwnerID());
			cstmt.setInt(13, villageCategory.getVectoraddress().get(0).getAddressID());
			cstmt.setString(14, villageCategory.getVectoraddress().get(0).getAddressno());
			cstmt.setString(15, villageCategory.getVectoraddress().get(0).getVillageno());
			cstmt.setString(16, villageCategory.getVectoraddress().get(0).getAlley());
			cstmt.setString(17, villageCategory.getVectoraddress().get(0).getStreet());
			cstmt.setString(18, villageCategory.getVectoraddress().get(0).getSubdistrict());
			cstmt.setString(19, villageCategory.getVectoraddress().get(0).getDistrict());
			cstmt.setString(20, villageCategory.getVectoraddress().get(0).getProvince());
			cstmt.setString(21, villageCategory.getVectoraddress().get(0).getZipcode());
			cstmt.setString(22, villageCategory.getVectoraddress().get(0).getMapimage());
			cstmt.setString(23, villageCategory.getVectoraddress().get(0).getMapimagedetail());
			cstmt.setString(24, villageCategory.getVectoraddress().get(0).getLatitude());
			cstmt.setString(25, villageCategory.getVectoraddress().get(0).getLongtitude());
			cstmt.setString(26, login.getOwner().getHoteldetail().getTelephone());
			cstmt.setString(27, login.getOwner().getHoteldetail().getFacebook());
			cstmt.setString(28, login.getOwner().getHoteldetail().getLine());
			cstmt.setString(29, login.getOwner().getHoteldetail().getTwitter());
			cstmt.setString(30, login.getOwner().getHoteldetail().getWebsite());
			cstmt.setString(31, villageCategory.getVectoraddress().get(0).getStatusapproved());
			cstmt.setInt(32, villageCategory.getVillageID());
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

	public void editPRBusinessAndTravel_ReatauarantslDetail(Login login, VillageCategory villageCategory,
			Category category) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt2 = null;
		CallableStatement cstmt = null;
		String sql2 = "call owner_editprbusinessandtravel_ReataurantsDetail_address(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql = "call owner_editprbusinessandtravel_ReataurantsDetail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัติ
			 */
			conn.setAutoCommit(false);
			cstmt2 = conn.prepareCall(sql2);
			cstmt2.setInt(1, login.getOwner().getRestaurantsdetail().getRestaurantsdetailID());
			cstmt2.setString(2, villageCategory.getVectoraddress().get(0).getAddressno());
			cstmt2.setString(3, villageCategory.getVectoraddress().get(0).getVillageno());
			cstmt2.setString(4, villageCategory.getVectoraddress().get(0).getAlley());
			cstmt2.setString(5, villageCategory.getVectoraddress().get(0).getStreet());
			cstmt2.setString(6, villageCategory.getVectoraddress().get(0).getSubdistrict());
			cstmt2.setString(7, villageCategory.getVectoraddress().get(0).getDistrict());
			cstmt2.setString(8, villageCategory.getVectoraddress().get(0).getProvince());
			cstmt2.setString(9, villageCategory.getVectoraddress().get(0).getZipcode());
			cstmt2.setString(10, villageCategory.getVectoraddress().get(0).getMapimage());
			cstmt2.setString(11, villageCategory.getVectoraddress().get(0).getMapimagedetail());
			cstmt2.setString(12, villageCategory.getVectoraddress().get(0).getLatitude());
			cstmt2.setString(13, villageCategory.getVectoraddress().get(0).getLongtitude());
			cstmt2.setString(14, villageCategory.getVectoraddress().get(0).getStatusapproved());
			cstmt2.setInt(15, villageCategory.getVillageID());
			cstmt2.setInt(16, villageCategory.getVectoraddress().get(0).getAddressID());
			cstmt2.executeUpdate();

			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, login.getOwner().getRestaurantsdetail().getRestaurantsdetailID());
			cstmt.setString(2, login.getOwner().getRestaurantsdetail().getRestaurantsdetailName());
			cstmt.setString(3, login.getOwner().getRestaurantsdetail().getRestaurantsdetailData());
			cstmt.setString(4, login.getOwner().getRestaurantsdetail().getRestaurantsdetailTitel());
			cstmt.setString(5, login.getOwner().getRestaurantsdetail().getOpentime());
			cstmt.setString(6, login.getOwner().getRestaurantsdetail().getPricerange());
			cstmt.setString(7, login.getOwner().getRestaurantsdetail().getAmenities());
			cstmt.setInt(8, login.getOwner().getRestaurantsdetail().getStatisticsvisit());
			cstmt.setString(9, category.getVectorsubcategoryrestaurants().get(0).getSubcategoryrestaurantID());
			cstmt.setString(10, login.getOwner().getRestaurantsdetail().getTelephone());
			cstmt.setString(11, login.getOwner().getRestaurantsdetail().getFacebook());
			cstmt.setString(12, login.getOwner().getRestaurantsdetail().getLine());
			cstmt.setString(13, login.getOwner().getRestaurantsdetail().getTwitter());
			cstmt.setString(14, login.getOwner().getRestaurantsdetail().getWebsite());
			cstmt.setInt(15, login.getOwner().getOwnerID());
			cstmt.setInt(16, villageCategory.getVectoraddress().get(0).getAddressID());
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
				cstmt2.close();
				cstmt.close();

				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
	}

	public void editPRBusinessAndTravel_Images(VillageCategory villageCategory) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call owner_editprbusinessandtravel_Images( ? , ? , ? );";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัติ
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			for (Address address : villageCategory.getVectoraddress()) {
				for (Images image : address.getVectorimages()) {
					cstmt.setInt(1, image.getImageID());
					cstmt.setString(2, image.getImageName());
					cstmt.setString(3, image.getImageDetail());
				}
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

	public void addPRBusinessAndTravel_Images(VillageCategory villageCategory) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call owner_createprbusinessandtravel_Images(?,?,?)";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัติ
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);

			for (Address address : villageCategory.getVectoraddress()) {
				for (Images image : address.getVectorimages()) {
					cstmt.setString(1, image.getImageName());
					cstmt.setString(2, image.getImageDetail());
					cstmt.setInt(3, address.getAddressID());
				}
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

	public Vector<Category> getEditPRBusinessAndTravelDetail_Category(Login login) {
		Vector<Category> listcategories = new Vector<>();
		Owner owner = new Owner();
		Category category = new Category();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt_travle = null;
		PreparedStatement stmt_travle_sub = null;
		PreparedStatement stmt_travle_cat = null;
		PreparedStatement stmt_hotel = null;
		PreparedStatement stmt_hotel_sub = null;
		PreparedStatement stmt_hotel_cat = null;
		PreparedStatement stmt_res = null;
		PreparedStatement stmt_res_sub = null;
		PreparedStatement stmt_res_cat = null;
		try {
			Vector<SubCategoryTravel> listsubCategoryTravel = new Vector<>();
			SubCategoryTravel subCategoryTravel = new SubCategoryTravel();
			Vector<TravelDetail> listtravelDetail = new Vector<>();
			String sql = "select traveldetail.traveldetailID,traveldetail.traveldetailName,traveldetail.traveldetailData,"
					+ "traveldetail.traveldetailTitle,traveldetail.statisticsvisit ,traveldetail.ownerID,"
					+ "address.addressID,address.addressno, address.villageno,address.alley,address.street,address.subdistrict,address.district,"
					+ "address.province,address.zipcode,address.mapimage,date_format(address.datecreate,'%d/%m/%Y'),address.latitude,"
					+ "address.longtitude,traveldetail.telephone,traveldetail.facebook,traveldetail.line,"
					+ "traveldetail.twitter,traveldetail.website,address.statusapproved,image.imageID,image.imageName,image.imageDetail,"
					+ "villagecategory.villageID,villagecategory.villageName from traveldetail "
					+ "inner join owner on traveldetail.ownerID = owner.ownerID "
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
				owner.getTravledetail().getAddress().setAddressID(rs.getInt(7));
				owner.getTravledetail().getAddress().setAddressno(rs.getString(8));
				owner.getTravledetail().getAddress().setVillageno(rs.getString(9));
				owner.getTravledetail().getAddress().setAlley(rs.getString(10));
				owner.getTravledetail().getAddress().setStreet(rs.getString(11));
				owner.getTravledetail().getAddress().setSubdistrict(rs.getString(12));
				owner.getTravledetail().getAddress().setDistrict(rs.getString(13));
				owner.getTravledetail().getAddress().setProvince(rs.getString(14));
				owner.getTravledetail().getAddress().setZipcode(rs.getString(15));
				owner.getTravledetail().getAddress().setMapimage(rs.getString(16));
				owner.getTravledetail().getAddress().setDatecreate(rs.getString(17));
				owner.getTravledetail().getAddress().setLatitude(rs.getString(18));
				owner.getTravledetail().getAddress().setLongtitude(rs.getString(19));
				owner.getTravledetail().setTelephone(rs.getString(20));
				owner.getTravledetail().setFacebook(rs.getString(21));
				owner.getTravledetail().setLine(rs.getString(22));
				owner.getTravledetail().setTwitter(rs.getString(23));
				owner.getTravledetail().setWebsite(rs.getString(24));
				owner.getTravledetail().getAddress().setStatusapproved(rs.getString(25));
				owner.getTravledetail().getAddress().getVectorimages()
						.add(new Images(rs.getInt(26), rs.getString(27), rs.getString(28)));
				owner.getTravledetail().getAddress().getVillageCategoryID().setVillageID(rs.getInt(29));
				owner.getTravledetail().getAddress().getVillageCategoryID().setVillageName(rs.getString(30));

				String sql1_tr = "select subcategorytravel.subcategorytravelID,subcategorytravel.subcategorytravelName "
						+ "from traveldetail inner join subcategorytravel on (traveldetail.subcategorytravelID = subcategorytravel.subcategorytravelID) "
						+ "where traveldetail.traveldetailID = ? ;";
				stmt_travle_sub = conn.prepareStatement(sql1_tr);
				stmt_travle_sub.setInt(1, owner.getTravledetail().getTraveldetailID());
				ResultSet rs1_tr = stmt_travle_sub.executeQuery();
				if (rs1_tr.next()) {
					category.getVectorsubcategorytravel()
							.add(new SubCategoryTravel(rs1_tr.getString(1), rs1_tr.getString(2), ""));
					String sql2_tr = "select distinct(category.categoryID),category.categoryName "
							+ "from subcategorytravel inner join category on(subcategorytravel.categoryID=category.categoryID) "
							+ "where subcategorytravel.subcategorytravelID  = ? ;";
					stmt_travle_cat = conn.prepareStatement(sql2_tr);
					stmt_travle_cat.setString(1, category.getVectorsubcategorytravel().get(0).getSubcategorytravelID());
					ResultSet rs2_tr = stmt_travle_cat.executeQuery();
					if (rs2_tr.next()) {
						category.setCategoryID(rs2_tr.getString(1));
						category.setCategoryName(rs2_tr.getString(2));
						listcategories.addElement(category);
						listsubCategoryTravel.add(category.getVectorsubcategorytravel().get(0));
					}
					category.setVectorsubcategorytravel(listsubCategoryTravel);
					rs2_tr.close();
					stmt_travle_cat.close();
				}
				listtravelDetail.add(owner.getTravledetail());
				rs1_tr.close();
				stmt_travle_sub.close();
			}
			subCategoryTravel.setVectortraveldetail(listtravelDetail);
			rs.close();

			Vector<SubCategoryHotel> listsubCategoryHotel = new Vector<>();
			SubCategoryHotel subCategoryHotel = new SubCategoryHotel();
			Vector<HotelDetail> listhotelDetail = new Vector<>();
			String sql2 = " select hoteldetail.hoteldetailID,hoteldetail.hoteldetailName,"
					+ "hoteldetail.hoteldetailData,hoteldetail.hoteldetailTitle,hoteldetail.opentime,"
					+ "hoteldetail.checkincheckout,hoteldetail.roomofnumber,hoteldetail.hotelprice,"
					+ "hoteldetail.amenities,hoteldetail.statisticsvisit,hoteldetail.ownerID,"
					+ "address.addressID,address.addressno, address.villageno,address.alley,address.street,address.subdistrict,address.district,"
					+ "address.province,address.zipcode,address.mapimage,date_format(address.datecreate,'%d/%m/%Y'),address.latitude,"
					+ "address.longtitude,hoteldetail.telephone,hoteldetail.facebook,hoteldetail.line,"
					+ "hoteldetail.twitter,hoteldetail.website,address.statusapproved,image.imageID,image.imageName,image.imageDetail,"
					+ "villagecategory.villageID,villagecategory.villageName from hoteldetail "
					+ " inner join owner on hoteldetail.ownerID = owner.ownerID "
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
				owner.getHoteldetail().getAddress().setAddressID(rs2.getInt(12));
				owner.getHoteldetail().getAddress().setAddressno(rs2.getString(13));
				owner.getHoteldetail().getAddress().setVillageno(rs2.getString(14));
				owner.getHoteldetail().getAddress().setAlley(rs2.getString(15));
				owner.getHoteldetail().getAddress().setStreet(rs2.getString(16));
				owner.getHoteldetail().getAddress().setSubdistrict(rs2.getString(17));
				owner.getHoteldetail().getAddress().setDistrict(rs2.getString(18));
				owner.getHoteldetail().getAddress().setProvince(rs2.getString(19));
				owner.getHoteldetail().getAddress().setZipcode(rs2.getString(20));
				owner.getHoteldetail().getAddress().setMapimage(rs2.getString(21));
				owner.getHoteldetail().getAddress().setDatecreate(rs2.getString(22));
				owner.getHoteldetail().getAddress().setLatitude(rs2.getString(23));
				owner.getHoteldetail().getAddress().setLongtitude(rs2.getString(24));
				owner.getHoteldetail().setTelephone(rs2.getString(25));
				owner.getHoteldetail().setFacebook(rs2.getString(26));
				owner.getHoteldetail().setLine(rs2.getString(27));
				owner.getHoteldetail().setTwitter(rs2.getString(28));
				owner.getHoteldetail().setWebsite(rs2.getString(29));
				owner.getHoteldetail().getAddress().setStatusapproved(rs2.getString(30));
				owner.getHoteldetail().getAddress().getVectorimages()
						.add(new Images(rs2.getInt(31), rs2.getString(32), rs2.getString(33)));
				owner.getHoteldetail().getAddress().getVillageCategoryID().setVillageID(rs2.getInt(34));
				owner.getHoteldetail().getAddress().getVillageCategoryID().setVillageName(rs2.getString(35));

				String sql1_ht = "select subcategoryhotel.subcategoryhotelID,subcategoryhotel.subcategoryhotelName "
						+ "from hoteldetail inner join subcategoryhotel on (hoteldetail.subcategoryhotelID = subcategoryhotel.subcategoryhotelID) "
						+ "where hoteldetail.hoteldetailID = ? ;";
				stmt_hotel_sub = conn.prepareStatement(sql1_ht);
				stmt_hotel_sub.setInt(1, owner.getHoteldetail().getHoteldetailID());
				ResultSet rs1_ht = stmt_hotel_sub.executeQuery();
				if (rs1_ht.next()) {
					category.getVectorsubcategoryhotel()
							.add(new SubCategoryHotel(rs1_ht.getString(1), rs1_ht.getString(2), ""));
					String sql2_ht = "select distinct(category.categoryID),category.categoryName "
							+ "from subcategoryhotel inner join category on(subcategoryhotel.categoryID=category.categoryID) "
							+ "where subcategoryhotel.subcategoryhotelID  = ? ;";
					stmt_hotel_cat = conn.prepareStatement(sql2_ht);
					stmt_hotel_cat.setString(1, category.getVectorsubcategoryhotel().get(0).getSubcategoryhotelID());
					ResultSet rs2_ht = stmt_hotel_cat.executeQuery();
					if (rs2_ht.next()) {
						category.setCategoryID(rs2_ht.getString(1));
						category.setCategoryName(rs2_ht.getString(2));
						listcategories.addElement(category);
						listsubCategoryHotel.add(category.getVectorsubcategoryhotel().get(0));
					}
					stmt_hotel_cat.close();
					category.setVectorsubcategoryhotel(listsubCategoryHotel);
					rs2_ht.close();

				}
				listhotelDetail.add(owner.getHoteldetail());
				rs1_ht.close();
				stmt_hotel_sub.close();
			}
			subCategoryHotel.setVectorhoteldetail(listhotelDetail);
			category.setVectorsubcategoryhotel(listsubCategoryHotel);
			// owner.setHoteldetail(hotelDetail);
			rs2.close();

			Vector<SubCategoryRestaurants> listsubCategoryRestaurants = new Vector<>();
			Vector<RestaurantsDetail> listrestaurantsDetails = new Vector<>();
			SubCategoryRestaurants subCategoryRestaurants = new SubCategoryRestaurants();
			String sql3 = "select restaurantsdetail.restaurantsdetailID,restaurantsdetail.restaurantsdetailName,"
					+ "restaurantsdetail.restaurantsdetailData,restaurantsdetail.restaurantsdetailTitle,"
					+ "restaurantsdetail.opentime,restaurantsdetail.pricerange,restaurantsdetail.amenities,"
					+ "restaurantsdetail.statisticsvisit,restaurantsdetail.ownerID,"
					+ "address.addressID,address.addressno, address.villageno,address.alley,address.street,address.subdistrict,address.district,"
					+ "address.province,address.zipcode,address.mapimage,date_format(address.datecreate,'%d/%m/%Y'),address.latitude,"
					+ "address.longtitude,restaurantsdetail.telephone,restaurantsdetail.facebook,restaurantsdetail.line,"
					+ "restaurantsdetail.twitter,restaurantsdetail.website,address.statusapproved,image.imageID,image.imageName,image.imageDetail,"
					+ "villagecategory.villageID,villagecategory.villageName from restaurantsdetail "
					+ "inner join owner on restaurantsdetail.ownerID = owner.ownerID "
					+ "inner join address on address.addressID = restaurantsdetail.addressID "
					+ "inner join villagecategory on address.villageID = villagecategory.villageID "
					+ "inner join image on image.addressID = address.addressID where owner.OwnerID = ? ;";
			stmt_res = conn.prepareStatement(sql3);
			stmt_res.setInt(1, login.getOwner().getOwnerID());
			ResultSet rs3 = stmt_res.executeQuery();
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
				owner.getRestaurantsdetail().getAddress().setAddressID(rs3.getInt(10));
				owner.getRestaurantsdetail().getAddress().setAddressno(rs3.getString(11));
				owner.getRestaurantsdetail().getAddress().setVillageno(rs3.getString(12));
				owner.getRestaurantsdetail().getAddress().setAlley(rs3.getString(13));
				owner.getRestaurantsdetail().getAddress().setStreet(rs3.getString(14));
				owner.getRestaurantsdetail().getAddress().setSubdistrict(rs3.getString(15));
				owner.getRestaurantsdetail().getAddress().setDistrict(rs3.getString(16));
				owner.getRestaurantsdetail().getAddress().setProvince(rs3.getString(17));
				owner.getRestaurantsdetail().getAddress().setZipcode(rs3.getString(18));
				owner.getRestaurantsdetail().getAddress().setMapimage(rs3.getString(19));
				owner.getRestaurantsdetail().getAddress().setDatecreate(rs3.getString(20));
				owner.getRestaurantsdetail().getAddress().setLatitude(rs3.getString(21));
				owner.getRestaurantsdetail().getAddress().setLongtitude(rs3.getString(22));
				owner.getRestaurantsdetail().setTelephone(rs3.getString(23));
				owner.getRestaurantsdetail().setFacebook(rs3.getString(24));
				owner.getRestaurantsdetail().setLine(rs3.getString(25));
				owner.getRestaurantsdetail().setTwitter(rs3.getString(26));
				owner.getRestaurantsdetail().setWebsite(rs3.getString(27));
				owner.getRestaurantsdetail().getAddress().setStatusapproved(rs3.getString(28));
				owner.getRestaurantsdetail().getAddress().getVectorimages()
						.add(new Images(rs3.getInt(29), rs3.getString(30), rs3.getString(31)));
				owner.getRestaurantsdetail().getAddress().getVillageCategoryID().setVillageID(rs3.getInt(32));
				owner.getRestaurantsdetail().getAddress().getVillageCategoryID().setVillageName(rs3.getString(33));

				String sql1_rd = "select subcategoryrestaurants.subcategoryrestaurantsID,subcategoryrestaurants.subcategoryrestaurantsName "
						+ "from restaurantsdetail inner join subcategoryrestaurants on (restaurantsdetail.subcategoryrestaurantsID = subcategoryrestaurants.subcategoryrestaurantsID) "
						+ "where restaurantsdetail.restaurantsdetailID = ? ;";
				stmt_res_sub = conn.prepareStatement(sql1_rd);
				stmt_res_sub.setInt(1, owner.getRestaurantsdetail().getRestaurantsdetailID());
				ResultSet rs1_rd = stmt_res_sub.executeQuery();
				if (rs1_rd.next()) {
					category.getVectorsubcategoryrestaurants()
							.add(new SubCategoryRestaurants(rs1_rd.getString(1), rs1_rd.getString(2), ""));
					subCategoryRestaurants.setSubcategoryrestaurantID(rs1_rd.getString(1));
					subCategoryRestaurants.setSubcategoryrestaurantName(rs1_rd.getString(2));

					String sql2_rd = "select distinct(category.categoryID),category.categoryName "
							+ "from subcategoryrestaurants inner join category on(subcategoryrestaurants.categoryID = category.categoryID) "
							+ "where subcategoryrestaurants.subcategoryrestaurantsID  = ? ;";
					stmt_res_cat = conn.prepareStatement(sql2_rd);
					stmt_res_cat.setString(1,
							category.getVectorsubcategoryrestaurants().get(0).getSubcategoryrestaurantID());
					ResultSet rs2_rd = stmt_res_cat.executeQuery();
					if (rs2_rd.next()) {
						category.setCategoryID(rs2_rd.getString(1));
						category.setCategoryName(rs2_rd.getString(2));
						listcategories.addElement(category);
						listsubCategoryRestaurants.add(category.getVectorsubcategoryrestaurants().get(0));
					}
					category.setVectorsubcategoryrestaurants(listsubCategoryRestaurants);
					rs2_rd.close();
					stmt_res_cat.close();
				}
				listrestaurantsDetails.add(owner.getRestaurantsdetail());
				rs1_rd.close();
				stmt_res_sub.close();
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
				stmt_res.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return listcategories;
	}

	public VillageCategory getEditPRBusinessAndTravelDetail_VillageCategory(Login login) {
		Owner owner = new Owner();
		VillageCategory villageCategory = new VillageCategory();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt_travle = null;
		PreparedStatement stmt_hotel = null;
		PreparedStatement stmt_res = null;
		try {
			String sql = "select traveldetail.traveldetailID,traveldetail.traveldetailName,traveldetail.traveldetailData,"
					+ "traveldetail.traveldetailTitle,traveldetail.statisticsvisit ,traveldetail.ownerID,"
					+ "address.addressID,address.addressno, address.villageno,address.alley,address.street,address.subdistrict,address.district,"
					+ "address.province,address.zipcode,address.mapimage,date_format(address.datecreate,'%d/%m/%Y'),address.latitude,"
					+ "address.longtitude,traveldetail.telephone,traveldetail.facebook,traveldetail.line,"
					+ "traveldetail.twitter,traveldetail.website,address.statusapproved,image.imageID,image.imageName,image.imageDetail,"
					+ "villagecategory.villageID,villagecategory.villageName from traveldetail "
					+ "inner join owner on traveldetail.ownerID = owner.ownerID "
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
				owner.getTravledetail().getAddress().setAddressID(rs.getInt(7));
				owner.getTravledetail().getAddress().setAddressno(rs.getString(8));
				owner.getTravledetail().getAddress().setVillageno(rs.getString(9));
				owner.getTravledetail().getAddress().setAlley(rs.getString(10));
				owner.getTravledetail().getAddress().setStreet(rs.getString(11));
				owner.getTravledetail().getAddress().setSubdistrict(rs.getString(12));
				owner.getTravledetail().getAddress().setDistrict(rs.getString(13));
				owner.getTravledetail().getAddress().setProvince(rs.getString(14));
				owner.getTravledetail().getAddress().setZipcode(rs.getString(15));
				owner.getTravledetail().getAddress().setMapimage(rs.getString(16));
				owner.getTravledetail().getAddress().setDatecreate(rs.getString(17));
				owner.getTravledetail().getAddress().setLatitude(rs.getString(18));
				owner.getTravledetail().getAddress().setLongtitude(rs.getString(19));
				owner.getTravledetail().setTelephone(rs.getString(20));
				owner.getTravledetail().setFacebook(rs.getString(21));
				owner.getTravledetail().setLine(rs.getString(22));
				owner.getTravledetail().setTwitter(rs.getString(23));
				owner.getTravledetail().setWebsite(rs.getString(24));
				owner.getTravledetail().getAddress().setStatusapproved(rs.getString(25));
				owner.getTravledetail().getAddress().getVectorimages()
						.add(new Images(rs.getInt(26), rs.getString(27), rs.getString(28)));
				owner.getTravledetail().getAddress().getVillageCategoryID().setVillageID(rs.getInt(29));
				owner.getTravledetail().getAddress().getVillageCategoryID().setVillageName(rs.getString(30));
			}

			rs.close();
			String sql2 = " select hoteldetail.hoteldetailID,hoteldetail.hoteldetailName,"
					+ "hoteldetail.hoteldetailData,hoteldetail.hoteldetailTitle,hoteldetail.opentime,"
					+ "hoteldetail.checkincheckout,hoteldetail.roomofnumber,hoteldetail.hotelprice,"
					+ "hoteldetail.amenities,hoteldetail.statisticsvisit,hoteldetail.ownerID,"
					+ "address.addressID,address.addressno, address.villageno,address.alley,address.street,address.subdistrict,address.district,"
					+ "address.province,address.zipcode,address.mapimage,date_format(address.datecreate,'%d/%m/%Y'),address.latitude,"
					+ "address.longtitude,hoteldetail.telephone,hoteldetail.facebook,hoteldetail.line,"
					+ "hoteldetail.twitter,hoteldetail.website,address.statusapproved,image.imageID,image.imageName,image.imageDetail,"
					+ "villagecategory.villageID,villagecategory.villageName from hoteldetail "
					+ " inner join owner on hoteldetail.ownerID = owner.ownerID "
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
				owner.getHoteldetail().getAddress().setAddressID(rs2.getInt(12));
				owner.getHoteldetail().getAddress().setAddressno(rs2.getString(13));
				owner.getHoteldetail().getAddress().setVillageno(rs2.getString(14));
				owner.getHoteldetail().getAddress().setAlley(rs2.getString(15));
				owner.getHoteldetail().getAddress().setStreet(rs2.getString(16));
				owner.getHoteldetail().getAddress().setSubdistrict(rs2.getString(17));
				owner.getHoteldetail().getAddress().setDistrict(rs2.getString(18));
				owner.getHoteldetail().getAddress().setProvince(rs2.getString(19));
				owner.getHoteldetail().getAddress().setZipcode(rs2.getString(20));
				owner.getHoteldetail().getAddress().setMapimage(rs2.getString(21));
				owner.getHoteldetail().getAddress().setDatecreate(rs2.getString(22));
				owner.getHoteldetail().getAddress().setLatitude(rs2.getString(23));
				owner.getHoteldetail().getAddress().setLongtitude(rs2.getString(24));
				owner.getHoteldetail().setTelephone(rs2.getString(25));
				owner.getHoteldetail().setFacebook(rs2.getString(26));
				owner.getHoteldetail().setLine(rs2.getString(27));
				owner.getHoteldetail().setTwitter(rs2.getString(28));
				owner.getHoteldetail().setWebsite(rs2.getString(29));
				owner.getHoteldetail().getAddress().setStatusapproved(rs2.getString(30));
				owner.getHoteldetail().getAddress().getVectorimages()
						.add(new Images(rs2.getInt(31), rs2.getString(32), rs2.getString(33)));
				owner.getHoteldetail().getAddress().getVillageCategoryID().setVillageID(rs2.getInt(34));
				owner.getHoteldetail().getAddress().getVillageCategoryID().setVillageName(rs2.getString(35));
			}
			rs2.close();

			String sql3 = "select restaurantsdetail.restaurantsdetailID,restaurantsdetail.restaurantsdetailName,"
					+ "restaurantsdetail.restaurantsdetailData,restaurantsdetail.restaurantsdetailTitle,"
					+ "restaurantsdetail.opentime,restaurantsdetail.pricerange,restaurantsdetail.amenities,"
					+ "restaurantsdetail.statisticsvisit,restaurantsdetail.ownerID,"
					+ "address.addressID,address.addressno, address.villageno,address.alley,address.street,address.subdistrict,address.district,"
					+ "address.province,address.zipcode,address.mapimage,date_format(address.datecreate,'%d/%m/%Y'),address.latitude,"
					+ "address.longtitude,address.telephone,address.facebook,address.line,"
					+ "address.twitter,address.website,address.statusapproved,image.imageID,image.imageName,image.imageDetail,"
					+ "villagecategory.villageID,villagecategory.villageName from restaurantsdetail "
					+ "inner join owner on restaurantsdetail.ownerID = owner.ownerID "
					+ "inner join address on address.addressID = restaurantsdetail.addressID "
					+ "inner join villagecategory on address.villageID = villagecategory.villageID "
					+ "inner join image on image.addressID = address.addressID where owner.OwnerID = ? ;";
			stmt_res = conn.prepareStatement(sql3);
			stmt_res.setInt(1, login.getOwner().getOwnerID());
			ResultSet rs3 = stmt_res.executeQuery();
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
				owner.getRestaurantsdetail().getAddress().setAddressID(rs3.getInt(10));
				owner.getRestaurantsdetail().getAddress().setAddressno(rs3.getString(11));
				owner.getRestaurantsdetail().getAddress().setVillageno(rs3.getString(12));
				owner.getRestaurantsdetail().getAddress().setAlley(rs3.getString(13));
				owner.getRestaurantsdetail().getAddress().setStreet(rs3.getString(14));
				owner.getRestaurantsdetail().getAddress().setSubdistrict(rs3.getString(15));
				owner.getRestaurantsdetail().getAddress().setDistrict(rs3.getString(16));
				owner.getRestaurantsdetail().getAddress().setProvince(rs3.getString(17));
				owner.getRestaurantsdetail().getAddress().setMapimage(rs3.getString(19));
				owner.getRestaurantsdetail().getAddress().setDatecreate(rs3.getString(20));
				owner.getRestaurantsdetail().getAddress().setLatitude(rs3.getString(21));
				owner.getRestaurantsdetail().getAddress().setLongtitude(rs3.getString(22));
				owner.getRestaurantsdetail().setTelephone(rs3.getString(23));
				owner.getRestaurantsdetail().setFacebook(rs3.getString(24));
				owner.getRestaurantsdetail().setLine(rs3.getString(25));
				owner.getRestaurantsdetail().setTwitter(rs3.getString(26));
				owner.getRestaurantsdetail().setWebsite(rs3.getString(27));
				owner.getRestaurantsdetail().getAddress().setStatusapproved(rs3.getString(28));
				owner.getRestaurantsdetail().getAddress().getVectorimages()
						.add(new Images(rs2.getInt(31), rs2.getString(32), rs2.getString(33)));
				owner.getRestaurantsdetail().getAddress().getVillageCategoryID().setVillageID(rs3.getInt(32));
				owner.getRestaurantsdetail().getAddress().getVillageCategoryID().setVillageName(rs3.getString(33));
			}
			rs3.close();

		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmt_travle.close();
				stmt_hotel.close();
				stmt_res.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return villageCategory;

	}

	public Vector<Images> getImgListArticle(Address address) {
		Vector<Images> listimg = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select imageID,imageName,imageDetail,statusImage from image where addressID = ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, address.getAddressID());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Images img = new Images();
				img.setImageID(rs.getInt(1));
				img.setImageName(rs.getString(2));
				img.setImageDetail(rs.getString(3));
				img.setStatusimage(rs.getInt(4));
				listimg.add(img);
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
		return listimg;
	}

	public void removeImagePR(String imageID) {
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "delete  from image where imageID  = ? ;";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัติ
			 */
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, imageID);
			stmt.executeUpdate();
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
				stmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
	}

	public Owner getViewPRBusinessAndTravelDetail(Login login) {
		Owner owner = new Owner();
		Category category = new Category();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stm_travle = null;
		PreparedStatement stmt_hotel = null;
		PreparedStatement stmt_res = null;
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
					+ "traveldetail.twitter,traveldetail.website,address.statusapproved,image.imageID,image.imageName,image.imageDetail,"
					+ "villagecategory.villageID,villagecategory.villageName " + "from traveldetail "
					+ "inner join owner on traveldetail.ownerID = owner.ownerID "
					+ "inner join subcategorytravel on traveldetail.subcategorytravelID = subcategorytravel.subcategorytravelID "
					+ "inner join category on subcategorytravel.categoryID = category.categoryID "
					+ "inner join address on address.addressID = traveldetail.addressID "
					+ "inner join image on image.addressID = address.addressID "
					+ "inner join villagecategory on address.villageID = villagecategory.villageID "
					+ "where owner.OwnerID = ? ;";
			stm_travle = conn.prepareStatement(sql);
			stm_travle.setInt(1, login.getOwner().getOwnerID());
			ResultSet rs = stm_travle.executeQuery();
			while (rs.next() && login.getOwner().getOwnerID() == rs.getInt(6)) {
				owner.getTravledetail().setTraveldetailID(rs.getInt(1));
				owner.getTravledetail().setTraveldetailName(rs.getString(2));
				owner.getTravledetail().setTraveldetailData(rs.getString(3));
				owner.getTravledetail().setTraveldetailTitel(rs.getString(4));
				owner.getTravledetail().setStatisticsvisit(rs.getInt(5));
				owner.setOwnerID(rs.getInt(6));

				category.getVectorsubcategorytravel().add(new SubCategoryTravel(rs.getString(7), rs.getString(8), ""));

				// subCategoryTravel.setSubcategorytravelID(rs.getString(7));
				// subCategoryTravel.setSubcategorytravelName(rs.getString(8));

				category.setCategoryID(rs.getString(9));
				category.setCategoryName(rs.getString(10));

				// Address address = new Address();
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
				owner.getTravledetail().getAddress().setStatusapproved(rs.getString(30));

				owner.getTravledetail().getAddress().getVectorimages()
						.add(new Images(rs.getInt(31), rs.getString(32), rs.getString(33)));
				// Images images = new Images();
				// images.setImageID(rs.getInt(31));
				// images.setImageName(rs.getString(32));
				// images.setImageDetail(rs.getString(33));

				owner.getTravledetail().getAddress().getVillageCategoryID().setVillageID(rs.getInt(34));
				owner.getTravledetail().getAddress().getVillageCategoryID().setVillageName(rs.getString(35));

				// listimages.add(images);
				// owner.getTravledetail().getAddress().setVectorimages(listimages);
				// address.setVillageCategoryID(villageCategory);
				// travelDetail.setAddress(address);
				listtravelDetail.add(owner.getTravledetail());
				listsubCategoryTravel.add(category.getVectorsubcategorytravel().get(0));
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
					+ "hoteldetail.twitter,hoteldetail.website,address.statusapproved,image.imageID,image.imageName,image.imageDetail,"
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

				category.getVectorsubcategoryhotel()
						.add(new SubCategoryHotel(rs2.getString(12), rs2.getString(13), ""));
				// subCategoryHotel.setSubcategoryhotelID(rs2.getString(12));
				// subCategoryHotel.setSubcategoryhotelName(rs2.getString(13));

				category.setCategoryID(rs2.getString(14));
				category.setCategoryName(rs2.getString(15));

				// Address address = new Address();
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
				owner.getHoteldetail().getAddress().setStatusapproved(rs2.getString(35));

				owner.getHoteldetail().getAddress().getVectorimages()
						.add(new Images(rs2.getInt(36), rs2.getString(37), rs2.getString(38)));

				// Images images = new Images();
				// images.setImageID(rs2.getInt(36));
				// images.setImageName(rs2.getString(37));
				// images.setImageDetail(rs2.getString(38));

				owner.getHoteldetail().getAddress().getVillageCategoryID().setVillageID(rs2.getInt(39));
				owner.getHoteldetail().getAddress().getVillageCategoryID().setVillageName(rs2.getString(40));

				// listimages.add(images);
				// address.setVectorimages(listimages);
				// address.setVillageCategoryID(villageCategory);
				// hotelDetail.setAddress(address);
				listhotelDetail.add(owner.getHoteldetail());
				listsubCategoryHotel.add(category.getVectorsubcategoryhotel().get(0));
			}
			subCategoryHotel.setVectorhoteldetail(listhotelDetail);
			category.setVectorsubcategoryhotel(listsubCategoryHotel);
			// owner.setHoteldetail(hotelDetail);
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
					+ "restaurantsdetail.twitter,restaurantsdetail.website,address.statusapproved,image.imageID,image.imageName,image.imageDetail,"
					+ "villagecategory.villageID,villagecategory.villageName from restaurantsdetail "
					+ "inner join owner on restaurantsdetail.ownerID = owner.ownerID "
					+ "inner join address on address.addressID = restaurantsdetail.addressID "
					+ " inner join subcategoryrestaurants on restaurantsdetail.subcategoryrestaurantsID = subcategoryrestaurants.subcategoryrestaurantsID "
					+ "inner join category on subcategoryrestaurants.categoryID = category.categoryID "
					+ "inner join villagecategory on address.villageID = villagecategory.villageID "
					+ "inner join image on image.addressID = address.addressID where owner.OwnerID = ? ;";
			stmt_res = conn.prepareStatement(sql3);
			stmt_res.setInt(1, login.getOwner().getOwnerID());
			ResultSet rs3 = stmt_res.executeQuery();
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
				// subCategoryRestaurants.setSubcategoryrestaurantID(rs3.getString(10));
				// subCategoryRestaurants.setSubcategoryrestaurantName(rs3.getString(11));

				category.setCategoryID(rs3.getString(12));
				category.setCategoryName(rs3.getString(13));

				// Address address = new Address();
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
				owner.getRestaurantsdetail().getAddress().setStatusapproved(rs3.getString(33));

				owner.getRestaurantsdetail().getAddress().getVectorimages()
						.add(new Images(rs3.getInt(34), rs3.getString(35), rs3.getString(36)));

				// Images images = new Images();
				// images.setImageID(rs3.getInt(34));
				// images.setImageName(rs3.getString(35));
				// images.setImageDetail(rs3.getString(36));

				owner.getRestaurantsdetail().getAddress().getVillageCategoryID().setVillageID(rs3.getInt(37));
				owner.getRestaurantsdetail().getAddress().getVillageCategoryID().setVillageName(rs3.getString(38));

				// listimages.add(images);
				// address.setVectorimages(listimages);
				// address.setVillageCategoryID(villageCategory);
				// restaurantsDetails.setAddress(address);
				listrestaurantsDetails.add(owner.getRestaurantsdetail());
				listsubCategoryRestaurants.add(category.getVectorsubcategoryrestaurants().get(0));

			}
			subCategoryRestaurants.setVectorrestaurantsdetail(listrestaurantsDetails);
			category.setVectorsubcategoryrestaurants(listsubCategoryRestaurants);
			// owner.setRestaurantsdetail(restaurantsDetails);

			rs3.close();

		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stm_travle.close();
				stmt_hotel.close();
				stmt_res.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return owner;

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
}
