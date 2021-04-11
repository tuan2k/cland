<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>
<div class="col-md-10">

	<div class="row">
		<div class="col-md-12 panel-info">
			<div class="content-box-header panel-heading">
				<div class="panel-title ">Thêm người sử dụng</div>
			</div>

			<div class="content-box-large box-with-header">
				<div>
					<div class="row mb-10"></div>

					<div class="row">
						<div class="col-sm-6">
							<form
								action="${pageContext.request.contextPath}/admin/user/add-model"
								method="post">
								<div class="col-sm-6">
									<div class="form-group">
										<label for="name">Tên đăng nhập:</label> <input type="text"
											name="username" class="form-control"
											placeholder="Nhập tên đăng nhập">
									</div>

									<div class="form-group">
										<label for="name">Mật khẩu:</label> <input type="password"
											name="password" class="form-control"
											placeholder="Nhập mật khẩu">
									</div>
									<div class="form-group">
										<label for="name">Họ và tên: </label> <input type="text"
											name="fullname" class="form-control"
											placeholder="Nhập mật khẩu">
									</div>
								</div>
								<div class="col-sm-12">
									<input type="submit" value="Thêm" class="btn btn-success" /> <input
										type="reset" value="Nhập lại" class="btn btn-default" />
								</div>

							</form>
						</div>
					</div>

				</div>
			</div>

		</div>
	</div>
	<!-- /.row col-size -->

</div>