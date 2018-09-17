package com.pongyeang.listHotelsandSubCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class ListHotelsandSubCategoryManager {
	private int noOfRecords;

	public SubCategoryHotel getistHotelsandSubCategory(String HotelSubID, int offset, int noOfRecords) {
		SubCategoryHotel subCategoryHotel = new SubCategoryHotel();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select subcategoryhotelID,subcategoryhotelName from subcategoryhotel where subcategoryhotelID = ? ;";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, HotelSubID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				subCategoryHotel.setSubcategoryhotelID(rs.getString(1));
				subCategoryHotel.setSubcategoryhotelName(rs.getString(2));
				subCategoryHotel.setVectorhoteldetail(this.getDetailFeaturedHotel(HotelSubID, offset, noOfRecords));
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
		return subCategoryHotel;
	}

	public Vector<HotelDetail> getDetailFeaturedHotel(String HotelSubID, int offset, int noOfRecords) {
		Vector<HotelDetail> vhotel = new Vector<HotelDetail>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select SQL_CALC_FOUND_ROWS hoteldetail.hoteldetailID,hoteldetail.hoteldetailName,hoteldetail.hoteldetailData"
				+ ",hoteldetail.hoteldetailTitle,hoteldetail.opentime,hoteldetail.checkincheckout"
				+ ",hoteldetail.roomofnumber,hoteldetail.hotelprice,hoteldetail.amenities"
				+ ",hoteldetail.statisticsvisit,address.addressID,address.datecreate,address.statusapproved from hoteldetail inner join address on address.addressID = hoteldetail.addressID "
				+ "where hoteldetail.subcategoryhotelID = ? "
				+ "and address.statusapproved='yes' order by  hoteldetail.statisticsvisit desc limit ? , ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, HotelSubID);
			stmt.setInt(2, offset);
			stmt.setInt(3, noOfRecords);
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
				hotelDetail.getAddress().setStatusapproved(rs.getString(13));
				hotelDetail.getAddress().setVectorimages(this.getImgListHotel(hotelDetail.getAddress().getAddressID()));

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

	public Vector<Images> getImgListHotel(int adddressID) {
		Vector<Images> listimg = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select address.addressID,image.imageID," + "image.imageName,image.imageDetail "
				+ "from address inner join image on image.addressID = address.addressID where address.addressID= ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, adddressID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Images img = new Images();
				img.setImageID(rs.getInt(2));
				img.setImageName(rs.getString(3));
				img.setImageDetail(rs.getString(4));
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

	public int getNoOfRecords() {
		return noOfRecords;
	}
}
