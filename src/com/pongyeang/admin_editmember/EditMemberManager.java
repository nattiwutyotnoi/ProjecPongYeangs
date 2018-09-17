package com.pongyeang.admin_editmember;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EditMemberManager {

	private Login login = new Login();
	
		public Login getLogin() {
		return this.login;
	}

	public void editMember(Login login) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "call admin_editmember(?,?,?,?,?,?,?,?,?)";
		try {
			/*
			 * ปิดฟังก์ชัน Auto Commit ใน Database เพื่อไม่ให้มี
			 * การเปลี่ยนแปลงข้อมูลอัตโนมัต
			 */
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, login.getOwner().getOwnerFirstname());
			cstmt.setString(2, login.getOwner().getOwnerzLastname());
			cstmt.setString(3, login.getOwner().getIdcard());
			cstmt.setString(4, login.getOwner().getBithday());
			cstmt.setString(5, login.getOwner().getPhone());
			cstmt.setString(6, login.getOwner().getEmail());
			cstmt.setInt(7, login.getOwner().getStatusapprove());
			cstmt.setString(8, login.getUsername());
			cstmt.setString(9, login.getPassword());
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
	};

	public Login geViewMember(Login listmember) {
		Login listmembers = new Login();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select owner.ownerID, owner.ownerFirstname, owner.ownerLastname, owner.idcard, "
				+ "owner.birthday,owner.phone, owner.email, owner.statusapprove, "
				+ "login.username, login.password from login join owner on(login.username = owner.username)"
				+ "where owner.ownerID = ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, listmember.getOwner().getOwnerID());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				listmembers.getOwner().setOwnerID(rs.getInt(1));
				listmembers.getOwner().setOwnerFirstname(rs.getString(2));
				listmembers.getOwner().setOwnerzLastname(rs.getString(3));
				listmembers.getOwner().setIdcard(rs.getString(4));
				listmembers.getOwner().setBithday(rs.getString(5));
				listmembers.getOwner().setPhone(rs.getString(6));
				listmembers.getOwner().setEmail(rs.getString(7));
				listmembers.getOwner().setStatusapprove(rs.getInt(8));

				listmembers.setUsername(rs.getString(9));
				listmembers.setPassword(rs.getString(10));
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

		return listmembers;
	}

	public void getSendingEmail(Login login) throws AddressException, MessagingException {
		String userfrom = "spie555spie@gmail.com";
		String passwordfrom = "spice053578712";
		String title = "pongyenag travel";
		String localhosturl = "http://localhost:8096/pongyeangs/index.jsp";
		try {
			Properties props = new Properties();
			props.setProperty("mail.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.starttls.enable", "true");

			Authenticator auth = new SMTPAuthenticator(userfrom, passwordfrom);

			Session session = Session.getInstance(props, auth);

			MimeMessage msg = new MimeMessage(session);
			msg.setSubject("สมัครสมาชิก Pongyang Travel");
			if (login.getOwner().getStatusapprove() == 0) {
				msg.setText("สมาชิกใหม่");
			} else if (login.getOwner().getStatusapprove() == 1) {
				msg.setText("สมัครสมาชิกเป็นใหม่ของเว็บไซต์ Pongyeang" + "\n" + "สวัสดีครับ/สวัสดีค่ะ,คุณ"
						+ login.getOwner().getOwnerFirstname() + " " + login.getOwner().getOwnerzLastname() + "\n"
						+ "ชื่อผู้ใช้งาน :" + login.getOwner().getEmail() + "\n" + "รหัสผ่าน :" + login.getPassword()
						+ "\n" + "สถานะการใช้งาน : สมาชิกไม่ได้ออนไลน์" + "\n"
						+ "บัญชีสมาชิกของคุณมีปัญหากรุณาติดต่อผู้ดูแลระบบ" + localhosturl);
			} else if (login.getOwner().getStatusapprove() == 2) {
				msg.setText("สมัครสมาชิกเป็นใหม่ของเว็บไซต์ Pongyeang" + "\n" + "สวัสดีครับ/สวัสดีค่ะ,คุณ"
						+ login.getOwner().getOwnerFirstname() + " " + login.getOwner().getOwnerzLastname() + "\n"
						+ "ชื่อผู้ใช้งาน :" + login.getOwner().getEmail() + "\n" + "รหัสผ่าน :" + login.getPassword()
						+ "\n" + "สถานะการใช้งาน : สมาชิกออนไลน์" + "\n" + localhosturl);

			}
			msg.setFrom(new InternetAddress(userfrom));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(login.getOwner().getEmail()));
			Transport.send(msg);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private class SMTPAuthenticator extends Authenticator {

		private PasswordAuthentication authentication;

		public SMTPAuthenticator(String userfrom, String passwordfrom) {
			authentication = new PasswordAuthentication(userfrom, passwordfrom);
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return authentication;
		}
	}
}
