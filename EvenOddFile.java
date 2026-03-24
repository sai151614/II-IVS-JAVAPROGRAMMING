import java.io.*;
import java.util.*;

public class EvenOddFile {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            // Create File Writers
            FileWriter evenFile = new FileWriter("Even.txt");
            FileWriter oddFile = new FileWriter("Odd.txt");

            System.out.println("Enter how many numbers:");
            int n = sc.nextInt();

            System.out.println("Enter " + n + " numbers:");

            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();

                if (num % 2 == 0) {
                    evenFile.write(num + "\n");  // Write even numbers
                } else {
                    oddFile.write(num + "\n");   // Write odd numbers
                }
            }

            // Close files
            evenFile.close();
            oddFile.close();

            System.out.println("Numbers successfully written to files!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}