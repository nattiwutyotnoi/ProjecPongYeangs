package com.pongyeang.listFeaturedTravel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pongyeang.bean.HotelDetail;
import com.pongyeang.bean.RestaurantsDetail;
import com.pongyeang.bean.SubCategoryHotel;
import com.pongyeang.bean.SubCategoryRestaurants;
import com.pongyeang.bean.SubCategoryTravel;
import com.pongyeang.bean.TravelDetail;

/**
 * Servlet implementation class listFeaturedTravelServlet
 */
@WebServlet("/ListFeaturedTravelServlet")
public class ListFeaturedTravelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListFeaturedTravelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ListFeaturedTravelManager lftm = new ListFeaturedTravelManager();
		String category = request.getParameter("category");
		
		int page = 1;
		int recordsPerPage = 5;
		if (request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int noOfRecords = lftm.getNoOfRecords();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		
		session.setAttribute("listDesc",lftm.getListFeaturedTravel(Integer.parseInt(category),(page - 1) * recordsPerPage,recordsPerPage));
		goTo("/listFeaturedTravelPage.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void goTo(String url, HttpServletRequest request,HttpServletResponse response) {
		if (url != null) {
		RequestDispatcher dispatcher =getServletContext().getRequestDispatcher(url);
		try { dispatcher.forward(request, response); }
		catch (Exception e) {}
		}
		}
}
