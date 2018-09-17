<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="java.util.*"%>
<%@page import="com.pongyeang.bean.*"%>
<%@page import="com.pongyeang.listVillageCategory.*"%>
<%@page import="com.pongyeang.owner_createprbusinessandtravel.*"%>
<%@page import="java.util.*"%>
<%@page import="com.pongyeang.bean.*"%>
<%
	CreatePRBusinessAndTravelManager createPRBusinessAndTravelManager = new CreatePRBusinessAndTravelManager();
	Vector<VillageCategory> vectorvillagecategort = (Vector<VillageCategory>) request
			.getAttribute("vectorvillagecategort");
	Vector<Category> vectorcategory = (Vector<Category>) request.getAttribute("vectorcatehory");
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
<title>Create PR Business And Travel</title>
<!-- 	Create PR -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBogMg4rJMkMh_ELGp402CttC-XeEbooXw"></script>
<script type="text/javascript" src="Tools/js/js-map/mapUtility.js"></script>
<script
	src="htpps://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="Tools/js/jquery-1.11.1.js" type="text/javascript"></script>
<script src=”http://js.nicedit.com/nicEdit-latest.js”></script>
<script>
			bkLib.onDomLoaded(function()
			{
			new nicEditor().panelInstance(‘detail’);
			});
</script>
<script type="text/javascript">
	function validate() {
		var business = document.forms["createpr"]["business"].value;
		var title = document.forms["createpr"]["title"].value;
		var category = document.forms["createpr"]["category"].value;
		var addressno = document.forms["createpr"]["addressno"].value;
		var villageno = document.forms["createpr"]["villageno"].value;
		var village = document.forms["createpr"]["village"].value;
		var alley = document.forms["createpr"]["alley"].value;
		var street = document.forms["createpr"]["street"].value;
		var subdistrict = document.forms["createpr"]["subdistrict"].value;
		var district = document.forms["createpr"]["district"].value;
		var province = document.forms["createpr"]["province"].value;
		var zipcode = document.forms["createpr"]["zipcode"].value;
		var detail = document.forms["createpr"]["detail"].value;
		var telephone = document.forms["createpr"]["telephone"].value;
		var mapimage = document.forms["createpr"]["mapimage"].value;
		var imagedetail = document.forms["createpr"]["imagedetail"].value;

		var checkaddressno = /^[0-9/]{1,10}$/;
		var checkvillageno = /^[0-9]{1,2}$/;
		var checksubdistrict = /^[ก-์]*$/;
		var checkdistrict = /^[ก-์]*$/;
		var checkprovince = /^[ก-์]*$/;
		var checkzipcode = /^[0-9]{4,6}$/;
		var checktelephone1 = /^[0]\d{9}$/;

		if (business == "") {
			alert("กรุณากรอก ชื่อสถานที่ท่องเที่ยว ด้วยครับ/ค่ะ");
			createpr.business.focus();
			return false;
		}
		if (title == "") {
			alert("กรุณากรอก คำเกริ่นนำ ด้วยครับ/ค่ะ");
			createpr.title.focus();
			return false;
		}
		if (category == "") {
			alert("กรุณากรอก ประเภทสถานที่ท่องเที่ยว ด้วยด้วยครับ/ค่ะ");
			createpr.category.focus();
			return false;
		}
		if (addressno == "") {
			alert("กรุณากรอก บ้านเลขที่ ด้วยครับ/ค่ะ");
			createpr.addressno.focus();
			return false;
		}
		if (!addressno.match(checkaddressno)) {
			alert("กรุณากรอก รูปแบบที่เป็นบ้านเลขที่ ด้วยครับ/ค่ะ");
			createpr.addressno.focus();
			return false;
		}
		if (villageno == "") {
			alert("กรุณากรอก หมู่ที่ ด้วยครับ/ค่ะ");
			createpr.villageno.focus();
			return false;
		}
		if (!villageno.match(checkvillageno)) {
			alert("กรุณากรอก รูปแบบฟอร์มของหมู่ที่ ด้วยครับ/ค่ะ");
			createpr.villageno.focus();
			return false;
		}
		if (alley == "") {
			alert("กรุณากรอก ตรอก/ซอย ด้วยครับ/ค่ะ");
			createpr.alley.focus();
			return false;
		}
		if (street == "") {
			alert("กรุณากรอก ถนน ด้วยครับ/ค่ะ");
			createpr.street.focus();
			return false;
		}
		if (subdistrict == "") {
			alert("กรุณากรอก ตำบล ด้วยครับ/ค่ะ");
			createpr.subdistrict.focus();
			return false;
		}
		if (!subdistrict.match(checksubdistrict)) {
			alert("กรุณากรอก ตำบลเป็นตัวอักษรภาษาไทย ด้วยครับ/ค่ะ");
			createpr.subdistrict.focus();
			return false;
		}
		if (district == "") {
			alert("กรุณากรอก อำเภอ ด้วยครับ/ค่ะ");
			createpr.district.focus();
			return false;
		}
		if (!district.match(checkdistrict)) {
			alert("กรุณากรอก อำเภอเป็นตัวอักษรภาษาไทย ด้วยครับ/ค่ะ");
			createpr.district.focus();
			return false;
		}
		if (province == "") {
			alert("กรุณากรอก จังหวัด ด้วยครับ/ค่ะ");
			createpr.province.focus();
			return false;
		}
		if (!province.match(checkprovince)) {
			alert("กรุณากรอก จังหวัดเป็นตัวอักษรภาษาไทย ด้วยครับ/ค่ะ");
			createpr.province.focus();
			return false;
		}
		if (zipcode == "") {
			alert("กรุณากรอก รหัสไปรษณีย์ ด้วยครับ/ค่ะ");
			createpr.zipcode.focus();
			return false;
		}
		if (!zipcode.match(checkzipcode)) {
			alert("กรุณากรอก เป็นตัวเลขเท่านั้น ด้วยครับ/ค่ะ");
			createpr.zipcode.focus();
			return false;
		}
		if (detail == "") {
			alert("กรุณากรอก เนื้อหารายละเอียดข้อมูล ด้วยครับ/ค่ะ");
			createpr.detail.focus();
			return false;
		}

		if (category == "ที่พัก") {
			var opentimeofhotel = document.forms["createpr"]["opentimeofhotel"].value;
			var checkincheckout = document.forms["createpr"]["checkincheckout"].value;
			var hotelprice = document.forms["createpr"]["hotelprice"].value;
			var roomofnumber = document.forms["createpr"]["roomofnumber"].value;
			var amenitiesofhotel = document.forms["createpr"]["amenitiesofhotel"].value;

			if (opentimeofhotel == "") {
				alert("กรุณากรอก เวลาเปิด-เวลาปิด ด้วย");
				createpr.opentimeofhotel.focus();
				return false;
			}
			if (checkincheckout == "") {
				alert("กรุณากรอก เวลาเช็คอิน-เช็คเอาท์ ด้วย");
				createpr.checkincheckout.focus();
				return false;
			}
			if (hotelprice == "") {
				alert("กรุณากรอก ช่วงราคา ด้วยครับ");
				createpr.hotelprice.focus();
				return false;
			}
			if (roomofnumber == "") {
				alert("กรุณากรอก จำนวนห้อง ด้วยครับ");
				createpr.roomofnumber.focus();
				return false;
			}
			if (amenitiesofhotel == "") {
				alert("กรุณากรอก สิ่งอำนวยความ ด้วย");
				createpr.amenitiesofhotel.focus();
				return false;
			}
		} else if (category == "ร้านค้าบริการ") {
			var opentimeofrestaurants = document.forms["createpr"]["opentimeofrestaurants"].value;
			var pricerange = document.forms["createpr"]["pricerange"].value;
			var amenitiesofrestaurants = document.forms["createpr"]["amenitiesofrestaurants"].value;

			if (opentimeofrestaurants == "") {
				alert("กรุณากรอก เวลาเปิด-เวลาปิด ด้วย");
				createpr.opentimeofrestaurants.focus();
				return false;
			}
			if (pricerange == "") {
				alert("กรุณากรอก ช่วงราคา ด้วย");
				createpr.pricerange.focus();
				return false;
			}
			if (amenitiesofrestaurants == "") {
				alert("กรุณากรอก สิ่งอำนวยความสะดวก ด้วยครับ");
				createpr.amenitiesofrestaurants.focus();
				return false;
			}
		}

		if (telephone == "") {
			alert("กรุณากรอก เบอร์โทรศัพท์ ด้วยครับ/ค่ะ");
			createpr.telephone.focus();
			return false;
		}	
	}
