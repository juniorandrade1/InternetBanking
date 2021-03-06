package Sources;

import Model.ClassConta;
import Model.ClassCorrentista;
import Model.ClassFuncionario;
import Model.ClassTransacao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class QuerysBd {
    public QuerysBd(){};
    
    private final String getLogin = "select * from CONTA, CORRENTISTA where Email = ? and Senha = ? and Numero = ? and (Primeiro_Corr = CPF or Segundo_Corr = CPF or Terceiro_Corr = CPF)";
    private final String getLoginFunc = "select * from FUNCIONARIO where Codigo = ? and Email = ? and Senha = ?";
    
    private final String getConta = "select * from CONTA where Numero = ?";
   
    private final String getContaCorr1 = "select * from CONTA where Primeiro_Corr = ?";
    private final String getContaCorr2 = "select * from CONTA where Primeiro_Corr = ? and Segundo_Corr = ?";
    private final String getContaCorr3 = "select * from CONTA where Primeiro_Corr = ? and Segundo_Corr = ? and Terceiro_Corr = ?";
    
    private final String getCorrentista = "select * from CORRENTISTA where CPF = ?";
    private final String getFuncionario = "select * from FUNCIONARIO where Codigo = ?";
    private final String getFuncionario2 = "select * from FUNCIONARIO where Nome = ? and Email = ? and Funcao = ? and Senha = ?";
    
    private final String setSaldo = "update CONTA set saldo = saldo + ? where Numero = ?";
    
    private final String updateTransacaoTransf = "insert into TRANSACAO (Tipo, Nro_Conta, Nro_Conta_Transf, Valor) values(?, ?, ?, ?)";
    private final String getAllExtrato = "select * from TRANSACAO where Nro_Conta = ? or Nro_Conta_Transf = ?";
    
    
    private final String insertCorrentista = "insert into CORRENTISTA (Nome, CPF, Endereco, Email, Senha) values (?,?,?,?,?)";
    private final String insertLogins = "insert into LOGINS (numeroConta, username, senha, CPF) values (?, ?,?,?)";
    
    private final String insertConta1 = "insert into CONTA (Primeiro_Corr, Saldo, Limite) values(?,?,?)";
    private final String insertConta2 = "insert into CONTA (Primeiro_Corr, Segundo_Corr, Saldo, Limite) values(?,?,?,?)";
    private final String insertConta3 = "insert into CONTA (Primeiro_Corr, Segundo_Corr, Terceiro_Corr, Saldo, Limite) values(?,?,?,?,?)";
    
    private final String insertFunc = "insert into FUNCIONARIO (Nome, Email, Funcao, Senha) values(?,?,?,?)";
    
    private PreparedStatement pstmt;
    private PreparedStatement aux;
   
    
    public String verifyInfo(String username, String senha, String numero, int option) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bdquerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(option == 0) { 
            String s;
            try (Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "")) {
                pstmt = (PreparedStatement) c.prepareStatement(getLogin);
                pstmt.setString(1, username);
                pstmt.setString(2, senha);
                pstmt.setString(3, numero);

                ResultSet rs = pstmt.executeQuery();
                s = null;
                while(rs.next()) s = rs.getString("CPF");
            }
            return s;
        }
        else {
            String s;
            try (Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "")) {
                pstmt = (PreparedStatement) c.prepareStatement(getLoginFunc);
                pstmt.setString(1, numero);
                pstmt.setString(2, username);
                pstmt.setString(3, senha);

                ResultSet rs = pstmt.executeQuery();
                s = null;
                while(rs.next()) s = rs.getString("Codigo");
            }
            return s;
        }
    }    
    public ClassConta getConta(String numero) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bdquerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClassConta cc;
        try (Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "")) {
            pstmt = (PreparedStatement) c.prepareStatement(getConta);
            pstmt.setString(1, numero);
            ResultSet rs = pstmt.executeQuery();
            cc = null;
            while(rs.next()) {
                String Numero = numero, PrimeiroCorr = rs.getString(2), SegundoCorr = rs.getString(3), TerceiroCorr = rs.getString(4);
                double Saldo = rs.getDouble(5), Limite = rs.getDouble(6);
                cc = new ClassConta(Numero, PrimeiroCorr, SegundoCorr, TerceiroCorr, Saldo, Limite);
            }
        }
        return cc;
    } 
    public ClassConta getConta(String pCorr, String sCorr, String tCorr) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bdquerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClassConta cc;
        try (Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "")) {
            if(pCorr != null && sCorr != null && tCorr != null) {
                pstmt = (PreparedStatement) c.prepareStatement(getContaCorr3);
                pstmt.setString(1, pCorr);
                pstmt.setString(2, sCorr);
                pstmt.setString(3, tCorr);
            }
            else if(pCorr != null && sCorr != null) {
                pstmt = (PreparedStatement) c.prepareStatement(getContaCorr2);
                pstmt.setString(1, pCorr);
                pstmt.setString(2, sCorr);
            }
            else {
                pstmt = (PreparedStatement) c.prepareStatement(getContaCorr1);
                pstmt.setString(1, pCorr);
            }
            
            ResultSet rs = pstmt.executeQuery();
            cc = null;
            while(rs.next()) {
                String Numero = rs.getString(1), PrimeiroCorr = rs.getString(2), SegundoCorr = rs.getString(3), TerceiroCorr = rs.getString(4);
                double Saldo = rs.getDouble(5), Limite = rs.getDouble(6);
                cc = new ClassConta(Numero, PrimeiroCorr, SegundoCorr, TerceiroCorr, Saldo, Limite);
            }
        }
        return cc;
    } 
    public ClassCorrentista getCorrentista(String CPF) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bdquerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClassCorrentista cc;
        try (Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "")) {
            pstmt = (PreparedStatement) c.prepareStatement(getCorrentista);
            pstmt.setString(1, CPF);
            ResultSet rs = pstmt.executeQuery();
            cc = new ClassCorrentista("", "", "", "", "", "");
            while(rs.next()) {
                String Nome = rs.getString("Nome"), Endereco = rs.getString("Endereco"), Email = rs.getString("Email");
                String Senha = rs.getString("Senha");
               
                cc.setCPF(CPF);
                cc.setNome(Nome);
                cc.setEndereco(Endereco);
                cc.setEmail(Email);
                cc.setSenha(Senha);
            }
        }
        return cc;
    }
    public ClassFuncionario getFuncionario(String CPF) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bdquerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClassFuncionario cc;
        try (Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "")) {
            pstmt = (PreparedStatement) c.prepareStatement(getFuncionario);
            pstmt.setString(1, CPF);
            ResultSet rs = pstmt.executeQuery();
            cc = null;
            while(rs.next()) {
                String cpf = CPF, Nome = rs.getString(2), Endereco = rs.getString(3), Email = rs.getString(4);   
                String Senha = rs.getString(5);
                cc = new ClassFuncionario(cpf, Nome, Endereco, Email, Senha);
            }
        }
        return cc;
    } 
    public void updateTransferencia(String a, String b, String cc, double e) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bdquerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "")) {
            pstmt = (PreparedStatement) c.prepareStatement(updateTransacaoTransf);
            System.out.println("Transacao");
            
            pstmt.setString(1, a);
            pstmt.setString(2, b);
            pstmt.setString(3, cc);
            pstmt.setDouble(4, e);
            pstmt.execute();
        }
    }  
    public void updateSaldo(String conta, double value) throws SQLException, Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bdquerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "")) {
            ClassConta cc = getConta(conta);
            if(cc.getSaldo() + value < -cc.getLimite()) {
                throw new Exception("Saldo Insuficiente");
            }       
            
            pstmt = (PreparedStatement) c.prepareStatement(setSaldo);
            pstmt.setDouble(1, value);
            pstmt.setString(2, conta);
            pstmt.execute();
            
        }
    }
    public void goTransferencia(String from, String to, double w) throws SQLException, Exception {
        updateSaldo(from, -w);
        updateSaldo(to, w);
        updateTransferencia("transf", from, to, w);
    }
    public ArrayList<ClassTransacao> getAllExtrato(String conta) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bdquerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<ClassTransacao> arr;
        try (Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "")) {
            pstmt = (PreparedStatement) c.prepareStatement(getAllExtrato);
            pstmt.setString(1, conta);
            pstmt.setString(2, conta);
            ResultSet rs = pstmt.executeQuery();
            arr = new ArrayList<>();
            while(rs.next()) {
                String Codigo = rs.getString(1);
                String Tipo = rs.getString(2);
                String NroConta = rs.getString(3);
                String NroContaTransf = rs.getString(4);
                double Valor = rs.getDouble(5);
                arr.add(new ClassTransacao(Codigo, Tipo, NroConta, NroContaTransf, Valor));
            }
        }
        return arr;
    } 
    public void createCorrentista(String Nome, String CPF, String Endereco, String Email, String Senha) throws SQLException {
         try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bdquerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<ClassTransacao> arr;
        try (Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "")) {
            pstmt = (PreparedStatement) c.prepareStatement(insertCorrentista);
            pstmt.setString(1, Nome);
            pstmt.setString(2, CPF);
            pstmt.setString(3, Endereco);
            pstmt.setString(4, Email);
            pstmt.setString(5, Senha);
            pstmt.execute(); 
        }
    }
    public void createLogins(String numeroConta, String Username, String Senha, String CPF) throws SQLException {
         try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bdquerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<ClassTransacao> arr;
        try (Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "")) {
            pstmt = (PreparedStatement) c.prepareStatement(insertLogins);
            pstmt.setString(1, numeroConta);
            pstmt.setString(2, Username);
            pstmt.setString(3, Senha);
            pstmt.setString(4, CPF);
            pstmt.execute(); 
        }
    } 
    public void createUser(String Nome, String CPF, String Endereco, String Email, String Senha) throws SQLException {
        //System.out.println(Nome + " " + CPF + " " + Endereco + " " + Email);
        createCorrentista(Nome, CPF, Endereco, Email, Senha);
    }
    public void createConta(String pC, String sC, String tC, double valor, double limite) throws SQLException  {
         try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bdquerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "")) {
            System.out.println(pC + " " + sC + " " + tC);
            
            if(sC == null) {
                pstmt = (PreparedStatement) c.prepareStatement(insertConta1);
                pstmt.setString(1, pC);
                pstmt.setDouble(2, valor);
                pstmt.setDouble(3, limite);
            }
            else if(tC == null) {
                pstmt = (PreparedStatement) c.prepareStatement(insertConta2);
                pstmt.setString(1, pC);
                pstmt.setString(2, sC);
                pstmt.setDouble(3, valor);
                pstmt.setDouble(4, limite);
            }
            else {
                pstmt = (PreparedStatement) c.prepareStatement(insertConta3);
                pstmt.setString(1, pC);
                pstmt.setString(2, sC);
                pstmt.setString(3, tC);
                pstmt.setDouble(4, valor);
                pstmt.setDouble(5, limite);
            }
            pstmt.execute();   
        }
    }
    void goSaque(String numero, Double valor) throws SQLException, Exception {
        updateSaldo(numero, -valor);
        updateTransferencia("saque", numero, null, valor);
    }
    void goDeposito(String numero, Double valor) throws SQLException, Exception {
        updateSaldo(numero, valor);
        updateTransferencia("deposito", numero, null, valor);
    }

    void createFunc(String Nome, String Email, String Funcao, String Senha) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bdquerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<ClassTransacao> arr;
        try (Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "")) {
            pstmt = (PreparedStatement) c.prepareStatement(insertFunc);
            pstmt.setString(1, Nome);
            pstmt.setString(2, Email);
            pstmt.setString(3, Funcao);
            pstmt.setString(4, Senha);
            pstmt.execute(); 
        }
    }
    
    ClassFuncionario getFuncionario2(String Nome, String Email, String Funcao, String Senha) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bdquerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClassFuncionario f = null;
        try (Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/JAVABANK", "root", "")) {
            pstmt = (PreparedStatement) c.prepareStatement(getFuncionario2);
            pstmt.setString(1, Nome);
            pstmt.setString(2, Email);
            pstmt.setString(3, Funcao);
            pstmt.setString(4, Senha);
            ResultSet rs = pstmt.executeQuery(); 
            while(rs.next()) {
                String codigo = rs.getString(1);
                String nome = rs.getString(2);
                String endereco = rs.getString(3);
                String email = rs.getString(4);
                String senha = rs.getString(5);
                f = new ClassFuncionario(codigo, nome, endereco, email, senha);
            }
        }
        return f;
    }
}
