package com.pongyeang.owner_editregisterprofile;

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
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditRegisterProfileServlet")
public class EditRegisterProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditRegisterProfileServlet() {
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
		Login login = (Login) session.getAttribute("login");
		EditRegisterProfileManager editProfileManager = new EditRegisterProfileManager();

		// รับค่าใน ส่วนที่1
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String idcard = request.getParameter("idcard");
		String bithday = request.getParameter("bithday");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		// รับค่าใน ส่วนที่2
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// เพิ่มค่าในคลาส Login
		login.setUsername(username);
		login.setPassword(password);

		// เพิ่มค่าในคคลาส Owner
		login.getOwner().setOwnerFirstname(firstname);
		login.getOwner().setOwnerzLastname(lastname);
		login.getOwner().setIdcard(idcard);
		login.getOwner().setBithday(bithday);
		login.getOwner().setPhone(phone);
		login.getOwner().setEmail(email);

		editProfileManager.editRegisterProfile(login);
		
		goTo("/owner-viewprofiledetail.jsp", request, response);
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
