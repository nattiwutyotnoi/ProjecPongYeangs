<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="java.util.*"%>
<%@page import="com.pongyeang.bean.*"%>
<%@page import="com.pongyeang.owner_viewprofiledetail.*"%>
<%@page import="com.pongyeang.admin_listmember.*"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Profile Detail</title>
</head>
<!-- Meta -->
<meta name="description" content="">
<meta name="author"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<body>
	<!-- Begin HEADER -->
	<%@include file="pages/header-menu.jsp"%>
	<!-- End HEADER -->
	<%
		if (login != null) {
	%>
	<!-- === BEGIN CONTENT === -->
	<div id="content" class="container">
		<div class="row margin-vert-30">
			<div class="row margin-vert-30">
				<!-- Register Box -->
				<div class="col-md-12">
					<form class="signup-page" action="owner-editregisterprofile.jsp">
						<div class="signup-header"></div>
						<div class="row">
							<div class="col-md-6 col-md-offset-3">
								<h2>ดูข้อมูลส่วนตัว</h2>
								<p>
								<h3>ส่วนที่ 1</h3>
								</p>
								<table class="table table-hover">
									<tr>
										<td><label>ชื่อจริง <span class="color-red">*</span></label>
										</td>
										<td><%=login.getOwner().getOwnerFirstname()%></td>

									</tr>
									<tr>
										<td><label>นามสกุล <span class="color-red">*</span></label>
										</td>
										<td><%=login.getOwner().getOwnerzLastname()%></td>
									</tr>
									<tr>
										<td><label>รหัสบัตรประชาชน <span
												class="color-red">*</span></label></td>
										<td><%=login.getOwner().getIdcard()%></td>
									</tr>
									<tr>
										<td><label>วันเกิด <span class="color-red">*</span></td>
										<td><%=login.getOwner().getBithday()%></td>
									</tr>
									<tr>
										<td><label>เบอร์โทรศัพท์ <span class="color-red">*</span></label>
										</td>
										<td><%=login.getOwner().getPhone()%></td>
									</tr>
									<tr>
										<td><label>อีเมล์ <span class="color-red">*</span></label></td>
										<td><%=login.getOwner().getEmail()%></td>
									</tr>
									<tr>
										<td colspan="2"><h3>ส่วนที่ 2</h3></td>
									</tr>
									<tr>
										<td><label>ชื่อผู้ใข้งาน <span class="color-red">*</span></label></td>
										<td><%=login.getUsername()%></td>
									<tr>
										<td><label>รหัสผ่าน <span class="color-red">*</span></label></td>
										<td><%=login.getPassword()%></td>
									</tr>
								</table>
								<div class="row">
									<div class="col-lg-12 text-right">
										<a href="index.jsp" class="btn btn-info">ย้อนกลับ</a>
										<button class="btn btn-success" type="submit">แก้ไขข้อมูล</button>
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