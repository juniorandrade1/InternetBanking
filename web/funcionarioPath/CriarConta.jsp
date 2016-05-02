

<%@page import="Model.ClassLogged"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Conta</title>
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
        <h1>
            <b>Nova Conta</b><br>
            <h2>
                <br>Insira o CPF de Correntistas Validos<br>
                O 1º Correntista é obrigatorio. Deixando os demais em branco, <br>
                será considerado como não existente.<br>
                <br>
            </h2>
        </h1>
        <form id="CriarConta" method="POST" action="/InternetBanking/NovaConta">     
            Primeiro Correntista: <input type="text" name="priCorr"><br><br>
            Segundo Correntista: <input type="text" name="segCorr"><br><br>
            Terceiro Correntista: <input type="text" name="terCorr"><br><br>
            Saldo: <input type="text" name="saldo"><br><br>
            Limite: <input type="text" name="limite"><br><br>
            <input type="submit" value="Criar Conta">
        </form>
        <%
            }
        %>
    </body>
</html>
