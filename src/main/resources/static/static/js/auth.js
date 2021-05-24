console.log("working");

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
    // your page initialization code here
    // the DOM will be available here
    console.log("docuemnt ready");
    const userid=getCookie("userID");
    console.log(userid)
    if(userid>0){
        //this prevents server from endless loading of the page
        if(window.location.href === "http://localhost:5555/") window.location.replace("/admin");
        else return;
    }else {
        //this prevents server from endless loading of the page
        if(window.location.href === "http://localhost:5555/") return;
        else window.location.replace("/");
    }
})();