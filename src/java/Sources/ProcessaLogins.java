package Sources;

import Model.ClassCorrentista;
import Model.ClassConta;
import Model.ClassFuncionario;
import Model.ClassLogged;
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
    
    private QuerysBd bd;
    //Recebe Logins Gerais
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
        if(request.getParameter("formName").compareTo("Login") == 0) {
            bd = new QuerysBd();
            String username = request.getParameter("username");
            String senha = request.getParameter("senha");
            String numero = request.getParameter("numero");
            String address = address = "WEB-INF/UnknownCustomer.jsp";
            try {
                String CPF = bd.verifyInfo(username, senha, numero, 0);
                if (CPF != null){
                    ClassCorrentista Correntista = bd.getCorrentista(CPF);
                    ClassConta Conta = bd.getConta(numero);
                    request.getSession().setAttribute("Conta", Conta);
                    request.getSession().setAttribute("Correntista", Correntista);
                    request.getSession().setAttribute("Logged", new ClassLogged());
                    address = "/clientePath/HomeUser.jsp";
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProcessaLogins.class.getName()).log(Level.SEVERE, null, ex);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
        }
        else {   
            bd = new QuerysBd();
            String username = request.getParameter("username");
            String senha = request.getParameter("senha");
            String numero = request.getParameter("numero");
            String address = address = "WEB-INF/UnknownCustomer.jsp";
            try {
                    String codigoAcesso = bd.verifyInfo(username, senha, numero, 1);
                    ClassFuncionario Funcionario = bd.getFuncionario(codigoAcesso);
                    if(Funcionario != null) {
                       request.getSession().setAttribute("Funcionario", Funcionario);
                       request.getSession().setAttribute("Logged", new ClassLogged(true));
                       address = "/funcionarioPath/HomeFunc.jsp";
                    }
                } catch (SQLException ex) {
                Logger.getLogger(ProcessaLogins.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
        }
    }
}
