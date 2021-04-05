<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-md-10">
	<div class="content-box-large">
		<div class="row">
			<div class="panel-heading">
				<div class="panel-title ">Quản lý danh mục</div>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-8">
				<a href="add.html" class="btn btn-success"><span
					class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

			</div>
			<div class="col-md-4">
				<div class="input-group form">
					<input type="text" class="form-control" placeholder="Search...">
					<span class="input-group-btn">
						<button class="btn btn-primary" type="button">Search</button>
					</span>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="panel-body">
				<table cellpadding="0" cellspacing="0" border="0"
					class="table table-striped table-bordered" id="example">
					<thead>
						<tr>
							<th>ID</th>
							<th>Tên</th>
							<th>Danh mục</th>
							<th>Lượt đọc</th>
							<th>Hình ảnh</th>
							<th>Chức năng</th>
						</tr>
					</thead>
					<tbody>
						<tr class="odd gradeX">
							<td>1</td>
							<td>Internet Explorer 4.0</td>
							<td>Win 95+</td>
							<td class="center">4</td>
							<td class="center text-center"><img src="${pageContext.request.contextPath }/resources/admin/images/fff.png" />
							</td>
							<td class="center text-center"><a href="" title=""
								class="btn btn-primary"><span
									class="glyphicon glyphicon-pencil "></span> Sửa</a> <a href=""
								title="" class="btn btn-danger"><span
									class="glyphicon glyphicon-trash"></span> Xóa</a></td>
						</tr>
						<tr class="even gradeC">
							<td>2</td>
							<td>Internet Explorer 5.0</td>
							<td>Win 95+</td>
							<td>95</td>
							<td class="center text-center"><img src="${pageContext.request.contextPath }/resources/admin/images/fff.png" />
							</td>
							<td class="center text-center"><a href="" title=""
								class="btn btn-primary"><span
									class="glyphicon glyphicon-pencil "></span> Sửa</a> <a href=""
								title="" class="btn btn-danger"><span
									class="glyphicon glyphicon-trash"></span> Xóa</a></td>
						</tr>
						<tr class="odd gradeA">
							<td>3</td>
							<td>Internet Explorer 5.5</td>
							<td>Win 95+</td>
							<td class="center">5.5</td>
							<td class="center text-center"><img src="${pageContext.request.contextPath }/resources/admin/images/fff.png" />
							</td>
							<td class="center text-center"><a href="" title=""
								class="btn btn-primary"><span
									class="glyphicon glyphicon-pencil"></span> Sửa</a> <a href=""
								title="" class="btn btn-danger"><span
									class="glyphicon glyphicon-trash"></span> Xóa</a></td>
						</tr>
						<tr class="even gradeA">
							<td>4</td>
							<td>Internet Explorer 6</td>
							<td>Win 98+</td>
							<td class="center">6</td>
							<td class="center text-center"><img src="${pageContext.request.contextPath }/resources/admin/images/fff.png" />
							</td>
							<td class="center text-center"><a href="" title=""
								class="btn btn-primary"><span
									class="glyphicon glyphicon-pencil "></span> Sửa</a> <a href=""
								title="" class="btn btn-danger"><span
									class="glyphicon glyphicon-trash"></span> Xóa</a></td>
						</tr>
						<tr class="odd gradeA">
							<td>5</td>
							<td>Internet Explorer 7</td>
							<td>Win XP SP2+</td>
							<td class="center">7</td>
							<td class="center text-center"><img src="${pageContext.request.contextPath }/resources/admin/images/fff.png" />
							</td>
							<td class="center text-center"><a href="" title=""
								class="btn btn-primary"><span
									class="glyphicon glyphicon-pencil "></span> Sửa</a> <a href=""
								title="" class="btn btn-danger"><span
									class="glyphicon glyphicon-trash"></span> Xóa</a></td>
						</tr>
						<tr class="even gradeA">
							<td>6</td>
							<td>AOL browser (AOL desktop)</td>
							<td>Win XP</td>
							<td class="center">6</td>
							<td class="center text-center"><img src="${pageContext.request.contextPath }/resources/admin/images/fff.png" />
							</td>
							<td class="center text-center"><a href="" title=""
								class="btn btn-primary"><span
									class="glyphicon glyphicon-pencil "></span> Sửa</a> <a href=""
								title="" class="btn btn-danger"><span
									class="glyphicon glyphicon-trash"></span> Xóa</a></td>
						</tr>
					</tbody>
				</table>

				<!-- Pagination -->
				<nav class="text-center" aria-label="...">
					<ul class="pagination">
						<li class="disabled"><a href="#" aria-label="Previous"><span
								aria-hidden="true">«</span></a></li>
						<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#" aria-label="Next"><span
								aria-hidden="true">»</span></a></li>
					</ul>
				</nav>
				<!-- /.pagination -->

			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.content-box-large -->



</div>