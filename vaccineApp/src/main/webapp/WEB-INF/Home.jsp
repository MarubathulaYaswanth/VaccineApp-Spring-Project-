<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<!-- ... rest of your code ... -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="expires" content="0">
<meta http-equiv="pragma" content="no-cache">
<title>HomePage</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="resource/css/home.css" ></c:url>">
<style>
.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	width: 20%;
	display: inline-block; /* Set display to inline-block */
	margin: 10px; /* Add some margin for spacing */
	margin-left: 60px;
}

.card:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.container {
	padding: 2px 16px;
}
</style>
</head>
<body>
	<header>
		<h2 style="margin-left: 800px">
			<%
			String userEmail = (String) (session.getAttribute("email"));
			out.println(userEmail);
			%>
		</h2>
		<script>
		function go() {
			window.location
					.replace(
							"http://localhost:8083/vaccineApp/LoginPage",
							'window',
							'toolbar=1,location=1,directories=1,status=1,menubar=1,scrollbars=1,resizable=1');
			self.close()
		}
		</script>
		<%
		String userEmailParam = request.getParameter("email");
		if (userEmailParam != null && !userEmailParam.isEmpty()) {
			session.setAttribute("email", userEmailParam);
		}
		%>
		<%
		if (session.getAttribute("email").equals("")) {
		%>
		<a href="login.jsp"><b>Login </b></a>
		<%
		} else {
		%>
		<a href="javascript:go()" class="register-btn"><b>Logout</b></a>
		<%
		}
		%>
		<a href="gotoMemberPage" class="member-btn">AddMember</a>
	</header>
	<center>
		<h1>HomePage</h1>
	</center>
	<div style="text-align:center;">
		<div class="card" style="text-align:center;">
		<img
			src="https://www.paidmembershipspro.com/wp-content/uploads/2014/01/Roles-for-members.png"
			alt="Avatar" style="width: 40%">
		<div class="container">
			<h4>
				<b>Member-Count</b>
			</h4>
			<p>
				<%
				int membercount = (int) session.getAttribute("membercount");
				out.println(membercount);
				%>
			</p>
		</div>
	</div>
	<div class="card" style="text-align:center;">
		<img
			src="https://www.paidmembershipspro.com/wp-content/uploads/2014/01/Roles-for-members.png"
			alt="Avatar" style="width: 40%">
		<div class="container">
			<h4>
				<b>John Doe</b>
			</h4>
			<p>Architect & Engineer</p>
		</div>
	</div>
	<div class="card" style="text-align:center;">
		<img
			src="https://www.paidmembershipspro.com/wp-content/uploads/2014/01/Roles-for-members.png"
			alt="Avatar" style="width: 40%">
		<div class="container">
			<h4>
				<b>John Doe</b>
			</h4>
			<p>Architect & Engineer</p>
		</div>
	</div>
	</div>
	<footer style="margin-top:120px;"></footer>
</body>
</html>
