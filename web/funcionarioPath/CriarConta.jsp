<%-- 
    Document   : CriarConta
    Created on : 06/04/2016, 17:26:46
    Author     : Júnior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Conta</title>
    </head>
    <body>
        <h1>
            <b>Nova Conta</b><br>
            <h2>
            <br>Insira o CPF dos correntistas. Caso não exista, será<br>
            disponibilizada a opção de criação. Campos de correntista<br>
            em branco serão considerados como não existente.<br>
            <br></h2>
        </h1>
        <form id="CriarConta" method="POST" action="NovaConta">     
            Primeiro Correntista: <input type="text" name="priCorr"><br><br>
            Segundo Correntista: <input type="text" name="segCorr"><br><br>
            Terceiro Correntista: <input type="text" name="terCorr"><br><br>
            Saldo: <input type="text" name="saldo"><br><br>
            Limite: <input type="text" name="limite"><br><br>
            <input type="submit" value="Criar Conta">
        </form>
    </body>
</html>