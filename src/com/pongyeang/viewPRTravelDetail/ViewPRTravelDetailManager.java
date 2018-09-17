package com.pongyeang.viewPRTravelDetail;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class ViewPRTravelDetailManager {

	public TravelDetail getViewPRTravelDetail(String travelID) {
		TravelDetail td = new TravelDetail();
		Vector<Images> listimg = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select  traveldetail.traveldetailID,traveldetail.traveldetailName,traveldetail.traveldetailData"
				+ ",traveldetail.traveldetailTitle,traveldetail.statisticsvisit,traveldetail.ownerID,address.addressID,address.addressno"
				+ ",address.villageno,address.alley,address.street,address.subdistrict,address.district"
				+ ",address.province,address.zipcode,address.mapimage,address.mapimagedetail,date_format(address.datecreate,'%d/%m/%Y'),address.latitude"
				+ ",address.longtitude,traveldetail.telephone,traveldetail.facebook,traveldetail.line"
				+ ",traveldetail.twitter,traveldetail.website,address.statusapproved,address.villageID,image.imageID,image.imageName,image.imageDetail from traveldetail "
				+ "inner join address on address.addressID = traveldetail.addressID  "
				+ "inner join image on image.addressID = address.addressID where traveldetail.traveldetailID= ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, travelID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				td.setTraveldetailID(rs.getInt(1));
				td.setTraveldetailName(rs.getString(2));
				td.setTraveldetailData(rs.getString(3));
				td.setTraveldetailTitel(rs.getString(4));
				td.setStatisticsvisit(rs.getInt(5));
				td.setOwnerID(this.getOwner(rs.getInt(6)));
				td.getAddress().setAddressID(rs.getInt(7));
				td.getAddress().setAddressno(rs.getString(8));
				td.getAddress().setVillageno(rs.getString(9));
				td.getAddress().setAlley(rs.getString(10));
				td.getAddress().setStreet(rs.getString(11));
				td.getAddress().setSubdistrict(rs.getString(12));
				td.getAddress().setDistrict(rs.getString(13));
				td.getAddress().setProvince(rs.getString(14));
				td.getAddress().setZipcode(rs.getString(15));
				td.getAddress().setMapimage(rs.getString(16));
				td.getAddress().setMapimagedetail(rs.getString(17));
				td.getAddress().setDatecreate(rs.getString(18));
				td.getAddress().setLatitude(rs.getString(19));
				td.getAddress().setLongtitude(rs.getString(20));
				
				td.setTelephone(rs.getString(21));
				td.setFacebook(rs.getString(22));
				td.setLine(rs.getString(23));
				td.setTwitter(rs.getString(24));
				td.setWebsite(rs.getString(25));
				
				td.getAddress().setStatusapproved(rs.getString(26));
				td.getAddress().setVillageCategoryID(this.getVaillage(rs.getInt(27)));

				td.getAddress().getVectorimages().add(new Images(rs.getInt(28),rs.getString(29),rs.getString(30)));
//				img.setImageID(rs.getInt(28));
//				img.setImageName(rs.getString(29));
//				img.setImageDetail(rs.getString(30));
//				listimg.add(img);
			}

			td.setVecotrarticle(this.getListArticle(td.getTraveldetailID()));
//td.getAddress().setVectorimages(listimg);
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
		return td;
	}

	public Vector<Article> getListArticle(int a) {
		Vector<Article> listA = new Vector<Article>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "Select SQL_CALC_FOUND_ROWS article.articleID,article.articleName,article.articleDetail,article.articleTitel,article.contactus,date_format(article.datecreate,'%d/%m/%Y'),article.amenities "
				+ "from traveldetail inner join article on article.traveldetailID=traveldetail.traveldetailID where traveldetail.traveldetailID= ? limit 3 ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, a);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Article ar = new Article();
				ar.setArticleID(rs.getInt(1));
				ar.setArticleName(rs.getString(2));
				ar.setArticleDetail(rs.getString(3));
				ar.setArticleTitel(rs.getString(4));
				ar.setCountactus(rs.getString(5));
				ar.setDatecreate(rs.getString(6));
				ar.setAmenities(rs.getString(7));
				ar.setVectorimages(this.getImgListArticle(ar.getArticleID()));
				listA.add(ar);
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
		return listA;
	}

	public Vector<Images> getImgListArticle(int articelID) {
		Vector<Images> listimg = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select imageID,imageName,imageDetail from image where articleID= ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, articelID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Images img = new Images();
				img.setImageID(rs.getInt(1));
				img.setImageName(rs.getString(2));
				img.setImageDetail(rs.getString(3));
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

	public void isUpdate(int id, int count) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "UPDATE traveldetail set statisticsvisit = ?  where traveldetailID= ? ;";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัติ
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, count + 1);
			cstmt.setInt(2, id);
			cstmt.executeUpdate();
			System.out.println(count);
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
