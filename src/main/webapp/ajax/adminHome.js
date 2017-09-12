$(document).ready(function() {
	/*
	//if user has not logged in then user should not be able to come to Home page
	if(checkCookie("userId")==""){
		window.location.replace("http://localhost:8018/IPLMaven/adminLogin.jsp");
	}
	*/	
	$("#btn-logout").click(function() {
		//alert();
		if(deleteCookie("userId")==true)
			window.location.replace("http://localhost:8018/IPLMaven/adminLogin.jsp");
	});
});