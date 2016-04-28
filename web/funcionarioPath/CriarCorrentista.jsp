

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Correntista</title>
    </head>
    <body>
        
        <form id="CriarCorrentista" method="POST" action="/InternetBanking/NovoCorrentista">     
            Nome: <input type="text" name="Nome"><br><br>
            CPF: <input type="text" name="CPF"><br><br>
            Endereço: <input type="text" name="Endereco"><br><br>
            Email: <input type="text" name="Email"><br><br>
            Username: <input type="text" name="Username"><br><br>
            Senha: <input type="text" name="Senha"><br><br>
            <input type="submit" value="Criar Correntista">
        </form>
    </body>
</html>
