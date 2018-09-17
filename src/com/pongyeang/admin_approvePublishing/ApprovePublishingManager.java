package com.pongyeang.admin_approvePublishing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pongyeang.utilities.ExceptionUtil;
import com.pongyeang.utilities.MySQLConnectionPool;

public class ApprovePublishingManager {

	public void editUpdateApprove(String addressID, String approve) {
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "UPDATE address set statusapproved = ? where addressID= ? ;";
		try {
			/*
			ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			การเปลี่ยนแปลงข้อมูลอัตโนมัต
			*/
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, approve);
			stmt.setString(2, addressID);
			stmt.executeUpdate();
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
				stmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
	}
}
