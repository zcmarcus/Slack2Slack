<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Form - Choose Template" />
<%@include file="templates/head.jsp"%>
<html lang="en">
<body>
<%@include file="templates/navmenu.jsp"%>
<div class="container">


    <h2>Configure Workspace using Template</h2>
        <div>
            <c:choose>
                <c:when test="${!empty userTemplates}">
                    <c:forEach items="${userTemplates}" var="template">
                        <p>Test output for Template with id: ${template.templateId}:</p>
                        <p class="alert alert-warning">
                            ${template}
                        </p>
                    </c:forEach>
                </c:when>
            </c:choose>
        </div>

        <form action="formLoadAction" method="POST" class="form">
            <div>
                <div class="form-group">
                    <label for="chooseTemplate">Choose Template to Configure: </label>
                    <select class="form-control" name="chooseTemplate" id="chooseTemplate">
                        <option selected disabled>Select...</option>
                        <c:choose>
                            <c:when test="${!empty userTemplates}">
                                <c:forEach items="${userTemplates}" var="template">
                                    <option value="${template.templateId}">Template Name: ${template.templateName}</option>
                                </c:forEach>
                            </c:when>
                        </c:choose>
                        <option value="new">Create New Template</option>
                    </select>
                </div>

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
