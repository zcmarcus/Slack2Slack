<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Sign Up" />
<%@include file="templates/head.jsp"%>


<html>
<body>
<div class="container-fluid">
    <%@include file="templates/navmenu.jsp"%>

    <div class="container">

        <div class="row">
            <div class="col-6 offset-3">

                <form class="form" action="signup" method="post">
                    <div class="form-group">
                        <label for="username">Username: </label>
                        <input class="form-control" type="text" name="username" id="username" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password: </label>
                        <input type="password" class="form-control" name="password" id="password" required>
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword">Confirm Password: </label>
                        <input type="password" class="form-control" name="confirmPassword" id="confirmPassword" required>
                    </div>

                    <div class="text-danger mt-2 mb-2" id="passwordMatchStatus"></div>

                    <div class="form-group">
                        <input type="submit" class="btn btn-primary" name="submit" id="submit" value="Create Account">
                    </div>
                </form>

            </div>
        </div>


    </div>
</div>
</body>
</html>