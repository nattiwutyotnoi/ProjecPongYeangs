package com.pongyeang.admin_listmember;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.pongyeang.bean.*;

/**
 * Servlet implementation class ListMemberServlet
 */
@WebServlet("/ListMemberServlet")
public class ListMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListMemberServlet() {
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
		ListMemberManager listMemberManager = new ListMemberManager();
		Vector<Login> listmember = new Vector<>();
		String statusapprove = request.getParameter("statusapprove");
		if (request.getParameter("statusapprove") != null) {
			int statusapproves = Integer.parseInt(statusapprove);

			// Pagination ไปแต่ละหน้าตามที่เราดึกข้อมูลมาจากฐานข้อมูล เช่น
			// ดึกมา10ออกมา10 เป็นต้น
			int page = 1;
			int recordsPerPage = 10;

			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			listmember = listMemberManager.getListAllMember((page - 1) * recordsPerPage, recordsPerPage,
					statusapproves);

			int noOfRecords = listMemberManager.getNoOfRecords();
			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

			request.setAttribute("noOfPages", noOfPages);
			request.setAttribute("currentPage", page);
			request.setAttribute("listmember", listmember);
			session.setAttribute("statusapproves", statusapproves);
			RequestDispatcher view = request.getRequestDispatcher("admin-listmember.jsp");
			view.forward(request, response);

		} else {
			// Pagination ไปแต่ละหน้าตามที่เราดึกข้อมูลมาจากฐานข้อมูล เช่น
			// ดึกมา10ออกมา10 เป็นต้น
			int statusapproves = 3;			
			int page = 1;
			int recordsPerPage = 10;
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			listmember = listMemberManager.getListAllEmployees((page - 1) * recordsPerPage, recordsPerPage);

			int noOfRecords = listMemberManager.getNoOfRecords();
			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

			request.setAttribute("noOfPages", noOfPages);
			request.setAttribute("currentPage", page);
			request.setAttribute("listmember", listmember);
			session.setAttribute("statusapproves", statusapproves);
			RequestDispatcher view = request.getRequestDispatcher("admin-listmember.jsp");
			view.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

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
