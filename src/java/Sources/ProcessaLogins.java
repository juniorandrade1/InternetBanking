package Sources;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProcessaLogins extends HttpServlet {
    
    private BDQuerys bd;
    //Recebe Logins Gerais
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bd = new BDQuerys();
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");
        String numero = request.getParameter("numero");
        String address = address = "WEB-INF/UnknownCustomer.jsp";
        try {
            String CPF = bd.verifyInfo(username, senha, numero);
            if (CPF != null){
                ClassConta Conta = bd.getConta(numero);
                request.getSession().setAttribute("Conta", Conta);
                
                ClassCorrentista Correntista = bd.getCorrentista(CPF);
                request.getSession().setAttribute("Correntista", Correntista);
                address = "/clientePath/HomeUser.jsp";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProcessaLogins.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    // Post recebe login funcionarios
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //BankCustomer customer = BankCustomerLookup.getCustomer(request.getParameter("username"));
        //request.getSession().setAttribute("func", customer);
        String address = "WEB-INF/UnknownCustomer.jsp";
//        if (customer == null) {
//            address = "WEB-INF/UnknownCustomer.jsp";
//        } else {
//            address = "HomeFunc.jsp";
//        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

}
