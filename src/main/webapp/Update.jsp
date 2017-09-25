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
<title>Dashboard</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- Plugin CSS -->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/sb-admin.css" rel="stylesheet">
<style>
input[type=text],select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}
</style>
</head>

<body class="fixed-nav" id="page-top">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand" href="#">CRIC INFO</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav navbar-sidenav">
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Dashboard"><a class="nav-link" href="admin.jsp"> <i
						class="fa fa-fw fa-dashboard"></i> <span class="nav-link-text">
							Dashboard</span>
				</a></li>
<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Tables"><a class="nav-link" href="upload.jsp"> <i
						class="fa fa-fw fa-table"></i> <span class="nav-link-text">
							Upload</span>
				</a></li>
				<li class="nav-item active" data-toggle="tooltip"
					data-placement="right" title="Tables"><a class="nav-link"
					href="#"> <i class="fa fa-fw fa-table"></i> <span
						class="nav-link-text"> Insert/Update</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Components"><a class="nav-link" href="Delete.jsp">
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
				<li class="nav-item"><a
					href="index.html" id="logout" onclick="myFunction()">
						<i class="fa fa-fw fa-sign-out"></i> Logout
				</a></li>
			</ul>
		</div>
	</nav>

	<div class="content-wrapper py-3">

		<div class="container-fluid">

			<!-- Breadcrumbs -->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Insert/Update</a></li>
			</ol>

			<!-- Insert
			<form action="AddController" method="post">
				<label for="fname">Season</label> 
				<input type="text" id="season" name="season"> 
				<label for="lname">Venue</label>  
				<input type="text" id="venue" name="venue"> 
				<label for="country">City</label>
				<input type="text" id="city" name="city"> 
				<label for="country">Team_1</label>
				 <input type="text" id="team_name1" name="team_name1"> 
				<label for="country">Team_2</label> 
				<input type="text" id="team_name2" name="team_name2">
				<label for="country">Winner</label> 
				<input type="text" id="winner" name="winner"> 
				<label for="country">Win By Runs</label> 
				<input type="text" id="runs" name="runs"> 
				<label for="country">Win By Wickets</label>
				 <input type="text" id="wickets" name="wickets">
				<label for="country">Umpire_1</label> 
				<input type="text" id="umpire_name1" name="umpire_name1"> 
				 <label for="country">Umpire_2</label>
				<input type="text" id="umpire_name2" name="umpire_name2"> 
				<input class="col-sm-4" type="submit" value="Insert">
				<input class="col-sm-4" type="submit" value="Update">
				</form> -->
				<p style="text-align:center;"><%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%></p>
				<form action="UpdateVenueController" method="post">
				<label for="id">Id</label>  
				<input type="number" id="venueid" name="venueid"> 
				<label for="lname">Venue</label>  
				<input type="text" id="venue" name="venue"> 
				<label for="country">City</label>
				<input type="text" id="city" name="city">
			<input class="col-sm-4" type="submit" value="Update">
		 
				</form>
				<form action="UpdateMatchController" method="post">
				<label for="fname">Season</label> 
				<input type="text" id="season" name="season"> 
				<label for="country">Date</label>
				<input type="text" id="date" name="date">
			<input class="col-sm-4" type="submit" value="Insert">
				</form>
				<form action="UpdateTeamController" method="post">
				<label for="country">Team Name</label>
				 <input type="text" id="team_name" name="team_name"> 
			<input class="col-sm-4" type="submit" value="Update">
				</form>
				
					<form action="">
				<label for="country">Toss Decision</label> 
				<input type="text" id="toss" name="toss"> 
			<input class="col-sm-4" type="submit" value="Update">
				</form>
			
			
				<form  action="UpdateUmpireController" method="post">
				<label for="country">Umpire Name</label> 
				<input type="text" id="umpire_name" name="umpire_name"> 
			<input class="col-sm-4" type="submit" value="Update">
				</form>
				<form action="UpdateOutcomeController" method="post">
				<label for="country">Player of the match </label> 
				<input type="text" id="player" name="player"> 
				<label for="country">Win By Runs</label> 
				<input type="text" id="runs" name="runs"> 
				<label for="country">Win By Wickets</label>
				 <input type="text" id="wickets" name="wickets">
			<input class="col-sm-4" type="submit" value="Update">
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
