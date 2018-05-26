<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="icon" type="image/png" href="images/favicon.ico.png" sizes="32x32">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>STUDENT REGISTRATION FORM</title>

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
.container1 { position:center; width:700px; background: linear-gradient(#660066, #FF66FF);  overflow:hidden;
               padding:2px; gradient; border-radius:15px; border:2px solid #000000;}
.container2 { position:center; width:450px; background: linear-gradient(#ff4d4d,#ffb3b3);  overflow:auto;
               padding:20px; gradient; border-radius:15px; border:2px solid #000000;}
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
<br>
<h1 style="margin-left:450px"><img src="images/library_icon.png" height="70%"> Library Management</h1><br><br><br>
<div class="container2" style="margin-left:400px;">	
	   <h2 style="margin-left:30px">STUDENT REGISTRATION FORM <img src="images/register.png" height="70%"></h2>
		<s:form method="post" name="registerForm" action="registration" onsubmit="return ValidateData()">
			<s:hidden name="studentdata.student_id" />
			<s:hidden name="studentdata.is_approved" />
			<s:textfield name="studentdata.roll" label="Roll" id="Roll"/>
			<s:textfield name="studentdata.name" label="Name" id="Name"/>
			<s:select name="studentdata.branchType1.branch_id"
                         list="#{'0':'SELECT BRANCH','1':'CHEMICAL','2':'CIVIL','3':'C.S.E.','4':'E.C.E','5':'ELECTRICAL','6':'I.T.','7':'MECHANICAL','8':'METALLURGY','9':'MINING','10':'PRODUCTION'}" label="Branch" id="BranchName"/>
			<s:select name="studentdata.batch" list="#{'0':'SELECT BATCH','2012':'2012','2013':'2013','2014':'2014','2015':'2015'}" label="Batch" id="Batch"/>
			<s:password name="studentdata.password" label="Password" id="Password1"/>
	        <s:password label="Confirm Password" id="Password2"/>	
			<s:submit value="REGISTER" align="center"/>
		</s:form>
</div>	<br>
</body>
</html>