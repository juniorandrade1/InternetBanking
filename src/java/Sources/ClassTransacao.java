/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sources;

import java.io.Serializable;

/**
 *
 * @author Júnior
 */
public class ClassTransacao implements Serializable{
    private String Codigo;
    private String Tipo;
    private String NroConta;
    private String NroContaTransf;
    private double Valor;
    
    public ClassTransacao() {};
    public ClassTransacao(String a, String b, String c, String d, double e) {
        this.Codigo = a;
        this.Tipo = b;
        this.NroConta = c;
        this.NroContaTransf = d;
        this.Valor = e;
    }
    
    public ClassTransacao(String a, String b, String c, double e) {
        this.Codigo = a;
        this.Tipo = b;
        this.NroConta = c;
        this.NroContaTransf = null;
        this.Valor = e;
    }
    
    
    
    public String getCodigo(){ return this.Codigo; };
    public String getTipo(){ return this.Tipo; };
    public String getNroConta(){ return this.NroConta; };
    public String getNroContaTransf(){ return this.NroContaTransf; };
    public double getValor(){ return this.Valor; };
    
    public void setCodigo(String s){ this.Codigo = s; };
    public void setTipo(String s){ this.Tipo = s; };
    public void setNroConta(String s){ this.NroConta = s; };
    public void setNroContaTransf(String s){ this.NroContaTransf = s; };
    public void setValor(double s){ this.Valor = s; };
    
}
