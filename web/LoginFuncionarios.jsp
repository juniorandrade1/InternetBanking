<%-- 
    Document   : LoginFuncionarios
    Created on : 27/04/2016, 19:51:11
    Author     : Júnior

--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acesso Funcionarios</title>
    </head>
    <body>
        <fieldset>
            <legend>Acesso Funcionarios</legend>
            <form id="LoginFuncionarios" method="post" action="/InternetBanking/ProcessaLogins">
                Username: <input type="text" name="username"><br><br>
                Numero da Conta: <input type="text" name="numero"><br><br>
                Senha: <input type="password" name="senha"><br><br>
                <input type="hidden" name="formName" value="LoginFuncionarios">
                <input type="submit" value="Efetuar Login">
            </form>
        </fieldset>
        <br>
    </body>
</html>
