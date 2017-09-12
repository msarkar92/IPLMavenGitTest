<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<meta name="description" content="">
<meta name="author" content="">
<title>Insert Match Info</title>

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
				<li class="breadcrumb-item"><a href="#">Insert/Update</a></li>
			</ol>

			<!-- Insert -->
			<form action="AddController" method="post" id="form-content">
				<label for="fname">Season</label> 
				<input type="text" id="season"
					name="season"> 
					<label for="lname">Venue</label> <input
					type="text" id="venue" name="venue"> 
					<label for="country">City</label>
				<input type="text" id="city" name="city"> 
				<label
					for="country">Team_1</label> <input type="text" id="team_name1"
					name="team_name1"> 
					<label for="country">Team_2</label> <input
					type="text" id="team_name2" name="team_name2">
					 <label
					for="country">Winner</label> <input type="text" id="winner"
					name="winner"> 
					<label for="country">Win By Runs</label> <input
					type="text" id="runs" name="runs"> 
					<label for="country">Win
					By Wickets</label> <input type="text" id="wickets" name="wickets">
				<label for="country">Umpire_1</label> <input type="text"
					id="umpire_name1" name="umpire_name1"> 
					<label for="country">Umpire_2</label>
				<input type="text" id="umpire_name2" name="umpire_name2"> 
				<input class="col-sm-4"
					type="submit" value="Insert">
					<input class="col-sm-4"
						type="submit" value="Update">
				</form>
		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /.content-wrapper -->

	<!-- Scroll to Top Button -->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fa fa-angle-up"></i>
	</a>

	
	<script>
	 function myFunction() {
         alert("Logged out successfully");
     }
</script>

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
