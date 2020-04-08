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

                <form class="form" action="signupAction" method="post">
                    <div class="form-group">
                        <label for="name">User name: </label>
                        <input class="form-control" type="text" name="name" id="name" required pattern="[a-zA-Z0-9]{1}[a-zA-Z0-9_]{0,29}"  maxlength="30">
                    </div>
                    <div class="form-group">
                        <label for="password">Password: </label>
                        <input type="password" class="form-control" name="password" id="password" required maxlength="50">
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword">Confirm Password: </label>
                        <input type="password" class="form-control" name="confirmPassword" id="confirmPassword" required maxlength="50" >
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