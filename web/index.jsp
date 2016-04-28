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
            <form id="Login" method="post" action="/InternetBanking/ProcessaLogins">
                Username: <input type="text" name="username"><br><br>
                Numero da Conta: <input type="text" name="numero"><br><br>
                Senha: <input type="password" name="senha"><br><br>
                <input type="hidden" name="formName" value="Login">
                <input type="submit" value="Efetuar Login">
                
            </form>
            <a href="LoginFuncionarios.jsp">
                <button>Acesso Funcionarios</button>
            </a>
            
        </fieldset>
        <br>
    </BODY>
</HTML>