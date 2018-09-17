package com.pongyeang.bean;

import java.util.Vector;

public class SubCategoryRestaurants {
	private String subcategoryrestaurantID;
	private String subcategoryrestaurantName;
	private String subcategoryrestaurantimage;
	private Vector<RestaurantsDetail> vectorrestaurantsdetail;

	public SubCategoryRestaurants() {

	}

	public SubCategoryRestaurants(String subcategoryrestaurantID, String subcategoryrestaurantName,
			String subcategoryrestaurantimage) {
		super();
		this.subcategoryrestaurantID = subcategoryrestaurantID;
		this.subcategoryrestaurantName = subcategoryrestaurantName;
		this.subcategoryrestaurantimage = subcategoryrestaurantimage;
	}

	public String getSubcategoryrestaurantID() {
		return subcategoryrestaurantID;
	}

	public void setSubcategoryrestaurantID(String subcategoryrestaurantID) {
		this.subcategoryrestaurantID = subcategoryrestaurantID;
	}

	public String getSubcategoryrestaurantName() {
		return subcategoryrestaurantName;
	}

	public void setSubcategoryrestaurantName(String subcategoryrestaurantName) {
		this.subcategoryrestaurantName = subcategoryrestaurantName;
	}

	public String getSubcategoryrestaurantimage() {
		return subcategoryrestaurantimage;
	}

	public void setSubcategoryrestaurantimage(String subcategoryrestaurantimage) {
		this.subcategoryrestaurantimage = subcategoryrestaurantimage;
	}

	public Vector<RestaurantsDetail> getVectorrestaurantsdetail() {
		return vectorrestaurantsdetail;
	}

	public void setVectorrestaurantsdetail(Vector<RestaurantsDetail> vectorrestaurantsdetail) {
		this.vectorrestaurantsdetail = vectorrestaurantsdetail;
	}

}
