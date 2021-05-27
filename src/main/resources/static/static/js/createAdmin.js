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
    //request for creating the new user

    fetch("/api/user?type=1", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    })
        .then(res => {
            form.reset();
            alert("Admin was successfully created");
        })
        .catch(err => console.log(err));
});
