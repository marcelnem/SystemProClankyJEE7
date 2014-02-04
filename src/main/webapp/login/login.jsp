<%-- 
    Document   : login
    Created on : Feb 2, 2014, 9:29:58 PM
    Author     : marcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <script src="../resources/js/jquery-1.11.0.min.js"></script>
        <script type="text/javascript">

            function initWebsocket(e) {
                window.name = document.getElementById("j_username").value;
                return true;
            }

            $(document).ready(function() {
                form = document.getElementById('loginForm');
                if (form.attachEvent) {
                    form.attachEvent("submit", initWebsocket);
                } else {
                    form.addEventListener("submit", initWebsocket);
                }



            });
        </script>
    </head>
    <body>
        <form method="post" action="j_security_check" id="loginForm">
            Please log in.<br/>
            Username: <input type="text" name="j_username" id = "j_username"/><br/>
            Password: <input type="password" name="j_password" /><br/>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
