import java.util.Scanner;

public class FibonacciEvenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = sc.nextInt();
        long sum = 0;
        int a = 1, b = 1;
        while (a <= N) {
            if (a % 2 == 0) {
                sum += a;
            }
            int temp = a + b;
            a = b;
            b = temp;
        }
        System.out.println("Sum of even Fibonacci numbers up to " + N + " is: " + sum);
    }
}