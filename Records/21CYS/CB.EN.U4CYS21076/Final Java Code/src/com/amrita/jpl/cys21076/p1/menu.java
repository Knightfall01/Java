package com.amrita.jpl.cys21076.p1;
import java.util.Scanner;


// The Menu class provides a basic menu-driven program.
public class menu {
    public static void main(String[] args){
        Scanner This = new Scanner(System.in);
        System.out.println("Enter one of the following :");
        int choice = 0;
        do {
            System.out.println("1. Factorial (1)");
            System.out.println("2. Fibonacci (2)");
            System.out.println("3. The Sum of 'n' numbers (3)");
            System.out.println("4. Prime numbers Test (4)");
            System.out.println("5. Exit (5) ");
            choice = This.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter a number: ");
                    int number = This.nextInt();
                    if (number < 0) {
                        System.out.println("Error 1 : Negative or Zero as values cannot be accepted for factorization.");
                        break;
                    }
                    System.out.println("Factorial of the number " + number + " is " + fact(number));
                    // The fact method calculates the factorial of a given number.
                }
                case 2 -> {
                    System.out.println("Enter the limit for the generation of fibonacci series :");
                    int limit = This.nextInt();
                    if (limit < 0) {
                        System.out.println("Error 2 : Negative or Zero as values cannot be accepted as limit for the fibonacci series generation. ");
                        break;
                    }
                    System.out.println("The fibonacci series :");
                    fibo(limit);
                    // The fibo method prints out the Fibonacci series up to a given number of terms.
                }
                case 3 -> {
                    System.out.println("Enter the number of  terms that you want to find the sum of :");
                    int count = This.nextInt();
                    if (count < 0) {
                        System.out.println("Error 3 : Negative or Zero as values cannot be accepted as number of terms to be added.");
                        break;
                    }
                    System.out.println("The sum of " + count + "is" + sum_n_no(count));
                    // The sumN method calculates the sum of the first n numbers.
                }
                case 4 -> {
                    System.out.println("Enter a number to check its primality");
                    int primeornot = This.nextInt();
                    if (primeornot < 0) {
                        System.out.println("Error 4 : Negative numbers cannot accepted for primality test.");
                        break;
                    }
                    if (prime_test(primeornot)) {
                        System.out.println("The given number " + primeornot + "is" + " a prime number");
                    } else {
                        System.out.println("The given number " + primeornot + "is" + " not a prime number");
                    }
                    break;
                    // The primeTest method checks if a given number is prime.
                }

                case 5 -> {
                    System.out.println("Exiting");
                    break;
                }
            }
        } while (choice != 0);
    }
    public static int fact(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void fibo(int count) {
        int a = 0;
        int b = 1;
        for (int i = 1; i <= count; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }

    public static int sum_n_no (int count) {
        int sum = 0;
        for ( int i = 0 ; i <= count ; i++){
            sum += i;
        }
        return sum;
    }

    public static  boolean prime_test (int primeornot){
        if (primeornot == 1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(primeornot); i++) {
            if (primeornot % i == 0) {
                return false;
            }
        }
        return true;
    }
}


