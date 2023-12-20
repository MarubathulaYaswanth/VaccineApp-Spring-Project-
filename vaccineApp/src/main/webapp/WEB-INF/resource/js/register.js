function validatePassword() {
	var pwd1 = document.getElementById("password").value;
	var pwd2 = document.getElementById("confirmPassword").value;
	var newpwd = document.getElementById("newpassword").value;
	var cnewpwd = document.getElementById("confirmnewpassword").value;
	if (pwd1 != pwd2) {
		document.getElementById("cpswd").innerHTML = "passwords are not matched";
		return false;
	}
	if(newpwd != cnewpwd){
		document.getElementById("cpswd").innerHTML = "passwords are not matched";
		return false;
		
	}
	
}