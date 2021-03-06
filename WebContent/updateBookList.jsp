<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="icon" type="image/png" href="images/favicon.ico.png" sizes="32x32">
<link rel="stylesheet" href="css/table.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Book List</title>
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
.container2 { position:center; width:auto; background: linear-gradient(#ff4d4d,#ffb3b3);  overflow:auto;
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
.dueForm{
text-align:center;}
</style>
</head>
<body>  
<h1 style="margin-left:450px"><img src="images/library_icon.png" height="70%"> Library Management</h1>
 <% session=request.getSession(false) ; 
      if(session.getAttribute("admin_user")!=null){
   %>
 <h3 style="margin-left:300px">WELCOME  ${sessionScope.admin_user} ! <a style="width:10%;height:90%" class="circle2" href="adminLogout">Logout</a></h3>

<div class="container2" style="margin-left:10px;">
   <h2 style="margin-left:350px">4. Update Book List : </h2>
      <table id="approveReturnBookTable" class="CSSTableGenerator">
			<tr>
				<th>Book Id</th>
				<th>Book Name</th>
				<th>Book Author</th>
				<th>Branch</th>
				<th>Available</th>
                <th>Description</th>
				<th>Semester</th>
				<th>Available books</th>
				<th>Edit/Update </th>
            </tr>
            <s:iterator value="availList" var="availableList">
            <tr>
                    <td align="center"><s:property value="book_id" /></td>
					<td align="center"><s:property value="book_name" /></td>
					<td align="center"><s:property value="book_author" /></td>
					<td align="center"><s:property value="branchType2.branch_name" /></td>
					<td align="center"><s:property value="is_book_available" /></td>
					<td align="center"><s:property value="book_description" /></td>
					<td align="center"><s:property value="book_semester" /></td>
					<td align="center"><s:property value="number_of_available_books" /></td>
					<td align="center"><a class="circle1" 
					    href="editThisBook?admin_id=<s:property value="admin_id"/>&&book_id=<s:property value="book_id"/>">EDIT ?</a></td>
           </tr>
	        </s:iterator>
 </table>
 </div><br></br>	
<div class="container1" style="margin-left:300px;">
   <h2 style="margin-left:60px">1. Approve / Reject Student's Registration : <a class="circle3" href="approveStudentRegistration?admin_id=<s:property value="admin_id"/>"> CLICK</a></h2>
   <h2 style="margin-left:60px">2. Approve / Reject Book Issue request : <a class="circle3" href="approveBookIssueRequest?admin_id=<s:property value="admin_id"/>"> CLICK</a></h2>   
   <h2 style="margin-left:60px">3. Approve / Reject Book Return request : <a class="circle3" href="approveBookReturnRequest?admin_id=<s:property value="admin_id"/>">CLICK</a></h2>
   <h2 style="margin-left:60px">5. Wishlisted Book By Student : <a class="circle3" href="view_Wishlisted_Book_List?admin_id=<s:property value="admin_id"/>">CLICK</a></h2>
   <h2 style="margin-left:60px">6. View Total Due Balance List : <a class="circle3" href="dueBalanceList?admin_id=<s:property value="admin_id"/>"> CLICK </a></h2>
   <h2 style="margin-left:60px">7. Due Balance Of A Particular Student :</h2>
                                 <form name="dueForm" class="dueForm" action="particularStudentDue?admin_id=<s:property value="admin_id"/>" method="post" onsubmit="return validateDueForm()">
                                   <s:textfield name="roll" label="Roll" id="Roll"/><br><br>
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