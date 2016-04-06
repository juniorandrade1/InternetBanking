<%-- 
    Document   : Transferencia
    Created on : 06/04/2016, 16:22:24
    Author     : Júnior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transferencia</title>
    </head>
    <body>
        <h1>
            <form id="TransferenciaUsuario" method="POST" action="RealizarTransferencia">
                Numero da Conta de Destino: <input type="text" name="contaDest"><br><br>
                Valor (R$): <input type="text" name="valor"><br><br>
                <input type="submit" value="Efetuar Transferencia">
                <input type="hidden" value="usuario" name="tipo">
            </form>
        </h1>
    </body>
</html>
