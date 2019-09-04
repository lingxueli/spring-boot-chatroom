/**
 * Login
 */
function login() {
    // TODO: complete the login function
    user = document.getElementById('username').value
    console.log(user)
    //location.replace('/index?username)
}

/**
 * Enter to login.
 */
document.onkeydown = function (event) {
    var e = event || window.event || arguments.callee.caller.arguments[0];
    e.keyCode === 13 && login();
};


