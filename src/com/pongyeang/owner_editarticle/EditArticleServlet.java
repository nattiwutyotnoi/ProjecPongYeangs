package com.pongyeang.owner_editarticle;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

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

import com.pongyeang.bean.Article;
import com.pongyeang.bean.Images;
import com.pongyeang.bean.Login;
import com.pongyeang.owner_addarticle.AddArticelManager;
import com.pongyeang.owner_viewarticle.OwnerViewArtcleManager;

/**
 * Servlet implementation class EditArticleServlet
 */
@WebServlet("/EditArticleServlet")
public class EditArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<FileItem> multiparts;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditArticleServlet() {
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
		EditArticleManager editArticleManager = new EditArticleManager();
		String articleID = request.getParameter("articleID");
		Article article = editArticleManager.getArticleDetail(articleID);
		session.setAttribute("article", article);
		goTo("/owner-editarticle.jsp", request, response);
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
		Article article = (Article) session.getAttribute("article");
		EditArticleManager editArticleManager = new EditArticleManager();

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

				article.setArticleID(article.getArticleID());
				article.setArticleName(articleName);
				article.setArticleTitel(articleTitel);
				article.setArticleDetail(articleDetail);
				article.setAmenities(amenities);
				article.setCountactus(contactus);
				article.setStatisticsvisit(article.getStatisticsvisit());

				Vector<Images> listImage = editArticleManager.getImgListArticle(article);

				int i = 0;
				int j = 0;
				int h = 0;
				int imagenumber = 0;
				int multipartscheck = multiparts.size();
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						for (int s = 0; s < listImage.size(); s++) {
							String targetPathImageArticle = getServletContext().getRealPath("/Tools/images/article");
							File createRrPath = new File(targetPathImageArticle);
							if (!createRrPath.exists()) {
								createRrPath.mkdirs();
							}
							if (ServletFileUpload.isMultipartContent(request)) {
								int uploadimagesnumber = 5 + i;
								int uploaddetailimagenumber = 7 + j;
								int hidden = 6 + h;
								if (uploadimagesnumber < multipartscheck) {
									
									String articelpicture = new File(multiparts.get(uploadimagesnumber).getName()).getName();
									String imagedetail = multiparts.get(uploaddetailimagenumber).getString("UTF-8");
									String hiddenimage = multiparts.get(hidden).getString("UTF-8");
									String imagearticler = "";
									
									if (!articelpicture.equals("") && !hiddenimage.equals("")) {										
										if(listImage.get(s).getStatusimage() == 1){													
											String deleteimagearticler = listImage.get(s).getImageName();
											File filedelete = new File(targetPathImageArticle + "/" + deleteimagearticler);
											filedelete.delete();		
											
										imagearticler = new File("article_OwnerID"+login.getOwner().getOwnerID()+"_" + (imagenumber + 1) + "_"
												+ multiparts.get(uploadimagesnumber).getName()).getName();
										String[] subimagearticler = imagearticler.split("\\.");
										String getimagearticler = subimagearticler[0];
										String setimagearticler = getimagearticler+".jpg";
										
										multiparts.get(uploadimagesnumber).write(
												new File(targetPathImageArticle + File.separator + setimagearticler));
										article.getVectorimages().add(new Images(listImage.get(s).getImageID(), setimagearticler, imagedetail));
										editArticleManager.editImages(article);
										}else{
											
											imagearticler = new File("article_OwnerID"+login.getOwner().getOwnerID()+"_" + (imagenumber + 1) + "_"+multiparts.get(uploadimagesnumber).getName())
													.getName();
											String[] subimagearticler = imagearticler.split("\\.");
											String getimagearticler = subimagearticler[0];
											String setimagearticler = getimagearticler+".jpg";
											multiparts.get(uploadimagesnumber)
													.write(new File(targetPathImageArticle + File.separator + setimagearticler));
											article.getVectorimages().add(new Images(0, setimagearticler, imagedetail));
											editArticleManager.addImages(article);
										}
									}else if (hiddenimage.equals("")) {
										imagearticler = new File("article_OwnerID"+login.getOwner().getOwnerID()+"_" + (imagenumber + 1) + "_"+multiparts.get(uploadimagesnumber).getName())
												.getName();
										String[] subimagearticler = imagearticler.split("\\.");
										String getimagearticler = subimagearticler[0];
										String setimagearticler = getimagearticler+".jpg";
										multiparts.get(uploadimagesnumber)
												.write(new File(targetPathImageArticle + File.separator + setimagearticler));
										article.getVectorimages().add(new Images(0, setimagearticler, imagedetail));
										editArticleManager.addImages(article);
									} else if (!imagedetail.equalsIgnoreCase("")) {
										imagearticler = listImage.get(s).getImageName();	
										article.getVectorimages().add(new Images(listImage.get(s).getImageID(), imagearticler, imagedetail));
										editArticleManager.editImages(article);
									} else {
										imagearticler = listImage.get(s).getImageName();		
										imagedetail =  listImage.get(s).getImageDetail();
										article.getVectorimages().add(new Images(listImage.get(s).getImageID(), imagearticler, imagedetail));
										editArticleManager.editImages(article);
									}
									
									i  += 3;
									j  += 3;
									h +=3;
									imagenumber++;
								}
							}
						}
					}
				}
				editArticleManager.editArticle(login, article);

			} catch (Exception ex) {
				request.setAttribute("notification", "File Upload Failed due to " + ex);
				ex.printStackTrace();
			}
		} else {
			request.setAttribute("notification", "Sorry this Servlet only handles file upload request");
		}

		session.setAttribute("login", login);
		goTo("/OwnerListArticleServlet", request, response);
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
