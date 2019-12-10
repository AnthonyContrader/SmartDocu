<%@ page import="it.contrader.dto.ExtensionDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
<meta name="description" content="Extension Management">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Extension Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a> 
		<a class="active" href="/extension/getall">Extensions</a> 
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<ExtensionDTO> list = (List<ExtensionDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Type</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (ExtensionDTO d : list) {
			%>
			<tr>
				<td><a href="/extension/read?id=<%=d.getId()%>"> <%=d.getType()%></a></td>
				<td><a href="/extension/preupdate?id=<%=d.getId()%>">Edit</a></td>


				<td><a href="/extension/delete?id=<%=d.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/extension/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="extension">Type</label>
				</div>
				<div class="col-75">
					<input type="text" id="type" name="type"
						placeholder="inserisci type">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>

</body>
</html>