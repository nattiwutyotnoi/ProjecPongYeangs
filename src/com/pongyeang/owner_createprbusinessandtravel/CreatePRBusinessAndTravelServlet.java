package com.pongyeang.owner_createprbusinessandtravel;

import java.io.File;
import java.io.IOException;
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.*;
import java.util.*;
import com.google.gson.Gson;
import com.pongyeang.bean.*;
import com.pongyeang.listVillageCategory.*;
import com.pongyeang.owner_viewprbusinessandtravel.Owner_viewPRbusinessandtravelManager;

/**
 * Servlet implementation class CreatePRBusinessAndTravelServlet
 */
@WebServlet("/CreatePRBusinessAndTravelServlet")
public class CreatePRBusinessAndTravelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<FileItem> multiparts;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreatePRBusinessAndTravelServlet() {
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
		Login login = (Login) session.getAttribute("login");
		CreatePRBusinessAndTravelManager createPRBusinessAndTravelManager = new CreatePRBusinessAndTravelManager();
		Owner owner = createPRBusinessAndTravelManager.getCreatePRBusinessAndTravel(login);

		if (owner.getTravledetail().getTraveldetailID() != 0 || owner.getHoteldetail().getHoteldetailID() != 0
				|| owner.getRestaurantsdetail().getRestaurantsdetailID() != 0) {
			String warming = "�س��ӡ�����ҧʶҹ����ͧ��������� �ҡ��ͧ������ҧ�������ӡ�����";
			request.setAttribute("warming", warming);
			session.setAttribute("login", login);
			request.setAttribute("owner", owner);
			goTo("/owner-viewPRbusinessandtravel.jsp", request, response);
		} else {

			Vector<Category> vectorcatehory = createPRBusinessAndTravelManager.getListCategory();
			Vector<SubCategoryTravel> vectortravel = new Vector<>();
			Vector<SubCategoryHotel> vectorhotel = new Vector<>();
			Vector<SubCategoryRestaurants> vectoreastataurants = new Vector<>();
			Vector<VillageCategory> vectorvillagecategort = createPRBusinessAndTravelManager.getListVaillage();

			List<String> list = new ArrayList<String>();
			String categoryName = request.getParameter("categoryName");
			String json = null;
			if (request.getParameter("categoryName") != null) {
				if (categoryName.equals("��ͧ�����")) {
					vectortravel = createPRBusinessAndTravelManager.getListTravelSubCategory();
					for (SubCategoryTravel travel : vectortravel) {
						list.add(travel.getSubcategorytravelName());
					}
					json = new Gson().toJson(list);
					response.setContentType("application/json");
					response.getWriter().write(json);
				} else if (categoryName.equals("���ѡ")) {
					vectorhotel = createPRBusinessAndTravelManager.getListHotelSubCategory();
					for (SubCategoryHotel hotel : vectorhotel) {
						list.add(hotel.getSubcategoryhotelName());
					}
					json = new Gson().toJson(list);
					response.setContentType("application/json");
					response.getWriter().write(json);
				} else if (categoryName.equals("��ҹ��Һ�ԡ��")) {
					vectoreastataurants = createPRBusinessAndTravelManager.getListRastutaurantsSubCategory();
					for (SubCategoryRestaurants rastataurants : vectoreastataurants) {
						list.add(rastataurants.getSubcategoryrestaurantName());
					}
					json = new Gson().toJson(list);
					response.setContentType("application/json");
					response.getWriter().write(json);
				}
			} else {
				request.setAttribute("vectorvillagecategort", vectorvillagecategort);
				request.setAttribute("vectorcatehory", vectorcatehory);
				goTo("/owner-createPRbusinessandtravel.jsp", request, response);
			}

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
		Login login = (Login) session.getAttribute("login");
		CreatePRBusinessAndTravelManager createPRBusinessAndTravelManager = new CreatePRBusinessAndTravelManager();

		Category categorys = createPRBusinessAndTravelManager.getCategorys();
		Address address = createPRBusinessAndTravelManager.getAddress();

		String targetPath = getServletContext().getRealPath("/Tools/images/mapimage");
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				File createPath = new File(targetPath);
				if (!createPath.exists()) { // �� ����������
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

				if (category.equals("��ͧ�����")) {
					String subcategorytravelID = "";
					if (subcategory.equalsIgnoreCase("��ͧ����Ǹ����ҵ�")) {
						subcategorytravelID = "1";
					} else if (subcategory.equalsIgnoreCase("��ͧ������ԧ͹��ѡ��")) {
						subcategorytravelID = "2";
					} else if (subcategory.equalsIgnoreCase("��ͧ������ԧ�ɵ�")) {
						subcategorytravelID = "3";
					} else if (subcategory.equalsIgnoreCase("��ͧ����Ǽ�����")) {
						subcategorytravelID = "4";
					} else if (subcategory.equalsIgnoreCase("��ͧ����Ƿҧ�Ѳ��������ླ�")) {
						subcategorytravelID = "5";
					} else if (subcategory.equalsIgnoreCase("��ͧ��������¹����Զժ���")) {
						subcategorytravelID = "6";
					} else if (subcategory.equalsIgnoreCase("��ͧ����ǡѺ�ٹ�������¹���")) {
						subcategorytravelID = "7";
					} else if (subcategory.equalsIgnoreCase("��ͧ����ǡѺʶҹ���ҧ��ʹ�")) {
						subcategorytravelID = "8";
					}
					categorys.getVectorsubcategorytravel().add(new SubCategoryTravel(subcategorytravelID, null, null));

					login.getOwner().getTravledetail()
							.setTraveldetailID(createPRBusinessAndTravelManager.getMaxTravelDetailID());
					login.getOwner().getTravledetail().setTraveldetailName(business);
					login.getOwner().getTravledetail().setTraveldetailTitel(title);
					login.getOwner().getTravledetail().setTraveldetailData(detail);

				} else if (category.equals("���ѡ")) {
					String subcategoryHotelID = "";
					if (subcategory.equalsIgnoreCase("�ç���")) {
						subcategoryHotelID = "1";
					} else if (subcategory.equalsIgnoreCase("�����")) {
						subcategoryHotelID = "2";
					} else if (subcategory.equalsIgnoreCase("�������")) {
						subcategoryHotelID = "3";
					} else if (subcategory.equalsIgnoreCase("������")) {
						subcategoryHotelID = "4";
					} else if (subcategory.equalsIgnoreCase("�ʵ������")) {
						subcategoryHotelID = "5";
					} else if (subcategory.equalsIgnoreCase("�ѧ����")) {
						subcategoryHotelID = "6";
					} else if (subcategory.equalsIgnoreCase("�պ�")) {
						subcategoryHotelID = "7";
					} else if (subcategory.equalsIgnoreCase("�ٵԤ������")) {
						subcategoryHotelID = "8";
					} else if (subcategory.equalsIgnoreCase("�ҹ�ҧ�鹷�")) {
						subcategoryHotelID = "9";
					}
					String opentimeofhotel = multiparts.get(14).getString("UTF-8");
					String checkincheckout = multiparts.get(15).getString("UTF-8");
					String hotelprice = multiparts.get(16).getString("UTF-8");
					String roomofnumber = multiparts.get(17).getString("UTF-8");
					String amenitiesofhotel = multiparts.get(18).getString("UTF-8");

					categorys.getVectorsubcategoryhotel().add(new SubCategoryHotel(subcategoryHotelID, null, null));

					login.getOwner().getHoteldetail()
							.setHoteldetailID(createPRBusinessAndTravelManager.getMaxHotelDetailID());
					login.getOwner().getHoteldetail().setHoteldetailName(business);
					login.getOwner().getHoteldetail().setHoteldetailTitel(title);
					login.getOwner().getHoteldetail().setHoteldetailData(detail);
					login.getOwner().getHoteldetail().setOpentime(opentimeofhotel);
					login.getOwner().getHoteldetail().setCheckincheckout(checkincheckout);
					login.getOwner().getHoteldetail().setHotelprice(hotelprice);
					login.getOwner().getHoteldetail().setRoomofnumber(roomofnumber);
					login.getOwner().getHoteldetail().setAmenities(amenitiesofhotel);
				} else if (category.equals("��ҹ��Һ�ԡ��")) {
					String subcategoryRastaurantsID = "";
					if (subcategory.equalsIgnoreCase("��ҹ���")) {
						subcategoryRastaurantsID = "1";
					} else if (subcategory.equalsIgnoreCase("��ҹ�����")) {
						subcategoryRastaurantsID = "2";
					} else if (subcategory.equalsIgnoreCase("��ҹ��觪��������")) {
						subcategoryRastaurantsID = "3";
					} else if (subcategory.equalsIgnoreCase("��ҹ��觪�ź����")) {
						subcategoryRastaurantsID = "4";
					} else if (subcategory.equalsIgnoreCase("��ҹ�ͧ�ҡ�ͧ������֡")) {
						subcategoryRastaurantsID = "5";
					}
					String opentimeofrestaurants = multiparts.get(19).getString("UTF-8");
					String pricerange = multiparts.get(20).getString("UTF-8");
					String amenitiesofrestaurants = multiparts.get(21).getString("UTF-8");

					categorys.getVectorsubcategoryrestaurants()
							.add(new SubCategoryRestaurants(subcategoryRastaurantsID, null, null));

					login.getOwner().getRestaurantsdetail()
							.setRestaurantsdetailID(createPRBusinessAndTravelManager.getMaxReataurantsDetailID());
					login.getOwner().getRestaurantsdetail().setRestaurantsdetailName(business);
					login.getOwner().getRestaurantsdetail().setRestaurantsdetailTitel(title);
					login.getOwner().getRestaurantsdetail().setRestaurantsdetailData(detail);
					login.getOwner().getRestaurantsdetail().setOpentime(opentimeofrestaurants);
					login.getOwner().getRestaurantsdetail().setPricerange(pricerange);
					login.getOwner().getRestaurantsdetail().setAmenities(amenitiesofrestaurants);
				}
				String telephone = multiparts.get(22).getString("UTF-8");
				String facebook = multiparts.get(23).getString("UTF-8");
				String line = multiparts.get(24).getString("UTF-8");
				String twitter = multiparts.get(25).getString("UTF-8");
				String website = multiparts.get(26).getString("UTF-8");

				String mapimage = new File(multiparts.get(27).getName()).getName();
				String setmapimage = "";
				if (!mapimage.equals("")) {
					mapimage = new File(
							"mapimage_OwnerID" + login.getOwner().getOwnerID() + "_" + multiparts.get(27).getName())
									.getName();
					String[] submapimage = mapimage.split("\\.");
					String getmapimage = submapimage[0];
					setmapimage = getmapimage + ".jpg";
					multiparts.get(27).write(new File(targetPath + File.separator + setmapimage));
				} else {
					setmapimage = "null.jpg";
					multiparts.get(27).write(new File(targetPath + File.separator + setmapimage));
				}

				String mapimagedetail = multiparts.get(28).getString("UTF-8");
				String latiude = multiparts.get(29).getString("UTF-8");
				String longitude = multiparts.get(30).getString("UTF-8");

				address.setAddressID(createPRBusinessAndTravelManager.getMaxAddressID());
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
				address.getVillageCategoryID().setVillageID(Integer.parseInt(village));

				if (category.equals("��ͧ�����")) {
					login.getOwner().getTravledetail().setTelephone(telephone);
					login.getOwner().getTravledetail().setFacebook(facebook);
					login.getOwner().getTravledetail().setLine(line);
					login.getOwner().getTravledetail().setTwitter(twitter);
					login.getOwner().getTravledetail().setWebsite(website);
					login.getOwner().getTravledetail().setAddress(address);

					createPRBusinessAndTravelManager.addPRBusinessAndTravel_TravelDetail(login, categorys);
				} else if (category.equals("���ѡ")) {

					login.getOwner().getHoteldetail().setTelephone(telephone);
					login.getOwner().getHoteldetail().setFacebook(facebook);
					login.getOwner().getHoteldetail().setLine(line);
					login.getOwner().getHoteldetail().setTwitter(twitter);
					login.getOwner().getHoteldetail().setWebsite(website);
					login.getOwner().getHoteldetail().setAddress(address);

					createPRBusinessAndTravelManager.addPRBusinessAndTravel_HotelDetail(login, categorys);
				} else if (category.equals("��ҹ��Һ�ԡ��")) {
					login.getOwner().getRestaurantsdetail().setTelephone(telephone);
					login.getOwner().getRestaurantsdetail().setFacebook(facebook);
					login.getOwner().getRestaurantsdetail().setLine(line);
					login.getOwner().getRestaurantsdetail().setTwitter(twitter);
					login.getOwner().getRestaurantsdetail().setWebsite(website);
					login.getOwner().getRestaurantsdetail().setAddress(address);

					createPRBusinessAndTravelManager.addPRBusinessAndTravel_ReatauarantslDetail(login, categorys);
				}

				int i = 0;
				int j = 0;
				int imagenumber = 0;
				int multipartscheck = multiparts.size();
				System.out.println(multipartscheck);
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String targetPathImagePR = getServletContext().getRealPath("/Tools/images/pr");
						File createRrPath = new File(targetPathImagePR);
						if (!createRrPath.exists()) {
							createRrPath.mkdirs();
						}
						if (ServletFileUpload.isMultipartContent(request)) {
							int tree = 31 + i;
							int trees = 32 + j;
							if (trees < multipartscheck) {
								String imagepr = new File("pr_ownerID" + login.getOwner().getOwnerID() + "_"
										+ (imagenumber + 1) + "_" + multiparts.get(tree).getName()).getName();
								String[] subimagepr = imagepr.split("\\.");
								String getimagepr = subimagepr[0];
								String setimage = getimagepr + ".jpg";
								multiparts.get(tree).write(new File(targetPathImagePR + File.separator + setimage));
								String imagedetail = multiparts.get(trees).getString("UTF-8");
								address.getVectorimages().add(new Images(0, setimage, imagedetail));
								createPRBusinessAndTravelManager.addPRBusinessAndTravel_Images(address);
								i += 2;
								j += 2;
								imagenumber++;
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
		goTo("/index.jsp", request, response);
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
