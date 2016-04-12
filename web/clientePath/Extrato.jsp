<%-- 
    Document   : Extrato
    Created on : 06/04/2016, 16:22:42
    Author     : Júnior
--%>
<%@page import="java.io.IOException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Extrato</title>
    </head>
    
        <h1>Ola Senhor(a) ${Correntista.nome} </h1><br>
        <h2>Entre com o periodo desejado do extrato:</h2><br>
        <fieldset>
            <legend>Periodo</legend>
            
            <form id="Periodo" method="POST" action="Extrato.jsp">
                Data Inicial (dd/mm/aaaa): <input type="text" name="data"><br><br>
                
                Intervalo: <input type="text" name="intervalo"><br><br>
                
                <input type="submit" value="Consultar">
            </form>
            
        </fieldset>
        
        <% 
            if (request.getMethod().equals("POST")) {
                //BDQuerys bd;
                String data = request.getParameter("data");
                String intervalo = request.getParameter("intervalo");
                int dia = (data.charAt(0) - '0') * 10 + data.charAt(1) - '0';
                int mes = (data.charAt(3) - '0') * 10 + data.charAt(4) - '0';
                int ano = (data.charAt(6) - '0') * 1000 + (data.charAt(7) - '0') * 100 + (data.charAt(8) - '0') * 10 + data.charAt(9) - '0';
                
            }
        %>
    
</html>
