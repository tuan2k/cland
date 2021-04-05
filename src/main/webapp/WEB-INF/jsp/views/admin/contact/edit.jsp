<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>
<div class="col-md-10">
	<c:choose>
		<c:when test="${not empty contact }">
			<div class="row">
				<div class="col-md-12 panel-info">
					<form
						action="${pageContext.request.contextPath}/admin/contact/edit-model"
						method="post">
						<input name="cid" type="hidden" value="${contact.cid }"/>
						Họ và tên: <input name="fullname" value="${contact.fullname }" type="text" /><br />
						Email: <input name="email" value="${contact.email }" type="text" /><br />
						Môn học: <input name="subject" value="${contact.subject }" type="text" /><br />
						Nội dung: <textarea name="content" >${contact.content }</textarea><br />
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