<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp" %>
<c:url value="resources/cland/" var="contentpath" scope="application"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<title>CLand | VinaEnter Edu</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<!--Oswald Font -->
	<link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="${contentpath }/css/tooltipster.css" />
	<!-- home slider-->
	<link href="${contentpath }/css/pgwslider.css" rel="stylesheet"/>
	<!-- Font Awesome -->
	<link rel="stylesheet" href="${contentpath }/css/font-awesome.min.css"/>
	<link href="${contentpath }/style.css" rel="stylesheet" media="screen"/>
	<link href="${contentpath }/responsive.css" rel="stylesheet" media="screen"/>
</head>

<body>

	<tiles:insertAttribute name="header">
	</tiles:insertAttribute>
	<section id="content_area">
	<div class="clearfix wrapper main_content_area">
		<div class="clearfix main_content floatleft">
		
			<tiles:insertAttribute name="content">
			</tiles:insertAttribute>
			
		</div>
		<div class="clearfix sidebar_container floatright">
		
			<tiles:insertAttribute name="rightbar">
			</tiles:insertAttribute>
			
		</div>
	</div>
	</section>

	<tiles:insertAttribute name="footer">
			</tiles:insertAttribute>

	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.7.0.min.js"></script>
	<script type="text/javascript" src="${ contentpath }/js/jquery.tooltipster.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.tooltip').tooltipster();
		});
	</script>
	<script type="text/javascript" src="${contentpath }/js/selectnav.min.js"></script>
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
	<script type="text/javascript" src="${contentpath }/js/placeholder_support_IE.js"></script>
</body>
</html>


