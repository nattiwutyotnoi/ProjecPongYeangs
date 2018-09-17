package com.pongyeang.owner_listallarticle;

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
import com.pongyeang.listArticle.*;

/**
 * Servlet implementation class OwnerListArticleServlet
 */
@WebServlet("/OwnerListArticleServlet")
public class OwnerListArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OwnerListArticleServlet() {
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
		OwnerListArticleManager ownerListArticleManager = new OwnerListArticleManager();
		Login login = (Login) session.getAttribute("login");
		Owner owner = new Owner();
		// owner =
		// ownerListArticleManager.getListPRBusinessAndTravelDetail(login);

		// Pagination ไปแต่ละหน้าตามที่เราดึกข้อมูลมาจากฐานข้อมูล เช่น
		// ดึกมา10ออกมา10 เป็นต้น
		int page = 1;
		int recordsPerPage = 10;
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));

		owner = ownerListArticleManager.getArticleData((page - 1) * recordsPerPage, recordsPerPage,
				login);

		int noOfRecords = ownerListArticleManager.getNoOfRecords();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		session.setAttribute("owner", owner);
		RequestDispatcher view = request.getRequestDispatcher("owner-listarticle.jsp");
		view.forward(request, response);

		// session.setAttribute("owner",owner);
		// goTo("/owner-listarticle.jsp",request,response);
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
