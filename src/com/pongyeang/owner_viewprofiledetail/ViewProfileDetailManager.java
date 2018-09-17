package com.pongyeang.owner_viewprofiledetail;

import java.sql.*;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class ViewProfileDetailManager {

	public Login getViewProfileDetail(Login login) {
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select ownerID,ownerFirstname,ownerLastname,idcard,birthday,phone,email,login.username,login.password "
				+ "from owner inner join login on(owner.username=login.username) "
				+ "where ownerID = ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, login.getOwner().getOwnerID());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				login.getOwner().setOwnerID(rs.getInt(1));
				login.getOwner().setOwnerFirstname(rs.getString(2));
				login.getOwner().setOwnerzLastname(rs.getString(3));
				login.getOwner().setIdcard(rs.getString(4));
				login.getOwner().setBithday(rs.getString(5));
				login.getOwner().setPhone(rs.getString(6));
				login.getOwner().setEmail(rs.getString(7));
				login.setUsername(rs.getString(8));
				login.setPassword(rs.getString(9));
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
		return login;
	}
}
