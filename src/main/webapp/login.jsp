<%--
  Created by IntelliJ IDEA.
  User: paulawaite
  Date: 9/20/15
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="templates/head.jsp"%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%@include file="templates/header.jsp"%>
<%-- TODO add form here for logging in --%>
<div class="line"></div>
<FORM id="loginForm" ACTION="j_security_check" METHOD="POST">
    <TABLE>
        <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
    </TABLE>
</FORM>
</body>
</html>


