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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
  <link rel="stylesheet" href="/resources/b/css/bootstrap.css"/>
  <script src="/resources/b/js/bootstrap.js"></script>


</head>
<body>

<div class="container">
  <div class="row">
    <div class="row">
      <%--logout--%>
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="#">Twitter</a>
          </div>
          <a class="nav navbar-nav navbar-right" href="<c:url value="/j_spring_security_logout"/>">Logout</a>
        </div>


      </nav>
    </div>
    <br/>

      <div class="row">

        <div class="col-md-offset-4 col-md-4">
          <form id="tweetForm" action="/app/tweets" method="post">

            <div class="form-group">
              <textarea cols="5" rows="3" name="text" class="form-control"></textarea>
            </div>

            <button type="submit" form="tweetForm" class="btn btn-success right">Send</button>

          </form>
        </div>
      </div>
    <br/>



    <div class="row">
      <%--main tweets--%>

      <div class="col-md-offset-4 col-md-4">
        <ol class="list-group">

          <c:if test="${allT}">
            <c:forEach var="tweet" items="${tweetsAll}">
              <li id="tweet<c:out value="${tweet.id}"/>" class="list-group-item">
                <div class="content">
                  <p class="">
                    <a href="/app/tweets/owner/<c:out value="${tweet.owner.login}"/>"><h4><c:out
                            value="${tweet.owner.login}"/></h4></a>
                <span>
                  Date:<c:out value="${tweet.createdAt}"/>
                </span>
                  </p>
                  <div class="media-body">
                    <c:out value="${tweet.text}"/>
                  </div>
                  <button onclick="delete_tweet(<c:out value="${tweet.id}"/>)" class="btn btn-xs btn-danger">x</button>
                </div>
              </li>

            </c:forEach>
          </c:if>

          <c:if test="${byUser}">
            <c:forEach var="tweet" items="${tweetsUser}">
              <li id="tweet<c:out value="${tweet.id}"/>" class="list-group-item">
                <div class="content">
                  <p class="">
                    <a href="/app/tweets/owner/<c:out value="${tweet.owner.login}"/>"><h4><c:out
                            value="${tweet.owner.login}"/></h4></a>
                <span>
                  Date:<c:out value="${tweet.createdAt}"/>
                </span>
                  </p>
                  <div class="media-body">
                    <c:out value="${tweet.text}"/>
                  </div>
                  <button onclick="delete_tweet(<c:out value="${tweet.id}"/>)" class="btn btn-xs btn-danger pull-right">x</button>
                </div>
              </li>

            </c:forEach>
          </c:if>

        </ol>

      </div>
    </div>
  </div>
</div>
<script>

  $('#tweetForm').submit(function (e) {
    console.log("start processing the form")
    e.preventDefault();
    var form = $(this);
    var data = form.serialize();
    $.ajax({
      type: 'POST',
      url: '/app/tweets',
      data: data,
      success: function (data) {
        console.log('Пришли')
        console.log(data);
      }
    });
    location.reload(1);
  });

  function delete_tweet(id) {
    $.ajax({
      type:'DELETE',
      url:'/app/tweets/'+id,
      success: function(data) {
        console.log(data);
      }
    });
    location.reload(1);
  }


</script>

</body>
</html>
