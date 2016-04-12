package Sources;


import java.io.Serializable;

public class ClassCorrentista implements Serializable{   
   private String CPF;
   private String Nome;
   private String Endereco;
   private String Email;
   
   public ClassCorrentista() {
       this.CPF = "";
       this.Nome = "";
       this.Endereco = "";
       this.Email = "";
   }
   public ClassCorrentista(String CPF, String Nome, String Endereco, String Email) {
       this.CPF = CPF;
       this.Nome = Nome;
       this.Endereco = Endereco;
       this.Email = Email;
   }
   public void setCPF(String s){ this.CPF = s; }
   public void setNome(String s){ this.Nome = s; }
   public void setEndereco(String s){ this.Endereco = s; }
   public void setEmail(String s){ this.Email = s; }
   
   public String getCPF(){ return this.CPF; }
   public String getNome(){ return this.Nome; }
   public String getEndereco(){ return this.Endereco; }
   public String getEmail(){ return this.Email; }
   
}
