<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		
		<a class="navbar-brand" href="#">SnickInfo</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav navbar-sidenav">
				<li class="nav-item active" data-toggle="tooltip"
					data-placement="right" title="Dashboard"><a class="nav-link"
					href="adminHome.jsp"> <i class="fa fa-fw fa-dashboard"></i> <span
						class="nav-link-text"> Dashboard</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Tables"><a class="nav-link" href="adminUpload.jsp"> <i
						class="fa fa-fw fa-table"></i> <span class="nav-link-text">
							Upload</span>
				</a></li>

				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Tables"><a class="nav-link" href="adminInsert.jsp"> <i
						class="fa fa-fw fa-table"></i> <span class="nav-link-text">
							Insert/Update</span>
				</a></li>

				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Components"><a class="nav-link" href="adminDelete.jsp">
						<i class="fa fa-fw fa-scissors"></i> <span class="nav-link-text">
							Delete</span>
				</a></li>

			</ul>
			
			<ul class="navbar-nav sidenav-toggler">
				<li class="nav-item"><a class="nav-link text-center"
					id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
				</a></li>

			</ul>

			<ul class="navbar-nav ml-auto">
			
				<li class="nav-item">
					<form class="form-inline my-2 my-lg-0 mr-lg-2">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Search for..."> <span
								class="input-group-btn">
								<button class="btn btn-primary" type="button">
									<i class="fa fa-search"></i>
								</button>
							</span>
						</div>
					</form>
				</li>
				
				<li class="nav-item">
					<form class="navbar-form navbar-left">
						<button type="button" id="btn-logout" class="btn btn-danger">
							<i class="fa fa-fw fa-sign-out"></i> Logout
						</button>
					</form>
				<li class="nav-item">
			</ul>
		</div>
	</nav>