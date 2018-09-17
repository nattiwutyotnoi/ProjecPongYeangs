package com.pongyeang.owner_register;

import java.sql.*;
import java.util.*;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class RegisterManager {
	private Login login = new Login();

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public int getMaxOwnerID() {
		int ownernumber = 1;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select max(ownerID) from owner;";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ownernumber = rs.getInt(1) + 1;
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

		return ownernumber;
	}

	public int getMaxAddressID() {
		int addressnumber = 1;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select max(addressID) from address;";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				addressnumber = rs.getInt(1) + 1;
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
		return addressnumber;
	}

	public Login addRegister(Login login) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		CallableStatement cstmtowner = null;

		String sql_insertlogin = "insert into login values( ? , ? , ? ) ;";
		String sql_insertowner = "call insertOwner(?,?,?,?,?,?,?,?)";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัติ
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql_insertlogin);
			cstmt.setString(1, login.getUsername());
			cstmt.setString(2, login.getPassword());
			cstmt.setInt(3, 2);
			cstmt.executeUpdate();

			cstmtowner = conn.prepareCall(sql_insertowner);
			cstmtowner.setInt(1, login.getOwner().getOwnerID());
			cstmtowner.setString(2, login.getOwner().getOwnerFirstname());
			cstmtowner.setString(3, login.getOwner().getOwnerzLastname());
			cstmtowner.setString(4, login.getOwner().getIdcard());
			cstmtowner.setString(5, login.getOwner().getBithday());
			cstmtowner.setString(6, login.getOwner().getPhone());
			cstmtowner.setString(7, login.getOwner().getEmail());
			cstmtowner.setString(8, login.getUsername());
			cstmtowner.executeUpdate();

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
				cstmtowner.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return login;
	};
}
