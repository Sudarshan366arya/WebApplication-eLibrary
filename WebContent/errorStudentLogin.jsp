<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<html>
<head>
<link rel="icon" type="image/png" href="images/favicon.ico.png" sizes="32x32">
<script type="text/javascript">
function isAlphaNumericKey(i) {
	if ((i.value).length > 0) {
		i.value = i.value.replace(/[^\d\d.\d\w\s\(\)]+/g, "");
		}
	/*var str = i.value;
	i.value = str.toUpperCase()*/
}
function validateAdminForm() {
	   var x = document.forms["adminLoginForm"]["AdminName"].value;
	   if (x == null || x == "") {
	   alert("User name must be filled out");
	   return false;
	}
	   var x = document.forms["adminLoginForm"]["Password"].value;
	   if (x == null || x == "") {
	   alert("Password name must be filled out");
	   return false;
	}
}
function validateStudentForm() {
	   var x = document.forms["studentLoginForm"]["Roll"].value;
	   if (x == null || x == "" ||x<=1200000||x>=1699999) {
	   alert("Valid Roll must be filled out");
	   return false;
	}
	   var x = document.forms["studentLoginForm"]["Password"].value;
	   if (x == null || x == ""||x==0) {
	   alert("Password must be filled out");
	   return false;
	}
	}
</script>
<title>Welcome To eLibrary</title>
<style type="text/css"> 
  body {
  background: #CCFF33 url("images/library.jpg") no-repeat;
  height:auto;
  background-size:cover;
  }
  .container { position:center; width:450px; background: linear-gradient(#660066, #FF66FF);  overflow:auto;
               padding:2px;gradient; border-radius:15px; border:2px solid #000000;opacity:0.95;}
  form {  margin:20; auto; }
                
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
  
h2 {
	background-color:#ed8223;
	color:#000000;
	font-family:'Helvetica Neue',sans-serif;
	font-size:25px;
	line-height:30px;
	border-radius:20px;
	-webkit-border-radius:20px;
	-moz-border-radius:20px;
	border:0;
	text-shadow:#C17C3A 0 -1px 0;
	text-align:center;
	width:450px;
	height:35px;
}  
h3{
   color:#800000;
   font-family: 'Helvetica Neue',sans-serif;
   font-size:15px;
   text-align:center;
}
input[type=text] {
    padding:6px; 
    border:3px solid #CCFF33; 
    -webkit-border-radius: 15px;
    border-radius: 7px;
    width:250px;
    background:#ffffff;
}
input[type=text]:focus {
    border-color:#CCFF33;
}
input[type=password]{
    padding:6px; 
    border:3px solid #CCFF33; 
    -webkit-border-radius: 15px;
    border-radius: 7px;
    width:250px;
    background:#ffffff;
}
input[type=submit] {
    padding:4px 12px; 
    background:#ccc; 
    font-family:'Helvetica Neue',sans-serif;
    font-size:15px;
    border:1px solid #CCFF33; 
    cursor:pointer;
    -webkit-border-radius: 5px;
    border-radius:10px; 
}
label{
   font-size:20px;
   font-family:'Helvetica Neue',sans-serif;
   color:#000000;
}
input[type=placeholder]{
  color: #CCFF33;
  }
    .circle1 {
    border-radius: 10px;
    width: 30%;
    height: 4%; 
    background:#008000;
    display:inline-block;
    line-height:20px;
    vertical-align:center;
    text-align:center;
    color:#ffffff;
}
a{
  font-size:15px;
  font-family:'Helvetica Neue',sans-serif;
  color:#66ff66;
  text-align:center;
  }
</style>
</head>
<body>
	<h1 style="margin-left:450px"><img src="images/library_icon.png" height="70%"> Library Management</h1>
	
    <div class="container" style="margin-left:100px;">
     <h2>ADMIN LOGIN <img src="images/admin_login.png" height="80%"></h2>
		<s:form method="post" name="adminLoginForm" action="adminLogin" onsubmit="return validateAdminForm()">
			<s:hidden name="admindata.admin_id" key="id" />
			<s:textfield name="admindata.admin_user_name" label="User Name" placeholder="User Name" onkeyup="isAlphaNumericKey(this);" id="AdminName" />
			<s:password name="admindata.admin_password" label="Password" placeholder="Password" id="Password"/>
            <s:submit value="LOGIN" align="center" />
		</s:form>
	   </div> <br></br>
    
    <div class="container" style="margin-left:300px;">
    <h2>STUDENT LOGIN <img src="images/studentlogin.png" height="80%"></h2>
    <h3>INCORRECT ROLL NO. / PASSWORD !!<img src="images/wrong_login.png" height="4%"></h3>
		<s:form method="post" name="studentLoginForm" action="studentLogin" onsubmit="return validateStudentForm()">
			<s:hidden name="studentdata.student_id" key="student_id" />
			<s:textfield name="studentdata.roll"  label="Roll"  placeholder="Enter Roll" onkeyup="isAlphaNumericKey(this);" id="Roll" min="1200000" max="1699999"/>
			<s:password name="studentdata.password" label="Password"  placeholder="Password" id="Password"/>
			<s:submit value="LOGIN" align="center" />
		</s:form>
		
	</div>
		<br></br>
		
   <div class="container" style="margin-left:500px;">
		<h2>Not Registered Yet !!! <img src="images/warning.png" height="60%"> </h2>
		<a style="margin-left:150px" href="registerRequest" class="circle1">REGISTER</a>
   </div>
</body>
</html>