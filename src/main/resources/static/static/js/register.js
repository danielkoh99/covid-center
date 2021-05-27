const form = document.querySelector(".form-horizontal");
form.addEventListener("submit", (e) => {
    e.preventDefault();
    let password = document.querySelector('input[name=password]');
    const confirm = document.querySelector('input[name=password_confirm]');
    if(password.value === ""){
        password.setCustomValidity('Password field can not be empty');
        return;
    }
    if(confirm.value === ""){
        password.setCustomValidity('Confirm password field can not be empty');
        return;
    }
    if (confirm.value !== password.value) {
        confirm.setCustomValidity('Passwords do not match');
        return;
    }
    const cprNumber = document.querySelector('input[name=cpr]').value;
    const firstname = document.querySelector('input[name=firstname]').value;
    const surname = document.querySelector('input[name=surname]').value;
    const email = document.querySelector('input[name=email]').value;
    password = document.querySelector('input[name=password]').value;
    const data = {
        cprNumber,
        name: firstname,
        surname: surname,
        email,
        password
    }
    console.log(data);
    //request for creating the new user

    fetch("/api/user", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    })
        .then(res => {
            const loginData = {
                email,
                password
            }
            fetch("/api/user/login", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(loginData),
            })
                .then(res => res.json())
                .then(cookies => {
                    document.cookie = "userID="+cookies.idUser;
                    document.cookie = "username="+cookies.name;
                    document.cookie = "token="+cookies.token;
                    document.cookie = "loginTime="+cookies.loginTime;
                    document.cookie = "userType="+cookies.userType.type;
                    window.location.replace("/user");
                })
                .catch(err => console.log("we are in the error block"));
        })
        .catch(err => console.log("we are in the error block"));



    // var xhttp = new XMLHttpRequest();
    // xhttp.open("POST", "api/user/login", true);
    // xhttp.onreadystatechange = function() {
    //     if (this.readyState == 4 && this.status == 200) {
    //
    //         // Response
    //         var response = this.responseText;
    //         var cookies =JSON.parse(response);
    //         console.log(cookies);
    //
    //         document.cookie = "userID="+cookies.idUser;
    //         document.cookie = "username="+cookies.name;
    //         document.cookie = "token="+cookies.token;
    //         document.cookie = "loginTime="+cookies.loginTime;
    //         document.cookie = "userType="+cookies.userType.type;
    //         //forwarding diff users to diff pages depending on their type
    //         switch(cookies.userType.type){
    //             case "user": {
    //                 window.location.replace("/user"); //andrei this path is for u
    //                 break;
    //             }
    //             case "secretary": {
    //                 window.location.replace("/secretary"); //daniel this path is for u
    //                 break;
    //             }
    //             case "administrator": {
    //                 window.location.replace("/admin"); //simon and vlad path
    //                 break;
    //             }
    //             default: {
    //                 break;
    //             }
    //         }
    //
    //     }
    // };
    // var loginData={"password":password,"email":email};
    // xhttp.send(JSON.stringify(loginData));
});
