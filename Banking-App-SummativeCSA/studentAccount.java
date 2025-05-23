import java.util.Calendar;

/**
 * Represents a student account with special loan conditions.
 */
public class studentAccount extends account {

    public studentAccount(int birthYear, String firstName) {
        super(birthYear, firstName);
        if (Calendar.getInstance().get(Calendar.YEAR) - birthYear > 18) { // Deprecated but idk why
            throw new IllegalArgumentException(
                "Student must be under 18 years old"
            );
        }
    }

    /**
     * Take a student loan with zero interest.
     *
     * @param amount The loan amount
     */
    public void takeStudentLoan(double amount) {
        this.loanBackend(amount, 0.00);
    }

    /**
     * Overrides the standard loan with a reduced interest rate for students.
     *
     * @param amount The loan amount
     */
    @Override
    public void takeLoan(double amount) {
        this.loanBackend(amount, 1.05);
    }
}
