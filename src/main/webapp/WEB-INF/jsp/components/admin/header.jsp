<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="header">
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<!-- Logo -->
				<div class="logo">
					<h1>
						<a href="index.html">VNE-Admin</a>
					</h1>
				</div>
			</div>
			<div class="col-md-5">
				<div class="row">
					<div class="col-lg-12"></div>
				</div>
			</div>
			<div class="col-md-2">
				<div class="navbar navbar-inverse" role="banner">
					<nav
						class="collapse navbar-collapse bs-navbar-collapse navbar-right"
						role="navigation">
						<ul class="nav navbar-nav">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">My Account <b class="caret"></b></a>
								<ul class="dropdown-menu animated fadeInUp">
									<li><a href="profile.html">Profile</a></li>
									<li><a href="${pageContext.request.contextPath }/auth/logout">Logout</a></li>
								</ul></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="js/bootstrap/bootstrap-dropdown.js"></script>
<script>
	$(document).ready(function() {
		$('.dropdown-toggle').dropdown()
	});
</script>