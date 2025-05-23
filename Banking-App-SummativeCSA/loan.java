import java.util.Date;

public class loan {

    private double amount;
    private double interestRate;
    private Date date;

    public loan(double amount, double interestRate) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.date = new Date();
    }

    public double getAmount() {
        return amount;
    }

    public void pay(account account, double pay) {
        purchase payback = new purchase(-pay, account, account, "Loan Payment");

        account.purchaseAPI(payback);
        amount -= pay;
    }

    public String toString() {
        return (
            "AMOUNT:" + amount + "|INTEREST:" + interestRate + "|DATE:" + date
        );
    }
}
