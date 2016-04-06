
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowBalance extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BankCustomer customer = BankCustomerLookup.getCustomer(request.getParameter("id"));
        String address;
        if (customer == null) {
            address = "WEB-INF/UnknownCustomer.jsp";
        } else if (customer.getBalance() < 0) {
            address = "WEB-INF/NegativeBalance.jsp";
            request.setAttribute("badCustomer", customer);
        } else if (customer.getBalance() < 10000) {
            address = "WEB-INF/NormalBalance.jsp";
            request.setAttribute("regularCustomer", customer);
        } else {
            address = "/WEB-INF/HighBalance.jsp";
            request.setAttribute("eliteCustomer", customer);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
