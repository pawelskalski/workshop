package pl.coderslab.team2.controller.OrdersController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

@WebServlet(name = "OrdersController")
public class OrdersController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter writer = response.getWriter();


    }

    public static void startMainMenu(){

        int action = choseAction();
        switch(action){
            case 1: System.out.println("Option 1"); break;
            case 2: System.out.println("Option2");;break;
            case 3: System.out.println("Option 3"); break;
            case 4: System.out.println("Option 4"); break;
        }
    }

    private static int choseAction(){

        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("What you want to do:");
            System.out.println("1 - Manage users");
            System.out.println("2 - Manage user group");
            System.out.println("3 - Manage questions");
            System.out.println("4 - Take exam");

            try{
                int option = scan.nextInt();
                if(option < 1 || option > 4){
                    throw new Exception("Wrong value");
                }
                return option;
            }catch (Exception e){
                System.out.println("Wrong value");
                scan.next();
            }

        }

    }


}
