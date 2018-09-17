<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create PR Business And Travel(Hotel)</title>
</head>
<body>
	<div class="subcategoryhotel">
		<div class="row">
			<div class="col-sm-6">
				<label>เวลาเปิด -เวลาปิด<span class="color-red">*</span></label> <input
					class="form-control margin-bottom-20" type="text"
					name="opentimeofhotel" id="opentimeofhotel">
			</div>
			<div class="col-sm-6">
				<label>ช่วงเวลาเช็คอิน-เช็คเอาท์<span class="color-red">*</span></label>
				<input class="form-control margin-bottom-20" type="text"
					name="checkincheckout" id="checkincheckout">

			</div>
			<div class="col-sm-6">
				<label>ช่วงราคา <span class="color-red">*</span></label> <input
					class="form-control margin-bottom-20" type="text" name="hotelprice"
					id="hotelprice">
			</div>
			<div class="col-sm-6">
				<label>จำนวนห้องพัก<span class="color-red">*</span></label> <input
					class="form-control margin-bottom-20" type="text"
					name="roomofnumber" id="roomofnumber">
			</div>
		</div>
		<label>สิ่งอำนวยความสะดวก<span class="color-red">*</span></label>
		<textarea class="form-control margin-bottom-20" rows="3"
			name="amenitiesofhotel" id="amenitiesofhotel"></textarea>
	</div>
</body>
</html>
