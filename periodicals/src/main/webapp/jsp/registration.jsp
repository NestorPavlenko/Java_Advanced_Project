<%@ spring:taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
<div>
<form:form>
<spring:bind path="email">
    <div class="form-group ${status.error ? 'has-error' : ''}">
        <form:input type="text" path="email" class="form-control" placeholder="Email" autofocus="true"></form:input>
        <form:errors path="email"></form:errors>
    </div>
</spring:bind>

<spring:bind path="password">
    <div class="form-group ${status.error ? 'has-error' : ''}">
        <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
        <form:errors path="password"></form:errors>
    </div>
</spring:bind>

<spring:bind path="passwordConfirm">
    <div class="form-group ${status.error ? 'has-error' : ''}">
        <form:input type="password" path="passwordConfirm" class="form-control" placeholder="Confirm your password"></form:input>
        <form:errors path="passwordConfirm"></form:errors>
    </div>
</spring:bind>

<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
</form:form>

</div>
</body>
</html>

