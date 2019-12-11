<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="it.contrader.dto.DocumentDTO"
    import="it.contrader.dto.ExtensionDTO"
	import="it.contrader.dto.UserDTO"
 	import="it.contrader.dto.CategoryDTO"
 	import="it.contrader.dto.FolderDTO"
%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Document Edit">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Document</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
		<a href="/homeadmin.jsp">Home</a>
		<a href=/user/getall>Users</a>
		<a href="/folder/getall">Folders</a> 
		<a class="active" href="/document/getall">Documents</a>
		<a href="/version/getall">Versions</a> 
		<a href="/category/getall">Categories</a>
		<a href="/extension/getall">Extensions</a> 
		<a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

	<%
		DocumentDTO d = (DocumentDTO) request.getSession().getAttribute("dto");
		List<UserDTO> listU = (List<UserDTO>) request.getSession().getAttribute("listUser");
		List<FolderDTO> listF = (List<FolderDTO>) request.getSession().getAttribute("listFolder");
		List<CategoryDTO> listC = (List<CategoryDTO>) request.getSession().getAttribute("listCategory");
		List<ExtensionDTO> listE = (List<ExtensionDTO>) request.getSession().getAttribute("listExtension");
	%>
	


	<form id="floatleft" action="/document/update" method="post">
		
<div class="row">
				<div class="col-25">
					<label for="title">Title</label>
				</div>
				<div class="col-75">
					<input type="text" id="title" name="title"
						placeholder="inserisci title">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="description">Description</label>
				</div>
			<div class="col-75">
					<input type="text" id="description" name="description"
						placeholder="inserisci description">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="genre">Genre</label>
				</div>
				<div class="col-75">
					<input type="text" id="genre" name="genre"
						placeholder="inserisci genre">
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-25">
					<label for="datePub">Publication Date</label>
				</div>
				<div class="col-75">
					<input type="date" data-date-inline-picker="true" id="date" name="datePub"
						placeholder="inserisci publication date">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="user">User</label>
				</div>
				<div class="col-75">
					<select id="user" name="user">
						<%for (UserDTO u : listU) { %>
						<option value='<%=u.getId()%>'><%=u.getUsername() %></option>
						<% } %>
					</select>
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="folder">Folder</label>
				</div>
				<div class="col-75">
					<select id="folder" name="folder">
						<%for (FolderDTO f : listF) { %>
						<option value='<%=f.getId()%>'><%=f.getName() %></option>
						<% } %>
					</select>
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="category">Category</label>
				</div>
				<div class="col-75">
					<select id="category" name="category">
						<%for (CategoryDTO c : listC) { %>
						<option value='<%=c.getId()%>'><%=c.getType() %></option>
						<% } %>
					</select>
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="extension">Estension</label>
				</div>
				<div class="col-75">
					<select id="extension" name="extension">
						<%for(ExtensionDTO e : listE) { %>
						<option value='<%=e.getId()%>'><%=e.getType() %></option>
						<% } %>
					</select>
				</div>
			</div>
			
			
			<button type="submit">Insert</button>
		</form>


</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>