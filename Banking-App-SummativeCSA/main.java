public class main {

    public static void main(String[] args) {
        account account = accountParser.createAccountFromFile("john_info.txt");
        //System.out.println(student.readFile("Data/JohnLOANHISTORY.txt"));
        account.takeLoan(30);
        System.out.println(account.getBalance());
        System.out.println(account.sortedPurchases());
        System.out.println(
            account.findPurchase(account.sortedPurchases().get(0))
        );
    }
}
