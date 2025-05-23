/**
 * Represents a bank account with user information and financial data.
 */
public class account {

    // User information
    private int userID;
    private String passportNumber;
    private int birthdate;

    // Dynamic data
    private int balance;
    private ArrayList<loan> loans;
    private ArrayList<purchase> purchaseHistory;

    /**
     * Default constructor for creating a new account.
     */
    public account() {
        this.balance = 0;
        this.loans = new ArrayList<Loan>();
        this.purchaseHistory = new ArrayList<Purchase>();
    }

    public boolean purchase (account vendor, int amount) {
        if (this.balance < amount) {
            return false;
        } else {
            this.balance -= amount;


        }
    }

    /**
     * Internal method to handle loan processing.
     *
     * @param amount The loan amount
     * @param interest The interest rate as a decimal (e.g., 1.10 for 10% interest)
     */
    protected void loanBackend(int amount, double interest) {

    }

    /**
     * Take a standard loan with default interest rate.
     *
     * @param amount The loan amount
     */
    public void takeLoan(int amount) {
        this.loanBackend(amount, 1.10);
    }
}    public boolean purchase (account vendor, int amount) {    public boolean purchase (account vendor, int amount) {
