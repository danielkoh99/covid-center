

document.querySelector("#loginForm").addEventListener("submit", function(e){
    e.preventDefault();    //stop form from submitting
    var email = document.getElementById("floatingInput").value;
    var password = document.getElementById("floatingPassword").value;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "api/user/login", true);
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {

            // Response
            var response = this.responseText;
            var cookies =JSON.parse(response);
            console.log(cookies);

            document.cookie = "userID="+cookies.idUser;
            document.cookie = "username="+cookies.name;
            document.cookie = "token="+cookies.token;
            document.cookie = "loginTime="+cookies.loginTime;
            document.cookie = "userType="+cookies.userType.type;
            //forwarding diff users to diff pages depending on their type
            switch(cookies.userType.type){
                case "user": {
                    window.location.replace("/user"); //andrei this path is for u
                    break;
                }
                case "secretary": {
                    window.location.replace("/secretary"); //daniel this path is for u
                    break;
                }
                case "administrator": {
                    window.location.replace("/admin"); //simon and vlad path
                    break;
                }
                default: {
                    break;
                }
            }

        }
    };
    var data={"password":password,"email":email};
    xhttp.send(JSON.stringify(data));

});