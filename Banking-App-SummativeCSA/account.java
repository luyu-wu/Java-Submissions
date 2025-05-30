import java.io.File;
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
     *
     * @param birthYear The year of birth for the account holder
     * @param firstName The first name of the account holder
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

    /**
     * Gets the current balance of the account.
     *
     * @return The current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets the first name of the account holder.
     *
     * @return The account holder's first name
     */
    public String getName() {
        return firstName;
    }

    /**
     * Makes a purchase from a vendor.
     *
     * @param vendor The vendor account receiving the payment
     * @param amount The amount of the purchase
     * @param purchaseDescription Description of what was purchased
     * @return true if purchase was successful, false if insufficient funds
     */
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

    /**
     * Saves a purchase to the purchase history file.
     *
     * @param Purchase The purchase to save
     */
    public void savePurchase(purchase Purchase) {
        try {
            FileWriter writer = new FileWriter(purchaseFileName, true);
            writer.write(encryptKey.encode(Purchase.toString() + "\n"));
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Saves a loan to the loan history file.
     *
     * @param Loan The loan to save
     */
    public void saveLoan(loan Loan) {
        try {
            FileWriter writer = new FileWriter(loanFileName, true);
            writer.write(encryptKey.encode(Loan.toString()) + "\n"); // Appended write to the loan file
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Recursively extracts purchase amounts from a string representation.
     *
     * @param str The string containing purchase data
     * @param purchasesSoFar List to store extracted purchase amounts
     */
    private void recurseStringPurchases(
        String str,
        ArrayList<Double> purchasesSoFar
    ) {
        int start_ind = str.indexOf("\n");
        int end_ind = str.indexOf("\n", start_ind + 1);
        if (start_ind != -1 && end_ind != -1) { // If the string is not ending
            double value = Double.parseDouble(
                str.split("\\|")[0].split(":")[1] // Find the first column of the string seperator, and the portion after semicolon
            );
            purchasesSoFar.add(value);
            if (str.length() > 5) {
                recurseStringPurchases(
                    str.substring(end_ind - 1),
                    purchasesSoFar
                );
            }
        }
    }

    /**
     * Recursively searches for a purchase with specific value.
     *
     * @param str The string to search in
     * @param Value The purchase value to find
     * @return The description of the found purchase or "COULD NOT FIND" if not found
     */
    private String recurseFindPurchase(String str, double Value) {
        int start_ind = str.indexOf("\n");
        int end_ind = str.indexOf("\n", start_ind + 1);
        if (start_ind != -1 && end_ind != -1) {
            double price = Double.parseDouble(
                str.split("\\|")[0].split(":")[1]
            );
            if (price == Value) {
                return str
                    .substring(start_ind, end_ind)
                    .split("\\|")[4].split(":")[1]; // Same logic as above, but with the fourth column
            } else {
                return recurseFindPurchase(str.substring(end_ind - 1), Value);
            }
        } else {
            return "COULD NOT FIND";
        }
    }

    /**
     * Finds a purchase by its value.
     *
     * @param Value The value of the purchase to find
     * @return The description of the found purchase
     */
    public String findPurchase(double Value) {
        return recurseFindPurchase(this.readFile(purchaseFileName), Value);
    }

    /**
     * Reads all purchases from the purchase history file.
     *
     * @return List of purchase amounts
     */
    public ArrayList<Double> readPurchases() {
        String file = readFile(purchaseFileName);
        ArrayList<Double> values = new ArrayList<Double>();
        recurseStringPurchases(file, values);
        return values;
    }

    /**
     * Returns a sorted list of purchases in descending order.
     *
     * @return Sorted list of purchase amounts
     */
    public ArrayList<Double> sortedPurchases() {
        ArrayList<Double> purchases = readPurchases();
        int n = purchases.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (purchases.get(j) > purchases.get(minIndex)) {
                    minIndex = j;
                }
            }

            Double temp = purchases.get(minIndex);
            purchases.set(minIndex, purchases.get(i));
            purchases.set(i, temp);
        }

        return purchases;
    }

    /**
     * Reads and decrypts a file.
     *
     * @param name The name of the file to read
     * @return The decrypted contents of the file
     */
    public String readFile(String name) {
        try {
            File file = new File(name);
            Scanner scan = new Scanner(file);
            String encrypted = "";
            while (scan.hasNextLine()) {
                encrypted = encrypted + scan.nextLine() + "\n";
            }
            scan.close();
            return encryptKey.decode(encrypted);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Processes a purchase and updates the vendor's balance.
     *
     * @param purchase The purchase to process
     */
    public void purchaseAPI(purchase purchase) {
        this.savePurchase(purchase);
        this.balance += purchase.getAmount();
    }

    /**
     * Returns an array of sorted loans.
     *
     * @return Array of loans in sorted order
     */
    public loan[] sortedLoans() {
        String string = readFile(loanFileName);
        String[] lines = string.split("\n");
        loan[] loans = new loan[lines.length];

        return loans;
    }

    /**
     * Internal method to handle loan processing.
     *
     * @param amount The loan amount
     * @param interest The interest rate as a decimal (e.g., 1.10 for 10% interest)
     */
    protected void loanBackend(double amount, double interest) {
        loan newLoan = new loan(amount, interest, this);
        saveLoan(newLoan);
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
