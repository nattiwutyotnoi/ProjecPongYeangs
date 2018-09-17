package com.pongyeang.bean;

import java.util.Vector;

public class VillageCategory {
	private int villageID;
	private String villageName;
	private String villageDetail;
	private String villageImage;
	private Vector<Address> vectoraddress  = new Vector<>();

	public VillageCategory() {

	}

	public VillageCategory(int villageID, String villageName, String villageDetail) {
		super();
		this.villageID = villageID;
		this.villageName = villageName;
		this.villageDetail = villageDetail;
	}

	public int getVillageID() {
		return villageID;
	}

	public void setVillageID(int villageID) {
		this.villageID = villageID;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public String getVillageDetail() {
		return villageDetail;
	}

	public void setVillageDetail(String villageDetail) {
		this.villageDetail = villageDetail;
	}

	public String getVillageImage() {
		return villageImage;
	}

	public void setVillageImage(String villageImage) {
		this.villageImage = villageImage;
	}

	public Vector<Address> getVectoraddress() {
		return vectoraddress;
	}

	public void setVectoraddress(Vector<Address> vectoraddress) {
		this.vectoraddress = vectoraddress;
	}

}
