package com.pongyeang.admin_viewprbusinessandtravel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pongyeang.bean.Login;
import com.pongyeang.bean.Owner;
import com.pongyeang.viewhotelsandlodgingdetail.ViewHotelsandLodgingDetailManager;

/**
 * Servlet implementation class ViewPRBusinessandTravelServlet
 */
@WebServlet("/ViewPRBusinessandTravelServlet")
public class ViewPRBusinessandTravelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPRBusinessandTravelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");		
		String ownerID = request.getParameter("ownerID");
		int IntOwnerID = Integer.parseInt(ownerID);
		ViewPRBusinessandTravelManager viewPRBusinessandTravelManager = new ViewPRBusinessandTravelManager();
		Owner owner = viewPRBusinessandTravelManager.getViewPRBusinessAndTravelDetail(IntOwnerID);	
		request.setAttribute("listprowner", owner);
		goTo("/admin-viewprbusinessandtravel.jsp", request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
