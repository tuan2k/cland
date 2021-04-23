<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>
<div class="col-md-10">

	<div class="row">
		<div class="col-md-12 panel-info">
			<div class="content-box-header panel-heading">
				<div class="panel-title ">Thêm liên lạc</div>
			</div>

			<c:if test="${not empty msg }">
				<div class="alert alert-danger" role="alert">${msg }</div>
			</c:if>

			<div class="content-box-large box-with-header">
				<div>
					<div class="row mb-10"></div>

					<form:errors path="contact.*" cssStyle="color:red" cssClass="error"></form:errors>
					<div class="row">
						<div class="col-sm-6">
							<form
								action="${pageContext.request.contextPath}/admin/contact/add"
								method="post">
								<div class="form-group">
									<label for="name">Họ và tên: </label> <input type="text"
										name="fullname" class="form-control"
										placeholder="Nhập họ và tên">
								</div>
								<div class="form-group">
									<label for="name">Email: </label> <input type="text"
										name="email" class="form-control" placeholder="Nhập email">
								</div>
								<div class="form-group">
									<label for="name">Môn học: </label> <input type="text"
										name="subject" class="form-control" placeholder="Nhập môn học">
								</div>
								<div class="form-group">
									<label for="name">Nội dung: </label>
									<textarea type="text" name="content" class="form-control"
										placeholder="Nhập nội dung"></textarea>
								</div>
								<div class="col-sm-12">
									<input type="submit" value="Thêm" class="btn btn-success" /> <input
										type="reset" value="Nhập lại" class="btn btn-default" />
								</div>
							</form>
						</div>
					</div>
					<hr>
				</div>
			</div>
		</div>
		<!-- /.row col-size -->

	</div>
</div>