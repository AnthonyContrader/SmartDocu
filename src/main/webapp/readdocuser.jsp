<%@ page import="it.contrader.dto.DocumentDTO" import="it.contrader.dto.VersionDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Document Management">

<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Document Manager</title>

</head>
<body>

	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeuser.jsp">Home</a> 
		<a class="active" href="/document/getall">Documents</a> 
		
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			DocumentDTO d = (DocumentDTO) request.getSession().getAttribute("dtoDocument");
			VersionDTO v = (VersionDTO) request.getSession().getAttribute("dtoVersion");
		%>

		<h1><%=d.getTitle() %></h1>
		<h2><%=d.getDescription() %></h2>
		<label><%=v.getContent() %></label>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>

</body>
</html>