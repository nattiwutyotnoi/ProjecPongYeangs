package com.pongyeang.owner_viewprbusinessandtravel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class Owner_viewPRbusinessandtravelManager {

	private Category categorys = new Category();
	private VillageCategory villageCategory = new VillageCategory();
	private Address address = new Address();

	public Category getCategorys() {
		return categorys;
	}

	public void setCategorys(Category categorys) {
		this.categorys = categorys;
	}

	public VillageCategory getVillageCategory() {
		return villageCategory;
	}

	public void setVillageCategory(VillageCategory villageCategory) {
		this.villageCategory = villageCategory;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Owner getViewPRBusinessAndTravelDetail(Login login) {
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
					+ "villagecategory.villageID,villagecategory.villageName from traveldetail "
					+ "inner join owner on traveldetail.ownerID = owner.ownerID "
					+ "inner join subcategorytravel on traveldetail.subcategorytravelID = subcategorytravel.subcategorytravelID "
					+ "inner join category on subcategorytravel.categoryID = category.categoryID "
					+ "inner join address on address.addressID = traveldetail.addressID "
					+ "inner join image on image.addressID = address.addressID "
					+ "inner join villagecategory on address.villageID = villagecategory.villageID "
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
				category.getVectorsubcategorytravel().add(new SubCategoryTravel(rs.getString(7),rs.getString(8),""));
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
					+ "villagecategory.villageID,villagecategory.villageName from hoteldetail "
					+ " inner join owner on hoteldetail.ownerID = owner.ownerID "
					+ "inner join subcategoryhotel on hoteldetail.subcategoryhotelID = subcategoryhotel.subcategoryhotelID "
					+ " inner join category on subcategoryhotel.categoryID = category.categoryID "
					+ "inner join address on address.addressID = hoteldetail.addressID "
					+ "inner join villagecategory on address.villageID = villagecategory.villageID "
					+ "inner join image on image.addressID = address.addressID where owner.OwnerID = ? ;";
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
				category.getVectorsubcategoryhotel().add(new SubCategoryHotel(rs2.getString(12), rs2.getString(13), ""));
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
				listhotelDetail.add(owner.getHoteldetail());
				listsubCategoryHotel.add(category.getVectorsubcategoryhotel().get(0));
			}
			subCategoryHotel.setVectorhoteldetail(listhotelDetail);
			category.setVectorsubcategoryhotel(listsubCategoryHotel);

			rs2.close();

			Vector<SubCategoryRestaurants> listsubCategoryRestaurants = new Vector<>();
			SubCategoryRestaurants subCategoryRestaurants = new SubCategoryRestaurants();
			Vector<RestaurantsDetail> listrestaurantsDetails = new Vector<>();
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
					+ "villagecategory.villageID,villagecategory.villageName from restaurantsdetail "
					+ "inner join owner on restaurantsdetail.ownerID = owner.ownerID "
					+ "inner join address on address.addressID = restaurantsdetail.addressID "
					+ " inner join subcategoryrestaurants on restaurantsdetail.subcategoryrestaurantsID = subcategoryrestaurants.subcategoryrestaurantsID "
					+ "inner join category on subcategoryrestaurants.categoryID = category.categoryID "
					+ "inner join villagecategory on address.villageID = villagecategory.villageID "
					+ "inner join image on image.addressID = address.addressID where owner.OwnerID = ? ;";
			stmt_restaurants = conn.prepareStatement(sql3);
			stmt_restaurants.setInt(1, login.getOwner().getOwnerID());
			ResultSet rs3 = stmt_restaurants.executeQuery();
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
				category.getVectorsubcategoryrestaurants().add(new SubCategoryRestaurants(rs3.getString(10), rs3.getString(11), ""));
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
				listrestaurantsDetails.add(owner.getRestaurantsdetail());
				listsubCategoryRestaurants.add(category.getVectorsubcategoryrestaurants().get(0));

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
				stmt_restaurants.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return owner;

	}

	public Owner getListTravelDetail(Login login) {
		Owner owner = new Owner();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select traveldetail.traveldetailID,traveldetail.traveldetailName,traveldetail.traveldetailData"
				+ ",traveldetail.traveldetailTitle,traveldetail.statisticsvisit,traveldetail.subcategoryhotelID,"
				+ "owner.ownerFirstname, owner.ownerLastname, owner.idcard, owner.birthday,"
				+ " owner.phone, owner.email, owner.datecreate"
				+ "from traveldetail inner join owner on(traveldetail.ownerID=owner.ownerID)" + " where ownerID = ? ;";
		try {
			SubCategoryTravel subCategoryTravel = new SubCategoryTravel();
			TravelDetail travelDetail = new TravelDetail();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, login.getOwner().getOwnerID());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				travelDetail.setTraveldetailID(rs.getInt(1));
				travelDetail.setTraveldetailData(rs.getString(2));
				travelDetail.setTraveldetailName(rs.getString(3));
				travelDetail.setTraveldetailData(rs.getString(4));
				travelDetail.setTraveldetailTitel(rs.getString(5));
				subCategoryTravel.setSubcategorytravelID(rs.getString(6));
				owner.setOwnerID(rs.getInt(7));
				owner.setOwnerFirstname(rs.getString(8));
				owner.setOwnerzLastname(rs.getString(9));
				owner.setIdcard(rs.getString(10));
				owner.setBithday(rs.getString(11));
				owner.setPhone(rs.getString(12));
				owner.setEmail(rs.getString(13));
				owner.setDatecreate(rs.getString(14));
				owner.setTravledetail(travelDetail);
				login.setOwner(owner);
				subCategoryTravel.getVectortraveldetail().add(travelDetail);
				login.setOwner(owner);
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

	public Owner getListHotellDetail(Login login) {
		Owner owner = new Owner();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "hoteldetail.hoteldetailID,hoteldetail.hoteldetailName,hoteldetail.hoteldetailData,hoteldetail.hoteldetailTitle,"
				+ "hoteldetail.opentime,hoteldetail.checkincheckout,hoteldetail.hotelprice,"
				+ "hoteldetail.roomofnumber,hoteldetail.amenities,hoteldetail.statisticsvisit,"
				+ "owner.ownerFirstname, owner.ownerLastname, owner.idcard, owner.birthday, "
				+ "owner.phone, owner.email, owner.datecreatefrom hoteldetail "
				+ "from hoteldetail inner join owner on(hoteldetail.ownerID=owner.ownerID)"
				+ "where owner.ownerID =  ? ;";
		try {
			SubCategoryHotel subCategoryHotel = new SubCategoryHotel();

			HotelDetail hotelDetail = new HotelDetail();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, login.getOwner().getOwnerID());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				hotelDetail.setHoteldetailID(rs.getInt(1));
				hotelDetail.setHoteldetailName(rs.getString(2));
				hotelDetail.setHoteldetailData(rs.getString(3));
				hotelDetail.setHoteldetailTitel(rs.getString(4));
				hotelDetail.setOpentime(rs.getString(5));
				hotelDetail.setCheckincheckout(rs.getString(6));
				hotelDetail.setHotelprice(rs.getString(7));
				hotelDetail.setRoomofnumber(rs.getString(8));
				hotelDetail.setAmenities(rs.getString(9));
				subCategoryHotel.setSubcategoryhotelID(rs.getString(10));
				owner.setOwnerID(rs.getInt(11));
				owner.setOwnerFirstname(rs.getString(12));
				owner.setOwnerzLastname(rs.getString(13));
				owner.setIdcard(rs.getString(14));
				owner.setBithday(rs.getString(15));
				owner.setPhone(rs.getString(16));
				owner.setEmail(rs.getString(17));
				owner.setDatecreate(rs.getString(18));
				owner.setHoteldetail(hotelDetail);
				subCategoryHotel.getVectorhoteldetail().add(hotelDetail);
				login.setOwner(owner);
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

	public TravelDetail getViewPRTravelDetail(String n) {
		TravelDetail td = new TravelDetail();
		Address ad = new Address();
		Vector<Images> listimg = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select traveldetail.traveldetailID,traveldetail.traveldetailName,traveldetail.traveldetailData"
				+ ",traveldetail.traveldetailTitle,traveldetail.statisticsvisit,address.addressno"
				+ ",address.villageno,address.alley,address.street,address.subdistrict,address.district"
				+ ",address.province,address.zipcode,address.mapimage,address.mapimagedetail,date_format(address.datecreate,'%d/%m/%Y'),address.latitude"
				+ ",address.longtitude,traveldetail.telephone,traveldetail.facebook,traveldetail.line"
				+ ",traveldetail.twitter,traveldetail.website,image.imageID,image.imageName,image.imageDetail from traveldetail "
				+ "inner join address on address.traveldetailID = traveldetail.traveldetailID "
				+ "inner join image on image.addressID = address.addressID where traveldetail.traveldetailID= ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, n);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				td.setTraveldetailID(rs.getInt(1));
				td.setTraveldetailName(rs.getString(2));
				td.setTraveldetailData(rs.getString(3));
				td.setTraveldetailTitel(rs.getString(4));
				td.setStatisticsvisit(rs.getInt(5));
				td.getAddress().setAddressno(rs.getString(6));
				td.getAddress().setVillageno(rs.getString(7));
				td.getAddress().setAlley(rs.getString(8));
				td.getAddress().setStreet(rs.getString(9));
				td.getAddress().setSubdistrict(rs.getString(10));
				td.getAddress().setDistrict(rs.getString(11));
				td.getAddress().setProvince(rs.getString(12));
				td.getAddress().setZipcode(rs.getString(13));
				td.getAddress().setMapimage(rs.getString(14));
				td.getAddress().setMapimagedetail(rs.getString(15));
				td.getAddress().setDatecreate(rs.getString(16));
				td.getAddress().setLatitude(rs.getString(17));
				td.getAddress().setLongtitude(rs.getString(18));
				td.setTelephone(rs.getString(19));
				td.setFacebook(rs.getString(20));
				td.setLine(rs.getString(21));
				td.setTwitter(rs.getString(22));
				td.setWebsite(rs.getString(23));
				td.getAddress().getVectorimages().add(new Images(rs.getInt(24), rs.getString(25), rs.getString(26)));
			}
			ad.setVectorimages(listimg);
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

	/* END */
}
