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
<c:if test="${!empty moviesList}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Title</th>
            <th width="120">Director</th>
        </tr>
        <c:forEach items="${moviesList}" var="movie">
            <tr>
                <td>${movie.id}</td>
                <td>${movie.title}</td>
                <td>${movie.director}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
