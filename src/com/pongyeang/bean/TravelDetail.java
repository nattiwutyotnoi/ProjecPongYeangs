package com.pongyeang.bean;

import java.util.Vector;

public class TravelDetail {
	private int traveldetailID;
	private String traveldetailName;
	private String traveldetailData;
	private String traveldetailTitel;
	private int statisticsvisit;
	private String telephone;
	private String facebook;
	private String line;
	private String twitter;
	private String website;
	private Address address = new Address();
	private Vector<Article> vecotrarticle = new Vector<>();
	private Owner ownerID;

	public TravelDetail() {
	}

	public TravelDetail(int traveldetailID, String traveldetailName, String traveldetailData, String traveldetailTitel,
			int statisticsvisit, String telephone, String facebook, String line, String twitter, String website,
			Address address, Vector<Article> vecotrarticle, Owner ownerID) {
		super();
		this.traveldetailID = traveldetailID;
		this.traveldetailName = traveldetailName;
		this.traveldetailData = traveldetailData;
		this.traveldetailTitel = traveldetailTitel;
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

	public int getTraveldetailID() {
		return traveldetailID;
	}

	public void setTraveldetailID(int traveldetailID) {
		this.traveldetailID = traveldetailID;
	}

	public String getTraveldetailName() {
		return traveldetailName;
	}

	public void setTraveldetailName(String traveldetailName) {
		this.traveldetailName = traveldetailName;
	}

	public String getTraveldetailData() {
		return traveldetailData;
	}

	public void setTraveldetailData(String traveldetailData) {
		this.traveldetailData = traveldetailData;
	}

	public String getTraveldetailTitel() {
		return traveldetailTitel;
	}

	public void setTraveldetailTitel(String traveldetailTitel) {
		this.traveldetailTitel = traveldetailTitel;
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
