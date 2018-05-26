<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="icon" type="image/png" href="images/favicon.ico.png" sizes="32x32">
<link rel="stylesheet" href="css/table.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookList Update Form</title>
<script type="text/javascript">
function validateDueForm() {
	   var x = document.forms["dueForm"]["Roll"].value;
	   if (x == null || x == "" ||x<=1200000||x>=1699999) {
	   alert("Valid Roll must be filled out");
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
               padding:2px; gradient; border-radius:15px; border:2px solid #000000;opacity:0.95;}
.container2 { position:center; width:450px; background: linear-gradient(#ff4d4d,#ffb3b3);  overflow:auto;
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
	width:550px;
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

.circle1 {
    border-radius: 10px;
    width: 90%;
    height: 100%; 
    background:#008000;
    display:inline-block;
    line-height:20px;
    vertical-align:center;
    text-align:center;
    color:#ffffff;
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
.updateForm{
text-align:center;}
.dueForm{
text-align:center;}
</style>
</head>
<body>
<h1 style="margin-left:450px"><img src="images/library_icon.png" height="70%"> Library Management</h1>
<% session=request.getSession(false) ; 
    if(session.getAttribute("admin_user")!=null){
%>
 <h3 style="margin-left:300px">WELCOME ${sessionScope.admin_user} ! <a style="width:10%;height:90%" class="circle2" href="adminLogout"> Logout</a></h3>
<div class="container2" style="margin-left:400px;">
 <h2 style="margin-left:50px;width:350px;">4. Update This Book !! </h2>
<s:form action="updatedone" name="updateForm" method="post">
    <s:hidden name="availablebooks.book_id" key="id" value="%{availablebookedit.book_id}"/>
    <input type="hidden" name="admin_id" value="<s:property value='admin_id'/>"/>
	<s:textfield name="availablebooks.book_name"  value="%{availablebookedit.book_name}" label="Book Name" />
	<s:textfield name="availablebooks.book_author" value="%{availablebookedit.book_author}" label="Book Author"/>
	<s:select name="availablebooks.branchType2.branch_id" list="#{'','1':'CHEMICAL','2':'CIVIL','3':'C.S.E.','4':'E.C.E','5':'ELECTRICAL','6':'I.T.','7':'MECHANICAL','8':'METALLURGY','9':'MINING','10':'PRODUCTION','11':'ALL'}" value="%{availablebookedit.branchType2.branch_id}" label="Book Branch"/> 
	<s:select name="availablebooks.book_semester" list="#{'','1':'FIRST (1st)','2':'SECOND (2nd)','3':'THIRD (3rd)','4':'FOURTH (4th)','5':'FIFTH (5th)','6':'SIXTH (6th)','7':'SEVENTH (7th)','8':'EIGHTH (8th)'}" value="%{availablebookedit.book_semester}" label="Semester"/>
	<s:textfield name="availablebooks.book_description" value="%{availablebookedit.book_description}" label="Description"/>
	<s:select name="availablebooks.is_book_available" list="#{'','true':'YES','false':'NO'}" value="%{availablebookedit.is_book_available}" label="Available"/>
	<s:textfield name="availablebooks.number_of_available_books" value="%{availablebookedit.number_of_available_books}" label="Available Books"/>
	<s:submit value="Update List" align="center"/>
</s:form>
</div><br>
<div class="container1" style="margin-left:300px;">
   <s:hidden name="admin_name" id="adminName" value="%{admindata.admin_name}"/>
   <input type="hidden" name="admin_id" value="<s:property value='admin_id'/>"/>
   <h2 style="margin-left:60px">1. Approve / Reject Student's Registration : <a class="circle3" href="approveStudentRegistration?admin_id=<s:property value="admin_id"/>"> CLICK</a></h2>
   <h2 style="margin-left:60px">2. Approve / Reject Book Issue request : <a class="circle3" href="approveBookIssueRequest?admin_id=<s:property value="admin_id"/>"> CLICK</a></h2>
   <h2 style="margin-left:60px">3. Approve / Reject Book Return request : <a class="circle3" href="approveBookReturnRequest?admin_id=<s:property value="admin_id"/>">CLICK</a></h2>
   <h2 style="margin-left:60px">5. Wishlisted Book By Student : <a class="circle3" href="view_Wishlisted_Book_List?admin_id=<s:property value="admin_id"/>">CLICK</a></h2>  
   <h2 style="margin-left:60px">6. View Total Due Balance List : <a class="circle3" href="dueBalanceList?admin_id=<s:property value="admin_id"/>"> CLICK </a></h2>
   <h2 style="margin-left:60px">7. Due Balance Of A Particular Student :</h2>
                                 <form name="dueForm" class="dueForm" action="particularStudentDue?admin_id=<s:property value="admin_id"/>" method="post" onsubmit="return validateDueForm()" >
                                   <s:textfield name="roll" label="Roll" id="Roll"/>
                                   <s:submit value="View Due" align="center"/>
                                  </form>
  </div>
<%
     }else {
    	  response.sendRedirect("index.jsp");
      }
%>
</body>
</html>