<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
    <HEAD>
        <TITLE>Tela de Login</TITLE>
        <LINK REL=STYLESHEET
              HREF="./bank-support/JSP-Styles.css"
              TYPE="text/css">
    </HEAD>
    <BODY>
        <fieldset>
            <legend>Tela de Login</legend>
            <form id="Login" method="get" action="ShowBalance">
                Username: <input type="text" name="username"><br><br>
                Numero da Conta: <input type="text" name="numero"><br><br>
                Senha: <input type="password" name="senha"><br><br>
                <input type="submit" value="Efetuar Login">
                
            </form>
            <form action="LoginFuncionarios">
                <input type="submit" value="Acesso para Funcionarios">
            </form>
        </fieldset>
        <br>
    </BODY>
</HTML>