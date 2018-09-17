<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="java.util.*"%>
<%@page import="com.pongyeang.bean.*"%>
<%@page import="com.pongyeang.listVillageCategory.*"%>
<%@page import="com.pongyeang.owner_createprbusinessandtravel.*"%>
<%
	Vector<VillageCategory> vectorvillagecategort = (Vector<VillageCategory>) request
			.getAttribute("vectorvillagecategory");
	Vector<Category> vectorcategory = (Vector<Category>) request.getAttribute("vectorcatehory");
	Owner owner = (Owner) request.getAttribute("owner");
	Vector<Category> listcategory = (Vector<Category>) request.getAttribute("listcategory");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit PR Business And Travel</title>
<!-- 	Edit PR -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBogMg4rJMkMh_ELGp402CttC-XeEbooXw"></script>
<script type="text/javascript" src="Tools/js/js-map/mapUtility.js"></script>
<script
	src="htpps://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="Tools/js/jquery-1.11.1.js" type="text/javascript"></script>
</head>
<body>
	<!-- Begin HEADER -->
	<%@include file="pages/header-menu.jsp"%>
	<!-- End HEADER -->
	<%
		if (request.getAttribute("vectorvillagecategory") != null && request.getAttribute("owner") != null
				&& request.getAttribute("listcategory") != null && request.getAttribute("vectorcatehory") != null) {
	%>
	<!-- === BEGIN CONTENT === -->
	<div id="content" class="container">
		<form class="signup-page" action="EditPRBusinessAndTravelServlet"
			method="post" enctype="multipart/form-data" name="editpr">
			<div class="row margin-vert-30">
				<!-- Register Box -->
				<div class="col-md-12">
					<div class="signup-header">
						<%
							if (owner.getTravledetail().getTraveldetailID() != 0 ) {
						%>
						<!-- Start TravleDetail -->
						<h2>แก้ไขสถานที่ท่องเที่ยว</h2>
					</div>
					<hr>
					<p>
					<h3>ข้อมูลสถานที่ท่องเที่ยว</h3>
					</p>
					<div class="row">
						<div class="col-sm-6">
							<label>ชื่อสถานที่ท่องเที่ยว<span class="color-red">*</span></label>
							<input class="form-control margin-bottom-20" type="text"
								name="business" id="business"
								value="<%=owner.getTravledetail().getTraveldetailName()%>">
						</div>
						<div class="col-sm-6">
							<label>คำเกริ่นนำ<span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text" name="title"
								id="title"
								value="<%=owner.getTravledetail().getTraveldetailTitel()%>">
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<label>ประเภทสถานที่ท่องเที่ยว <span class="color-red">*</span></label>
							<select class="form-control margin-bottom-20" name="category"
								id="category">
								<option value="<%=listcategory.get(0).getCategoryName()%>"><%=listcategory.get(0).getCategoryName()%></option>
								<option value="ท่องเที่ยว">ท่องเที่ยว</option>
							</select>
						</div>
						<div class="col-sm-6">
							<label>ประเภทย่อยของแต่ละสถานที่ท่องเที่ยว <span
								class="color-red">*</span></label> <select
								class="form-control margin-bottom-20" name="subcategory"
								id="subcategory">
								<option
									value="<%=listcategory.get(0).getVectorsubcategorytravel().get(0).getSubcategorytravelName()%>"><%=listcategory.get(0).getVectorsubcategorytravel().get(0).getSubcategorytravelName()%></option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">
							<label>บ้านเลขที่ <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text"
								name="addressno" id="addressno"
								value="<%=owner.getTravledetail().getAddress().getAddressno()%>">
						</div>
						<div class="col-sm-2">
							<label>หมู่ <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text"
								name="villageno" id="villageno"
								value="<%=owner.getTravledetail().getAddress().getVillageno()%>">
						</div>
						<div class="col-sm-2">
							<label>หมู่บ้าน <span class="color-red">*</span></label> <select
								class="form-control margin-bottom-20" name="village">
								<option
									value="<%=owner.getTravledetail().getAddress().getVillageCategoryID().getVillageID()%>"><%=owner.getTravledetail().getAddress().getVillageCategoryID().getVillageName()%></option>
								<%
									for (VillageCategory villagecategory : vectorvillagecategort) {
								%>
								<option value="<%=villagecategory.getVillageID()%>"><%=villagecategory.getVillageName()%></option>
								<%
									}
								%>
							</select>
						</div>
						<div class="col-sm-2">
							<label>ตรอก/ซอย <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text" name="alley"
								id="alley"
								value="<%=owner.getTravledetail().getAddress().getAlley()%>">
						</div>
						<div class="col-sm-2">
							<label>ถนน <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text" name="street"
								id="street"
								value="<%=owner.getTravledetail().getAddress().getStreet()%>">
						</div>
						<div class="col-sm-2">
							<label>ตำบล <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text"
								name="subdistrict" id="subdistrict"
								value="<%=owner.getTravledetail().getAddress().getSubdistrict()%>">
						</div>
						<div class="col-sm-2">
							<label>อำเภอ <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text"
								name="district" id="district"
								value="<%=owner.getTravledetail().getAddress().getDistrict()%>">
						</div>
						<div class="col-sm-2">
							<label>จังหวัด <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text"
								name="province" id="province"
								value="<%=owner.getTravledetail().getAddress().getProvince()%>">
						</div>
						<div class="col-sm-2">
							<label>รหัสไปรษณีย์ <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text" name="zipcode"
								id="zipcode"
								value="<%=owner.getTravledetail().getAddress().getZipcode()%>">
						</div>
					</div>

					<label>เนื้อหาสถานที่ท่องเที่ยว <span class="color-red">*</span></label>
					<textarea class="form-control margin-bottom-20" rows="3"
						name="detail" id="detail"><%=owner.getTravledetail().getTraveldetailData()%></textarea>
					<hr>
					<!-- Start SubcategoryTravel -->
					<%@include file="pages/subcategoryhotel-page.jsp"%>
					<!-- End SubcategoryTravel -->
					<!-- Start SubcategoryTravel -->
					<%@include file="pages/subcategoryrestaurants-page.jsp"%>
					<!-- End SubcategoryTravel -->
					<script>
						$(".subcategoryhotel").hide();
						$(".subcategoryrestaurants").hide();
						$('#category').on('change', function() {
							if (this.value == 'ที่พัก') {
								$(".subcategoryhotel").show();
								$(".subcategoryrestaurants").hide();
							}
							if (this.value == 'ร้านค้าบริการ') {
								$(".subcategoryrestaurants").show();
								$(".subcategoryhotel").hide();
							}
							if (this.value == 'ท่องเที่ยว') {
								$(".subcategoryrestaurants").hide();
								$(".subcategoryhotel").hide();
							}
						});
					</script>
					<p>
					<h3>ติด ต่อ</h3>
					</p>
					<label>เบรอ์โทรศัพท์<span class="color-red">*</span></label> <input
						class="form-control margin-bottom-20" type="text" name="telephone"
						id="telephone"
						value="<%=owner.getTravledetail().getTelephone()%>">
					<label>Facebook<span class="color-red">*</span></label> <input
						class="form-control margin-bottom-20" type="text" name="facebook"
						id="facebook"
						value="<%=owner.getTravledetail().getFacebook()%>">
					<label>Line<span class="color-red">*</span></label> <input
						class="form-control margin-bottom-20" type="text" name="line"
						id="line"
						value="<%=owner.getTravledetail().getLine()%>"><label>Twitter<span
						class="color-red">*</span></label> <input
						class="form-control margin-bottom-20" type="text" name="twitter"
						id="twitter"
						value="<%=owner.getTravledetail().getTwitter()%>">
					<label>Website<span class="color-red">*</span></label> <input
						class="form-control margin-bottom-20" type="text" name="website"
						id="website"
						value="<%=owner.getTravledetail().getWebsite()%>">

					<p>
					<h3>รูปภาพเส้นทางการเดินทาง</h3>
					</p>
					<div class="row">
						<div class="col-md-6">
							<img id="output" width="400" height="340"
								src="Tools/images/mapimage/<%=owner.getTravledetail().getAddress().getMapimage()%>">
						</div>
						<div class="col-md-6">
							<h4 class="color-red">หากต้องการแก้ไขรูปภาพให้ทำการเลือกรูปภาพใหม่</h4>
							<input class="form-control margin-bottom-20" type="file"
								name="mapimage" id="mapimage" onchange="loadFile(output)">
							<label>คำอธิบายรูปภาพ<span class="color-red">*</span></label>
							<textarea class="form-control margin-bottom-20" rows="3"
								name="mapimagedetail" id="mapimage"><%=owner.getTravledetail().getAddress().getMapimagedetail()%></textarea>
						</div>
					</div>
					<p>
					<h3>แผนที่</h3>
					</p>
					<div class="row">
						<div class="col-md-4">
							<label>ละติจูด<span class="color-red">*</span></label> <input
								id="txtLat" name="latiude" type="text"
								class="form-control margin-bottom-20"
								value="<%=owner.getTravledetail().getAddress().getLatitude()%>" />
						</div>
						<div class="col-md-4 col-md-offset-4">
							<label>ลองจิจูด<span class="color-red">*</span></label><input
								id="txtLng" name="longitude" type="text"
								class="form-control margin-bottom-20"
								value="<%=owner.getTravledetail().getAddress().getLongtitude()%>" /><br />
						</div>
					</div>
					<center>
						<a
							href="http://www.dpt.go.th/suphanburi/toc/10/102PlaceSuphanburiGeoRSS.html"
							class="btn btn-success">หา ละติจูด และ ลองจิจูด </a>
					</center>
					<br /> <br />
					<!-- 	<div id="map_canvas" style="width: auto; height: 500px;"></div> -->
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
					<br>
					<hr>
					<p>
					<h3>รูปภาพ</h3>
					</p>

					<div name="count" id="count">
						<div class="container1">
							<%
								for (int i = 0; i < owner.getTravledetail().getAddress().getVectorimages().size(); i++) {
							%>
							<div class="removeimage" id="removeimage">
								<div class="row">
									<div class="col-md-6">
										<img
											alt="<%=owner.getTravledetail().getAddress().getVectorimages().get(i).getImageName()%>"
											src="Tools/images/pr/<%=owner.getTravledetail().getAddress().getVectorimages().get(i).getImageName()%>"
											style="width: 500px; height: 280px;" class="img-thumbnail">

									</div>
									<div class="col-md-6">
										<label>รูปภาพ <span class="color-red">*</span></label> <input
											class="form-control margin-bottom-20" type="file"
											name="image[]" id="image"
											value="<%=owner.getTravledetail().getAddress().getVectorimages().get(i).getImageName()%>">
										<input type="hidden" name="hiddemimage"
											value="<%=owner.getTravledetail().getAddress().getVectorimages().get(i).getImageName()%>" />
										<label>คำอธิบายรูปภาพ<span class="color-red">*</span></label>
										<textarea class="form-control margin-bottom-20" rows="3"
											name="imagedetail[]" id="imagedetail"><%=owner.getTravledetail().getAddress().getVectorimages().get(i).getImageDetail()%></textarea>
										<a
											href="DeleteImagePRBusinessAndTravelServlet?imageID=<%=owner.getTravledetail().getAddress().getVectorimages().get(i).getImageID()%>&&imageName=<%=owner.getTravledetail().getAddress().getVectorimages().get(i).getImageName()%>"
											class="remove btn btn-danger" id="remove"
											Onclick="return removeElement(editpr)">Delete</a>
									</div>
								</div>
							</div>
							<br>
							<%
								}
							%>
							<div class="col-lg-12 text-right">
							<button class="add_form_field btn btn-info btn-lg">
								<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							</button>
						</div>
						</div>
						<!-- End TravleDetail -->
						<!-- Start RestauranstsDetail -->
						<%
							} else if (owner.getRestaurantsdetail().getRestaurantsdetailID() != 0) {
						%>
						<h2>แก้ไขสถานที่ท่องเที่ยว</h2>
					</div>
					<hr>
					<p>
					<h3>ข้อมูลสถานที่ท่องเที่ยว</h3>
					</p>
					<div class="row">
						<div class="col-sm-6">
							<label>ชื่อสถานที่ท่องเที่ยว<span class="color-red">*</span></label>
							<input class="form-control margin-bottom-20" type="text"
								name="business" id="business"
								value="<%=owner.getRestaurantsdetail().getRestaurantsdetailName()%>">
						</div>
						<div class="col-sm-6">
							<label>คำเกริ่นนำ<span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text" name="title"
								id="title"
								value="<%=owner.getRestaurantsdetail().getRestaurantsdetailTitel()%>">
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<label>ประเภทสถานที่ท่องเที่ยว <span class="color-red">*</span></label>
							<select class="form-control margin-bottom-20" name="category"
								id="category">
								<option value="<%=listcategory.get(0).getCategoryName()%>"><%=listcategory.get(0).getCategoryName()%></option>
								<option value="ร้านค้าบริการ">ร้านค้าบริการ</option>
							</select>
						</div>
						<div class="col-sm-6">
							<label>ประเภทย่อยของแต่ละสถานที่ท่องเที่ยว <span
								class="color-red">*</span></label> <select
								class="form-control margin-bottom-20" name="subcategory"
								id="subcategory">
								<option
									value="<%=listcategory.get(0).getVectorsubcategoryrestaurants().get(0)
							.getSubcategoryrestaurantName()%>"><%=listcategory.get(0).getVectorsubcategoryrestaurants().get(0)
							.getSubcategoryrestaurantName()%></option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">
							<label>บ้านเลขที่ <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text"
								name="addressno" id="addressno"
								value="<%=owner.getRestaurantsdetail().getAddress().getAddressno()%>">
						</div>
						<div class="col-sm-2">
							<label>หมู่ <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text"
								name="villageno" id="villageno"
								value="<%=owner.getRestaurantsdetail().getAddress().getVillageno()%>">
						</div>
						<div class="col-sm-2">
							<label>หมู่บ้าน <span class="color-red">*</span></label> <select
								class="form-control margin-bottom-20" name="village">
								<option
									value="<%=owner.getRestaurantsdetail().getAddress().getVillageCategoryID().getVillageID()%>"><%=owner.getRestaurantsdetail().getAddress().getVillageCategoryID().getVillageName()%></option>
								<%
									for (VillageCategory villagecategory : vectorvillagecategort) {
								%>
								<option value="<%=villagecategory.getVillageID()%>"><%=villagecategory.getVillageName()%></option>
								<%
									}
								%>
							</select>
						</div>
						<div class="col-sm-2">
							<label>ตรอก/ซอย <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text" name="alley"
								id="alley"
								value="<%=owner.getRestaurantsdetail().getAddress().getAlley()%>">
						</div>
						<div class="col-sm-2">
							<label>ถนน <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text" name="street"
								id="street"
								value="<%=owner.getRestaurantsdetail().getAddress().getStreet()%>">
						</div>
						<div class="col-sm-2">
							<label>ตำบล <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text"
								name="subdistrict" id="subdistrict"
								value="<%=owner.getRestaurantsdetail().getAddress().getSubdistrict()%>">
						</div>
						<div class="col-sm-2">
							<label>อำเภอ <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text"
								name="district" id="district"
								value="<%=owner.getRestaurantsdetail().getAddress().getDistrict()%>">
						</div>
						<div class="col-sm-2">
							<label>จังหวัด <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text"
								name="province" id="province"
								value="<%=owner.getRestaurantsdetail().getAddress().getProvince()%>">
						</div>
						<div class="col-sm-2">
							<label>รหัสไปรษณีย์ <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text" name="zipcode"
								id="zipcode"
								value="<%=owner.getRestaurantsdetail().getAddress().getZipcode()%>">
						</div>
					</div>

					<label>เนื้อหาสถานที่ท่องเที่ยว <span class="color-red">*</span></label>
					<textarea class="form-control margin-bottom-20" rows="3"
						name="detail" id="detail"><%=owner.getRestaurantsdetail().getRestaurantsdetailData()%></textarea>
					<hr>
					<!-- Start SubcategoryTravel -->
					<%@include file="pages/subcategoryhotel-page.jsp"%>
					<!-- End SubcategoryTravel -->
					<div class="subcategoryrestaurants" id="subcategoryrestaurants">
						<div class="row">
							<div class="col-sm-6">
								<label>เวลาเปิด -เวลาปิด<span class="color-red">*</span></label>
								<input class="form-control margin-bottom-20" type="text"
									name="opentimeofrestaurants" id="opentimeofrestaurants"
									value="<%=owner.getRestaurantsdetail().getOpentime()%>">
							</div>
							<div class="col-sm-6">
								<label>ช่วงราคา <span class="color-red">*</span></label> <input
									class="form-control margin-bottom-20" type="text"
									name="pricerange" id="pricerange"
									value="<%=owner.getRestaurantsdetail().getPricerange()%>">
							</div>
						</div>
						<label>สิ่งอำนวยความสะดวก<span class="color-red">*</span></label>
						<textarea class="form-control margin-bottom-20" rows="3"
							name="amenitiesofrestaurants" id="amenitiesofrestaurants"><%=owner.getRestaurantsdetail().getAmenities()%></textarea>
					</div>

					<script type='text/javascript'>
						$(".subcategoryhotel").hide();
						$('#category').on('change', function() {
							if (this.value == 'ที่พัก') {
								$(".subcategoryhotel").show();
								$(".subcategoryrestaurants").hide();
							}
							if (this.value == 'ร้านค้าบริการ') {
								$(".subcategoryrestaurants").show();
								$(".subcategoryhotel").hide();
							}
							if (this.value == 'ท่องเที่ยว') {
								$(".subcategoryrestaurants").hide();
								$(".subcategoryhotel").hide();
							}
						});
					</script>
					<p>
					<h3>ติดต่อ</h3>
					</p>
					<label>เบรอ์โทรศัพท์<span class="color-red">*</span></label> <input
						class="form-control margin-bottom-20" type="text" name="telephone"
						id="telephone"
						value="<%=owner.getRestaurantsdetail().getTelephone()%>">
					<label>Facebook<span class="color-red">*</span></label> <input
						class="form-control margin-bottom-20" type="text" name="facebook"
						id="facebook"
						value="<%=owner.getRestaurantsdetail().getFacebook()%>">
					<label>Line<span class="color-red">*</span></label> <input
						class="form-control margin-bottom-20" type="text" name="line"
						id="line"
						value="<%=owner.getRestaurantsdetail().getLine()%>"><label>Twitter<span
						class="color-red">*</span></label> <input
						class="form-control margin-bottom-20" type="text" name="twitter"
						id="twitter"
						value="<%=owner.getRestaurantsdetail().getTwitter()%>">
					<label>Website<span class="color-red">*</span></label> <input
						class="form-control margin-bottom-20" type="text" name="website"
						id="website"
						value="<%=owner.getRestaurantsdetail().getWebsite()%>">
					<p>
					<h3>รูปภาพเส้นทางการเดินทาง</h3>
					</p>
					<div class="row">
						<div class="col-md-6">
							<img id="output" width="400" height="340"
								src="Tools/images/mapimage/<%=owner.getRestaurantsdetail().getAddress().getMapimage()%>">
						</div>
						<div class="col-md-6">
							<h4 class="color-red">หากต้องการแก้ไขรูปภาพให้ทำการเลือกรูปภาพใหม่</h4>
							<input class="form-control margin-bottom-20" type="file"
								name="mapimage" id="mapimage" onchange="loadFile(output)">
							<label>คำอธิบายรูปภาพ<span class="color-red">*</span></label>
							<textarea class="form-control margin-bottom-20" rows="3"
								name="mapimagedetail" id="mapimage"><%=owner.getRestaurantsdetail().getAddress().getMapimagedetail()%></textarea>
						</div>
					</div>
					<p>
					<h3>แผนที่</h3>
					</p>
					<div class="row">
						<div class="col-md-4">
							<label>ละติจูด<span class="color-red">*</span></label> <input
								id="txtLat" name="latiude" type="text"
								class="form-control margin-bottom-20"
								value="<%=owner.getRestaurantsdetail().getAddress().getLatitude()%>" />
						</div>
						<div class="col-md-4 col-md-offset-4">
							<label>ลองจิจูด<span class="color-red">*</span></label><input
								id="txtLng" name="longitude" type="text"
								class="form-control margin-bottom-20"
								value="<%=owner.getRestaurantsdetail().getAddress().getLongtitude()%>" /><br />
						</div>
					</div>
					<center>
						<a
							href="http://www.dpt.go.th/suphanburi/toc/10/102PlaceSuphanburiGeoRSS.html"
							class="btn btn-success">หา ละติจูด และ ลองจิจูด </a>
					</center>
					<br /> <br />
					<!-- <div id="map_canvas" style="width: auto; height: 500px;"></div> -->
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
					<br>
					<hr>
					<p>
					<h3>รูปภาพ</h3>
					</p>
					<div class="container1">
						<%
							for (int i = 0; i < owner.getRestaurantsdetail().getAddress().getVectorimages().size(); i++) {
						%>
						<div class="removeimage" id="removeimage">
							<div class="row">
								<div class="col-md-6">
									<img
										alt="<%=owner.getRestaurantsdetail().getAddress().getVectorimages().get(i).getImageName()%>"
										src="Tools/images/pr/<%=owner.getRestaurantsdetail().getAddress().getVectorimages().get(i).getImageName()%>"
										style="width: 500px; height: 280px;" class="img-thumbnail">
								</div>
								<div class="col-md-6">
									<label>รูปภาพ <span class="color-red">*</span></label> <input
										class="form-control margin-bottom-20" type="file"
										name="image[]" id="image"
										value="Tools/images/pr/<%=owner.getRestaurantsdetail().getAddress().getVectorimages().get(i).getImageName()%>">
									<input type="hidden" name="hiddemimage"
										value="<%=owner.getRestaurantsdetail().getAddress().getVectorimages().get(i).getImageName()%>" />
									<label>คำอธิบายรูปภาพ<span class="color-red">*</span></label>
									<textarea class="form-control margin-bottom-20" rows="3"
										name="imagedetail[]" id="imagedetail"><%=owner.getRestaurantsdetail().getAddress().getVectorimages().get(i).getImageDetail()%></textarea>
									<a
										href="DeleteImagePRBusinessAndTravelServlet?imageID=<%=owner.getRestaurantsdetail().getAddress().getVectorimages().get(i).getImageID()%>&&imageName=<%=owner.getRestaurantsdetail().getAddress().getVectorimages().get(i).getImageName()%>"
										class="remove btn btn-danger" id="remove"
										Onclick="return removeElement(editpr)">Delete</a>
								</div>
							</div>
						</div>					
						<%}%>
						<div class="col-lg-12 text-right">
							<button class="add_form_field btn btn-info btn-lg">
								<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							</button>
						</div>
						<!-- Start RestauranstsDetail -->
						<!-- Start HotelDeatil -->
						<%
							} else if (owner.getHoteldetail().getHoteldetailID() != 0) {
						%>
						<hr>
						<p>
						<h3>ข้อมูลสถานที่ท่องเที่ยว</h3>
						</p>
						<div class="row">
							<div class="col-sm-6">
								<label>ชื่อสถานที่ท่องเที่ยว<span class="color-red">*</span></label>
								<input class="form-control margin-bottom-20" type="text"
									name="business" id="business"
									value="<%=owner.getHoteldetail().getHoteldetailName()%>">
							</div>
							<div class="col-sm-6">
								<label>คำเกริ่นนำ<span class="color-red">*</span></label> <input
									class="form-control margin-bottom-20" type="text" name="title"
									id="title"
									value="<%=owner.getHoteldetail().getHoteldetailTitel()%>">
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<label>ประเภทสถานที่ท่องเที่ยว <span class="color-red">*</span></label>
								<select class="form-control margin-bottom-20" name="category"
									id="category">
									<option value="<%=listcategory.get(0).getCategoryName()%>"><%=listcategory.get(0).getCategoryName()%></option>
									<option value="ที่พัก">ที่พัก</option>
								</select>
							</div>
							<div class="col-sm-6">
								<label>ประเภทย่อยของแต่ละสถานที่ท่องเที่ยว <span
									class="color-red">*</span></label> <select
									class="form-control margin-bottom-20" name="subcategory"
									id="subcategory">
									<option
										value="<%=listcategory.get(0).getVectorsubcategoryhotel().get(0).getSubcategoryhotelName()%>"><%=listcategory.get(0).getVectorsubcategoryhotel().get(0).getSubcategoryhotelName()%></option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-2">
								<label>บ้านเลขที่ <span class="color-red">*</span></label> <input
									class="form-control margin-bottom-20" type="text"
									name="addressno" id="addressno"
									value="<%=owner.getHoteldetail().getAddress().getAddressno()%>">
							</div>
							<div class="col-sm-2">
								<label>หมู่ <span class="color-red">*</span></label> <input
									class="form-control margin-bottom-20" type="text"
									name="villageno" id="villageno"
									value="<%=owner.getHoteldetail().getAddress().getVillageno()%>">
							</div>
							<div class="col-sm-2">
								<label>หมู่บ้าน <span class="color-red">*</span></label> <select
									class="form-control margin-bottom-20" name="village">
									<option
										value="<%=owner.getHoteldetail().getAddress().getVillageCategoryID().getVillageID()%>"><%=owner.getHoteldetail().getAddress().getVillageCategoryID().getVillageName()%></option>
									<%
										for (VillageCategory villagecategory : vectorvillagecategort) {
									%>
									<option value="<%=villagecategory.getVillageID()%>"><%=villagecategory.getVillageName()%></option>
									<%
										}
									%>
								</select>
							</div>
							<div class="col-sm-2">
								<label>ตรอก/ซอย <span class="color-red">*</span></label> <input
									class="form-control margin-bottom-20" type="text" name="alley"
									id="alley"
									value="<%=owner.getHoteldetail().getAddress().getAlley()%>">
							</div>
							<div class="col-sm-2">
								<label>ถนน <span class="color-red">*</span></label> <input
									class="form-control margin-bottom-20" type="text" name="street"
									id="street"
									value="<%=owner.getHoteldetail().getAddress().getStreet()%>">
							</div>
							<div class="col-sm-2">
								<label>ตำบล <span class="color-red">*</span></label> <input
									class="form-control margin-bottom-20" type="text"
									name="subdistrict" id="subdistrict"
									value="<%=owner.getHoteldetail().getAddress().getSubdistrict()%>">
							</div>
							<div class="col-sm-2">
								<label>อำเภอ <span class="color-red">*</span></label> <input
									class="form-control margin-bottom-20" type="text"
									name="district" id="district"
									value="<%=owner.getHoteldetail().getAddress().getDistrict()%>">
							</div>
							<div class="col-sm-2">
								<label>จังหวัด <span class="color-red">*</span></label> <input
									class="form-control margin-bottom-20" type="text"
									name="province" id="province"
									value="<%=owner.getHoteldetail().getAddress().getProvince()%>">
							</div>
							<div class="col-sm-2">
								<label>รหัสไปรษณีย์ <span class="color-red">*</span></label> <input
									class="form-control margin-bottom-20" type="text"
									name="zipcode" id="zipcode"
									value="<%=owner.getHoteldetail().getAddress().getZipcode()%>">
							</div>
						</div>
						<label>เนื้อหาสถานที่ท่องเที่ยว <span class="color-red">*</span></label>
						<textarea class="form-control margin-bottom-20" rows="3"
							name="detail" id="detail"><%=owner.getHoteldetail().getHoteldetailData()%></textarea>
						<hr>
						<div class="subcategoryhotel">
							<div class="row">
								<div class="col-sm-6">
									<label>เวลาเปิด -เวลาปิด<span class="color-red">*</span></label>
									<input class="form-control margin-bottom-20" type="text"
										name="opentimeofhotel" id="opentimeofhotel"
										value="<%=owner.getHoteldetail().getOpentime()%>">
								</div>
								<div class="col-sm-6">
									<label>ช่วงเวลาเช็คอิน-เช็คเอาท์<span class="color-red">*</span></label>
									<input class="form-control margin-bottom-20" type="text"
										name="checkincheckout" id="checkincheckout"
										value="<%=owner.getHoteldetail().getCheckincheckout()%>">
								</div>
								<div class="col-sm-6">
									<label>ช่วงราคา <span class="color-red">*</span></label> <input
										class="form-control margin-bottom-20" type="text"
										name="hotelprice" id="hotelprice"
										value="<%=owner.getHoteldetail().getHotelprice()%>">
								</div>
								<div class="col-sm-6">
									<label>จำนวนห้องพัก<span class="color-red">*</span></label> <input
										class="form-control margin-bottom-20" type="text"
										name="roomofnumber" id="roomofnumber"
										value="<%=owner.getHoteldetail().getRoomofnumber()%>">
								</div>
							</div>
							<label>สิ่งอำนวยความสะดวก<span class="color-red">*</span></label>
							<textarea class="form-control margin-bottom-20" rows="3"
								name="amenitiesofhotel" id="amenitiesofhotel"><%=owner.getHoteldetail().getAmenities()%></textarea>
						</div>
						<!-- Start SubcategoryTravel -->
						<%@include file="pages/subcategoryrestaurants-page.jsp"%>
						<!-- End SubcategoryTravel -->
						<script type='text/javascript'>
							$(".subcategoryrestaurants").hide();
							$('#category').on('change', function() {
								if (this.value == 'ที่พัก') {
									$(".subcategoryhotel").show();
									$(".subcategoryrestaurants").hide();
								}
								if (this.value == 'ร้านค้าบริการ') {
									$(".subcategoryrestaurants").show();
									$(".subcategoryhotel").hide();
								}
								if (this.value == 'ท่องเที่ยว') {
									$(".subcategoryrestaurants").hide();
									$(".subcategoryhotel").hide();
								}
							});
						</script>
						<p>
						<h3>ติดต่อ</h3>
						</p>
						<label>เบรอ์โทรศัพท์<span class="color-red">*</span></label> <input
							class="form-control margin-bottom-20" type="text"
							name="telephone" id="telephone"
							value="<%=owner.getHoteldetail().getTelephone()%>">
						<label>Facebook<span class="color-red">*</span></label> <input
							class="form-control margin-bottom-20" type="text" name="facebook"
							id="facebook"
							value="<%=owner.getHoteldetail().getFacebook()%>">
						<label>Line<span class="color-red">*</span></label> <input
							class="form-control margin-bottom-20" type="text" name="line"
							id="line"
							value="<%=owner.getHoteldetail().getLine()%>">
						<label>Twitter<span class="color-red">*</span></label> <input
							class="form-control margin-bottom-20" type="text" name="twitter"
							id="twitter"
							value="<%=owner.getHoteldetail().getTwitter()%>">
						<label>Website<span class="color-red">*</span></label> <input
							class="form-control margin-bottom-20" type="text" name="website"
							id="website"
							value="<%=owner.getHoteldetail().getWebsite()%>">
						<p>
						<h3>รูปภาพเส้นทางการเดินทาง</h3>
						</p>
						<div class="row">
							<div class="col-md-6">
								<img id="output" width="400" height="340"
									src="Tools/images/mapimage/<%=owner.getHoteldetail().getAddress().getMapimage()%>">
							</div>
							<div class="col-md-6">
								<h4 class="color-red">หากต้องการแก้ไขรูปภาพให้ทำการเลือกรูปภาพใหม่</h4>
								<input class="form-control margin-bottom-20" type="file"
									name="mapimage" id="mapimage" onchange="loadFile(output)">
								<label>คำอธิบายรูปภาพ<span class="color-red">*</span></label>
								<textarea class="form-control margin-bottom-20" rows="3"
									name="mapimagedetail" id="mapimage"><%=owner.getHoteldetail().getAddress().getMapimagedetail()%></textarea>
							</div>
						</div>
						<p>
						<h3>แผนที่</h3>
						</p>
						<div class="row">
							<div class="col-md-4">
								<label>ละติจูด<span class="color-red">*</span></label> <input
									id="txtLat" name="latiude" type="text"
									class="form-control margin-bottom-20"
									value="<%=owner.getHoteldetail().getAddress().getLatitude()%>" />
							</div>
							<div class="col-md-4 col-md-offset-4">
								<label>ลองจิจูด<span class="color-red">*</span></label><input
									id="txtLng" name="longitude" type="text"
									class="form-control margin-bottom-20"
									value="<%=owner.getHoteldetail().getAddress().getLongtitude()%>" /><br />
							</div>
						</div>
						<center>
							<a
								href="http://www.dpt.go.th/suphanburi/toc/10/102PlaceSuphanburiGeoRSS.html"
								class="btn btn-success">หา ละติจูด และ ลองจิจูด </a>
						</center>
						<br /> <br />
						<!-- <div id="map_canvas" style="width: auto; height: 500px;"></div> -->
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
						<br>
						<hr>
						<p>
						<h3>รูปภาพ</h3>
						</p>
						<div class="row">
							<div name="count" id="count">
								<div class="container1">
									<%
										for (int i = 0; i < owner.getHoteldetail().getAddress().getVectorimages().size(); i++) {
									%>
									<div class="removeimage" id="removeimage">
										<div class="row">
											<div class="col-md-6">
												<img
													alt="<%=owner.getHoteldetail().getAddress().getVectorimages().get(i).getImageName()%>"
													src="Tools/images/pr/<%=owner.getHoteldetail().getAddress().getVectorimages().get(i).getImageName()%>"
													style="width: 500px; height: 280px;" class="img-thumbnail">
											</div>
											<div class="col-md-6">
												<label>รูปภาพ <span class="color-red">*</span></label> <input
													class="form-control margin-bottom-20" type="file"
													name="image[]" id="image"
													value="Tools/images/pr/<%=owner.getHoteldetail().getAddress().getVectorimages().get(i).getImageName()%>">
												<input type="hidden" name="hiddemimage"
													value="<%=owner.getHoteldetail().getAddress().getVectorimages().get(i).getImageName()%>" />
												<label>คำอธิบายรูปภาพ<span class="color-red">*</span></label>
												<textarea class="form-control margin-bottom-20" rows="3"
													name="imagedetail[]" id="imagedetail"><%=owner.getHoteldetail().getAddress().getVectorimages().get(i).getImageDetail()%></textarea>
												<a
													href="DeleteImagePRBusinessAndTravelServlet?imageID=<%=owner.getHoteldetail().getAddress().getVectorimages().get(i).getImageID()%>&&imageName=<%=owner.getHoteldetail().getAddress().getVectorimages().get(i).getImageName()%>"
													class="remove btn btn-danger" id="remove"
													Onclick="return removeElement(editpr)">Delete</a>
											</div>
										</div>
									</div>
									<%
										}
									%>
								</div>
							</div>
						</div>
						<div class="col-lg-12 text-right">
							<button class="add_form_field btn btn-info btn-lg">
								<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							</button>
						</div>
						<!-- End HotelDeatil -->
						<%
							}
						%>		
									
						<hr>
						<div class="row">
							<center>
							<div class="col-lg-12">
								<button class="btn btn-success" type="submit">ตกลง</button>
								<a href="index.jsp" class="btn btn-danger">ยกเลิก</a>
							</div>
							</center>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- End Register Box -->
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
<%if (owner.getTravledetail().getTraveldetailID() != 0) {%>
	
<%for (int i = 0; i < owner.getTravledetail().getAddress().getVectorimages().size(); i++) {%>
	min_fields =
<%=owner.getTravledetail().getAddress().getVectorimages().size()%>
	
<%}%>
	
<%} else if (owner.getRestaurantsdetail().getRestaurantsdetailID() != 0) {%>
	
<%for (int i = 0; i < owner.getRestaurantsdetail().getAddress().getVectorimages().size(); i++) {%>
	min_fields =
<%=owner.getRestaurantsdetail().getAddress().getVectorimages().size()%>
	
<%}%>
	
<%} else if (owner.getHoteldetail().getHoteldetailID() != 0) {%>
	
<%for (int i = 0; i < owner.getHoteldetail().getAddress().getVectorimages().size(); i++) {%>
	min_fields =
<%=owner.getHoteldetail().getAddress().getVectorimages().size()%>
	
<%}%>
	
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
																'<div ><label>รูปภาพ<span class="color-red">*</span></label> <br>'
																		+ '<input class="form-control margin-bottom-20" type="file" name="image[]" id="image" onchange="loadFile(event)"> '
																		+ '<input type="hidden" name="hiddemimage" value="" />	'
																		+ '<label>คำอธิบายรูปภาพ<span class="color-red">*</span></label>'
																		+ '<textarea class="form-control margin-bottom-20" rows="3" name="imagedetail[]" id="imagedetail">-</textarea>'
																		+ '<a href="#" class="delete btn btn-danger">Delete</a>'
																		+ '</div>');
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
<!--Start Select  SubCategory -->
<script type='text/javascript'>
	$(document).ready(function() {
		$('#category').change(function(event) {
			var sports = $("select#category").val();
			$.get('EditPRBusinessAndTravelServlet', {
				categoryName : sports
			}, function(jsonResponse) {
				var select = $('#subcategory');
				select.find('option').remove();
				$.each(jsonResponse, function(index, value) {
					$('<option>').val(value).text(value).appendTo(select);
				});
			});
		});
	});
</script>
<!--End Select  SubCategory -->
<!-- Start Edit Image -->
<script>
	var loadFile = function(output) {
		var output = document.getElementById('output');
		output.src = URL.createObjectURL(event.target.files[0]);
	};
</script>
<!-- End Edit Image -->
<!-- Start Edit image -->
<script language=javascript>
	function removeElement(editpr) {
		// Removes an element from the document
		var element = document.getElementById('removeimage');
		element.parentNode.removeChild(element);
	}
</script>
<!-- End Edit image -->
</html>