<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@include file="style.jsp"%>
<html>
<head>
    <title>Simple exercises</title>
</head>
<body>
<a href="index">Back to main menu</a>
<br/>
<br/>
<c:if test="${!empty usersList}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
        </tr>
        <c:forEach items="${usersList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
