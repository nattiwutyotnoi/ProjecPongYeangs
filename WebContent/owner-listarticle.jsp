<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import=" com.pongyeang.bean.*"%>
<%
	Owner owner = (Owner) session.getAttribute("owner");
	int noOfPages = (int) request.getAttribute("noOfPages");
	int currentPage = (int) request.getAttribute("currentPage");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Article</title>
</head>
<body>
	<!-- Begin HEADER -->
	<%@include file="pages/header-menu.jsp"%>
	<!-- End HEADER -->
	<%
		if (session.getAttribute("owner") != null) {
	%>
	<!-- === Start CONTENT === -->
	<!-- Page Content -->
	<div class="container">
		<!-- Page Heading -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">แสดงบทความทั้งหมด</h1>
			</div>
		</div>
		<!-- /.row -->	
		<%if (owner.getTravledetail().getTraveldetailID() != 0) {%>
			<%try{ %>		
				<%for (Article article : owner.getTravledetail().getVecotrarticle()) {%>
					<!-- Project One -->
					<div class="row">
						<div class="col-md-5">
							<a href="#"> <img class="img-responsive img-rounded"
								src="Tools/images/article/<%=article.getVectorimages().get(0).getImageName()%>"
								alt="<%=article.getVectorimages().get(0).getImageName()%>"  style="width: 500px; height: 300px;">
							</a>
						</div>
						<div class="col-md-6">
							<h3><%=article.getArticleName()%></h3>
							<p>
								จำนวนผู้เข้าชม :<%=article.getStatisticsvisit()%></p>
							<h4><%=article.getArticleTitel()%></h4>
							<a class="btn btn-primary"
								href="OwnerViewArticleServlet?articleID=<%=article.getArticleID()%>">อ่านเพิ่มเติม<span
								class="glyphicon glyphicon-chevron-right"></span></a>
						</div>
					</div>
					<!-- /.row -->
				<hr>
				<%}%>	
				 <%}catch (Exception e){ %>
					<div class="row">
						<div class="col-lg-12">
								<h2 class="page-header">ยังไม่มีข้อมูล</h2>
						</div>
					</div>
				<%} %>
		<!-- Start Panel-->
		<div class="panel-footer">
			<div class="row">
				<div class="col col-xs-offset-3 col-xs-6">
					<nav aria-label="Page navigation" class="text-center">
					<ul class="pagination">
						<%
							if (currentPage >= 2) {
						%>
						<%
							if (currentPage == noOfPages) {
						%>
						<li><a
							href="OwnerListArticleServlet?page=<%=currentPage - 1%>"
							aria-label="Previous"><span aria-hidden="true">«</span></a></li>
						<%
							for (int s = 0; s < noOfPages; s++) {
						%>
						<li><a href="OwnerListArticleServlet?page=<%=s + 1%>"><span
								aria-hidden="true"><%=s + 1%></span></a></li>
						<%
							}
						%>
						<%
							} else {
						%>
						<li><a
							href="OwnerListArticleServlet?page=<%=currentPage - 1%>"
							aria-label="Previous"><span aria-hidden="true">«</span></a></li>
						<%
							for (int s = 0; s < noOfPages; s++) {
						%>
						<li><a href="OwnerListArticleServlet?page=<%=s + 1%>"><span
								aria-hidden="true"><%=s + 1%></span></a></li>
						<%
							}
						%>
						<li><a
							href="OwnerListArticleServlet?page=<%=currentPage + 1%>"
							aria-label="Next"><span aria-hidden="true">»</span></a></li>

						<%
							}
						%>
						<%
							}
						%>
						<%
							if (currentPage != noOfPages) {
						%>
						<%
							if (currentPage == 1) {
						%>
						<%
							for (int s = 0; s < noOfPages; s++) {
						%>
						<li><a href="OwnerListArticleServlet?page=<%=s + 1%>"><span
								aria-hidden="true"><%=s + 1%></span></a></li>
						<%
							}
						%>
						<li><a
							href="OwnerListArticleServlet?page=<%=currentPage + 1%>"
							aria-label="Next"><span aria-hidden="true">»</span></a></li>
						<%
							}
						%>
						<%
							}
						%>
					</ul>
					</nav>
				</div>
			</div>
		</div>
		<!-- End Panel-->
		<hr>
		<!-- /.row -->
		<%} else if (owner.getHoteldetail().getHoteldetailID() != 0) {%>
		<%try{ %>		
			<%for (Article article : owner.getHoteldetail().getVecotrarticle()) {%>
			<!-- Project One -->
			<div class="row">
				<div class="col-md-5">
					<a href="#"> <img class="img-responsive img-rounded"
						src="Tools/images/article/<%=article.getVectorimages().get(0).getImageName()%>"
						alt="<%=article.getVectorimages().get(0).getImageName()%>"  style="width: 500px; height: 300px;">
					</a>
				</div>
				<div class="col-md-6">
					<h3><%=article.getArticleName()%></h3>
					<p>
						จำนวนผู้เข้าชม :<%=article.getStatisticsvisit()%></p>
					<h4><%=article.getArticleTitel()%></h4>
					<a class="btn btn-primary"
						href="OwnerViewArticleServlet?articleID=<%=article.getArticleID()%>">อ่านเพิ่มเติม<span
						class="glyphicon glyphicon-chevron-right"></span></a>
				</div>
			</div>
		<!-- /.row -->
		<hr>
		<%}%>
			<%}catch (Exception e){ %>
					<div class="row">
						<div class="col-lg-12">
								<h2 class="page-header">ยังไม่มีข้อมูล</h2>
						</div>
					</div>
			<%} %>
		<hr>
		<!-- Start Panel-->
		<div class="panel-footer">
			<div class="row">
				<div class="col col-xs-offset-3 col-xs-6">
					<nav aria-label="Page navigation" class="text-center">
					<ul class="pagination">
						<%
							if (currentPage >= 2) {
						%>
						<%
							if (currentPage == noOfPages) {
						%>
						<li><a
							href="OwnerListArticleServlet?page=<%=currentPage - 1%>"
							aria-label="Previous"><span aria-hidden="true">«</span></a></li>
						<%
							for (int s = 0; s < noOfPages; s++) {
						%>
						<li><a href="OwnerListArticleServlet?page=<%=s + 1%>"><span
								aria-hidden="true"><%=s + 1%></span></a></li>
						<%
							}
						%>
						<%
							} else {
						%>
						<li><a
							href="OwnerListArticleServlet?page=<%=currentPage - 1%>"
							aria-label="Previous"><span aria-hidden="true">«</span></a></li>
						<%
							for (int s = 0; s < noOfPages; s++) {
						%>
						<li><a href="OwnerListArticleServlet?page=<%=s + 1%>"><span
								aria-hidden="true"><%=s + 1%></span></a></li>
						<%
							}
						%>
						<li><a
							href="OwnerListArticleServlet?page=<%=currentPage + 1%>"
							aria-label="Next"><span aria-hidden="true">»</span></a></li>

						<%
							}
						%>
						<%
							}
						%>
						<%
							if (currentPage != noOfPages) {
						%>
						<%
							if (currentPage == 1) {
						%>
						<%
							for (int s = 0; s < noOfPages; s++) {
						%>
						<li><a href="OwnerListArticleServlet?page=<%=s + 1%>"><span
								aria-hidden="true"><%=s + 1%></span></a></li>
						<%
							}
						%>
						<li><a
							href="OwnerListArticleServlet?page=<%=currentPage + 1%>"
							aria-label="Next"><span aria-hidden="true">»</span></a></li>
						<%
							}
						%>
						<%
							}
						%>
					</ul>
					</nav>
				</div>
			</div>
		</div>
		<!-- End Panel-->
		<!-- /.row -->
		<%} else if (owner.getRestaurantsdetail().getRestaurantsdetailID() != 0) {%>
		<%try{ %>
			<%for (Article article : owner.getRestaurantsdetail().getVecotrarticle()) {	%>
			<!-- Project One -->
			<div class="row">
				<div class="col-md-5">
					<a href="#"> <img class="img-responsive img-rounded"
						src="Tools/images/article/<%=article.getVectorimages().get(0).getImageName()%>"
						alt="<%=article.getVectorimages().get(0).getImageName()%>" style="width: 500px; height: 300px;">
					</a>
				</div>
				<div class="col-md-6">
					<h4><%=article.getArticleName()%></h4>
					<p>
						จำนวนผู้เข้าชม :<%=article.getStatisticsvisit()%></p>
					<h3><%=article.getArticleTitel()%></h3>
					<a class="btn btn-primary"
						href="OwnerViewArticleServlet?articleID=<%=article.getArticleID()%>">อ่านเพิ่มเติม<span
						class="glyphicon glyphicon-chevron-right"></span></a>
				</div>
			</div>
			<!-- /.row -->
			<hr>
			<%}%>
		<%}catch (Exception e){ %>
					<div class="row">
						<div class="col-lg-12">
								<h2 class="page-header">ยังไม่มีข้อมูล</h2>
						</div>
					</div>
			<%} %>
		<!-- Start Panel-->
		<div class="panel-footer">
			<div class="row">
				<div class="col col-xs-offset-3 col-xs-6">
					<nav aria-label="Page navigation" class="text-center">
					<ul class="pagination">
						<%
							if (currentPage >= 2) {
						%>
						<%
							if (currentPage == noOfPages) {
						%>
						<li><a
							href="OwnerListArticleServlet?page=<%=currentPage - 1%>"
							aria-label="Previous"><span aria-hidden="true">«</span></a></li>
						<%
							for (int s = 0; s < noOfPages; s++) {
						%>
						<li><a href="OwnerListArticleServlet?page=<%=s + 1%>"><span
								aria-hidden="true"><%=s + 1%></span></a></li>
						<%
							}
						%>
						<%
							} else {
						%>
						<li><a
							href="OwnerListArticleServlet?page=<%=currentPage - 1%>"
							aria-label="Previous"><span aria-hidden="true">«</span></a></li>
						<%
							for (int s = 0; s < noOfPages; s++) {
						%>
						<li><a href="OwnerListArticleServlet?page=<%=s + 1%>"><span
								aria-hidden="true"><%=s + 1%></span></a></li>
						<%
							}
						%>
						<li><a
							href="OwnerListArticleServlet?page=<%=currentPage + 1%>"
							aria-label="Next"><span aria-hidden="true">»</span></a></li>

						<%
							}
						%>
						<%
							}
						%>
						<%
							if (currentPage != noOfPages) {
						%>
						<%
							if (currentPage == 1) {
						%>
						<%
							for (int s = 0; s < noOfPages; s++) {
						%>
						<li><a href="OwnerListArticleServlet?page=<%=s + 1%>"><span
								aria-hidden="true"><%=s + 1%></span></a></li>
						<%
							}
						%>
						<li><a
							href="OwnerListArticleServlet?page=<%=currentPage + 1%>"
							aria-label="Next"><span aria-hidden="true">»</span></a></li>
						<%
							}
						%>
						<%
							}
						%>
					</ul>
					</nav>
				</div>
			</div>
		</div>
		<!-- End Panel-->
		<hr>
		<%
			}
		%>
	</div>
	<!-- /.container -->
	<!-- === END CONTENT === -->
	<%
		} else {
	%>
	ไม่มีบทความที่ต้องการแสดง
	<%
		}
	%>

	<!-- Begin Footer -->
	<%@include file="pages/footer-menu.jsp"%>
	<!-- End Footer -->
</body>

</html>