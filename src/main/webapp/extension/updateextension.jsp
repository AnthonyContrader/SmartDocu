<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="it.contrader.dto.ExtensionDTO"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Extension</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="ExtensionServlet?mode=extensionlist">Extensions</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%ExtensionDTO e = (ExtensionDTO) request.getAttribute("dto");%>


<form id="floatleft" action="ExtensionServlet?mode=update&id=<%=e.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">Type</label>
    </div>
    <div class="col-75">
      <input type="text" id="extension" name="type" value=<%=e.getEstensione()%>>
    </div>
  </div>
  		</div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>
</body>
</html>