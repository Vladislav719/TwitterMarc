<%--
  Created by IntelliJ IDEA.
  User: vladislav
  Date: 05.05.2015
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <link rel="stylesheet" href="../resources/b/css/bootstrap.css"/>
    <script src="../resources/b/js/bootstrap.js"></script>
</head>
<body>

<div class="container">
    <div class="row">
        <h1 class="text-info"> Авторизация </h1>
    </div>
    <div class="row">
        <div class="col-md-offset-4 col-md-5">
            <form id="registrationForm" method="post" action="/login">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" class="form-control" placeholder="Enter username"/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" class="form-control" placeholder="pass" name="password">
                </div>
                <button class="btn btn-default" type="submit" form="registrationForm">Login</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
