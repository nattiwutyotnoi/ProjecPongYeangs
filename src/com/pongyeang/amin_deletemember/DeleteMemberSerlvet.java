package com.pongyeang.amin_deletemember;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pongyeang.bean.*;

/**
 * Servlet implementation class DeleteMemberSerlvet
 */
@WebServlet("/DeleteMemberSerlvet")
public class DeleteMemberSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteMemberSerlvet() {
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
		DeleteMemberManager deleteMemberManager = new DeleteMemberManager();
		String Username = request.getParameter("Username");
		Owner owner = deleteMemberManager.getViewPRBusinessAndTravelDetail(Username);
		try {
			deleteMemberManager.getSendingEmail(owner);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		if (owner.getTravledetail().getTraveldetailID() != 0) {

			Vector<Article> listarticle = deleteMemberManager
					.getListArticleTravel(owner.getTravledetail().getTraveldetailID());
			for (Article article : listarticle) {
				Vector<Images> listImage = deleteMemberManager.getImgListArticleTravel(article.getArticleID());
				for (int i = 0; i < listImage.size(); i++) {
					String targetPathImageArticle = getServletContext().getRealPath("/Tools/images/article");
					String deleteimagearticler = listImage.get(i).getImageName();
					File filedelete = new File(targetPathImageArticle + "/" + deleteimagearticler);
					filedelete.delete();
				}
			}

			Vector<Images> listImageaddress = deleteMemberManager
					.getImgAddress(owner.getTravledetail().getAddress().getAddressID());
			for (int i = 0; i < listImageaddress.size(); i++) {
				String targetPathImageAddress = getServletContext().getRealPath("/Tools/images/pr");
				String deleteimageaddress = listImageaddress.get(i).getImageName();
				File filedeleteaddress = new File(targetPathImageAddress + "/" + deleteimageaddress);
				filedeleteaddress.delete();
			}

			String targetPathmapimage = getServletContext().getRealPath("/Tools/images/mapimage");
			String deletemapimage = owner.getTravledetail().getAddress().getMapimage();
			File filedeletemapimage = new File(targetPathmapimage + "/" + deletemapimage);
			filedeletemapimage.delete();

		} else if (owner.getHoteldetail().getHoteldetailID() != 0) {
			Vector<Article> listarticle = deleteMemberManager
					.getListArticleHotel(owner.getHoteldetail().getHoteldetailID());
			for (Article article : listarticle) {
				Vector<Images> listImage = deleteMemberManager.getImgListArticleHotel(article.getArticleID());
				for (int i = 0; i < listImage.size(); i++) {
					String targetPathImageArticle = getServletContext().getRealPath("/Tools/images/article");
					String deleteimagearticler = listImage.get(i).getImageName();
					File filedelete = new File(targetPathImageArticle + "/" + deleteimagearticler);
					filedelete.delete();
				}
			}

			Vector<Images> listImageaddress = deleteMemberManager
					.getImgAddress(owner.getHoteldetail().getAddress().getAddressID());
			for (int i = 0; i < listImageaddress.size(); i++) {
				String targetPathImageAddress = getServletContext().getRealPath("/Tools/images/pr");
				String deleteimageaddress = listImageaddress.get(i).getImageName();
				File filedeleteaddress = new File(targetPathImageAddress + "/" + deleteimageaddress);
				filedeleteaddress.delete();
			}

			String targetPathmapimage = getServletContext().getRealPath("/Tools/images/mapimage");
			String deletemapimage = owner.getHoteldetail().getAddress().getMapimage();
			File filedeletemapimage = new File(targetPathmapimage + "/" + deletemapimage);
			filedeletemapimage.delete();
		} else if(owner.getRestaurantsdetail().getRestaurantsdetailID() != 0) {
			Vector<Article> listarticle = deleteMemberManager
					.getListArticleRestaurants(owner.getRestaurantsdetail().getRestaurantsdetailID());
			for (Article article : listarticle) {
				Vector<Images> listImage = deleteMemberManager.getImgListArticleRestaurants(article.getArticleID());
				for (int i = 0; i < listImage.size(); i++) {
					String targetPathImageArticle = getServletContext().getRealPath("/Tools/images/article");
					String deleteimagearticler = listImage.get(i).getImageName();
					File filedelete = new File(targetPathImageArticle + "/" + deleteimagearticler);
					filedelete.delete();
				}
			}

			Vector<Images> listImageaddress = deleteMemberManager
					.getImgAddress(owner.getRestaurantsdetail().getAddress().getAddressID());
			for (int i = 0; i < listImageaddress.size(); i++) {
				String targetPathImageAddress = getServletContext().getRealPath("/Tools/images/pr");
				String deleteimageaddress = listImageaddress.get(i).getImageName();
				File filedeleteaddress = new File(targetPathImageAddress + "/" + deleteimageaddress);
				filedeleteaddress.delete();
			}

			String targetPathmapimage = getServletContext().getRealPath("/Tools/images/mapimage");
			String deletemapimage = owner.getRestaurantsdetail().getAddress().getMapimage();
			File filedeletemapimage = new File(targetPathmapimage + "/" + deletemapimage);
			filedeletemapimage.delete();
		}else{
			deleteMemberManager.removeMember(owner);
			goTo("/ListMemberServlet", request, response);
		}
		deleteMemberManager.removeMember(owner);
		goTo("/ListMemberServlet", request, response);
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
