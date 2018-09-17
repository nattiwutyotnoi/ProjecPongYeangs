package com.pongyeang.listArticle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class ListArticleManager {
	private int noOfRecords;

	public Vector<Article> getListArticle(int offset, int noOfRecords) {
		Vector<Article> listA = new Vector<Article>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select SQL_CALC_FOUND_ROWS articleID,articleName,articleDetail,articleTitel,"
				+ "contactus,date_format(article.datecreate,'%d/%m/%Y'),statisticsvisit,amenities from article limit ? , ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, offset);
			stmt.setInt(2, noOfRecords);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Article ar = new Article();
				ar.setArticleID(rs.getInt(1));
				ar.setArticleName(rs.getString(2));
				ar.setArticleDetail(rs.getString(3));
				ar.setArticleTitel(rs.getString(4));
				ar.setCountactus(rs.getString(5));
				ar.setDatecreate(rs.getString(6));
				ar.setStatisticsvisit(rs.getInt(7));
				ar.setAmenities(rs.getString(8));
				ar.setVectorimages(this.getImgListArticle(ar.getArticleID()));
				listA.add(ar);
			}
			rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if (rs.next())
				this.noOfRecords = rs.getInt(1);
			if (stmt != null)
				stmt.close();
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
		return listA;
	}

	public Vector<Images> getImgListArticle(int z) {
		Vector<Images> listimg = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select imageID,imageName,imageDetail from image where articleID= ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, z);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Images img = new Images();
				img.setImageID(rs.getInt(1));
				img.setImageName(rs.getString(2));
				img.setImageDetail(rs.getString(3));
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

	public int getNoOfRecords() {
		return noOfRecords;
	}
}
