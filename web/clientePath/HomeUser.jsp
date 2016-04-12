    <%-- 
    Document   : HomeUser
    Created on : 06/04/2016, 14:49:45
    Author     : Júnior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Ola Senhor(a) ${Correntista.nome}, conta ${Conta.numero} </h1><br>
        <a href="clientePath/TransferenciaUsuario.jsp">Realizar Transferencia</a><br>
        <a href="Saldo.jsp">Verificar Saldo</a><br>
        <a href="Extrato.jsp">Verificar Extrato</a><br>
    </body>
</html>
