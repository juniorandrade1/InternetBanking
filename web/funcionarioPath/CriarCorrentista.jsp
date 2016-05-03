

<%@page import="Model.ClassLogged"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Correntista</title>
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
        <form id="CriarCorrentista" method="POST" action="/InternetBanking/NovoCorrentista">     
            Nome: <input type="text" name="Nome"><br><br>
            CPF: <input type="text" name="CPF"><br><br>
            Endereço: <input type="text" name="Endereco"><br><br>
            Email: <input type="text" name="Email"><br><br>
            Senha: <input type="text" name="Senha"><br><br>
            <input type="submit" value="Criar Correntista">
        </form>
        <%
            }
        %>
    </body>
</html>
