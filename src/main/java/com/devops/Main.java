package com.devops;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("Hello and Welcome to the scientific calculator !!!");
            System.out.println("Which operation would you like to perform?");
            System.out.println("1. Find the square root");
            System.out.println("2. Calculate the factorial of a number");
            System.out.println("3. Find natural log (base e) of a number");
            System.out.println("4. Calculate x to the power b");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            logger.info("User selected option: {}", choice);

            if (choice == 1) {
                System.out.print("Enter the number: ");
                double number = scanner.nextDouble();
                double ans = calculator.squareRoot(number);
                System.out.println("The square root of " + number + " is " + ans);
            } else if (choice == 2) {
                System.out.print("Enter the number: ");
                int number = scanner.nextInt();
                long ans = calculator.factorial(number);
                System.out.println("The factorial of " + number + " is " + ans);
            } else if (choice == 3) {
                System.out.print("Enter the number: ");
                double number = scanner.nextDouble();
                double ans = calculator.naturalLog(number);
                System.out.println("The natural log of " + number + " is " + ans);
            } else if (choice == 4) {
                System.out.print("Enter the number: ");
                double number = scanner.nextDouble();
                System.out.print("Enter the power: ");
                double power = scanner.nextDouble();
                double ans = calculator.power(number, power);
                System.out.println("The power of " + number + " is " + ans);
            } else if (choice == 5) {
                logger.info("User exited the calculator.");
                System.out.println("Exiting program...");
                System.exit(0);
            } else {
                logger.warn("Invalid choice entered: {}", choice);
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
