package com.pongyeang.owner_editarticle;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pongyeang.owner_addarticle.AddArticelManager;
import com.pongyeang.owner_editprbusinessandtravel.EditPRBusinessAndTravelManager;

/**
 * Servlet implementation class DeleteImageEditArticleServlet
 */
@WebServlet("/DeleteImageEditArticleServlet")
public class DeleteImageEditArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteImageEditArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String imageID = request.getParameter("imageID");
		String imageName = request.getParameter("imageName");
		String articleID = request.getParameter("articleID");
		
		AddArticelManager addArticelManager = new AddArticelManager();	
		addArticelManager.removeImageArticle(imageID);

		String targetPathImagePR = getServletContext().getRealPath("/Tools/images/article");
		File filedelete = new File(targetPathImagePR + "/" + imageName);
		filedelete.delete();
		
		request.setAttribute("articleID", articleID);
		goTo("/EditArticleServlet", request, response);
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
