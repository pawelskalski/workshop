<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 04.08.18
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditStatus</title>
</head>
<body>
<form action="/EditOrderStatus" method="GET">
    <p>Podaj id klienta którego chcesz wyszukać</p>
    <label>
        <input type="number" name="orderId">

        <input type="submit" name="Szukaj">
        <p></p>
        Choose new status:
        <select name="newStatus">
            <option>Oczekujace</option>
            <option>Realizowane</option>
            <option>Gotowe do odbioru</option>
        </select>
    </label>
</form>
<p></p>

<p></p>
<a href="/OrdersMenu/OrderMain.jsp">Powrót</a>

</body>
</html>
