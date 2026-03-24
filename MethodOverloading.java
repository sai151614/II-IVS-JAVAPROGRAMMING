class Calculator {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to add two doubles
    public double add(double a, double b) {
        return a + b;
    }

    // Method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method to add an array of integers
    public int add(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}

public class MethodOverloading {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Add two ints: " + calc.add(5, 10));
        System.out.println("Add two doubles: " + calc.add(5.5, 10.5));
        System.out.println("Add three ints: " + calc.add(1, 2, 3));
        System.out.println("Add array: " + calc.add(new int[]{1, 2, 3, 4, 5}));
    }
}