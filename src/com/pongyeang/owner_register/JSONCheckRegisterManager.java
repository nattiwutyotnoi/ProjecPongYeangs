package com.pongyeang.owner_register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pongyeang.utilities.*;

public class JSONCheckRegisterManager {

	public boolean getAllCheckIDCard(String idcard) {
		boolean chksearch = false;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select idcard from owner where idcard = ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, idcard);
			ResultSet rs = stmt.executeQuery();
			chksearch = (rs.next());
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
		return chksearch;
	}

	public boolean getAllCheckPhone(String phone) {
		boolean chksearch = false;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select phone from owner where phone = ? ;";

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, phone);
			ResultSet rs = stmt.executeQuery();
			chksearch = (rs.next());
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
		return chksearch;
	}

	public boolean getAllCheckEmail(String email) {
		boolean chksearch = false;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select email from owner where email = ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			chksearch = (rs.next());
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
		return chksearch;
	}

}
