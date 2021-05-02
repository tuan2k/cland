<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<title>CLand | VinaEnter Edu</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!--Oswald Font -->
<link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700'
	rel='stylesheet' type='text/css' />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/cland/css/tooltipster.css" />
<!-- home slider-->
<link href="${pageContext.request.contextPath}/resources/cland/css/pgwslider.css" rel="stylesheet" />
<!-- Font Awesome -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/cland/css/font-awesome.min.css" />
<link href="${pageContext.request.contextPath}/resources/cland/style.css" rel="stylesheet" media="screen" />
<link href="${pageContext.request.contextPath}/resources/cland/responsive.css" rel="stylesheet"
	media="screen" />
</head>

<body>

	<section id="content_area">
	<div class="clearfix wrapper main_content_area">

		<div class="clearfix main_content floatleft">


			<div class="clearfix content">
				<div class="content_title">
					<h2>Our Works</h2>
				</div>


				<div class="clearfix single_work_container">
					<c:choose>
						<c:when test="${not empty listland }">
							<c:forEach items="${listland }" var="land">
								<div class="clearfix single_work">
									<img class="img_top" src="${pageContext.request.contextPath}/resources/cland/images/work1.png"
										alt="" /> <img class="img_bottom"
										src="${pageContext.request.contextPath}/resources/cland/images/work_bg2.png" alt="" />
									<h2>${land.lid }</h2>
									<a href="${pageContext.request.contextPath}/single/${land.lid}"><p class="caption">${land.lname }</p></a>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
						empty
						</c:otherwise>
					</c:choose>
					<div class="clearfix work_pagination">
						<nav> <a class="newer floatleft" href=""> < -- Trang
							trước</a> <a class="older floatright" href="">Trang kế -- ></a> </nav>
					</div>

				</div>
			</div>

		</div>
	</div>
	</section>

	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.7.0.min.js"></script>
	<script type="text/javascript"
		src="${contentpath }/js/jquery.tooltipster.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.tooltip').tooltipster();
		});
	</script>
	<script type="text/javascript"
		src="${contentpath }/js/selectnav.min.js"></script>
	<script type="text/javascript">
		selectnav('nav', {
			label : '-Navigation-',
			nested : true,
			indent : '-'
		});
	</script>
	<script src="${contentpath }/js/pgwslider.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.pgwSlider').pgwSlider({

				intervalDuration : 5000

			});
		});
	</script>
	<script type="text/javascript"
		src="${contentpath }/js/placeholder_support_IE.js"></script>
</body>
</html>


