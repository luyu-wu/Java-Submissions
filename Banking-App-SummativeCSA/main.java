public class main {

    public static void main(String[] args) {
        account student = new account(2012, "John");
        //System.out.println(student.readFile("Data/JohnLOANHISTORY.txt"));
        student.takeLoan(21039);
        System.out.println(student.getBalance());
    }
}
