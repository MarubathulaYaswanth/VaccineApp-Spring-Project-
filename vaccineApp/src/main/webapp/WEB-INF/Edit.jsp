<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EditPage</title>
<style>
	body {
		font-family: Arial, sans-serif;
		margin: 0;
		padding: 0;
		background-color: #f4f4f4;
		/* Set your desired background color */
		width:100%;
	}
	
	header {
		background-color: #3498db;
		/* Header color */
		color: #fff;
		/* Header text color */
		padding: 10px;
		text-align: center;
		font-size: 10px;
		height:40px;
		width: 100%;
	}
	
	form {
		max-width: 600px;
		margin: 20px auto;
		background-color: #fff;
		padding: 10px;
		border-radius: 5px;
		box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	}
	
	form label {
		display: block;
		margin-bottom: 8px;
		font-weight: bold;
	}
	
	form input {
		width: 97%;
		padding: 10px;
		margin-bottom: 15px;
		border: 1px solid #ccc;
		border-radius: 4px;
	}
	
	form input[type="date"] {
		width: calc(100% - 22px);
		/* Adjust the width for date input */
	}
	
	form input[type="submit"] {
		background-color: #333;
		/* Set your desired submit button background color */
		color: #fff;
		/* Set your desired submit button text color */
		padding: 10px 15px;
		border: none;
		border-radius: 4px;
		cursor: pointer;
	}
	
	.g1 {
		width: 10%;
	}
	
	.g2 {
		width: 16%;
	}
	
	.g3 {
		width: 14.5%;
	}
	
	footer {
		background-color: #3498db;
		/* Footer color */
		color: #fff;
		/* Footer text color */
		text-align: center;
		width: 100%;
		height:30px;
		padding: 10px;
	}
	
	.response {
	    color: #fff;
	    padding: 8px 15px;
	    text-decoration: none;
	    border-radius: 5px;
	}
</style>
</head>
<body>
	<header style="font-size:20px"><b><center>EDIT MEMBER FORM</center></b></header>
	 <div style="">
        <form action="${pageContext.request.contextPath }/Edit" method="post"> 
        
            <label for="memberid">Member Id:</label>
            <input type="number" id="memberid" name="memberid" value="${memberId}" required readonly><br>
            
            <label for="memberName">Member Name:</label>
            <input type="text" id="memberName" name="memberName" value="${memberName}" required><br>

            <label>Gender:</label>
	        Male:<input class="g2" type="radio" id="male" name="membergender" value="${membergender}" required><br>
	        Female:<input class="g1" type="radio" id="female" name="membergender" value="${membergender}" required><br>
	        Other:<input class="g3" type="radio" id="other" name="membergender" value="${membergender}" required><br>

            <label for="memberDOB">Date of Birth:</label>
            <input type="date" id="memberDOB" name="memberDOB" value="${memberDOB }" required><br>

            <label for="memberidProof">Member_ID Proof:</label>
            <select id="memberidProof" name="memberidProof">
            	<option>${memberidProof }</option>
                <option value="aadharCard">Aadhar Card</option>
                <option value="panCard">Pan Card</option>
                <option value="drivingLicense">Driving License</option>
            </select><br><br>
            
            <label for="idProof">ID Proof No:</label>
            <input type="text" id="idproof" name="idProofno" value="${idproof }" required><br>

            <label for="vaccineType">Vaccine Type:</label>
            <select id="vaccineType" name="vaccineType">
            	<option>${vaccineType}</option>
                <option value="covishield">Covishield</option>
                <option value="covaxine">Covaxine</option>
                <option value="sputnik">sputnik</option>
            </select><br><br>

            <label for="dose">Dose:</label>
            <select id="dose" name="dose">
            	<option>${dose }</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
            </select><br><br>
            
            <label for="refEmail">REF_EMAIL:</label>
            <input type="text" id="refemail" name="refemail" value="<% out.print(session.getAttribute("email"));%>" required readonly><br>

            <input type="submit" value="Edit Member">
        </form>
    </div><br><br>
	<center><a href="${pageContext.request.contextPath}/gotoMemberPage" class="member-btn">AddMember</a></center>    
	<h1>${editresponse}</h1>
	<footer></footer>
        
</body>
</html>