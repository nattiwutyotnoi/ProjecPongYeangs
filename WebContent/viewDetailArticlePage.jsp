<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pongyeang.bean.*"%>
<%
	Article ArticleOne = (Article) session.getAttribute("ArticleOne");
%>
<%
	String url = "http://06ab758d.ngrok.io";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<style>
#map {
	height: 400px;
	width: 100%;
}
</style>
<!-- Title -->
<title><%=ArticleOne.getArticleName()%></title>
<!-- Meta -->
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<!-- Google Fonts-->
<link href="http://fonts.googleapis.com/css?family=Lato:400,300"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"
	rel="stylesheet" type="text/css">
</head>
<body>
	<!-- Begin HEADER -->
	<%@include file="pages/header-menu.jsp"%>
	<!-- End HEADER -->
	<!-- ******************************************************************************************************************** -->
	<div class="container">
		<!-- Page Heading/Breadcrumbs -->
		<div class="list-group-item" style="background-color: #78bd8e">
			<div class="row header1">
				<div class="col-xs-12">
					<div class="col-xs-8">
						<h2 class="font-size-20 bold">
							<font color="#FFFFFF"><%=ArticleOne.getArticleName()%> </font>
						</h2>
					</div>
				</div>
			</div>
		</div>
		<!-- /.row -->
		<!-- Content Row -->
		<div class="row">
			<!-- Blog Post Content Column -->
			<div class="col-lg-12">
				<!-- Date/Time -->
				<br> <i class="fa fa-clock-o"></i>
				<%=ArticleOne.getDatecreate()%>(จำนวนผู้เข้าชม : <%=ArticleOne.getStatisticsvisit()%></p>
				<!-- Page Heading/Breadcrumbs -->
				<div class="col-md-12">
					<h2 align="center"><%=ArticleOne.getArticleName()%></h2>
					<p class="lead"><%=ArticleOne.getArticleTitel()%></p>
				</div>
				<!-- /.row -->
				<!-- Preview Image -->
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<img class="img-responsive"
							src="Tools/images/article/<%=ArticleOne.getVectorimages().get(0).getImageName()%>"
							align="center">
						<hr>
					</div>
				</div>
				<!-- Post Content -->
				<div class="row">
					<div class="col-md-12">
								<p>
								<%=ArticleOne.getArticleDetail()%>
								</p>
					</div>
				</div>
				<TABLE class="table">
					<TR>
						<TH>สิ่งอำนวยความสะดวก</TH>
						<TD><%=ArticleOne.getAmenities()%></TD>
					</TR>
					<TR>
						<TH>ติดต่อสอบถาม</TH>
						<TD><%=ArticleOne.getCountactus()%></TD>
					</TR>
				</TABLE>
				<!-- Start Gallery ***************************************************************************************-->
				<div class="row">
					<div class="col-lg-12">
						<%
							for (int i = 0; i < ArticleOne.getVectorimages().size(); i++) {
						%>
						<div class="col-lg-3 col-md-4 col-xs-6 thumb">
							<a class="thumbnail" href="#" data-image-id=""
								data-toggle="modal"
								<%if (ArticleOne.getVectorimages().get(i).getImageDetail() != null) {%>
								data-title="<%=ArticleOne.getVectorimages().get(i).getImageDetail()%>"
								<%} else {%> data-title="<%=ArticleOne.getArticleName()%>" <%}%>
								data-caption="Some lovely red flowers"
								data-image="Tools/images/article/<%=ArticleOne.getVectorimages().get(i).getImageName()%>"
								data-target="#image-gallery"> <img
								src="Tools/images/article/<%=ArticleOne.getVectorimages().get(i).getImageName()%>"
								align="center" style="width: 215px; height: 143px;">
								<div class="caption"></div>
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
			<div class="col-md-12">
				<div class="fb-like"
					data-href="<%=url%>pongyeang/ViewPRTravelDetailServlet?travelID=<%=ArticleOne.getArticleID()%>"
					data-width="500" data-layout="button" data-action="like"
					data-size="large" data-show-faces="true" data-share="true"></div>
				<div id="fb-root"></div>
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
				<div class="fb-comments"
					data-href="<%=url%>pongyeang/ViewHotelsandLodgingDetailServlet?hoteldetailID=<%=ArticleOne.getArticleID()%>"
					data-width="100%" data-numposts="5"></div>
			</div>
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
<!-- === END FOOTER === -->