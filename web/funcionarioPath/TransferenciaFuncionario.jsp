<%-- 
    Document   : Transferencia
    Created on : 06/04/2016, 16:22:24
    Author     : Júnior
--%>

<%@page import="Sources.QuerysBd"%>
<%@page import="Model.ClassConta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transferencia</title>
    </head>
    <body>
        <h1>
            <form id="TransferenciaFuncionario" method="POST" action="TransferenciaFuncionario.jsp">
                Numero da Conta de Saida: <input type="text" name="contaSaida"><br><br>
                Numero da Conta de Destino: <input type="text" name="contaDestino"><br><br>
                Valor (R$): <input type="text" name="valor"><br><br>
                <input type="submit" value="Efetuar Transferencia">
            </form>
        </h1>
    </body>
    
    <% 
        if (request.getMethod().equals("POST")) {
            
            QuerysBd bd = new QuerysBd();
            String ContaDestino = request.getParameter("contaDestino");
            String ContaSaida = request.getParameter("contaSaida");
            
            ClassConta cc = bd.getConta(ContaSaida);
            
            
            double qtd = Double.parseDouble(request.getParameter("valor"));
           
            double saldo = cc.getSaldo();
            if(qtd > saldo) {
                out.println("<br>Saldo Insuficiente para a Transferencia!<br>");
            }
            else {
                ClassConta transfer = bd.getConta(ContaDestino);
                if(transfer == null) {
                    out.println("<br>Conta inexistente!<br><br>");
                }
                else {
                    //if(transfer.getNumero.isEqual(cc.getNumero))
                    bd.goTransferencia(cc.getNumero(), transfer.getNumero(), qtd);
                    out.println("<br>Transferencia efetuada com sucesso!!!!!<br>");
                    out.println("<br><i>Conta: " + transfer.getNumero() + "</i><br>");
                    out.println("<i>Primeiro Correntista: " + transfer.getPrimeiroCorr()+ "</i><br>");
                    out.println("<i>Segundo Correntista: " + transfer.getSegundoCorr()+ "</i><br>");
                    out.println("<i>Terceiro Correntista: " + transfer.getTerceiroCorr()+ "</i><br>");
                }
            }
            
            
            
        }
    %>
</html>
