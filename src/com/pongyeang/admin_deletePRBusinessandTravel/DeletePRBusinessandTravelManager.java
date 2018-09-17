package com.pongyeang.admin_deletePRBusinessandTravel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;;

public class DeletePRBusinessandTravelManager {
	/**************************************
	 * Start Travel
	 ***************************************************/
	public void removePRBusinessandTravel(String traveldetailID, String addressID) {
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmttravel = null;
		PreparedStatement stmttravel_image = null;
		PreparedStatement stmttravel_article = null;
		PreparedStatement stmttravel_address = null;
		PreparedStatement stmttravel_travelldetail = null;

		String sqltravel = "delete  from  image where image.addressID  = ? ;";
		String sqltravel_image = "delete from image where image.articleID  = ? ;";
		String sqltravel_article = "delete from article where article.traveldetailID  = ? ;";		
		String sqltravel_travelldetail = "delete  from  traveldetail where traveldetail.traveldetailID  = ? ;";
		String sqltravel_address = "delete  from  address where address.addressID  = ? ;";
		
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัต
			 */
			conn.setAutoCommit(false);
			stmttravel = conn.prepareStatement(sqltravel);
			stmttravel.setString(1, addressID);
			stmttravel.executeUpdate();

			if (this.getListArticle(traveldetailID) != null) {
				for (int i = 0; i < this.getListArticle(traveldetailID).size(); i++) {
					stmttravel_image = conn.prepareStatement(sqltravel_image);
					stmttravel_image.setInt(1, this.getListArticle(traveldetailID).get(i).getArticleID());
					stmttravel_image.executeUpdate();
					stmttravel_image.close();
				}
				stmttravel_article = conn.prepareStatement(sqltravel_article);
				stmttravel_article.setString(1, traveldetailID);
				stmttravel_article.executeUpdate();
				stmttravel_article.close();
			}
			
			stmttravel_travelldetail = conn.prepareStatement(sqltravel_travelldetail);
			stmttravel_travelldetail.setString(1, traveldetailID);
			stmttravel_travelldetail.executeUpdate();
			stmttravel_travelldetail.close();

			stmttravel_address = conn.prepareStatement(sqltravel_address);
			stmttravel_address.setString(1, addressID);
			stmttravel_address.executeUpdate();
			stmttravel_address.close();
			
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
				stmttravel.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
	}

	public Vector<Article> getListArticle(String traveldetailID) {
		Vector<Article> listArticle = new Vector<Article>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmtarticle = null;
		String sql = "select SQL_CALC_FOUND_ROWS articleID,articleName,articleDetail,articleTitel,"
				+ "contactus,date_format(article.datecreate,'%d/%m/%Y'),statisticsvisit,"
				+ "amenities from article where article.traveldetailID= ? ;";
		try {
			stmtarticle = conn.prepareStatement(sql);
			stmtarticle.setString(1, traveldetailID);
			ResultSet rs = stmtarticle.executeQuery();
			while (rs.next()) {
				Article ar = new Article();
				ar.setArticleID(rs.getInt(1));
				ar.setArticleName(rs.getString(2));
				ar.setArticleDetail(rs.getString(3));
				ar.setArticleTitel(rs.getString(4));
				ar.setCountactus(rs.getString(5));
				ar.setDatecreate(rs.getString(6));
				ar.setStatisticsvisit(rs.getInt(7));
				ar.setAmenities(rs.getString(8));
				listArticle.add(ar);
			}
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmtarticle.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return listArticle;
	}

	/**************************************
	 * End Travel
	 ***************************************************/
	/**************************************
	 * Start Hotel
	 ***************************************************/
	public void removePRBusinessandHotel(String hoteldetailID, String addressID) {
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmthotel_addressimage = null;
		PreparedStatement stmthotel_articleimage = null;
		PreparedStatement stmthotel_article = null;
		PreparedStatement stmthotel_address = null;
		PreparedStatement stmthotel_hoteldetail = null;

		String sqlhotel_addressimage = "delete  from  image where image.addressID  = ? ;";
		String sqlhotel_articleimage = "delete from image where image.articleID  = ? ;";
		String sqlhotel_article = "delete from article where article.hoteldetailID  = ? ;";
		String sqlhotel_hoteldetail = "delete from hoteldetail where hoteldetail.hoteldetailID  = ? ;";
		String sqlhotel_address = "delete  from  address where address.addressID  = ? ;";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัต
			 */
			conn.setAutoCommit(false);

			stmthotel_addressimage = conn.prepareStatement(sqlhotel_addressimage);
			stmthotel_addressimage.setString(1, addressID);
			stmthotel_addressimage.executeUpdate();

			if (this.getListArticle(hoteldetailID) != null) {
				for (int i = 0; i < this.getListArticle(hoteldetailID).size(); i++) {
					stmthotel_articleimage = conn.prepareStatement(sqlhotel_articleimage);
					stmthotel_articleimage.setInt(1, this.getListArticleHotel(hoteldetailID).get(i).getArticleID());
					stmthotel_articleimage.executeUpdate();
					stmthotel_articleimage.close();
				}
				stmthotel_article = conn.prepareStatement(sqlhotel_article);
				stmthotel_article.setString(1, hoteldetailID);
				stmthotel_article.executeUpdate();
				stmthotel_article.close();
			}
			
			stmthotel_hoteldetail = conn.prepareStatement(sqlhotel_hoteldetail);
			stmthotel_hoteldetail.setString(1, hoteldetailID);
			stmthotel_hoteldetail.executeUpdate();
			stmthotel_hoteldetail.close();
			
			stmthotel_address = conn.prepareStatement(sqlhotel_address);
			stmthotel_address.setString(1, addressID);
			stmthotel_address.executeUpdate();
			stmthotel_address.close();

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
				stmthotel_addressimage.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}

	}

