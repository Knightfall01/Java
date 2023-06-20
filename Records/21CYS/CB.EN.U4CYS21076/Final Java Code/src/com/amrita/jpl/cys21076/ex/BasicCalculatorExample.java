package com.amrita.jpl.cys21076.ex;

import java.util.Scanner;

interface Calculator {
    double add(double num1, double num2);
    double subtract(double num1, double num2);
    double multiply(double num1, double num2);
    double divide(double num1, double num2) throws ArithmeticException;
}

class BasicCalculator implements Calculator {
    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double divide(double num1, double num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero error!");
        }
        return num1 / num2;
    }
}


public class BasicCalculatorExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        // System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        Calculator calculator = new BasicCalculator();

        double addition = calculator.add(num1, num2);
        double subtraction = calculator.subtract(num1, num2);
        double multiplication = calculator.multiply(num1, num2);
        double division;
        try {
            division = calculator.divide(num1, num2);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        System.out.println("Addition: " + addition);
        System.out.println("Subtraction: " + subtraction);
        System.out.println("Multiplication: " + multiplication);
        System.out.println("Division: " + division);
    }
}

