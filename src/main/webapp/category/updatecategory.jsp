<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="it.contrader.dto.CategoryDTO"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Categoryt</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="CategoryServlet?mode=categorylist">Categories</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%CategoryDTO e = (CategoryDTO) request.getAttribute("dto");%>


<form id="floatleft" action="CategoryServlet?mode=update&id=<%=e.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">Type</label>
    </div>
    <div class="col-75">
      <input type="text" id="category" name="type" value=<%=e.getDescription()%>>
    </div>
  </div>
  	      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>