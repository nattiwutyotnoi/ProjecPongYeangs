package com.pongyeang.owner_viewprbusinessandtravel;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pongyeang.bean.*;

/**
 * Servlet implementation class Owner_viewPRbusinessandtravelServlet
 */
@WebServlet("/Owner_viewPRbusinessandtravelServlet")
public class Owner_viewPRbusinessandtravelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Owner_viewPRbusinessandtravelServlet() {
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
		Owner_viewPRbusinessandtravelManager viewPRbusinessandtravelManager = new Owner_viewPRbusinessandtravelManager();
		Owner owner = viewPRbusinessandtravelManager.getViewPRBusinessAndTravelDetail(login);		
		request.setAttribute("owner", owner);
		goTo("/owner-viewPRbusinessandtravel.jsp", request, response);
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
