    <%@page import="Sources.ClassFuncionario"%>
<%-- 
    Document   : HomeFunc
    Created on : 06/04/2016, 14:49:45
    Author     : Júnior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Ola Senhor(a) ${Funcionario.nome}, funcionario do tipo ${Funcionario.funcao} </h1><br>
        <% 
            ClassFuncionario func = (ClassFuncionario) request.getSession().getAttribute("Funcionario");
            String type = func.getFuncao();
            if(type.compareTo("gerente") == 0) {
                %>
                    <a href="funcionarioPath/CriarCorrentista.jsp">Criar Correntista</a><br>
                    <a href="funcionarioPath/CriarConta.jsp">Criar Conta</a><br>
                <%
            }
        %>     
       
        <a href="funcionarioPath/TransferenciaFuncionario.jsp">Realizar Transferencia</a><br>
        <a href="funcionarioPath/SaldoFuncionario.jsp">Verificar Saldo</a><br>
        <a href="funcionarioPath/ExtratoFuncionario.jsp">Verificar Extrato</a><br>
    </body>
</html>