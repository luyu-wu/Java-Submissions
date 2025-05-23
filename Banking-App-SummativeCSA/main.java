public class main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        account student = new account(2012, "John");
        student.takeLoan(21039);

        System.out.println(student.getBalance());
    }
}
