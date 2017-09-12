//will be called form any page to set cookies
function setCookie(key,value){
	if(checkCookieEnabled()==true){
		//$.cookie(key,value, { path: '/', expires: 1 });
		document.cookie = key + "=" + value + ";path=/";
		return true;
	}
	return false;
}

function deleteCookie(key){
	document.cookie = key +"=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;";
	return true;
}

function getCookie(key) {
    var name = key + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

//check whether cookie is there based on the key
function checkCookie(key) {
    var user = getCookie(key);
    if (user != "") {
        return user
    }
    return "";
}

//Check whether Browser cookie is enabled or not
function checkCookieEnabled(){
	
	var status = navigator.cookieEnabled;
	if(status==false){
		alert("Your Browser cookies are disabled, Please enable cookies");
		return false;
	}
	//alert("check cookie enabled");
	return true;
}