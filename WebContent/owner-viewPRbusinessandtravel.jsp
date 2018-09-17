<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="java.util.*"%>
<%@page import="com.pongyeang.bean.*"%>
<%@page import="com.pongyeang.listVillageCategory.*"%>
<%
	Owner owner = (Owner) request.getAttribute("owner");
%>
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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View PR Business And Travel</title>
</head>
<body>
	<!-- Begin HEADER -->
	<%@include file="pages/header-menu.jsp"%>
	<!-- End HEADER -->
	<div id="content" class="container">
		<div class="row margin-vert-30">
			<form class="signup-page" action="EditPRBusinessAndTravelServlet"
				method="get">
				<%
					if (request.getAttribute("owner") != null) {
				%>
				<%
					if (owner.getTravledetail().getTraveldetailID() != 0) {
				%>
				<!-- Start TravleDetail -->
				<!-- ******************************************************************************************************************** -->
				<!-- Page Heading/Breadcrumbs -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header"><%=owner.getTravledetail().getTraveldetailName()%>
						</h1>
					</div>
				</div>
				<!-- /.row -->
				<!-- Content Row -->
				<div class="row">
					<!-- Blog Post Content Column -->
					<div class="col-lg-12">
						<!-- Date/Time -->
						<p>
							<i class="fa fa-clock-o"></i>
							<%=owner.getTravledetail().getAddress().getDatecreate()%></p>
						<!-- Page Heading/Breadcrumbs -->
						<div class="col-md-12">
							<h2 align="center"><%=owner.getTravledetail().getTraveldetailName()%></h2>
							<p class="lead"><%=owner.getTravledetail().getTraveldetailTitel()%></p>
						</div>
						<!-- /.row -->
						<!-- Preview Image -->
						<div class="row">
							<div class="col-md-6 col-md-offset-3">
								<img class="img-rounded"
									src="Tools/images/pr/<%=owner.getTravledetail().getAddress().getVectorimages().get(0).getImageName()%>">
							</div>
						</div>
						<hr>
						<!-- Post Content -->
						<P>
						<h3><%=owner.getTravledetail().getTraveldetailData()%></h3>
						</P>
						<hr>
						<!-- Start Gallery ***************************************************************************************-->
						<div class="row">
							<div class="col-lg-12">
								<%
									for (int i = 0; i < owner.getTravledetail().getAddress().getVectorimages().size(); i++) {
								%>
								<div class="col-lg-3 col-md-4 col-xs-6 thumb">
									<a class="thumbnail" href="#" data-image-id=""
										data-toggle="modal"
										<%if (owner.getTravledetail().getAddress().getVectorimages().get(i).getImageDetail() != null
								&& !owner.getTravledetail().getAddress().getVectorimages().get(i).getImageDetail()
										.equalsIgnoreCase("-")) {%>
										data-title="<%=owner.getTravledetail().getAddress().getVectorimages().get(i).getImageDetail()%>"
										<%} else {%>
										data-title="<%=owner.getTravledetail().getTraveldetailName()%>"
										<%}%> data-caption="Some lovely red flowers"
										data-image="Tools/images/pr/<%=owner.getTravledetail().getAddress().getVectorimages().get(i).getImageName()%>"
										data-target="#image-gallery"> <img
										src="Tools/images/pr/<%=owner.getTravledetail().getAddress().getVectorimages().get(i).getImageName()%>"
										align="center" style="width: 215px; height: 143px;">
									</a>
								</div>
								<div class="modal fade" id="image-gallery" tabindex="-1"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">
													<span aria-hidden="true">×</span><span class="sr-only">Close</span>
												</button>
												<h4 class="modal-title" id="image-gallery-title"></h4>
											</div>
											<div class="modal-body">
												<img id="image-gallery-image" class="img-responsive" src="">
											</div>
										</div>
									</div>
								</div>
								<%
									}
								%>
							</div>
						</div>
						<!-- End Gallery ***************************************************************************************-->
						<!-- Map+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
						<div class="row">
							<div class="col-lg-12">
								<h2 class="page-header">ตำเเหน่งที่ตั้ง</h2>
							</div>
						</div>
						<!-- Map Column -->
						<div class="row">
							<div class="col-md-6">
								<div id="googleMap" style="width: 100%; height: 400px;"></div>
								<script>
									function initMap() {
										var uluru = {
											lat :
								<%=owner.getTravledetail().getAddress().getLatitude()%>
									,
											lng :
								<%=owner.getTravledetail().getAddress().getLongtitude()%>
									};
										var map = new google.maps.Map(document
												.getElementById('googleMap'), {
											zoom : 15,
											center : uluru
										});
										var marker = new google.maps.Marker({
											position : uluru,
											map : map
										});
									}
								</script>
								<script async defer
									src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCz15jXRmU5Rt5vocXYBhJpmCIls0IE-KE&callback=initMap">
									
								</script>
							</div>
							<!-- Start Contact Details Column -->
							<div class="col-md-6">
								<h3>สามารถติอต่อสอบถามได้ทาง</h3>
								<p>
								<div class="media-body">
									<%="บ้านเลขที่ " + owner.getTravledetail().getAddress().getAddressno() + "หมู่ที่ "
							+ owner.getTravledetail().getAddress().getVillageno() + " หมู่บ้าน "
							+ owner.getTravledetail().getAddress().getVillageCategoryID().getVillageName() + " ซอย "
							+ owner.getTravledetail().getAddress().getAlley() + " ถนน "
							+ owner.getTravledetail().getAddress().getStreet() + " ตำบล"
							+ owner.getTravledetail().getAddress().getDistrict() + " จังหวัด "
							+ owner.getTravledetail().getAddress().getProvince() + " รหัสไปรษณีย์ "
							+ owner.getTravledetail().getAddress().getZipcode()%><br>
								</div>
								<div class="media">
									<div class="media-body">
										<i class="fa fa-phone-square fa-2x"></i> <abbr title="Phone"></abbr>:
										<%=owner.getTravledetail().getTelephone()%></p>
									</div>
									<%
										if (!owner.getTravledetail().getWebsite().equalsIgnoreCase("-")
														&& !owner.getTravledetail().getWebsite().equalsIgnoreCase("null")) {
									%>
									<div class="media-body">
										<i class="fa fa-envelope-square fa-2x"></i> <abbr title="web"></abbr>:
										<a
											href="<%=owner.getTravledetail().getWebsite()%>"><%=owner.getTravledetail().getWebsite()%></a>
									</div>
									<%
										} else {
												}
									%>
									<%
										if (!owner.getTravledetail().getFacebook().equalsIgnoreCase("-")
														&& !owner.getTravledetail().getFacebook().equalsIgnoreCase("null")) {
									%>
									<div class="media-body">
										<i class="fa fa-facebook-square fa-2x"></i> <abbr
											title="facebook"></abbr>: <a
											href="<%=owner.getTravledetail().getFacebook()%>"><%=owner.getTravledetail().getFacebook()%></a>
									</div>
									<%
										} else {
												}
									%>
									<%
										if (!owner.getTravledetail().getLine().equalsIgnoreCase("-")
														&& !owner.getTravledetail().getLine().equalsIgnoreCase("null")) {
									%>
									<div class="media-body">
										<i class="fa fa-linkedin-square fa-2x"></i> <abbr title="line"></abbr>:
										<%=owner.getTravledetail().getLine()%>
									</div>
									<%
										} else {
												}
									%>
									<%
										if (!owner.getTravledetail().getLine().equalsIgnoreCase("-")
														&& !owner.getTravledetail().getLine().equalsIgnoreCase("null")) {
									%>
									<div class="media-body">
										<i class="fa fa-twitter-square fa-2x"></i> <abbr title="twi"></abbr>:
										<%=owner.getTravledetail().getTwitter()%>
									</div>
									<%
										} else {
												}
									%>
								</div>
							</div>
						</div>
						<!-- End Contact Details Column -->
						<!-- Map+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
						<!-- Intro Content -->
						<div class="row">
							<div class="col-lg-12">
								<h2 class="page-header">แผนที่นำทาง</h2>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<%
									if (!owner.getTravledetail().getAddress().getMapimage().equals("null.jpg")) {
								%>
								<img class="img-responsive"
									src="Tools/images/mapimage/<%=owner.getTravledetail().getAddress().getMapimage()%>"
									alt="<%=owner.getTravledetail().getAddress().getMapimage()%>"
									style="width: 500px; height: 400px;">
								<%
									} else {
								%>
								<img class="img-responsive"
									src="Tools/images/logo/pongyeanglogo.png"
									alt="pongyeanglogo.png" style="width: 500px; height: 400px;">
								<%
									}
								%>
							</div>
							<div class="col-md-6">
								<%=owner.getTravledetail().getAddress().getMapimagedetail()%>
							</div>
						</div>
					</div>
					<!-- /.row -->
					<!-- Team Members -->
					<!-- +++++++++++++++++++++++++++++++++++++++++++ -->
				</div>
				<!-- ********************************************************************************************************************* -->
				<!-- End TravleDetail -->
				<%
					} else if (owner.getHoteldetail().getHoteldetailID() != 0) {
				%>
				<!-- Start HotelDeatil -->
				<!-- ******************************************************************************************************************** -->
				<!-- Page Heading/Breadcrumbs -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header"><%=owner.getHoteldetail().getHoteldetailName()%>
						</h1>
					</div>
				</div>
				<!-- /.row -->
				<!-- Content Row -->
				<div class="row">
					<!-- Blog Post Content Column -->
					<div class="col-lg-12">
						<!-- Date/Time -->
						<p>
							<i class="fa fa-clock-o"></i>
							<%=owner.getHoteldetail().getAddress().getDatecreate()%></p>
						<!-- Page Heading/Breadcrumbs -->
						<div class="col-md-12">
							<h2 align="center"><%=owner.getHoteldetail().getHoteldetailName()%></h2>
							<p class="lead"><%=owner.getHoteldetail().getHoteldetailTitel()%></p>
						</div>
						<!-- /.row -->
						<!-- Preview Image -->
						<div class="row">
							<div class="col-md-6 col-md-offset-3">
								<img class="img-rounded"
									src="Tools/images/pr/<%=owner.getHoteldetail().getAddress().getVectorimages().get(0).getImageName()%>">
							</div>
						</div>
						<hr>
						<!-- Post Content -->
						<div class="col-md-12">
							<p>
							<div class="media-body">
								<h3><%=owner.getHoteldetail().getHoteldetailData()%></h3>
							</div>
							</p>
						</div>
						<hr>
						<!-- Start Gallery ***************************************************************************************-->
						<div class="row">
							<div class="col-lg-12">
								<%
									for (int i = 0; i < owner.getHoteldetail().getAddress().getVectorimages().size(); i++) {
								%>
								<div class="col-lg-3 col-md-4 col-xs-6 thumb">
									<a class="thumbnail" href="#" data-image-id=""
										data-toggle="modal"
										<%if (owner.getHoteldetail().getAddress().getVectorimages().get(i).getImageDetail() != null
								&& !owner.getHoteldetail().getAddress().getVectorimages().get(i).getImageDetail()
										.equalsIgnoreCase("-")) {%>
										data-title="<%=owner.getHoteldetail().getAddress().getVectorimages().get(i).getImageDetail()%>"
										<%} else {%>
										data-title="<%=owner.getHoteldetail().getHoteldetailName()%>"
										<%}%> data-caption="Some lovely red flowers"
										data-image="Tools/images/pr/<%=owner.getHoteldetail().getAddress().getVectorimages().get(i).getImageName()%>"
										data-target="#image-gallery"> <img
										src="Tools/images/pr/<%=owner.getHoteldetail().getAddress().getVectorimages().get(i).getImageName()%>"
										align="center" style="width: 215px; height: 143px;">
									</a>
								</div>
								<div class="modal fade" id="image-gallery" tabindex="-1"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">
													<span aria-hidden="true">×</span><span class="sr-only">Close</span>
												</button>
												<h4 class="modal-title" id="image-gallery-title"></h4>
											</div>
											<div class="modal-body">
												<img id="image-gallery-image" class="img-responsive" src="">
											</div>
										</div>
									</div>
								</div>
								<%
									}
								%>
							</div>
						</div>
						<!-- End Gallery ***************************************************************************************-->
						<!-- Map+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
						<div class="row">
							<div class="col-lg-12">
								<h2 class="page-header">ตำเเหน่งที่ตั้ง</h2>
							</div>
						</div>
						<!-- Map Column -->
						<div class="row">
							<div class="col-md-6">

								<div id="googleMap" style="width: 100%; height: 400px;"></div>
								<script>
									function initMap() {
										var uluru = {
											lat :
								<%=owner.getHoteldetail().getAddress().getLatitude()%>
									,
											lng :
								<%=owner.getHoteldetail().getAddress().getLongtitude()%>
									};
										var map = new google.maps.Map(document
												.getElementById('googleMap'), {
											zoom : 15,
											center : uluru
										});
										var marker = new google.maps.Marker({
											position : uluru,
											map : map
										});
									}
								</script>
								<script async defer
									src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCz15jXRmU5Rt5vocXYBhJpmCIls0IE-KE&callback=initMap">
									
								</script>
							</div>
							<!-- Start Contact Details Column -->
							<div class="col-md-6">
								<h3>สามารถติอต่อสอบถามได้ทาง</h3>
								<p>
								<div class="media-body">
									<%="บ้านเลขที่ " + owner.getHoteldetail().getAddress().getAddressno() + "หมู่ที่ "
							+ owner.getHoteldetail().getAddress().getVillageno() + " หมู่บ้าน "
							+ owner.getHoteldetail().getAddress().getVillageCategoryID().getVillageName() + " ซอย "
							+ owner.getHoteldetail().getAddress().getAlley() + " ถนน "
							+ owner.getHoteldetail().getAddress().getStreet() + " ตำบล"
							+ owner.getHoteldetail().getAddress().getDistrict() + " จังหวัด "
							+ owner.getHoteldetail().getAddress().getProvince() + " รหัสไปรษณีย์ "
							+ owner.getHoteldetail().getAddress().getZipcode()%><br>
								</div>
								<div class="media">
									<div class="media-body">
										<i class="fa fa-phone-square fa-2x"></i> <abbr title="Phone"></abbr>:
										<%=owner.getHoteldetail().getTelephone()%></p>
									</div>
									<%
										if (!owner.getHoteldetail().getWebsite().equalsIgnoreCase("-")
														&& !owner.getHoteldetail().getWebsite().equalsIgnoreCase("null")) {
									%>
									<div class="media-body">
										<i class="fa fa-envelope-square fa-2x"></i> <abbr title="web"></abbr>:
										<a
											href="<%=owner.getHoteldetail().getWebsite()%>"><%=owner.getHoteldetail().getWebsite()%></a>
									</div>
									<%
										} else {
												}
									%>
									<%
										if (!owner.getHoteldetail().getFacebook().equalsIgnoreCase("-")
														&& !owner.getHoteldetail().getFacebook().equalsIgnoreCase("null")) {
									%>
									<div class="media-body">
										<i class="fa fa-facebook-square fa-2x"></i> <abbr
											title="facebook"></abbr>: <a
											href="<%=owner.getHoteldetail().getFacebook()%>"><%=owner.getHoteldetail().getFacebook()%></a>
									</div>
									<%
										} else {
												}
									%>
									<%
										if (!owner.getHoteldetail().getLine().equalsIgnoreCase("-")
														&& !owner.getHoteldetail().getLine().equalsIgnoreCase("null")) {
									%>
									<div class="media-body">
										<i class="fa fa-linkedin-square fa-2x"></i> <abbr title="line"></abbr>:
										<%=owner.getHoteldetail().getLine()%>
									</div>
									<%
										} else {
												}
									%>
									<%
										if (!owner.getHoteldetail().getLine().equalsIgnoreCase("-")
														&& !owner.getHoteldetail().getLine().equalsIgnoreCase("null")) {
									%>
									<div class="media-body">
										<i class="fa fa-twitter-square fa-2x"></i> <abbr title="twi"></abbr>:
										<%=owner.getHoteldetail().getTwitter()%>
									</div>
									<%
										} else {
												}
									%>
								</div>
							</div>
						</div>
						<!-- End Contact Details Column -->
						<!-- Map+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
						<!-- Intro Content -->
						<div class="row">
							<div class="col-lg-12">
								<h2 class="page-header">แผนที่นำทาง</h2>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<%
									if (!owner.getHoteldetail().getAddress().getMapimage().equals("null.jpg")) {
								%>
								<img class="img-responsive"
									src="Tools/images/mapimage/<%=owner.getHoteldetail().getAddress().getMapimage()%>"
									alt="<%=owner.getHoteldetail().getAddress().getMapimage()%>"
									style="width: 500px; height: 400px;">
								<%
									} else {
								%>
								<img class="img-responsive"
									src="Tools/images/logo/pongyeanglogo.png"
									alt="pongyeanglogo.png" style="width: 500px; height: 400px;">
								<%
									}
								%>
							</div>
						</div>
						<div class="col-md-6">
							<%=owner.getHoteldetail().getAddress().getMapimagedetail()%>
						</div>
					</div>
				</div>
				<!-- /.row -->
				<!-- Team Members -->
				<!-- +++++++++++++++++++++++++++++++++++++++++++ -->
				<!-- ********************************************************************************************************************* -->
				<!-- End HotelDeatil -->
				<%
					} else if (owner.getRestaurantsdetail().getRestaurantsdetailID() != 0) {
				%>
				<!-- Start RestauranstsDetail -->
				<!-- ******************************************************************************************************************** -->
				<!-- Page Heading/Breadcrumbs -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header"><%=owner.getRestaurantsdetail().getRestaurantsdetailName()%>
						</h1>
					</div>
				</div>
				<!-- /.row -->
				<!-- Content Row -->
				<div class="row">
					<!-- Blog Post Content Column -->
					<div class="col-lg-12">
						<!-- Date/Time -->
						<p>
							<i class="fa fa-clock-o"></i>
							<%=owner.getRestaurantsdetail().getAddress().getDatecreate()%></p>
						<!-- Page Heading/Breadcrumbs -->
						<div class="col-md-12">
							<h2 align="center"><%=owner.getRestaurantsdetail().getRestaurantsdetailName()%></h2>
							<p class="lead"><%=owner.getRestaurantsdetail().getRestaurantsdetailTitel()%></p>
						</div>
						<!-- /.row -->
						<!-- Preview Image -->
						<div class="row">
							<div class="col-md-6 col-md-offset-3">
								<img class="img-rounded"
									src="Tools/images/pr/<%=owner.getRestaurantsdetail().getAddress().getVectorimages().get(0).getImageName()%>">
							</div>
						</div>
						<hr>
						<!-- Post Content -->
						<P>
						<h3><%=owner.getRestaurantsdetail().getRestaurantsdetailData()%></h3>
						</P>
						<hr>
						<!-- Start Gallery ***************************************************************************************-->
						<div class="row">
							<div class="col-lg-12">
								<%
									for (int i = 0; i < owner.getRestaurantsdetail().getAddress().getVectorimages().size(); i++) {
								%>
								<div class="col-lg-3 col-md-4 col-xs-6 thumb">
									<a class="thumbnail" href="#" data-image-id=""
										data-toggle="modal"
										<%if (owner.getRestaurantsdetail().getAddress().getVectorimages().get(i).getImageDetail() != null
								&& !owner.getRestaurantsdetail().getAddress().getVectorimages().get(i).getImageDetail()
										.equalsIgnoreCase("-")) {%>
										data-title="<%=owner.getRestaurantsdetail().getAddress().getVectorimages().get(i)
									.getImageDetail()%>"
										<%} else {%>
										data-title="<%=owner.getRestaurantsdetail().getRestaurantsdetailName()%>"
										<%}%> data-caption="Some lovely red flowers"
										data-image="Tools/images/pr/<%=owner.getRestaurantsdetail().getAddress().getVectorimages().get(i).getImageName()%>"
										data-target="#image-gallery"> <img
										src="Tools/images/pr/<%=owner.getRestaurantsdetail().getAddress().getVectorimages().get(i).getImageName()%>"
										align="center" style="width: 215px; height: 143px;">
									</a>
								</div>
								<div class="modal fade" id="image-gallery" tabindex="-1"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">
													<span aria-hidden="true">×</span><span class="sr-only">Close</span>
												</button>
												<h4 class="modal-title" id="image-gallery-title"></h4>
											</div>
											<div class="modal-body">
												<img id="image-gallery-image" class="img-responsive" src="">
											</div>
										</div>
									</div>
								</div>
								<%
									}
								%>
							</div>
						</div>
						<!-- End Gallery ***************************************************************************************-->
						<!-- Map+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
						<div class="row">
							<div class="col-lg-12">
								<h2 class="page-header">ตำเเหน่งที่ตั้ง</h2>
							</div>
						</div>
						<!-- Map Column -->
						<div class="row">
							<div class="col-md-6">
								<div id="googleMap" style="width: 100%; height: 400px;"></div>
								<script>
						function initMap() {
							var uluru = {
								lat :
					<%=owner.getRestaurantsdetail().getAddress().getLatitude()%>
						,
								lng :
					<%=owner.getRestaurantsdetail().getAddress().getLongtitude()%>
						};
							var map = new google.maps.Map(document
									.getElementById('googleMap'), {
								zoom : 15,
								center : uluru
							});
							var marker = new google.maps.Marker({
								position : uluru,
								map : map
							});
						}
					</script>
								<script async defer
									src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCz15jXRmU5Rt5vocXYBhJpmCIls0IE-KE&callback=initMap">
						
					</script>
							</div>
							<!-- Start Contact Details Column -->
							<div class="col-md-6">
								<h3>สามารถติอต่อสอบถามได้ทาง</h3>
								<p>
								<div class="media-body">
									<%="บ้านเลขที่ " + owner.getRestaurantsdetail().getAddress().getAddressno() + "หมู่ที่ "
							+ owner.getRestaurantsdetail().getAddress().getVillageno() + " หมู่บ้าน "
							+ owner.getRestaurantsdetail().getAddress().getVillageCategoryID().getVillageName()
							+ " ซอย " + owner.getRestaurantsdetail().getAddress().getAlley() + " ถนน "
							+ owner.getRestaurantsdetail().getAddress().getStreet() + " ตำบล"
							+ owner.getRestaurantsdetail().getAddress().getDistrict() + " จังหวัด "
							+ owner.getRestaurantsdetail().getAddress().getProvince() + " รหัสไปรษณีย์ "
							+ owner.getRestaurantsdetail().getAddress().getZipcode()%><br>
								</div>
								<div class="media">
									<div class="media-body">
										<i class="fa fa-phone-square fa-2x"></i> <abbr title="Phone"></abbr>:
										<%=owner.getRestaurantsdetail().getTelephone()%></p>
									</div>
									<%
										if (!owner.getRestaurantsdetail().getWebsite().equalsIgnoreCase("-")
														&& !owner.getRestaurantsdetail().getWebsite().equalsIgnoreCase("null")) {
									%>
									<div class="media-body">
										<i class="fa fa-envelope-square fa-2x"></i> <abbr title="web"></abbr>:
										<a
											href="<%=owner.getRestaurantsdetail().getWebsite()%>"><%=owner.getRestaurantsdetail().getWebsite()%></a>
									</div>
									<%
										} else {
												}
									%>
									<%
										if (!owner.getRestaurantsdetail().getFacebook().equalsIgnoreCase("-")
														&& !owner.getRestaurantsdetail().getFacebook().equalsIgnoreCase("null")) {
									%>
									<div class="media-body">
										<i class="fa fa-facebook-square fa-2x"></i> <abbr
											title="facebook"></abbr>: <a
											href="<%=owner.getRestaurantsdetail().getFacebook()%>"><%=owner.getRestaurantsdetail().getFacebook()%></a>
									</div>
									<%
										} else {
												}
									%>
									<%
										if (!owner.getRestaurantsdetail().getLine().equalsIgnoreCase("-")
														&& !owner.getRestaurantsdetail().getLine().equalsIgnoreCase("null")) {
									%>
									<div class="media-body">
										<i class="fa fa-linkedin-square fa-2x"></i> <abbr title="line"></abbr>:
										<%=owner.getRestaurantsdetail().getLine()%>
									</div>
									<%
										} else {
												}
									%>
									<%
										if (!owner.getRestaurantsdetail().getLine().equalsIgnoreCase("-")
														&& !owner.getRestaurantsdetail().getLine().equalsIgnoreCase("null")) {
									%>
									<div class="media-body">
										<i class="fa fa-twitter-square fa-2x"></i> <abbr title="twi"></abbr>:
										<%=owner.getRestaurantsdetail().getTwitter()%>
									</div>
									<%
										} else {
												}
									%>
								</div>
							</div>
						</div>
						<!-- End Contact Details Column -->
						<!-- Map+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
						<!-- Intro Content -->
						<div class="row">
							<div class="col-lg-12">
								<h2 class="page-header">แผนที่นำทาง</h2>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<%
									if (!owner.getRestaurantsdetail().getAddress().getMapimage().equals("null.jpg")) {
								%>
								<img class="img-rounded"
									src="Tools/images/mapimage/<%=owner.getRestaurantsdetail().getAddress().getMapimage()%>"
									alt="<%=owner.getRestaurantsdetail().getAddress().getMapimage()%>"
									style="width: 500px; height: 400px;">
								<%
									} else {
								%>
								<img class="img-responsive"
									src="Tools/images/logo/pongyeanglogo.png"
									alt="pongyeanglogo.png" style="width: 500px; height: 400px;">
								<%
									}
								%>
							</div>
							<div class="col-md-6">
								<%=owner.getRestaurantsdetail().getAddress().getMapimagedetail()%>
							</div>
						</div>
						<!-- /.row -->
						<!-- Team Members -->
						<!-- +++++++++++++++++++++++++++++++++++++++++++ -->
					</div>
				</div>
				<!-- End RestauranstsDetail -->
				<!-- **************************************************
				******************************************************************* -->
				<%
					} else {
				%>
				ไม่พบข้อมูลที่ต้องการ
				<%
					}
				%>
				<%
					} else {
				%>
				ไม่พบข้อมูลที่ต้องการ
				<%
					}
				%>
				<hr>
				<div class="row">
					<div class="col-lg-12 text-right">
						<a href="index.jsp" class="btn btn-info">ย้อนกลับ</a>
						<button class="btn btn-success" type="submit">แก้ไขข้อมูล</button>
					</div>
				</div>
				<br>
			</form>
		</div>
	</div>
	<!-- === END CONTENT === -->
	<!-- Begin Footer -->
	<%@include file="pages/footer-menu.jsp"%>
	<!-- End Footer -->
