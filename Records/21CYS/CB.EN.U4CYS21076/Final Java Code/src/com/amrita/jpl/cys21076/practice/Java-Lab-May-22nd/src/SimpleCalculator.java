import java.util.Scanner;

abstract class Calculators {
    protected static double num1;
    protected static double num2;

    public Calculators(double num1, double num2) {
        Calculators.num1 = num1;
        Calculators.num2 = num2;
    }

    public static double calculate() {
        return 0;
    }

    public static void displayResult() {
        double result = calculate();
        System.out.println("Result: " + result);
    }
}

class Adding extends Calculators {
    public Adding(double num1, double num2) {
        super(num1, num2);
    }

    public static double calculate() {
        return num1 + num2;
    }
}

class Subtracting extends Calculators {
    public Subtracting(double num1, double num2) {
        super(num1, num2);
    }

    public static double calculate() {
        return num1 - num2;
    }
}

class Multiplying extends Calculators {
    public Multiplying(double num1, double num2) {
        super(num1, num2);
    }

    public static double calculate() {
        return num1 * num2;
    }
}

class Dividing extends Calculators {
    public Dividing(double num1, double num2) {
        super(num1, num2);
    }

    public static double calculate() {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new ArithmeticException("Cannot divide by zero!");
        }
    }
}

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter the operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        Calculator calculator;

        switch (operation) {
            case '+' -> calculator = (Calculator) new Adding(num1, num2);
            case '-' -> calculator = (Calculator) new Subtracting(num1, num2);
            case '*' -> calculator = (Calculator) new Multiplying(num1, num2);
            case '/' -> calculator = (Calculator) new Dividing(num1, num2);
            default -> {
                System.out.println("Invalid operation!");
                return;
            }
        }

        Calculators.displayResult();

        scanner.close();
    }
}
