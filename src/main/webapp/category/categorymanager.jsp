<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
  import="java.util.List"
    import="it.contrader.dto.CategoryDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="CategoryServlet?mode=categorylist">Category</a>
  <a href="LogoutServlet" id="logout">Logout</a>
 
</div>
<div class="main">
	<%
		List<CategoryDTO> list = (List<CategoryDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Type</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (CategoryDTO u : list) {
		%>
		<tr>
			<td><a href=CategoryServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getDescription()%>
			</a></td>
			<td><a href=CategoryServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=CategoryServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="CategoryServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="category">Type</label>
    </div>
    <div class="col-75">
      <input type="text" id="category" name="type" placeholder="inserisci tipo">
    </div>
  </div>

      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>
</body>
</html>