</body>
<!-- Start Show Image Dialog -->
<script type="text/javascript">
	$(document).ready(function() {

		loadGallery(true, 'a.thumbnail');

		//This function disables buttons when needed
		function disableButtons(counter_max, counter_current) {
			$('#show-previous-image, #show-next-image').show();
			if (counter_max == counter_current) {
				$('#show-next-image').hide();
			} else if (counter_current == 1) {
				$('#show-previous-image').hide();
			}
		}

		/**
		 *
		 * @param setIDs        Sets IDs when DOM is loaded. If using a PHP counter, set to false.
		 * @param setClickAttr  Sets the attribute for the click handler.
		 */

		function loadGallery(setIDs, setClickAttr) {
			var current_image, selector, counter = 0;

			$('#show-next-image, #show-previous-image').click(function() {
				if ($(this).attr('id') == 'show-previous-image') {
					current_image--;
				} else {
					current_image++;
				}

				selector = $('[data-image-id="' + current_image + '"]');
				updateGallery(selector);
			});

			function updateGallery(selector) {
				var $sel = selector;
				current_image = $sel.data('image-id');
				$('#image-gallery-caption').text($sel.data('caption'));
				$('#image-gallery-title').text($sel.data('title'));
				$('#image-gallery-image').attr('src', $sel.data('image'));
				disableButtons(counter, $sel.data('image-id'));
			}

			if (setIDs == true) {
				$('[data-image-id]').each(function() {
					counter++;
					$(this).attr('data-image-id', counter);
				});
			}
			$(setClickAttr).on('click', function() {
				updateGallery($(this));
			});
		}
	});
</script>
<!-- End Show Image Dialog -->
</html>