<%@include file="templates/head.jsp"%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%@include file="templates/header.jsp"%>
<div class="line">

</div>
<div class="container">
    <h2>Sign In</h2>
    <div class="row col-6">
        <FORM id="loginForm" action="<%=request.getContextPath()%>/j_security_check" METHOD="POST">
            <div>
                <div class="form-group">
                    <input type="TEXT" placeholder="User Name" class="form-control" id="username" name="j_username">
                </div>
                <div class="form-group">
                    <input type="PASSWORD" placeholder="Password" class="form-control" id="password" name="j_password">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </FORM>
    </div>
</div>
</body>
</html>
