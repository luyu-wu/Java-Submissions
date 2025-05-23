/**
 * Represents a student account with special loan conditions.
 */
public class studentAccount extends Account {

    /**
     * Take a student loan with zero interest.
     *
     * @param amount The loan amount
     */
    public void takeStudentLoan(int amount) {
        this.loanBackend(amount, 0.00);
    }

    /**
     * Overrides the standard loan with a reduced interest rate for students.
     *
     * @param amount The loan amount
     */
    @Override
    public void takeLoan(int amount) {
        this.loanBackend(amount, 1.05);
    }
}
