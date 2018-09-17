package com.pongyeang.index;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.pongyeang.bean.Address;
import com.pongyeang.bean.Article;
import com.pongyeang.bean.Category;
import com.pongyeang.bean.HotelDetail;
import com.pongyeang.bean.Images;
import com.pongyeang.bean.RestaurantsDetail;
import com.pongyeang.bean.SubCategoryHotel;
import com.pongyeang.bean.SubCategoryRestaurants;
import com.pongyeang.bean.SubCategoryTravel;
import com.pongyeang.bean.TravelDetail;
import com.pongyeang.utilities.ExceptionUtil;
import com.pongyeang.utilities.MySQLConnectionPool;

public class IndexManager {

	public Vector<TravelDetail> getDetailFeaturedTravel() {
		Vector<TravelDetail> listtravel = new Vector<TravelDetail>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statement_traveldetail = null;
		String sql_traveldetail = "select SQL_CALC_FOUND_ROWS traveldetail.traveldetailID,"
				+ "traveldetail.traveldetailName,traveldetail.traveldetailData,"
				+ "traveldetail.traveldetailTitle,traveldetail.statisticsvisit,"
				+ "traveldetail.addressID,address.datecreate,address.statusapproved "
				+ "from traveldetail inner join address on address.addressID = traveldetail.addressID "
				+ "where address.statusapproved= 'yes' order by  traveldetail.statisticsvisit desc limit 3 ;";
		try {
			statement_traveldetail = conn.prepareStatement(sql_traveldetail);
			ResultSet rs = statement_traveldetail.executeQuery();
			while (rs.next()) {
				TravelDetail travelDetail = new TravelDetail();
				travelDetail.setTraveldetailID(rs.getInt(1));
				travelDetail.setTraveldetailName(rs.getString(2));
				travelDetail.setTraveldetailData(rs.getString(3));
				travelDetail.setTraveldetailTitel(rs.getString(4));
				travelDetail.setStatisticsvisit(rs.getInt(5));

				travelDetail.getAddress().setAddressID(rs.getInt(6));
				travelDetail.getAddress().setDatecreate(rs.getString(7));
				travelDetail.getAddress().setStatusapproved(rs.getString(8));
				travelDetail.getAddress().setVectorimages(this.getImgListOne(travelDetail.getAddress().getAddressID()));

				// Address address = new Address();
				// address.setAddressID(rs.getInt(6));
				// address.setDatecreate(rs.getString(7));
				// address.setStatusapproved(rs.getString(8));
				// address.setVectorimages(this.getImgListOne(address.getAddressID()));
				// travelDetail.setAddress(travelDetail.getAddress());
				listtravel.add(travelDetail);
			}
			rs.close();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statement_traveldetail.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return listtravel;
	}

	public Vector<HotelDetail> getDetailFeaturedHotel() {
		Vector<HotelDetail> listhotel = new Vector<HotelDetail>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statement_hoteldetail = null;
		String sql = "select SQL_CALC_FOUND_ROWS hoteldetail.hoteldetailID,hoteldetail.hoteldetailName,hoteldetail.hoteldetailData"
				+ ",hoteldetail.hoteldetailTitle,hoteldetail.opentime,hoteldetail.checkincheckout"
				+ ",hoteldetail.roomofnumber,hoteldetail.hotelprice,hoteldetail.amenities"
				+ ",hoteldetail.statisticsvisit,hoteldetail.addressID,address.datecreate,address.statusapproved"
				+ " from hoteldetail inner join address on address.addressID = hoteldetail.addressID "
				+ "where address.statusapproved='yes' order by  hoteldetail.statisticsvisit desc limit 3; ";
		try {
			statement_hoteldetail = conn.prepareStatement(sql);
			ResultSet rs = statement_hoteldetail.executeQuery();
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

				// Address address = new Address();
				// address.setAddressID(rs.getInt(11));
				// address.setDatecreate(rs.getString(12));
				// address.setStatusapproved(rs.getString(13));
				hotelDetail.getAddress().setVectorimages(this.getImgListOne(hotelDetail.getAddress().getAddressID()));

				// hotelDetail.setAddress(hotelDetail.getAddress());
				listhotel.add(hotelDetail);
			}
			rs.close();
			statement_hoteldetail.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listhotel;
	}

	public Vector<RestaurantsDetail> getDetailFeaturedRestataurant() {
		Vector<RestaurantsDetail> listrestaurants = new Vector<RestaurantsDetail>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statement_restaurantsdetail = null;
		String sql = "select SQL_CALC_FOUND_ROWS restaurantsdetail.restaurantsdetailID,restaurantsdetail.restaurantsdetailName,"
				+ "restaurantsdetail.restaurantsdetailData,restaurantsdetail.restaurantsdetailTitle,"
				+ "restaurantsdetail.opentime,restaurantsdetail.pricerange,restaurantsdetail.amenities,"
				+ "restaurantsdetail.statisticsvisit,restaurantsdetail.addressID,address.datecreate,address.statusapproved "
				+ "from restaurantsdetail inner join address on address.addressID = restaurantsdetail.addressID where address.statusapproved='yes' order by  restaurantsdetail.statisticsvisit desc limit 3;";
		try {
			statement_restaurantsdetail = conn.prepareStatement(sql);
			ResultSet rs = statement_restaurantsdetail.executeQuery();
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
				restaurantsDetail.getAddress().setStatusapproved(rs.getString(11));
				restaurantsDetail.getAddress()
						.setVectorimages(this.getImgListOne(restaurantsDetail.getAddress().getAddressID()));

				// Address address = new Address();
				// address.setAddressID(rs.getInt(9));
				// address.setDatecreate(rs.getString(10));
				// address.setStatusapproved(rs.getString(11));
				// address.setVectorimages(this.getImgListOne(address.getAddressID()));
				// restaurantsDetail.setAddress(restaurantsDetail.getAddress());

				listrestaurants.add(restaurantsDetail);
			}
			rs.close();
			statement_restaurantsdetail.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listrestaurants;
	}

	public Vector<Article> getListArticle() {
		Vector<Article> listArticle = new Vector<Article>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statement_article = null;
		String sql = "Select SQL_CALC_FOUND_ROWS article.articleID,article.articleName,article.articleDetail,article.articleTitel,article.contactus,date_format(article.datecreate,'%d/%m/%Y'),article.amenities,article.statisticsvisit "
				+ "from article order by rand() limit 3 ;";
		try {
			statement_article = conn.prepareStatement(sql);
			ResultSet rs = statement_article.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				article.setArticleID(rs.getInt(1));
				article.setArticleName(rs.getString(2));
				article.setArticleDetail(rs.getString(3));
				article.setArticleTitel(rs.getString(4));
				article.setCountactus(rs.getString(5));
				article.setDatecreate(rs.getString(6));
				article.setAmenities(rs.getString(7));
				article.setStatisticsvisit(rs.getInt(8));
				article.setVectorimages(this.getImgListArticle(article.getArticleID()));
				listArticle.add(article);
			}
			rs.close();
			statement_article.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listArticle;
	}

	public Vector<Images> getImgListArticle(int articleID) {
		Vector<Images> listimges = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statement_Imagearticle = null;
		String sql = "select imageID,imageName,imageDetail from image where articleID= ? ;";
		try {
			statement_Imagearticle = conn.prepareStatement(sql);
			statement_Imagearticle.setInt(1, articleID);
			ResultSet rs = statement_Imagearticle.executeQuery();
			while (rs.next()) {
				Images imges = new Images();
				imges.setImageID(rs.getInt(1));
				imges.setImageName(rs.getString(2));
				imges.setImageDetail(rs.getString(3));
				listimges.add(imges);
			}
			rs.close();
			statement_Imagearticle.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listimges;
	}

	public Vector<Images> getImgListOne(int addressID) {
		Vector<Images> listimges = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statement_Image = null;
		String sql = "select address.addressID,image.imageID,image.imageName," + "image.imageDetail "
				+ "from address inner join image on image.addressID = address.addressID "
				+ "where address.addressID= ? ;";
		try {
			statement_Image = conn.prepareStatement(sql);
			statement_Image.setInt(1, addressID);
			ResultSet rs = statement_Image.executeQuery();
			while (rs.next()) {
				Images imges = new Images();
				imges.setImageID(rs.getInt(2));
				imges.setImageName(rs.getString(3));
				imges.setImageDetail(rs.getString(4));
				listimges.add(imges);
			}
			rs.close();
			statement_Image.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listimges;
	}

	public Vector<Images> getImgAll() {
		Vector<Images> listimges = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statement_Imageall = null;
		String sql = "select imageID,imageName,imageDetail from image where image.addressID IS NOT NULL order by rand() limit 3;";
		try {
			statement_Imageall = conn.prepareStatement(sql);
			ResultSet rs = statement_Imageall.executeQuery();
			while (rs.next()) {
				Images imges = new Images();
				imges.setImageID(rs.getInt(1));
				imges.setImageName(rs.getString(2));
				imges.setImageDetail(rs.getString(3));
				listimges.add(imges);
			}
			rs.close();
			statement_Imageall.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listimges;
	}
}
