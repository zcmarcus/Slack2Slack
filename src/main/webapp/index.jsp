<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Home - Slack2Slack" />
<%@include file="templates/head.jsp"%>
<html>
<body>
<%@include file="templates/navmenu.jsp"%>
<%@include file="templates/header.jsp"%>

<main>

<%--    TODO: Format error messages; update text on index to include intro--%>
        <%@ page session="true" %>
        <c:if test="${sessionScope.authError}">There was an error authenticating your account. Please try again.</c:if>
<%--        Below line is just for adjusting the CSS (uncomment it if needed). We don't actually want to display if there's no error--%>
<%--        <c:if test="${not sessionScope.authError}">There's no error!</c:if>--%>

        <h2 id="welcome">Hello World!</h2>
        <p id="welcomeToSlack2Slack">Welcome to the amazing Slack2Slack application</p>


</main>
</body>
</html>
