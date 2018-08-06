package pl.coderslab.team2.dao;

import pl.coderslab.team2.controller.OrdersController.Error;
import pl.coderslab.team2.entity.Client;
import pl.coderslab.team2.entity.Orders;
import pl.coderslab.team2.services.DbService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.valueOf;

public class OrdersDao extends HttpServlet {
    public static int addOrdertoDB(Orders order) {
        int result = 0;
        String query = "insert into orders values(null, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?);";
        List<String> params = getAll(order);
        try {
            result = DbService.insertIntoDatabase(query, params);
        } catch (SQLException ignore) {}
        return result;
    }

    public static int updateOrderDataInDb(Orders order, int id) {
        int result = 0;
        String query = "update orders set beginRepairingData = ?, destinedWorker = ?, issueInfo = ?, repairInfo = ?, Status = ?, vechicle = ?, costForClient = ?, partsCost = ?, workHoursCost = ?, workHoursAmount = ? where id = ?;"; //TODO fill it
        order.setOrderId(id);
        List<String> params = getAllIdLast(order);
        try {
            result = DbService.executeQuery(query, params);
        } catch (SQLException ignore) {  }
        return result;
    }



    public static List<Orders> loadAll() {
        String query = "select * from orders;";
        List<Orders> orders = new ArrayList<>();
        List<String[]> allOrders = new ArrayList<>();
        try {
            allOrders = DbService.getData(query, null);
        } catch (SQLException ignore) { }

        for (String[] orderList : allOrders
                ) {
            BigDecimal big = new BigDecimal(2.55);
            BigDecimal big2 = new BigDecimal(3.55);
            Orders order = new Orders(1,"l","o","r","e","m","i","p",big,big2,5,6);
            BigDecimal costForClient = new BigDecimal(orderList[8]);
            BigDecimal partsCost = new BigDecimal(orderList[9]);
            double WorkHoursCost = valueOf(orderList[10]);
            double WorkHoursAmount = valueOf(orderList[11]);
            order.setOrderId(Integer.parseInt(orderList[0]));
            order.setAcceptanceData(orderList[1]);
            order.setBeginRepairingData(orderList[2]);
            order.setDestinedWorker(orderList[3]);
            order.setIssueInfo(orderList[4]);
            order.setRepairInfo(orderList[5]);
            order.setStatus(orderList[6]);
            order.setVechicle(orderList[7]);
            order.setCostForClient(costForClient);
            order.setCostForClient(partsCost);
            order.setWorkHoursCost(WorkHoursCost);
            order.setWorkHoursAmount(WorkHoursAmount);
            orders.add(order);
        }
        return orders;
    }


    public static Orders findById(int id) {
        String query = "select * from orders where id = ?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        List<String[]> clientListFromDb = new ArrayList<>();
        try {
            clientListFromDb = DbService.getData(query, params);
        } catch (SQLException ignore) { }
        String[] orderList = clientListFromDb.get(0);
        BigDecimal big = new BigDecimal(2.55);
        BigDecimal big2 = new BigDecimal(3.55);
        Orders order = new Orders(id,"l","o","r","e","m","i","p",big,big2,5,6);
        BigDecimal costForClient = new BigDecimal(orderList[8]);
        BigDecimal partsCost = new BigDecimal(orderList[9]);
        double WorkHoursCost = valueOf(orderList[10]);
        double WorkHoursAmount = valueOf(orderList[11]);
        order.setOrderId(Integer.parseInt(orderList[0]));
        order.setAcceptanceData(orderList[1]);
        order.setBeginRepairingData(orderList[2]);
        order.setDestinedWorker(orderList[3]);
        order.setIssueInfo(orderList[4]);
        order.setRepairInfo(orderList[5]);
        order.setStatus(orderList[6]);
        order.setVechicle(orderList[7]);
        order.setCostForClient(costForClient);
        order.setCostForClient(partsCost);
        order.setWorkHoursCost(WorkHoursCost);
        order.setWorkHoursAmount(WorkHoursAmount);
        return order;
    }

    public static int delete(int id) {
        String query = "delete from orders where id = ?";
        List<String> params = new ArrayList<>();
        int result = 0;
        params.add(String.valueOf(id));
        try {
            result = DbService.executeQuery(query, params);
        } catch (SQLException ignore) {  }
        return result;
    }
    public static int showOrderStatus(int id){
        String query = "select Status from orders where id =?";
        List<String> params = new ArrayList<>();
        int result = 0;
        params.add(String.valueOf(id));
        try {
            result = DbService.executeQuery(query,params);
        } catch (SQLException ignore){ }
        return result;
    }
    public static void editStatus(int id, String newStatus){
        String query = "update orders set status = ? where id =?";
        List<String> params = new ArrayList<>();
        params.add(newStatus);
        id = new Integer(id);
        params.add(Integer.toString(id));
        try {
            DbService.executeQuery(query,params);
        }catch (Exception ignore){  }

    }
    private static List<String> getAll(Orders order) {
        List<String> params = new ArrayList<>();
        params.add(order.getAcceptanceData().toString());
        params.add(order.getBeginRepairingData().toString());
        params.add(order.getDestinedWorker());
        params.add(order.getIssueInfo());
        params.add(order.getRepairInfo());
        params.add(order.getStatus());
        params.add(order.getVechicle());
        params.add(order.getCostForClient().toString()); // fix bigDecimal to string
        params.add(order.getPartsCost().toString()); // same as above
        params.add(String.valueOf(order.getWorkHoursCost()));
        params.add(String.valueOf(order.getWorkHoursAmount()));
        return params;
    }
    private static List<String> getAllIdLast(Orders order) {
        List<String> params = new ArrayList<>();
        params.add(order.getAcceptanceData().toString());
        params.add(order.getBeginRepairingData().toString());
        params.add(order.getDestinedWorker());
        params.add(order.getIssueInfo());
        params.add(order.getRepairInfo());
        params.add(order.getStatus());
        params.add(order.getVechicle());
        params.add(order.getCostForClient().toString()); // fix bigDecimal to string
        params.add(order.getPartsCost().toString()); // same as above
        params.add(String.valueOf(order.getWorkHoursCost()));
        params.add(String.valueOf(order.getWorkHoursAmount()));
        params.add(String.valueOf(order.getOrderId()));
        return params;
    }

    }

