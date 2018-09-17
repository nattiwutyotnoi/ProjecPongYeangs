package com.pongyeang.owner_register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * Servlet implementation class JSONCheckRegisterServlet
 */
@WebServlet("/JSONCheckRegisterServlet")
public class JSONCheckRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JSONCheckRegisterServlet() {
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
		boolean chksearch = false;
		JSONCheckRegisterManager jsonCheckRegisterManager = new JSONCheckRegisterManager();
		if (request.getParameter("idcard") != null) {
			String idcard = request.getParameter("idcard");
			chksearch = jsonCheckRegisterManager.getAllCheckIDCard(idcard);
		}
		if (request.getParameter("email") != null) {
			String email = request.getParameter("email");
			chksearch = jsonCheckRegisterManager.getAllCheckEmail(email);
		}
		if (request.getParameter("phone") != null) {
			String phone = request.getParameter("phone");
			chksearch = jsonCheckRegisterManager.getAllCheckPhone(phone);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(chksearch, Boolean.class);
		response.getWriter().append(json);
	}

}
