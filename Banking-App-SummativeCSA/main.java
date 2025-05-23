public class main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        loan newLoan = new loan(1.00, 1.02);
        account student = new account(2012, "John");
        //System.out.println(student.readFile("Data/JohnLOANHISTORY.txt"));
        // student.takeLoan(21039);
        //System.out.println(student.readFile("Data/JohnLOANHISTORY.txt"));
        student.saveLoan(newLoan);
        System.out.println(student.getBalance());
    }
}
