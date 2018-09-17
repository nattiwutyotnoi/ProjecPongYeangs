<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String warming = (String) request.getAttribute("warming");
	if (warming != null) {
		request.removeAttribute(warming);
%>
<script language="javascript">
				alert("<%=warming%>");
</script>
<%
	}
%>
<html>
<head>
<!-- Title -->
<title>Login</title>
<!-- Meta -->
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
</head>
<script type="text/javascript">
	function validate() {
		var username = document.forms["login"]["username"].value;
		var password = document.forms["login"]["password"].value;

		if (username == "") {
			alert("กรุณากรอก ชื่อผู้ใช้ ด้วยครับ/ค่ะ");
			login.username.focus();
			return false;
		}
		if (password == "") {
			alert("กรุณากรอก รหัสผ่าน ด้วยครับ/ค่ะ");
			login.password.focus();
			return false;
		}
	}
</script>
<body>
	<!-- Begin HEADER -->
	<%@include file="pages/header-menu.jsp"%>
	<!-- End HEADER -->
	<!-- === BEGIN CONTENT === -->
	<div id="content" class="container">
		<div class="container">
			<div class="row margin-vert-30">
				<!-- Login Box -->
				<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
					<form class="login-page" name="login" action="LoginServlet"
						method="post" name="login">
						<div class="login-header margin-bottom-30">
							<h2>เข้าสู่ระบบ</h2>
						</div>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"><i class="fa fa-user"></i></span>
							<input placeholder="Username" class="form-control" type="text"
								name="username" id="username">
						</div>
						<div class="input-group margin-bottom-20">
							<span class="input-group-addon"><i class="fa fa-lock"></i></span>
							<input placeholder="Password" class="form-control"
								type="password" name="password" id="password">
						</div>
						<div class="row">
							<div class="col-md-12">
								<button class="btn btn-primary pull-right" type="submit"
									onclick="return validate()">เข้าสู่ระบบ</button>
							</div>
						</div>
						<hr>
						<h4></h4>
						<p>
							<a href="#" data-toggle="modal" data-target="#exampleModal"
								data-whatever="@getbootstrap"><h4>ลืมรหัสผ่าน?</h4></a>
						</p>
						
					</form>
				</div>
				<!-- End Login Box -->
			</div>
		</div>
	</div>
	<!-- === END CONTENT === -->
			<form action="ForgetPasswordServlet" method="POST">
					<div class="modal fade" id="exampleModal" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="exampleModalLabel">ลืมรหัสผ่าน</h4>
									</div>
									
										<div class="modal-body">										
												<div class="form-group">
													<label for="recipient-name" class="control-label">อีเมล์</label>
													<input type="text" class="form-control" id="recipientname" name="recipientname">
												</div>
												<div class="form-group">
													<label for="recipient-name" class="control-label">รหัสผ่านใหม่</label>
													<input type="text" class="form-control" id="recipientpassword" name="recipientpassword">
												</div>
												<div class="form-group">
													<label for="message-text" class="control-label">***หมายเหตุ</label>
													<textarea class="form-control" id="messagetext" name="messagetext"></textarea>
												</div>									
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-danger "
												data-dismiss="modal">ยกเลิก</button>
												<input type="submit" value="ส่งอีเมล์" class="btn btn-success" >
										</div>
								
								</div>
							</div>
						</div>
					</form>
	<!-- Begin Footer -->
	<%@include file="pages/footer-menu.jsp"%>
	<!-- End Footer -->
</body>
</html>