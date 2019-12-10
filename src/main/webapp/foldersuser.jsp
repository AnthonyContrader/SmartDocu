<%@ page import="it.contrader.dto.FolderDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Folder Management">

<link href="/css/vittoriostyle.css" rel="stylesheet">

<style type="text/css"><%@include file="/css/font-awesome.css"%></style>


<title>Folder Manager</title>

</head>
<body>

	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeuser.jsp">Home</a> 
		<a href="/user/getall">Users</a> 
		<a class="active" href="/folder/getall">Folders</a> 
		<a href="/document/getall">Documents</a> 
		<a href="/version/getall">Versions</a> 
		<a href="/category/getall">Categories</a> 
		<a href="/extension/getall">Extensions</a> 
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<FolderDTO> list = (List<FolderDTO>) request.getSession().getAttribute("list");
		%>
	
	<br>

		<table>
			<tr>

			</tr>
			<%
				for (FolderDTO f : list) {
			%>
			<tr>
				<td><a href="/document/readbyfolderid?id=<%=f.getId()%>"> <i class="fa fa-folder" aria-hidden="true"> </i><%=f.getName()%></a></td>
			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/folder/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="folder">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="name" name="name"
						placeholder="inserisci name">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>

</body>
</html>