<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.DocumentDTO"%>
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
  <a class="active" href="/document/getall">Documents</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

	<%DocumentDTO d = (DocumentDTO) request.getSession().getAttribute("dto");%>


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
					<input type="text" id="datePub" name="datePub"
						placeholder="inserisci publication date">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="user">User</label>
				</div>
				<div class="col-75">
					<input type="text" id="user" name="user"
						placeholder="inserisci user">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="folder">Folder</label>
				</div>
				<div class="col-75">
					<select id="folder" name="folder">
						<option value='1'>Documenti</option>
						<option value='2'>Film</option>
					</select>
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="category">Category</label>
				</div>
				<div class="col-75">
					<select id="category" name="category">
						<option value='1'>Privato</option>
					</select>
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="extension">Estension</label>
				</div>
				<div class="col-75">
					<select id="extension" name="extension">
						<option value='1'>.doc</option>
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