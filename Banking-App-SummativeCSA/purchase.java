import java.util.Date;

public class purchase {

    private account vendorAcc;
    private account buyerAcc;
    private double amount;
    private String purchaseDescription;
    private Date date;

    /**
     * Creates a new purchase transaction
     * @param amount The monetary amount of the purchase
     * @param vendorAcc The account of the vendor/seller
     * @param buyerAcc The account of the buyer
     * @param purchaseDescription A description of what was purchased
     */
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

    /**
     * Gets the monetary amount of this purchase
     * @return The amount as a double
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns a string representation of the purchase
     * @return A formatted string containing purchase details
     */
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
