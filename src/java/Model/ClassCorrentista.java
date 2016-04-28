package Model;


import java.io.Serializable;

public class ClassCorrentista implements Serializable{   
   private String CPF;
   private String Nome;
   private String Endereco;
   private String Email;
   private String Username;
   private String Senha;
   
   public ClassCorrentista() {
       this.CPF = "";
       this.Nome = "";
       this.Endereco = "";
       this.Email = "";
       this.Username = "";
       this.Senha = "";
   }
   public ClassCorrentista(String CPF, String Nome, String Endereco, String Email, String Username, String Senha) {
       this.CPF = CPF;
       this.Nome = Nome;
       this.Endereco = Endereco;
       this.Email = Email;
       this.Username = Username;
       this.Senha = Senha;
   }
   
   public void setCPF(String s){ this.CPF = s; }
   public void setNome(String s){ this.Nome = s; }
   public void setEndereco(String s){ this.Endereco = s; }
   public void setEmail(String s){ this.Email = s; }
   public void setUsername(String s){ this.Username = s; }
   public void setSenha(String s){ this.Senha = s; }
   
   public String getCPF(){ return this.CPF; }
   public String getNome(){ return this.Nome; }
   public String getEndereco(){ return this.Endereco; }
   public String getEmail(){ return this.Email; }
   public String getUsername(){ return this.Username; }
   public String getSenha(){ return this.Senha; }
}
