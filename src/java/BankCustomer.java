
import java.io.Serializable;


public class BankCustomer implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String id, firstName, lastName, type;
    private double balance;

    public BankCustomer(String id, String firstName, String lastName, double balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.type = "user";
    }
    
    public BankCustomer(String id, String firstName, String lastName, String type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = 0;
        this.type = type;
    }
    
    public String getId() { return this.id; }
    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public double getBalance() { return this.balance; }
    public double getBalanceNoSign() { return (Math.abs(this.balance));  }
    public String getType() { return this.type; }
    
    public void setId(String s) { this.id = s; }
    public void setFirstName(String s) { this.firstName = s; }
    public void setLastName(String s) { this.lastName = s; }
    public void setBalance(double s) { this.balance = s; }
    public void setType(String s) { this.type = s; }
}
