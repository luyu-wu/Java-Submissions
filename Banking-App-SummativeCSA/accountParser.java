import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class accountParser {

    public static account createAccountFromFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            String firstName = null;
            int birthYear = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (
                    line.startsWith("firstName:") ||
                    line.startsWith("First Name:")
                ) {
                    firstName = line.split(":")[1].trim();
                } else if (
                    line.startsWith("birthYear:") ||
                    line.startsWith("Birth Year:")
                ) {
                    birthYear = Integer.parseInt(line.split(":")[1].trim());
                }
            }
            scanner.close();

            if (firstName == null) {
                throw new IllegalArgumentException(
                    "First name not found in file"
                );
            }

            account newAccount = new account(birthYear, firstName);
            return newAccount;
        } catch (FileNotFoundException e) {
            System.out.println("Account file not found: " + filePath);
            return null;
        } catch (Exception e) {
            System.out.println("Error parsing account file: " + e.getMessage());
            return null;
        }
    }
}
