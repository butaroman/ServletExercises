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
<c:if test="${!empty movieTitleList}">
    <table class="tg">
        <tr>
            <th width="80">Movie Title</th>
        </tr>
        <c:forEach items="${movieTitleList}" var="title">
            <tr>
                <td>${title}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>