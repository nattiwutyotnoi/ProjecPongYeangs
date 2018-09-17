package com.pongyeang.viewhotelsandlodgingdetail;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class ViewHotelsandLodgingDetailManager {

	public HotelDetail getViewHotelsandLodgingDetail(String hoteldetailID) {
		HotelDetail hotelDetail = new HotelDetail();
		Vector<Images> listimges = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select hoteldetail.hoteldetailID" + ",hoteldetail.hoteldetailName"
				+ ",hoteldetail.hoteldetailData" + ",hoteldetail.hoteldetailTitle" + ",hoteldetail.opentime"
				+ ",hoteldetail.checkincheckout" + ",hoteldetail.roomofnumber" + ",hoteldetail.hotelprice"
				+ ",hoteldetail.amenities" + ",hoteldetail.statisticsvisit" + ",hoteldetail.ownerID"
				+ ",address.addressID" + ",address.addressno" + ",address.villageno" + ",address.alley"
				+ ",address.street" + ",address.subdistrict" + ",address.district" + ",address.province"
				+ ",address.zipcode" + ",address.mapimage " + ",address.mapimagedetail"
				+ ",date_format(address.datecreate,'%d/%m/%Y')" + ",address.latitude" + ",address.longtitude"
				+ ",hoteldetail.telephone" + ",hoteldetail.facebook" + ",hoteldetail.line" + ",hoteldetail.twitter"
				+ ",hoteldetail.website,address.statusapproved,address.villageID" + ",image.imageID" + ",image.imageName"
				+ ",image.imageDetail from hoteldetail "
				+ "inner join address on address.addressID = hoteldetail.addressID "
				+ "inner join image on image.addressID = address.addressID where hoteldetail.hoteldetailID= ? ";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, hoteldetailID);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
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
				
				hotelDetail.setOwnerID(this.getOwner(rs.getInt(11)));
				hotelDetail.getAddress().setAddressID(rs.getInt(12));
				hotelDetail.getAddress().setAddressno(rs.getString(13));
				hotelDetail.getAddress().setVillageno(rs.getString(14));
				hotelDetail.getAddress().setAlley(rs.getString(15));
				hotelDetail.getAddress().setStreet(rs.getString(16));
				hotelDetail.getAddress().setSubdistrict(rs.getString(17));
				hotelDetail.getAddress().setDistrict(rs.getString(18));
				hotelDetail.getAddress().setProvince(rs.getString(19));
				hotelDetail.getAddress().setZipcode(rs.getString(20));
				hotelDetail.getAddress().setMapimage(rs.getString(21));
				hotelDetail.getAddress().setMapimagedetail(rs.getString(22));
				hotelDetail.getAddress().setDatecreate(rs.getString(23));
				hotelDetail.getAddress().setLatitude(rs.getString(24));
				hotelDetail.getAddress().setLongtitude(rs.getString(25));
				
				hotelDetail.setTelephone(rs.getString(26));
				hotelDetail.setFacebook(rs.getString(27));
				hotelDetail.setLine(rs.getString(28));
				hotelDetail.setTwitter(rs.getString(29));
				hotelDetail.setWebsite(rs.getString(30));
				hotelDetail.getAddress().setStatusapproved(rs.getString(31));
				hotelDetail.getAddress().setVillageCategoryID(this.getVaillage(rs.getInt(32)));

				hotelDetail.getAddress().getVectorimages().add(new Images(rs.getInt(33),rs.getString(34),rs.getString(35)));
//				imges.setImageID(rs.getInt(33));
//				imges.setImageName(rs.getString(34));
//				imges.setImageDetail(rs.getString(35));
//				listimges.add(imges);
				
			}
			hotelDetail.setVecotrarticle(this.getListArticle(hotelDetail.getHoteldetailID()));
//			hotelDetail.getAddress().setVectorimages(listimges);
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
		return hotelDetail;
	}

	public Vector<Article> getListArticle(int hotelDetailID) {
		Vector<Article> listArticle = new Vector<Article>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "Select SQL_CALC_FOUND_ROWS article.articleID,article.articleName,article.articleDetail,article.articleTitel,article.contactus,date_format(article.datecreate,'%d/%m/%Y'),article.amenities "
				+ "from hoteldetail inner join article on article.hoteldetailID=hoteldetail.hoteldetailID where hoteldetail.hoteldetailID= ? limit 3 ; ";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, hotelDetailID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				article.setArticleID(rs.getInt(1));
				article.setArticleName(rs.getString(2));
				article.setArticleDetail(rs.getString(3));
				article.setArticleTitel(rs.getString(4));
				article.setCountactus(rs.getString(5));
				article.setDatecreate(rs.getString(6));
				article.setAmenities(rs.getString(7));
				article.setVectorimages(this.getImgListArticle(article.getArticleID()));
				listArticle.add(article);
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
		return listArticle;
	}

	public Vector<Images> getImgListArticle(int articleID) {
		Vector<Images> listimges = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select imageID,imageName,imageDetail from image where articleID= ? ";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, articleID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Images imges = new Images();
				imges.setImageID(rs.getInt(1));
				imges.setImageName(rs.getString(2));
				imges.setImageDetail(rs.getString(3));
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

	public VillageCategory getVaillage(int villageID) {
		VillageCategory villagecategory = new VillageCategory();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "Select villageID,villageName,villageDetail from villagecategory where villageID= ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, villageID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
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

	public Owner getOwner(int ownerID) {
		Owner ownerOne = new Owner();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "Select ownerID,ownerFirstname,ownerLastname,idcard, "
				+ "birthday,phone,email,statusapprove from owner where ownerID= ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ownerID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				ownerOne.setOwnerID(rs.getInt(1));
				ownerOne.setOwnerFirstname(rs.getString(2));
				ownerOne.setOwnerzLastname(rs.getString(3));
				ownerOne.setIdcard(rs.getString(4));
				ownerOne.setBithday(rs.getString(5));
				ownerOne.setPhone(rs.getString(6));
				ownerOne.setEmail(rs.getString(7));
				ownerOne.setStatusapprove(rs.getInt(8));
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
		return ownerOne;
	}

	public void isUpdate(int hotelDetailID, int hotelDetailstatisticsvisit) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "UPDATE hoteldetail set statisticsvisit = ?  where hoteldetailID= ? ;";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัติ
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, hotelDetailID);
			cstmt.setInt(2, hotelDetailstatisticsvisit + 1);
			cstmt.executeUpdate();
			System.out.println(hotelDetailstatisticsvisit);
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
}
