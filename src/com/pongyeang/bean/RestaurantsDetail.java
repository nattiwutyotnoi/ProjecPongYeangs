package com.pongyeang.bean;

import java.util.Vector;

public class RestaurantsDetail {
	private int restaurantsdetailID;
	private String restaurantsdetailName;
	private String restaurantsdetailData;
	private String restaurantsdetailTitel;
	private String opentime;
	private String pricerange;
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

	public RestaurantsDetail() {
	}

	public RestaurantsDetail(int restaurantsdetailID, String restaurantsdetailName, String restaurantsdetailData,
			String restaurantsdetailTitel, String opentime, String pricerange, String amenities, int statisticsvisit,
			String telephone, String facebook, String line, String twitter, String website, Address address,
			Vector<Article> vecotrarticle, Owner ownerID) {
		super();
		this.restaurantsdetailID = restaurantsdetailID;
		this.restaurantsdetailName = restaurantsdetailName;
		this.restaurantsdetailData = restaurantsdetailData;
		this.restaurantsdetailTitel = restaurantsdetailTitel;
		this.opentime = opentime;
		this.pricerange = pricerange;
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

	public int getRestaurantsdetailID() {
		return restaurantsdetailID;
	}

	public void setRestaurantsdetailID(int restaurantsdetailID) {
		this.restaurantsdetailID = restaurantsdetailID;
	}

	public String getRestaurantsdetailName() {
		return restaurantsdetailName;
	}

	public void setRestaurantsdetailName(String restaurantsdetailName) {
		this.restaurantsdetailName = restaurantsdetailName;
	}

	public String getRestaurantsdetailData() {
		return restaurantsdetailData;
	}

	public void setRestaurantsdetailData(String restaurantsdetailData) {
		this.restaurantsdetailData = restaurantsdetailData;
	}

	public String getRestaurantsdetailTitel() {
		return restaurantsdetailTitel;
	}

	public void setRestaurantsdetailTitel(String restaurantsdetailTitel) {
		this.restaurantsdetailTitel = restaurantsdetailTitel;
	}

	public String getOpentime() {
		return opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	public String getPricerange() {
		return pricerange;
	}

	public void setPricerange(String pricerange) {
		this.pricerange = pricerange;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
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
