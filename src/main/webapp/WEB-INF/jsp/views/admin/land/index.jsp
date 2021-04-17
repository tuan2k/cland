<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>
<p>${ msg}</p>
<div class="col-md-10">
	<div class="content-box-large">
		<div class="row">
			<div class="panel-heading">
				<div class="panel-title ">Quản lý đất đai</div>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-8">
				<a href="${pageContext.request.contextPath }/admin/land/add" class="btn btn-success"><span
					class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

			</div>
			<div class="col-md-4">
				<div class="input-group form">
					<input type="text" class="form-control" placeholder="Search...">
					<span class="input-group-btn">
						<button class="btn btn-primary" type="button">Search</button>
					</span>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="panel-body">

				<c:choose>
					<c:when test="${not empty listlands }">
						<table cellpadding="0" cellspacing="0" border="0"
							class="table table-striped table-bordered" id="example">
							<thead>
								<tr>
									<th>ID</th>
									<th>Tên</th>
									<th>Danh mục</th>
									<th>Lượt đọc</th>
									<th>Hình ảnh</th>
									<th>Chức năng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listlands}" var="land">
								<tr class="odd gradeX">
									<td>${land.lid }</td>
									<td>${land.lname }</td>
									<td>${land.category.cname }</td>
									<td class="center">${ land.count_views}</td>
									<td class="center text-center"><img
										src="${ pageContext.request.contextPath}/resources/files/${land.picture}" />
									</td>
									<td class="center text-center"><a href="${pageContext.request.contextPath }/admin/land/edit/${land.lid}" title=""
										class="btn btn-primary"><span
											class="glyphicon glyphicon-pencil "></span> Sửa</a> 
									<a href="${pageContext.request.contextPath }/admin/land/delete/${land.lid}"
										title="" class="btn btn-danger"><span
											class="glyphicon glyphicon-trash"></span> Xóa</a></td>
								</tr>
								</c:forEach>

							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<p class="msg">Empty news</p>
					</c:otherwise>
				</c:choose>

				<!-- Pagination -->
				<c:if test="${not empty totalPage}">
				<nav class="text-center" aria-label="...">
					<ul class="pagination">
						<c:set value="0" var="k"></c:set>
						<c:forEach begin="1" end="${totalPage}" var="i">
						<c:if test="${ k == 0}">
						<c:choose>
						<c:when test="${currentPage > 1 }">
						<li><a href="${pageContext.request.contextPath }/admin/land/index/${currentPage-1}" aria-label="Previous"><span
								aria-hidden="true">«</span></a></li>
						</c:when>
						<c:otherwise>
						<li><a href="${pageContext.request.contextPath }/admin/land/index/1" aria-label="Previous"><span
								aria-hidden="true">«</span></a></li>
						</c:otherwise>
						</c:choose>
						<c:set value="1" var="k"></c:set>
						</c:if>
						<li class="<c:if test="${ i == currentPage }">active</c:if>">
						<a href="${pageContext.request.contextPath }/admin/land/index/${i}">${i } 
						<span class="sr-only">(current)</span></a></li>
						<c:if test="${ i == totalPage}">
						<c:choose>
						<c:when test="${currentPage < totalPage }">
						<li><a href="${pageContext.request.contextPath }/admin/land/index/${currentPage+1}" aria-label="Next"><span
								aria-hidden="true">»</span></a></li>
						</c:when>
						<c:otherwise>
						<li><a href="${pageContext.request.contextPath }/admin/land/index/${totalPage}" aria-label="Next"><span
								aria-hidden="true">»</span></a></li>
						</c:otherwise>
						</c:choose>
						</c:if>
						</c:forEach>
						
					</ul>
				</nav>
				</c:if>
				<!-- /.pagination -->

			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.content-box-large -->



</div>