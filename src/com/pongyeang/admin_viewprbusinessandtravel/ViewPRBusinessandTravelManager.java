package com.pongyeang.admin_viewprbusinessandtravel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

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

public class ViewPRBusinessandTravelManager {
	public Owner getViewPRBusinessAndTravelDetail(int IntOwnerID) {
		Owner owner = new Owner();
		Category category = new Category();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt_travel = null;
		PreparedStatement stmt_hotel = null;
		PreparedStatement stmt_restaurants = null;
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
					+ "villagecategory.villageID,villagecategory.villageName,owner.email from traveldetail "
					+ "inner join owner on traveldetail.ownerID = owner.ownerID "
					+ "inner join subcategorytravel on traveldetail.subcategorytravelID = subcategorytravel.subcategorytravelID "
					+ "inner join category on subcategorytravel.categoryID = category.categoryID "
					+ "inner join address on address.addressID = traveldetail.addressID "
					+ "inner join image on image.addressID = address.addressID "
					+ "inner join villagecategory on address.villageID = villagecategory.villageID "
					+ "where owner.OwnerID = ? ;";
			stmt_travel = conn.prepareStatement(sql);
			stmt_travel.setInt(1, IntOwnerID);
			ResultSet rs = stmt_travel.executeQuery();
			while (rs.next() && IntOwnerID == rs.getInt(6)) {
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
				owner.getTravledetail().getAddress().setStatusapproved(rs.getString(30));
				owner.getTravledetail().getAddress().getVectorimages()
						.add(new Images(rs.getInt(31), rs.getString(32), rs.getString(33)));
				owner.getTravledetail().getAddress().getVillageCategoryID().setVillageID(rs.getInt(34));
				owner.getTravledetail().getAddress().getVillageCategoryID().setVillageName(rs.getString(35));
				owner.setEmail(rs.getString(36));
				owner.getTravledetail()
						.setVecotrarticle(this.getListArticleTravel(owner.getTravledetail().getTraveldetailID()));
				listtravelDetail.add(owner.getTravledetail());
				listsubCategoryTravel.add(category.getVectorsubcategorytravel().get(0));
			}
			subCategoryTravel.setVectortraveldetail(listtravelDetail);
			category.setVectorsubcategorytravel(listsubCategoryTravel);

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
					+ "villagecategory.villageID,villagecategory.villageName,owner.email from hoteldetail "
					+ " inner join owner on hoteldetail.ownerID = owner.ownerID "
					+ "inner join subcategoryhotel on hoteldetail.subcategoryhotelID = subcategoryhotel.subcategoryhotelID "
					+ " inner join category on subcategoryhotel.categoryID = category.categoryID "
					+ "inner join address on address.addressID = hoteldetail.addressID "
					+ "inner join villagecategory on address.villageID = villagecategory.villageID "
					+ "inner join image on image.addressID = address.addressID where owner.OwnerID = ? ;";
			stmt_hotel = conn.prepareStatement(sql2);
			stmt_hotel.setInt(1, IntOwnerID);
			ResultSet rs2 = stmt_hotel.executeQuery();
			while (rs2.next() && IntOwnerID == rs2.getInt(11)) {
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
				owner.getHoteldetail().getAddress().setStatusapproved(rs2.getString(35));
				owner.getHoteldetail().getAddress().getVectorimages()
						.add(new Images(rs2.getInt(36), rs2.getString(37), rs2.getString(38)));
				owner.getHoteldetail().getAddress().getVillageCategoryID().setVillageID(rs2.getInt(39));
				owner.getHoteldetail().getAddress().getVillageCategoryID().setVillageName(rs2.getString(40));
				owner.setEmail(rs2.getString(41));
				owner.getHoteldetail()
						.setVecotrarticle(this.getListArticleHotel(owner.getHoteldetail().getHoteldetailID()));
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
					+ "restaurantsdetail.twitter,restaurantsdetail.website,address.statusapproved,image.imageID,image.imageName,image.imageDetail,"
					+ "villagecategory.villageID,villagecategory.villageName,owner.email from restaurantsdetail "
					+ "inner join owner on restaurantsdetail.ownerID = owner.ownerID "
					+ "inner join address on address.addressID = restaurantsdetail.addressID "
					+ " inner join subcategoryrestaurants on restaurantsdetail.subcategoryrestaurantsID = subcategoryrestaurants.subcategoryrestaurantsID "
					+ "inner join category on subcategoryrestaurants.categoryID = category.categoryID "
					+ "inner join villagecategory on address.villageID = villagecategory.villageID "
					+ "inner join image on image.addressID = address.addressID where owner.OwnerID = ? ;";
			stmt_restaurants = conn.prepareStatement(sql3);
			stmt_restaurants.setInt(1, IntOwnerID);
			ResultSet rs3 = stmt_restaurants.executeQuery();
			while (rs3.next() && IntOwnerID == rs3.getInt(9)) {
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
				owner.getRestaurantsdetail().getAddress().setStatusapproved(rs3.getString(33));
				owner.getRestaurantsdetail().getAddress().getVectorimages()
						.add(new Images(rs3.getInt(34), rs3.getString(35), rs3.getString(36)));
				owner.getRestaurantsdetail().getAddress().getVillageCategoryID().setVillageID(rs3.getInt(37));
				owner.getRestaurantsdetail().getAddress().getVillageCategoryID().setVillageName(rs3.getString(38));
				owner.setEmail(rs3.getString(39));
				owner.getRestaurantsdetail().setVecotrarticle(
						this.getListArticleRestaurants(owner.getRestaurantsdetail().getRestaurantsdetailID()));
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
				stmt_travel.close();
				stmt_hotel.close();
				stmt_restaurants.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return owner;

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

	public void getSendingEmail(String Username,String messagetext) throws AddressException, MessagingException {
		String userfrom = "spie555spie@gmail.com";
		String passwordfrom = "spice053578712";
		String title = "pongyenag travel";
		String localhosturl = "http://localhost:8096/pongyeangs/index.jsp";
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
			msg.setText("กรุณาตรวจสอบข้อมูลสถานที่ท่องเที่ยวของท่านเนื่องจาก "+messagetext+"\n"+
					"กรุณากลับไปแก้ไขด้วย ครับ/ค่ะ" + "\n" + localhosturl);
			msg.setFrom(new InternetAddress(userfrom));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(Username));
			Transport.send(msg);
		} catch (

		Exception ex) {
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
