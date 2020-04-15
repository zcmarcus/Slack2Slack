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

                                        <li><a class="nav-link sidebarLink" href="#about">About</a></li>
                                        <li><a class="nav-link sidebarLink" href="#howto">How to Use</a></li>
                                        <li><a class="nav-link sidebarLink" href="#resources">Resources</a></li>
                                </ul>
                        </div>
                        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 flex-grow-1 py-3">
                                <h2 class="mt-3">Slack2Slack Documentation</h2>


                                <div class="card mt-5" id="about">
                                        <div class="card-body p-5">
                                                <h3 class="card-title">About</h3>
                                                <p class="card-text">Slack2Slack is a utility allowing for quick and simple configuration of new Slack Workspaces from user-created templates.</p>
                                        </div>
                                </div>

                                <div class="card mt-5" id="howto">
                                        <div class="card-body p-5">
                                                <h3 class="card-title">How to Use</h3>
                                                <div>
                                                    <ol class="list-group">
                                                            <li class="list-item mt-2 mb-2">Create a new Slack Workspace at <a href="slack.com/create#email">slack.com/create#email</a> and set up with base required details.</li>
                                                            <li class="list-item mt-2 mb-2">
                                                                    <ul class="list-unstyled">
                                                                            <li class="list-item">Add our Slack App to workspace (Codename: SlacKerZ, but will be listed as Slack2Slack upon distribution)</li>
                                                                            <li class="list-item"><img src="images/docs/install_slack_app.png" alt=""></li>
                                                                    </ul>
                                                            <li class="list-item mt-2 mb-2">
                                                                    <ul class="list-unstyled">
                                                                            <li class="list-item">In a web browser, navigate to our web app here: <a href="http://18.217.107.47:8080/Slack2Slack_war">http://18.217.107.47:8080/Slack2Slack_war</a></li>
                                                                    </ul>
                                                            </li>


                                                            <li class="list-item mt-2 mb-2">
                                                                    <ul class="list-unstyled">
                                                                            <li class="list-item">Click "Sign Up" in the upper right section of the top navigation bar, and create a user account.</a></li>
                                                                            <li class="list-item"><img src="images/docs/001_sign_up.png" alt=""></li>
                                                                    </ul>
                                                            </li>


                                                            <li class="list-item mt-2 mb-2">
                                                                    <ul class="list-unstyled">
                                                                            <li class="list-item">Create a new account.</li>
                                                                            <li class="list-item"><img src="images/docs/002_create_account.png" alt=""></li>
                                                                    </ul>
                                                            </li>

                                                            <li class="list-item mt-2 mb-2">
                                                                    <ul class="list-unstyled">
                                                                            <li class="list-item">Upon confirmation of account creation, click "Log In."</li>
                                                                            <li class="list-item"><img src="images/docs/003_creation_confirmed.png" alt=""></li>
                                                                    </ul>
                                                            </li>

                                                            <li class="list-item mt-2 mb-2">
                                                                    <ul class="list-unstyled">
                                                                            <li class="list-item">Enter credentials and click Submit</li>
                                                                            <li class="list-item"><img src="images/docs/004_log_in.png" alt=""></li>
                                                                    </ul>
                                                            </li>

                                                            <li class="list-item mt-2 mb-2">
                                                                    <ul class="list-unstyled">
                                                                            <li class="list-item">You will be presented with a dialog asking you to grant our Slack App permission to create and modify channel data in your workspace. Click 'Allow'.</li>
                                                                            <li class="list-item"><img src="images/docs/005_permission_allow.png" alt=""></li>
                                                                    </ul>
                                                            </li>

                                                            <li class="list-item mt-2 mb-2">
                                                                    <ul class="list-unstyled">
                                                                            <li class="list-item">After being redirected to our web app's home page, click "Slack Workspace Template Form" in the upper right section of the top navigation bar.</li>
                                                                            <li class="list-item"><img src="images/docs/006_click_template_form.png" alt=""></li>
                                                                    </ul>
                                                            </li>

                                                            <li class="list-item mt-2 mb-2">
                                                                    <ul class="list-unstyled">
                                                                            <li class="list-item">You will reach a screen with a drop-down menu containing any existing templates and an option to create a new template.</li>
                                                                            <li class="list-item"><img src="images/docs/007a_choose_template.png" alt=""></li>
                                                                    </ul>
                                                            </li>

                                                            <li class="list-item mt-2 mb-2">
                                                                    <ul class="list-unstyled">
                                                                            <li class="list-item"><img src="images/docs/007b_choose_template_choices.png" alt=""></li>
                                                                    </ul>
                                                            </li>

                                                            <li class="list-item mt-2 mb-2">
                                                                    <ul class="list-unstyled">
                                                                            <li class="list-item">Selecting "Create New Template" and clicking the Submit button will land the user on a blank form for configuring a new workspace template</li>
                                                                            <li class="list-item"><img src="images/docs/008a_configure_new.png" alt=""></li>
                                                                    </ul>
                                                            </li>

                                                            <li class="list-item mt-2 mb-2">
                                                                    <ul class="list-unstyled">
                                                                            <li class="list-item">Selecting an existing template and clicking Submit will load a template configuration form already pre-filled with fields from the existing template<li>
                                                                            <li class="list-item"><img src="images/docs/008b_configure_existing.png" alt=""></li>
                                                                    </ul>
                                                            </li>
                                                  

                                                            <li class="list-item mt-2 mb-2">
                                                                    <ul class="list-unstyled">
                                                                            <li class="list-item">When workspace template configuration is complete, click to Submit. This fires off two actions: 1.)*All workspace attributes defined on form are configured/added to the user's Slack Workspace. ,
                                                                                    and 2.) If any changes are made to the template, the template is updated in the database.
                                                                            </li>
                                                                            <li><small>*Note: only partially functional at this time. Note all form fields are currently configured to populate Slack Workspace attributes</small></li>
                                                                            <li class="list-item"><img src="images/docs/009_submit.png" alt=""></li>
                                                                    </ul>
                                                            </li>

                                                            <li class="list-item mt-2 mb-2">
                                                                    <ul class="list-unstyled">
                                                                            <li class="list-item">Check Slack Workspace for new changes based on form entry.</li>
                                                                            <li class="list-item"><img src="images/docs/010_channels_created.png" alt=""></li>
                                                                    </ul>
                                                            </li>






                                                    </ol>
                                                </div>
                                        </div>

                                </div>

                                <div class="mt-5" id="resources">
                                        <h3>Web Service Resources</h3>
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

