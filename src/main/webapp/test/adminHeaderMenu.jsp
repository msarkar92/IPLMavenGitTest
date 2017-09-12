<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<nav class="navbar navbar-inverse navbar-fixed-top">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>                        
	      </button>
	      <a class="navbar-brand" href="adminHome.jsp">Admin Home</a>
	    </div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="adminHome.jsp">Home</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Link 1</a></li>
				<li><a href="#">Link 2</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<!-- <li><a href="#"><span class="glyphicon glyphicon-user"></span></a></li>  -->
				<li><a href="adminLogin.jsp"><span
						class="glyphicon glyphicon-log-in"></span> Logout
						</a>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">
					Notifications <span class="label label-danger">New</span>
					</a>
					<ul class="dropdown-menu notify-drop">
						<div class="notify-drop-title">
							<div class="row">
								<div class="col-md-6">
									<h6>Notification <span class="label label-danger">New</span></h6>
								</div>
								<div class="col-md-6 text-right">
									<a href="" class="rIcon allRead" data-tooltip="tooltip"
										data-placement="bottom" title="tümü okundu."><i
										class="fa fa-dot-circle-o"></i></a>
								</div>
							</div>
						</div>
						<!-- end notify title -->
						<!-- notify content -->
						<div class="drop-content">
							<li>
								No Notification								
							</li>
						</div>
					</ul>
				<li>
					<a href="">
						<span class="glyphicon glyphicon-user"></span>
						Admin Name
					</a>
				</li>
				<li></li>

				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span>
					</a>
			        <ul class="dropdown-menu">
			          <li><a href="#">Page 1-1</a></li>
			          <li><a href="#">Page 1-2</a></li>
			          <li><a href="#">Page 1-3</a></li>
			        </ul>
			        </li>
				</ul>
			</div>
	</div>
</nav>