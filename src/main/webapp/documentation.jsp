<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Documentation - Slack2Slack" />
<%@include file="templates/head.jsp"%>
<html>
<body>
<%@include file="templates/navmenu.jsp"%>
<%@include file="templates/header.jsp"%>

<main>

        <div class="container-fluid flex-grow-1 d-flex">
                <div class="row flex-fill flex-column flex-sm-row">
                        <div class="col-sm-3 col-md-2 sidebar flex-shrink-1 bg-dark pt-3" id="Navbar">
                                <ul class="nav flex-sm-column">

                                        <li><a class="nav-link" href="#description">Description</a></li>
                                        <li><a class="nav-link" href="#resources">Resources</a></li>
                                        <li><a class="nav-link" href="#">Another Thing</a></li>
                                        <li><a class="nav-link" href="#">Also This</a></li>
                                </ul>
                        </div>
                        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 flex-grow-1 py-3">
                                <h5>Content</h5>

                                <h2 id="welcome">Hello World!</h2>
                                <p id="welcomeToSlack2Slack">Slack2Slack Documentation</p>



                                <div class="mt-5" id="description">
                                        <h3>Description</h3>
                                        <p>Description text...</p>

                                </div>

                                <div class="mt-5" id="operations">
                                        <h3>Resources</h3>

                                        <table class="table table-bordered" id="serviceOperationsTable" style="border-collapse:collapse;">
                                                <thead>
                                                        <tr>
                                                                <th>Type</th>
                                                                <th>Operation Details</th>
                                                        </tr>
                                                </thead>
                                                <tbody>
                                                        <tr colspan="2" data-toggle="collapse" data-target="operationDetails1" class="accordion-toggle">
                                                                <td class="operationType"><button class="btn btn-primary">POST</button></td>
                                                                <td class="operationDetails"><a href="#">addTemplate</a></td>
                                                        </tr>
                                                        <tr class="p">
                                                                <td colspan="2" class="hiddenRow">
                                                                        <div class="accordian-body collapse p-3" id="operationDetails1">
                                                                                <table class="table table-striped">
                                                                                        <caption>Parameters</caption>
                                                                                        <thead>
                                                                                        <tr>
                                                                                                <th>Name</th>
                                                                                                <th>Description</th>
                                                                                                <th>Data type</th>
                                                                                        </tr>
                                                                                        </thead>
                                                                                        <tbody>
                                                                                        <tr>
                                                                                                <td>parameter1</td>
                                                                                                <td>description.....</td>
                                                                                                <td>TemplatesCollection</td>
                                                                                        </tr>
                                                                                        </tbody>
                                                                                </table>

                                                                        </div>
                                                                </td>
                                                        </tr>

                                                        <tr colspan="2" data-toggle="collapse" data-target="operationDetails2" class="accordion-toggle">
                                                                <td class="operationType"><button class="btn btn-success">GET</button></td>
                                                                <td class="operationDetails"><a href="#">getTemplates</a></td>
                                                        </tr>
                                                        <tr class="p">
                                                                <td colspan="2" class="hiddenRow">
                                                                        <div class="accordian-body collapse p-3" id="operationDetails2">
                                                                                <table class="table table-striped">
                                                                                        <caption>Parameters</caption>
                                                                                        <thead>
                                                                                        <tr>
                                                                                                <th>Name</th>
                                                                                                <th>Description</th>
                                                                                                <th>Data type</th>
                                                                                        </tr>
                                                                                        </thead>
                                                                                        <tbody>
                                                                                        <tr>
                                                                                                <td>parameter1</td>
                                                                                                <td>description.....</td>
                                                                                                <td>TemplatesCollection</td>
                                                                                        </tr>
                                                                                        </tbody>
                                                                                </table>

                                                                        </div>
                                                                </td>
                                                        </tr>
                                                </tbody>
                                        </table>


                                </div>
                        </div>
                </div>
        </div>
















</main>
</body>
</html>
