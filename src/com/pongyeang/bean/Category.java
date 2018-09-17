package com.pongyeang.bean;

import java.util.*;

public class Category {
	private String categoryID;
	private String categoryName;
	private Vector<SubCategoryTravel> vectorsubcategorytravel =  new Vector<SubCategoryTravel>();
	private Vector<SubCategoryRestaurants> vectorsubcategoryrestaurants = new Vector<SubCategoryRestaurants>();
	private Vector<SubCategoryHotel> vectorsubcategoryhotel = new Vector<SubCategoryHotel>();

	public Category() {

	}

	public Category(String categoryID, String categoryName) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}

	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Vector<SubCategoryTravel> getVectorsubcategorytravel() {
		return vectorsubcategorytravel;
	}

	public void setVectorsubcategorytravel(Vector<SubCategoryTravel> vectorsubcategorytravel) {
		this.vectorsubcategorytravel = vectorsubcategorytravel;
	}

	public Vector<SubCategoryRestaurants> getVectorsubcategoryrestaurants() {
		return vectorsubcategoryrestaurants;
	}

	public void setVectorsubcategoryrestaurants(Vector<SubCategoryRestaurants> vectorsubcategoryrestaurants) {
		this.vectorsubcategoryrestaurants = vectorsubcategoryrestaurants;
	}

	public Vector<SubCategoryHotel> getVectorsubcategoryhotel() {
		return vectorsubcategoryhotel;
	}

	public void setVectorsubcategoryhotel(Vector<SubCategoryHotel> vectorsubcategoryhotel) {
		this.vectorsubcategoryhotel = vectorsubcategoryhotel;
	}

}
