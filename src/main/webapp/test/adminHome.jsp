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
<html>
<head>
	<title>Admin's Home</title>	
	<jsp:include page="links.jsp"></jsp:include>
	
	<script src="js/myScript.js"></script>
	<script src="ajax/adminHome.js"></script>	 
</head>
<body>
	<jsp:include page="adminHeaderMenu.jsp"></jsp:include>
	<div class="container-fluid" style="margin-top:80px">
	
		<div class="row">
			<jsp:include page="adminSideNav.jsp"></jsp:include>
			
			<div class="col-sm-10">
				<div class="row">
					<div class="col-sm-10">
						<form action="">
							<h4>Search Matches</h4>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Enter Match Name"
									name="search">
								<div class="input-group-btn">
									<button class="btn btn-default" type="submit">
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-sm-10">
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	
</body>
<jsp:include page="adminFooterMenu.jsp"></jsp:include>
</html>