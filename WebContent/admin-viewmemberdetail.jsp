<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="java.util.*"%>
<%@page import="com.pongyeang.bean.*"%>
<%@page import="com.pongyeang.admin_listmember.*"%>
<%
	Login listmember = (Login) session.getAttribute("loginowner");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Member Detail</title>
</head>
<body>
	<!-- Begin HEADER -->
	<%@include file="pages/header-menu.jsp"%>
	<!-- End HEADER -->
	<%
		if (listmember != null) {
	%>
	<!-- === BEGIN CONTENT === -->
	<div id="content" class="container">
		<div class="row margin-vert-30">
			<div class="row margin-vert-30">
				<!-- Register Box -->
				<div class="col-md-12">
					<form class="signup-page" action="EditMemberServlet" method="get">
						<div class="signup-header"></div>
						<div class="row">
							<div class="col-md-6 col-md-offset-3">
								<h2>ดูข้อมูลส่วนตัว</h2>
								<p>
								<h3>ส่วนที่ 1</h3>
								</p>
								<table class="table table-hover">
									<tr>
										<td><label>ชื่อจริง</label>
										</td>
										<td><%=listmember.getOwner().getOwnerFirstname()%></td>

									</tr>
									<tr>
										<td><label>นามสกุล </label>
										</td>
										<td><%=listmember.getOwner().getOwnerzLastname()%></td>
									</tr>
									<tr>
										<td><label>รหัสบัตรประชาชน </label></td>
										<td><%=listmember.getOwner().getIdcard()%></td>
									</tr>
									<tr>
										<td><label>วันเกิด</label></td>
										<td><%=listmember.getOwner().getBithday()%></td>
									</tr>
									<tr>
										<td><label>เบอร์โทรศัพท์ </label></label>
										</td>
										<td><%=listmember.getOwner().getPhone()%></td>
									</tr>
									<tr>
										<td><label>อีเมล์ </label></td>
										<td><%=listmember.getOwner().getEmail()%></td>
									</tr>
									<tr>
										<td><label>สถานะของสมาชิก</label></td>
										<td>
										<%if (listmember.getOwner().getStatusapprove() == 0) {%>
											<font color=#ff9900>สมาชิกใหม่</font> 
										<%} else if (listmember.getOwner().getStatusapprove() == 1) {%>
											<font color="#ff3300"> สมาชิกไม่ได้ออนไลน์</font> 
										<%} else if (listmember.getOwner().getStatusapprove() == 2) { %>
											<font color="#009900"> สมาชิกออนไลน์ </font> 
										<%} %>									
										</td>
									</tr>
									<tr>
										<td colspan="2"><h3>ส่วนที่ 2</h3></td>
									</tr>
									<tr>
										<td><label>ชื่อผู้ใข้งาน </label></td>
										<td><%=listmember.getUsername()%></td>
									<tr>
										<td><label>รหัสผ่าน</label></td>
										<td><%=listmember.getPassword()%></td>
									</tr>
									
								</table>
								<div class="row">
									<div class="col-lg-12 text-right">
										<a href="index.jsp" class="btn btn-info">ย้อนกลับ</a>
										<button class="btn btn-success" type="submit">แก้ไขข้อมูล</button>
											<%if(listmember.getOwner().getStatusapprove() == 0){ %>
											<a href="UpdateStatuMemberServlet?OwnerID=<%=listmember.getOwner().getOwnerID() %>" class="btn btn-danger" >แก้ไขเป็นสมาชิกออนไลน์</a>
										<%}else if(listmember.getOwner().getStatusapprove() == 1){ %>
											<a href="UpdateStatuMemberServlet?OwnerID=<%=listmember.getOwner().getOwnerID() %>" class="btn btn-danger" >แก้ไขเป็นสมาชิกออนไลน์</a>
										<%} else if(listmember.getOwner().getStatusapprove() == 2){ %>
											<a href="UpdateStatuMemberServlet?OwnerID=<%=listmember.getOwner().getOwnerID() %>" class="btn btn-danger" >แก้ไขเป็นสมาชิกไม่ได้ออนไลน์</a>
										<%} %>										
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- End Register Box -->
	</div>
	<!-- === END CONTENT === -->
	<%
		} else {
	%>
	<jsp:include page="pages/pages-404.jsp" />
	<%
		}
	%>
	<!-- Begin Footer -->
	<%@include file="pages/footer-menu.jsp"%>
	<!-- End Footer -->
</body>
</html>