<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>
<div class="clearfix main_content floatleft">

	<c:choose>
	<c:when test="${not empty land }">
	
	<div class="clearfix content">

		<h1>${land.lname }</h1>
		<div class="clearfix post-meta">
			<p>
				<span><i class="fa fa-clock-o"></i> ${land.address }</span> <span><i class="fa fa-folder"></i> Diện tích: 100m2</span>
			</p>
		</div>

		<div class="vnecontent">
			<p>${land.description }</p>
		</div>

		<a class="btn" href="">Bài trước</a> <a class="btn" href="">Bài kế</a>

	</div>

	<div class="more_themes">
		<h2>
			Bất động sản liên quan <i class="fa fa-thumbs-o-up"></i>
		</h2>
		<c:choose>
		<c:when test="${not empty listlands }">
		<c:forEach items="${listland }" var="lands">
		<c:if test="${land.lid != lands.lid }">
		<div class="more_themes_container">
			<div class="single_more_themes floatleft">
				<img src="http://dummyimage.com/220x150/000/fff&text=Thumbnail"
					alt="" /> <a href="${pageContext.request.contextPath }/single/${lands.lid}"><h2>${lands.lname }</h2></a>
			</div>
		</div>
		</c:if>
		</c:forEach>
		</c:when>
		<c:otherwise>
		empty
		</c:otherwise>
		
		</c:choose>
		
	</div>
	
	</c:when>
	</c:choose>
	

</div>