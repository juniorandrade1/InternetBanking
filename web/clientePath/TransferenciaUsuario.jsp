<%-- 
    Document   : Transferencia
    Created on : 06/04/2016, 16:22:24
    Author     : Júnior
--%>

<%@page import="Sources.BDQuerys"%>
<%@page import="Sources.ClassConta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transferencia</title>
    </head>
    <body>
        <h1>
            <h2>Ola Senhor(a) ${Correntista.nome}, conta numero ${Conta.numero}</h2>
            <a href="HomeUser.jsp"><i>Home</i></a><br><br>
            <form id="TransferenciaUsuario" method="POST" action="TransferenciaUsuario.jsp">
                Numero da Conta de Destino: <input type="text" name="contaDest"><br><br>
                Valor (R$): <input type="text" name="valor"><br><br>
                <input type="submit" value="Efetuar Transferencia">
            </form>
        </h1>
    </body>
    
    <% 
        if (request.getMethod().equals("POST")) {
            BDQuerys bd = new BDQuerys();
            String numeroConta = request.getParameter("contaDest");
            double qtd = Double.parseDouble(request.getParameter("valor"));
            Object conta = request.getSession().getAttribute("Conta");
            ClassConta cc = (ClassConta) conta;
            double saldo = cc.getSaldo();
            if(qtd > saldo) {
                out.println("<br>Saldo Insuficiente para a Transferencia!<br>");
            }
            else {
                ClassConta transfer = bd.getConta(numeroConta);
                if(transfer == null) {
                    out.println("<br>Conta inexistente!<br><br>");
                }
                else {
                    //if(transfer.getNumero.isEqual(cc.getNumero))
                    bd.goTransferencia(cc.getNumero(), numeroConta, qtd);
                    out.println("<br>Transferencia efetuada com sucesso!!!!!<br>");
                    out.println("<br><i>Conta: " + cc.getNumero() + "</i><br>");
                    out.println("<i>Primeiro Correntista: " + cc.getPrimeiroCorr()+ "</i><br>");
                    out.println("<i>Segundo Correntista: " + cc.getSegundoCorr()+ "</i><br>");
                    out.println("<i>Terceiro Correntista: " + cc.getTerceiroCorr()+ "</i><br>");
                }
            }
            
            
            
        }
    %>
</html>
