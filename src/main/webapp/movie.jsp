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
            <th colspan="2">Action</th>
        </tr>
        <c:forEach items="${moviesList}" var="movie">
            <tr>
                <td>${movie.id}</td>
                <td>${movie.title}</td>
                <td>${movie.director}</td>
                <td>
                    <a href='task0movies?action=delete&movieId=<c:out value="${movie.id }"/>'>Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add new movie</h1>
<form action="task0movies" method="post">
        <div>
            <label for="id">Movie ID</label> <br><input type="text"
                    name="id" id="id" value="<c:out value="${movie.id}"/>"
                                                    placeholder="id" />
        </div>
        <div>
            <label for="title">Title</label> <br><input type="text"
                    name="title" id="title" value="<c:out value="${movie.title}" />"
                                                    placeholder="title" />
        </div>
        <div>
            <label for="director">Director</label><br> <input type="text"
                    name="director" id="director" value="<c:out value="${movie.director}" />"
                                                    placeholder="director" />
        </div>
        <div>
            <input type="submit" value="Add movie" />
        </div>
</form>

</body>
</html>
