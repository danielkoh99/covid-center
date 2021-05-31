(function() {
    const userid=getCookie("userID");
    const userType=getCookie("userType");
    if(userid>0){
        if(userType!=="user"){
            if(window.location.href === "http://localhost:5555/") return;
            else window.location.replace("/");
        }
    }
    else{
        if(window.location.href === "http://localhost:5555/") return;
        else window.location.replace("/");
    }
})();