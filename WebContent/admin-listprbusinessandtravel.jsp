<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.*"%>
	<%@ page import="com.pongyeang.bean.*"%>
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
<title>ListPR</title>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<body>
	<!-- Begin HEADER -->
	<%@include file="pages/header-menu.jsp"%>
	<!-- End HEADER -->
	
	 <!-- Page Content -->
    <div class="container">

        <!-- Page Heading -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">สถานที่ท่องเที่ยวยอดนิยม</h1>
            </div>
        </div>
		<form >
			<div class="form-group" >
			<table align="center">
			<tr>
			<td><label for="sel1">เลือกหมวดหมู่ : </label> </td>
			<td><select 
					class="form-control" onChange="window.location.href=this.value">
					<option value="ListPRBusinessandTravelServlet?type=1" <%if (vCategoryAll.getCategoryID().equals("1")){ %>selected="selected"<%}%>>ที่เที่ยว</option>
					<option value="ListPRBusinessandTravelServlet?type=2" <%if (vCategoryAll.getCategoryID().equals("2")){ %>selected="selected"<%}%>>ที่พัก</option>
					<option value="ListPRBusinessandTravelServlet?type=3" <%if (vCategoryAll.getCategoryID().equals("3")){ %>selected="selected"<%}%>>ร้านอาหาร</option>
				</select></td>
			</tr>
			</table>
			</div >
		</form>
		<!-- /.row -->
