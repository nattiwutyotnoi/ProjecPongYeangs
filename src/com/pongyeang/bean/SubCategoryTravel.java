package com.pongyeang.bean;

import java.util.Vector;

public class SubCategoryTravel {
	private String subcategorytravelID;
	private String subcategorytravelName;
	private String subcategoryhotelImage;
	private Vector<TravelDetail> vectortraveldetail;

	public SubCategoryTravel() {

	}

	public SubCategoryTravel(String subcategorytravelID, String subcategorytravelName, String subcategoryhotelImage) {
		super();
		this.subcategorytravelID = subcategorytravelID;
		this.subcategorytravelName = subcategorytravelName;
		this.subcategoryhotelImage = subcategoryhotelImage;
	}

	public String getSubcategorytravelID() {
		return subcategorytravelID;
	}

	public void setSubcategorytravelID(String subcategorytravelID) {
		this.subcategorytravelID = subcategorytravelID;
	}

	public String getSubcategorytravelName() {
		return subcategorytravelName;
	}

	public void setSubcategorytravelName(String subcategorytravelName) {
		this.subcategorytravelName = subcategorytravelName;
	}

	public String getSubcategoryhotelImage() {
		return subcategoryhotelImage;
	}

	public void setSubcategoryhotelImage(String subcategoryhotelImage) {
		this.subcategoryhotelImage = subcategoryhotelImage;
	}

	public Vector<TravelDetail> getVectortraveldetail() {
		return vectortraveldetail;
	}

	public void setVectortraveldetail(Vector<TravelDetail> vectortraveldetail) {
		this.vectortraveldetail = vectortraveldetail;
	}

}
