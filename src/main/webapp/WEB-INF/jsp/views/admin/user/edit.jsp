<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>
<div class="col-md-10">
	<c:choose>
		<c:when test="${not empty user }">
			<div class="row">
				<div class="col-md-12 panel-info">
					<form
						action="${pageContext.request.contextPath}/admin/user/edit-model"
						method="post">
						<input name="id" type="hidden" value="${user.id }"/>
						Tên đăng nhập: <input name="username" value="${user.username }" type="text" /><br />
						<br /> Mật khẩu: <input name="password" type="password" value="${user.password }"/><br />
						<br /> Họ và tên: <input name="fullname" type="text" value="${user.fullname }" /><br />
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