public class main {

    public static void main(String[] args) {
        // Create a account from a AI written template file
        account account = accountParser.createAccountFromFile("john_info.txt");

        // Take a loan out on the account, which writes to encrypted files with a purchase from the bank, and a loan record
        account.takeLoan(30);

        // Print the new balance of the account.
        System.out.println(account.getBalance());

        // Print an array of all of the past purchases of the person, selection sorted
        System.out.println(account.sortedPurchases());

        // Print the description of the largest purchase the person has made.
        System.out.println(
            account.findPurchase(account.sortedPurchases().get(0))
        );
    }
}
