<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="icon" type="image/png" href="images/favicon.ico.png" sizes="32x32">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REGISTRATION DONE</title>
<script type="text/javascript">
 function ValidateData(){
	 var x = document.forms["registerForm"]["Roll"].value;
	   if (x == null || x == "" ||x<=1200000||x>=1699999) {
	   alert("Valid Roll must be filled out");
	   return false;
	} 
   var x = document.forms["registerForm"]["Name"].value;
    if (x == null || x == "") {
		alert("Name must be filled out");
		return false;
    }
    var x = document.forms["registerForm"]["BranchName"].value;
    if (x == null || x == ""||x=="0") {
    alert("Branch must be selected out");
    return false;
 }
    var x = document.forms["registerForm"]["Batch"].value;
    if (x == null || x == ""||x=="0") {
    alert("Batch must be selected out");
    return false;
 }
	var x = document.forms["registerForm"]["Password1"].value;
	   if (x == null || x == "") {
	   alert("Password must be filled out");
	   return false;
	} 
   var y = document.forms["registerForm"]["Password1"].value; 
   var z= document.forms["registerForm"]["Password2"].value;
	 if(y!=z){
		 alert("Password Combination must be same");
		 return false;
	 }
 }
</script>
<style type="text/css">
body {
  background: #CCFF33 url("images/library1.jpg") no-repeat;
  height:auto;
  background-size:cover;
  }
.container1 { position:center; width:450px; background: linear-gradient(#660066, #FF66FF);  overflow:hidden;
               padding:2px; gradient; border-radius:15px; border:2px solid #000000;opacity:0.95;}
.container2 { position:center; width:700px; background: linear-gradient(#ff4d4d,#ffb3b3);  overflow:auto;
               padding:20px; gradient; border-radius:15px; border:2px solid #000000;opacity:0.95;}
    h1 {
	-webkit-box-shadow:rgba(0,0,0,0.2) 0 1px 0 0;
	-moz-box-shadow:rgba(0,0,0,0.2) 0 1px 0 0;
	box-shadow:rgba(0,0,0,0.2) 0 1px 0 0;
	border-bottom-color:#333;
	border:2px solid #000000;
	background-color:#7cceee;
	border-radius:25px;
	-moz-border-radius:25px;
	-webkit-border-radius:25px;
	color:#333;
	font-family: 'Comic Sans MS', cursive, sans-serif;
	font-size:25px;
	text-shadow:#b2e2f5 0 1px 0;
	text-align:center;
	padding:10px;
	width:400px;
	height:35px;
}

h2{
-webkit-box-shadow:rgba(0,0,0,0.2) 0 1px 0 0;
	-moz-box-shadow:rgba(0,0,0,0.2) 0 1px 0 0;
	box-shadow:rgba(0,0,0,0.2) 0 1px 0 0;
	border-bottom-color:#333;
	border:1px solid #000000;
	background-color:#ed8223;
	color:#4d0018;
	font-family:'Helvetica Neue',sans-serif;
	font-size:20px;
	line-height:30px;
	border-radius:10px;
   -webkit-border-radius:20px;
	-moz-border-radius:20px;
	text-shadow:#C17C3A 0 -1px 0;
	text-align:center;
	padding:2px;
	width:400px;
	height:30px;
}
  h3{
    -webkit-box-shadow:rgba(0,0,0,0.2) 0 1px 0 0;
	-moz-box-shadow:rgba(0,0,0,0.2) 0 1px 0 0;
	box-shadow:rgba(0,0,0,0.2) 0 1px 0 0;
	border-bottom-color:#333;
	border:2px solid #000000;
	background-color:#ff66a3;
	border-radius:25px;
	-moz-border-radius:25px;
	-webkit-border-radius:25px;
	color:#000000;
	font-family: 'Helvetica Neue',sans-serif;
	font-size:20px;
	text-shadow:#b2e2f5 0 1px 0;
	text-align:center;
	padding:3px;
	width:500px;
	height:25px;
}
input[type=text] {
    padding:4px; 
    border:3px solid #CCFF33; 
    -webkit-border-radius: 15px;
    border-radius: 7px;
    width:250px;
    background:#ffffff;
    align:center;
}
select{
    padding:4px; 
    border:3px solid #CCFF33; 
    -webkit-border-radius: 15px;
    border-radius: 7px;
    width:250px;
    background:#ffffff;
    text-align:center;
}
input[type=text]:focus {
    border-color:#CCFF33;
}
label{
   font-size:20px;
   font-family:'Helvetica Neue',sans-serif;
   color:#000000;
}
input[type=password] {
   padding:6px; 
    border:3px solid #CCFF33; 
    -webkit-border-radius: 15px;
    border-radius: 7px;
    width:250px;
    background:#ffffff; 
}
input[type=submit] {
    padding:3px 12px; 
    background:#ccc; 
    font-family:'Helvetica Neue',sans-serif;
    font-size:15px;
    border:2px solid #CCFF33; 
    cursor:pointer;
    -webkit-border-radius: 5px;
    border-radius:10px; 
}
.registerForm{
text-align:center;}
</style>
</head>
<body>
<h1 style="margin-left:450px"><img src="images/library_icon.png" height="70%"> Library Management</h1>

<div class="container2" style="margin-left:300px;">
<h3 style="margin-left:100px;">Regestration Request Taken Successfully <img src="images/register.png" height="80%"></h3>
<h3 style="margin-left:100px;">Please Login After The Approval Process</h3>
</div><br></br>
    <div class="container1" style="margin-left:300px;">
    <h2>STUDENT LOGIN <img src="images/studentlogin.png" height="80%"></h2>
		<s:form method="post" name="studentLoginForm" action="studentLogin" onsubmit="return validateStudentForm()">
			<s:hidden name="studentdata.student_id" key="student_id" />
			<s:textfield name="studentdata.roll"  label="Roll"  placeholder="Enter Roll" onkeyup="isAlphaNumericKey(this);" id="Roll"/>
			<s:password name="studentdata.password" label="Password"  placeholder="Password" id="Password"/>
			<s:submit value="LOGIN" align="center" />
		</s:form>
	</div>
	<br></br>
	<div class="container1" style="margin-left:100px;">
    <h2>ADMIN LOGIN <img src="images/admin_login.png" height="80%"></h2>
		<s:form method="post" name="adminLoginForm" action="adminLogin" onsubmit="return validateAdminForm()">
			<s:hidden name="admindata.admin_id" key="id" />
			<s:textfield name="admindata.admin_user_name" label="User Name" placeholder="User Name" onkeyup="isAlphaNumericKey(this);" id="AdminName" />
			<s:password name="admindata.admin_password" label="Password" placeholder="Password" id="Password"/>
            <s:submit value="LOGIN" align="center" />
		</s:form>
	   </div>
</body>
</html>