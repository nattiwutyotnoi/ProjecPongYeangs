package com.pongyeang.owner_login;

import java.sql.*;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.pongyeang.bean.*;
import com.pongyeang.utilities.*;

public class LoginManager {

	public int getLogin(String username,String password) throws SQLException {	
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select  username,password,status From login where username = ?";
		try {		
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() && password.equals(rs.getString(2))) {
				Login login = new Login();
				login.setUsername(rs.getString(1));
				login.setPassword(rs.getString(2));
				return rs.getInt(3);
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
		return 0;
	}

	public Login getOwnerUsername(String username) {
		Login login = new Login();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement stmt = null;
		String sql = "select ownerID,ownerFirstname,ownerLastname,"
				+ "statusapprove,login.username from owner owner "
				+ "join login login on owner.username = login.username where owner.email = ? ;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {	
				login.getOwner().setOwnerID(rs.getInt(1));
				login.getOwner().setOwnerFirstname(rs.getString(2));
				login.getOwner().setOwnerzLastname(rs.getString(3));
				login.getOwner().setStatusapprove(rs.getInt(4));
				login.setUsername(rs.getString(5));
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

	public void editUpdateNewMember(String recipientname, String recipientpassword) {
		Connection conn = MySQLConnectionPool.getConnection();
		CallableStatement cstmt = null;
		String sql = "update login set password =  ?  where username = ? ;";
		try {
			cstmt =conn.prepareCall(sql);
			cstmt.setString(1, recipientpassword);
			cstmt.setString(2, recipientname);
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

	public void getSendingEmail(String recipientname, String messagetext, String recipientpassword)
			throws AddressException, MessagingException {
		String userfrom = "spie555spie@gmail.com";
		String passwordfrom = "spice053578712";
		String title = "pongyenag_travel";

		try {
			Properties props = new Properties();
			props.setProperty("mail.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.starttls.enable", "true");

			Authenticator auth = new SMTPAuthenticator(userfrom, passwordfrom);

			Session session = Session.getInstance(props, auth);

			MimeMessage msg = new MimeMessage(session);
			msg.setSubject("สมาชิกลืมรหัสผ่าน");
			msg.setText("อีเมล์ : " + recipientname + "\n" + "รหัสผ่านใหม่: " + recipientpassword + "\n" + "หมายเหตุ: "
					+ messagetext + "\n" + "กลับไปยังหน้าเว็บไซต์" + "\n"
					+ "http://localhost:8096/pongyeangs/index.jsp");

			msg.setFrom(new InternetAddress(userfrom));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientname));

			// Send message
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

	public void getEmail(String to, String from, String userName, String password, Properties props, String subject,
			String messageBody) throws MessagingException {
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(messageBody, "text/html");
		MimeMultipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setContent(multipart);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Have You got Mail!");
			message.setText(messageBody, "UTF-8", "html");
			Transport.send(message);
		} catch (MessagingException ex) {
			System.out.println(ex);
		}
	}
}
