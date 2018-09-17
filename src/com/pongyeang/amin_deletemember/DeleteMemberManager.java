package com.pongyeang.amin_deletemember;

import java.sql.*;
import java.util.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class DeleteMemberManager {

	public void removeMember(Owner owner) {
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmttravel_aricleimage = null;
		PreparedStatement stmttravel_article = null;
		PreparedStatement stmttravel_addressimage = null;
		PreparedStatement stmttravel_address = null;
		PreparedStatement stmttravel_traveldetail = null;
		String sqltravel_aricleimage = "delete  from image where image.articleID  = ? ;";
		String sqltravel_article = "delete  from article where article.articleID  = ? ;";
		String sqltravel_addressimage = "delete  from image where image.addressID  = ? ;";	
		String sqltravel_traveldetail = "delete  from traveldetail where traveldetail.addressID  = ? ;";
		String sqltravel_address = "delete  from address where address.addressID  = ? ;";
		
		PreparedStatement stmthotel_aricleimage = null;
		PreparedStatement stmthotel_article = null;
		PreparedStatement stmthotel_addressimage = null;
		PreparedStatement stmthotel_address = null;
		PreparedStatement stmthotel_hoteldetail = null;
		String sqlhotel_aricleimage = "delete  from image where image.articleID  = ? ;";
		String sqlhotel_article = "delete  from article where article.articleID  = ? ;";
		String sqlhotel_addressimage = "delete  from image where image.addressID  = ? ;";	
		String sqlhotel_hoteldetail = "delete  from hoteldetail where hoteldetail.addressID  = ? ;";
		String sqlhotel_address = "delete  from address where address.addressID  = ? ;";

		PreparedStatement stmtrestaurants_aricleimage = null;
		PreparedStatement stmtrestaurants_article = null;
		PreparedStatement stmtrestaurants_addressimage = null;
		PreparedStatement stmtrestaurants_address = null;
		PreparedStatement stmtrestaurants_restaurantsdetail = null;
		String sqlrestaurants_aricleimage = "delete  from image where image.articleID  = ? ;";
		String sqlrestaurants_article = "delete  from article where article.articleID  = ? ;";
		String sqlrestaurants_addressimage = "delete  from image where image.addressID  = ? ;";
		String sqlrestaurants_restaurantsdetail = "delete  from restaurantsdetail where restaurantsdetail.addressID  = ? ;";
		String sqlrestaurants_address = "delete  from address where address.addressID  = ? ;";
		
		PreparedStatement stmtowner = null;
		PreparedStatement stmtlogin = null;
		String sqlowner = "delete  from owner where owner.username  = ? ;";
		String sqllogin = "delete  from login where login.username  = ? ;";

		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัต
			 */
			conn.setAutoCommit(false);
			if (owner.getTravledetail().getTraveldetailID() != 0) {
				// ลบรูปภาพของบทความสถานที่ท่องเที่ยว
				for (int i = 0; i < owner.getTravledetail().getVecotrarticle().size(); i++) {
					stmttravel_aricleimage = conn.prepareStatement(sqltravel_aricleimage);
					stmttravel_aricleimage.setInt(1,
							owner.getTravledetail().getVecotrarticle().get(i).getArticleID());
					stmttravel_aricleimage.executeUpdate();
					stmttravel_aricleimage.close();
				}
				// ลบบทความสถานที่ท่องเที่ยว
				for (int i = 0; i < owner.getTravledetail().getVecotrarticle().size(); i++) {
					stmttravel_article = conn.prepareStatement(sqltravel_article);
					stmttravel_article.setInt(1, owner.getTravledetail().getVecotrarticle().get(i).getArticleID());
					stmttravel_article.executeUpdate();
					stmttravel_article.close();
				}
				// ลบรูปภาพของที่อยู่สถานที่ท่องเที่ยว
				stmttravel_addressimage = conn.prepareStatement(sqltravel_addressimage);
				stmttravel_addressimage.setInt(1, owner.getTravledetail().getAddress().getAddressID());
				stmttravel_addressimage.executeUpdate();
				stmttravel_addressimage.close();
									
				// ลบสถานที่ท่องเที่ยว
				stmttravel_traveldetail = conn.prepareStatement(sqltravel_traveldetail);
				stmttravel_traveldetail.setInt(1, owner.getTravledetail().getAddress().getAddressID());
				stmttravel_traveldetail.executeUpdate();
				stmttravel_traveldetail.close();
				
				// ลบที่อยุ่สถานที่ท่องเที่ยว
				stmttravel_address = conn.prepareStatement(sqltravel_address);
				stmttravel_address.setInt(1, owner.getTravledetail().getAddress().getAddressID());
				stmttravel_address.executeUpdate();
				stmttravel_address.close();
				
			} else if (owner.getHoteldetail().getHoteldetailID() != 0) {
				// ลบรูปภาพของบทความที่พัก
				for (int i = 0; i < owner.getHoteldetail().getVecotrarticle().size(); i++) {
					stmthotel_aricleimage = conn.prepareStatement(sqlhotel_aricleimage);
					stmthotel_aricleimage.setInt(1, owner.getHoteldetail().getVecotrarticle().get(i).getArticleID());
					stmthotel_aricleimage.executeUpdate();
					stmthotel_aricleimage.close();
				}
				// ลบบทความที่พัก
				for (int i = 0; i < owner.getHoteldetail().getVecotrarticle().size(); i++) {
					stmthotel_article = conn.prepareStatement(sqlhotel_article);
					stmthotel_article.setInt(1, owner.getHoteldetail().getVecotrarticle().get(i).getArticleID());
					stmthotel_article.executeUpdate();
					stmthotel_article.close();
				}
				// ลบรูปภาพของที่อยู่ที่พัก
				stmthotel_addressimage = conn.prepareStatement(sqlhotel_addressimage);
				stmthotel_addressimage.setInt(1, owner.getHoteldetail().getAddress().getAddressID());
				stmthotel_addressimage.executeUpdate();
				stmthotel_addressimage.close();
				
				// ลบที่พัก
				stmthotel_hoteldetail = conn.prepareStatement(sqlhotel_hoteldetail);
				stmthotel_hoteldetail.setInt(1, owner.getHoteldetail().getAddress().getAddressID());
				stmthotel_hoteldetail.executeUpdate();
				stmthotel_hoteldetail.close();
				
				// ลบที่อยู่ที่พัก
				stmthotel_address = conn.prepareStatement(sqlhotel_address);
				stmthotel_address.setInt(1, owner.getHoteldetail().getAddress().getAddressID());
				stmthotel_address.executeUpdate();
				stmthotel_address.close();
			} else if (owner.getRestaurantsdetail().getRestaurantsdetailID() != 0) {
				// ลบรูปภาพของบทความสถานที่ร้านค้าและบริการ
				for (int i = 0; i < owner.getRestaurantsdetail().getVecotrarticle().size(); i++) {
					stmtrestaurants_aricleimage = conn.prepareStatement(sqlrestaurants_aricleimage);
					stmtrestaurants_aricleimage.setInt(1,
							owner.getRestaurantsdetail().getVecotrarticle().get(i).getArticleID());
					stmtrestaurants_aricleimage.executeUpdate();
					stmtrestaurants_aricleimage.close();
				}
				// ลบบทความสถานที่ร้านค้าและบริการ
				for (int i = 0; i < owner.getRestaurantsdetail().getVecotrarticle().size(); i++) {
					stmtrestaurants_article = conn.prepareStatement(sqlrestaurants_article);
					stmtrestaurants_article.setInt(1,
							owner.getRestaurantsdetail().getVecotrarticle().get(i).getArticleID());
					stmtrestaurants_article.executeUpdate();
					stmtrestaurants_article.close();
				}
				// ลบรูปภาพของที่อยู่สถานที่ร้านค้าและบริการ
				stmtrestaurants_addressimage = conn.prepareStatement(sqlrestaurants_addressimage);
				stmtrestaurants_addressimage.setInt(1, owner.getRestaurantsdetail().getAddress().getAddressID());
				stmtrestaurants_addressimage.executeUpdate();
				stmtrestaurants_addressimage.close();
							
				// ลบสถานที่ร้านค้าและบริการ
				stmtrestaurants_restaurantsdetail = conn.prepareStatement(sqlrestaurants_restaurantsdetail);
				stmtrestaurants_restaurantsdetail.setInt(1, owner.getRestaurantsdetail().getAddress().getAddressID());
				stmtrestaurants_restaurantsdetail.executeUpdate();
				stmtrestaurants_restaurantsdetail.close();
				
				// ลบที่อยุ่สถานที่ร้านค้าและบริการ
				stmtrestaurants_address = conn.prepareStatement(sqlrestaurants_address);
				stmtrestaurants_address.setInt(1, owner.getRestaurantsdetail().getAddress().getAddressID());
				stmtrestaurants_address.executeUpdate();
				stmtrestaurants_address.close();

			}

			stmtowner = conn.prepareStatement(sqlowner);
			stmtowner.setString(1, owner.getLogin().getUsername());
			stmtowner.executeUpdate();
			stmtowner.close();

			stmtlogin = conn.prepareStatement(sqllogin);
			stmtlogin.setString(1, owner.getLogin().getUsername());
			stmtlogin.executeUpdate();
			stmtlogin.close();
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
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
	}

	public Owner getViewPRBusinessAndTravelDetail(String Username) {
		Login login = new Login();
		Owner owner = new Owner();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select owner.ownerID, owner.ownerFirstname, owner.ownerLastname,"
				+ "owner.email,login.username,login.password "
				+ "from owner inner join login on login.username = owner.username where login.username = ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, Username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				owner.setOwnerID(rs.getInt(1));
				owner.setOwnerFirstname(rs.getString(2));
				owner.setOwnerzLastname(rs.getString(3));
				owner.setEmail(rs.getString(4));
				login.setUsername(rs.getString(5));
				login.setPassword(rs.getString(6));
				owner.setLogin(login);
				owner.setTravledetail(this.getTravelDetail(owner.getOwnerID()));
				owner.setHoteldetail(this.getHotelDetail(owner.getOwnerID()));
				owner.setRestaurantsdetail(this.getRestauantsDetail(owner.getOwnerID()));
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

	public TravelDetail getTravelDetail(int travelDetail) {
		TravelDetail travel = new TravelDetail();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select traveldetail.traveldetailID, traveldetail.traveldetailName, traveldetail.traveldetailData, traveldetail.traveldetailTitle,address.addressID "
				+ " from traveldetail inner join address on traveldetail.addressID = address.addressID "
				+ "where traveldetail.ownerID = ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, travelDetail);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				travel.setTraveldetailID(rs.getInt(1));
				travel.setTraveldetailName(rs.getString(2));
				travel.setTraveldetailData(rs.getString(3));
				travel.setTraveldetailTitel(rs.getString(4));
				travel.getAddress().setAddressID(rs.getInt(5));
				travel.setVecotrarticle(this.getListArticleTravel(travel.getTraveldetailID()));
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

		return travel;
	}

	public HotelDetail getHotelDetail(int HotelDetail) {
		HotelDetail hotel = new HotelDetail();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select hoteldetail.hoteldetailID, hoteldetail.hoteldetailName, hoteldetail.hoteldetailData, hoteldetail.hoteldetailTitle,address.addressID  "
				+ " from hoteldetail inner join address on hoteldetail.addressID = address.addressID "
				+ "where hoteldetail.ownerID = ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, HotelDetail);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				hotel.setHoteldetailID(rs.getInt(1));
				hotel.setHoteldetailName(rs.getString(2));
				hotel.setHoteldetailData(rs.getString(3));
				hotel.setHoteldetailTitel(rs.getString(4));
				hotel.getAddress().setAddressID(rs.getInt(5));
				hotel.setVecotrarticle(this.getListArticleHotel(hotel.getHoteldetailID()));
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
		return hotel;
	}

	public RestaurantsDetail getRestauantsDetail(int RestauantsDetail) {
		RestaurantsDetail restautants = new RestaurantsDetail();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select restaurantsdetail.restaurantsdetailID, restaurantsdetail.restaurantsdetailName, restaurantsdetail.restaurantsdetailData, restaurantsdetail.restaurantsdetailTitle,address.addressID  "
				+ " from restaurantsdetail  inner join address on restaurantsdetail.addressID = address.addressID "
				+ "where restaurantsdetail.ownerID = ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, RestauantsDetail);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				restautants.setRestaurantsdetailID(rs.getInt(1));
				restautants.setRestaurantsdetailName(rs.getString(2));
				restautants.setRestaurantsdetailData(rs.getString(3));
				restautants.setRestaurantsdetailTitel(rs.getString(4));
				restautants.getAddress().setAddressID(rs.getInt(5));
				restautants.setVecotrarticle(this.getListArticleRestaurants(restautants.getRestaurantsdetailID()));
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

		return restautants;
	}

	public Vector<Article> getListArticleTravel(int travelDetail) {
		Vector<Article> vectorArticle = new Vector<Article>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql_article_travle = "select article.articleID,article.articleName,article.articleTitel,article.articleDetail,"
				+ "article.datecreate,article.contactus,article.amenities,article.statisticsvisit from article "
				+ "inner join traveldetail on article.traveldetailID = traveldetail.traveldetailID "
				+ "where article.traveldetailID = ? ;";
		try {
			stmt = conn.prepareStatement(sql_article_travle);
			stmt.setInt(1, travelDetail);
			ResultSet rs_article_travle = stmt.executeQuery();
			while (rs_article_travle.next()) {
				Article article_travle = new Article();
				article_travle.setArticleID(rs_article_travle.getInt(1));
				article_travle.setArticleName(rs_article_travle.getString(2));
				article_travle.setArticleTitel(rs_article_travle.getString(3));
				article_travle.setArticleDetail(rs_article_travle.getString(4));
				article_travle.setDatecreate(rs_article_travle.getString(5));
				article_travle.setCountactus(rs_article_travle.getString(6));
				article_travle.setAmenities(rs_article_travle.getString(7));
				article_travle.setStatisticsvisit(rs_article_travle.getInt(8));
				article_travle.setVectorimages(this.getImgListArticleTravel(article_travle.getArticleID()));
				vectorArticle.add(article_travle);
			}
			rs_article_travle.close();
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
		return vectorArticle;
	}

	public Vector<Images> getImgListArticleTravel(int articleID) {
		Vector<Images> listimages = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql_article_images_travle = "select image.imageID,image.imageName,image.imageDetail "
				+ "from image inner join article on image.articleID = article.articleID "
				+ "where article.articleID = ? ;";
		try {
			stmt = conn.prepareStatement(sql_article_images_travle);
			stmt.setInt(1, articleID);
			ResultSet rs_article_images_travle = stmt.executeQuery();
			while (rs_article_images_travle.next()) {
				Images article_images_travle = new Images();
				article_images_travle.setImageID(rs_article_images_travle.getInt(1));
				article_images_travle.setImageName(rs_article_images_travle.getString(2));
				article_images_travle.setImageDetail(rs_article_images_travle.getString(3));
				listimages.add(article_images_travle);
			}
			rs_article_images_travle.close();
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

	public Vector<Article> getListArticleHotel(int hotelDetail) {
		Vector<Article> vectorArticle = new Vector<Article>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sqll_article_hotel = "select article.articleID,article.articleName,article.articleTitel,article.articleDetail,"
				+ "article.datecreate,article.contactus,article.amenities,article.statisticsvisit from article "
				+ "inner join hoteldetail on article.hoteldetailID = hoteldetail.hoteldetailID "
				+ "where article.hoteldetailID = ? ;";
		try {
			stmt = conn.prepareStatement(sqll_article_hotel);
			stmt.setInt(1, hotelDetail);
			ResultSet rs_article_hotel = stmt.executeQuery();
			while (rs_article_hotel.next()) {
				Article article_hotel = new Article();
				article_hotel.setArticleID(rs_article_hotel.getInt(1));
				article_hotel.setArticleName(rs_article_hotel.getString(2));
				article_hotel.setArticleTitel(rs_article_hotel.getString(3));
				article_hotel.setArticleDetail(rs_article_hotel.getString(4));
				article_hotel.setDatecreate(rs_article_hotel.getString(5));
				article_hotel.setCountactus(rs_article_hotel.getString(6));
				article_hotel.setAmenities(rs_article_hotel.getString(7));
				article_hotel.setStatisticsvisit(rs_article_hotel.getInt(8));
				article_hotel.setVectorimages(this.getImgListArticleHotel(article_hotel.getArticleID()));
				vectorArticle.add(article_hotel);
			}
			rs_article_hotel.close();
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
		return vectorArticle;
	}

	public Vector<Images> getImgListArticleHotel(int articleID) {
		Vector<Images> listimages = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql_article_images_hotel = "select image.imageID,image.imageName,image.imageDetail "
				+ "from image inner join article on image.articleID = article.articleID "
				+ "where article.articleID = ? ;";
		try {
			stmt = conn.prepareStatement(sql_article_images_hotel);
			stmt.setInt(1, articleID);
			ResultSet rs_article_images_hotel = stmt.executeQuery();
			while (rs_article_images_hotel.next()) {
				Images article_images_hotel = new Images();
				article_images_hotel.setImageID(rs_article_images_hotel.getInt(1));
				article_images_hotel.setImageName(rs_article_images_hotel.getString(2));
				article_images_hotel.setImageDetail(rs_article_images_hotel.getString(3));
				listimages.add(article_images_hotel);
			}
			rs_article_images_hotel.close();
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

	public Vector<Article> getListArticleRestaurants(int RestaurantslDetail) {
		Vector<Article> vectorArticle = new Vector<Article>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql_article_restaurants = "select article.articleID,article.articleName,article.articleTitel,article.articleDetail,"
				+ "article.datecreate,article.contactus,article.amenities,article.statisticsvisit from article "
				+ "inner join restaurantsdetail on article.restaurantsdetailID = restaurantsdetail.restaurantsdetailID "
				+ "where article.restaurantsdetailID = ? ;";
		try {
			stmt = conn.prepareStatement(sql_article_restaurants);
			stmt.setInt(1, RestaurantslDetail);
			ResultSet rs_article_restaurants = stmt.executeQuery();
			while (rs_article_restaurants.next()) {
				Article article_restaurants = new Article();
				article_restaurants.setArticleID(rs_article_restaurants.getInt(1));
				article_restaurants.setArticleName(rs_article_restaurants.getString(2));
				article_restaurants.setArticleTitel(rs_article_restaurants.getString(3));
				article_restaurants.setArticleDetail(rs_article_restaurants.getString(4));
				article_restaurants.setDatecreate(rs_article_restaurants.getString(5));
				article_restaurants.setCountactus(rs_article_restaurants.getString(6));
				article_restaurants.setAmenities(rs_article_restaurants.getString(7));
				article_restaurants.setStatisticsvisit(rs_article_restaurants.getInt(8));
				article_restaurants
						.setVectorimages(this.getImgListArticleRestaurants(article_restaurants.getArticleID()));
				vectorArticle.add(article_restaurants);
			}
			rs_article_restaurants.close();
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
		return vectorArticle;
	}

	public Vector<Images> getImgListArticleRestaurants(int articleID) {
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

	public Vector<Images> getImgAddress(int addressID) {
		Vector<Images> listimages = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql_article_images_restaurants = "select image.imageID,image.imageName,image.imageDetail "
				+ "from image inner join address on image.addressID = address.addressID "
				+ "where address.addressID = ? ;";
		try {
			stmt = conn.prepareStatement(sql_article_images_restaurants);
			stmt.setInt(1, addressID);
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

	public void getSendingEmail(Owner owner) throws AddressException, MessagingException {
		String userfrom = "spie555spie@gmail.com";
		String passwordfrom = "spice053578712";
		String title = "pongyenag travel";
		String localhosturl = "http://06ab758d.ngrok.io/pongyeangs/index.jsp";
		try {
			Properties props = new Properties();
			props.setProperty("mail.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.starttls.enable", "true");

			Authenticator auth = new SMTPAuthenticator(userfrom, passwordfrom);

			Session session = Session.getInstance(props, auth);

			MimeMessage msg = new MimeMessage(session);
			msg.setSubject("สมัครสมาชิก Pongyang Travel");
			msg.setText("สมัครสมาชิกเป็นใหม่ของเว็บไซต์ Pongyeang" + "\n" + "สวัสดีครับ/สวัสดีค่ะ,คุณ"
					+ owner.getOwnerFirstname() + "\n" 
					+"บัญชีสมาชิกของคุณถูกยกเลิกแล้ว หากมีข้อสงสัยกรุณาติดต่อทางเว็บไซต์" +"\n"
					+ localhosturl);

			msg.setFrom(new InternetAddress(userfrom));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(owner.getEmail()));
			Transport.send(msg);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private class SMTPAuthenticator extends Authenticator {

		private PasswordAuthentication authentication;

		public SMTPAuthenticator(String userfrom, String passwordfrom) {
			authentication = new PasswordAuthentication(userfrom, passwordfrom);
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return authentication;
		}
	}
}