package com.pongyeang.admin_viewmemberdetail;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class ViewMemberDetailManager {
	public Login getViewMember(String ownerID) {
		Login listmembers = new Login();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select owner.ownerID, owner.ownerFirstname, owner.ownerLastname, owner.idcard, "
				+ "owner.birthday,owner.phone, owner.email, owner.statusapprove, "
				+ "login.username, login.password from login join owner on(login.username = owner.username)"
				+ "where owner.ownerID = ? ;";
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, ownerID);
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

	public void editNewMember(String ownerID) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "update owner set statusapprove =  2 where ownerID =? ;";
			try {
				cstmt = conn.prepareCall(sql);
				cstmt.setString(1, ownerID);
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
	}
	
	
	public void getSendingEmail(Login listmember) throws AddressException, MessagingException {
		String userfrom = "spie555spie@gmail.com";
		String passwordfrom = "spice053578712";
		String title = "pongyenag_travel";
		String url ="http://localhost:8096/pongyeangs/index.jsp";
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
			if (listmember.getOwner().getStatusapprove() == 0) {
				msg.setText("สมาชิกใหม่");
			} else if (listmember.getOwner().getStatusapprove() == 1) {
				msg.setText("สมัครสมาชิกเป็นใหม่ของเว็บไซต์ Pongyeang" + "\n" + "สวัสดีครับ/สวัสดีค่ะ,คุณ"
						+ listmember.getOwner().getOwnerFirstname() + " " + listmember.getOwner().getOwnerzLastname() + "\n"
						+ "ชื่อผู้ใช้งาน :" + listmember.getOwner().getEmail() + "\n" + "รหัสผ่าน :" + listmember.getPassword() + "\n"
						+ "สถานะการใช้งาน : สมาชิกไม่ได้ออนไลน์"
						+"กลับไปยังหน้าเว็บไซต์"+"\n"
						+url);
			} else if (listmember.getOwner().getStatusapprove() == 2) {		
				msg.setText("สมัครสมาชิกเป็นใหม่ของเว็บไซต์ Pongyeang" + "\n" + "สวัสดีครับ/สวัสดีค่ะ,คุณ"
						+ listmember.getOwner().getOwnerFirstname() + " " + listmember.getOwner().getOwnerzLastname() + "\n"
						+ "ชื่อผู้ใช้งาน :" + listmember.getOwner().getEmail() + "\n" + "รหัสผ่าน :" + listmember.getPassword() + "\n"
						+ "สถานะการใช้งาน : สมาชิกออนไลน์"+"\n"
						+"กลับไปยังหน้าเว็บไซต์"+"\n"
						+url);
				
			}
			msg.setFrom(new InternetAddress(userfrom));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(listmember.getOwner().getEmail()));
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
