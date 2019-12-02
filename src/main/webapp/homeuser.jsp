<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home User</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@include file="css/header.jsp"%>


<div class="navbar">
  <a class="active" href="homeuser.jsp">Home</a>
  <a href="UserServlet?mode=userlist">User</a>
  <a href="FolderServlet?mode=folderlist">Folder</a>
  <a href="LogoutServlet" id="logout">Logout</a>
  
</div>

<div class="main">
<h1>Benvenuto Nel Social Network Dei Documenti ${user.getUsername()}</h1>

"Questo bellissimo Social Network , ti permette di gestire documenti come se fossero dei post; Quindi puoi condividerli,commentarli e mettere "Mi Piace"

</div>


<%@ include file="css/footer.jsp" %>


</body>
</html>