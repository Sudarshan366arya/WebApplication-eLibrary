<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="icon" type="image/png" href="images/favicon.ico.png" sizes="32x32">
<link rel="stylesheet" href="css/table.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book returning Request</title>
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
</style>
</head>
<body>
<h1 style="margin-left:450px">Library Management</h1>
<% session=request.getSession(false) ; 
    if(session.getAttribute("student_user")!=null){
%>
    <h3 style="margin-left:300px">WELCOME ${sessionScope.student_user} ! <a style="width:10%;height:90%" class="circle2" href="studentLogout"> Logout</a></h3>
<div class="container2" style="margin-left:250px;">
<h2 style="margin-left:100px">Failed To Return The Book,As Book Is Not Granted For Use !! </h2>
<table id="returnBook" class="CSSTableGenerator">
		<tr>
			<th>Book Id</th>
			<th>Book Name</th>
			<th>Book Author</th>
			<th>Semester</th>
			<th>Status</th>
		</tr>
		<s:iterator value="viewBookList" var="avail">
			<tr>
			    <td align="center"><s:property value="book_id"/></td>
				<td align="center"><s:property value="book_name"/></td>
				<td align="center"><s:property value="author_name"/></td>
				<td align="center"><s:property value="book_semester"/></td>
				<td align="center"><s:property value="status"/></td>
			</tr>
		</s:iterator>
	</table>
</div>
<br></br>
	<div class="container1" style="margin-left:300px;">
    <h2 style="margin-left:60px">1. Available Books in Library : <a class="circle3" href="availableBooks?student_id=<s:property value="student_id"/>">CLICK</a></h2>
	<h2 style="margin-left:50px">2. View Current Issued Books And Current Due : <a class="circle3" href="issuedBooks?student_id=<s:property value="student_id"/>">CLICK</a></h2>	
	<h2 style="margin-left:60px">3. Previous Issued Books And Previous Due : <a class="circle3" href="previousIssuedBooks?student_id=<s:property value="student_id"/>">CLICK</a></h2>
	<h2 style="margin-left:60px">4. Manage Wishlist : <a class="circle3" href="wishlisting?student_id=<s:property value="student_id"/>">CLICK</a></h2>	
</div>
   <%
     }else {
    	  response.sendRedirect("index.jsp");
      }
%>
</body>
</html>