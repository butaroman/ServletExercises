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
<c:if test="${!empty ratingsList}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Rating</th>
            <th width="120">Rating date</th>
            <th width="120">movieId</th>
            <th width="120">userId</th>
        </tr>
        <c:forEach items="${ratingsList}" var="rating">
            <tr>
                <td>${rating.id}</td>
                <td>${rating.rating}</td>
                <td>${rating.ratingDate}</td>
                <td>${rating.movie.id}</td>
                <td>${rating.user.id}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
