<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.VersionDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Version Read">

<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Version</title>
</head>
<body>

	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a>
		<a href=/user/getall>Users</a>
		<a href="/folder/getall">Folders</a> 
		<a href="/document/getall">Documents</a>
		<a class="active" href="/version/getall">Versions</a> 
		<a href="/category/getall">Categories</a>
		<a href="/extension/getall">Extensions</a> 
		<a href="/user/logout" id="logout">Logout</a>
	</div>
<div class="main">
		<%
			VersionDTO v = (VersionDTO) request.getSession().getAttribute("dto");
		%>

		<br>

		<table>
			<tr>
				<th>Number</th>
				<th>Modification Date</th>
				<th>Content</th>
				<th>Document</th>
				<th></th>
				<th></th>
			</tr>
			
			<tr>
				<td><%=v.getNumber()%></td>
				<td><%=v.getDateMod()%></td>
				<td><%=v.getContent()%></td>
				<td><%=v.getDocumentDTO().getTitle() %></td>
			</tr>
				
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>