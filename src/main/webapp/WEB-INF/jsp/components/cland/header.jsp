<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>

<section id="header_area">
	<div class="wrapper header">
		<div class="clearfix header_top">
			<div class="clearfix logo floatleft">
				<a href="index.html"><h1>
						<span>C</span>Land
					</h1></a>
			</div>
			<div class="clearfix search floatright">
				<form action="${pageContext.request.contextPath}/search">
					<input type="text" placeholder="Search" name="search" /> <input
						type="submit" />
				</form>
			</div>
		</div>
		<div class="header_bottom">
			<nav>
				<ul id="nav">
					<li><a href="${pageContext.request.contextPath}/">Trang
							chủ</a></li>
					<li id="dropdown"><a
						href="${pageContext.request.contextPath}/cat/1">Bất động sản</a>
						<ul>
							<c:choose>
								<c:when test="${ not empty listcats }">
									<c:forEach items="${listcats}" var="cat">

										<li><a
											href="${pageContext.request.contextPath}/cat/${cat.cid}">${cat.cname }</a>
										</li>
									</c:forEach>
								</c:when>
							</c:choose>
						</ul></li>
					<li><a href="${pageContext.request.contextPath}/cat/1">Giới
							thiệu</a></li>
					<li><a href="${pageContext.request.contextPath}/contact">Liên
							hệ</a></li>
				</ul>
			</nav>
		</div>
	</div>
</section>