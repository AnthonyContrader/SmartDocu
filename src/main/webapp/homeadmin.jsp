<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Admin</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@include file="css/header.jsp"%>


<div class="navbar">
  <a class="active" href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="CategoryServlet?mode=categorylist">Categorie</a>
  <a href="ExtensionServlet?mode=extensionlist">Estenzioni</a>
  <a href="LogoutServlet" id="logout">Logout</a>
  
</div>

<div class="main">
<h1>Benvenuto Nel Social Network Dei Documenti ${user.getUsername()}</h1>

"Questo bellissimo Social Network , ti permette di gestire documenti come se fossero dei post; Quindi puoi condividerli,commentarli e mettere "Mi Piace"

</div>


<%@ include file="css/footer.jsp" %>

</body>
</html>