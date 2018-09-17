package com.pongyeang.bean;

public class Owner {
	private int ownerID;
	private String ownerFirstname;
	private String ownerzLastname;
	private String idcard;
	private String bithday;
	private String phone;
	private String email;
	private String datecreate;
	private int statusapprove;
	private Login login;
	private TravelDetail travledetail = new TravelDetail();
	private RestaurantsDetail restaurantsdetail = new RestaurantsDetail();
	private HotelDetail hoteldetail = new HotelDetail();

	public Owner() {

	}

	public Owner(int ownerID, String ownerFirstname, String ownerzLastname, String idcard, String bithday, String phone,
			String email, String datecreate, int statusapprove) {
		super();
		this.ownerID = ownerID;
		this.ownerFirstname = ownerFirstname;
		this.ownerzLastname = ownerzLastname;
		this.idcard = idcard;
		this.bithday = bithday;
		this.phone = phone;
		this.email = email;
		this.datecreate = datecreate;
		this.statusapprove = statusapprove;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public String getOwnerFirstname() {
		return ownerFirstname;
	}

	public void setOwnerFirstname(String ownerFirstname) {
		this.ownerFirstname = ownerFirstname;
	}

	public String getOwnerzLastname() {
		return ownerzLastname;
	}

	public void setOwnerzLastname(String ownerzLastname) {
		this.ownerzLastname = ownerzLastname;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getBithday() {
		return bithday;
	}

	public void setBithday(String bithday) {
		this.bithday = bithday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDatecreate() {
		return datecreate;
	}

	public void setDatecreate(String datecreate) {
		this.datecreate = datecreate;
	}

	public int getStatusapprove() {
		return statusapprove;
	}

	public void setStatusapprove(int statusapprove) {
		this.statusapprove = statusapprove;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public TravelDetail getTravledetail() {
		return travledetail;
	}

	public void setTravledetail(TravelDetail travledetail) {
		this.travledetail = travledetail;
	}

	public RestaurantsDetail getRestaurantsdetail() {
		return restaurantsdetail;
	}

	public void setRestaurantsdetail(RestaurantsDetail restaurantsdetail) {
		this.restaurantsdetail = restaurantsdetail;
	}

	public HotelDetail getHoteldetail() {
		return hoteldetail;
	}

	public void setHoteldetail(HotelDetail hoteldetail) {
		this.hoteldetail = hoteldetail;
	}

}
