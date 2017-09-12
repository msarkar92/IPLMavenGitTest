<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>

<jsp:include page="links_1.jsp"></jsp:include>
<script src="js/myScript.js"></script>
<script src="ajax/adminHome.js"></script>

</head>
<nav class="navbar navbar-default navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">CRIC INFO</a>

		</div>

		<div id="navbar" class="navbar-collapse collapse">

			<ul class="nav navbar-nav navbar-right">


				<li><a href="adminHome.jsp">Home</a></li>

			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>

	<p style="text-align:center;">
		<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>
	</p>
  
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="well well-sm">
				<form class="form-horizontal" action="ResetController" method="post">
					<fieldset>
						<legend class="text-center">Reset Password</legend>

						<div class="form-group">
					 <label for="inputPassword"
					class="col-md-3 control-label">Old Password</label><div class="col-md-9"> <input type="password"
					id="inputPassword" name="oldpass"  class="form-control" placeholder="Password"
					></div>
			</div>
						

						<div class="form-group">
					 <label for="inputPassword"
					class="col-md-3 control-label">New Password</label><div class="col-md-9"> <input type="password"
					id="inputPassword" name="newpass"  class="form-control" placeholder="Password"
					></div>
			</div>
						
<div class="form-group">
					 <label for="inputPassword"
					class="col-md-3 control-label">Confirm Password</label><div class="col-md-9"> <input type="password"
					id="inputPassword" name="confirmpass"  class="form-control" placeholder="Password"
					></div>
			</div>
						
						

						<!-- Form actions -->
						<div class="form-group">
							<div class="col-md-12 text-right">
								<button type="submit"
								class="btn btn-primary btn-lg">Submit</button>

							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>

</body>
</html>