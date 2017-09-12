<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%
	String userName = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("userId"))
				userName = cookie.getValue();
		}
	}
	if (userName == null)
		response.sendRedirect("adminLogin.jsp");
%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<meta name="description" content="">
<meta name="author" content="">
<title>Admin Dashboard</title>

<jsp:include page="links_1.jsp"></jsp:include>
<script src="js/myScript.js"></script>
<script src="ajax/adminHome.js"></script>

</head>

<body class="fixed-nav" id="page-top">

	<jsp:include page="adminHeaderMenu.jsp"></jsp:include>

	<div class="content-wrapper py-3">

		<div class="container-fluid">

			<!-- Breadcrumbs -->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
				
				<li class="breadcrumb-item active"><%=userName %>'s Dashboard</li>
			</ol>
			
			<img src='dash.jpg' width="1050px" height="350px">
			
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-area-chart"></i> Area Chart Example
				</div>
				<div class="card-body">
					<iframe class="chartjs-hidden-iframe" tabindex="-1"
						style="display: block; overflow: hidden; border: 0px; margin: 0px; top: 0px; left: 0px; bottom: 0px; right: 0px; height: 100%; width: 100%; position: absolute; pointer-events: none; z-index: -1;"></iframe>
					<canvas id="myAreaChart" width="722" height="216"
						style="display: block; width: 722px; height: 216px;"></canvas>
				</div>

			</div>

			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-bar-chart"></i> Bar Chart Example
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col-sm-8 my-auto">
							<iframe class="chartjs-hidden-iframe" tabindex="-1"
								style="display: block; overflow: hidden; border: 0px; margin: 0px; top: 0px; left: 0px; bottom: 0px; right: 0px; height: 100%; width: 100%; position: absolute; pointer-events: none; z-index: -1;"></iframe>
							<canvas id="myBarChart" width="471" height="235"
								style="display: block; width: 471px; height: 235px;"></canvas>
						</div>
						
					</div>
				</div>

			</div>


		</div>

		

	</div>
	
	<!-- Scroll to Top Button -->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fa fa-angle-up"></i>
	</a>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/popper/popper.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
	<script src="vendor/chart.js/Chart.min.js"></script>
	<script src="vendor/datatables/jquery.dataTables.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/sb-admin.min.js"></script>

</body>

</html>

