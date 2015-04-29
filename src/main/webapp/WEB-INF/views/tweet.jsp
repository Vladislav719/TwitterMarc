<%--
  Created by IntelliJ IDEA.
  User: vladislav
  Date: 28.04.2015
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:forEach var="tweet" items="${tweets}">
  <c:out value="${tweet.id}"/>
  <c:out value="${tweet.owner}"/>
  <c:out value="${tweet.text}"/>
  <c:out value="${tweet.createdAt}"/>
</c:forEach>

</body>
</html>
