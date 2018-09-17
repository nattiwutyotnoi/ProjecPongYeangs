<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pongyeang.bean.*"%>
<% String url = "https://b9b7b627.ngrok.io/" ;%>
<%
	SubCategoryHotel vHotel = (SubCategoryHotel) session.getAttribute("ListHotelSub");
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
<title><%=vHotel.getSubcategoryhotelName()%></title>
<!-- Meta -->
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
</head>
<body>
	<!-- Begin HEADER -->
	<%@include file="pages/header-menu.jsp"%>
	<!-- End HEADER -->
	<%
		if (vHotel != null || request.getAttribute("noOfPages") != null
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
							<font color="#FFFFFF"> <%
								 	if (vHotel.getSubcategoryhotelName() != null) {
								 %> <%=vHotel.getSubcategoryhotelName()%> <%
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
		<!-- /.row -->
		<%try{ %>
		<%for (HotelDetail hv : vHotel.getVectorhoteldetail()) {%>
		<!-- Project One -->
		<div class="row">
			<div class="col-md-5">
				<a href="#"> <img class="img-responsive"
					src="Tools/images/pr/<%=hv.getAddress().getVectorimages().get(0).getImageName()%>"
					alt="image2" width="700px" height="400px">
				</a>
			</div>
			<div class="col-md-6">
				<h3><%=hv.getHoteldetailName()%></h3>
				<h4>
					จำนวนคนเข้าชม :
					<%=hv.getStatisticsvisit()%></h4>
				<p><%=hv.getHoteldetailTitel()%></p>
				<p><div class="fb-like" data-href="<%=url%>pongyeang/ViewHotelsandLodgingDetailServlet?hoteldetailID=<%=hv.getHoteldetailID()%>" 
				data-width="500" data-layout="standard" data-action="like" data-size="large" data-show-faces="true" data-share="true"></div></p>
				<a class="btn btn-primary"
					href="ViewHotelsandLodgingDetailServlet?hoteldetailID=<%=hv.getHoteldetailID()%>">อ่านต่อ
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
							href="ListHotelsandSubCategoryServlet?HotelSubID=<%=vHotel.getSubcategoryhotelID() %>&&page=<%=currentPage - 1%>"
							aria-label="Previous"><span aria-hidden="true">«</span></a></li>
						<%
							for (int s = 0; s < noOfPages; s++) {
						%>
						<li><a href="ListHotelsandSubCategoryServlet?HotelSubID=<%=vHotel.getSubcategoryhotelID() %>&&page=<%=s + 1%>"><span
								aria-hidden="true"><%=s + 1%></span></a></li>
						<%
							}
						%>
						<%
							} else {
						%>
						<li><a
							href="ListHotelsandSubCategoryServlet?HotelSubID=<%=vHotel.getSubcategoryhotelID() %>&&page=<%=currentPage - 1%>"
							aria-label="Previous"><span aria-hidden="true">«</span></a></li>
						<%
							for (int s = 0; s < noOfPages; s++) {
						%>
						<li><a href="ListHotelsandSubCategoryServlet?HotelSubID=<%=vHotel.getSubcategoryhotelID() %>&&page=<%=s + 1%>"><span
								aria-hidden="true"><%=s + 1%></span></a></li>
						<%
							}
						%>
						<li><a
							href="ListHotelsandSubCategoryServlet?HotelSubID=<%=vHotel.getSubcategoryhotelID() %>&&page=<%=currentPage + 1%>"
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
						<li><a href="ListHotelsandSubCategoryServlet?HotelSubID=<%=vHotel.getSubcategoryhotelID() %>&&page=<%=s + 1%>"><span
								aria-hidden="true"><%=s + 1%></span></a></li>
						<%
							}
						%>
						<li><a
							href="ListHotelsandSubCategoryServlet?HotelSubID=<%=vHotel.getSubcategoryhotelID() %>&&page=<%=currentPage + 1%>"
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