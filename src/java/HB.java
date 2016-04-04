/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Júnior
 */
public class HB extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Sistema HomeBanking</title>");            
            
            /////////////////////INICIO CSS///////////////////////////
            out.println("<style type=\"text/css\">");
            out.println("<!--");
            out.println("body {");
            out.println("padding:0px;");
            out.println("margin:0px;");
            out.println("}");
            out.println("#menu ul{");
            out.println("padding:0px;");
            out.println("margin:0px;\n" +
			"float: left;\n" +
			"width: 100%;\n" +
			"background-color:#EDEDED;\n" +
			"list-style:none;\n" +
			"font:80% Tahoma;");
            out.println("}");
            out.println("#menu ul li { display: inline; }\n" +
" \n" +
"		#menu ul li a {\n" +
"			background-color:#EDEDED;\n" +
"			color: #333;\n" +
"			text-decoration: none;\n" +
"			border-bottom:3px solid #EDEDED;\n" +
"			padding: 2px 10px;\n" +
"			float:left;\n" +
"		}\n" +
" \n" +
"		#menu ul li a:hover {\n" +
"			background-color:#D6D6D6;\n" +
"			color: #6D6D6D;\n" +
"			border-bottom:3px solid #EA0000;\n" +
"		}\n" +
"	-->\n" +
"	</style>");
            /////////////////FIM CSS/////////////////////
            
            out.println("</head>");
            out.println("<body>");
            
            out.println(""
                    + "<div id=\"menu\">\n" +
                        "<ul>\n" +
                            "<li><a href=\"\">Home</a></li>\n" +
                            "<li><a href=\"\">Consultar Saldo</a></li>\n" +
                            "<li><a href=\"\">Sair</a></li>\n" +
        		"</ul>\n" +
                "</div>");
            
            out.println("</body>");
            
            out.println("</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
