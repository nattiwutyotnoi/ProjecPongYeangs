<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pongyeang.bean.*"%>
<% String url = "https://b9b7b627.ngrok.io/" ;%>
<%
	SubCategoryRestaurants vrestauranrs = (SubCategoryRestaurants) session.getAttribute("listRastaurants");
int noOfPages = (int) request.getAttribute("noOfPages");
int currentPage = (int) request.getAttribute("currentPage");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<!-- Title -->
<title>Substance - Professional Bootstrap Template</title>
<!-- Meta -->
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<!-- Favicon -->
<link href="favicon.html" rel="shortcut icon">
<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="Tools/css/bootstrap.css" rel="stylesheet">
<!-- Template CSS -->
<link rel="stylesheet" href="Tools/css/animate.css" rel="stylesheet">
<link rel="stylesheet" href="Tools/css/font-awesome.css"
	rel="stylesheet">
<link rel="stylesheet" href="Tools/css/nexus.css" rel="stylesheet">
<link rel="stylesheet" href="Tools/css/responsive.css" rel="stylesheet">
<link rel="stylesheet" href="Tools/css/custom.css" rel="stylesheet">
<!-- Google Fonts-->
<link href="http://fonts.googleapis.com/css?family=Lato:400,300"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"
	rel="stylesheet" type="text/css">
</head>
<body>
	<!-- Begin HEADER -->
	<%@include file="pages/header-menu.jsp"%>
	<!-- End HEADER -->
<%
		if (vrestauranrs != null || request.getAttribute("noOfPages") != null
				|| request.getAttribute("currentPage") != null) {
	%>
	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading -->
		<div class="list-group-item" style="background-color: #228B22">
					<div class="row header1">
						<div class="col-xs-12">
							<div class="col-xs-8">
								<h2 class="font-size-20 bold">
									<font color="#FFFFFF"><%
						if (vrestauranrs.getSubcategoryrestaurantName() != null) {
					%>
					<%=vrestauranrs.getSubcategoryrestaurantName()%>
					<%
						} else {
					%>ยังไม่มีข้อมูล<%
						}
					%>
									</font>
								</h2>
							</div>
						</div>
					</div>
				</div>
		<br>
		<%try{ %>
		<!-- /.row -->
			<%for (RestaurantsDetail rv : vrestauranrs.getVectorrestaurantsdetail()) {%>
			<!-- Project One -->
			<div class="row">
				<div class="col-md-5">
					<a href="#"> <img class="img-responsive"
						src="Tools/images/pr/<%=rv.getAddress().getVectorimages().get(0).getImageName()%>"
						alt="image2" width="700px" height="400px">
					</a>
				</div>
				<div class="col-md-6">
					<h3><%=rv.getRestaurantsdetailName()%></h3>
					<h4>
						จำนวนคนเข้าชม :
						<%=rv.getStatisticsvisit()%></h4>
					<p><%=rv.getRestaurantsdetailTitel()%></p>
					<p><div class="fb-like" data-href="<%=url%>pongyeang/ViewRestaurantsandShopsDetailServlet?RestaurantsSubID=<%=rv.getRestaurantsdetailID()%>" 
					data-width="500" data-layout="standard" data-action="like" data-size="large" data-show-faces="true" data-share="true"></div></p>
					<a class="btn btn-primary"
						href="ViewRestaurantsandShopsDetailServlet?RestaurantsSubID=<%=rv.getRestaurantsdetailID()%>">อ่านต่อ
						<span class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
			</div>
			<hr>
			<%}%>
			<%}catch (Exception e){ %>
				<div class="row">
					<div class="col-lg-12">
						<h2 class="page-header">ยังไม่มีข้อมูล</h2>
					</div>
				</div>
			<%} %>	
		<!-- Pagination -->
		<div class="panel-footer">
			<div class="row">
				<div class="col col-xs-offset-3 col-xs-6">
					<nav aria-label="Page navigation" class="text-center">
					<ul class="pagination">
						<%
							if (currentPage >= 2) {
						%>
						<%
							if (currentPage == noOfPages) {
						%>
						<li><a
							href="ListRestaurantsandshopsSubCategoryServlet?RestaurantsSubID=<%=vrestauranrs.getSubcategoryrestaurantID() %>&&page=<%=currentPage - 1%>"
							aria-label="Previous"><span aria-hidden="true">«</span></a></li>
						<%
							for (int s = 0; s < noOfPages; s++) {
						%>
						<li><a href="ListRestaurantsandshopsSubCategoryServlet?RestaurantsSubID=<%=vrestauranrs.getSubcategoryrestaurantID() %>&&page=<%=s + 1%>"><span
								aria-hidden="true"><%=s + 1%></span></a></li>
						<%
							}
						%>
						<%
							} else {
						%>
						<li><a
							href="ListRestaurantsandshopsSubCategoryServlet?RestaurantsSubID=<%=vrestauranrs.getSubcategoryrestaurantID() %>&&page=<%=currentPage - 1%>"
							aria-label="Previous"><span aria-hidden="true">«</span></a></li>
						<%
							for (int s = 0; s < noOfPages; s++) {
						%>
						<li><a href="ListRestaurantsandshopsSubCategoryServlet?RestaurantsSubID=<%=vrestauranrs.getSubcategoryrestaurantID() %>&&page=<%=s + 1%>"><span
								aria-hidden="true"><%=s + 1%></span></a></li>
						<%
							}
						%>
						<li><a
							href="ListRestaurantsandshopsSubCategoryServlet?RestaurantsSubID=<%=vrestauranrs.getSubcategoryrestaurantID() %>&&page=<%=currentPage + 1%>"
							aria-label="Next"><span aria-hidden="true">»</span></a></li>

						<%
							}
						%>
						<%
							}
						%>
						<%
							if (currentPage != noOfPages) {
						%>
						<%
							if (currentPage == 1) {
						%>
						<%
							for (int s = 0; s < noOfPages; s++) {
						%>
						<li><a href="ListRestaurantsandshopsSubCategoryServlet?RestaurantsSubID=<%=vrestauranrs.getSubcategoryrestaurantID() %>&&page=<%=s + 1%>"><span
								aria-hidden="true"><%=s + 1%></span></a></li>
						<%
							}
						%>
						<li><a
							href="ListRestaurantsandshopsSubCategoryServlet?RestaurantsSubID=<%=vrestauranrs.getSubcategoryrestaurantID() %>&&page=<%=currentPage + 1%>"
							aria-label="Next"><span aria-hidden="true">»</span></a></li>
						<%
							}
						%>
						<%
							}
						%>
					</ul>
					</nav>
				</div>
			</div>
		</div>
		<!-- /.row -->

		<hr>

	</div>
	<!-- /.container -->
		<%
      		} else {
      	%>
	ไม่พบข้อมูล
	<%
      		}
      	%>
	<!-- === END CONTENT === -->

	<!-- Begin Footer -->
	<%@include file="pages/footer-menu.jsp"%>
	<!-- End Footer -->
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/th_TH/sdk.js#xfbml=1&version=v2.10&appId=133213807294938";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
</body>
</html>
<!-- === END FOOTER === -->