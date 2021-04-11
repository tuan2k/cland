<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp"%>
<div class="col-md-10">

	<div class="row">
		<div class="col-md-12 panel-info">
			<div class="content-box-header panel-heading">
				<div class="panel-title ">Sửa danh mục</div>
			</div>
			<div class="content-box-large box-with-header">
				<div>
					<div class="row mb-10"></div>

					<div class="row">
						<div class="col-sm-6">
							<c:choose>
								<c:when test="${not empty cat }">
									<div class="row">
										<div class="col-md-12 panel-info">
											<form method="post" action="${pageContext.request.contextPath}/admin/cat/edit">
												<input name="cid" type="hidden" value="${cat.cid }" /> Tên
												danh mục: <input name="cname" value="${cat.cname }"
													type="text" /><br />
													<hr>
											 <input name="submit" value="Lưu"
													type="submit" />
											</form>
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<p class="msg">Empty news</p>
								</c:otherwise>
							</c:choose>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- /.row col-size -->

</div>