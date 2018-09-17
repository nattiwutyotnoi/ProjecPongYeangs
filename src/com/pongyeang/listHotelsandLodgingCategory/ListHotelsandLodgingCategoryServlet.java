package com.pongyeang.listHotelsandLodgingCategory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListHotelsandLodgingCategoryServlet
 */
@WebServlet("/ListHotelsandLodgingCategoryServlet")
public class ListHotelsandLodgingCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListHotelsandLodgingCategoryServlet() {
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
		ListHotelsandLodgingCategoryManager lhm = new ListHotelsandLodgingCategoryManager();

		session.setAttribute("ListHotel", lhm.getListSubCategoryHotel());
		goTo("/listHotelsandLodgingCategoryPage.jsp", request, response);
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
