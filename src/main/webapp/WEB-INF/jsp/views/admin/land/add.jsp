<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>	
<div class="col-md-10">
	<div class="row">
		<div class="col-md-12 panel-info">
			<div class="content-box-header panel-heading">
				<div class="panel-title ">Thêm đất đai</div>
			</div>
			
			<c:if test="${not empty msg }">
				<div class="alert alert-danger" role="alert">${msg }</div>
			</c:if>
			
			<form:errors path="land.*" cssStyle="color:red"
						cssClass="error"></form:errors>
			<div class="content-box-large box-with-header">
				<form action="${pageContext.request.contextPath}/admin/land/add" id="frmLogin"
				 method="post" enctype="multipart/form-data">
				<div>
					<div class="row mb-10"></div>

					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="name">Tên lô đất</label>
								 <input type="text" class="form-control" name="lname" required>
							</div>

							<div class="form-group">
								<label>Danh mục </label> 
								<select class="form-control" name="cname">
									<c:forEach items="${listcats}" var="cat">
									<option value="${ cat.cname }">${cat.cname }</option>
									</c:forEach>
								</select>
							</div>
							
							<div class="form-group">
								<label>Mô tả</label>
								<textarea class="form-control" rows="3" name="description" required></textarea>
							</div>
							
							<div class="form-group">
								<label>Thêm hình ảnh</label>
								<input type="file" class="btn btn-default" name="image" required>
								<p class="help-block">
									<em>Định dạng: jpg, png, jpeg,...</em>
								</p>
							</div>
							<div class="form-group">
								<label for="name">area</label>
								 <input type="text" class="form-control" name="area" required>
							</div>
							
							<div class="form-group">
								<label for="name">Địa chỉ</label>
								 <input type="text" class="form-control" name="address" required>
							</div>
							
							<div class="form-group">
								<label for="name">count_views</label>
								 <input type="text" class="form-control" name="count_views" required>
							</div>
						</div>
					</div>

					<hr>

					<div class="row">
						<div class="col-sm-12">
							<input type="submit" value="Thêm" class="btn btn-success" /> <input
								type="reset" value="Nhập lại" class="btn btn-default" />
						</div>
					</div>
				</div>
				</form>
				
			</div>
			
		</div>
	</div>
	<!-- /.row col-size -->
</div>