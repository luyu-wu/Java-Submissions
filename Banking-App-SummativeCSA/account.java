import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a bank account with user information and financial data.
 */
public class account {

    // User information
    private String passportNumber;
    private Date birthdate;

    // Dynamic data
    private double balance;
    private ArrayList<loan> loans;
    private ArrayList<purchase> purchaseHistory;

    /**
     * Default constructor for creating a new account.
     */
    public account(String passportNumString, int birthYear) {
        this.passportNumber = passportNumString;
        this.birthdate = new Date(birthYear);
        this.balance = 0;
        this.loans = new ArrayList<loan>();
        this.purchaseHistory = new ArrayList<purchase>();
    }

    public boolean purchase(account vendor, double amount) {
        purchase currentPurchase = new purchase(amount, vendor, this);
        if (this.balance < amount) {
            return false;
        } else {
            this.balance -= amount;
            this.purchaseHistory.add(currentPurchase);

            vendor.purchaseAPI(currentPurchase);
            return true;
        }
    }

    public void purchaseAPI(purchase purchase) {
        this.purchaseHistory.add(purchase);
        this.balance += purchase.getAmount();
    }

    /**
     * Internal method to handle loan processing.
     *
     * @param amount The loan amount
     * @param interest The interest rate as a decimal (e.g., 1.10 for 10% interest)
     */
    protected void loanBackend(double amount, double interest) {
        loan newLoan = new loan(amount, interest);
        this.loans.add(newLoan);
        this.balance += amount;
    }

    /**
     * Take a standard loan with default interest rate.
     *
     * @param amount The loan amount
     */
    public void takeLoan(double amount) {
        System.out.println("Loan of $" + amount + " taken successfully!");
        this.loanBackend(amount, 1.10);
    }
}
