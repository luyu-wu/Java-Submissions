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
    private Date birthdate;
    private String firstName;

    // Dynamic data
    private double balance;
    private String purchaseFileName;
    private String loanFileName;

    private encrypt encryptKey;

    /**
     * Default constructor for creating a new account.
     */
    public account(int birthYear, String firstName) {
        this.birthdate = new Date(birthYear);
        this.firstName = firstName;
        this.balance = 0;
        purchaseFileName = "Data/" + firstName + "PURCHASEHISTORY.txt";
        loanFileName = "Data/" + firstName + "LOANHISTORY.txt";

        int nameKey = 0;
        for (int i = 0; i < firstName.length(); i++) {
            nameKey += (int) firstName.charAt(i); // Convert name into a unique integer key (AI generated strategy)
        }
        encryptKey = new encrypt(nameKey);

        // Create necessary files
        try {
            File f1 = new File(loanFileName);
            File f2 = new File(purchaseFileName);
            if (f1.createNewFile() && f2.createNewFile()) {
                System.out.println(
                    "File created: " + f1.getName() + ", " + f2.getName()
                );
            } else {
                System.out.println("Files already created.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return firstName;
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
            writer.write(
                readFile(loanFileName) +
                encryptKey.encode(Loan.toString()) +
                "\n"
            );
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String readFile(String name) {
        try {
            File file = new File(name);
            Scanner scan = new Scanner(file);
            String encrypted = "";
            while (scan.hasNextLine()) {
                encrypted = encrypted + scan.nextLine() + "\n";
            }
            scan.close();
            return encrypted;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void purchaseAPI(purchase purchase) {
        this.savePurchase(purchase);
        this.balance += purchase.getAmount();
    }

    public loan[] sortedLoans() {
        String string = readFile(loanFileName);
        String[] lines = string.split("\n");
        loan[] loans = new loan[lines.length];
        for (int i = 0; i < lines.length; i++) {
            loans[i] = new loan(1.00, 1.01);
        }
        return loans;
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
        System.out.println("Loan of $" + amount + " taken successfully!");
    }

    /**
     * Take a standard loan with default interest rate.
     *
     * @param amount The loan amount
     */
    public void takeLoan(double amount) {
        this.loanBackend(amount, 1.10);
    }
}
