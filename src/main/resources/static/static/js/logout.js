var username = document.getElementById("userNamePlaceholder");
username.textContent=getCookie("username");

document.getElementById("logoutButton").addEventListener("click", ()=>{
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "api/user/logout", true);
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {

            // Response
            document.cookie = "userID=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
            document.cookie = "userType=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
            document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
            document.cookie = "token=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
            document.cookie = "loginTime=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
            window.location.replace("/");
        }
    };
    var data={"idUser":getCookie("userID")};
    xhttp.send(JSON.stringify(data));
});