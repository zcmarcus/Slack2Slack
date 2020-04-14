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
                        <div class="col-sm-3 col-md-2 sidebar flex-shrink-1 pt-3" id="documentationNavbar">
                                <ul class="nav flex-sm-column">

                                        <li><a class="nav-link" href="#description">Description</a></li>
                                        <li><a class="nav-link" href="#resources">Resources</a></li>
                                        <li><a class="nav-link" href="#">Another Thing</a></li>
                                        <li><a class="nav-link" href="#">Also This</a></li>
                                </ul>
                        </div>
                        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 flex-grow-1 py-3">
                                <h5>Content</h5>

                                <h2 id="welcome">Slack2Slack Web Service Documentation</h2>




                                <div class="mt-5" id="description">
                                        <h3>Description</h3>
                                        <p>Description text...</p>

                                </div>

                                <div class="mt-5" id="operations">
                                        <h3>Resources</h3>
                                        <table class="table table-bordered table-striped" id="serviceOperationsTable" style="border-collapse:collapse;">
                                                <thead>
                                                        <tr>
                                                                <th>Type</th>
                                                                <th>Operation Details</th>
                                                        </tr>
                                                </thead>
                                                <tbody>
                                                        <tr class="toggler togglers1">
                                                                <td class="operationType"><button class="btn btn-primary togglers1">POST</button></td>
                                                                <td class="operationDetails"><span class="font-bold">addTemplate</span></td>
                                                        </tr>
                                                        <tr class="collapse p-3 hiddenRow" id="operationDetails1">
                                                                <td colspan="2">
                                                                        <div>
                                                                                <h4>Description</h4>
                                                                                <p>Create a new template</p>
                                                                                <table class="table table-condensed">
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

                                                        <tr class="toggler togglers2">
                                                                <td class="operationType "><button class="btn btn-success togglers2">GET</button></td>
                                                                <td class="operationDetails"><span class="font-bold">getTemplate</span></td>
                                                        </tr>
                                                        <tr class="collapse p-3 hiddenRow" id="operationDetails2">
                                                                <td colspan="2">
                                                                        <div>
                                                                                <h4>Description</h4>
                                                                                <p>Retrieve a template.</p>
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

                                                        <tr class="toggler togglers3">
                                                                <td class="operationType "><button class="btn btn-success togglers3">GET</button></td>
                                                                <td class="operationDetails"><span class="font-bold">getTemplates</span></td>
                                                        </tr>
                                                        <tr class="collapse p-3 hiddenRow" id="operationDetails3">
                                                                <td colspan="2">
                                                                        <div>
                                                                                <h4>Description</h4>
                                                                                <p>Get all templates for a user.</p>
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

                                                        <tr class="toggler togglers4">
                                                                <td class="operationType "><button class="btn btn-primary togglers4">PUT</button></td>
                                                                <td class="operationDetails"><span class="font-bold">updateTemplate</span></td>
                                                        </tr>
                                                        <tr class="collapse p-3 hiddenRow" id="operationDetails4">
                                                                <td colspan="2">
                                                                        <div>
                                                                                <h4>Description</h4>
                                                                                <p>Update an existing template.</p>
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

                                                        <tr class="toggler togglers5">
                                                                <td class="operationType "><button class="btn btn-primary togglers5">DELETE</button></td>
                                                                <td class="operationDetails"><span class="font-bold">removeTemplate</span></td>
                                                        </tr>
                                                        <tr class="collapse p-3 hiddenRow" id="operationDetails5">
                                                                <td colspan="2">
                                                                        <div>
                                                                                <h4>Description</h4>
                                                                                <p>Delete a template</p>
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

