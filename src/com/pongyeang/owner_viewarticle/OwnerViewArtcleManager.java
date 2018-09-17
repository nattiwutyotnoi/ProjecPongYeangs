package com.pongyeang.owner_viewarticle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class OwnerViewArtcleManager {

	public Article getViewArticleDetail(String articleID) {
		Article article = new Article();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt_article = null;
		PreparedStatement stmt_image = null;	
		String sql = "select article.articleID,article.articleName,article.articleTitel,article.articleDetail,"
				+ "article.datecreate,article.contactus,article.amenities,article.statisticsvisit from article "
				+ "where  article.articleID = ? ;";
		String sql1 = "select image.imageID,image.imageName,image.imageDetail from image where image.articleID = ? ;";
			try {
				stmt_article = conn.prepareStatement(sql);
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
					stmt_image = conn.prepareStatement(sql1);
					stmt_image.setString(1, articleID);			
					ResultSet rs1 = stmt_image.executeQuery();
					while (rs1.next()) {
						article.getVectorimages().add(new Images(rs1.getInt(1), rs1.getString(2), rs1.getString(3)));
					}
					rs1.close();
					stmt_image.close();
				}
				rs.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			} finally {
				try {
					stmt_article.close();			
					conn.close();
				} catch (SQLException ex) {
					ExceptionUtil.messageException(new Throwable(), ex);
				}
			}
		return article;

	}
}
