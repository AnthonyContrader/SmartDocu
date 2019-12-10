<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.FolderDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Folder Read">

<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Folder</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a>
		<a href=/user/getall>Users</a>
		<a class="active" href="/folder/getall">Folders</a> 
		<a href="/document/getall">Documents</a>
		<a href="/version/getall">Versions</a> 
		<a href="/category/getall">Categories</a>
		<a href="/extension/getall">Extensions</a> 
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			FolderDTO f = (FolderDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
			</tr>
			<tr>
				<td><%=f.getId()%></td>
				<td><%=f.getName()%></td>

			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>