	public Vector<Article> getListArticleHotel(String hoteldetailID) {
		Vector<Article> listArticle = new Vector<Article>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmtarticle = null;
		String sql = "select SQL_CALC_FOUND_ROWS articleID,articleName,articleDetail,articleTitel,"
				+ "contactus,date_format(article.datecreate,'%d/%m/%Y'),"
				+ "statisticsvisit,amenities from article where article.hoteldetailID= ? ;";
		try {
			stmtarticle = conn.prepareStatement(sql);
			stmtarticle.setString(1, hoteldetailID);
			ResultSet rs = stmtarticle.executeQuery();
			while (rs.next()) {
				Article ar = new Article();
				ar.setArticleID(rs.getInt(1));
				ar.setArticleName(rs.getString(2));
				ar.setArticleDetail(rs.getString(3));
				ar.setArticleTitel(rs.getString(4));
				ar.setCountactus(rs.getString(5));
				ar.setDatecreate(rs.getString(6));
				ar.setStatisticsvisit(rs.getInt(7));
				ar.setAmenities(rs.getString(8));
				listArticle.add(ar);
			}
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmtarticle.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return listArticle;
	}

	/**************************************
	 * End Hotel
	 ***************************************************/
	/**************************************
	 * Start Restaurants
	 ***************************************************/
	public void removePRBusinessandRestaurants(String restaurantsdetailID, String addressId) {
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmtrestaurants = null;
		PreparedStatement stmtrestaurants_image = null;
		PreparedStatement stmtrestaurants_article = null;
		PreparedStatement stmtrestaurants_address = null;
		PreparedStatement stmtrestaurants_restaurantsdetail = null;

		String sqlrestaurants = "delete  from  image where image.addressID  = ? ;";
		String sqlrestaurantsl_image = "delete from image where image.articleID  =? ;";
		String sqlrestaurants_article = "delete from article where article.restaurantsdetailID  = ? ;";
		String sqlrestaurants_restaurantsdetail = "delete  from restaurantsdetail where restaurantsdetail.restaurantsdetailID  = ? ;";
		String sqlrestaurants_address = "delete  from  address where address.addressID  = ? ;";
		
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัต
			 */
			conn.setAutoCommit(false);
			stmtrestaurants = conn.prepareStatement(sqlrestaurants);
			stmtrestaurants.setString(1, addressId);
			stmtrestaurants.executeUpdate();

			if (this.getListArticleRestaurants(restaurantsdetailID) != null) {
				for (int i = 0; i < this.getListArticleRestaurants(restaurantsdetailID).size(); i++) {
					stmtrestaurants_image = conn.prepareStatement(sqlrestaurantsl_image);
					stmtrestaurants_image.setInt(1,
							this.getListArticleRestaurants(restaurantsdetailID).get(i).getArticleID());
					stmtrestaurants_image.executeUpdate();
					stmtrestaurants_image.close();
				}
				stmtrestaurants_article = conn.prepareStatement(sqlrestaurants_article);
				stmtrestaurants_article.setString(1, restaurantsdetailID);
				stmtrestaurants_article.executeUpdate();
				stmtrestaurants_article.close();
			}
		

			stmtrestaurants_restaurantsdetail = conn.prepareStatement(sqlrestaurants_restaurantsdetail);
			stmtrestaurants_restaurantsdetail.setString(1, restaurantsdetailID);
			stmtrestaurants_restaurantsdetail.executeUpdate();
			stmtrestaurants_restaurantsdetail.close();

			stmtrestaurants_address = conn.prepareStatement(sqlrestaurants_address);
			stmtrestaurants_address.setString(1, addressId);
			stmtrestaurants_address.executeUpdate();
			stmtrestaurants_address.close();
			
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
				stmtrestaurants.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
	}

	public Vector<Article> getListArticleRestaurants(String restaurantsdetailID) {
		Vector<Article> listArtile = new Vector<Article>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmtarticle = null;

		String sql = "select SQL_CALC_FOUND_ROWS articleID,articleName,articleDetail,articleTitel,"
				+ "contactus,date_format(article.datecreate,'%d/%m/%Y'),statisticsvisit,"
				+ "amenities from article where article.restaurantsdetailID= ? ;";
		try {
			stmtarticle = conn.prepareStatement(sql);
			stmtarticle.setString(1, restaurantsdetailID);
			ResultSet rs = stmtarticle.executeQuery();
			while (rs.next()) {
				Article ar = new Article();
				ar.setArticleID(rs.getInt(1));
				ar.setArticleName(rs.getString(2));
				ar.setArticleDetail(rs.getString(3));
				ar.setArticleTitel(rs.getString(4));
				ar.setCountactus(rs.getString(5));
				ar.setDatecreate(rs.getString(6));
				ar.setStatisticsvisit(rs.getInt(7));
				ar.setAmenities(rs.getString(8));
				listArtile.add(ar);
			}
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmtarticle.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return listArtile;
	}

	/**************************************
	 * End Restaurants
	 ***************************************************/
	public Vector<Images> getImgListArticle(int articleID) {
		Vector<Images> listimages = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql_article_images_restaurants = "select image.imageID,image.imageName,image.imageDetail "
				+ "from image inner join article on image.articleID = article.articleID "
				+ "where article.articleID = ? ;";
		try {
			stmt = conn.prepareStatement(sql_article_images_restaurants);
			stmt.setInt(1, articleID);
			ResultSet rs_article_images_restaurants = stmt.executeQuery();
			while (rs_article_images_restaurants.next()) {
				Images article_images_restaurants = new Images();
				article_images_restaurants.setImageID(rs_article_images_restaurants.getInt(1));
				article_images_restaurants.setImageName(rs_article_images_restaurants.getString(2));
				article_images_restaurants.setImageDetail(rs_article_images_restaurants.getString(3));
				listimages.add(article_images_restaurants);
			}
			rs_article_images_restaurants.close();
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
		return listimages;
	}

	public Vector<Images> getImgAddress(String addressID) {
		Vector<Images> listimages = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql_article_images_restaurants = "select image.imageID,image.imageName,image.imageDetail "
				+ "from image inner join address on image.addressID = address.addressID "
				+ "where address.addressID = ? ;";
		try {
			stmt = conn.prepareStatement(sql_article_images_restaurants);
			stmt.setString(1, addressID);
			ResultSet rs_article_images_restaurants = stmt.executeQuery();
			while (rs_article_images_restaurants.next()) {
				Images article_images_restaurants = new Images();
				article_images_restaurants.setImageID(rs_article_images_restaurants.getInt(1));
				article_images_restaurants.setImageName(rs_article_images_restaurants.getString(2));
				article_images_restaurants.setImageDetail(rs_article_images_restaurants.getString(3));
				listimages.add(article_images_restaurants);
			}
			rs_article_images_restaurants.close();
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
		return listimages;
	}

	public Address getAddressID(String Detail) {
		Address address = new Address();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select address.addressID,address.mapimage from address where address.addressID = ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, Detail);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				address.setAddressID(rs.getInt(1));
				address.setMapimage(rs.getString(2));
			}
			rs.next();
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
		return address;
	}
}
