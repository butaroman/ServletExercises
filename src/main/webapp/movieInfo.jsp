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
<c:if test="${!empty resultList}">
    <table class="tg">
        <tr>
            <th width="80">Movie id</th>
            <th width="120">Rating date</th>
        </tr>
        <c:forEach items="${resultList}" var="elem">
            <tr>
                <td>${elem[0]}</td>
                <td>${elem[1]}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
