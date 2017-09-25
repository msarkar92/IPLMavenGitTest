<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dto.UploadFileLogDTO"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<meta name="description" content="">
<meta name="author" content="">
<title>Update Match Info</title>

<jsp:include page="links_1.jsp"></jsp:include>
<script src="js/myScript.js"></script>

</head>

<body class="fixed-nav" id="page-top">

	<jsp:include page="adminHeaderMenu.jsp"></jsp:include>

	<div class="content-wrapper py-3">
		<div class="container-fluid">
			<!-- Breadcrumbs -->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Upload</a></li>
			</ol>
			<div class="row">
				<div class="col-sm-3 col-md-2 sidebar">
					<ul class="nav nav-sidebar">
						<form action="UpdateVenueController" method="post">
							<label for="id">Id</label> <input type="number" id="venueid" name="venueid"> 
							<label for="lname">Venue</label> 
							<input type="text" id="venue" name="venue"> 
							<label for="country">City</label> <input type="text" id="city" name="city"> 
							<input class="col-sm-4" type="submit" value="Update">
						</form>
					</ul>
				</div>
			</div>
		</div>
	</div>

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
