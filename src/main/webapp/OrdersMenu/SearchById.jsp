<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 03.08.18
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SearchInDB</title>
</head>
<body>
<form action="/ShowOrder" method="GET">
<p>Podaj id klienta którego chcesz wyszukać</p>
<label>
    <input type="number" name="orderId">
    <input type="submit" name="Szukaj">
</label>
</form>
<p></p>
<table>
    <tr>
<c:forEach items="${result}" var="item">
    <td> item </td>
</c:forEach>
    </tr>
</table>
<p></p>
<a href="/OrdersMenu/OrderMain.jsp">Powrót</a>
</body>
</html>
