<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>
<div class="clearfix sidebar">
	<div class="clearfix single_sidebar category_items">
		<h2>Danh mục bất động sản</h2>
		<ul>
			<c:choose>
			<c:when test="${ not empty listcats }">
			<c:forEach items="${listcats}" var="cat">
			<li class="cat-item"><a href="${pageContext.request.contextPath}/cat/${cat.cid}">${cat.cname }</a>(${cat.num })</li>
			</c:forEach>
			</c:when>
			<c:otherwise>
			empty cat
			</c:otherwise>
			</c:choose>
		</ul>
	</div>

	<div class="clearfix single_sidebar">
		<div class="popular_post">
			<div class="sidebar_title">
				<h2>Xem nhiều</h2>
			</div>
			<ul>	
			<c:choose>
			<c:when test="${ not empty listlands }">
			<c:forEach items="${listlands}" var="land" >
			<li><a href="${pageContext.request.contextPath}/single/${land.lid}">${land.lname }</a></li>
			</c:forEach>
			</c:when>
			<c:otherwise>
			empty cat
			</c:otherwise>
			</c:choose>
			</ul>
		</div>
	</div>

	<div class="clearfix single_sidebar">
		<h2>Danh mục hot</h2>
		<ul>
			<c:choose>
			<c:when test="${ not empty listcats }">
			<c:forEach items="${listcats}" var="cat" >
			<li class="cat-item"><a href="${pageContext.request.contextPath}/cat/${cat.cid}">${cat.cname }</a>(${cat.num})</li>
			</c:forEach>
			</c:when>
			<c:otherwise>
			empty cat
			</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>