<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import=" com.pongyeang.bean.*"%>
<%
	Article article = (Article) session.getAttribute("article");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Article</title>
</head>
<body>
	<!-- Begin HEADER -->
	<%@include file="pages/header-menu.jsp"%>
	<!-- End HEADER -->
	<!-- ******************************************************************************************************************** -->
	<div class="container">
		<div class="row margin-vert-30">
			<%
				if (session.getAttribute("article") != null) {
			%>
				<!-- Page Heading/Breadcrumbs -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header"><%=article.getArticleName()%>
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
							<%=article.getDatecreate()%></p>
						<!-- Page Heading/Breadcrumbs -->
						<div class="col-md-12">
							<h2 align="center"><%=article.getArticleName()%></h2>
							<p class="lead"><%=article.getArticleTitel()%></p>
						</div>
						<!-- /.row -->
						<!-- Preview Image -->
						<div class="row">
							<div class="col-md-6 col-md-offset-3">
								<img class="img-responsive img-rounded"
									src="Tools/images/article/<%=article.getVectorimages().get(0).getImageName()%>"
									alt="<%=article.getVectorimages().get(0).getImageName()%>">
							</div>
						</div>
						<hr>
						<!-- Post Content -->
						<P>
						<h3><%=article.getArticleDetail()%></h3>
						</P>

						<TABLE class="table">
							<TR>
								<TH>สิ่งอำนวยความสะดวก</TH>
								<TD><%=article.getAmenities()%></TD>
							</TR>

							<TR>
								<TH>ติดต่อสอบถาม</TH>
								<TD><%=article.getCountactus()%></TD>
							</TR>
						</TABLE>
					</div>
					<hr>
					<!-- Start Gallery ***************************************************************************************-->
					<div class="row">
						<div class="col-lg-12">
							<%
								for (int i = 0; i < article.getVectorimages().size(); i++) {
							%>
							<div class="col-lg-3 col-md-4 col-xs-6 thumb">
								<a class="thumbnail" href="#" data-image-id=""
									data-toggle="modal"
									<%if (article.getVectorimages().get(i).getImageDetail() != null
							&& !article.getVectorimages().get(i).getImageDetail().equalsIgnoreCase("-")) {%>
									data-title="<%=article.getVectorimages().get(i).getImageDetail()%>"
									<%} else {%> data-title="<%=article.getArticleName()%>" <%}%>
									data-caption="Some lovely red flowers"
									data-image="Tools/images/article/<%=article.getVectorimages().get(i).getImageName()%>"
									data-target="#image-gallery"> <img
									src="Tools/images/article/<%=article.getVectorimages().get(i).getImageName()%>"
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
				</div>
				<!-- /.row -->
				<hr>
				<div class="row">
					<center>
						<%
							if (!status.equalsIgnoreCase("2")) {
						%>
						<a href="index.jsp" class="btn btn-info">ย้อนกลับ</a>
						<%
							} else {
						%>
						<a href="OwnerListArticleServlet" class="btn btn-info">ย้อนกลับ</a> <a
							href="EditArticleServlet?articleID=<%=article.getArticleID()%>"
							class="btn btn-success">แก้ไขข้อมูล</a> <a
							href="OwnerDeleteArticleServlet?articleID=<%=article.getArticleID()%>"
							class="btn btn-danger"
							onclick="return confirm('คุณแน่ใจหรือไม่ที่ต้องการลบบทความนี้')">ลบบทความ</a>
						<%}%>
					</center>
				</div>
			<%
				} else {
			%>
			ไม่พบข้อมูลในหน้านี้
			<%
				}
			%>
		</div>
	</div>
	<!-- ********************************************************************************************************************* -->

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