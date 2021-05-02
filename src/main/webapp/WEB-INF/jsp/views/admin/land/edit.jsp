<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>	
<div class="col-md-10">
	<div class="row">
		<div class="col-md-12 panel-info">
			<div class="content-box-header panel-heading">
				<div class="panel-title ">Sửa đất đai</div>
			</div>
			<br> <br>
			<c:if test="${not empty msg }">
			<div class="alert alert-danger" role="alert">
			${ msg}
			</div>
			</c:if>
			<div class="content-box-large box-with-header">
			
				<c:choose>
				<c:when test="${not empty land }">
				<form:form action="${pageContext.request.contextPath }/admin/land/edit" method="post" enctype="multipart/form-data" modelAttribute="land">
				<div>
					<div class="row mb-10"></div>

					<div class="row">
						<div class="col-sm-6">
							<input name="lid" type="hidden" value="${land.lid }" />
							<div class="form-group">
								<label for="name">Tên lô đất</label>
								 <input type="text" class="form-control" name="lname" value="${land.lname }">
							</div>

							<div class="form-group">
								<label>Danh mục </label> 
								<select class="form-control" name="cid">
									<c:forEach items="${listcats}" var="cat">
									<option value="${ cat.cid }" <c:if test="${cat.cid == land.category.cid }">checked</c:if> >${cat.cname }</option>
									</c:forEach>
								</select>
							</div>
							
							<div class="form-group">
								<label>Mô tả</label>
								<textarea class="form-control" rows="3" name="description">${land.description }</textarea>
							</div>
							
							<div class="form-group">
								<label>Thêm hình ảnh</label>
								<input type="file" class="btn btn-default" name="image">
								<p class="help-block">
									<em>Định dạng: jpg, png, jpeg,...</em>
								</p>
							</div>
							<div class="form-group">
								<label for="name">area</label>
								 <input type="text" class="form-control" name="area" value="${land.area }">
							</div>
							
							<div class="form-group">
								<label for="name">Địa chỉ</label>
								 <input type="text" class="form-control" name="address" value="${land.address }">
							</div>
							
							<div class="form-group">
								<label for="name">count_views</label>
								 <input type="text" class="form-control" name="count_views" value="${land.count_views }">
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
				</form:form>
				</c:when>
				<c:otherwise></c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<!-- /.row col-size -->

</div>