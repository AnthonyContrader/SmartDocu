<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.FolderDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Folder Edit">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Folder</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
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

	<%FolderDTO f = (FolderDTO) request.getSession().getAttribute("dto");%>


	<form id="floatleft" action="/folder/update" method="post">
		<div class="row">
	    	<div class="col-25">
	      	<label for="name">Name</label>
	    	</div>
	    <div class="col-75">
	    	<input type="text" id="name" name="name" value=<%=f.getName()%>>
	    </div>
	</div>
	      <button type="submit" >Edit</button>
	</form>


</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>