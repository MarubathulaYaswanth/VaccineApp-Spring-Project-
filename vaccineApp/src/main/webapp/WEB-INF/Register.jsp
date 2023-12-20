<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="resource/css/register.css" ></c:url>">
    <script src="<c:url value="resource/js/register.js" ></c:url>"></script>
</head>
<body>
    <header><h2>User Registration Form</h2></header>
    <form onsubmit="return validatePassword()" action="saveData" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required><br>
        <span id="cpswd" style="color:red"></span><br><br>

        <label for="mobileNumber">Mobile Number:</label>
        <input type="text" id="mobileNumber" name="mobileNumber" required><br>

        <label>Gender:</label>
        Male:<input class="g2" type="radio" id="male" name="gender" value="male" required><br>
        Female:<input class="g1" type="radio" id="female" name="gender" value="female" required><br>
        Other:<input class="g3" type="radio" id="other" name="gender" value="other" required><br>

        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob" required><br>

        <br>

        <input type="submit" value="Register">
        <center><h2>${responsemessage1}</h2></center>
        <center>If you have an account click on <a href="LoginPage1" class="register-btn">Login</a></center>
    </form>
    <footer></footer>
</body>
</html>
