<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.pongyeang.bean.*" %>
<%
	String status = (String) session.getAttribute("status");
	Login login = (Login) session.getAttribute("login");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Meta -->
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<!-- Favicon -->
<link href="Tools/css/main.css" rel="stylesheet">

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
<link rel="stylesheet" href="Tools/css/google-map.css" rel="stylesheet">
<!-- Google Fonts-->
<link href="http://fonts.googleapis.com/css?family=Lato:400,300"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"
	rel="stylesheet" type="text/css">
<script type="text/javascript" src="Tools/js/bootstrap.min.js"></script>
<!-- 	Create PR -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBogMg4rJMkMh_ELGp402CttC-XeEbooXw"></script>
<script type="text/javascript" src="Tools/js/js-map/mapUtility.js"></script>
<script
	src="htpps://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="Tools/js/jquery-1.11.1.js" type="text/javascript"></script>
</head>
<body>

	<div id="pre_header" class="visible-lg" >
	    <nav class="navbar navbar-inverse" role="navigation" style="background-color: #3a8250">
		<div class="container">
			<!-- Top Menu -->
			<div class="col-md-12 margin-top-15">

				<div id="hornav" class="pull-right visible-lg">				
					<ul class="nav navbar-nav">
						<li><a href="index.jsp"><font size="4"
						color="#FFFFFF">หน้าแรก</font></a></li>
						<li><span ><font size="4" color="#FFFFFF">ที่เที่ยว</font></span>
							<ul>
								<li><a href="ListTravelCategoryServlet">ท่องเที่ยวทั้งหมด</a></li>
								<li><a href="ListTravelSubCategoryServlet?TravelSubID=1">ท่องเที่ยวธรรมชาติ</a></li>
								<li><a href="ListTravelSubCategoryServlet?TravelSubID=2">ท่องเที่ยวเชิงอนุรักษ์</a></li>
								<li><a href="ListTravelSubCategoryServlet?TravelSubID=3">ท่องเที่ยวเชิงเกษตร</a></li>
								<li><a href="ListTravelSubCategoryServlet?TravelSubID=4">ท่องเที่ยวผจญภัย</a></li>
								<li><a href="ListTravelSubCategoryServlet?TravelSubID=5">ท่องเที่ยวทางวัฒนธรรมประเพณี</a></li>
								<li><a href="ListTravelSubCategoryServlet?TravelSubID=6">ท่องเที่ยวเรียนรู้วิถีชนบท</a></li>
								<li><a href="ListTravelSubCategoryServlet?TravelSubID=7">ท่องเที่ยวกับศูนย์การเรียนรู้</a></li>
								<li><a href="ListTravelSubCategoryServlet?TravelSubID=8">ท่องเที่ยวกับสถานที่ทางศาสนา</a></li>
							</ul></li>
						<li><span><font size="4" color="#FFFFFF">ที่พัก</font></span>
							<ul>
								<li><a href="ListHotelsandLodgingCategoryServlet">ที่พักทั้งหมด</a></li>
								<li><a href="ListHotelsandSubCategoryServlet?HotelSubID=1">โรงแรม</a></li>
								<li><a href="ListHotelsandSubCategoryServlet?HotelSubID=2">โฮสเทล</a></li>
								<li><a href="ListHotelsandSubCategoryServlet?HotelSubID=3">โฮมสเตย์</a></li>
								<li><a href="ListHotelsandSubCategoryServlet?HotelSubID=4">รีสอร์ท</a></li>
								<li><a href="ListHotelsandSubCategoryServlet?HotelSubID=5">เกสต์เฮาส์</a></li>
								<li><a href="ListHotelsandSubCategoryServlet?HotelSubID=6">บังกะโล</a></li>
								<li><a href="ListHotelsandSubCategoryServlet?HotelSubID=7">บีบี</a></li>
								<li><a href="ListHotelsandSubCategoryServlet?HotelSubID=8">บูติครีสอร์ท</a></li>
								<li><a href="ListHotelsandSubCategoryServlet?HotelSubID=9">ลานกางเต้นท์</a></li>
							</ul></li>
						<li><span><font size="4" color="#FFFFFF">ร้านอาหาร</font></span>
							<ul>
								<li><a href="ListRestaurantsandshopsCategoryServlet">ร้านทั้งหมด</a></li>
								<li><a
									href="ListRestaurantsandshopsSubCategoryServlet?RestaurantsSubID=1">ร้านกาแฟ</a></li>
								<li><a
									href="ListRestaurantsandshopsSubCategoryServlet?RestaurantsSubID=2">ร้านอาหาร</a></li>
								<li><a
									href="ListRestaurantsandshopsSubCategoryServlet?RestaurantsSubID=3">ร้านนั่งชิลริมน้ำ</a></li>
								<li><a
									href="ListRestaurantsandshopsSubCategoryServlet?RestaurantsSubID=4">ร้านนั่งชิลบนดอย์</a></li>
								<li><a
									href="ListRestaurantsandshopsSubCategoryServlet?RestaurantsSubID=5">ร้านของฝากของที่ระลึก</a></li>
							</ul></li>
						<li><span><font size="4" color="#FFFFFF">หมู่บ้าน</font></span>
							<ul>
								<li><a href="ListVillageCategoryServlet">หมู่บ้านทั้งหมด</a></li>
								<li><a href="ListAllTravelofVillageServlet?village=1">หมู่บ้านโป่งแยงใน</a></li>
								<li><a href="ListAllTravelofVillageServlet?village=2">หมู่บ้านโป่งแยงนอก้ำ</a></li>
								<li><a href="ListAllTravelofVillageServlet?village=3">หมู่บ้านม่วงคำ</a></li>
								<li><a href="ListAllTravelofVillageServlet?village=4">หมู่บ้านกองแหะ</a></li>
								<li><a href="ListAllTravelofVillageServlet?village=5">หมู่บ้านปงไคร้</a></li>
								<li><a href="ListAllTravelofVillageServlet?village=6">หมู่บ้านแม่สาใหม่</a></li>
								<li><a href="ListAllTravelofVillageServlet?village=7">หมู่บ้านบวกจั่น</a></li>
								<li><a href="ListAllTravelofVillageServlet?village=8">หมู่บ้านปางลุง-บวกเต๋ย</a></li>
								<li><a href="ListAllTravelofVillageServlet?village=9">หมู่บ้านผานกกก</a></li>
								<li><a href="ListAllTravelofVillageServlet?village=10">หมู่บ้านแม่สาน้อย</a></li>
							</ul></li>
						<li><a href="ListArticleServlet"><font size="4" color="#FFFFFF">บทความ</font></a></li>

						<%
							if (session.getAttribute("status") != null || session.getAttribute("login") != null) {
						%>
						<%
							if (status.equals("1")) {
						%>
						<li><span><font size="4" color="#FFFFFF">ผู้ดูแลระบบ</font></span>
							<ul>
								<li><a href="ListMemberServlet">แสดงสมาชิกทั้งหมด</a></li>
								<li><a href="ListPRBusinessandTravelServlet?type=1">แสดงสถานที่ท่องเที่ยวทั้งหมด</a></li>
							</ul></li>
						<li><a href="LogoutServlet"> <font size="4" color="#FFFFFF">ออกจากระบบ</font></a></li>
						<%
							} else if (status.equals("2")) {
						%>
						<li><span><font size="4" color="#FFFFFF">คุณ <%=login.getOwner().getOwnerFirstname()%></font></span>
							<ul>
								<li><a href="ViewProfileDetailServlet">ดูข้อมูลส่วนตัว</a></li>
								<li><a href="CreatePRBusinessAndTravelServlet">สร้างสถานที่ท่องเที่ยว</a></li>
								<li><a href="Owner_viewPRbusinessandtravelServlet">ดูข้อมูลสถานที่ท่องเที่ยว</a></li>
								<li><a href="AddArticleServlet">สร้างบทความ</a></li>
								<li><a href="OwnerListArticleServlet">แสดงบทความทั้งหมด</a></li>
							</ul></li>
						<li><a href="LogoutServlet"><font size="4" color="#FFFFFF" >ออกจากระบบ</font></a></li>
						<%
							} else {
						%>
						<li><span><font size="4" color="#FFFFFF">เข้าสู่ระบบ</font></span>
							<ul>
								<li><a href="page-login.jsp">เข้าสู่ระบบ</a></li>
								<li><a href="register.jsp">สมัครสมาชิก</a></li>
							</ul></li>
						<%
							}
						%>
						<%
							} else {
						%>
						<li><a href="contact.jsp"><font size="4" color="#FFFFFF">ติดต่อเรา</font></a></li>
						<li><span><font size="4" color="#FFFFFF">เข้าสู่ระบบ</font></span>
							<ul>
								<li><a href="page-login.jsp">เข้าสู่ระบบ</a></li>
								<li><a href="register.jsp">สมัครสมาชิก</a></li>
							</ul></li>
						<%
							}
						%>
					</ul>
				</div>
			</div>
			<div class="clear"></div>
			<!-- End Top Menu -->
		</div>
	</nav>
	</div>
	<br><br><br>
	
	<center><img  src="Tools/img/logo/21985842_1419358561514170_1947940349_o.png" width="1020" height="350"></center>
   
	<!-- === END HEADER === -->
	<br>
	<!-- JS -->
	<script type="text/javascript" src="Tools/js/jquery.min.js"
		type="text/javascript"></script>
	<script type="text/javascript" src="Tools/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script type="text/javascript" src="Tools/js/scripts.js"></script>
	<!-- Isotope - Portfolio Sorting -->
	<script type="text/javascript" src="Tools/js/jquery.isotope.js"
		type="text/javascript"></script>
	<!-- Mobile Menu - Slicknav -->
	<script type="text/javascript" src="Tools/js/jquery.slicknav.js"
		type="text/javascript"></script>
	<!-- Animate on Scroll-->
	<script type="text/javascript" src="Tools/js/jquery.visible.js"
		charset="utf-8"></script>
	<!-- Slimbox2-->
	<script type="text/javascript" src="Tools/js/slimbox2.js"
		charset="utf-8"></script>
	<!-- Modernizr -->
	<script src="Tools/js/modernizr.custom.js" type="text/javascript"></script>
	<!-- End JS -->
</body>
</html>