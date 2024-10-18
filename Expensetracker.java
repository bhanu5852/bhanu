package expensetrackingsystem.java;


	import java.util.ArrayList;
	import java.util.Date;

	public class Expensetracker {
	    private ArrayList<Expense> expenses;

	    public Expensetracker() {
	        expenses = new ArrayList<>();
	    }

	    public void addExpense(String description, double amount) {
	        expenses.add(new Expense(description, amount, new Date()));
	    }

	    public void removeExpense(int index) {
	        if (index >= 0 && index < expenses.size()) {
	            expenses.remove(index);
	        }
	    }

	    public ArrayList<Expense> getExpenses() {
	        return expenses;
	    }
	}


