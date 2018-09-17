<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.*"%>
	<%@ page import="com.pongyeang.bean.*"%>
	<% String url = "https://b9b7b627.ngrok.io/" ;%>
	<%Category vCategoryAll = (Category)session.getAttribute("listDesc"); 
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
<!-- Google Fonts-->
<link href="http://fonts.googleapis.com/css?family=Lato:400,300"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"
	rel="stylesheet" type="text/css">
	
</head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<body>
	<!-- Begin HEADER -->
	<%@include file="pages/header-menu.jsp"%>
	<!-- End HEADER -->
	<%
		if (vCategoryAll != null || request.getAttribute("noOfPages") != null
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
									<font color="#FFFFFF">สถานที่ท่องเที่ยวยอดนิยม
									</font>
								</h2>
							</div>
						</div>
					</div>
				</div>
		<form >
			<div class="form-group" >
			<table align="center">
			<tr>
			<td><label for="sel1"><h2>เลือกหมวดหมู่ : </h2></label> </td>
			<td><select 
					class="form-control" onChange="window.location.href=this.value">
					<option value="ListFeaturedTravelServlet?category=1" <%if (vCategoryAll.getCategoryID().equals("1")){ %>selected="selected"<%}%>>ที่เที่ยว</option>
					<option value="ListFeaturedTravelServlet?category=2" <%if (vCategoryAll.getCategoryID().equals("2")){ %>selected="selected"<%}%>>ที่พัก</option>
					<option value="ListFeaturedTravelServlet?category=3" <%if (vCategoryAll.getCategoryID().equals("3")){ %>selected="selected"<%}%>>ร้านอาหาร</option>
				</select> </td>
			</tr>
			</table>
				<br>
			</div >
		</form>
		<!-- /.row -->
		<%if(vCategoryAll.getCategoryID().equals("1")){ %>
		<%try{ %>
	       <%for (SubCategoryTravel su : vCategoryAll.getVectorsubcategorytravel()) {%>
				<%for(TravelDetail tv: su.getVectortraveldetail()){ %>
				  <!-- Project One -->
		        <div class="row">
		            <div class="col-md-5">
		                <a href="#">
		                    <img class="img-responsive" src="Tools/images/pr/<%=tv.getAddress().getVectorimages().get(0).getImageName()%>" alt="image2" width="700px" height="400px">
		                </a>
		            </div>
		            <div class="col-md-6">
		                <h3><%=tv.getTraveldetailName() %></h3>
		                <h4>จำนวนคนเข้าชม : <%=tv.getStatisticsvisit() %></h4>
		                <p><%=tv.getTraveldetailTitel() %></p>
		                 <p><div class="fb-like" data-href="http://31d54ffc.ngrok.io/pongyeang/ViewPRTravelDetailServlet?travelID=<%=tv.getTraveldetailID()%>" 
						data-width="500" data-layout="standard" data-action="like" data-size="large" data-show-faces="true" data-share="true"></div></p>
		                <a class="btn btn-primary" href="ViewPRTravelDetailServlet?travelID=<%=tv.getTraveldetailID()%>">อ่านต่อ  <span class="glyphicon glyphicon-chevron-right"></span></a>
		            </div>
		        </div>
		        <hr>
		        <%} %>
			<%} %>
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
											<%if (currentPage >= 2) {%>
											<%if(currentPage == noOfPages ){ %>
											<li><a
												href="ListFeaturedTravelServlet?category=1&&page=<%=currentPage - 1%>"
												aria-label="Previous"><span aria-hidden="true">«</span></a></li>
											<%for( int s = 0 ; s < noOfPages ; s++){ %>
											<li><a href="ListFeaturedTravelServlet?category=1&&page=<%=s+1%>"><span
													aria-hidden="true"><%=s+1%></span></a></li>
											<%} %>
											<%}else{ %>
											<li><a
												href="ListFeaturedTravelServlet?category=1&&page=<%=currentPage - 1%>"
												aria-label="Previous"><span aria-hidden="true">«</span></a></li>
											<%for( int s = 0 ; s < noOfPages ; s++){ %>
											<li><a href="ListFeaturedTravelServlet?category=1&&page=<%=s+1%>"><span
													aria-hidden="true"><%=s+1%></span></a></li>
											<%} %>
											<li><a
												href="ListFeaturedTravelServlet?category=1&&page=<%=currentPage + 1%>"
												aria-label="Next"><span aria-hidden="true">»</span></a></li>

											<%} %>
											<%	}%>
											<%if (currentPage != noOfPages ) {%>
											<%if(currentPage == 1){ %>
											<%for( int s = 0 ; s < noOfPages ; s++){ %>
											<li><a href="ListFeaturedTravelServlet?category=1&&page=<%=s+1%>"><span
													aria-hidden="true"><%=s+1%></span></a></li>
											<%} %>
											<li><a
												href="ListFeaturedTravelServlet?category=1&&page=<%=currentPage + 1%>"
												aria-label="Next"><span aria-hidden="true">»</span></a></li>
											<%}%>
											<%} %>
										</ul>
										</nav>
									</div>
								</div>
							</div>
        <!-- /.row -->
<%}else if(vCategoryAll.getCategoryID().equals("2")){ %>
	<%try{ %>
		 <%for (SubCategoryHotel sh : vCategoryAll.getVectorsubcategoryhotel()) {%>
			 <%for(HotelDetail hd: sh.getVectorhoteldetail()){ %>
				  <!-- Project One -->
		        <div class="row">
		            <div class="col-md-5">
		                <a href="#">
		                    <img class="img-responsive" src="Tools/images/pr/<%=hd.getAddress().getVectorimages().get(0).getImageName()%>" alt="image2" width="700px" height="400px">
		                </a>
		            </div>
		            <div class="col-md-6">
		                <h3><%=hd.getHoteldetailName() %></h3>
		                <h4>จำนวนคนเข้าชม : <%=hd.getStatisticsvisit() %></h4>
		                <p><%=hd.getHoteldetailTitel() %></p>
		                 <p><div class="fb-like" data-href="http://31d54ffc.ngrok.io/pongyeang/ViewHotelsandLodgingDetailServlet?hoteldetailID=<%=hd.getHoteldetailID()%>" 
						data-width="500" data-layout="standard" data-action="like" data-size="large" data-show-faces="true" data-share="true"></div></p>
		                <a class="btn btn-primary" href="ViewHotelsandLodgingDetailServlet?hoteldetailID=<%=hd.getHoteldetailID()%>">อ่านต่อ  <span class="glyphicon glyphicon-chevron-right"></span></a>
		            </div>
		        </div>
		        <hr>
		        <%} %>
			<%} %>
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
											<%if (currentPage >= 2) {%>
											<%if(currentPage == noOfPages ){ %>
											<li><a
												href="ListFeaturedTravelServlet?category=2&&page=<%=currentPage - 1%>"
												aria-label="Previous"><span aria-hidden="true">«</span></a></li>
											<%for( int s = 0 ; s < noOfPages ; s++){ %>
											<li><a href="ListFeaturedTravelServlet?category=2&&page=<%=s+1%>"><span
													aria-hidden="true"><%=s+1%></span></a></li>
											<%} %>
											<%}else{ %>
											<li><a
												href="ListFeaturedTravelServlet?category=2&&page=<%=currentPage - 1%>"
												aria-label="Previous"><span aria-hidden="true">«</span></a></li>
											<%for( int s = 0 ; s < noOfPages ; s++){ %>
											<li><a href="ListFeaturedTravelServlet?category=2&&page=<%=s+1%>"><span
													aria-hidden="true"><%=s+1%></span></a></li>
											<%} %>
											<li><a
												href="ListFeaturedTravelServlet?category=2&&page=<%=currentPage + 1%>"
												aria-label="Next"><span aria-hidden="true">»</span></a></li>

											<%} %>
											<%	}%>
											<%if (currentPage != noOfPages ) {%>
											<%if(currentPage == 1){ %>
											<%for( int s = 0 ; s < noOfPages ; s++){ %>
											<li><a href="ListFeaturedTravelServlet?category=2&&page=<%=s+1%>"><span
													aria-hidden="true"><%=s+1%></span></a></li>
											<%} %>
											<li><a
												href="ListFeaturedTravelServlet?category=2&&page=<%=currentPage + 1%>"
												aria-label="Next"><span aria-hidden="true">»</span></a></li>
											<%}%>
											<%} %>
										</ul>
										</nav>
									</div>
								</div>
							</div>
<%}else if(vCategoryAll.getCategoryID().equals("3")){ %>
	<%try{ %>
		<%for (SubCategoryRestaurants sr : vCategoryAll.getVectorsubcategoryrestaurants()) {%>
			<%for(RestaurantsDetail rd: sr.getVectorrestaurantsdetail()){ %>
				  <!-- Project One -->
		        <div class="row">
		            <div class="col-md-5">
		                <a href="#">
		                    <img class="img-responsive" src="Tools/images/pr/<%=rd.getAddress().getVectorimages().get(0).getImageName()%>" alt="image2" width="700px" height="400px">
		                </a>
		            </div>
		            <div class="col-md-6">
		                <h3><%=rd.getRestaurantsdetailName()%></h3>
		                <h4>จำนวนคนเข้าชม : <%=rd.getStatisticsvisit() %></h4>
		                <p><%=rd.getRestaurantsdetailTitel() %></p>
		                 <p><div class="fb-like" data-href="<%=url%>pongyeang/ViewRestaurantsandShopsDetailServlet?RestaurantsSubID=<%=rd.getRestaurantsdetailID()%>" 
						data-width="500" data-layout="standard" data-action="like" data-size="large" data-show-faces="true" data-share="true"></div></p>
		                <a class="btn btn-primary" href="ViewRestaurantsandShopsDetailServlet?RestaurantsSubID=<%=rd.getRestaurantsdetailID()%>">อ่านต่อ  <span class="glyphicon glyphicon-chevron-right"></span></a>
		            </div>
		        </div>
		        <hr>
        	<%} %>
		<%} %>
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
											<%if (currentPage >= 2) {%>
											<%if(currentPage == noOfPages ){ %>
											<li><a
												href="ListFeaturedTravelServlet?category=3&&page=<%=currentPage - 1%>"
												aria-label="Previous"><span aria-hidden="true">«</span></a></li>
											<%for( int s = 0 ; s < noOfPages ; s++){ %>
											<li><a href="ListFeaturedTravelServlet?category=3&&page=<%=s+1%>"><span
													aria-hidden="true"><%=s+1%></span></a></li>
											<%} %>
											<%}else{ %>
											<li><a
												href="ListFeaturedTravelServlet?category=3&&page=<%=currentPage - 1%>"
												aria-label="Previous"><span aria-hidden="true">«</span></a></li>
											<%for( int s = 0 ; s < noOfPages ; s++){ %>
											<li><a href="ListFeaturedTravelServlet?category=2&&page=<%=s+1%>"><span
													aria-hidden="true"><%=s+1%></span></a></li>
											<%} %>
											<li><a
												href="ListFeaturedTravelServlet?category=3&&page=<%=currentPage + 1%>"
												aria-label="Next"><span aria-hidden="true">»</span></a></li>

											<%} %>
											<%	}%>
											<%if (currentPage != noOfPages ) {%>
											<%if(currentPage == 1){ %>
											<%for( int s = 0 ; s < noOfPages ; s++){ %>
											<li><a href="ListFeaturedTravelServlet?category=3&&page=<%=s+1%>"><span
													aria-hidden="true"><%=s+1%></span></a></li>
											<%} %>
											<li><a
												href="ListFeaturedTravelServlet?category=3&&page=<%=currentPage + 1%>"
												aria-label="Next"><span aria-hidden="true">»</span></a></li>
											<%}%>
											<%} %>
										</ul>
										</nav>
									</div>
								</div>
							</div>
<%} %>
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