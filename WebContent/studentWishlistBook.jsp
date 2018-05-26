<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="icon" type="image/png" href="images/favicon.ico.png" sizes="32x32">
<link rel="stylesheet" href="css/table.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Wishlisted Books</title>
<script type="text/javascript"> 
function validateForm() {
   var x = document.forms["wishListForm"]["BookName"].value;
   if (x == null || x == "") {
   alert("Book name must be filled out");
   return false;
}
   var x = document.forms["wishListForm"]["Author"].value;
   if (x == null || x == "") {
   alert("Author name must be filled out");
   return false;
}
   var x = document.forms["wishListForm"]["Publisher"].value;
   if (x == null || x == "") {
   alert("Publisher name must be filled out");
   return false;
}
   var x = document.forms["wishListForm"]["Semester"].value;
   if (x == null || x == ""||x=="0") {
   alert("Semester must be selected out");
   return false;
}
   var x = document.forms["wishListForm"]["BranchName"].value;
   if (x == null || x == ""||x=="0") {
   alert("Branch name must be filled out");
   return false;
}
}
</script>
<style type="text/css">
body {
  background: #CCFF33 url("images/library.jpg") no-repeat;
  height:auto;
  background-size:cover;
  }
.container1 { position:center; width:700px; background: linear-gradient(#660066, #FF66FF);  overflow:hidden;
               padding:3px; gradient; border-radius:15px; border:3px solid #000000;}
.container2 { position:center; width:800px; background: linear-gradient(#ff4d4d,#ffb3b3);  overflow:auto;
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
h2 {
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
	width:600px;
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
	width:700px;
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
    align:center;
}
input[type=text]:focus {
    border-color:#CCFF33;
}
label{
   font-size:20px;
   font-family:'Helvetica Neue',sans-serif;
   color:#000000;
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
a{
  font-size:15px;
  font-family:'Helvetica Neue',sans-serif;
  text-align:center;
}
.circle2 {
    border-radius: 10px;
    width: 90%;
    height: 100%; 
    background:#b30000;
    display:inline-block;
    line-height:20px;
    vertical-align:center;
    text-align:center;
    color:#ffffff;
}
.circle3 {
    border-radius: 10px;
    width: 10%;
    height: 70%; 
    background:#4d0018;
    display:inline-block;
    line-height:20px;
    vertical-align:center;
    text-align:center;
    color:#ffffff;
}
</style>
</head>
<body>
<h1 style="margin-left:450px"><img src="images/library_icon.png" height="70%"> Library Management</h1>
<% session=request.getSession(false) ; 
    if(session.getAttribute("student_user")!=null){
%>
    <h3 style="margin-left:300px">WELCOME ${sessionScope.student_user} ! <a style="width:10%;height:90%" class="circle2" href="studentLogout"> Logout</a></h3>
<div class="container2" style="margin-left:250px;">
<h2 style="margin-left:100px">4. Place Your Unavailable Book Request :</h2>
  <div id="fromLayout" align="center">
    <s:form  method="post" id="wishListForm" name="wishListForm" action="addBookToWishlist" onsubmit="return validateForm()">
      <s:hidden name="studentWishlist.requested_by_id_foreign"  value="%{student_id}" />
      <s:hidden name="student_id"  value="%{student_id}" />
      <s:textfield name="studentWishlist.wishlisted_book" id="BookName" label="Book Name"/>
      <s:textfield name="studentWishlist.wishlistedbook_author" id="Author"   label="Author Name" />
      <s:textfield name="studentWishlist.wishlisted_book_publisher"  id="Publisher" label="Book Publisher" />    
	  <s:select name="studentWishlist.semester" list="#{'0':'SELECT SEMESTER','1':'FIRST (1st)','2':'SECOND (2nd)','3':'THIRD (3rd)','4':'FOURTH (4th)','5':'FIFTH (5th)','6':'SIXTH (6th)','7':'SEVENTH (7th)','8':'EIGHTH (8th)'}" id="Semester" label="Book Semester" />
      <s:select name="studentWishlist.branch_type_foreign" list="#{'0':'SELECT BRANCH','1':'CHEMICAL','2':'CIVIL','3':'C.S.E.','4':'E.C.E','5':'ELECTRICAL','6':'I.T.','7':'MECHANICAL','8':'METALLURGY','9':'MINING','10':'PRODUCTION','11':'ALL'}" id="BranchName" label="Book Branch"/>   
	<s:submit value="SUBMIT REQUEST" align="center"/>
  </s:form>
</div>
</div><br></br>
<div class="container1" style="margin-left:300px;">
    <h2 style="margin-left:60px">1. Available Books in Library : <a class="circle3" href="availableBooks?student_id=<s:property value="student_id"/>">CLICK</a></h2>
	<h2 style="margin-left:60px">2. View Current Issued Books And Current Due : <a class="circle3" href="issuedBooks?student_id=<s:property value="student_id"/>">CLICK</a></h2>
	<h2 style="margin-left:60px">3. Previous Issued Books And Previous Due : <a class="circle3" href="previousIssuedBooks?student_id=<s:property value="student_id"/>">CLICK</a></h2>
</div>
<%
     }else {
    	  response.sendRedirect("index.jsp");
      }
%> 
</body>
</html>