package com.pongyeang.owner_addarticle;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.pongyeang.bean.*;

/**
 * Servlet implementation class AddArticleServlet
 */
@WebServlet("/AddArticleServlet")
public class AddArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<FileItem> multiparts;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddArticleServlet() {
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
		AddArticelManager addArticelManager = new AddArticelManager();
		Login login = (Login) session.getAttribute("login");

		Owner owner = addArticelManager.getViewPRBusinessAndTravelDetail(login);
		if (owner.getTravledetail() != null || owner.getHoteldetail() != null || owner.getRestaurantsdetail() != null) {
			if (owner.getTravledetail().getTraveldetailID() != 0 || owner.getHoteldetail().getHoteldetailID() != 0
					|| owner.getRestaurantsdetail().getRestaurantsdetailID() != 0) {
				session.setAttribute("owner", owner);
				goTo("/owner-addArticle.jsp", request, response);
			} else {
				String warming = "คุณต้องทำการสร้างสถานที่ท่องเที่ยวก่อน ครับ/ค่ะ";
				request.setAttribute("warming", warming);
				goTo("/CreatePRBusinessAndTravelServlet", request, response);
			}
		} else {
			String warming = "คุณต้องทำการสร้างสถานที่ท่องเที่ยวก่อน ครับ/ค่ะ";
			request.setAttribute("warming", warming);
			goTo("/CreatePRBusinessAndTravelServlet", request, response);
		}
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
		Owner owner = (Owner) session.getAttribute("owner");

		AddArticelManager addArticelManager = new AddArticelManager();
		Article article = addArticelManager.getArticle();

		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				multiparts = upload.parseRequest(request);
				String articleName = multiparts.get(0).getString("UTF-8");
				String articleTitel = multiparts.get(1).getString("UTF-8");
				String articleDetail = multiparts.get(2).getString("UTF-8");
				String amenities = multiparts.get(3).getString("UTF-8");
				String contactus = multiparts.get(4).getString("UTF-8");

				article.setArticleID(addArticelManager.getMaxArticleID());
				article.setArticleName(articleName);
				article.setArticleTitel(articleTitel);
				article.setArticleDetail(articleDetail);
				article.setAmenities(amenities);
				article.setCountactus(contactus);

				if (owner.getTravledetail().getTraveldetailID() != 0) {
					addArticelManager.addTravelDetailArticle(owner, article);
				} else if (owner.getHoteldetail().getHoteldetailID() != 0) {
					addArticelManager.addHotelDetailArticle(owner, article);
				} else if (owner.getRestaurantsdetail().getRestaurantsdetailID() != 0) {
					addArticelManager.addRestaurantsDetailArticle(owner, article);
				} else {
					goTo("/index.jsp", request, response);
				}
				int i = 0;
				int j = 0;
				int imagenumber = 0;
				System.out.println(multiparts.size());
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String targetPathImageArticle = getServletContext().getRealPath("/Tools/images/article");
						File createRrPath = new File(targetPathImageArticle);
						if (!createRrPath.exists()) {
							createRrPath.mkdirs();
						}
						if (ServletFileUpload.isMultipartContent(request)) {
							int uploadimagesnumber = 5 + i;
							int uploaddetailimagenumber = 6 + j;
							if (uploadimagesnumber < multiparts.size()) {

								String imagearticler = new File(multiparts.get(uploadimagesnumber).getName()).getName();
								String imagearticlernull = "";
								String setimagearticler = "";
								if (!imagearticler.equals("")) {
									imagearticler = new File("article_OwnerID" + login.getOwner().getOwnerID() + "_"
											+ (imagenumber + 1) + "_" + multiparts.get(uploadimagesnumber).getName())
													.getName();
									String[] subimagearticler = imagearticler.split("\\.");
									String getimagearticler = subimagearticler[0];
									setimagearticler = getimagearticler + ".jpg";
									multiparts.get(uploadimagesnumber).write(
											new File(targetPathImageArticle + File.separator + setimagearticler));
								} else {
									imagearticlernull = "null.jpg";
									multiparts.get(27).write(
											new File(targetPathImageArticle + File.separator + imagearticlernull));
								}
								String imagedetail = multiparts.get(uploaddetailimagenumber).getString("UTF-8");
								article.getVectorimages().add(new Images(0, setimagearticler, imagedetail));
								// images.setImageName(setimagearticler);
								// images.setImageDetail(imagedetail);
								addArticelManager.addImages(article);
								i += 2;
								j += 2;
								imagenumber++;
							}
						}
					}
				}
			} catch (Exception ex) {
				request.setAttribute("notification", "File Upload Failed due to " + ex);
				ex.printStackTrace();
			}
		} else {
			request.setAttribute("notification", "Sorry this Servlet only handles file upload request");
		}

		session.setAttribute("login", login);
		request.setAttribute("article", article);
		goTo("/index.jsp", request, response);
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
