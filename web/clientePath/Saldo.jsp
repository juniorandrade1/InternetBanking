
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saldo</title>
    </head>
    <body>
        <a href="/InternetBanking/clientePath/HomeUser.jsp">Home</a><br>
         <a href="/InternetBanking/Logoff">Logoff</a><br>
        <h1>Ola Senhor(a) ${Correntista.nome}</h1><br>
        <h1>Seu saldo é de ${Conta.saldo} </h1><br>
    </body>
</html>
