package com.pongyeang.bean;

public class Images {
	private int imageID;
	private String imageName;
	private String imageDetail;
	private int statusimage;
	
	public Images() {

	}

	public Images(int imageID, String imageName, String imageDetail) {
		super();
		this.imageID = imageID;
		this.imageName = imageName;
		this.imageDetail = imageDetail;
	}

	public int getImageID() {
		return imageID;
	}

	public void setImageID(int imageID) {
		this.imageID = imageID;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageDetail() {
		return imageDetail;
	}

	public void setImageDetail(String imageDetail) {
		this.imageDetail = imageDetail;
	}

	public int getStatusimage() {
		return statusimage;
	}

	public void setStatusimage(int statusimage) {
		this.statusimage = statusimage;
	}

}
