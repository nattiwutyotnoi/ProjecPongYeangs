package com.pongyeang.bean;

import java.util.Vector;

public class Address {

	private int addressID;
	private String addressno;
	private String villageno;
	private String alley;
	private String street;
	private String subdistrict;
	private String district;
	private String province;
	private String zipcode;
	private String mapimage;
	private String mapimagedetail;
	private String datecreate;
	private String latitude;
	private String longtitude;
	private String statusapprove;
	private VillageCategory villageCategoryID = new VillageCategory();
	private Vector<Images> vectorimages = new Vector<>();

	public Address() {

	}

	public Address(int addressID, String addressno, String villageno, String alley, String street, String subdistrict,
			String district, String province, String zipcode, String mapimage, String mapimagedetail, String datecreate,
			String latitude, String longtitude, String statusapproved) {
		super();
		this.addressID = addressID;
		this.addressno = addressno;
		this.villageno = villageno;
		this.alley = alley;
		this.street = street;
		this.subdistrict = subdistrict;
		this.district = district;
		this.province = province;
		this.zipcode = zipcode;
		this.mapimage = mapimage;
		this.mapimagedetail = mapimagedetail;
		this.datecreate = datecreate;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.statusapprove = statusapproved;
	}

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getAddressno() {
		return addressno;
	}

	public void setAddressno(String addressno) {
		this.addressno = addressno;
	}

	public String getVillageno() {
		return villageno;
	}

	public void setVillageno(String villageno) {
		this.villageno = villageno;
	}

	public String getAlley() {
		return alley;
	}

	public void setAlley(String alley) {
		this.alley = alley;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSubdistrict() {
		return subdistrict;
	}

	public void setSubdistrict(String subdistrict) {
		this.subdistrict = subdistrict;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getMapimage() {
		return mapimage;
	}

	public void setMapimage(String mapimage) {
		this.mapimage = mapimage;
	}

	public String getMapimagedetail() {
		return mapimagedetail;
	}

	public void setMapimagedetail(String mapimagedetail) {
		this.mapimagedetail = mapimagedetail;
	}

	public String getDatecreate() {
		return datecreate;
	}

	public void setDatecreate(String datecreate) {
		this.datecreate = datecreate;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public Vector<Images> getVectorimages() {
		return vectorimages;
	}

	public void setVectorimages(Vector<Images> vectorimages) {
		this.vectorimages = vectorimages;
	}

	public String getStatusapproved() {
		return statusapprove;
	}

	public void setStatusapproved(String statusapproved) {
		this.statusapprove = statusapproved;
	}

	public VillageCategory getVillageCategoryID() {
		return villageCategoryID;
	}

	public void setVillageCategoryID(VillageCategory villageCategoryID) {
		this.villageCategoryID = villageCategoryID;
	}

}
