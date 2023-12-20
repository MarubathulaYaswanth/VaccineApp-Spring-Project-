<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Reset Password</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="resource/css/register.css" ></c:url>">
    <script src="<c:url value="resource/js/register.js" ></c:url>"></script>
</head>
<body>
	<header></header>
	<form onsubmit="return validatePassword()" action="forgotpassword" method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="newpassword">New Password:</label>
        <input type="password" id="newpassword" name="newpassword" required><br>
        
        <label for="confirmnewpassword">Confirm New Password:</label>
        <input type="password" id="confirmnewpassword" name="confirmnewpassword" required><br>
        <span id="cpswd" style="color:red"></span><br><br>
        
        <input type="submit" value="ResetPassword">
        <center><h2>${forgotpasswordrespoonse}</h2></center>
        <center>Go To Index Page--<a href="goToIndexPage">Index</a></center>
        
    </form>
    <footer></footer>
</body>
</html>