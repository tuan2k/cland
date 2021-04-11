<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>
<div class="clearfix slider">
	<ul class="pgwSlider">
		<li><img src="${ contentpath}/images/thumbs/megamind_07.jpg" alt="Paris, France"
			data-description="Eiffel Tower and Champ de Mars"
			data-large-src="${ contentpath}/images/slides/megamind_07.jpg" /></li>
		<li><img src="${ contentpath}/images/thumbs/wall-e.jpg"
			alt="MontrÃ©al, QC, Canada" data-large-src="${ contentpath}/images/slides/wall-e.jpg"
			data-description="Eiffel Tower and Champ de Mars" /></li>
		<li><img src="${ contentpath}/images/thumbs/up-official-trailer-fake.jpg"
			alt="Shanghai, China"
			data-large-src="${ contentpath}/images/slides/up-official-trailer-fake.jpg"
			data-description="Shanghai ,chaina"></li>


	</ul>
</div>


<div class="clearfix content">
	<div class="content_title">
		<h2>Bài viết mới</h2>
	</div>

	<c:choose>
	<c:when test="${not empty listlands }">
	<c:forEach items="${listlands}" var="land">
	<div class="clearfix single_content">
		<div class="clearfix post_date floatleft">
			<div class="date">
				<h3>27</h3>
				<p>Tháng 3</p>
			</div>
		</div>
		<div class="clearfix post_detail">
			<h2>
				<a href="">${land.lname }</a>
			</h2>
			<div class="clearfix post-meta">
				<p>
					<span><i class="fa fa-clock-o"></i>${land.address }</span> <span><i class="fa fa-folder"></i>
						Diện tích: 100m2</span>
				</p>
			</div>
			<div class="clearfix post_excerpt">
				<img src="${ contentpath}/images/thumb.png" alt="" />
				<p>${land.description }</p>
			</div>
			<a href="${pageContext.request.contextPath }/single/${land.lid}">Xem thêm</a>
		</div>
	</div>
	</c:forEach>
	</c:when>
	<c:otherwise>
	empty news
	</c:otherwise>
	
	</c:choose>
	

	
</div>

<div class="pagination">
	<nav>
		<ul>
			<li><a href=""> << </a></li>
			<li><a href="">1</a></li>
			<li><a href="">2</a></li>
			<li><a href="">3</a></li>
			<li><a href="">4</a></li>
			<li><a href=""> >> </a></li>
		</ul>
	</nav>
</div>