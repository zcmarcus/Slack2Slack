<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h2>Configure Workspace using Template</h2>

    <form action="" method="POST" class="form">
        <div>
            <div class="form-group">
                <label for="chooseTemplate">Choose Template: </label>
                <select class="form-control" name="chooseTemplate" id="chooseTemplate">
                    <option selected>Choose...</option>
                    <%--  FIXME: Change to actual variable and method names--%>
                    <c:choose>
                        <c:when test="${!empty userTemplates}">
                            <c:forEach items="${userTemplates}" var="template">
                                <option>${userTemplates.getTemplateName}</option>
                            </c:forEach>
                        </c:when>
                    </c:choose>
                    <option></option>
                </select>
            </div>
        </div>

        <%-- Name this template (only used in our web app; has no bearing on Slack workspace)--%>
        <div>
            <div>
                <h3>Template Name</h3>
                <p>
                    Give this workspace a descriptive name.
                </p>
                <p>
                    <small>Note: This field does not show up in Slack; it is simply used
                    help identify this template.</small>
                </p>

            </div>

            <div class="form-group">
                <label for="templateName">Template Name (</label>
                <input type="text" class="form-control" name="templateName" id="templateName" placeholder="Template Name">
            </div>

        </div>
        <%-- Fill out workspace details (owner first/last name, owner display name, workspace icon)--%>
        <div>
            <div>
                <h3>Workspace Details</h3>
            </div>

            <div class="form-group">
                <label for="ownerFirstName">Owner First Name</label>
                <input type="text" class="form-control" name="ownerFirstName" id="ownerFirstName" placeholder="First Name">
            </div>
            <div class="form-group">
                <label for="ownerLastName">Owner Last Name</label>
                <input type="text" class="form-control" name="ownerLastName" id="ownerLastName" placeholder="Last Name">
            </div>
            <div class="form-group">
                <label for="ownerDisplayName">Owner Display Name</label>
                <input type="text" class="form-control" name="ownerDisplayName" id="ownerDisplayName" placeholder="Desired Display Name">
            </div>
            // TODO: Either leave as is (require user to upload icon image elsewhere and type url here) OR allow file upload (use Amazon S3 bucket?)
            <div class="form-group">
                <label for="iconUrl">Workspace Icon</label>
                <input type="text" class="form-control" name="iconUrl" id="iconUrl" placeholder="Workspace Icon Url">
            </div>
        </div>

        <%-- Add/configure desired channels  --%>

        <%-- TODO: Validation - if user fills out topic and purpose for a given channel, that channel's name must also be entered.--%>
        <div>
            <div>
                <h3>
                    Channels
                </h3>
            </div>

            <div class="form-group">
                <label for="channel1Name">Channel Name</label>
                <input type="text" class="form-control" name="channel1Name" id="channel1Name" placeholder="Channel Name">
            </div>

            <div class="form-group">
                <label for="channel1Topic">Channel Topic</label>
                <input type="text" class="form-control" name="channel1Topic" id="channel1Topic" placeholder="Channel Topic">
            </div>
            <div class="form-group">
                <label for="channel1Purpose">Channel Purpose</label>
                <input type="text" class="form-control" name="channel1Purpose" id="channel1Purpose" placeholder="Channel Purpose">
            </div>

            <div class="moreChannelsContainer">
                <%--
                    TODO: Decide:
                          A.) include markup for all inputs for creating channels, hidden by default, and display programmatically with js/jquery
                          or
                          B.) add elements dynamically with javascript (create & append)
                --%>
            </div>

            <div>
                <button id="addChannel" class="btn btn-secondary">Add Another Channel</button>
            </div>

            <div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>


    </form>

</body>
</html>
