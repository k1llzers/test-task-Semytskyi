<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Statistic</title>
</head>
<body>
<h1>statistic of domen</h1>
<table>
    <tr>
        <td>Count of pages</td>
        <td>Count of external link</td>
    </tr>
    <tr>
        <td><c:out value="${domenCountOfPages}"   /></td>
        <td><c:out value="${domenCountofExternal}"   /></td>
    </tr>
</table>

<h1>statistic of pages</h1>
<table>
    <tr>
        <td>url</td>
        <td>Count of external link</td>
        <td>Nesting level</td>
    </tr>
    <c:forEach items="${urls}" var="url">
        <tr>
            <td><c:out value="${url.url}"   /></td>
            <td><c:out value="${url.countOfExternalHrefs}"   /></td>
            <td><c:out value="${url.nestingLevel}"   /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
