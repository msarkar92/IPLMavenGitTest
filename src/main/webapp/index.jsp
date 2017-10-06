<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SnickInfo</title>
<jsp:include page="links.jsp"></jsp:include>

<style>
/* Note: Try to remove the following lines to see the effect of CSS positioning */
.affix {
	top: 0;
	width: 100%;
	z-index: 10;
}

.affix+.container-fluid {
	padding-top: 70px;
}
</style>
</head>
<body>
	<div class="background-image-div container-fluid"
		style="background-image: url('images/banner/banner.jpg');"></div>

	<nav class="navbar navbar-inverse" data-spy="affix"
		data-offset-top="200">
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Basic Topnav</a></li>
			<li><a href="#">Page 1</a></li>
			<li><a href="#">Page 2</a></li>
			<li><a href="#">Page 3</a></li>
		</ul>
	</nav>

	<div class="container-fluid">
		<div id="filter-criteria">
			<table>
				<tr>
					<td>
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">
								By Team <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#">Challengers</a></li>
								<li><a href="#">Daredevils</a></li>
								<li><a href="#">Gujarat Lions</a></li>
								<li><a href="#">Kings XI</a></li>
								<li><a href="#">Knight Riders</a></li>
								<li><a href="#">Mumbai</a></li>
								<li><a href="#">Sunrisers</a></li>
								<li><a href="#">Supergiant</a></li>
							</ul>
						</div>
					</td>
					<td>
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">
								By Year <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#">2017</a></li>
								<li><a href="#">2016</a></li>
								<li><a href="#">2015</a></li>
								<li><a href="#">2014</a></li>
							</ul>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<hr>
		<h3>Matches of 2017</h3>
		<div id="short-match-list">

			<div class="row match-short-detail shadow-depth">

				<div class="col-md-2">
					<h5 id="match-time">March 21 2017, 08:00 PM</h5>
					<h5>Eden Gardens, Kolkata</h5>
				</div>
				<div class="col-md-4">

					<div class="media">
						<div class="media-left">
							<img src="images/csk.jpg" class="media-object"
								style="width: 30px">
						</div>
						<div class="media-body"
							style="margin-top: auto; margin-bottom: auto; height: 20px;">
							<h4 class="media-heading">
								Chennai Super Kings <small><i>Runs</i></small>
							</h4>
						</div>
					</div>

					<div class="media">
						<div class="media-left">
							<img src="images/kkr.jpg" class="media-object"
								style="width: 30px">
						</div>
						<div class="media-body"
							style="margin-top: auto; margin-bottom: auto; height: 20px;">
							<h4 class="media-heading">
								Kolkata Knight Riders <small><i>Runs</i></small>
							</h4>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<h3 class="h3-winning-status">Kolkata Knight Riders Won By 2
						Runs</h3>
					<button type="button" class="btn btn-default">Detail
						Report</button>
				</div>
			</div>
			<!-- End of  match details 1 -->
			<!-- 
			<div class="row match-short-detail shadow-depth">

				<div class="col-md-2">
					<h5 id="match-time">March 21 2017, 08:00 PM</h5>
					<h5>Eden Gardens, Kolkata</h5>
				</div>
				<div class="col-md-4">

					<div class="media">
						<div class="media-left">
							<img src="images/csk.jpg" class="media-object"
								style="width: 30px">
						</div>
						<div class="media-body"
							style="margin-top: auto; margin-bottom: auto; height: 20px;">
							<h4 class="media-heading">
								Chennai Super Kings <small><i>Runs</i></small>
							</h4>
						</div>
					</div>

					<div class="media">
						<div class="media-left">
							<img src="images/kkr.jpg" class="media-object"
								style="width: 30px">
						</div>
						<div class="media-body"
							style="margin-top: auto; margin-bottom: auto; height: 20px;">
							<h4 class="media-heading">
								Kolkata Knight Riders <small><i>Runs</i></small>
							</h4>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<h3 class="h3-winning-status">Kolkata Knight Riders Won By 2
						Runs</h3>
					<button type="button" class="btn btn-default">Detail
						Report</button>
				</div>
			</div>
			 -->
			<!-- End of  match details 2 -->
			<!-- 
			<div class="row match-short-detail shadow-depth">

				<div class="col-md-2">
					<h5 id="match-time">March 21 2017, 08:00 PM</h5>
					<h5>Eden Gardens, Kolkata</h5>
				</div>
				<div class="col-md-4">

					<div class="media">
						<div class="media-left">
							<img src="images/csk.jpg" class="media-object"
								style="width: 30px">
						</div>
						<div class="media-body"
							style="margin-top: auto; margin-bottom: auto; height: 20px;">
							<h4 class="media-heading">
								Chennai Super Kings <small><i>Runs</i></small>
							</h4>
						</div>
					</div>

					<div class="media">
						<div class="media-left">
							<img src="images/kkr.jpg" class="media-object"
								style="width: 30px">
						</div>
						<div class="media-body"
							style="margin-top: auto; margin-bottom: auto; height: 20px;">
							<h4 class="media-heading">
								Kolkata Knight Riders <small><i>Runs</i></small>
							</h4>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<h3 class="h3-winning-status">Kolkata Knight Riders Won By 2
						Runs</h3>
					<button type="button" class="btn btn-default">Detail
						Report</button>
				</div>
			</div>
			 -->
			<!-- End of  match details 3 -->

			<!-- 
			<div class="row match-short-detail shadow-depth">

				<div class="col-md-2">
					<h5 id="match-time">March 21 2017, 08:00 PM</h5>
					<h5>Eden Gardens, Kolkata</h5>
				</div>
				<div class="col-md-4">

					<div class="media">
						<div class="media-left">
							<img src="images/csk.jpg" class="media-object"
								style="width: 30px">
						</div>
						<div class="media-body"
							style="margin-top: auto; margin-bottom: auto; height: 20px;">
							<h4 class="media-heading">
								Chennai Super Kings <small><i>Runs</i></small>
							</h4>
						</div>
					</div>

					<div class="media">
						<div class="media-left">
							<img src="images/kkr.jpg" class="media-object"
								style="width: 30px">
						</div>
						<div class="media-body"
							style="margin-top: auto; margin-bottom: auto; height: 20px;">
							<h4 class="media-heading">
								Kolkata Knight Riders <small><i>Runs</i></small>
							</h4>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<h3 class="h3-winning-status">Kolkata Knight Riders Won By 2
						Runs</h3>
					<button type="button" class="btn btn-default">Detail
						Report</button>
				</div>
			</div>
			 -->
			<!-- End of  match details 4 -->
		</div>

	</div>
	<jsp:include page="userFooter.jsp"></jsp:include>	
</body>
</html>