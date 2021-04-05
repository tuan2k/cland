<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-md-10">

	<div class="row">
		<div class="col-md-12 panel-info">
			<div class="content-box-header panel-heading">
				<div class="panel-title ">Thêm danh mục</div>
			</div>
			<div class="content-box-large box-with-header">
				<div>
					<div class="row mb-10"></div>

					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="name">Tên truyện</label> <input type="text"
									class="form-control" placeholder="Nhập tên truyện">
							</div>

							<div class="form-group">
								<label>Danh mục truyện</label> <select class="form-control">
									<option>Amsterdam</option>
									<option>Atlanta</option>
									<option>Baltimore</option>
									<option>Boston</option>
								</select>
							</div>

							<div class="form-group">
								<label>Thêm hình ảnh</label> <input type="file"
									class="btn btn-default" id="exampleInputFile1">
								<p class="help-block">
									<em>Định dạng: jpg, png, jpeg,...</em>
								</p>
							</div>

							<div class="form-group">
								<label>Mô tả</label>
								<textarea class="form-control" rows="3"></textarea>
							</div>


						</div>

						<div class="col-sm-6"></div>

						<div class="col-sm-12">
							<div class="form-group">
								<label>Chi tiết</label>
								<textarea class="form-control" rows="7"></textarea>
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
			</div>
		</div>
	</div>
	<!-- /.row col-size -->

</div>