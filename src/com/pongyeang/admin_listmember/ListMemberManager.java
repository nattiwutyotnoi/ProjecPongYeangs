package com.pongyeang.admin_listmember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class ListMemberManager {

	private int noOfRecords;


	/**
	 * เมธอดสำหรับแสดงสมาชิกทั้งคน
	 */
	public Vector<Login> geListMember() {		
		Login login = new Login();
		Vector<Login> vectorlistmember = new Vector<>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;	
		String sql = "select owner.ownerID, owner.ownerFirstname, owner.ownerLastname, owner.idcard, "
				+ "owner.birthday,owner.phone, owner.email, owner.statusapprove, "
				+ "login.username, login.password from login join owner on(login.username = owner.username);";
			try {
				stmt = conn.prepareStatement(sql);			
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Login logins = new Login();
					logins.getOwner().setOwnerID(rs.getInt(1));
					logins.getOwner().setOwnerFirstname(rs.getString(2));
					logins.getOwner().setOwnerzLastname(rs.getString(3));
					logins.getOwner().setIdcard(rs.getString(4));
					logins.getOwner().setBithday(rs.getString(5));
					logins.getOwner().setPhone(rs.getString(6));
					logins.getOwner().setEmail(rs.getString(7));
					logins.getOwner().setStatusapprove(rs.getInt(8));
					logins.setUsername(rs.getString(9));
					logins.setPassword(rs.getString(10));
					vectorlistmember.add(logins);
				}
				rs.close();
			}catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			} finally {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException ex) {
					ExceptionUtil.messageException(new Throwable(), ex);
				}
			}

		return vectorlistmember;
	}

	/**
	 * เมธอดสำหรับแสดงสมาชิกที่เป็นสมาชิกใหม่ทั้งหมด
	 */
	public Vector<Login> geListAllNewMember() {
		Vector<Login> vectorlistmember = new Vector<>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select SQL_CALC_FOUND_ROWS owner.ownerID, owner.ownerFirstname, owner.ownerLastname, owner.idcard, "
				+ "owner.birthday,owner.phone, owner.email, owner.statusapprove, "
				+ "login.username, login.password from login join owner on(login.username = owner.username)"
				+ "where owner.statusapprove = 0;";
			try {
				stmt = conn.prepareStatement(sql);			
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Login logins = new Login();
					logins.getOwner().setOwnerID(rs.getInt(1));
					logins.getOwner().setOwnerFirstname(rs.getString(2));
					logins.getOwner().setOwnerzLastname(rs.getString(3));
					logins.getOwner().setIdcard(rs.getString(4));
					logins.getOwner().setBithday(rs.getString(5));
					logins.getOwner().setPhone(rs.getString(6));
					logins.getOwner().setEmail(rs.getString(7));
					logins.getOwner().setStatusapprove(rs.getInt(8));
					logins.setUsername(rs.getString(9));
					logins.setPassword(rs.getString(10));
					vectorlistmember.add(logins);
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


		return vectorlistmember;
	}

	/**
	 * เมธอดสำหรับแสดงสมาชิกทั้งหมด
	 */
	public Vector<Login> getListAllMember(int offset, int noOfRecords,int statusapproves) {
		Vector<Login> vectorlistmember = new Vector<>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select  SQL_CALC_FOUND_ROWS owner.ownerID, owner.ownerFirstname, owner.ownerLastname, owner.idcard, "
				+ "owner.birthday,owner.phone, owner.email, owner.statusapprove,"
				+ "login.username, login.password from login join owner on(login.username = owner.username) "
				+ "where statusapprove = ? limit ? , ? " ;
		try {				
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, statusapproves);
			stmt.setInt(2, offset);
			stmt.setInt(3, noOfRecords);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Login logins = new Login();
				logins.getOwner().setOwnerID(rs.getInt(1));
				logins.getOwner().setOwnerFirstname(rs.getString(2));
				logins.getOwner().setOwnerzLastname(rs.getString(3));
				logins.getOwner().setIdcard(rs.getString(4));
				logins.getOwner().setBithday(rs.getString(5));
				logins.getOwner().setPhone(rs.getString(6));
				logins.getOwner().setEmail(rs.getString(7));
				logins.getOwner().setStatusapprove(rs.getInt(8));
				logins.setUsername(rs.getString(9));
				logins.setPassword(rs.getString(10));
				vectorlistmember.add(logins);
			}
			rs.close();		
			rs= stmt.executeQuery("SELECT FOUND_ROWS()");
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
		return vectorlistmember;
	}

	public int getNoOfRecords() {
		return noOfRecords;
	}

	
	/**
	 * เมธอดสำหรับแสดงสมาชิกทั้งหมด
	 */
	public Vector<Login> getListAllEmployees(int offset, int noOfRecords) {
		Vector<Login> vectorlistmember = new Vector<>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;	
		String sql = "select  SQL_CALC_FOUND_ROWS owner.ownerID, owner.ownerFirstname, owner.ownerLastname, owner.idcard, "
				+ "owner.birthday,owner.phone, owner.email, owner.statusapprove,"
				+ "login.username, login.password from login join owner on(login.username = owner.username)  "
				+ "group by owner.ownerID DESC limit ? , ? ";
		try {			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, offset);
			stmt.setInt(2, noOfRecords);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Login logins = new Login();
				logins.getOwner().setOwnerID(rs.getInt(1));
				logins.getOwner().setOwnerFirstname(rs.getString(2));
				logins.getOwner().setOwnerzLastname(rs.getString(3));
				logins.getOwner().setIdcard(rs.getString(4));
				logins.getOwner().setBithday(rs.getString(5));
				logins.getOwner().setPhone(rs.getString(6));
				logins.getOwner().setEmail(rs.getString(7));
				logins.getOwner().setStatusapprove(rs.getInt(8));
				logins.setUsername(rs.getString(9));
				logins.setPassword(rs.getString(10));
				vectorlistmember.add(logins);
			}
			rs.close();

			rs= stmt.executeQuery("SELECT FOUND_ROWS()");
			if (rs.next())
				this.noOfRecords = rs.getInt(1);
			if (stmt != null)
				stmt.close();
		}catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return vectorlistmember;
	}
	
}
