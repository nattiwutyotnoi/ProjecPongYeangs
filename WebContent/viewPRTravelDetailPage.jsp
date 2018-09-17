<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pongyeang.bean.*"%>
<%
	String url = "https://67826cc4.ngrok.io/";
%>
<%
	TravelDetail travelOne = (TravelDetail) session.getAttribute("travelOne");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<head>

<!-- Title -->
<title><%=travelOne.getTraveldetailName()%></title>
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
							<font color="#FFFFFF"><%=travelOne.getTraveldetailName()%>
							</font>
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
				<p>
				<h4>
					by
					<%=travelOne.getOwnerID().getOwnerFirstname()%>
					<%=travelOne.getOwnerID().getOwnerzLastname()%>
				</h4>
				<i class="fa fa-clock-o"></i>
				<%=travelOne.getAddress().getDatecreate()%>(จำนวนผู้เข้าชม : <%=travelOne.getStatisticsvisit()%>)</p>
				<!-- Page Heading/Breadcrumbs -->
				<div class="col-md-12">
					<h2 align="center"><%=travelOne.getTraveldetailName()%></h2>
					<p class="lead"><%=travelOne.getTraveldetailTitel()%></p>
				</div>
				<!-- /.row -->
				<!-- Preview Image -->
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<img class="img-responsive"
							src="Tools/images/pr/<%=travelOne.getAddress().getVectorimages().get(0).getImageName()%>"
							align="center">
					</div>
				</div>
				<hr>
				<!-- Post Content -->
				<div class="row">
					<div class="col-md-12">
						<P>
						<h3><%=travelOne.getTraveldetailData()%></h3>
						</P>
					</div>
				</div>
				<hr>
				<!-- Start Gallery ***************************************************************************************-->
				<div class="row">
					<div class="col-lg-12">
						<%
							for (int i = 0; i < travelOne.getAddress().getVectorimages().size(); i++) {
						%>
						<div class="col-lg-3 col-md-4 col-xs-6 thumb">
							<a class="thumbnail" href="#" data-image-id=""
								data-toggle="modal"
								<%if (travelOne.getAddress().getVectorimages().get(i).getImageDetail() != null) {%>
								data-title="<%=travelOne.getAddress().getVectorimages().get(i).getImageDetail()%>"
								<%} else {%> data-title="	<%=travelOne.getTraveldetailName()%>"
								<%}%> data-caption="Some lovely red flowers"
								data-image="Tools/images/pr/<%=travelOne.getAddress().getVectorimages().get(i).getImageName()%>"
								data-target="#image-gallery"> <img
								src="Tools/images/pr/<%=travelOne.getAddress().getVectorimages().get(i).getImageName()%>"
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
				<!-- Map+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
				<div class="list-group-item" style="background-color: #78bd8e">
					<div class="row header1">
						<div class="col-xs-12">
							<div class="col-xs-8">
								<h2 class="font-size-20 bold">
									<font color="#FFFFFF">ตำเเหน่งที่ตั้ง </font>
								</h2>
							</div>
						</div>
					</div>
				</div>
				<!-- Map Column -->
				<div class="row">
					<div class="col-md-6">
						<div id="googleMap" style="width: 100%; height: 400px;"></div>
						<script>
							function initMap() {
								var uluru = {
									lat :
						<%=travelOne.getAddress().getLatitude()%>
							,
									lng :
						<%=travelOne.getAddress().getLongtitude()%>
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
					</div>
					<!-- Start Contact Details Column -->
					<div class="col-md-6">
						<h3>สามารถติอต่อสอบถามได้ทาง</h3>
						<p>
						<div class="media-body">
							<%="บ้านเลขที่ " + travelOne.getAddress().getAddressno() + "หมู่ที่ "
					+ travelOne.getAddress().getVillageno() + " หมู่บ้าน "
					+ travelOne.getAddress().getVillageCategoryID().getVillageName() + " ซอย "
					+ travelOne.getAddress().getAlley() + " ถนน " + travelOne.getAddress().getStreet() + " ตำบล"
					+ travelOne.getAddress().getDistrict() + " จังหวัด " + travelOne.getAddress().getProvince()
					+ " รหัสไปรษณีย์ " + travelOne.getAddress().getZipcode()%><br>
						</div>
						<div class="media">
							<div class="media-body">
								<i class="fa fa-phone-square fa-2x"></i> <abbr title="Phone"></abbr>:
								<%=travelOne.getTelephone()%></p>
							</div>
							<%
								if (!travelOne.getWebsite().equalsIgnoreCase("-")
										&& !travelOne.getWebsite().equalsIgnoreCase("null")) {
							%>
							<div class="media-body">
								<i class="fa fa-envelope-square fa-2x"></i> <abbr title="web"></abbr>:
								<a href="<%=travelOne.getWebsite()%>"><%=travelOne.getWebsite()%></a>
							</div>
							<%
								} else {
								}
							%>
							<%
								if (!travelOne.getFacebook().equalsIgnoreCase("-")
										&& !travelOne.getFacebook().equalsIgnoreCase("null")) {
							%>
							<div class="media-body">
								<i class="fa fa-facebook-square fa-2x"></i> <abbr
									title="facebook"></abbr>: <a
									href="<%=travelOne.getFacebook()%>"><%=travelOne.getFacebook()%></a>
							</div>
							<%
								} else {
								}
							%>
							<%
								if (!travelOne.getLine().equalsIgnoreCase("-")
										&& !travelOne.getLine().equalsIgnoreCase("null")) {
							%>
							<div class="media-body">
								<i class="fa fa-linkedin-square fa-2x"></i> <abbr title="line"></abbr>:
								<%=travelOne.getLine()%>
							</div>
							<%
								} else {
								}
							%>
							<%
								if (!travelOne.getLine().equalsIgnoreCase("-")
										&& !travelOne.getLine().equalsIgnoreCase("null")) {
							%>
							<div class="media-body">
								<i class="fa fa-twitter-square fa-2x"></i> <abbr title="twi"></abbr>:
								<%=travelOne.getTwitter()%>
							</div>
							<%
								} else {
								}
							%>
						</div>
					</div>
				</div>
				<br>
				<!-- End Contact Details Column -->
				<!-- Map+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
				<!-- Intro Content -->
				<div class="list-group-item" style="background-color: #78bd8e">
					<div class="row header1">
						<div class="col-xs-12">
							<div class="col-xs-8">
								<h2 class="font-size-20 bold">
									<font color="#FFFFFF">แผนที่นำทาง</font>
								</h2>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
					<%if(!travelOne.getAddress().getMapimage().equals("null.jpg")){ %>
							<img class="img-rounded"
								src="Tools/images/mapimage/<%=travelOne.getAddress().getMapimage()%>"
								alt="<%=travelOne.getAddress().getMapimage()%>"
								style="width: 500px; height: 400px;">
						<%}else{ %>
								<img class="img-responsive"
									src="Tools/images/logo/pongyeanglogo.png"
									alt="pongyeanglogo.png"
									style="width: 500px; height: 400px;">
						<%} %>	
					</div>
					<div class="col-md-6">
						<%=travelOne.getAddress().getMapimagedetail()%>
					</div>
				</div>
				<!-- /.row -->
				<!-- Team Members -->
			</div>
			
			<div class="row">
			<%try{ %>
					<%if(travelOne.getVecotrarticle().get(0)!=null){ %>
				<div class="col-lg-12">
					<h2 class="page-header">บทความ</h2>
				</div>
				<%} %>

				<%
					for (int i = 0; i < travelOne.getVecotrarticle().size(); i++) {
				%>
				<div class="col-md-4 text-center">
					<div class="thumbnail">
						<a
							href="ViewArticlesServlet?va=<%=travelOne.getVecotrarticle().get(i).getArticleID()%>"><img
							class="img-responsive"
							src="Tools/images/article/<%=travelOne.getVecotrarticle().get(i).getVectorimages().get(0).getImageName()%>"></a>
						<div class="caption">
							<h3><%=travelOne.getVecotrarticle().get(i).getArticleName()%><br>
								<small><%=travelOne.getVecotrarticle().get(i).getDatecreate()%></small>
							</h3>
							<p><%=travelOne.getVecotrarticle().get(i).getArticleTitel()%></p>

						</div>
					</div>
				</div>
				<%
					}
				%>
				<%}catch (Exception e){ %>
					<div class="row">
						<div class="col-lg-12">
								<h2 class="page-header">ยังไม่มีบทความ</h2>
						</div>
					</div>
			<%} %>
				<!-- +++++++++++++++++++++++++++++++++++++++++++ -->
			</div>		
		</div>
		<!-- /.row -->
		<hr>
		<div class="col-md-12">
			<div class="fb-like"
				data-href="<%=url%>pongyeang/ViewPRTravelDetailServlet?travelID=<%=travelOne.getTraveldetailID()%>"
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
				data-href="<%=url%>pongyeang/ViewPRTravelDetailServlet?travelID=<%=travelOne.getTraveldetailID()%>"
				data-width="100%" data-numposts="5"></div>
		</div>
		
	</div>


	<!-- ********************************************************************************************************************* -->
	<br>
	<!-- === END CONTENT === -->
	<!-- Begin Footer -->
	<%@include file="pages/footer-menu.jsp"%>
	<!-- End Footer -->
</body>
<script type='text/javascript'>
	$('.fb-comments').click(function() {
		location.reload();
	});
</script>
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