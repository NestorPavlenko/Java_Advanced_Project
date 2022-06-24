<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">


    <title>Periodicalds</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<%--    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>--%>
<%--    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>--%>
</head>
<body>
    <div class="container">

        <!-- Sidebar -->
        <div class="w3-sidebar w3-light-grey w3-bar-block" style="width:10%">
            <h3 class="w3-bar-item">Menu</h3>
            <a href="/create-periodical" class="w3-bar-item w3-button">Create periodical</a>
            <a href="/home" class="w3-bar-item w3-button">Home</a>
            <a href="/bucket" class="w3-bar-item w3-button">Bucket</a>
        </div>

        <!-- Page Content -->
        <div style="margin-left:10%">

            <div class="w3-container w3-teal">
                <h1>Periodicals</h1>
            </div>
            <div class="w3-container">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <form id="logoutForm" method="POST" action="${contextPath}/logout">
                        <input type="hidden" name="${_scrf.parameterName}" value="${_scrf.token}"/>
                    </form>

                    <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
                </c:if>

                <c:if test="${not empty periodicals}">
                    <c:forEach items="${periodicals}" var="currentPeriodical">
                        ${lists}
                    </c:forEach>
                </c:if>

                <div class="w3-card-4" style="width:20%; margin: 2%">
                    <img src="data:image/jpg;base64, ${currentPeriodical.encodedImage}" alt="Norway" style="width:100%">
                    <div class="w3-container w3-center">
                        <h3>${currentPeriodical.name}</h3>
                        <p>${currentPeriodical.description}</p>
                        <p>${currentPeriodical.price}</p>
                    </div>
                    <form action="${contextPath }/bucket" method="POST">
                        <input type="hidden" value="${currentPeriodical}" class="form-control" name="periodial">
                        <input type="submit" class="w3-button w3-block w3-dark-grey" value="+ add to bucket">
                    </form>
                </div>

            </div>
        </div>
    </div>
</body>
</html>