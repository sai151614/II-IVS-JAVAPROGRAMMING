import java.util.Scanner;

public class PangramChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine().toLowerCase();
        boolean[] present = new boolean[26];
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                present[c - 'a'] = true;
            }
        }
        boolean isPangram = true;
        for (boolean b : present) {
            if (!b) {
                isPangram = false;
                break;
            }
        }
        if (isPangram) {
            System.out.println("The string is a pangram.");
        } else {
            System.out.println("The string is not a pangram.");
        }
    }
}