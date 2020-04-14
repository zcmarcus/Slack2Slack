<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Configure Workspace" />
<%@include file="templates/head.jsp"%>
<html lang="en">
<body>
<%@include file="templates/navmenu.jsp"%>
<%@include file="templates/header.jsp"%>
<div class="container">

    <h2 id="configWorkspace">Configure Workspace using Template</h2>

    <div class="row col-6">
        <%--        TODO: change form action to servlet that handles call(s) to webservice to: 1.) create new template and 2.) create slack workspace--%>
        <form action="templateAction" method="POST" class="form">
            <input type="hidden" name="templateId" value="${currentTemplate.templateId}">

            <%-- Template name (only used in our web app; has no bearing on Slack workspace)--%>
            <div>
                <div>
                    <h3>Template Name</h3>
                    <p>
                        Give this template a descriptive name.
                    </p>
                    <p>
                        <small>Note: This field does not show up in Slack; it is simply used
                            to help identify this template.</small>
                    </p>

                </div>

                <div class="form-group">
                    <label for="templateName">Template Name</label>
                    <input type="text" class="form-control" name="templateName" value="${currentTemplate.templateName}" id="templateName" placeholder="Template Name">
                </div>

            </div>
            <%-- Workspace details (owner first/last name, owner display name, workspace icon)--%>
            <div>
                <div>
                    <h3>Workspace Details</h3>
                </div>

                <div class="form-group">
                    <label for="ownerFirstName">Owner First Name</label>
                    <input type="text" class="form-control" name="ownerFirstName" value="${currentTemplate.ownerFirstName}" id="ownerFirstName" placeholder="First Name">
                </div>
                <div class="form-group">
                    <label for="ownerLastName">Owner Last Name</label>
                    <input type="text" class="form-control" name="ownerLastName" value="${currentTemplate.ownerLastName}" id="ownerLastName" placeholder="Last Name">
                </div>
                <div class="form-group">
                    <label for="ownerDisplayName">Owner Display Name</label>
                    <input type="text" class="form-control" name="ownerDisplayName" value="${currentTemplate.ownerDisplayName}" id="ownerDisplayName" placeholder="Desired Display Name">
                </div>
                <div class="form-group">
                    <label for="ownerEmail">Owner Email</label>
                    <input type="text" class="form-control" name="ownerEmail" value="${currentTemplate.ownerEmail}" id="ownerEmail" placeholder="Email Address">
                </div>
                <div class="form-group">
                    <label for="iconUrl">Workspace Icon URL</label>
                    <input type="text" class="form-control" name="iconUrl" value="${currentTemplate.iconUrl}" id="iconUrl" placeholder="Example: https://1drv.ms/u/s23Aiti?e=2398z">
                </div>
            </div>

            <%-- Add/configure desired channels  --%>

            <%-- TODO: Validation - No fields required, BUT if user fills out topic and purpose for a given channel, that channel's name cannot be left empty.--%>
            <div id="channelsContainer">
                <div class="mb-2">
                    <h3>Channels</h3>
                    <span><small><em>Note: Maximum of 50 channels allowed</em></small></span>
                </div>

                <div id="channel1Details" class="border border-dark p-4">
                    <div class="form-group channel1NameFormGroup">
                        <label for="channel1Name">Name</label>
                        <input type="text" class="form-control" name="channel1Name" id="channel1Name" >
                    </div>
                    <div class="form-group" id="channel1PurposeFormGroup">
                        <label for="channel1Purpose">Purpose</label>
                        <input type="text" class="form-control" name="channel1Purpose" id="channel1Purpose">
                    </div>
                    <div class="form-group" id="channel1TopicFormGroup">
                        <label for="channel1Topic">Topic</label>
                        <input type="text" class="form-control" name="channel1Topic" id="channel1Topic">
                    </div>

                </div>



            </div>

            <div>
                <a id="addChannelButton" class="btn btn-secondary text-light mt-2">+ Add Another Channel</a>
            </div>


            <div class="mt-5">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>

        </form>

    </div>

</div>

</body>
</html>

<script>
    init();
</script>
