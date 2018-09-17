package com.pongyeang.admin_viewprbusinessandtravel;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pongyeang.bean.Owner;

/**
 * Servlet implementation class SendtoEmailServlet
 */
@WebServlet("/SendtoEmailServlet")
public class SendtoEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendtoEmailServlet() {
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
		String Username =  request.getParameter("Username");
		String ownerID = request.getParameter("OwnerID");
		String messagetext = request.getParameter("messagetext");	
		ViewPRBusinessandTravelManager viewPRBusinessandTravelManager = new ViewPRBusinessandTravelManager();
		try {
			viewPRBusinessandTravelManager.getSendingEmail(Username,messagetext);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		Owner owner = viewPRBusinessandTravelManager.getViewPRBusinessAndTravelDetail(Integer.parseInt(ownerID));	
		request.setAttribute("listprowner", owner);
		goTo("/admin-viewprbusinessandtravel.jsp", request, response);
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
