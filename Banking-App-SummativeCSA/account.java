import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Represents a bank account with user information and financial data.
 */
public class account {

    // User information
    private String passportNumber;
    private Date birthdate;
    private String firstName;

    // Dynamic data
    private double balance;
    private String purchaseFileName;
    private String loanFileName;

    private encrypt encryptKey = new encrypt((int) Math.random() * 1000);

    /**
     * Default constructor for creating a new account.
     */
    public account(String passportNumString, int birthYear, String firstName) {
        this.passportNumber = passportNumString;
        this.birthdate = new Date(birthYear);
        this.firstName = firstName;
        this.balance = 0;
        purchaseFileName = firstName + "PURCHASEHISTORY.txt";
        loanFileName = firstName + "LOANHISTORY.txt";

        // Create necessary files
        try {
            File f1 = new File(loanFileName);
            File f2 = new File(purchaseFileName);
            if (f1.createNewFile()) {
                System.out.println("File created: " + f1.getName());
            } else {
                System.out.println("File already exists.");
            }
            if (f2.createNewFile()) {
                System.out.println("File created: " + f2.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public boolean purchase(
        account vendor,
        double amount,
        String purchaseDescription
    ) {
        purchase currentPurchase = new purchase(
            amount,
            vendor,
            this,
            purchaseDescription
        );
        if (this.balance < amount) {
            return false;
        } else {
            this.balance -= amount;
            savePurchase(currentPurchase);
            vendor.purchaseAPI(currentPurchase);
            return true;
        }
    }

    public void savePurchase(purchase Purchase) {
        try {
            FileWriter writer = new FileWriter(purchaseFileName);
            writer.write(encryptKey.encode(Purchase.toString() + "\n"));
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveLoan(loan Loan) {
        try {
            FileWriter writer = new FileWriter(loanFileName);
            writer.write(encryptKey.encode(Loan.toString() + "\n"));
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void purchaseAPI(purchase purchase) {
        this.savePurchase(purchase);
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
        saveLoan(newLoan);
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
