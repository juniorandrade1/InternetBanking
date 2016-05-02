

<%@page import="Model.ClassLogged"%>
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
        <%
            ClassLogged log = (ClassLogged) request.getSession().getAttribute("Logged");
            if(log.getLog() == false) {
                out.println("Você não está loggado!<br><br>");
                %><a href="/InternetBanking/Logoff">Sair</a><br><%
            }
            else {
        %>
        <a href="/InternetBanking/funcionarioPath/HomeFunc.jsp">Home</a><br>
         <a href="/InternetBanking/Logoff">Logoff</a><br>
        <h1>Ola Senhor(a) ${Funcionario.nome}, funcionario do tipo ${Funcionario.funcao} </h1><br>
            <form id="TransferenciaFuncionario" method="POST" action="TransferenciaFuncionario.jsp">
                Numero da Conta de Saida: <input type="text" name="contaSaida"><br><br>
                Numero da Conta de Destino: <input type="text" name="contaDestino"><br><br>
                Valor (R$): <input type="text" name="valor"><br><br>
                <input type="submit" value="Efetuar Transferencia">
            </form>
        <%
            }
        %>
    </body>
    
    <% 
        if (request.getMethod().equals("POST")) {
            
            QuerysBd bd = new QuerysBd();
            String ContaDestino = request.getParameter("contaDestino");
            String ContaSaida = request.getParameter("contaSaida");
            ClassConta cc = bd.getConta(ContaSaida);
            ClassConta transfer = bd.getConta(ContaDestino);
            if(cc == null || transfer == null) {
                out.println("<br><h1>Conta Inexixstente</h1>");
            }
            else {
                double qtd = Double.parseDouble(request.getParameter("valor"));
                double saldo = cc.getSaldo();
                double limite = cc.getLimite();
                if(qtd > saldo + limite) {
                    out.println("<br>Saldo Insuficiente para a Transferencia!<br>");
                }
                else {
                    try {
                        bd.goTransferencia(cc.getNumero(), transfer.getNumero(), qtd);
                        out.println("<br>Transferencia efetuada com sucesso!!!!!<br>");
                        out.println("<br><i>Conta: " + transfer.getNumero() + "</i><br>");
                        out.println("<i>Primeiro Correntista: " + transfer.getPrimeiroCorr()+ "</i><br>");
                        out.println("<i>Segundo Correntista: " + transfer.getSegundoCorr()+ "</i><br>");
                        out.println("<i>Terceiro Correntista: " + transfer.getTerceiroCorr()+ "</i><br>");
                    }
                    catch(Exception ex) {
                        out.println("<br><h1>Erro na transferencia</h1>");
                    }
                } 
            }
        }
    %>
</html>
