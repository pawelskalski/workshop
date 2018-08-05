package pl.coderslab.team2.controller.OrdersController;

import pl.coderslab.team2.dao.OrdersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.valueOf;

@WebServlet(name = "EditOrderStatus")
public class EditOrderStatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int serchedid = valueOf(request.getParameter("orderId"));
        String newStatus = request.getParameter("newStatus");
        try {
            OrdersDao.editStatus(serchedid, newStatus);
            response.sendRedirect("/succesfull");
        } catch (Exception ignore) {
            response.sendRedirect("/Error");
        }
    }
}
