package Model;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class ClassFuncionario implements Serializable{
   private String Codigo, Nome, Email, Funcao;
   public ClassFuncionario(String a, String b, String c, String d) {
       this.Codigo = a;
       this.Nome = b;
       this.Email = c;
       this.Funcao = d;
   }
   public void setCodigo(String s){ this.Codigo = s; }
   public void setNome(String s){ this.Nome = s; }
   public void setEmail(String s){ this.Email = s; }
   public void setFuncao(String s){ this.Funcao = s; }
   public String getCodigo(){ return this.Codigo; }
   public String getNome(){ return this.Nome; }
   public String getEmail(){ return this.Email; }
   public String getFuncao(){ return this.Funcao; }
}
