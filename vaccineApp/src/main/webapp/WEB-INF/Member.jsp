<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!-- ... rest of your code ... -->

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Member Registration Form</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="resource/css/register.css" ></c:url>">
</head>
<body>
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
    <div>
        <header>
        <center><a href="getAllMembers" style="margin-right:800px;padding:5px 5px;text-decoration:none;background-color: #4CAF50;color: #fff;border-radius:5px">View Members</a><h1>ADD MEMBER FORM</h1></center>
        </header>
    </div>
    <div>
        <form action="addmemberPage" method="post"> 

            <label for="memberName">Member Name:</label>
            <input type="text" id="memberName" name="memberName" required><br>

            <label>Gender:</label>
	        Male:<input class="g2" type="radio" id="male" name="membergender" value="male" required><br>
	        Female:<input class="g1" type="radio" id="female" name="membergender" value="female" required><br>
	        Other:<input class="g3" type="radio" id="other" name="membergender" value="other" required><br>

            <label for="memberDOB">Date of Birth:</label>
            <input type="date" id="memberDOB" name="memberDOB" required><br>

            <label for="memberidProof">Member_ID Proof:</label>
            <select id="memberidProof" name="memberidProof">
            	<option value="select">select</option>
                <option value="aadharCard">Aadhar Card</option>
                <option value="panCard">Pan Card</option>
                <option value="drivingLicense">Driving License</option>
            </select><br><br>
            
            <label for="idProof">ID Proof No:</label>
            <input type="text" id="idproof" name="idProofno" required><br>

            <label for="vaccineType">Vaccine Type:</label>
            <select id="vaccineType" name="vaccineType">
            	<option value="select">select</option>
                <option value="covishield">Covishield</option>
                <option value="covaxine">Covaxine</option>
                <option value="sputnik">sputnik</option>
            </select><br><br>

            <label for="dose">Dose:</label>
            <select id="dose" name="dose">
            	<option value="select">select</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
            </select><br><br>
            
            <label for="refEmail">REF_EMAIL:</label>
            <input type="text" id="refemail" name="refemail" value="${refEmail}" required><br>
            

            <input type="submit" value="Add Member">
            <center><h2>${memberresponse}</h2></center>
            <center><h2>${deleteresponse}</h2></center>
        </form>
    </div>
    <div>
    	<center>
		<table border="1" width="900px">
	    <tr style="background-color:#f2f2f2;">
	        <th>MEMBER_ID</th>
	        <th>NAME</th>
	        <th>GENDER</th>
	        <th>DOB</th>
	        <th>IDPROOF</th>
	        <th>ID_PROOF_NO</th>
	        <th>VACCINE_TYPE</th>
	        <th>DOSE</th>
	        <th>Edit</th>
	        <th>Delete</th>
	    </tr>
	    <c:forEach var="member" items="${Members}">
	        <tr>
	            <td>${member.memberId}</td>
	            <td>${member.memberName}</td>
	            <td>${member.memberGender}</td>
	            <td>${member.memberDob}</td>
	            <td>${member.memberIdProof}</td>
	            <td>${member.idProofNo}</td>
	            <td>${member.vaccineType}</td>
	            <td>${member.dose}</td>
	            <td><a href="EditMember/${member.memberId}">Edit</a></td>
	            <td><a href="${pageContext.request.contextPath}/DeleteMember/${member.memberId}">Delete</a></td>
	        </tr>
	    </c:forEach>
		</table>

	</center>
    </div>
    <div>
        <footer></footer>
    </div>
</body>
</html>
