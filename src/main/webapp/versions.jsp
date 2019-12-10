<%@ page import="it.contrader.dto.VersionDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Version Management">

<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Version Manager</title>

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
			List<VersionDTO> list = (List<VersionDTO>) request.getSession().getAttribute("list");
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
			<%
				for (VersionDTO v : list) {
			%>
			<tr>
				<td><a href="/version/read?id=<%=v.getId()%>"> <%=v.getNumber()%></a></td>
				<td><%=v.getDateMod()%></td>
				<td><%=v.getContent()%></td>
				<td><%=v.getDocumentDTO().getTitle() %></td>
				<td><a href="/version/preupdate?id=<%=v.getId()%>">Edit</a></td>


				<td><a href="/version/delete?id=<%=v.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/version/insert" method="post">
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
					<label for="document">Document</label>
				</div>
				<div class="col-75">
					<input type="text" id="document" name="document"
						placeholder="inserisci Document">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>

</body>
</html>