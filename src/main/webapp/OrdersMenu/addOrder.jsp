<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 01.08.18
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AddOrder</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker();
        } );
        $( function () {
            $("#datepicker2").datepicker();
        });
    </script>
</head>
<body>

<form action="/addOrder" method="GET">
    <label>
        Acceptance Data:
        <input type="text" id="datepicker" name="acceptanceData"> <%--todo fix this script --%>
        <p></p>
        Begin Repairing Data:
        <input type="text" id="datepicker2" name="beginRepairingData">
        <p></p>
        Destined Worker:
        <input type="text" name="destinedWorker">
        <p></p>
        Issue Info:
        <input type="text" name="issueInfo">
        <p></p>
        Repair Info:
        <input type="text" name="repairInfo">
        <p></p>
        Status:
        <select name="Status">
            <option>Oczekujace</option>
            <option>Realizowane</option>
            <option>Gotowe do odbioru</option>
        </select>
        <p></p>
        Car:
        <input type = "text" name="car">
        <p></p>
        Cost for Client:
        <input type="number" step="0.01" name="costForClient" >
        <p></p>
        Cost of parts:
        <input type="number" step="0.01" name="partsCost">
        <p></p>
        Worker per hour:
        <input type="number" step="0.01" name ="workHoursCost">
        <p></p>
        Amount of work hours:
        <input type="number" name="workHoursAmount">
        <p></p>
        <input type="submit">

    </label>
    <p></p>
    <a href="/OrdersMenu/OrderMain.jsp">Order Menu</a>
</form>
</body>
</html>
