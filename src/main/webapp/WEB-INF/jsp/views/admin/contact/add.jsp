<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>
<div class="col-md-10">

	<div class="row">
		<div class="col-md-12 panel-info">
			<form action="${pageContext.request.contextPath}/admin/contact/add"
				method="post">
				Họ và tên: <input name="fullname" value="" type="text" /><br />
				Email: <input name="email" value="" type="text" /><br />
				Môn học: <input name="subject" value="" type="text" /><br />
				Nội dung: <textarea name="content" ></textarea><br />
				<input name="submit" value="Lưu" type="submit" />
			</form>
		</div>
	</div>
	<!-- /.row col-size -->

</div>