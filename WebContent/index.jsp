<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pongyeang.index.*"%>
<%@ page import="com.pongyeang.listFeaturedTravel.*"%>
<%@ page import="com.pongyeang.bean.*"%>
<%
	IndexManager im = new IndexManager();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Title -->
<title>index</title>
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
	<!-- === BEGIN CONTENT === -->
	<div id="content" class="container">
		<div class="thumbnail alert alert-success">
			<div class="row">
				<div class="col-xs-12">
					<div class="list-group-item" style="background-color: #78bd8e">
						<div class="row header1">
							<div class="col-xs-12">
								<div class="col-xs-8">
									<h2 class="font-size-20 bold">
										<font color="#FFFFFF">ท่องเที่ยวยอดฮิต</font>
									</h2>
								</div>
								<div class="col-sm-4 text-right">
									<h2 class="font-size-18">
										<a href="ListFeaturedTravelServlet?category=1&&page=1"><font
											color="#FFFFFF">ดูทั้งหมด >></font></a>
									</h2>
								</div>
							</div>
						</div>
					</div>
					<br>
					<div class="col-md-8">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
								<%try{ %>
								<%if(im.getDetailFeaturedTravel().get(0).getTraveldetailID() != 0){ %>
									<a href="ListFeaturedTravelServlet?category=1&&page=1"
										class="thumbnail"> <img class="img-responsive"
										src="Tools/images/pr/<%=im.getDetailFeaturedTravel().get(0).getAddress().getVectorimages().get(0).getImageName()%>"
										alt="" style="width:620px;height:400px;">								
									</a>
									<%}%>
									<%}catch(Exception ex){ %>
									<a href="#"
										class="thumbnail"> <img class="img-responsive"
										src="Tools/images/logo/pongyeanglogo.png"
										alt="">								
									</a>
									<%} %>
								</div>
								<div class="product-overlay">
									<div class="overlay-content">
										<br>
										<h2>
											<a href="ListFeaturedTravelServlet?category=1&&page=1"><font
												color="#FFFFFF">ที่ท่องเที่ยว</font></a>
										</h2>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-12">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
										<%try{ %>
										<%if(im.getDetailFeaturedHotel().get(0).getAddress().getVectorimages().get(0).getImageName() != null){ %>
											<a href="ListFeaturedTravelServlet?category=2&&page=1"
												class="thumbnail"> <img class="img-responsive"
												src="Tools/images/pr/<%=im.getDetailFeaturedHotel().get(0).getAddress().getVectorimages().get(0).getImageName()%>"
												alt="">
											</a>
											<%} %>
											<%}catch(Exception ex){ %>
													<a href="#"
														class="thumbnail"> <img class="img-responsive"
														src="Tools/images/logo/pongyeanglogo.png"
														alt="">								
													</a>
											<%} %>
										</div>
										<div class="product-overlay">
											<div class="overlay-content">
												<br>
												<h2>
													<a href="ListFeaturedTravelServlet?category=2&&page=1"><font
														color="#FFFFFF">ที่พัก</font></a>
												</h2>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
										<%try{ %>
										<%if(im.getDetailFeaturedRestataurant().get(0).getAddress().getVectorimages().get(0).getImageName() != null){ %>
											<a href="ListFeaturedTravelServlet?category=3&&page=1"
												class="thumbnail"> <img class="img-responsive"
												src="Tools/images/pr/<%=im.getDetailFeaturedRestataurant().get(0).getAddress().getVectorimages().get(0).getImageName()%>"
												alt="">
											</a>
											<%} %>
											<%}catch(Exception ex){ %>
													<a href="#"
														class="thumbnail"> <img class="img-responsive"
														src="Tools/images/logo/pongyeanglogo.png"
														alt="">								
													</a>
											<%} %>
										</div>

										<div class="product-overlay">
											<div class="overlay-content">
												<br>
												<h2>
													<a href="ListFeaturedTravelServlet?category=3&&page=1"><font
														color="#FFFFFF">ร้านอาหาร</font></a>
												</h2>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- === END CONTENT === -->
		<!-- ********************************************************************************************************************************** -->
		<!-- Page Content -->
		<!-- Service Panels -->
		<!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
		<div class="thumbnail alert alert-success">
			<div class="row">
				<div class="list-group-item" style="background-color: #78bd8e">
					<div class="row header1">
						<div class="col-xs-12">
							<div class="col-xs-8">
								<h2 class="font-size-20 bold">
									<font color="#FFFFFF">สถานที่ท่องเที่ยว</font>
								</h2>
							</div>
							<div class="col-sm-4 text-right">
								<h2 class="font-size-18">
									<a href="ListTravelCategoryServlet"><font color="#FFFFFF">ดูทั้งหมด
											>></font></a>
								</h2>
							</div>
						</div>
					</div>
				</div>
				<br>		
					<%try{ %>
				<%
					for (TravelDetail tr : im.getDetailFeaturedTravel()) {
				%>
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail ">
						<img
							src="Tools/images/pr/<%=tr.getAddress().getVectorimages().get(0).getImageName()%>"
							alt="image3" style="width:300px;height:190px;">
						<div class="caption">
							<h4><%=tr.getTraveldetailName()%></h4>
							<p>
								จำนวนผู้เข้าชม :
								<%=tr.getStatisticsvisit()%></p>
							<a
								href="ViewPRTravelDetailServlet?travelID=<%=tr.getTraveldetailID()%>"
								class="btn btn-primary" role="button">อ่านต่อ</a>
						</div>
					</div>
				</div>
				<%
					}
				%>
				<%}catch(Exception ex){%>
						<p>ยังไม่มีข้อมูล</p>
				<%} %>					
			</div>
		</div>
		<!-- ********************************************************************************************************************************** -->
		<!-- Service Tabs -->
		<div class="thumbnail alert alert-success">
			<div class="row">
				<div class="list-group-item" style="background-color: #78bd8e">
					<div class="row header1">
						<div class="col-xs-12">
							<div class="col-xs-8">
								<h2 class="font-size-20 bold">
									<font color="#FFFFFF">ที่พัก</font>
								</h2>
							</div>
							<div class="col-sm-4 text-right">
								<h2 class="font-size-18">
									<a href="ListHotelsandLodgingCategoryServlet"><font
										color="#FFFFFF">ดูทั้งหมด >></font></a>
								</h2>
							</div>
						</div>
					</div>
				</div>
				<br>		
				<%try{ %>
				<%if( im.getDetailFeaturedHotel().get(0).getHoteldetailID() != 0){%>
				<%
					for (HotelDetail ho : im.getDetailFeaturedHotel()) {
				%>
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img
							src="Tools/images/pr/<%=ho.getAddress().getVectorimages().get(0).getImageName()%>"
							alt="image3" style="width:300px;height:190px;">
						<div class="caption">
							<h4><%=ho.getHoteldetailName()%></h4>
							<p>
								จำนวนผู้เข้าชม :
								<%=ho.getStatisticsvisit()%></p>
							<a
								href="ViewHotelsandLodgingDetailServlet?hoteldetailID=<%=ho.getHoteldetailID()%>"
								class="btn btn-primary">อ่านต่อ</a>
						</div>
					</div>
				</div>
				<%
					}
				%>
				<%} %>
				<%}catch(Exception ex){%>
						<p>ยังไม่มีข้อมูล</p>
				<%} %>
				
			</div>
		</div>
		<!-- ********************************************************************************************************************************** -->
		<div class="thumbnail alert alert-success">
			<div class="row">
				<div class="list-group-item" style="background-color: #78bd8e">
					<div class="row header1">
						<div class="col-xs-12">
							<div class="col-xs-8">
								<h2 class="font-size-20 bold">
									<font color="#FFFFFF">ร้านอาหาร</font>
								</h2>
							</div>
							<div class="col-sm-4 text-right">
								<h2 class="font-size-18">
									<a href="ListRestaurantsandshopsCategoryServlet"><font
										color="#FFFFFF">ดูทั้งหมด >></font></a>
								</h2>
							</div>
						</div>
					</div>
				</div>
				<br>
				<%try{ %>
					<%if( im.getDetailFeaturedRestataurant().get(0).getRestaurantsdetailID() != 0){%>
				<%
					for (RestaurantsDetail re : im.getDetailFeaturedRestataurant()) {
				%>
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img
							src="Tools/images/pr/<%=re.getAddress().getVectorimages().get(0).getImageName()%>"
							alt="image3" style="width:300px;height:190px;">
						<div class="caption">
							<h4><%=re.getRestaurantsdetailName()%></h4>
							<p>
								จำนวนผู้เข้าชม :
								<%=re.getStatisticsvisit()%></p>
							<a
								href="ViewRestaurantsandShopsDetailServlet?RestaurantsSubID=<%=re.getRestaurantsdetailID()%>"
								class="btn btn-primary">อ่านต่อ</a>
						</div>
					</div>
				</div>
				<%
					}
				%>
				<%} %>
				<%}catch(Exception ex){%>
					<p>ยังไม่มีข้อมูล</p>
				<%} %>
			</div>
		</div>
		<!-- *********************************************************************************************************************************** -->
		<div class="thumbnail alert alert-success">
			<div class="row">
				<div class="list-group-item" style="background-color: #78bd8e">
					<div class="row header1">
						<div class="col-xs-12">
							<div class="col-xs-8">
								<h2 class="font-size-10 bold">
									<font color="#FFFFFF">บทความ</font>
								</h2>
							</div>
							<div class="col-sm-4 text-right">
								<h2 class="font-size-10">
									<a href="ListArticleServlet"><font color="#FFFFFF">ดูทั้งหมด
											>></font></a>
								</h2>
							</div>
						</div>
					</div>
				</div>
				<br>
				<%try{ %>
				<%if(im.getListArticle().get(0).getArticleID() != 0){ %>
				<%
					for (Article ar : im.getListArticle()) {
				%>
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img
							src="Tools/images/article/<%=ar.getVectorimages().get(0).getImageName()%>"
							alt="image3" style="width:300px;height:190px;">
						<div class="caption">
							<h4><%=ar.getArticleName()%></h4>
							<p>
								จำนวนผู้เข้าชม :
								<%=ar.getStatisticsvisit()%></p>
							<a href="ViewArticlesServlet?va=<%=ar.getArticleID()%>"
								class="btn btn-primary">อ่านต่อ</a>
						</div>
					</div>
				</div>
				<%
					}
				%>
				<%} %>
				<%}catch(Exception ex){%>
						<p>ยังไม่มีข้อมูล</p>
				<%} %>
			</div>
		</div>
	</div>
	<br>
	<!-- Begin Footer -->
	<%@include file="pages/footer-menu.jsp"%>
	<!-- End Footer -->
</body>
</html>