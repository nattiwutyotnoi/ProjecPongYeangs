package com.pongyeang.bean;

import java.util.Vector;

public class Article {
	private int articleID;
	private String articleName;
	private String articleDetail;
	private String articleTitel;
	private String duration;
	private String countactus;
	private String datecreate;
	private int statisticsvisit;
	private String amenities;
	private Vector<Images> vectorimages = new Vector<>();

	public Article() {
	}

	public Article(int articleID, String articleName, String articleDetail, String articleTitel, String countactus,
			String datecreate, String amenities,int statisticsvisit , String duration) {
		super();
		this.articleID = articleID;
		this.articleName = articleName;
		this.articleDetail = articleDetail;
		this.articleTitel = articleTitel;
		this.countactus = countactus;
		this.datecreate = datecreate;
		this.amenities = amenities;
		this.statisticsvisit = statisticsvisit;
		this.duration = duration;
	}

	public int getStatisticsvisit() {
		return statisticsvisit;
	}

	public void setStatisticsvisit(int statisticsvisit) {
		this.statisticsvisit = statisticsvisit;
	}

	public int getArticleID() {
		return articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public String getArticleDetail() {
		return articleDetail;
	}

	public void setArticleDetail(String articleDetail) {
		this.articleDetail = articleDetail;
	}

	public String getArticleTitel() {
		return articleTitel;
	}

	public void setArticleTitel(String articleTitel) {
		this.articleTitel = articleTitel;
	}

	public String getCountactus() {
		return countactus;
	}

	public void setCountactus(String countactus) {
		this.countactus = countactus;
	}

	public String getDatecreate() {
		return datecreate;
	}

	public void setDatecreate(String datecreate) {
		this.datecreate = datecreate;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public Vector<Images> getVectorimages() {
		return vectorimages;
	}

	public void setVectorimages(Vector<Images> vectorimages) {
		this.vectorimages = vectorimages;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}
