

<%@page import="Model.ClassLogged"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.IOException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Saldo</title>
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
         <form id="funcSaldo" method="post" action="/InternetBanking/getSaldoFunc">
                Numero Conta <input type="text" name="codigo"><br><br>
                <input type="submit" value="Pesquisar">   
        </form>
    <%
            }
        %>
    </body>
</html>
