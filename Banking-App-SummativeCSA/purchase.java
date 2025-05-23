public class purchase {

    account vendorAcc;
    account buyerAcc;
    double amount;

    public purchase(double amount, account vendorAcc, account buyerAcc) {
        this.amount = amount;
        this.vendorAcc = vendorAcc;
        this.buyerAcc = buyerAcc;
    }

    public double getAmount() {
        return amount;
    }
}
