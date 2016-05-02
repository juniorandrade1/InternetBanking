

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <a href="/InternetBanking/clientePath/HomeUser.jsp">Home</a><br>
        
         <a href="/InternetBanking/Logoff">Logoff</a><br>
        <h1>Ola Senhor(a) ${Correntista.nome}, conta ${Conta.numero} </h1><br>
        <a href="/InternetBanking/clientePath/TransferenciaUsuario.jsp">Realizar Transferencia</a><br>
        <a href="/InternetBanking/clientePath/Saldo.jsp">Verificar Saldo</a><br>
        <a href="/InternetBanking/clientePath/Extrato.jsp">Verificar Extrato</a><br>
    </body>
</html>
