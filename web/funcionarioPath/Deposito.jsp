<%-- 
    Document   : ExtratoFuncionario
    Created on : 08/04/2016, 03:02:24
    Author     : Júnior
--%>

<%@page import="java.io.IOException"%>
<%@page import="java.io.IOException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Saque</title>
    </head>
    <body>
        <h1>Ola Senhor(a) ${Funcionario.nome}, funcionario do tipo ${Funcionario.funcao} </h1><br>
         <form id="funcDeposito" method="post" action="/InternetBanking/goDeposito">
                Numero Conta: <input type="text" name="numero"><br><br>
                Valor do Deposito: <input type="text" name="valor"><br><br>
                
                <input type="submit" value="Realizar transação">   
        </form>
    </body>
</html>
