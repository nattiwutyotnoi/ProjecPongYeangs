package com.pongyeang.owner_deletearticle;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class OwnerDeleteArticleManager {

	public void removeArticle(String articleID) {
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt_image = null;
		PreparedStatement stmt_aricle = null;

		String sql = "delete from image where image.articleID = ? ;";
		String sql1 = "delete from article where article.articleID = ? ;";
		try {
			/*
			ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			การเปลี่ยนแปลงข้อมูลอัตโนมัต
			*/
			conn.setAutoCommit(false);

			stmt_image = conn.prepareStatement(sql);
			stmt_image.setString(1, articleID);
			stmt_image.executeUpdate();	

			stmt_aricle = conn.prepareStatement(sql1);
			stmt_aricle.setString(1, articleID);
			stmt_aricle.executeUpdate();
			
			// หากไม่มีข้อผิดพลาดใดๆ เกิดขึ้น สั่งให้มีการบันทึกเปลี่ยนแปลงข้อมูลได้
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
				stmt_image.close();
				stmt_aricle.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
	}

	public Vector<Images> getImgListArticle(String article) {
		Vector<Images> listimg = new Vector<Images>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select imageID,imageName,imageDetail,statusImage from image where articleID = ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, article);
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
}
