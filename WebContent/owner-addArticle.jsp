<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	Owner owner = (Owner) session.getAttribute("owner");
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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Article</title>
</head>
<script type="text/javascript">
	function validate() {
		var articleName = document.forms["createpr"]["articleName"].value;
		var articleTitel = document.forms["createpr"]["articleTitel"].value;
		var articleDetail = document.forms["createpr"]["articleDetail"].value;
		var amenities = document.forms["createpr"]["amenities"].value;
		var contactus = document.forms["createpr"]["contactus"].value;

		var checharticleTitel  = 	 /^[\w\s\d]{2,500}$/;
		var checharticlearticleDetail =  /^[\w\s\d]{2,2000}$/;
		var checkarticleName =  /^[\w\s\d]{2,500}$/;
		
		if (articleName == "") {
			alert("กรุณากรอก ชื่อบทความ ด้วยครับ/ค่ะ");
			addarticle.articleName.focus();
			return false;
		}
		if(!articleName.match(checkarticleName)){
			alert("กรุณากรอกใหม่เนื่องจากจำนวนเกิน 500 ตัวอักษา ด้วยครับ/ค่ะ");
			addarticle.articleName.focus();
			return false;
		}
		if(!articleTitel.match(checharticleTitel)){
			alert("กรุณากรอกใหม่เนื่องจากจำนวนเกิน 500 ตัวอักษา ด้วยครับ/ค่ะ");
			addarticle.articleName.focus();
			return false;
		}
		if (articleTitel == "") {
			articleTitel("กรุณากรอก คำเกริ่นนำ ด้วยครับ/ค่ะ");
			addarticle.articleTitel.focus();
			return false;
		}
		if(!articleDetail.match(checharticlearticleDetail)){
			alert("กรุณากรอกใหม่เนื่องจากจำนวนเกิน 500 ตัวอักษา ด้วยครับ/ค่ะ");
			addarticle.articleName.focus();
			return false;
		}
		if (articleDetail == "") {
			alert("กรุณากรอก เนื้อหาบทความ ด้วยครับ/ค่ะ");
			addarticle.articleDetail.focus();
			return false;
		}
		if (amenities == "") {
			alert("กรุณากรอก สิ่งอำนวยความสะดวก ด้วยครับ/ค่ะ");
			addarticle.amenities.focus();
			return false;
		}
		
		if (contactus == "") {
			alert("กรุณากรอก ติดต่อสอบถามเพิ่มเติม ด้วยครับ/ค่ะ");
			addarticle.contactus.focus();
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
		<div class="row margin-vert-30">
			<!-- Register Box -->
			<div class="col-md-9 col-md-offset-2">
				<form class="signup-page" action="AddArticleServlet" method="post" enctype="multipart/form-data" id="addarticle">
					<div class="signup-header">
							<h2>สร้างบทความ</h2>
						</div>
						<hr>
						<p>
						<h3>ข้อมูลบทความ</h3>
						</p>
						<div class="row">
							<div class="col-sm-6">
								<label>ชื่อบทความ<span class="color-red">*</span></label> <input
									class="form-control margin-bottom-20" type="text"
									name="articleName" id="articleName">
							</div>
							<div class="col-sm-6">
								<label>คำเกริ่นนำ <span class="color-red">*</span></label> <input
									class="form-control margin-bottom-20" type="text"
									name="articleTitel" id="articleTitel">
							</div>
						</div>
						<label>เนื้อหาบทความ<span class="color-red">*</span></label> 	<textarea 
							class="form-control margin-bottom-20" name="articleDetail" id="articleDetail"></textarea>
							<label>สิ่งอำนวยความสะดวก
							<span class="color-red">*</span>
						</label>
						<textarea class="form-control margin-bottom-20" name="amenities" id="amenities"></textarea>
						<hr>
						<p>
						<h3>ติดต่อ</h3>
						</p>
						<label>ติดต่อสอบถามเพิ่มเติม<span class="color-red">*</span></label>
					<textarea class="form-control margin-bottom-20" type="text"
							name="contactus" id="contactus"></textarea>
						<hr>
						<p>
						<h3>รูปภาพ</h3>
						</p>
						<div class="container1">
							<label>รูปที่1 <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="file" name="image[]"
								id="image[]"> <label>คำอธิบายรูปภาพ<span
								class="color-red">*</span></label>
							<textarea class="form-control margin-bottom-20" rows="3"
								name="imagedetail[]" id="imagedetail[]">-</textarea>
						</div>
						<div class="col-lg-12 text-right">
							<button class="add_form_field btn btn-info btn-lg">
								<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							</button>
						</div>
						<hr>
						<div class="row">
							<center>
								<div class="col-lg-12">
										<button class="btn btn-success" type="submit" onclick="return validate()">ตกลง</button>
									<button class="btn btn-success" type="reset">ยกเลิก</button>
								</div>
							</center>
						</div>
				</form>
			</div>
			<!-- End Register Box -->
		</div>
	</div>
	<!-- === END CONTENT === -->

	<!-- Begin Footer -->
	<%@include file="pages/footer-menu.jsp"%>
	<!-- End Footer -->
</body>
<!-- Start AddImage -->
<script type='text/javascript'>
	$(document)
			.ready(
					function() {
						var max_fields = 10;
						var wrapper = $(".container1");
						var add_button = $(".add_form_field");
						var x = 1;
						$(add_button)
								.click(
										function(e) {
											e.preventDefault();
											if (x < max_fields) {
												x++;
												// add input box
												$(wrapper)
														.append(
																'<div><label>รูปภาพ<span class="color-red">*</span></label> <input class="form-control margin-bottom-20" type="file" name="image[]" id="image"> <label>คำอธิบายรูปภาพ<span class="color-red">*</span></label> <textarea class="form-control margin-bottom-20" rows="3" name="imagedetail[]" id="imagedetail">-</textarea><a href="#" class="delete btn btn-danger">Delete</a></div>');
											} else {
												alert('คุณสามารถอัฟโหลดรูปภาพได้ 10 รูปภาพเท่านั้น')
											}
										});

						$(wrapper).on("click", ".delete", function(e) {
							e.preventDefault();
							$(this).parent('div').remove();
							x--;
						})
					});
</script>
<!-- End AddImage -->
</html>