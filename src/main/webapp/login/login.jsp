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
    </head>
    <body>
        <form method="post" action="j_security_check">
            Please log in.<br/>
            Username: <input type="text" name="j_username" /><br/>
            Password: <input type="password" name="j_password" /><br/>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
