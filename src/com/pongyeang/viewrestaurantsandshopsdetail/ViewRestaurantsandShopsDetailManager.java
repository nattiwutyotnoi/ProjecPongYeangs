package com.pongyeang.viewrestaurantsandshopsdetail;

import java.sql.*;
import java.util.Vector;
import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class ViewRestaurantsandShopsDetailManager {

	public RestaurantsDetail getViewRastaurantsandShopsDetail(String RastataurantsSubID) {
		RestaurantsDetail restaurantsDetail = new RestaurantsDetail();
		Vector<Images> listimges = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select  restaurantsdetail.restaurantsdetailID,restaurantsdetail.restaurantsdetailName,"
				+ "restaurantsdetail.restaurantsdetailData,restaurantsdetail.restaurantsdetailTitle,"
				+ "restaurantsdetail.opentime,restaurantsdetail.pricerange,restaurantsdetail.amenities,"
				+ "restaurantsdetail.statisticsvisit,restaurantsdetail.ownerID,"
				+ "address.addressID,address.addressno,address.villageno,address.alley,"
				+ "address.street,address.subdistrict,address.district,address.province,"
				+ "address.zipcode,address.mapimage,address.mapimagedetail,date_format(address.datecreate,'%d/%m/%Y'),"
				+ "address.latitude,address.longtitude,restaurantsdetail.telephone,restaurantsdetail.facebook,"
				+ "restaurantsdetail.line,restaurantsdetail.twitter,restaurantsdetail.website,address.statusapproved,address.villageID,image.imageID,image.imageName,image.imageDetail "
				+ "from restaurantsdetail "
				+ "inner join address on address.addressID = restaurantsdetail.addressID "
				+ "inner join image on image.addressID = address.addressID where restaurantsdetail.restaurantsdetailID= ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, RastataurantsSubID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				restaurantsDetail.setRestaurantsdetailID(rs.getInt(1));
				restaurantsDetail.setRestaurantsdetailName(rs.getString(2));
				restaurantsDetail.setRestaurantsdetailData(rs.getString(3));
				restaurantsDetail.setRestaurantsdetailTitel(rs.getString(4));
				restaurantsDetail.setOpentime(rs.getString(5));
				restaurantsDetail.setPricerange(rs.getString(6));
				restaurantsDetail.setAmenities(rs.getString(7));
				restaurantsDetail.setStatisticsvisit(rs.getInt(8));
				restaurantsDetail.setOwnerID(this.getOwner(rs.getInt(9)));
				restaurantsDetail.getAddress().setAddressID(rs.getInt(10));
				restaurantsDetail.getAddress().setAddressno(rs.getString(11));
				restaurantsDetail.getAddress().setVillageno(rs.getString(12));
				restaurantsDetail.getAddress().setAlley(rs.getString(13));
				restaurantsDetail.getAddress().setStreet(rs.getString(14));
				restaurantsDetail.getAddress().setSubdistrict(rs.getString(15));
				restaurantsDetail.getAddress().setDistrict(rs.getString(16));
				restaurantsDetail.getAddress().setProvince(rs.getString(17));
				restaurantsDetail.getAddress().setZipcode(rs.getString(18));
				restaurantsDetail.getAddress().setMapimage(rs.getString(19));
				restaurantsDetail.getAddress().setMapimagedetail(rs.getString(20));
				restaurantsDetail.getAddress().setDatecreate(rs.getString(21));
				restaurantsDetail.getAddress().setLatitude(rs.getString(22));
				restaurantsDetail.getAddress().setLongtitude(rs.getString(23));
				
				restaurantsDetail.setTelephone(rs.getString(24));
				restaurantsDetail.setFacebook(rs.getString(25));
				restaurantsDetail.setLine(rs.getString(26));
				restaurantsDetail.setTwitter(rs.getString(27));
				restaurantsDetail.setWebsite(rs.getString(28));
				
				restaurantsDetail.getAddress().setStatusapproved(rs.getString(29));
				restaurantsDetail.getAddress().setVillageCategoryID(this.getVaillage(rs.getInt(30)));

				restaurantsDetail.getAddress().getVectorimages().add(new Images(rs.getInt(31),rs.getString(32),rs.getString(33)));
//				imges.setImageID(rs.getInt(31));
//				imges.setImageName(rs.getString(32));
//				imges.setImageDetail(rs.getString(33));
//				listimges.add(imges);
			}
			restaurantsDetail.setVecotrarticle(this.getListArticle(restaurantsDetail.getRestaurantsdetailID()));
//			restaurantsDetail.getAddress().setVectorimages(listimges);
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

		return restaurantsDetail;
	}

	public Vector<Article> getListArticle(int restaurantsDetailID) {
		Vector<Article> listArticle = new Vector<Article>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select SQL_CALC_FOUND_ROWS article.articleID,article.articleName,article.articleDetail,article.articleTitel,article.contactus,date_format(article.datecreate,'%d/%m/%Y'),article.amenities "
				+ "from restaurantsdetail inner join article on article.restaurantsdetailID=restaurantsdetail.restaurantsdetailID where restaurantsdetail.restaurantsdetailID= ? limit 3;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, restaurantsDetailID);
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
		String sql = "select imageID,imageName,imageDetail from image where articleID= ? ;";
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
		String sql = "Select owner.ownerID, owner.ownerFirstname, owner.ownerLastname, owner.idcard, "
				+ "owner.birthday,owner.phone, owner.email, owner.statusapprove from owner where owner.ownerID= ? ;";
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

	public void isUpdate(int restaurantsDetailID, int restaurantsDetailStatisticsvisit) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "UPDATE restaurantsdetail set statisticsvisit = ? where restaurantsdetailID= ? ;";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัติ
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, restaurantsDetailStatisticsvisit + 1);
			cstmt.setInt(2, restaurantsDetailID);
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
}
