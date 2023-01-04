<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="webjars/bootstrap/4.6.2/css/bootstrap.min.css">
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/favicon.ico" />
    <title>Hibernate Examples</title>
</head>
<body>

<c:if test="${!empty users}">
    <table class="table table-striped">
        <tr>
            <c:forEach var="tableHeader" items="${tableHeaders}">
                <th>${tableHeader}</th>
            </c:forEach>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
