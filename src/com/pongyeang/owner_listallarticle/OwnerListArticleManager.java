package com.pongyeang.owner_listallarticle;

import java.sql.*;
import java.util.Vector;
import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class OwnerListArticleManager {

	private int noOfRecords;

	public Owner getArticleData(int offset, int noOfRecords, Login login) {
		Owner owner = new Owner();
		Category category = new Category();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt_travel = null;
		PreparedStatement stmt_hotel = null;
		PreparedStatement stmt_res = null;
		try {
			Vector<SubCategoryTravel> listsubCategoryTravel = new Vector<>();
			SubCategoryTravel subCategoryTravel = new SubCategoryTravel();
			Vector<TravelDetail> listtravelDetail = new Vector<>();
			String sql = "select  traveldetail.traveldetailID,traveldetail.traveldetailName,traveldetail.traveldetailData,"
					+ "traveldetail.traveldetailTitle,traveldetail.statisticsvisit ,traveldetail.ownerID,"
					+ "traveldetail.subcategorytravelID,subcategorytravel.subcategorytravelName,"
					+ "subcategorytravel.categoryID,category.categoryName  from traveldetail "
					+ "inner join owner on traveldetail.ownerID = owner.ownerID "
					+ "inner join subcategorytravel on traveldetail.subcategorytravelID = subcategorytravel.subcategorytravelID "
					+ "inner join category on subcategorytravel.categoryID = category.categoryID "
					+ "where owner.OwnerID = ? ;";
			stmt_travel = conn.prepareStatement(sql);
			stmt_travel.setInt(1, login.getOwner().getOwnerID());
			ResultSet rs = stmt_travel.executeQuery();
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
				owner.getTravledetail().setVecotrarticle(
						this.getListArticleTravel(owner.getTravledetail().getTraveldetailID(), offset, noOfRecords));
				listtravelDetail.add(owner.getTravledetail());
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
					+ "hoteldetail.subcategoryhotelID,subcategoryhotel.subcategoryhotelName, category.categoryID,category.categoryName "
					+ " from hoteldetail inner join owner on hoteldetail.ownerID = owner.ownerID "
					+ "inner join subcategoryhotel on hoteldetail.subcategoryhotelID = subcategoryhotel.subcategoryhotelID "
					+ "inner join category on subcategoryhotel.categoryID = category.categoryID where owner.OwnerID = ? ;";
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
				category.setCategoryID(rs2.getString(14));
				category.setCategoryName(rs2.getString(15));
				owner.getHoteldetail().setVecotrarticle(
						this.getListArticleHotel(owner.getHoteldetail().getHoteldetailID(), offset, noOfRecords));
				listhotelDetail.add(owner.getHoteldetail());
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
					+ "subcategoryrestaurants.categoryID,category.categoryName from restaurantsdetail "
					+ "inner join owner on restaurantsdetail.ownerID = owner.ownerID "
					+ " inner join subcategoryrestaurants on restaurantsdetail.subcategoryrestaurantsID = subcategoryrestaurants.subcategoryrestaurantsID "
					+ "inner join category on subcategoryrestaurants.categoryID = category.categoryID "
					+ " where owner.OwnerID = ? ;";
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
				category.setCategoryID(rs3.getString(12));
				category.setCategoryName(rs3.getString(13));
				owner.getRestaurantsdetail().setVecotrarticle(this.getListArticleRestaurants(
						owner.getRestaurantsdetail().getRestaurantsdetailID(), offset, noOfRecords));
				listrestaurantsDetails.add(owner.getRestaurantsdetail());
			}
			subCategoryRestaurants.setVectorrestaurantsdetail(listrestaurantsDetails);
			category.setVectorsubcategoryrestaurants(listsubCategoryRestaurants);
			rs3.close();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmt_travel.close();
				stmt_hotel.close();
				stmt_res.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return owner;

	}

	public int getNoOfRecords() {
		return noOfRecords;
	}

	public Vector<Article> getListArticleTravel(int travelDetail, int offset, int noOfRecords) {
		Vector<Article> vectorArticle = new Vector<Article>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt_article_travle = null;
		String sql_article_travle = "select SQL_CALC_FOUND_ROWS article.articleID,article.articleName,article.articleTitel,article.articleDetail,"
				+ "article.datecreate,article.contactus,article.amenities,article.statisticsvisit from article "
				+ "inner join traveldetail on article.traveldetailID = traveldetail.traveldetailID "
				+ "where article.traveldetailID = ?  limit ? , ? ;";
		try {
			stmt_article_travle = conn.prepareStatement(sql_article_travle);
			stmt_article_travle.setInt(1, travelDetail);
			stmt_article_travle.setInt(2, offset);
			stmt_article_travle.setInt(3, noOfRecords);
			ResultSet rs_article_travle = stmt_article_travle.executeQuery();
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
			rs_article_travle = stmt_article_travle.executeQuery("SELECT FOUND_ROWS()");
			if (rs_article_travle.next())
				this.noOfRecords = rs_article_travle.getInt(1);
			if (stmt_article_travle != null)
				stmt_article_travle.close();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmt_article_travle.close();
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
		PreparedStatement stmt_article_images_travle = null;
		String sql_article_images_travle = "select image.imageID,image.imageName,image.imageDetail "
				+ "from image inner join article on image.articleID = article.articleID "
				+ "where article.articleID = ? ;";
		try {
			stmt_article_images_travle = conn.prepareStatement(sql_article_images_travle);
			stmt_article_images_travle.setInt(1, articleID);
			ResultSet rs_article_images_travle = stmt_article_images_travle.executeQuery();
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
				stmt_article_images_travle.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return listimages;
	}

	public Vector<Article> getListArticleHotel(int hotelDetail, int offset, int noOfRecords) {
		Vector<Article> vectorArticle = new Vector<Article>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt_article_hotel = null;
		String sqll_article_hotel = "select SQL_CALC_FOUND_ROWS article.articleID,article.articleName,article.articleTitel,article.articleDetail,"
				+ "article.datecreate,article.contactus,article.amenities,article.statisticsvisit from article "
				+ "inner join hoteldetail on article.hoteldetailID = hoteldetail.hoteldetailID "
				+ "where article.hoteldetailID = ?  limit ? , ? ;";
		try {
			stmt_article_hotel = conn.prepareStatement(sqll_article_hotel);
			stmt_article_hotel.setInt(1, hotelDetail);
			stmt_article_hotel.setInt(2, offset);
			stmt_article_hotel.setInt(3, noOfRecords);
			ResultSet rs_article_hotel = stmt_article_hotel.executeQuery();
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
			rs_article_hotel = stmt_article_hotel.executeQuery("SELECT FOUND_ROWS()");
			if (rs_article_hotel.next())
				this.noOfRecords = rs_article_hotel.getInt(1);
			if (stmt_article_hotel != null)
				stmt_article_hotel.close();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmt_article_hotel.close();
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
		PreparedStatement stmt_article_images_hotel = null;
		String sql_article_images_hotel = "select image.imageID,image.imageName,image.imageDetail "
				+ "from image inner join article on image.articleID = article.articleID "
				+ "where article.articleID = ? ; ";
		try {
			stmt_article_images_hotel = conn.prepareStatement(sql_article_images_hotel);
			stmt_article_images_hotel.setInt(1, articleID);
			ResultSet rs_article_images_hotel = stmt_article_images_hotel.executeQuery();
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
				stmt_article_images_hotel.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return listimages;
	}

	public Vector<Article> getListArticleRestaurants(int RestaurantslDetail, int offset, int noOfRecords) {
		Vector<Article> vectorArticle = new Vector<Article>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt_article_restaurants = null;
		String sql_article_restaurants = "select SQL_CALC_FOUND_ROWS article.articleID,article.articleName,article.articleTitel,article.articleDetail,"
				+ "article.datecreate,article.contactus,article.amenities,article.statisticsvisit from article "
				+ "inner join restaurantsdetail on article.restaurantsdetailID = restaurantsdetail.restaurantsdetailID "
				+ "where article.restaurantsdetailID = ? limit ? , ? ;";
		try {
			stmt_article_restaurants = conn.prepareStatement(sql_article_restaurants);
			stmt_article_restaurants.setInt(1, RestaurantslDetail);
			stmt_article_restaurants.setInt(2, offset);
			stmt_article_restaurants.setInt(3, noOfRecords);
			ResultSet rs_article_restaurants = stmt_article_restaurants.executeQuery();
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
			rs_article_restaurants = stmt_article_restaurants.executeQuery("SELECT FOUND_ROWS()");
			if (rs_article_restaurants.next())
				this.noOfRecords = rs_article_restaurants.getInt(1);
			if (stmt_article_restaurants != null)
				stmt_article_restaurants.close();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmt_article_restaurants.close();
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
		PreparedStatement stmt_article_images_restaurants = null;
		String sql_article_images_restaurants = "select image.imageID,image.imageName,image.imageDetail "
				+ "from image inner join article on image.articleID = article.articleID "
				+ "where article.articleID = ? ;";
		try {
			stmt_article_images_restaurants = conn.prepareStatement(sql_article_images_restaurants);
			stmt_article_images_restaurants.setInt(1, articleID);
			ResultSet rs_article_images_restaurants = stmt_article_images_restaurants.executeQuery();
			while (rs_article_images_restaurants.next()) {
				Images article_images_restaurants = new Images();
				article_images_restaurants.setImageID(rs_article_images_restaurants.getInt(1));
				article_images_restaurants.setImageName(rs_article_images_restaurants.getString(2));
				article_images_restaurants.setImageDetail(rs_article_images_restaurants.getString(3));

				listimages.add(article_images_restaurants);
			}
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmt_article_images_restaurants.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return listimages;
	}
}
