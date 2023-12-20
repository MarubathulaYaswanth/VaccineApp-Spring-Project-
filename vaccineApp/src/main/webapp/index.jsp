<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IndexPage</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="resource/css/index.css" ></c:url>">
</head>

<body>
    <div class="container">
        <header class="header">
            <div class="logo">
                <center><h3>VACCINE APP</h3></center>
            </div>
            <div class="header-buttons">
                <a href="RegisterPage" class="register-button">Register</a>
                <a href="LoginPage" class="login-button">Login</a>
            </div>
        </header>
        
        <div style="margin-top:20px">
        	<img src="https://www.mpikg.mpg.de/192615/teaser-1372934746.jpg" width="50%" heigth="90%"><img src="https://www.mpikg.mpg.de/192615/teaser-1372934746.jpg" width="50%" heigth="50%">
        </div>

        <footer class="footer"></footer>
    </div>
</body>
</html>
