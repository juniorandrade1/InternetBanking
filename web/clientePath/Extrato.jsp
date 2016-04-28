
<%@page import="Model.ClassTransacao"%>
<%@page import="Sources.QuerysBd"%>
<%@page import="Model.ClassConta"%>
<%@page import="Model.ClassCorrentista"%>
<%@page import="Sources.Bdquerys"%>
<%@page import="Sources.Bdquerys"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.IOException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Extrato</title>
    </head>
    
        <h1>Ola Senhor(a) ${Correntista.nome} </h1><br>
        <fieldset>
            <legend>Extrato</legend>
            <%
                ClassConta s = (ClassConta) request.getSession().getAttribute("Conta");
                String conta = s.getNumero();
                QuerysBd bd = new QuerysBd();
                ArrayList<ClassTransacao> arr = bd.getAllExtrato(conta);
                
                out.println("<h1>Transacoes</h1><br><br>");
                out.println("<table border=\"1\" style=\"width:100%\">");
                out.println("<tr>");
                out.println("<th>Tipo</th>");
                out.println("<th>Nro. Conta</th>");
                out.println("<th>Nro. Conta Transf</th>");
                out.println("<th>Valor</th>");
                out.println("</tr>");
                
                for(ClassTransacao it : arr) {
                    out.println("<tr>");
                    out.println("<td>" + it.getTipo() + "</td>");
                    out.println("<td>" + it.getNroConta()+ "</td>");
                    out.println("<td>" + it.getNroContaTransf()+ "</td>");
                    out.println("<td>" + it.getValor()+ "</td>");
                    out.println("</tr>");                
                }
            %>
        </fieldset>
</html>