</script>
</head>
<body onload="initialize();">
	<!-- Begin HEADER -->
	<%@include file="pages/header-menu.jsp"%>
	<!-- End HEADER -->
	<%
		if (vectorvillagecategort != null) {
	%>
	<!-- === BEGIN CONTENT === -->
	<div id="content" class="container">
		<div class="row margin-vert-30">
			<!-- Register Box -->
			<div class="col-md-12">
				<form class="signup-page" action="CreatePRBusinessAndTravelServlet"
					method="post" enctype="multipart/form-data" name="createpr">
					<div class="signup-header">
						<h2>สร้างสถานที่ท่องเที่ยว</h2>
					</div>
					<hr>
					<p>
					<h3>ข้อมูลสถานที่ท่องเที่ยว</h3>
					</p>
					<div class="row">
						<div class="col-sm-6">
							<label>ชื่อสถานที่ท่องเที่ยว<span class="color-red">*</span></label>
							<input class="form-control margin-bottom-20" type="text"
								name="business" id="business">
						</div>
						<div class="col-sm-6">
							<label>คำเกริ่นนำ<span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text" name="title"
								id="title">
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<label>ประเภทสถานที่ท่องเที่ยว <span class="color-red">*</span></label>
							<select class="form-control margin-bottom-20" name="category"
								id="category">
								<option value="">เลือกประเภทสถานที่ท่องเที่ยว</option>
								<%
									for (Category category : vectorcategory) {
								%>
								<option value="<%=category.getCategoryName()%>"><%=category.getCategoryName()%></option>
								<%
									}
								%>
							</select>
						</div>
						<div class="col-sm-6">
							<label>ประเภทย่อยของแต่ละสถานที่ท่องเที่ยว <span
								class="color-red">*</span></label> <select
								class="form-control margin-bottom-20" name="subcategory"
								id="subcategory">
								<option value="">เลือกประเภทย่อยของแต่ละสถานที่ท่องเที่ยว</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">
							<label>บ้านเลขที่ <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text"
								name="addressno" id="addressno">
						</div>
						<div class="col-sm-2">
							<label>หมู่ <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text"
								name="villageno" id="villageno">
						</div>
						<div class="col-sm-2">
							<label>หมู่บ้าน <span class="color-red">*</span></label> <select
								class="form-control margin-bottom-20" name="village">
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
								id="alley" value="-">
						</div>
						<div class="col-sm-2">
							<label>ถนน <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text" name="street"
								id="street">
						</div>
						<div class="col-sm-2">
							<label>ตำบล <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text"
								name="subdistrict" id="subdistrict">
						</div>
						<div class="col-sm-2">
							<label>อำเภอ <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text"
								name="district" id="district">
						</div>
						<div class="col-sm-2">
							<label>จังหวัด <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text"
								name="province" id="province">
						</div>
						<div class="col-sm-2">
							<label>รหัสไปรษณีย์ <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="text" name="zipcode"
								id="zipcode">
						</div>
					</div>
					<label>เนื้อหาสถานที่ท่องเที่ยว <span class="color-red">*</span></label>
					<textarea class="form-control margin-bottom-20" rows="3"
						name="detail" id="detail" style="width: 100%;"></textarea>
					<!-- Start SubcategoryTravel -->
					<%@include file="pages/subcategoryhotel-page.jsp"%>
					<!-- End SubcategoryTravel -->
					<!-- Start SubcategoryTravel -->
					<%@include file="pages/subcategoryrestaurants-page.jsp"%>
					<!-- End SubcategoryTravel -->
					<hr>
					<p>
					<h3>ติดต่อ</h3>
					</p>
					<label>เบรอ์โทรศัพท์<span class="color-red">*</span></label> <input
						class="form-control margin-bottom-20" type="text" name="telephone"
						id="telephone"> <label>Facebook<span
						class="color-red">*</span></label> <input
						class="form-control margin-bottom-20" type="text" name="facebook"
						id="facebook" value="-"> <label>Line<span
						class="color-red">*</span></label> <input
						class="form-control margin-bottom-20" type="text" name="line"
						id="line" value="-"><label>Twitter<span
						class="color-red">*</span></label> <input
						class="form-control margin-bottom-20" type="text" name="twitter"
						id="twitter" value="-"> <label>Website<span
						class="color-red">*</span></label> <input
						class="form-control margin-bottom-20" type="text" name="website"
						id="website" value="-">

					<p>
					<h3>รูปภาพเส้นทางการเดินทาง</h3>
					</p>
					<input class="form-control margin-bottom-20" type="file"
						name="mapimage" id="mapimage"> <label>คำอธิบายรูปภาพ<span
						class="color-red">*</span></label>
					<textarea class="form-control margin-bottom-20" rows="3"
						name="mapimagedetail" id="mapimage">-</textarea>
					<p>
					<h3>แผนที่</h3>
					</p>
					<div class="row">
						<div class="col-md-4">
							<label>ละติจูด<span class="color-red">*</span></label> <input
								id="txtLat" name="latiude" type="text" value="18.889068"
								class="form-control margin-bottom-20" />
						</div>
						<div class="col-md-4 col-md-offset-4">
							<label>ลองจิจูด<span class="color-red">*</span></label><input
								id="txtLng" name="longitude" type="text" value="98.829571"
								class="form-control margin-bottom-20" /><br />
						</div>
					</div>
					<center>
						<a
							href="http://www.dpt.go.th/suphanburi/toc/10/102PlaceSuphanburiGeoRSS.html"
							class="btn btn-success">หา ละติจูด และ ลองจิจูด </a>
					</center>
					<br /> <br />
					<div id="map_canvas" style="width: auto; height: 500px;"></div>
					<br>
					<hr>
					<p>
					<h3>รูปภาพ</h3>
					</p>
					<div name="count" id="count">
						<div class="container1">
							<label>รูปภาพ <span class="color-red">*</span></label> <input
								class="form-control margin-bottom-20" type="file" name="image[]"
								id="image"> <label>คำอธิบายรูปภาพ<span
								class="color-red">*</span></label>
							<textarea class="form-control margin-bottom-20" rows="3"
								name="imagedetail[]" id="imagedetail">-</textarea>
						</div>
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
								<button class="btn btn-success" type="submit"
									onclick="return validate()">ตกลง</button>
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
<!--Start Select  SubCategory -->
<script type='text/javascript'>
	$(document).ready(function() {
		$('#category').change(function(event) {
			var sports = $("select#category").val();
			$.get('CreatePRBusinessAndTravelServlet', {
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
<!-- Start Hidden Text -->
<script type='text/javascript'>
	$(".subcategoryhotel").hide();
	$(".subcategoryrestaurants").hide();
	$('#category').on('change', function() {
		$(".subcategoryhotel").hide();
		$(".subcategoryrestaurants").hide();
		if (this.value == 'ที่พัก') {
			$(".subcategoryhotel").show();
		}
		if (this.value == 'ร้านค้าบริการ') {
			$(".subcategoryrestaurants").show();
		}
	});
</script>
<!-- End Hidden Text -->

</html>