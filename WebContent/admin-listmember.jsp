<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import="com.pongyeang.bean.*"%>
<%@page import="com.pongyeang.admin_listmember.*"%>
<%
	Vector<Login> listmember = (Vector<Login>) request.getAttribute("listmember");
	int statusapproves = (int) session.getAttribute("statusapproves");
	int noOfPages = (int) request.getAttribute("noOfPages");
	int currentPage = (int) request.getAttribute("currentPage");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="Tools/js/jquery.dataTables.min.js" type="text/javascript"></script>
<title>List Member</title>
</head>
<body>
	<!-- Begin HEADER -->
	<%@include file="pages/header-menu.jsp"%>
	<!-- End HEADER -->
	<!-- === BEGIN CONTENT === -->
	<%
		if (request.getAttribute("listmember") != null || request.getAttribute("noOfPages") != null
				|| request.getAttribute("currentPage") != null || session.getAttribute("statusapproves") != null) {
	%>
	<form action="ListMemberServlet" method="post" name="adminlistmember"
		id="adminlistmember">
		<div class="container">
			<div class="row">
				<div class="col-md-12 margin-top-30">
					<div class="panel panel-green panel-table">
						<div class="panel-heading">
							<div class="row">
								<div class="col col-xs-6">
									<h3 class="panel-title">แสดงสมาชิกทั้งหมด</h3>
								</div>
								<div class="col col-xs-6 text-right">
									<div class="pull-right">
										<div class="btn-group" data-toggle="buttons">
											<input type="text" id="myInput" onkeyup="myFunction()"
												placeholder="Search for names.." class="form-control">
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="signup-page">
							<div class="panel-body">
								<form class="form-horizontal">
									<div class="form-group">
										<label class="col-sm-4 control-label text-right">สถานะของสมาชิก
											:</label>
										<div class="col-sm-6">
											<p class="form-control-static">
												<select class="form-control"
													onChange="window.location.href=this.value">
													<option value="ListMemberServlet"
														<%if (statusapproves == 3) {%> selected="selected" <%}%>>
														สมาชิกทั้งหมด</option>
													<option value="ListMemberServlet?statusapprove=0"
														<%if (statusapproves == 0) {%> selected="selected" <%}%>>สมาชิกใหม่</option>
													<option value="ListMemberServlet?statusapprove=1"
														<%if (statusapproves == 1) {%> selected="selected" <%}%>>สมาชิกไม่ได้ออนไลน์</option>
													<option value="ListMemberServlet?statusapprove=2"
														<%if (statusapproves == 2) {%> selected="selected" <%}%>>สมาชิกที่ออนไลน์</option>
												</select> <br>
											</p>
										</div>
									</div>
								</form>
								<div class="row">
									<div class="col-md-12">
										<div class="table-responsive">
											<table class="table table-bordered table-hover"
												id="tableContainer">
												<thead>
													<tr class="header">
														<th class="hidden-xs">ลำดับที่</th>
														<th class="col-text">ชื่อ-นามสกุล</th>
														<th class="col-text">ชื่อผู้ใช้งาน</th>
														<th class="col-text">เบอร์โทรศัพท์</th>
														<th class="col-text">อีเมล์</th>
														<th class="col-text">สถานะ</th>
														<th class="col-text">ดูข้อมูลสมาชิก</th>
														<th class="col-text">ลบสมาชิก</th>
													</tr>
												</thead>
												<tbody id="listmember">
													<%
														int i = 0;
															for (Login listowner : listmember) {
													%>
													<%
														if (listowner.getOwner().getStatusapprove() == 0) {
													%>
													<tr data-status="pending">
														<td class="hidden-xs"><%=i + 1%></td>
														<td><%=listowner.getOwner().getOwnerFirstname()%></td>
														<td><%=listowner.getUsername()%></td>
														<td><%=listowner.getOwner().getPhone()%></td>
														<td><%=listowner.getOwner().getEmail()%></td>
														<td>
															<%
																if (listowner.getOwner().getStatusapprove() == 0) {
															%><font color=#ff9900> สมาชิกใหม่ </font> <%
 	} else if (listowner.getOwner().getStatusapprove() == 1) {
 %><font color="#ff3300"> สมาชิกไม่ได้ออนไลน์</font> <%
 	} else if (listowner.getOwner().getStatusapprove() == 2) {
 %><font color="#009900"> สมาชิกออนไลน์ </font> <%
 	}
 %>
														</td>
														<td align="center"><a
															href="VIewMemberDetailServlet?OwnerID=<%=listowner.getOwner().getOwnerID()%>"
															class="btn btn-success"> <span
																class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
														</a></td>
														<td align="center"><a
															href="DeleteMemberSerlvet?Username=<%=listowner.getUsername()%>"
															class="btn btn-danger"
															onclick="return confirm('คุณแน่ใจหรือไม่ที่ต้องการลบสมาชิกนี้')">
																<span class="glyphicon glyphicon-trash"
																aria-hidden="true"></span>
														</a></td>
													</tr>
													<%
														} else if (listowner.getOwner().getStatusapprove() == 1) {
													%>
													<tr data-status="pending">
														<td class="hidden-xs"><%=i + 1%></td>
														<td><%=listowner.getOwner().getOwnerFirstname()%></td>
														<td><%=listowner.getUsername()%></td>
														<td><%=listowner.getOwner().getPhone()%></td>
														<td><%=listowner.getOwner().getEmail()%></td>
														<td>
															<%
																if (listowner.getOwner().getStatusapprove() == 0) {
															%><font color=#ff9900> สมาชิกใหม่ </font> <%
 	} else if (listowner.getOwner().getStatusapprove() == 1) {
 %><font color="#ff3300"> สมาชิกไม่ได้ออนไลน์</font> <%
 	} else if (listowner.getOwner().getStatusapprove() == 2) {
 %><font color="#009900"> สมาชิกออนไลน์ </font> <%
 	}
 %>
														</td>
														<td align="center"><a
															href="VIewMemberDetailServlet?OwnerID=<%=listowner.getOwner().getOwnerID()%>"
															class="btn btn-success"> <span
																class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
														</a></td>
														<td align="center"><a
															href="DeleteMemberSerlvet?Username=<%=listowner.getUsername()%>"
															class="btn btn-danger"
															onclick="return confirm('คุณแน่ใจหรือไม่ที่ต้องการลบสมาชิกนี้')">
																<span class="glyphicon glyphicon-trash"
																aria-hidden="true"></span>
														</a></td>
													</tr>
													<%
														} else if (listowner.getOwner().getStatusapprove() == 2) {
													%>
													<tr data-status="pending">
														<td class="hidden-xs"><%=i + 1%></td>
														<td><%=listowner.getOwner().getOwnerFirstname()%></td>
														<td><%=listowner.getUsername()%></td>
														<td><%=listowner.getOwner().getPhone()%></td>
														<td><%=listowner.getOwner().getEmail()%></td>
														<td>
															<%
																if (listowner.getOwner().getStatusapprove() == 0) {
															%><font color=#ff9900> สมาชิกใหม่ </font> <%
 	} else if (listowner.getOwner().getStatusapprove() == 1) {
 %><font color="#ff3300"> สมาชิกไม่ได้ออนไลน์</font> <%
 	} else if (listowner.getOwner().getStatusapprove() == 2) {
 %><font color="#009900"> สมาชิกออนไลน์ </font> <%
 	}
 %>
														</td>
														<td align="center"><a
															href="VIewMemberDetailServlet?OwnerID=<%=listowner.getOwner().getOwnerID()%>"
															class="btn btn-success"> <span
																class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
														</a></td>
														<td align="center"><a
															href="DeleteMemberSerlvet?Username=<%=listowner.getUsername()%>"
															class="btn btn-danger"
															onclick="return confirm('คุณแน่ใจหรือไม่ที่ต้องการลบสมาชิกนี้')">
																<span class="glyphicon glyphicon-trash"
																aria-hidden="true"></span>
														</a></td>
													</tr>
													<%
														} else {
													%>
													<tr data-status="pending">
														<td class="hidden-xs"><%=i + 1%></td>
														<td><%=listowner.getOwner().getOwnerFirstname()%></td>
														<td><%=listowner.getUsername()%></td>
														<td><%=listowner.getOwner().getPhone()%></td>
														<td><%=listowner.getOwner().getEmail()%></td>
														<td>
															<%
																if (listowner.getOwner().getStatusapprove() == 0) {
															%><font color=#ff9900> สมาชิกใหม่ </font> <%
 	} else if (listowner.getOwner().getStatusapprove() == 1) {
 %><font color="#ff3300"> สมาชิกไม่ได้ออนไลน์</font> <%
 	} else if (listowner.getOwner().getStatusapprove() == 2) {
 %><font color="#009900"> สมาชิกออนไลน์ </font> <%
 	}
 %>
														</td>
														<td align="center"><a
															href="VIewMemberDetailServlet?OwnerID=<%=listowner.getOwner().getOwnerID()%>"
															class="btn btn-success"> <span
																class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
														</a></td>
														<td align="center"><a
															href="DeleteMemberSerlvet?Username=<%=listowner.getUsername()%>"
															class="btn btn-danger"
															onclick="return confirm('คุณแน่ใจหรือไม่ที่ต้องการลบสมาชิกนี้')">
																<span class="glyphicon glyphicon-trash"
																aria-hidden="true"></span>
														</a></td>
													</tr>
													<%
														}
													%>
													<%
														i++;
															}
													%>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
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
												href="ListMemberServlet?page=<%=currentPage - 1%>"
												aria-label="Previous"><span aria-hidden="true">«</span></a></li>
											<%
												for (int s = 0; s < noOfPages; s++) {
											%>
											<li><a href="ListMemberServlet?page=<%=s + 1%>"><span
													aria-hidden="true"><%=s + 1%></span></a></li>
											<%
												}
											%>
											<%
												} else {
											%>
											<li><a
												href="ListMemberServlet?page=<%=currentPage - 1%>"
												aria-label="Previous"><span aria-hidden="true">«</span></a></li>
											<%
												for (int s = 0; s < noOfPages; s++) {
											%>
											<li><a href="ListMemberServlet?page=<%=s + 1%>"><span
													aria-hidden="true"><%=s + 1%></span></a></li>
											<%
												}
											%>
											<li><a
												href="ListMemberServlet?page=<%=currentPage + 1%>"
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
											<li><a href="ListMemberServlet?page=<%=s + 1%>"><span
													aria-hidden="true"><%=s + 1%></span></a></li>
											<%
												}
											%>
											<li><a
												href="ListMemberServlet?page=<%=currentPage + 1%>"
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
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- === END CONTENT === -->
	<%
		} else {
	%>
	ไม่พบข้อมูลของสมาชิก
	<%
		}
	%>
	<!-- Begin Footer -->
	<%@include file="pages/footer-menu.jsp"%>
	<!-- End Footer -->
</body>
<!--Start Select  SubCategory -->
<!--Start Select  SubCategory -->
<script type='text/javascript'>
	function myFunction() {
		// Declare variables
		var input, filter, table, tr, td, i;
		input = document.getElementById("myInput");
		filter = input.value.toUpperCase();
		table = document.getElementById("tableContainer");
		tr = table.getElementsByTagName("tr");

		// Loop through all table rows, and hide those who don't match the search query
		for (i = 0; i < tr.length; i++) {
			if (!tr[i].classList.contains('header')) {
				td = tr[i].getElementsByTagName("td"), match = false;
				for (j = 0; j < td.length; j++) {
					if (td[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
						match = true;
						break;
					}
				}
				if (!match) {
					tr[i].style.display = "none";
				} else {
					tr[i].style.display = "";
				}
			}
		}
	}
</script>
<!--End Select  SubCategory -->
</html>