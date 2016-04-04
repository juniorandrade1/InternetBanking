<%-- 
    Document   : CriarConta
    Created on : 04/04/2016, 18:20:43
    Author     : Júnior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tela de Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form id="conta" method="POST" action="/InternetBanking/TelaUsu_rioComum">
            <p>Primeiro Correntista: <input type="text" name="corrA" size="40"></p>
            <p>Segundo Correntista: <input type="text" name="corrB" size="40"></p>
            <p>Terceiro Correntista: <input type="text" name="corrC" size="40"></p>
            <p>Saldo Inicial: <input type="text" name="saldo" size="40"></p>
            <p>Limite: <input type="text" name="limite" size="40"></p>
            <p><input type="submit" value="Submit"/>
        </form>
    </body>
</html>
