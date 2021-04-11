<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section id="header_area">
			<div class="wrapper header">
				<div class="clearfix header_top">
					<div class="clearfix logo floatleft">
						<a href="index.html"><h1><span>C</span>Land</h1></a>
					</div>
					<div class="clearfix search floatright">
						<form>
							<input type="text" placeholder="Search"/>
							<input type="submit" />
						</form>
					</div>
				</div>
				<div class="header_bottom">
					<nav>
						<ul id="nav">
							<li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>
							<li id="dropdown"><a href="cat.html">Bất động sản</a>
								<ul>
									<li><a href="cat.html">Danh mục 1</a></li>
									<li><a href="cat.html">Danh mục 2</a></li>
									<li><a href="cat.html">Danh mục 3</a></li>
									<li><a href="cat.html">Danh mục 4</a></li>
								</ul>
							</li>
							<li><a href="${pageContext.request.contextPath}/cat/1">Giới thiệu</a></li>
							<li><a href="${pageContext.request.contextPath}/contact">Liên hệ</a></li>
						</ul>
					</nav>
				</div>
			</div>
</section>