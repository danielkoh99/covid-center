
function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
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
//check if the users cookie exist in the browser
(function() {
    const userid=getCookie("userID");
    const userType=getCookie("userType");
    if(userid>0){
        switch (userType){
            case "administrator":
                if(window.location.href === "http://localhost:5555/") window.location.replace("/admin");
                break;
            case "secretary":
                if(window.location.href === "http://localhost:5555/") window.location.replace("/secretary");
                break;
            case "user":
                if(window.location.href === "http://localhost:5555/") window.location.replace("/user");
                break;
            default:
                if(window.location.href === "http://localhost:5555/") return;
                else window.location.replace("/");
                break;
        }
    }
    else{
        if(window.location.href === "http://localhost:5555/") return;
        else window.location.replace("/");
    }


})();