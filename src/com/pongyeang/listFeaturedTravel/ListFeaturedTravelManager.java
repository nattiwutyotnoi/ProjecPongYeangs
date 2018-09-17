package com.pongyeang.listFeaturedTravel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class ListFeaturedTravelManager {
	private int noOfRecords;

	public Category getListFeaturedTravel(int categoryID, int offset, int noOfRecords) {
		Category category = new Category();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select categoryID,categoryName from category where categoryID= ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, categoryID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				category.setCategoryID(rs.getString(1));
				category.setCategoryName(rs.getString(2));
				if (category.getCategoryName().equalsIgnoreCase("ท่องเที่ยว")) {
					category.setVectorsubcategorytravel(
							this.getSubFeaturedTravel(category.getCategoryID(), offset, noOfRecords));
				} else if (category.getCategoryName().equalsIgnoreCase("ที่พัก")) {
					category.setVectorsubcategoryhotel(
							this.getSubFeaturedHotel(category.getCategoryID(), offset, noOfRecords));
				} else if (category.getCategoryName().equalsIgnoreCase("ร้านค้าบริการ")) {
					category.setVectorsubcategoryrestaurants(
							this.getSubFeaturedRastataurants(category.getCategoryID(), offset, noOfRecords));
				}
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

	public Vector<SubCategoryTravel> getSubFeaturedTravel(String catid, int offset, int noOfRecords) {
		Vector<SubCategoryTravel> vs = new Vector<SubCategoryTravel>();
		SubCategoryTravel sub = new SubCategoryTravel();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select subcategorytravelID,subcategorytravelName from subcategorytravel where categoryID= ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, catid);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				sub.setSubcategorytravelID(rs.getString(1));
				sub.setSubcategorytravelName(rs.getString(2));
				sub.setVectortraveldetail(this.getDetailFeaturedTravel(offset, noOfRecords));
				vs.add(sub);
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
		return vs;
	}

	public Vector<SubCategoryHotel> getSubFeaturedHotel(String catid, int offset, int noOfRecords) {
		Vector<SubCategoryHotel> vh = new Vector<SubCategoryHotel>();
		SubCategoryHotel sub = new SubCategoryHotel();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select subcategoryhotelID,subcategoryhotelName from subcategoryhotel where categoryID= ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, catid);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				sub.setSubcategoryhotelID(rs.getString(1));
				sub.setSubcategoryhotelName(rs.getString(2));
				sub.setVectorhoteldetail(this.getDetailFeaturedHotel(offset, noOfRecords));
				vh.add(sub);
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
		return vh;
	}

	public Vector<SubCategoryRestaurants> getSubFeaturedRastataurants(String catid, int offset, int noOfRecords) {
		Vector<SubCategoryRestaurants> vr = new Vector<SubCategoryRestaurants>();
		SubCategoryRestaurants subCategoryRestaurants = new SubCategoryRestaurants();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select subcategoryrestaurantsID,subcategoryrestaurantsName from subcategoryrestaurants where categoryID= ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, catid);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				subCategoryRestaurants.setSubcategoryrestaurantID(rs.getString(1));
				subCategoryRestaurants.setSubcategoryrestaurantName(rs.getString(2));
				subCategoryRestaurants
						.setVectorrestaurantsdetail(this.getDetailFeaturedRestataurant(offset, noOfRecords));
				vr.add(subCategoryRestaurants);
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
		return vr;
	}

	public Vector<TravelDetail> getDetailFeaturedTravel(int offset, int noOfRecords) {
		Vector<TravelDetail> vtravel = new Vector<TravelDetail>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select SQL_CALC_FOUND_ROWS " + "traveldetail.traveldetailID," + "traveldetail.traveldetailName,"
				+ "traveldetail.traveldetailData," + "traveldetail.traveldetailTitle," + "traveldetail.statisticsvisit,"
				+ "address.addressID,address.datecreate "
				+ "from traveldetail inner join address on address.addressID = traveldetail.addressID "
				+ "where address.statusapproved='yes' order by  traveldetail.statisticsvisit desc  limit ? , ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, offset);
			stmt.setInt(2, noOfRecords);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				TravelDetail travelDetail = new TravelDetail();
				travelDetail.setTraveldetailID(rs.getInt(1));
				travelDetail.setTraveldetailName(rs.getString(2));
				travelDetail.setTraveldetailData(rs.getString(3));
				travelDetail.setTraveldetailTitel(rs.getString(4));
				travelDetail.setStatisticsvisit(rs.getInt(5));

				travelDetail.getAddress().setAddressID(rs.getInt(6));
				travelDetail.getAddress().setDatecreate(rs.getString(7));
				travelDetail.getAddress().setVectorimages(this.getImgListOne(travelDetail.getAddress().getAddressID()));

				vtravel.add(travelDetail);
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
		return vtravel;
	}

	public Vector<HotelDetail> getDetailFeaturedHotel(int offset, int noOfRecords) {
		Vector<HotelDetail> vhotel = new Vector<HotelDetail>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select SQL_CALC_FOUND_ROWS hoteldetail.hoteldetailID,hoteldetail.hoteldetailName,hoteldetail.hoteldetailData"
				+ ",hoteldetail.hoteldetailTitle,hoteldetail.opentime,hoteldetail.checkincheckout"
				+ ",hoteldetail.roomofnumber,hoteldetail.hotelprice,hoteldetail.amenities"
				+ ",hoteldetail.statisticsvisit,address.addressID,address.datecreate "
				+ "from hoteldetail inner join address on address.addressID = hoteldetail.addressID "
				+ "where address.statusapproved='yes' order by  hoteldetail.statisticsvisit desc limit ? , ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, offset);
			stmt.setInt(2, noOfRecords);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				HotelDetail hotelDetail = new HotelDetail();
				hotelDetail.setHoteldetailID(rs.getInt(1));
				hotelDetail.setHoteldetailName(rs.getString(2));
				hotelDetail.setHoteldetailData(rs.getString(3));
				hotelDetail.setHoteldetailTitel(rs.getString(4));
				hotelDetail.setOpentime(rs.getString(5));
				hotelDetail.setCheckincheckout(rs.getString(6));
				hotelDetail.setRoomofnumber(rs.getString(7));
				hotelDetail.setHotelprice(rs.getString(8));
				hotelDetail.setAmenities(rs.getString(9));
				hotelDetail.setStatisticsvisit(rs.getInt(10));

				hotelDetail.getAddress().setAddressID(rs.getInt(11));
				hotelDetail.getAddress().setDatecreate(rs.getString(12));
				hotelDetail.getAddress().setVectorimages(this.getImgListOne(hotelDetail.getAddress().getAddressID()));

				vhotel.add(hotelDetail);
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
		return vhotel;
	}

	public Vector<RestaurantsDetail> getDetailFeaturedRestataurant(int offset, int noOfRecords) {
		Vector<RestaurantsDetail> vrestaurants = new Vector<RestaurantsDetail>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select restaurantsdetail.restaurantsdetailID,restaurantsdetail.restaurantsdetailName,"
				+ "restaurantsdetail.restaurantsdetailData,restaurantsdetail.restaurantsdetailTitle,"
				+ "restaurantsdetail.opentime,restaurantsdetail.pricerange,restaurantsdetail.amenities,"
				+ "restaurantsdetail.statisticsvisit,address.addressID,address.datecreate "
				+ "from restaurantsdetail inner join address on address.addressID = restaurantsdetail.addressID "
				+ "where address.statusapproved='yes' order by  restaurantsdetail.statisticsvisit desc limit ? , ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, offset);
			stmt.setInt(2, noOfRecords);
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
				restaurantsDetail.getAddress().setVectorimages(this.getImgListOne(restaurantsDetail.getAddress().getAddressID()));
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

	public Vector<Images> getImgListOne(int addressID) {
		Vector<Images> listimges = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select address.addressID,image.imageID,image.imageName," + "image.imageDetail "
				+ "from address inner join image on image.addressID = address.addressID "
				+ "where address.addressID= ? ;";
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
