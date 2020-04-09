<%@include file="templates/head.jsp"%>
<c:set var="title" value="Home - Slack2Slack" />
<html>
<body>
<%@include file="templates/navmenu.jsp"%>
<%@include file="templates/header.jsp"%>

<main>
        <div class="line"></div>
        <h2 id="welcome">Hello World!</h2>
        <p id="welcomeToSlack2Slack">Welcome to the amazing Slack2Slack application</p>
        <c:choose>
                <c:when test="${!empty newUserId && newUserId > 0}">
                        <div class="alert alert-success">
                                Success! User with ID <c:out value="${newUserId}"/> signed up successfully. You may now log in here.
                        </div>

                </c:when>
        </c:choose>
</main>
</body>
</html>
