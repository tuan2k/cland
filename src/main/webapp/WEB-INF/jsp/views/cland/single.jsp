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
	</div>

	<div class="more_themes">
		<h2>
			Bất động sản liên quan <i class="fa fa-thumbs-o-up"></i>
		</h2>
		<c:choose>
		<c:when test="${not empty listlands }">
		<c:forEach items="${listlands }" var="lands">
		<c:if test="${land.lid != lands.lid && land.category.cid == lands.category.cid}">
		<h2><a href="${pageContext.request.contextPath }/single/${lands.lid}">${lands.lname }</a></h2>
		</c:if>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<h2>Empty listlands</h2>
		</c:otherwise>
		</c:choose>
	</div>
	</c:when>
	</c:choose>
	

</div>