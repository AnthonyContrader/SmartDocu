<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List"
    import="it.contrader.dto.ExtensionDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Extension Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a class="active" href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="CategoryServlet?mode=categorylist">Categorie</a>
  <a href="ExtensionServlet?mode=extensionlist">Estenzioni</a>
  <a href="LogoutServlet" id="logout">Logout</a>
  </div>
<div class="main">
	<%
		List<ExtensionDTO> list = (List<ExtensionDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Type</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (ExtensionDTO u : list) {
		%>
		<tr>
			<td><a href=ExtensionServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getEstensione()%>
			</a></td>
			<td><a href=ExtensionServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=ExtensionServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="ExtensionServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="extension">Type</label>
    </div>
    <div class="col-75">
      <input type="text" id="extension" name="type" placeholder="inserisci tipo">
    </div>
  </div>
	
      <button type="submit" >Insert</button>
</form>

<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>
</body>
</html>