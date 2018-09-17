package com.pongyeang.admin_editmember;

import java.io.IOException;
import java.util.Vector;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pongyeang.admin_listmember.ListMemberManager;
import com.pongyeang.admin_viewmemberdetail.ViewMemberDetailManager;
import com.pongyeang.bean.Login;
import com.pongyeang.bean.Owner;
import com.pongyeang.owner_editregisterprofile.EditRegisterProfileManager;

/**
 * Servlet implementation class EditMemberServlet
 */
@WebServlet("/EditMemberServlet")
public class EditMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMemberServlet() {
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
		Login listmember = (Login) session.getAttribute("loginowner");
		EditMemberManager memberManager = new EditMemberManager();
		listmember = memberManager.geViewMember(listmember);
		session.setAttribute("loginowner", listmember);
		goTo("/admin-editmember.jsp", request, response);
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
		Login listmember = (Login) session.getAttribute("loginowner");
		EditMemberManager editMemberManager = new EditMemberManager();
		Login login = editMemberManager.getLogin();
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

		// รับค่าในสถานะของผู้สามาชิก
		String status = request.getParameter("status");
		int statusOwner = Integer.parseInt(status);
		
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
		login.getOwner().setStatusapprove(statusOwner);
		editMemberManager.editMember(login);
		
		try {
			editMemberManager.getSendingEmail(login);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("loginowner", listmember);
		goTo("/admin-viewmemberdetail.jsp", request, response);
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
