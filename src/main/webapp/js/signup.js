function checkPasswordMatch() {
    let password = $("#password").val();
    let confirmPassword = $("#confirmPassword").val();
    console.log(password.length);

    console.log(confirmPassword.length);
    if (password != confirmPassword ) {
        $("#passwordMatchStatus").html("Passwords do not match!");
    } else if (password === confirmPassword && password.length > 0 && confirmPassword.length > 0) {
        $("#passwordMatchStatus").html("Passwords match.");
    } else {
        $("#passwordMatchStatus").html("");

    }

}

$(document).ready(function () {
    $("#confirmPassword").keyup(checkPasswordMatch);
    $("#password").keyup(checkPasswordMatch);
});
