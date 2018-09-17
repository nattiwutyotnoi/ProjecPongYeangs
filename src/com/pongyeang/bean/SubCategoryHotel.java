package com.pongyeang.bean;

import java.util.*;

public class SubCategoryHotel {
	private String subcategoryhotelID;
	private String subcategoryhotelName;
	private String subcategoryhotelImage;
	private Vector<HotelDetail> vectorhoteldetail;

	public SubCategoryHotel() {

	}

	public SubCategoryHotel(String subcategoryhotelID, String subcategoryhotelName, String subcategoryhotelImage) {
		super();
		this.subcategoryhotelID = subcategoryhotelID;
		this.subcategoryhotelName = subcategoryhotelName;
		this.subcategoryhotelImage = subcategoryhotelImage;
	}

	public String getSubcategoryhotelID() {
		return subcategoryhotelID;
	}

	public void setSubcategoryhotelID(String subcategoryhotelID) {
		this.subcategoryhotelID = subcategoryhotelID;
	}

	public String getSubcategoryhotelName() {
		return subcategoryhotelName;
	}

	public void setSubcategoryhotelName(String subcategoryhotelName) {
		this.subcategoryhotelName = subcategoryhotelName;
	}

	public String getSubcategoryhotelImage() {
		return subcategoryhotelImage;
	}

	public void setSubcategoryhotelImage(String subcategoryhotelImage) {
		this.subcategoryhotelImage = subcategoryhotelImage;
	}

	public Vector<HotelDetail> getVectorhoteldetail() {
		return vectorhoteldetail;
	}

	public void setVectorhoteldetail(Vector<HotelDetail> vectorhoteldetail) {
		this.vectorhoteldetail = vectorhoteldetail;
	}

}
