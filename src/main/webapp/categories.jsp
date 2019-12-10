<%@ page import="it.contrader.dto.CategoryDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Category Management">

<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Category Manager</title>

</head>
<body>

	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a> 
		<a href="/extension/getall">Extensions</a> 
		<a class="active" href="/category/getall">Categories</a> 
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<CategoryDTO> list = (List<CategoryDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Type</th>
				<th>Description</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (CategoryDTO c : list) {
			%>
			<tr>
				<td><a href="/category/read?id=<%=c.getId()%>"> <%=c.getType()%></a></td>
				<td><%=c.getDescription()%></td>
				<td><a href="/category/preupdate?id=<%=c.getId()%>">Edit</a></td>


				<td><a href="/category/delete?id=<%=c.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/category/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="category">Type</label>
				</div>
				<div class="col-75">
					<input type="text" id="type" name="type"
						placeholder="inserisci type">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="category">Description</label>
				</div>
				<div class="col-75">
					<input type="text" id="description" name="description"
						placeholder="inserisci description">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>


</body>
</html>