
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
         <form id="funcExtrato" method="post" action="/InternetBanking/goSaque">
                Numero Conta: <input type="text" name="numero"><br><br>
                Valor do Saque: <input type="text" name="valor"><br><br>
                
                <input type="submit" value="Realizar transação">   
        </form>
    </body>
</html>
