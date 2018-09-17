package com.pongyeang.owner_viewarticle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pongyeang.bean.*;
import com.pongyeang.owner_listallarticle.*;

/**
 * Servlet implementation class OwnerViewArticleServlet
 */
@WebServlet("/OwnerViewArticleServlet")
public class OwnerViewArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OwnerViewArticleServlet() {
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
		OwnerViewArtcleManager viewArtcleManager = new OwnerViewArtcleManager();
		Login login = (Login) session.getAttribute("login");
		Article article = (Article) request.getAttribute("article");
		
		if(request.getAttribute("article") != null){
			session.setAttribute("login", login);
			goTo("/owner-viewarticle.jsp", request, response);
		}else{
			String articleID = request.getParameter("articleID");
			article = viewArtcleManager.getViewArticleDetail(articleID);
			session.setAttribute("article", article);
			session.setAttribute("login", login);
			goTo("/owner-viewarticle.jsp", request, response);
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
