<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Login - Error" />
<%@include file="templates/head.jsp"%>
<html>
<body>
<div class="container-fluid">
    <%@include file="templates/navmenu.jsp"%>

    <div class="container">
        <h2>Login failed.</h2>
        <p>Please check user login credentials and <a href="login.jsp">try again</a>.</p>

    </div>
</div>
</body>
</html>
