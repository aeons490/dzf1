package fm;
public class Transaction {  
    private String description;  
    private double amount;  
    private boolean isIncome;  
  
    public Transaction(String description, double amount, boolean isIncome) {  
        this.description = description;  
        this.amount = amount;  
        this.isIncome = isIncome;  
    }  
  
    public String getDescription() {  
        return description;  
    }  
  
    public double getAmount() {  
        return amount;  
    }  
  
    public boolean isIncome() {  
        return isIncome;  
    }  
  
    @Override  
    public String toString() {  
        return (isIncome ? "收入" : "支出") + ": " + description + " - " + amount + "元";  
    }  
}