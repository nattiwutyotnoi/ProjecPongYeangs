package com.pongyeang.bean;

import java.util.Vector;

public class HotelDetail {
	private int hoteldetailID;
	private String hoteldetailName;
	private String hoteldetailData;
	private String hoteldetailTitel;
	private String opentime;
	private String checkincheckout;
	private String hotelprice;
	private String roomofnumber;
	private String amenities;
	private int statisticsvisit;
	private String telephone;
	private String facebook;
	private String line;
	private String twitter;
	private String website;
	private Address address = new Address();
	private Vector<Article> vecotrarticle = new Vector<>();
	private Owner ownerID;

	public HotelDetail() {

	}

	public HotelDetail(int hoteldetailID, String hoteldetailName, String hoteldetailData, String hoteldetailTitel,
			String opentime, String checkincheckout, String hotelprice, String roomofnumber, String amenities,
			int statisticsvisit, String telephone, String facebook, String line, String twitter, String website,
			Address address, Vector<Article> vecotrarticle, Owner ownerID) {
		super();
		this.hoteldetailID = hoteldetailID;
		this.hoteldetailName = hoteldetailName;
		this.hoteldetailData = hoteldetailData;
		this.hoteldetailTitel = hoteldetailTitel;
		this.opentime = opentime;
		this.checkincheckout = checkincheckout;
		this.hotelprice = hotelprice;
		this.roomofnumber = roomofnumber;
		this.amenities = amenities;
		this.statisticsvisit = statisticsvisit;
		this.telephone = telephone;
		this.facebook = facebook;
		this.line = line;
		this.twitter = twitter;
		this.website = website;
		this.address = address;
		this.vecotrarticle = vecotrarticle;
		this.ownerID = ownerID;
	}

	public int getHoteldetailID() {
		return hoteldetailID;
	}

	public void setHoteldetailID(int hoteldetailID) {
		this.hoteldetailID = hoteldetailID;
	}

	public String getHoteldetailName() {
		return hoteldetailName;
	}

	public void setHoteldetailName(String hoteldetailName) {
		this.hoteldetailName = hoteldetailName;
	}

	public String getHoteldetailData() {
		return hoteldetailData;
	}

	public void setHoteldetailData(String hoteldetailData) {
		this.hoteldetailData = hoteldetailData;
	}

	public String getHoteldetailTitel() {
		return hoteldetailTitel;
	}

	public void setHoteldetailTitel(String hoteldetailTitel) {
		this.hoteldetailTitel = hoteldetailTitel;
	}

	public int getStatisticsvisit() {
		return statisticsvisit;
	}

	public void setStatisticsvisit(int statisticsvisit) {
		this.statisticsvisit = statisticsvisit;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Vector<Article> getVecotrarticle() {
		return vecotrarticle;
	}

	public void setVecotrarticle(Vector<Article> vecotrarticle) {
		this.vecotrarticle = vecotrarticle;
	}

	public String getOpentime() {
		return opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	public String getCheckincheckout() {
		return checkincheckout;
	}

	public void setCheckincheckout(String checkincheckout) {
		this.checkincheckout = checkincheckout;
	}

	public String getHotelprice() {
		return hotelprice;
	}

	public void setHotelprice(String hotelprice) {
		this.hotelprice = hotelprice;
	}

	public String getRoomofnumber() {
		return roomofnumber;
	}

	public void setRoomofnumber(String roomofnumber) {
		this.roomofnumber = roomofnumber;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public Owner getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(Owner ownerID) {
		this.ownerID = ownerID;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
