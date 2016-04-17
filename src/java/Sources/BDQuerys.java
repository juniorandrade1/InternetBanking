package Sources;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Júnior
 */
public class BDQuerys {
    private String getLogin = "select * from LOGINS where username = ? and senha = ? and numeroConta = ?";
    private String getConta = "select * from CONTA where Numero = ?";
    private String getCorrentista = "select * from CORRENTISTA where CPF = ?";
    private String getFuncionario = "select * from FUNCIONARIO where Codigo = ?";
    private String setSaldo = "update CONTA set saldo = saldo + ? where Numero = ?";
    private String updateTransacaoTransf = "insert into TRANSACAO (Tipo, Nro_Conta, Nro_Conta_Transf, Valor) values(?, ?, ?, ?)";
    
    private PreparedStatement pstmt;    
  
    public String verifyInfo(String username, String senha, String numero) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDQuerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "");
        
        pstmt = (PreparedStatement) c.prepareStatement(getLogin);
        pstmt.setString(1, username);
        pstmt.setString(2, senha);
        pstmt.setString(3, numero);
        ResultSet rs = pstmt.executeQuery();
        
        String s = null;
        while(rs.next()) s = rs.getString(4);
        
        c.close();
        return s;
    }
    
    public ClassConta getConta(String numero) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDQuerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "");
        pstmt = (PreparedStatement) c.prepareStatement(getConta);
        pstmt.setString(1, numero);
        ResultSet rs = pstmt.executeQuery();
        ClassConta cc = null;
        while(rs.next()) {
            String Numero = numero, PrimeiroCorr = rs.getString(2), SegundoCorr = rs.getString(3), TerceiroCorr = rs.getString(4);
            double Saldo = rs.getDouble(5), Limite = rs.getDouble(6);
            cc = new ClassConta(Numero, PrimeiroCorr, SegundoCorr, TerceiroCorr, Saldo, Limite);
        }
        c.close();
        return cc;
    }
    
    public ClassCorrentista getCorrentista(String CPF) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDQuerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "");
        pstmt = (PreparedStatement) c.prepareStatement(getCorrentista);
        pstmt.setString(1, CPF);
        ResultSet rs = pstmt.executeQuery();
        ClassCorrentista cc = new ClassCorrentista("", "", "", "");
        while(rs.next()) { 
            String Nome = rs.getString("Nome"), Endereco = rs.getString("Endereco"), Email = rs.getString("Email");
            cc.setCPF(CPF);
            cc.setNome(Nome);
            cc.setEndereco(Endereco);
            cc.setEmail(Email);
        }
        c.close();
        return cc;
    }
    
    
    ClassFuncionario getFuncionario(String CPF) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDQuerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "");
        pstmt = (PreparedStatement) c.prepareStatement(getFuncionario);
        pstmt.setString(1, CPF);
        ResultSet rs = pstmt.executeQuery();
        ClassFuncionario cc = null;
        while(rs.next()) {
            String cpf = CPF, Nome = rs.getString(2), Endereco = rs.getString(3), Email = rs.getString(4);
            cc = new ClassFuncionario(cpf, Nome, Endereco, Email);   
        }
        c.close();
        return cc;
    }
    
    public void updateTransferencia(String a, String b, String cc, double e) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDQuerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "");
        pstmt = (PreparedStatement) c.prepareStatement(updateTransacaoTransf);
        pstmt.setString(1, a);
        pstmt.setString(2, b);
        pstmt.setString(3, cc);
        pstmt.setDouble(4, e);
        pstmt.execute();
        c.close();
        return;
    }
    
    
    public void updateSaldo(String conta, double value) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDQuerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "");
        pstmt = (PreparedStatement) c.prepareStatement(setSaldo);
        pstmt.setDouble(1, value);
        pstmt.setString(2, conta);
        pstmt.execute();
        c.close();
        return;
    }
    
    public void goTransferencia(String from, String to, double w) throws SQLException {
        updateSaldo(from, -w);
        updateSaldo(to, w);
        updateTransferencia("transf", from, to, w);
    }
}
