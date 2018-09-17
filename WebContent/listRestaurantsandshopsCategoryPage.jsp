<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pongyeang.bean.*"%>

<%
	Vector<SubCategoryRestaurants> vRastataurants = (Vector<SubCategoryRestaurants>) session
			.getAttribute("ListRastaurants");
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

	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="list-group-item" style="background-color: #228B22">
					<div class="row header1">
						<div class="col-xs-12">
							<div class="col-xs-8">
								<h2 class="font-size-20 bold">
									<font color="#FFFFFF">ร้านอาหารทั้งหมด
									</font>
								</h2>
							</div>
						</div>
					</div>
				</div>
				<br>
		<!-- /.row -->
		<%try{ %>
		<!-- Projects Row -->
		<div class="row">
			<%	for (int i = 0; i < vRastataurants.size(); i++) {%>
			<div class="col-md-4 text-center">
				<div class="thumbnails">
					<a
						href="ListRestaurantsandshopsSubCategoryServlet?RestaurantsSubID=<%=vRastataurants.get(i).getSubcategoryrestaurantID()%>">
						<img class="img-responsives"
						src="Tools/images/category/SubRes_0<%=i+1%>.jpg" 
						alt="" width="100%">
					</a>
					<div class="caption">
						<h3 align="center">
							<a
								href="ListRestaurantsandshopsSubCategoryServlet?RestaurantsSubID=<%=vRastataurants.get(i).getSubcategoryrestaurantID()%>"><%=vRastataurants.get(i).getSubcategoryrestaurantName()%></a>
						</h3>
					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>
		<%}catch (Exception e){ %>
			<div class="row">
				<div class="col-lg-12">
					<h2 class="page-header">ยังไม่มีข้อมูล</h2>
				</div>
			</div>
		<%} %>	
	</div>
	<!-- === END CONTENT === -->
	<!-- Begin Footer -->
	<%@include file="pages/footer-menu.jsp"%>
	<!-- End Footer -->
</body>
</html>
<!-- === END FOOTER === -->