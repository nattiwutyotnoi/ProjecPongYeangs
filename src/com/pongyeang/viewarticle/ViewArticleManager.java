package com.pongyeang.viewarticle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class ViewArticleManager {
	public Article getViewArticle(String a) {
		Article viewA = new Article();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "Select articleID,articleName,articleDetail,articleTitel,contactus,"
				+ "date_format(article.datecreate,'%d/%m/%Y'),amenities,statisticsvisit from article where articleID = ? ";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, a);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				viewA.setArticleID(rs.getInt(1));
				viewA.setArticleName(rs.getString(2));
				viewA.setArticleDetail(rs.getString(3));
				viewA.setArticleTitel(rs.getString(4));
				viewA.setCountactus(rs.getString(5));
				viewA.setDatecreate(rs.getString(6));
				viewA.setAmenities(rs.getString(7));
				viewA.setStatisticsvisit(rs.getInt(8));
				viewA.setVectorimages(this.getImgListArticle(viewA.getArticleID()));
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
		return viewA;
	}

	public Vector<Images> getImgListArticle(int articleID) {
		Vector<Images> listimg = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select imageID,imageName,imageDetail from image where articleID= ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, articleID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Images img = new Images();
				img.setImageID(rs.getInt(1));
				img.setImageName(rs.getString(2));
				img.setImageDetail(rs.getString(3));
				listimg.add(img);
			}

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

	public void UpdateArticle(int id, int count) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "UPDATE article set statisticsvisit = ?  where articleID = ? ;";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัติ
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, count + 1);
			cstmt.setInt(2, id);
			cstmt.executeUpdate();
			System.out.println(count);
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
}
