<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ViewMember</title>
<link rel="stylesheet" type="text/css" href="<c:url value="resource/css/register.css" ></c:url>">

</head>
<body>
	<header>
	<center>Members</center>
	<center><%String email=(String)session.getAttribute("email");
		out.println(email);%></center>
	</header>
	<center>
		<table border="1" cellpadding="1" style="margin-top:30px">
		<tr>
			<th>MEMBER_ID</th>
			<th>MEMBER_NAME</th>
			<th>MEMBER_GENDER</th>
			<th>MEMBER_DOB</th>
			<th>MEMBER_IDPROOF</th>
			<th>ID_PROOF_NO</th>
			<th>VACCINE_TYPE</th>
			<th>DOSE</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="member" items="${Members}">
			<tr>
				<td>${member.memberId }</td>
				<td>${member.memberName }</td>
				<td>${member.memberGender }</td>
				<td>${member.memberDob }</td>
				<td> ${member.memberIdProof }</td>
				<td> ${member.idProofNo }</td>
				<td> ${member.vaccineType }</td>
				<td> ${member.dose }</td>
				<td><a href="EditMember">Edit</a></td>
				<td><a href="deleteMember">Delete</a></td>
			</tr>		
		</c:forEach>
		</table>
	<center>GoToHomePage <a href="goToHomePage">Home</a></center>
	</center>
	<footer style="margin-top:400px"></footer>
</body>
</html>