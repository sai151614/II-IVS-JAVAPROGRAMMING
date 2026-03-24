import java.util.*;

public class MultipleCatchDemo {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter first number:");
            int a = sc.nextInt();

            System.out.println("Enter second number:");
            int b = sc.nextInt();

            int result = a / b;   // may cause ArithmeticException

            int arr[] = {10, 20, 30};
            System.out.println(arr[5]); // may cause ArrayIndexOutOfBoundsException

            System.out.println("Result: " + result);
        }

        catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is out of range!");
        }

        catch (Exception e) {
            System.out.println("General Exception occurred!");
        }

        finally {
            System.out.println("Execution completed (finally block)");
        }
    }
}