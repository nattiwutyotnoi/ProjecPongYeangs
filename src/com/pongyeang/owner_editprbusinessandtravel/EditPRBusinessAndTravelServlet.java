package com.pongyeang.owner_editprbusinessandtravel;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.imageio.ImageIO;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.pongyeang.bean.*;
import com.pongyeang.listVillageCategory.ListVillageCategoryManager;
import com.pongyeang.owner_createprbusinessandtravel.CreatePRBusinessAndTravelManager;
import com.pongyeang.owner_editregisterprofile.EditRegisterProfileManager;
import com.pongyeang.owner_viewprbusinessandtravel.Owner_viewPRbusinessandtravelManager;
import com.sun.prism.Image;

/**
 * Servlet implementation class EditPRBusinessAndTravelServlet
 */
@WebServlet("/EditPRBusinessAndTravelServlet")
public class EditPRBusinessAndTravelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<FileItem> multiparts;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditPRBusinessAndTravelServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		EditRegisterProfileManager registerProfileManager = new EditRegisterProfileManager();
		EditPRBusinessAndTravelManager editPRBusinessAndTravelManager = new EditPRBusinessAndTravelManager();
		ListVillageCategoryManager listvillagecategorymanager = new ListVillageCategoryManager();

		Login login = (Login) session.getAttribute("login");
		Owner owner = editPRBusinessAndTravelManager.getViewPRBusinessAndTravelDetail(login);
		Vector<Category> listcategory = editPRBusinessAndTravelManager.getEditPRBusinessAndTravelDetail_Category(login);

		Vector<VillageCategory> vectorvillagecategort = listvillagecategorymanager.getListVaillage();
		Vector<Category> vectorcatehory = editPRBusinessAndTravelManager.getListCategory();

		Vector<SubCategoryTravel> vectortravel = new Vector<>();
		Vector<SubCategoryHotel> vectorhotel = new Vector<>();
		Vector<SubCategoryRestaurants> vectoreastataurants = new Vector<>();

		List<String> list = new ArrayList<String>();
		String categoryName = request.getParameter("categoryName");
		String json = null;
		if (request.getParameter("categoryName") != null) {
			if (categoryName.equals("ท่องเที่ยว")) {
				vectortravel = registerProfileManager.getListTravelSubCategory();
				for (SubCategoryTravel travel : vectortravel) {
					list.add(travel.getSubcategorytravelName());
				}
				json = new Gson().toJson(list);
				response.setContentType("application/json");
				response.getWriter().write(json);
			} else if (categoryName.equals("ที่พัก")) {
				vectorhotel = registerProfileManager.getListHotelSubCategory();
				for (SubCategoryHotel hotel : vectorhotel) {
					list.add(hotel.getSubcategoryhotelName());
				}
				json = new Gson().toJson(list);
				response.setContentType("application/json");
				response.getWriter().write(json);
			} else if (categoryName.equals("ร้านค้าบริการ")) {
				vectoreastataurants = registerProfileManager.getListRestaurantsSubCategory();
				for (SubCategoryRestaurants rastataurants : vectoreastataurants) {
					list.add(rastataurants.getSubcategoryrestaurantName());
				}
				json = new Gson().toJson(list);
				response.setContentType("application/json");
				response.getWriter().write(json);
			}
		} else {
			request.setAttribute("listcategory", listcategory);
			request.setAttribute("vectorvillagecategory", vectorvillagecategort);
			request.setAttribute("vectorcatehory", vectorcatehory);
			request.setAttribute("owner", owner);
			goTo("/owner-editPRbusinessandtravel.jsp", request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		EditPRBusinessAndTravelManager editPRBusinessAndTravelManager = new EditPRBusinessAndTravelManager();
		Login login = (Login) session.getAttribute("login");

		Owner_viewPRbusinessandtravelManager viewPRbusinessandtravelManager = new Owner_viewPRbusinessandtravelManager();
		Owner owner = viewPRbusinessandtravelManager.getViewPRBusinessAndTravelDetail(login);

		Category categorys = viewPRbusinessandtravelManager.getCategorys();
		VillageCategory villageCategory = viewPRbusinessandtravelManager.getVillageCategory();
		Address address = viewPRbusinessandtravelManager.getAddress();
		Vector<Address> listaddress = new Vector<>();

		String targetPath = getServletContext().getRealPath("/Tools/images/mapimage");
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				File createPath = new File(targetPath);
				if (!createPath.exists()) { // เช็ค โฟเดอร์ไม่มี
					createPath.mkdirs();
				}
				multiparts = upload.parseRequest(request);
				String business = multiparts.get(0).getString("UTF-8");
				String title = multiparts.get(1).getString("UTF-8");
				String category = multiparts.get(2).getString("UTF-8");
				String subcategory = multiparts.get(3).getString("UTF-8");
				String addressno = multiparts.get(4).getString("UTF-8");
				String villageno = multiparts.get(5).getString("UTF-8");
				String village = multiparts.get(6).getString("UTF-8");
				String alley = multiparts.get(7).getString("UTF-8");
				String street = multiparts.get(8).getString("UTF-8");
				String subdistrict = multiparts.get(9).getString("UTF-8");
				String district = multiparts.get(10).getString("UTF-8");
				String province = multiparts.get(11).getString("UTF-8");
				String zipcode = multiparts.get(12).getString("UTF-8");
				String detail = multiparts.get(13).getString("UTF-8");

				categorys.setCategoryName(category);

				if (category.equals("ท่องเที่ยว")) {
					String subcategorytravelID = "";
					if (subcategory.equalsIgnoreCase("ท่องเที่ยวธรรมชาติ")) {
						subcategorytravelID = "1";
					} else if (subcategory.equalsIgnoreCase("ท่องเที่ยวเชิงอนุรักษ์")) {
						subcategorytravelID = "2";
					} else if (subcategory.equalsIgnoreCase("ท่องเที่ยวเชิงเกษตร")) {
						subcategorytravelID = "3";
					} else if (subcategory.equalsIgnoreCase("ท่องเที่ยวผจญภัย")) {
						subcategorytravelID = "4";
					} else if (subcategory.equalsIgnoreCase("ท่องเที่ยวทางวัฒนธรรมประเพณี")) {
						subcategorytravelID = "5";
					} else if (subcategory.equalsIgnoreCase("ท่องเที่ยวเรียนรู้วิถีชนบท")) {
						subcategorytravelID = "6";
					} else if (subcategory.equalsIgnoreCase("ท่องเที่ยวกับศูนย์การเรียนรู้")) {
						subcategorytravelID = "7";
					} else if (subcategory.equalsIgnoreCase("ท่องเที่ยวกับสถานที่ทางศาสนา")) {
						subcategorytravelID = "8";
					}

					categorys.getVectorsubcategorytravel().add(new SubCategoryTravel(subcategorytravelID, "", ""));

					 login.getOwner().getTravledetail().setTraveldetailID(owner.getTravledetail().getTraveldetailID());
					 login.getOwner().getTravledetail().setTraveldetailName(business);
					 login.getOwner().getTravledetail().setTraveldetailTitel(title);
					 login.getOwner().getTravledetail().setTraveldetailData(detail);
					 login.getOwner().getTravledetail().getAddress()
					 .setAddressID(owner.getTravledetail().getAddress().getAddressID());
					 					 				 
				} else if (category.equals("ที่พัก")) {
					String subcategoryHotelID = "";
					if (subcategory.equalsIgnoreCase("โรงแรม")) {
						subcategoryHotelID = "1";
					} else if (subcategory.equalsIgnoreCase("โฮมเทล")) {
						subcategoryHotelID = "2";
					} else if (subcategory.equalsIgnoreCase("โฮมสเตย์")) {
						subcategoryHotelID = "3";
					} else if (subcategory.equalsIgnoreCase("รีสอร์ท")) {
						subcategoryHotelID = "4";
					} else if (subcategory.equalsIgnoreCase("เกสต์เฮาส์")) {
						subcategoryHotelID = "5";
					} else if (subcategory.equalsIgnoreCase("บังกะโล")) {
						subcategoryHotelID = "6";
					} else if (subcategory.equalsIgnoreCase("บีบี")) {
						subcategoryHotelID = "7";
					} else if (subcategory.equalsIgnoreCase("บูติครีสอร์ท")) {
						subcategoryHotelID = "8";
					} else if (subcategory.equalsIgnoreCase("ลานกางเต้นท์")) {
						subcategoryHotelID = "9";
					}
					String opentimeofhotel = multiparts.get(14).getString("UTF-8");
					String checkincheckout = multiparts.get(15).getString("UTF-8");
					String hotelprice = multiparts.get(16).getString("UTF-8");
					String roomofnumber = multiparts.get(17).getString("UTF-8");
					String amenitiesofhotel = multiparts.get(18).getString("UTF-8");

					categorys.getVectorsubcategoryhotel().add(new SubCategoryHotel(subcategoryHotelID, "", ""));
					login.getOwner().getHoteldetail().setHoteldetailID(owner.getHoteldetail().getHoteldetailID());
					login.getOwner().getHoteldetail().setHoteldetailName(business);
					login.getOwner().getHoteldetail().setHoteldetailTitel(title);
					login.getOwner().getHoteldetail().setHoteldetailData(detail);
					login.getOwner().getHoteldetail().setOpentime(opentimeofhotel);
					login.getOwner().getHoteldetail().setCheckincheckout(checkincheckout);
					login.getOwner().getHoteldetail().setHotelprice(hotelprice);
					login.getOwner().getHoteldetail().setRoomofnumber(roomofnumber);
					login.getOwner().getHoteldetail().setAmenities(amenitiesofhotel);
					login.getOwner().getHoteldetail().getAddress()
							.setAddressID(owner.getHoteldetail().getAddress().getAddressID());

				} else if (category.equals("ร้านค้าบริการ")) {
					String subcategoryRastaurantsID = "";
					if (subcategory.equalsIgnoreCase("ร้านกาแฟ")) {
						subcategoryRastaurantsID = "1";
					} else if (subcategory.equalsIgnoreCase("ร้านอาหาร")) {
						subcategoryRastaurantsID = "2";
					} else if (subcategory.equalsIgnoreCase("ร้านนั่งชิลริมน้ำ")) {
						subcategoryRastaurantsID = "3";
					} else if (subcategory.equalsIgnoreCase("ร้านนั่งชิลบนดอย")) {
						subcategoryRastaurantsID = "4";
					} else if (subcategory.equalsIgnoreCase("ร้านของฝากของที่ระลึก")) {
						subcategoryRastaurantsID = "5";
					}
					String opentimeofrestaurants = multiparts.get(19).getString("UTF-8");
					String pricerange = multiparts.get(20).getString("UTF-8");
					String amenitiesofrestaurants = multiparts.get(21).getString("UTF-8");

					categorys.getVectorsubcategoryrestaurants()
							.add(new SubCategoryRestaurants(subcategoryRastaurantsID, "", ""));
					login.getOwner().getRestaurantsdetail()
							.setRestaurantsdetailID(owner.getRestaurantsdetail().getRestaurantsdetailID());
					login.getOwner().getRestaurantsdetail().setRestaurantsdetailName(business);
					login.getOwner().getRestaurantsdetail().setRestaurantsdetailTitel(title);
					login.getOwner().getRestaurantsdetail().setRestaurantsdetailData(detail);
					login.getOwner().getRestaurantsdetail().setOpentime(opentimeofrestaurants);
					login.getOwner().getRestaurantsdetail().setPricerange(pricerange);
					login.getOwner().getRestaurantsdetail().setAmenities(amenitiesofrestaurants);
					login.getOwner().getRestaurantsdetail().getAddress()
							.setAddressID(owner.getRestaurantsdetail().getAddress().getAddressID());

				}

				String telephone = multiparts.get(22).getString("UTF-8");
				String facebook = multiparts.get(23).getString("UTF-8");
				String line = multiparts.get(24).getString("UTF-8");
				String twitter = multiparts.get(25).getString("UTF-8");
				String website = multiparts.get(26).getString("UTF-8");

				String pictureName = new File(multiparts.get(27).getName()).getName();
				String mapimage = "";
				String setmapimage = "";
				if (!pictureName.equals("")) {
					if (owner.getTravledetail().getTraveldetailID() != 0) {

						String deleteImageName = owner.getTravledetail().getAddress().getMapimage();
						File filedelete = new File(targetPath + "/" + deleteImageName);
						filedelete.delete();

					} else if (owner.getHoteldetail().getHoteldetailID() != 0) {

						String deleteImageName = owner.getHoteldetail().getAddress().getMapimage();
						File filedelete = new File(targetPath + "/" + deleteImageName);
						filedelete.delete();

					} else if (owner.getRestaurantsdetail().getRestaurantsdetailID() != 0) {

						String deleteImageName = owner.getRestaurantsdetail().getAddress().getMapimage();
						File filedelete = new File(targetPath + "/" + deleteImageName);
						filedelete.delete();
					}

					mapimage = new File(
							"mapimage_OwnerID" + login.getOwner().getOwnerID() + "_" + multiparts.get(27).getName())
									.getName();
					String[] submapimage = mapimage.split("\\.");
					String getmapimage = submapimage[0];
					setmapimage = getmapimage + ".jpg";
					multiparts.get(27).write(new File(targetPath + File.separator + setmapimage));

				} else {
					if (category.equals("ท่องเที่ยว")) {
						setmapimage = owner.getTravledetail().getAddress().getMapimage();
					} else if (category.equals("ที่พัก")) {
						setmapimage = owner.getHoteldetail().getAddress().getMapimage();
					} else if (category.equals("ร้านค้าบริการ")) {
						setmapimage = owner.getRestaurantsdetail().getAddress().getMapimage();
					}
				}

				String mapimagedetail = multiparts.get(28).getString("UTF-8");
				String latiude = multiparts.get(29).getString("UTF-8");
				String longitude = multiparts.get(30).getString("UTF-8");

				address.setAddressno(addressno);
				address.setVillageno(villageno);
				address.setAlley(alley);
				address.setStreet(street);
				address.setSubdistrict(subdistrict);
				address.setDistrict(district);
				address.setProvince(province);
				address.setZipcode(zipcode);

				address.setLatitude(latiude);
				address.setLongtitude(longitude);
				address.setMapimage(setmapimage);
				address.setMapimagedetail(mapimagedetail);

				villageCategory.setVillageID(Integer.parseInt(village));

				if (category.equals("ท่องเที่ยว")) {
					login.getOwner().getTravledetail().setTelephone(telephone);
					login.getOwner().getTravledetail().setFacebook(facebook);
					login.getOwner().getTravledetail().setLine(line);
					login.getOwner().getTravledetail().setTwitter(twitter);
					login.getOwner().getTravledetail().setWebsite(website);

					address.setAddressID(owner.getTravledetail().getAddress().getAddressID());
					address.setStatusapproved(owner.getTravledetail().getAddress().getStatusapproved());

					listaddress.add(address);
					villageCategory.setVectoraddress(listaddress);

					editPRBusinessAndTravelManager.editPRBusinessAndTravel_TravelDetail(login, villageCategory,
							categorys);
				} else if (category.equals("ที่พัก")) {
					login.getOwner().getHoteldetail().setTelephone(telephone);
					login.getOwner().getHoteldetail().setFacebook(facebook);
					login.getOwner().getHoteldetail().setLine(line);
					login.getOwner().getHoteldetail().setTwitter(twitter);
					login.getOwner().getHoteldetail().setWebsite(website);

					address.setAddressID(owner.getHoteldetail().getAddress().getAddressID());
					address.setStatusapproved(owner.getHoteldetail().getAddress().getStatusapproved());

					listaddress.add(address);
					villageCategory.setVectoraddress(listaddress);
					editPRBusinessAndTravelManager.editPRBusinessAndTravel_HotelDetail(login, villageCategory,
							categorys);
				} else if (category.equals("ร้านค้าบริการ")) {
					login.getOwner().getRestaurantsdetail().setTelephone(telephone);
					login.getOwner().getRestaurantsdetail().setFacebook(facebook);
					login.getOwner().getRestaurantsdetail().setLine(line);
					login.getOwner().getRestaurantsdetail().setTwitter(twitter);
					login.getOwner().getRestaurantsdetail().setWebsite(website);
					address.setAddressID(owner.getRestaurantsdetail().getAddress().getAddressID());
					address.setStatusapproved(owner.getRestaurantsdetail().getAddress().getStatusapproved());
					listaddress.add(address);
					villageCategory.setVectoraddress(listaddress);
					editPRBusinessAndTravelManager.editPRBusinessAndTravel_ReatauarantslDetail(login, villageCategory,
							categorys);
				}

				Vector<Images> listImage = editPRBusinessAndTravelManager.getImgListArticle(address);

				int i = 0;
				int j = 0;
				int h = 0;
				int imagenumber = 0;
				int multipartscheck = multiparts.size();
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						for (Images image : listImage) {
							String targetPathImagePR = getServletContext().getRealPath("/Tools/images/pr");
							File createRrPath = new File(targetPathImagePR);
							if (!createRrPath.exists()) {
								createRrPath.mkdirs();
							}
							if (ServletFileUpload.isMultipartContent(request)) {
								int tree = 31 + i;
								int trees = 33 + j;
								int hidden = 32 + h;
								if (trees < multipartscheck) {

									String PR_pictureName = new File(multiparts.get(tree).getName()).getName();
									String imagedetail = multiparts.get(trees).getString("UTF-8");
									String hiddenimage = multiparts.get(hidden).getString("UTF-8");
									String imagepr = "";

									if (!PR_pictureName.equals("") && !hiddenimage.equals("")) {
										if (image.getStatusimage() == 1) {
											String deleteImagePR = image.getImageName();
											File filedelete = new File(targetPathImagePR + "/" + deleteImagePR);
											filedelete.delete();

											imagepr = new File("pr_ownerID" + login.getOwner().getOwnerID() + "_"
													+ (imagenumber + 1) + "_" + multiparts.get(tree).getName())
															.getName();
											String[] subimagepr = imagepr.split("\\.");
											String getimagepr = subimagepr[0];
											String setimagepr = getimagepr + ".jpg";

											multiparts.get(tree)
													.write(new File(targetPathImagePR + File.separator + setimagepr));

											address.getVectorimages()
													.add(new Images(image.getImageID(), setimagepr, imagedetail));
											listaddress.add(address);
											villageCategory.setVectoraddress(listaddress);
											editPRBusinessAndTravelManager
													.editPRBusinessAndTravel_Images(villageCategory);
										} else {
											imagepr = new File("pr_ownerID" + login.getOwner().getOwnerID() + "_"
													+ (imagenumber + 1) + "_" + multiparts.get(tree).getName())
															.getName();
											String[] subimagepr = imagepr.split("\\.");
											String getimagepr = subimagepr[0];
											String setimagepr = getimagepr + ".jpg";
											multiparts.get(tree)
													.write(new File(targetPathImagePR + File.separator + setimagepr));
											address.getVectorimages().add(new Images(0, setimagepr, imagedetail));
											listaddress.add(address);
											villageCategory.setVectoraddress(listaddress);
											editPRBusinessAndTravelManager
													.addPRBusinessAndTravel_Images(villageCategory);
										}
									} else if (hiddenimage.equals("")) {
										imagepr = new File("pr_ownerID" + login.getOwner().getOwnerID() + "_"
												+ (imagenumber + 1) + "_" + multiparts.get(tree).getName()).getName();
										String[] subimagepr = imagepr.split("\\.");
										String getimagepr = subimagepr[0];
										String setimagepr = getimagepr + ".jpg";
										multiparts.get(tree)
												.write(new File(targetPathImagePR + File.separator + setimagepr));
										address.getVectorimages().add(new Images(0, setimagepr, imagedetail));
										listaddress.add(address);
										villageCategory.setVectoraddress(listaddress);
										editPRBusinessAndTravelManager.addPRBusinessAndTravel_Images(villageCategory);
									} else if (!imagedetail.equalsIgnoreCase("")) {
										imagepr = image.getImageName();
										address.getVectorimages()
												.add(new Images(image.getImageID(), imagepr, imagedetail));
										listaddress.add(address);
										villageCategory.setVectoraddress(listaddress);
										editPRBusinessAndTravelManager.editPRBusinessAndTravel_Images(villageCategory);
									} else {
										imagepr = image.getImageName();
										imagedetail = image.getImageDetail();
										address.getVectorimages()
												.add(new Images(image.getImageID(), imagepr, imagedetail));
										listaddress.add(address);
										villageCategory.setVectoraddress(listaddress);
										editPRBusinessAndTravelManager.editPRBusinessAndTravel_Images(villageCategory);
									}

									i += 3;
									j += 3;
									h += 3;
									imagenumber++;
								}
							}
						}
					}
				}

			} catch (Exception ex) {
				request.setAttribute("notification", "File Upload Failed due to " + ex);
				ex.printStackTrace();
			}
		} else {
			request.setAttribute("notification", "Sorry this Servlet only handles file upload request");
		}
		session.setAttribute("login", login);
		goTo("/Owner_viewPRbusinessandtravelServlet", request, response);
	}

	protected void goTo(String url, HttpServletRequest request, HttpServletResponse response) {
		if (url != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
			try {
				dispatcher.forward(request, response);
			} catch (Exception e) {
			}
		}
	}
}
