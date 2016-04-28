package Sources;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.ClassConta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Júnior
 */
public class NovaConta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    boolean existUser(String cpf){
        return true;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //
            String pCorr = request.getParameter("priCorr");
            String sCorr = request.getParameter("segCorr");
            String tCorr = request.getParameter("terCorr");
            double saldo = Double.parseDouble(request.getParameter("saldo"));
            double limite = Double.parseDouble(request.getParameter("limite"));
            //
            
            
            System.out.println("Entrou aqui");
            
            
            if(pCorr.compareTo("") == 0) {
                System.out.println("Primeiro Correntista não inserido");
                pCorr = null;
            }
            else {
                if(!existUser(pCorr)) {
                    System.out.println("Primeiro Correntista não válido");
                    pCorr = null;
                }
            }
            
             if(sCorr.compareTo("") == 0) {
                System.out.println("Segundo Correntista não inserido");
                sCorr = null;
            }
             else {
                 if(!existUser(sCorr)) {
                     System.out.println("Segundo Correntista não existe");
                    sCorr = null;
                 }
             }
            
            if(tCorr.compareTo("") == 0) {
                System.out.println("Terceiro Correntista não escolhido");
                tCorr = null;
            }
            else {
                if(!existUser(tCorr)) {
                    System.out.println("Terceiro Correntista não existe");
                    tCorr = null;
                }
            }
            
            QuerysBd bd = new QuerysBd();
            bd.createConta(pCorr, sCorr, tCorr, saldo, limite);
            out.println("Conta Criada<br>");
            ClassConta cc = bd.getConta(pCorr, sCorr, tCorr);
            out.println("A conta é de numero: " + cc.getNumero());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(NovaConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(NovaConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
