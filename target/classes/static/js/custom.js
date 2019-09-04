/**
 * Login
 */
function login() {
    // TODO: complete the login function
    user = document.getElementById('username').value
    location.replace('/index?username=' + user)
}

/**
 * Enter to login.
 */
document.onkeydown = function (event) {
    var e = event || window.event || arguments.callee.caller.arguments[0];
    e.keyCode === 13 && login();
};


