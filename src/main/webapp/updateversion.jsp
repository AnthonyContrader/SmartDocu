<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.VersionDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Version Edit">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Version</title>


</head>
<body>
<%@ include file="./css/header.jsp" %>
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
<br>
<div class="main">

	<%VersionDTO v = (VersionDTO) request.getSession().getAttribute("dto");%>

	<form id="floatleft" action="/version/update" method="post">
		
		<div class="row">
			<div class="col-25">
				<label for="number">Number</label>
			</div>
			<div class="col-75">
				<input type="text" id="number" name="number"
					placeholder="inserisci number">
			</div>
		</div>
		
		<div class="row">
			<div class="col-25">
				<label for="dateMod">Modification Date</label>
			</div>
			<div class="col-75">
				<input type="text" id="dateMod" name="dateMod"
					placeholder="inserisci modification date">
			</div>
		</div>
		
		<div class="row">
			<div class="col-25">
				<label for="content">Content</label>
			</div>
			<div class="col-75">
				<input type="text" id="content" name="content"
					placeholder="inserisci content">
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="idDocument">Document</label>
			</div>
			<div class="col-75">
				<input type="text" id="idDocument" name="idDocument"
					placeholder="inserisci Document">
			</div>
				<input type="hidden" name="id" value =<%=v.getId() %>>
		</div>
		<button type="submit">Insert</button>
	</form>



</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>