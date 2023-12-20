<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Login</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="resource/css/login.css" ></c:url>">

</head>
<body>
	
    <header><h2>User Login Form</h2></header>
    <form action="goToHome" method="post" autocomplete="nope">

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <br>

        <input type="submit" value="Login">
        <center><a href="goToForgotPasswordPage">ForgotPassword</a></center>
        <center><h1 style="color:red">${loginresponsemessage}</h1></center>
        <center>Do you have an account?<a href="RegisterPage" class="register-btn">Register</a></center>
    </form>
    <footer></footer>
</body>
</html>
