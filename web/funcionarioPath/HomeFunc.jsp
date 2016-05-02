<%@page import="Model.ClassLogged"%>
<%@page import="Model.ClassFuncionario"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
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
        <% 
            ClassFuncionario func = (ClassFuncionario) request.getSession().getAttribute("Funcionario");
            String type = func.getFuncao();
            if(type.compareTo("gerente") == 0) {
                %>
                    <a href="/InternetBanking/funcionarioPath/CriarCorrentista.jsp">Criar Correntista</a><br>
                    <a href="/InternetBanking/funcionarioPath/CriarConta.jsp">Criar Conta</a><br>
                <%
            }
        %>     

        <a href="/InternetBanking/funcionarioPath/Saque.jsp">Realizar Saque</a><br>
        <a href="/InternetBanking/funcionarioPath/Deposito.jsp">Realizar Deposito</a><br>
        <a href="/InternetBanking/funcionarioPath/TransferenciaFuncionario.jsp">Realizar Transferencia</a><br>
        <a href="/InternetBanking/funcionarioPath/SaldoFuncionario.jsp">Verificar Saldo</a><br>
        <a href="/InternetBanking/funcionarioPath/ExtratoFuncionario.jsp">Verificar Extrato</a><br>
        <%
            }
        %>
    </body>
</html>