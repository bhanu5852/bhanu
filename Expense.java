package expensetrackingsystem.java;



import java.util.Date;

public class Expense {
    private String description;
    private double amount;
    private Date date;

    public Expense(String description, double amount, Date date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f on %s", description, amount, date.toString());
    }
}



	

