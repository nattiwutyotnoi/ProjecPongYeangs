package com.pongyeang.owner_deletearticle;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pongyeang.bean.Images;
import com.pongyeang.bean.Login;
import com.pongyeang.bean.Owner;
import com.pongyeang.owner_listallarticle.OwnerListArticleManager;
import com.pongyeang.owner_viewarticle.OwnerViewArtcleManager;

/**
 * Servlet implementation class OwnerDeleteArticleServlet
 */
@WebServlet("/OwnerDeleteArticleServlet")
public class OwnerDeleteArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OwnerDeleteArticleServlet() {
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
		HttpSession session = request.getSession();
		OwnerDeleteArticleManager ownerDeleteArticleManager = new OwnerDeleteArticleManager();
		String status = (String) session.getAttribute("status");
		String articleID = request.getParameter("articleID");

		if (status.equals("1")) {
			String ownerIDArticle = request.getParameter("ownerIDArticle");
			Vector<Images> listImage = ownerDeleteArticleManager.getImgListArticle(articleID);
			System.out.println(articleID);
			for (int i = 0; i < listImage.size(); i++) {
				String targetPathImageArticle = getServletContext().getRealPath("/Tools/images/article");
				String deleteimagearticler = listImage.get(i).getImageName();
				File filedelete = new File(targetPathImageArticle + "/" + deleteimagearticler);
				filedelete.delete();
			}
			ownerDeleteArticleManager.removeArticle(articleID);
			System.out.println(ownerIDArticle);
			goTo("/ViewPRBusinessandTravelServlet?ownerID=" + ownerIDArticle, request,
					response);
		} else if (status.equals("2")) {
			Vector<Images> listImage = ownerDeleteArticleManager.getImgListArticle(articleID);
			for (int i = 0; i < listImage.size(); i++) {
				System.out.println(listImage.get(i).getImageID());
				String targetPathImageArticle = getServletContext().getRealPath("/Tools/images/article");
				String deleteimagearticler = listImage.get(i).getImageName();
				File filedelete = new File(targetPathImageArticle + "/" + deleteimagearticler);
				filedelete.delete();
			}
			ownerDeleteArticleManager.removeArticle(articleID);
			goTo("/index.jsp", request, response);
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
