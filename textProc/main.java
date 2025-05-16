import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class main {

    public static void main(String[] args) {
        try {
            File file = new File("text.txt");
            Scanner scan = new Scanner(file);
            String string = "";
            int lineNum = 1;
            while (scan.hasNextLine()) {
                lineNum++;
                string = string + scan.nextLine() + "\n";
            }
            string = string.concat(
                lineNum + " ermmmmmmmi dont wanna doo this" + "\n"
            );
            System.out.println(string);
            scan.close();

            try {
                FileWriter writer = new FileWriter("text.txt");
                writer.write(string);
                writer.close();
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
