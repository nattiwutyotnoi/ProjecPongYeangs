<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create PR Business And Travel(Restaurants)</title>
</head>
<body>
	<div class="subcategoryrestaurants">
		<div class="row">
			<div class="col-sm-6">
				<label>เวลาเปิด -เวลาปิด<span class="color-red">*</span></label> <input
					class="form-control margin-bottom-20" type="text"
					name="opentimeofrestaurants" id="opentimeofrestaurants">
			</div>
			<div class="col-sm-6">
				<label>ช่วงราคา <span class="color-red">*</span></label> <input
					class="form-control margin-bottom-20" type="text" name="pricerange"
					id="pricerange">
			</div>
		</div>
		<label>สิ่งอำนวยความสะดวก<span class="color-red">*</span></label>
		<textarea class="form-control margin-bottom-20" rows="3"
			name="amenitiesofrestaurants" id="amenitiesofrestaurants"></textarea>
	</div>
</body>
</html>
