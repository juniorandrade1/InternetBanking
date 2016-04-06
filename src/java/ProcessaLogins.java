
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProcessaLogins extends HttpServlet {

    boolean verifyInfo(String user, String number, String pass) {
        return true;
    }
    
    //Recebe Logins Gerais
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BankCustomer customer = BankCustomerLookup.getCustomer(request.getParameter("username"));
        request.getSession().setAttribute("user", customer);
        String address;
        if (customer == null) {
            address = "WEB-INF/UnknownCustomer.jsp";
        } else {
            address = "HomeUser.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
    
    // Post recebe login funcionarios
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       BankCustomer customer = BankCustomerLookup.getCustomer(request.getParameter("username"));
        request.getSession().setAttribute("func", customer);
        String address;
        if (customer == null) {
            address = "WEB-INF/UnknownCustomer.jsp";
        } else {
            address = "HomeFunc.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
    
}
