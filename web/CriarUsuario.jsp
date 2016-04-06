<%-- 
    Document   : CriarUsuario
    Created on : 06/04/2016, 17:43:57
    Author     : Júnior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form id="CriarUsuario" method="POST" action="NovoUsuario">     
            CPF: <input type="text" name="CPF"><br><br>
            Nome: <input type="text" name="nome"><br><br>
            Endereco: <input type="text" name="endereco"><br><br>
            Email: <input type="text" name="email"><br><br>
            <input type="submit" value="Criar Conta">
        </form>
    </body>
</html>
