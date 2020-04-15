<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Home - Slack2Slack" />
<%@include file="templates/head.jsp"%>
<html>
<body>
<%@include file="templates/navmenu.jsp"%>
<%@include file="templates/header.jsp"%>

<main>
        <div class="wrapper">
        <%@ page session="true" %>
        <c:if test="${sessionScope.authError}">
                <div class="alert alert-danger" role="alert">There was an error authenticating your account. Please log out and try again.</div>
        </c:if>
<%--        Below line is just for adjusting the CSS (uncomment it if needed). We don't actually want to display if there's no error--%>
<%--        <c:if test="${not sessionScope.authError}">--%>
<%--                <div class="alert alert-danger" role="alert">There's no error!</div>--%>
<%--        </c:if>--%>

        <h2 id="welcome">Welcome!</h2>
        <p id="welcomeToSlack2Slack">
                Slack2Slack is a time saver for Slack users who frequently create workspaces with the same channels.
                With Slack2Slack, you create a workspace template <i>just once</i>, and then can apply that template to
                as many Slack workspaces as you would like.</p>
                <ul>
                        <li>Eliminate clicking endlessly through Slack to create the same workspace over and over</li>
                        <li>Update your workspace templates at any time</li>
                        <li>Store up to 50 channels on each workspace template</li>
                </ul>
        </div>

</main>
</body>
</html>
