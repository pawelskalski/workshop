package pl.coderslab.team2.controller.OrdersController;

import pl.coderslab.team2.dao.OrdersDao;
import pl.coderslab.team2.entity.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/addOrder")
public class addOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String acceptanceData = request.getParameter("acceptanceData");
    String beginRepairingData = request.getParameter("beginRepairingData");
    String destinedWorker = request.getParameter("destinedWorket");
    String issueInfo = request.getParameter("issueInfo");
    String repairInfo = request.getParameter("repairInfo");
    String status = request.getParameter("Status");
    String car = request.getParameter("Car");
    String costForC = (request.getParameter("costForClient"));
    BigDecimal costForClient = new BigDecimal(costForC.replaceAll(",","\\."));
    String partsC = request.getParameter("partsCost");
    BigDecimal partCost = new BigDecimal(partsC.replaceAll(",","\\."));
    String workHoursC = request.getParameter("workHoursCost");
    double workHoursCost = Double.parseDouble(workHoursC.replaceAll(",","\\."));
    String workHousrA = request.getParameter("workHoursAmount");
    double workHoursAmount = Double.parseDouble(workHousrA.replaceAll(",","\\."));
    Orders order = new Orders(1,acceptanceData,beginRepairingData,destinedWorker,issueInfo,repairInfo,status,car,costForClient,partCost,workHoursCost,workHoursAmount);
    try {
        OrdersDao.addOrdertoDB(order);
        response.sendRedirect("/Succsesfull");
    }catch (Exception e){
        response.sendRedirect("/Error");

    }
    }
}
