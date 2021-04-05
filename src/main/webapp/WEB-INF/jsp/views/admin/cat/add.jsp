<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>
<div class="col-md-10">

	<div class="row">
		<div class="col-md-12 panel-info">
			<form action="${pageContext.request.contextPath}/admin/cat/add-model"
				method="post">
				Tên danh mục: <input name="cname" value="" type="text" /><br />
				<input name="submit" value="Lưu" type="submit" />
			</form>
		</div>
	</div>
	<!-- /.row col-size -->

</div>