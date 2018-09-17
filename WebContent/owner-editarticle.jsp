<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="java.util.*"%>
<%@page import="com.pongyeang.bean.*"%>
<%@page import="com.pongyeang.listVillageCategory.*"%>
<%@page import="com.pongyeang.owner_createprbusinessandtravel.*"%>
<%
	Article article = (Article) session.getAttribute("article");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Article</title>
</head>
<body>
	<!-- Begin HEADER -->
	<%@include file="pages/header-menu.jsp"%>
	<!-- End HEADER -->
	<%
		if (session.getAttribute("article") != null) {
	%>
	<!-- === BEGIN CONTENT === -->
	<div id="content" class="container">
		<div class="row margin-vert-30">
			<!-- Register Box -->
			<div class="col-md-9 col-md-offset-2">
				<form class="signup-page" action="EditArticleServlet" method="post"
					name="editarticle" enctype="multipart/form-data">
					<div class="signup-header">
						<h2>แก้ไขบทความ</h2>
					</div>
					<hr>
					<p>
					<h3>ข้อมูลบทความ</h3>
					</p>
					<div class="row">
						<div class="col-sm-6">
							<label>ชื่อบทความ<span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text"
								name="articleName" id="articleName"
								value="<%=article.getArticleName()%>">
						</div>
						<div class="col-sm-6">
							<label>คำเกริ่นนำ <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text"
								name="articleTitel" id="articleTitel"
								value="<%=article.getArticleTitel()%>">
						</div>
					</div>
					<label>เนื้อหาบทความ<span class="color-red">*</span></label>
					<textarea class="form-control margin-bottom-20"
						name="articleDetail" id="articleDetail"><%=article.getArticleDetail()%></textarea>
					<label>สิ่งอำนวยความสะดวก <span class="color-red">*</span>
					</label>
					<textarea class="form-control margin-bottom-20" name="amenities"
						id="amenities"><%=article.getAmenities()%></textarea>
					<hr>
					<p>
					<h3>ติดต่อ</h3>
					</p>
					<label>ติดต่อสอบถามเพิ่มเติม<span class="color-red">*</span></label>
					<textarea class="form-control margin-bottom-20" type="text"
						name="contactus" id="contactus"><%=article.getCountactus()%></textarea>
					<hr>
					<p>
					<h3>รูปภาพ</h3>
					</p>
					<div class="container1">
						<%
							for (int i = 0; i < article.getVectorimages().size(); i++) {
						%>
						<div class="removeimage" id="removeimage">
							<div class="row">
								<div class="col-md-6">
									<img alt="<%=article.getVectorimages().get(i).getImageName()%>"
										src="Tools/images/article/<%=article.getVectorimages().get(i).getImageName()%>"
										style="width: 470px; height: 250px;" class="img-thumbnail">

								</div>
								<div class="col-md-6">
									<label>รูปภาพ <span class="color-red">*</span></label> <input
										class="form-control margin-bottom-20" type="file"
										name="image[]" id="image"
										value="<%=article.getVectorimages().get(i).getImageName()%>">
									<input type="hidden" name="hiddemimage"
										value="<%=article.getVectorimages().get(i).getImageName()%>" />
									<label>คำอธิบายรูปภาพ<span class="color-red">*</span></label>
									<textarea class="form-control margin-bottom-20" rows="3"
										name="imagedetail[]" id="imagedetail"><%=article.getVectorimages().get(i).getImageDetail()%></textarea>
									<a
										href="DeleteImageEditArticleServlet?imageID=<%=article.getVectorimages().get(i).getImageID()%>
							&&imageName=<%=article.getVectorimages().get(i).getImageName()%>
							&&articleID=<%=article.getArticleID()%>"
										" class="remove btn btn-danger" id="remove"
										Onclick="return removeElement(editarticle)">Delete</a>
								</div>
							</div>
						</div>
						<br>
						<%
							}
						%>
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
								<button class="btn btn-success" type="submit">ตกลง</button>
								<button class="btn btn-danger" type="reset">ยกเลิก</button>
							</div>
						</center>
					</div>
				</form>
			</div>
			<!-- End Register Box -->
		</div>
	</div>
	<!-- === END CONTENT === -->
	<%
		} else {
	%>
	<%@include file="pages/pages-404.jsp"%>
	<%
		}
	%>
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
						var min_fields = 0;
						var wrapper = $(".container1");
						var add_button = $(".add_form_field");
						var x = 1;
						<%for (int i = 0; i < article.getVectorimages().size(); i++) {%>
							min_fields = 	<%=article.getVectorimages().size()%>
						<%}%>
						var all_fileds = max_fields - min_fields; 
						$(add_button)
								.click(
										function(e) {
											e.preventDefault();
											if (x <= all_fileds) {
												x++;
												// add input box
												$(wrapper)
														.append(
																'<div><label>รูปภาพ<span class="color-red">*'
																		+ '</span></label> <input class="form-control margin-bottom-20" type="file" name="image[]" id="image"> '
																		+ '<input type="hidden" name="hiddemimage" value="" />'
																		+ '<label>คำอธิบายรูปภาพ<span class="color-red">*</span></label> '
																		+ '<textarea class="form-control margin-bottom-20" rows="3" name="imagedetail[]" id="imagedetail">-</textarea>'
																		+ '<a href="#" class="delete btn btn-danger">Delete</a></div>');
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
<script language=javascript>
	function removeElement(editpr) {
		// Removes an element from the document
		var element = document.getElementById('removeimage');
		element.parentNode.removeChild(element);
	}
</script>
<!-- End Edit image -->
</html>