<%if(vCategoryAll.getCategoryID().equals("1")){ %>
	<%try{ %>
       <%for (SubCategoryTravel su : vCategoryAll.getVectorsubcategorytravel()) {%>
		<%for(TravelDetail tv: su.getVectortraveldetail()){ %>		
		 <div class="row">
             <div class="col-md-5">
                    <img class="img-responsive" src="Tools/images/pr/<%=tv.getAddress().getVectorimages().get(0).getImageName()%>" alt="image2" style="width: 500px; height: 300px;">
            </div>
            <div class="col-md-6">
                <h3><%=tv.getTraveldetailName() %><%if(tv.getAddress().getStatusapproved().equals("yes")) {%><span class="glyphicon glyphicon-ok" style="color:green ;"></span><%}else if(tv.getAddress().getStatusapproved().equals("no")){ %><span class="glyphicon glyphicon-remove" style="color:red ;"></span><%} %></h3>
                <h4>จำนวนคนเข้าชม : <%=tv.getStatisticsvisit() %></h4>
                <p><%=tv.getTraveldetailTitel() %></p>
               <a class="btn btn-primary" href="ViewPRBusinessandTravelServlet?ownerID=<%=tv.getOwnerID().getOwnerID()%>">อ่านต่อ  <span class="glyphicon glyphicon-chevron-right"></span></a>
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
												href="ListPRBusinessandTravelServlet?type=1&&page=<%=currentPage - 1%>"
												aria-label="Previous"><span aria-hidden="true">«</span></a></li>
											<%for( int s = 0 ; s < noOfPages ; s++){ %>
											<li><a href="ListPRBusinessandTravelServlet?type=1&&page=<%=s+1%>"><span
													aria-hidden="true"><%=s+1%></span></a></li>
											<%} %>
											<%}else{ %>
											<li><a
												href="ListPRBusinessandTravelServlet?type=1&&page=<%=currentPage - 1%>"
												aria-label="Previous"><span aria-hidden="true">«</span></a></li>
											<%for( int s = 0 ; s < noOfPages ; s++){ %>
											<li><a href="ListPRBusinessandTravelServlet?type=1&&page=<%=s+1%>"><span
													aria-hidden="true"><%=s+1%></span></a></li>
											<%} %>
											<li><a
												href="ListPRBusinessandTravelServlet?type=1&&page=<%=currentPage + 1%>"
												aria-label="Next"><span aria-hidden="true">»</span></a></li>

											<%} %>
											<%	}%>
											<%if (currentPage != noOfPages ) {%>
											<%if(currentPage == 1){ %>
											<%for( int s = 0 ; s < noOfPages ; s++){ %>
											<li><a href="ListPRBusinessandTravelServlet?type=1&&page=<%=s+1%>"><span
													aria-hidden="true"><%=s+1%></span></a></li>
											<%} %>
											<li><a
												href="ListPRBusinessandTravelServlet?type=1&&page=<%=currentPage + 1%>"
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
                    <img class="img-responsive" src="Tools/images/pr/<%=hd.getAddress().getVectorimages().get(0).getImageName()%>" alt="image2"  style="width: 500px; height: 300px;">
                </a>
            </div>
            <div class="col-md-6">
                <h3><%=hd.getHoteldetailName() %><%if(hd.getAddress().getStatusapproved().equals("yes")) {%><span class="glyphicon glyphicon-ok" style="color:green ;"></span><%}else if(hd.getAddress().getStatusapproved().equals("no")){ %><span class="glyphicon glyphicon-remove" style="color:red ;"></span><%} %></h3>
                <h4>จำนวนคนเข้าชม : <%=hd.getStatisticsvisit() %></h4>
                <p><%=hd.getHoteldetailTitel() %></p>
                <a class="btn btn-primary" href="ViewPRBusinessandTravelServlet?ownerID=<%=hd.getOwnerID().getOwnerID()%>">อ่านต่อ  <span class="glyphicon glyphicon-chevron-right"></span></a>
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
												href="ListPRBusinessandTravelServlet?type=2&&page=<%=currentPage - 1%>"
												aria-label="Previous"><span aria-hidden="true">«</span></a></li>
											<%for( int s = 0 ; s < noOfPages ; s++){ %>
											<li><a href="ListPRBusinessandTravelServlet?type=2&&page=<%=s+1%>"><span
													aria-hidden="true"><%=s+1%></span></a></li>
											<%} %>
											<%}else{ %>
											<li><a
												href="ListPRBusinessandTravelServlet?type=2&&page=<%=currentPage - 1%>"
												aria-label="Previous"><span aria-hidden="true">«</span></a></li>
											<%for( int s = 0 ; s < noOfPages ; s++){ %>
											<li><a href="ListPRBusinessandTravelServlet?type=2&&page=<%=s+1%>"><span
													aria-hidden="true"><%=s+1%></span></a></li>
											<%} %>
											<li><a
												href="ListPRBusinessandTravelServlet?type=2&&page=<%=currentPage + 1%>"
												aria-label="Next"><span aria-hidden="true">»</span></a></li>

											<%} %>
											<%	}%>
											<%if (currentPage != noOfPages ) {%>
											<%if(currentPage == 1){ %>
											<%for( int s = 0 ; s < noOfPages ; s++){ %>
											<li><a href="ListPRBusinessandTravelServlet?type=2&&page=<%=s+1%>"><span
													aria-hidden="true"><%=s+1%></span></a></li>
											<%} %>
											<li><a
												href="ListPRBusinessandTravelServlet?type=2&&page=<%=currentPage + 1%>"
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
                    <img class="img-responsive" src="Tools/images/pr/<%=rd.getAddress().getVectorimages().get(0).getImageName()%>" alt="image2"  style="width: 500px; height: 300px;">
                </a>
            </div>
            <div class="col-md-6">
                <h3><%=rd.getRestaurantsdetailName()%><%if(rd.getAddress().getStatusapproved().equals("yes")) {%><span class="glyphicon glyphicon-ok" style="color:green ;"></span><%}else if(rd.getAddress().getStatusapproved().equals("no")){ %><span class="glyphicon glyphicon-remove" style="color:red ;"></span><%} %></h3>
                <h4>จำนวนคนเข้าชม : <%=rd.getStatisticsvisit() %></h4>
                <p><%=rd.getRestaurantsdetailTitel() %></p>
                <a class="btn btn-primary" href="ViewPRBusinessandTravelServlet?ownerID=<%=rd.getOwnerID().getOwnerID()%>">อ่านต่อ  <span class="glyphicon glyphicon-chevron-right"></span></a>
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
												href="ListPRBusinessandTravelServlet?type=3&&page=<%=currentPage - 1%>"
												aria-label="Previous"><span aria-hidden="true">«</span></a></li>
											<%for( int s = 0 ; s < noOfPages ; s++){ %>
											<li><a href="ListPRBusinessandTravelServlet?type=3&&page=<%=s+1%>"><span
													aria-hidden="true"><%=s+1%></span></a></li>
											<%} %>
											<%}else{ %>
											<li><a
												href="ListPRBusinessandTravelServlet?type=3&&page=<%=currentPage - 1%>"
												aria-label="Previous"><span aria-hidden="true">«</span></a></li>
											<%for( int s = 0 ; s < noOfPages ; s++){ %>
											<li><a href="ListPRBusinessandTravelServlet?type=3&&page=<%=s+1%>"><span
													aria-hidden="true"><%=s+1%></span></a></li>
											<%} %>
											<li><a
												href="ListPRBusinessandTravelServlet?type=3&&page=<%=currentPage + 1%>"
												aria-label="Next"><span aria-hidden="true">»</span></a></li>

											<%} %>
											<%	}%>
											<%if (currentPage != noOfPages ) {%>
											<%if(currentPage == 1){ %>
											<%for( int s = 0 ; s < noOfPages ; s++){ %>
											<li><a href="ListPRBusinessandTravelServlet?type=3&&page=<%=s+1%>"><span
													aria-hidden="true"><%=s+1%></span></a></li>
											<%} %>
											<li><a
												href="ListPRBusinessandTravelServlet?type=3&&page=<%=currentPage + 1%>"
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
	<!-- === END CONTENT === -->
	
	<!-- Begin Footer -->
	<%@include file="pages/footer-menu.jsp"%>
	<!-- End Footer -->
</body>
</html>
<!-- === END FOOTER === -->