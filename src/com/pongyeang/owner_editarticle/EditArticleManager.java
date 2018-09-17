package com.pongyeang.owner_editarticle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class EditArticleManager {

	public Vector<Images> getImgListArticle(Article article) {
		Vector<Images> listimg = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select imageID,imageName,imageDetail,statusImage from image where articleID = ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, article.getArticleID());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Images img = new Images();
				img.setImageID(rs.getInt(1));
				img.setImageName(rs.getString(2));
				img.setImageDetail(rs.getString(3));
				img.setStatusimage(rs.getInt(4));
				listimg.add(img);
			}
			rs.close();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return listimg;
	}

	public void editImages(Article article) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call owner_editarticle_Images( ? , ? , ? );";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัติ
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			for (Images images : article.getVectorimages()) {
				cstmt.setInt(1, images.getImageID());
				cstmt.setString(2, images.getImageName());
				cstmt.setString(3, images.getImageDetail());
			}
			cstmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
	}

	public void addImages(Article article) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call owner_addarticle_Images( ? , ? , ? );";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัติ
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			for (Images images : article.getVectorimages()) {
				cstmt.setString(1, images.getImageName());
				cstmt.setString(2, images.getImageDetail());
				cstmt.setInt(3, article.getArticleID());
			}
			cstmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
	}

	public void editArticle(Login login, Article article) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call owner_editarticle(?,?,?,?,?,?,?)";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัติ
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, article.getArticleID());
			cstmt.setString(2, article.getArticleName());
			cstmt.setString(3, article.getArticleDetail());
			cstmt.setString(4, article.getArticleTitel());
			cstmt.setString(5, article.getCountactus());
			cstmt.setString(6, article.getAmenities());
			cstmt.setInt(7, article.getStatisticsvisit());
			cstmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
	}

	public void getEditTravelDetailArticle(Login login, Article article) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call owner_editarticle_TravelDetail(?,?,?,?,?,?)";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัติ
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, article.getArticleName());
			cstmt.setString(2, article.getArticleDetail());
			cstmt.setString(3, article.getArticleTitel());
			cstmt.setString(4, article.getCountactus());
			cstmt.setString(5, article.getAmenities());
			cstmt.setInt(6, article.getStatisticsvisit());
			cstmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
	}

	public void getEditRestaurantsDetailArticle(Login login, Article article) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call owner_editarticle_RestaurantsDetail(?,?,?,?,?,?)";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัติ
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, article.getArticleName());
			cstmt.setString(2, article.getArticleDetail());
			cstmt.setString(3, article.getArticleTitel());
			cstmt.setString(4, article.getCountactus());
			cstmt.setString(5, article.getAmenities());
			cstmt.setInt(6, article.getStatisticsvisit());
			cstmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
	}

	public Article getArticleDetail(String articleID) {
		Article article = new Article();
		Vector<Images> listimages = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt_article = null;
		PreparedStatement stmt_image = null;

		String sql_article = "select article.articleID,article.articleName,article.articleTitel,article.articleDetail,"
				+ "article.datecreate,article.contactus,article.amenities,article.statisticsvisit from article "
				+ "where  article.articleID = ? ;";
		String sql_image = "select image.imageID,image.imageName,image.imageDetail from image where image.articleID = ? ;";
		try {
			stmt_article = conn.prepareStatement(sql_article);
			stmt_article.setString(1, articleID);
			ResultSet rs = stmt_article.executeQuery();
			if (rs.next()) {
				article.setArticleID(rs.getInt(1));
				article.setArticleName(rs.getString(2));
				article.setArticleTitel(rs.getString(3));
				article.setArticleDetail(rs.getString(4));
				article.setDatecreate(rs.getString(5));
				article.setCountactus(rs.getString(6));
				article.setAmenities(rs.getString(7));
				article.setStatisticsvisit(rs.getInt(8));

				stmt_image = conn.prepareStatement(sql_image);
				stmt_image.setString(1, articleID);
				ResultSet rs1 = stmt_image.executeQuery();
				while (rs1.next()) {
					Images images = new Images();
					images.setImageID(rs1.getInt(1));
					images.setImageName(rs1.getString(2));
					images.setImageDetail(rs1.getString(3));
					listimages.add(images);
				}
				rs1.close();
				article.setVectorimages(listimages);
			}
			rs.close();
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmt_article.close();
				stmt_image.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return article;

	}

}
