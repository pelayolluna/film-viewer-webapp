<%-- 
    Document   : login
    Created on : 18-may-2016, 15:55:06
    Author     : 71677012L
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="Login" method="POST">
            User: <input type="text" name="usuario" />
            Password: <input type="password" name="password" />
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
