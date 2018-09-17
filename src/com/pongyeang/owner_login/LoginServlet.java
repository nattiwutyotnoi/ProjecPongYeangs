package com.pongyeang.owner_login;

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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		LoginManager loginmanager = new LoginManager();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			String status = String.valueOf(loginmanager.getLogin(username,password));
			System.out.println("Status " + String.valueOf(status));
			if (status.equals("1")) {
				System.out.println("admin");
				session.setAttribute("status", status);
				response.sendRedirect("index.jsp");
			} else if (status.equals("2")) {
				Login login  = loginmanager.getOwnerUsername(username);
				if (login.getOwner().getStatusapprove() != 2) {
					request.setAttribute("warming", "รอการอนุมัติจากผู้ดูแลระบบและโปรดตรวจสอบทางอีเมล์ของท่านด้วย");
					response.sendRedirect("page-login.jsp");
				} else {
					System.out.println("owner");
					System.out.println("pass");
					System.out.println(login.getOwner().getOwnerFirstname() + " " + login.getOwner().getOwnerzLastname());
					session.setAttribute("status", status);
					session.setAttribute("login", login);
					response.sendRedirect("index.jsp");
				}
			}else{
				request.setAttribute("warming", "ไม่พบข้อมูลผู้ใช้ กรุณาตรวจสอบอีกครั้ง");
				response.sendRedirect("page-login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
