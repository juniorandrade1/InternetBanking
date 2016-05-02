/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Júnior
 */
public class ClassLogged {
    boolean log;
    public ClassLogged(){ log = true; }

    public ClassLogged(boolean b) {
        this.log = b;
    }
    public void setLog(boolean s) {
        this.log = s;
    }
    public boolean getLog() {
        return this.log;
    }
}
