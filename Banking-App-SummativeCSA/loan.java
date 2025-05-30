import java.util.Date;

/**
 * Represents a loan with an amount, interest rate, and creation date.
 */
public class loan {

    private double amount;
    private double interestRate;
    private Date date;

    /**
     * Creates a new loan with the specified amount and interest rate.
     * The loan amount is immediately disbursed to the provided account.
     *
     * @param amount The principal amount of the loan
     * @param interestRate The interest rate of the loan
     * @param account The account to disburse the loan to
     */
    public loan(double amount, double interestRate, account account) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.date = new Date();
        purchase pay = new purchase(amount, account, account, "Loan Payment");
        account.purchaseAPI(pay);
    }

    /**
     * Gets the current outstanding amount of the loan.
     *
     * @return The current loan balance
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Makes a payment towards the loan balance from the specified account.
     *
     * @param account The account making the loan payment
     * @param pay The payment amount
     */
    public void pay(account account, double pay) {
        purchase payback = new purchase(-pay, account, account, "Loan Payment");

        account.purchaseAPI(payback);
        amount -= pay;
    }

    /**
     * Returns a string representation of the loan including amount, interest rate and date.
     *
     * @return String containing the loan details
     */
    public String toString() {
        return (
            "AMOUNT:" + amount + "|INTEREST:" + interestRate + "|DATE:" + date
        );
    }
}
