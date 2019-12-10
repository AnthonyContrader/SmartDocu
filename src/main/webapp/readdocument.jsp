<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.DocumentDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Document Read">

<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Document</title>
</head>
<body>

	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a class="active" href="/document/getall">Documents</a> 
		
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			DocumentDTO d = (DocumentDTO) request.getSession().getAttribute("dto");
		%>

		<br>

		<table>
			<tr>
				<th>Title</th>
				<th>Description</th>
				<th>Genre</th>
				<th>Publication Date</th>
				<th>User</th>
				<th>Folder</th>
				<th>Category</th>
				<th>Extension</th>
				<th></th>
				<th></th>
			</tr>
			<tr>
				<td><%=d.getTitle()%></td>
				<td><%=d.getDescription()%></td>
				<td><%=d.getGenre()%></td>
				<td><%=d.getDatePub() %></td>
				<td><%=d.getUserDTO().getUsername() %></td>
				<td><%=d.getFolderDTO().getNome() %></td>
				<td><%=d.getCategoryDTO()%></td>
				<td><%=d.getExtensionDTO().getType() %></td>
					</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>