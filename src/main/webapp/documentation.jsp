<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Documentation - Slack2Slack" />
<%@include file="templates/head.jsp"%>
<html>
<body>
<%@include file="templates/navmenu.jsp"%>
<%@include file="templates/header.jsp"%>

<main>


        <h2 id="welcome">Hello World!</h2>
        <p id="welcomeToSlack2Slack">Slack2Slack Documentation</p>

        <div class="sidenav">
                <a href="#description">Description</a>
                <a href="#resources">Resources</a>
                <a href="#">Another Thing</a>
                <a href="#">Also This</a>
        </div>

        <div class="main">
                <div id="description">
                        <h3>Description</h3>
                        <p>Description text...</p>

                </div>



                <div id="operations">
                        <h3>operations</h3>

                        <table class="table">
                                <thead>
                                        <tr>
                                                <th>Type</th>
                                                <th>Operation Details</th>
                                        </tr>
                                </thead>
                                <tbody>
                                        <tr>
                                                <td class="operationType">POST</td>
                                                <td class="operationDetails">addTemplate</td>
                                        </tr>
                                </tbody>
                        </table>


                </div>
        </div>




</main>
</body>
</html>
