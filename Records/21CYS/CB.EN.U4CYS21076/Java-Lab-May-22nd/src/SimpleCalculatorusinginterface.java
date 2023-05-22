import java.util.Scanner;

interface Calculator {
    double calculate(double num1, double num2);
}

class Add implements Calculator {
    public double calculate(double num1, double num2) {
        return num1 + num2;
    }
}

class Subtract implements Calculator {
    public double calculate(double num1, double num2) {
        return num1 - num2;
    }
}

class Multiply implements Calculator {
    public double calculate(double num1, double num2) {
        return num1 * num2;
    }
}

class Divide implements Calculator {
    public double calculate(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new ArithmeticException("Cannot divide by zero!");
        }
    }
}

public class SimpleCalculatorusinginterface {
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
            case '+':
                calculator = new Add();
                break;
            case '-':
                calculator = new Subtract();
                break;
            case '*':
                calculator = new Multiply();
                break;
            case '/':
                calculator = new Divide();
                break;
            default:
                System.out.println("Invalid operation!");
                return;
        }

        double result = calculator.calculate(num1, num2);
        System.out.println("Result: " + result);

        scanner.close();
    }
}
