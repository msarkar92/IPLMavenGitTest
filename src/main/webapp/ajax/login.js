$(document).ready(function() {
	/*
	//if user already logged in user should not be able to come to login page
	if(checkCookie("userId")!=""){
		window.location.replace("http://localhost:8018/IPLMaven/adminHome.jsp");
	}
	*/
	$("#btn-login-submit").click(function() {
		var jsonData = {userId:$("#email").val(),password:$("#password").val()};
		$.ajax({
			type:"post",
			cache:false,					
			url : "LoginController",
			data : "data="+JSON.stringify(jsonData),
			success : function(responseText) {						
				var jsonData=jQuery.parseJSON(responseText);
				//alert(responseText);
				if(jsonData.status==false){
					$("#error-msg").html(jsonData.message);
				}
				else{
					//if(setCookie("userId",$("#email").val())==true)
						window.location.replace("http://localhost:8018/IPLMaven/adminHome.jsp");
				}
			},
			error: function(responseText){
				alert(responseText);
			}				
		});
		return false;
	});
});