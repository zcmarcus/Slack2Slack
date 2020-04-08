<%@include file="templates/head.jsp"%>
<c:set var="title" value="Home - Slack2Slack" />
<html>
<body>
<%@include file="templates/header.jsp"%>
<%@include file="templates/navmenu.jsp"%>

<main>
        <h2>Hello World!</h2>
        <p>Welcome to the amazing Slack2Slack application</p>

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
