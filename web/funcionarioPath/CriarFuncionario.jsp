<%@page import="Model.ClassLogged"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Funcionario</title>
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
        <h1>Ola Senhor(a) ${Funcionario.nome}, funcionario do tipo ${Funcionario.funcao} </h1>
        <h1>
            <b>Nova Conta para Funcionario</b><br>
        </h1>
        
        <form id="CriarContaFuncionario" method="POST" action="/InternetBanking/NovoFuncionario">     
            Nome: <input type="text" name="nome"><br><br>
            Email: <input type="text" name="email"><br><br>
            Função: <input type="text" name="funcao"><br><br>
            Senha: <input type="text" name="senha"><br><br>
            <input type="submit" value="Criar conta">
        </form>
        <%
            }
        %>
    </body>
</html>
