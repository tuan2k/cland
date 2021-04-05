<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>
<div class="col-md-10">
	<c:choose>
		<c:when test="${not empty cat }">
			<div class="row">
				<div class="col-md-12 panel-info">
					<form
						action="${pageContext.request.contextPath}/admin/cat/edit-model"
						method="post">
						<input name="cid" type="hidden" value="${cat.cid }"/>
						Tên danh mục: <input name="cname" value="${cat.cname }" type="text" /><br />
						<input name="submit" value="Lưu" type="submit" />
					</form>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<p class="msg">Empty news</p>
		</c:otherwise>
	</c:choose>
</div>