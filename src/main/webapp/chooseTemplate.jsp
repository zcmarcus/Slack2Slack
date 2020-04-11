<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>

    <!-- form js script -->
    <script src="js/form.js"></script>

</head>
<body>
<div class="container">


    <h2>Configure Workspace using Template</h2>
    <div>

            <c:choose>
                <c:when test="${!empty userTemplates}">
                    <c:forEach items="${userTemplates}" var="template">
                        <p>Template ${template.templateId}:</p>
                        <p>
                            ${template}
                        </p>
                    </c:forEach>
                </c:when>
            </c:choose>

    </div>
    <div class="row col-6">

        <form action="formLoadAction" method="POST" class="form">
            <div>
                <div class="form-group">
                    <label for="chooseTemplate">Choose Template to Configure: </label>
                    <select class="form-control" name="chooseTemplate" id="chooseTemplate">
                        <option selected disabled>Select...</option>
                        <c:choose>
                            <c:when test="${!empty userTemplates}">
                                <c:forEach items="${userTemplates}" var="template">
                                    <option value="${template.templateId}">ID:${template.templateId} for Owner: ${template.ownerFirstName} ${template.ownerLastName}</option>
                                </c:forEach>
                            </c:when>
                        </c:choose>
                        <option value="new">Create New Template</option>
                    </select>
                </div>
<%--                <div class="form-group">--%>
<%--                    <input type="hidden" name="userTemplates" id="userTemplatesHolder"--%>
<%--                        <c:choose>--%>
<%--                            <c:when test="${!empty userTemplates}">--%>
<%--                               value="${userTemplates}"--%>
<%--                            </c:when>--%>
<%--                        </c:choose>--%>
<%--                    />--%>

<%--                </div>--%>
                <div class="mt-5">
                    <button type="submit" class="btn btn-primary" name="submitSelectTemplate">Configure Template</button>
                </div>

            </div>
        </form>

    </div>

</div>

</body>
</html>

<script>
    init();
</script>
