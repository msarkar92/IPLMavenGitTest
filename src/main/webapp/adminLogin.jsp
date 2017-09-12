<%@page import="java.io.PrintWriter"%>
<%@page import="dto.ResponseDTO"%>
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
	if (userName != null)
		response.sendRedirect("adminHome.jsp");
%>

<!DOCTYPE html>
<html>
<head>
	<title>Admin Login</title>
	<jsp:include page="links.jsp"></jsp:include>
		
	<script src="js/myScript.js"></script>
	<script src="ajax/login.js"></script>
	
	
	<script>
		/*function validate(){
			if(document.getElementById("email").value == "" || document.getElementById("password").value == ""){
				alert("Enter Email and Password");
			}
			else if(document.getElementById("email").value == "msarkar@yahoo.com" && document.getElementById("password").value=="123456" ){
				location.href="adminHome.jsp";
			}
			else{
				alert("Invalid Email or Password");
			}
		}
		*/
	</script>
</head>
	
<body style="background-image:url('background.jpg');">
	<nav class="navbar navbar-inverse transparent-nav">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">SnickInfo</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="#">Contact Us</a></li>
					<li><a href="#">About Us</a></li>					
				</ul>
			</div>
		</div>
	</nav>
	<div class="container" style="height: 800px;">
		<div class="row">
			<div class="col-xs-1 col-sm-2 col-md-3 col-lg-3">
			</div>
			<%
				String userId=request.getSession().getAttribute("userId")==null?"":(String)request.getSession().getAttribute("userId");
				if(userId.equals(""))
					
				//String msg=request.getAttribute("response")==null?"":request.getAttribute("response").toString();
			%>
			<div class="col-xs-10 col-sm-8 col-md-5 col-lg-5 col-centered">
				<div class="panel panel-default">
					<div class="panel-heading">Admin Login
					</div>
					<div class="panel-body">
						<p id="error-msg" align="center"><%//=msg%></p>
						<form action="LoginController" method="post">
							<div class="input-group">
								<span class="input-group-addon">
								<i class="glyphicon glyphicon-user"></i></span> 
								<input id="email" name="email" type="text" class="form-control" 	placeholder="Email"  autofocus>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">
								<i class="glyphicon glyphicon-lock"></i></span> 
								<input id="password" name="password" type="password" class="form-control"  placeholder="Password" >
							</div>
							<br>
							<div class="input-group pull-right">
								<button type="button" id="btn-login-submit" class="btn btn-primary" ><!--onclick="validate()">  onclick="location.href='adminHome.jsp'"> -->
									Login
								</button>
							</div>
						</form>
					</div>
					
				</div>
			</div>
			
			<div class="col-xs-1 col-sm-2 col-md-3 col-lg-3">
			</div>
		</div>
	</div>
	<jsp:include page="adminFooterMenu.jsp"></jsp:include>		
</body>
</html>