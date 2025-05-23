import java.util.Date;

public class purchase {

    private account vendorAcc;
    private account buyerAcc;
    private double amount;
    private String purchaseDescription;
    private Date date;

    public purchase(
        double amount,
        account vendorAcc,
        account buyerAcc,
        String purchaseDescription
    ) {
        this.amount = amount;
        this.vendorAcc = vendorAcc;
        this.buyerAcc = buyerAcc;
        this.purchaseDescription = purchaseDescription;
        this.date = new Date();
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        return (
            "AMOUNT:" +
            amount +
            "|VENDOR:" +
            vendorAcc.getName() +
            "|BUYER:" +
            buyerAcc.getName() +
            "|DATE:" +
            date +
            "|DESCRIPTION:" +
            purchaseDescription
        );
    }
}
