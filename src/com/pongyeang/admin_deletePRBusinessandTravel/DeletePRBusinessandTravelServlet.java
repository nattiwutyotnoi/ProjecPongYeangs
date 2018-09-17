package com.pongyeang.admin_deletePRBusinessandTravel;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pongyeang.bean.*;

/**
 * Servlet implementation class DeletePRBusinessandTravelServlet
 */
@WebServlet("/DeletePRBusinessandTravelServlet")
public class DeletePRBusinessandTravelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletePRBusinessandTravelServlet() {
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
		DeletePRBusinessandTravelManager dpbtm = new DeletePRBusinessandTravelManager();
		String addressID = request.getParameter("addressID");
		String traveldetailID = request.getParameter("traveldetailID");
		String hoteldetailID = request.getParameter("hoteldetailID");
		String restaurantsdetailID = request.getParameter("restaurantsdetailID");
		System.out.println(addressID + " " + traveldetailID);

		if (traveldetailID != null) {
			
			Vector<Article> listarticle = dpbtm.getListArticle(traveldetailID);
			for (Article article : listarticle) {
				Vector<Images> listImage = dpbtm.getImgListArticle(article.getArticleID());
				for (int i = 0; i < listImage.size(); i++) {
					String targetPathImageArticle = getServletContext().getRealPath("/Tools/images/article");
					String deleteimagearticler = listImage.get(i).getImageName();
					File filedelete = new File(targetPathImageArticle + "/" + deleteimagearticler);
					filedelete.delete();
				}
			}

			Vector<Images> listImageaddress = dpbtm.getImgAddress(addressID);
			for (int i = 0; i < listImageaddress.size(); i++) {
				String targetPathImageAddress = getServletContext().getRealPath("/Tools/images/pr");
				String deleteimageaddress = listImageaddress.get(i).getImageName();
				File filedeleteaddress = new File(targetPathImageAddress + "/" + deleteimageaddress);
				filedeleteaddress.delete();
			}

			Address address = dpbtm.getAddressID(addressID);
			String targetPathmapimage = getServletContext().getRealPath("/Tools/images/mapimage");
			String deletemapimage = address.getMapimage();
			File filedeletemapimage = new File(targetPathmapimage + "/" + deletemapimage);
			filedeletemapimage.delete();

			dpbtm.removePRBusinessandTravel(traveldetailID, addressID);
			goTo("/ListPRBusinessandTravelServlet?type=1", request, response);
			
		} else if (hoteldetailID != null) {
			
			Vector<Article> listarticle = dpbtm.getListArticle(hoteldetailID);
			for (Article article : listarticle) {
				Vector<Images> listImage = dpbtm.getImgListArticle(article.getArticleID());
				for (int i = 0; i < listImage.size(); i++) {
					String targetPathImageArticle = getServletContext().getRealPath("/Tools/images/article");
					String deleteimagearticler = listImage.get(i).getImageName();
					File filedelete = new File(targetPathImageArticle + "/" + deleteimagearticler);
					filedelete.delete();
				}
			}

			Vector<Images> listImageaddress = dpbtm.getImgAddress(addressID);
			for (int i = 0; i < listImageaddress.size(); i++) {
				String targetPathImageAddress = getServletContext().getRealPath("/Tools/images/pr");
				String deleteimageaddress = listImageaddress.get(i).getImageName();
				File filedeleteaddress = new File(targetPathImageAddress + "/" + deleteimageaddress);
				filedeleteaddress.delete();
			}

			Address address = dpbtm.getAddressID(addressID);
			String targetPathmapimage = getServletContext().getRealPath("/Tools/images/mapimage");
			String deletemapimage = address.getMapimage();
			File filedeletemapimage = new File(targetPathmapimage + "/" + deletemapimage);
			filedeletemapimage.delete();

			dpbtm.removePRBusinessandHotel(hoteldetailID, addressID);
			goTo("/ListPRBusinessandTravelServlet?type=2", request, response);
			
		} else if (restaurantsdetailID != null) {
			
			Vector<Article> listarticle = dpbtm.getListArticle(restaurantsdetailID);
			for (Article article : listarticle) {
				Vector<Images> listImage = dpbtm.getImgListArticle(article.getArticleID());
				for (int i = 0; i < listImage.size(); i++) {
					String targetPathImageArticle = getServletContext().getRealPath("/Tools/images/article");
					String deleteimagearticler = listImage.get(i).getImageName();
					File filedelete = new File(targetPathImageArticle + "/" + deleteimagearticler);
					filedelete.delete();
				}
			}

			Vector<Images> listImageaddress = dpbtm.getImgAddress(addressID);
			for (int i = 0; i < listImageaddress.size(); i++) {
				String targetPathImageAddress = getServletContext().getRealPath("/Tools/images/pr");
				String deleteimageaddress = listImageaddress.get(i).getImageName();
				File filedeleteaddress = new File(targetPathImageAddress + "/" + deleteimageaddress);
				filedeleteaddress.delete();
			}

			Address address = dpbtm.getAddressID(addressID);
			String targetPathmapimage = getServletContext().getRealPath("/Tools/images/mapimage");
			String deletemapimage = address.getMapimage();
			File filedeletemapimage = new File(targetPathmapimage + "/" + deletemapimage);
			filedeletemapimage.delete();

			dpbtm.removePRBusinessandRestaurants(restaurantsdetailID, addressID);
			goTo("/ListPRBusinessandTravelServlet?type=3", request, response);
			
		} else {
			
			goTo("/index.jsp", request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
