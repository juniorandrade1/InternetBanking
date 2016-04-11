
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Júnior
 */
public class ClassConta implements Serializable{
    private String Numero, PrimeiroCorr, SegundoCorr, TerceiroCorr;
    private double Saldo, Limite;
    public ClassConta(String a, String b, String c, String d, double e, double f) {
       this.Numero = a;
       this.PrimeiroCorr = b;
       this.SegundoCorr = c;
       this.TerceiroCorr = d;
       this.Saldo = e;
       this.Limite = f;
   }
   public void setNumero(String s){ this.Numero = s; }
   public void setPrimeiroCorr(String s){ this.PrimeiroCorr = s; }
   public void setSegundoCorr(String s){ this.SegundoCorr = s; }
   public void setTerceiroCorr(String s){ this.TerceiroCorr = s; }
   public void setSaldo(double x){ this.Saldo = x; }
   public void setLimite(double x){ this.Limite = x; }
   
   public String getNumero(){ return this.Numero; }
   public String getPrimeiroCorr(){ return this.PrimeiroCorr; }
   public String getSegundoCorr(){ return this.SegundoCorr; }
   public String getTerceiroCorr(){ return this.TerceiroCorr; }
   public double getSaldo(){ return this.Saldo; }
   public double getLimite(){ return this.Limite; }
}
