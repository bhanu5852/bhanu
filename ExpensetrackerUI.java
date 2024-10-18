package expensetrackingsystem.java;


	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.util.Objects;

	public class ExpensetrackerUI extends JFrame {
	    
		private Expensetracker tracker;
	    private JTextField descriptionField;
	    private JTextField amountField;
	    private DefaultListModel<Expense> expenseListModel;
	    private JList<Expense> expenseList;

	    public ExpensetrackerUI() {
	        tracker = new Expensetracker();
	        expenseListModel = new DefaultListModel<>();

	        setTitle("Expense Tracker");
	        setSize(400, 300);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());

	        // Input Panel
	        JPanel inputPanel = new JPanel();
	        inputPanel.setLayout(new FlowLayout());

	        descriptionField = new JTextField(15);
	        amountField = new JTextField(10);
	        JButton addButton = new JButton("Add Expense");
	        JButton deleteButton = new JButton("Delete Expense");

	        inputPanel.add(new JLabel("Description:"));
	        inputPanel.add(descriptionField);
	        inputPanel.add(new JLabel("Amount:"));
	        inputPanel.add(amountField);
	        inputPanel.add(addButton);
	        inputPanel.add(deleteButton);

	        add(inputPanel, BorderLayout.NORTH);

	        // Expense List
	        expenseList = new JList<>(expenseListModel);
	        add(new JScrollPane(expenseList), BorderLayout.CENTER);

	        // Button Actions
	        addButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String description = descriptionField.getText();
	                double amount;
	                try {
	                    amount = Double.parseDouble(amountField.getText());
	                    tracker.addExpense(description, amount);
	                    updateExpenseList();
	                    descriptionField.setText("");
	                    amountField.setText("");
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(null, "Invalid amount");
	                }
	            }
	        });

	        deleteButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int selectedIndex = expenseList.getSelectedIndex();
	                if (selectedIndex != -1) {
	                    tracker.removeExpense(selectedIndex);
	                    updateExpenseList();
	                } else {
	                    JOptionPane.showMessageDialog(null, "Select an expense to delete");
	                }
	            }
	        });
	    }

	    private void updateExpenseList() {
	        expenseListModel.clear();
	        for (Expense expense : tracker.getExpenses()) {
	            expenseListModel.addElement(expense);
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            ExpensetrackerUI ui = new ExpensetrackerUI();
	            ui.setVisible(true);
	        });
	    }

		@Override
		public String toString() {
			return "Expensetrackerui [tracker=" + tracker + ", descriptionField=" + descriptionField + ", amountField="
					+ amountField + ", expenseListModel=" + expenseListModel + ", expenseList=" + expenseList + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(amountField, descriptionField, expenseList, expenseListModel, tracker);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ExpensetrackerUI other = (ExpensetrackerUI) obj;
			return Objects.equals(amountField, other.amountField)
					&& Objects.equals(descriptionField, other.descriptionField)
					&& Objects.equals(expenseList, other.expenseList)
					&& Objects.equals(expenseListModel, other.expenseListModel)
					&& Objects.equals(tracker, other.tracker);
		}
	}


