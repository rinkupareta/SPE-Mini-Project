package com.devops;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public double squareRoot(double num) {
        double result = Math.sqrt(num);
        logger.info("Square root of {} is {}", num, result);
        return result;
    }

    public long factorial(int num) {
        if (num < 0) {
            logger.error("Factorial is not defined for negative numbers: {}", num);
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        logger.info("Factorial of {} is {}", num, fact);
        return fact;
    }

    public double naturalLog(double num) {
        if (num <= 0) {
            logger.error("Logarithm is not defined for zero or negative numbers: {}", num);
            throw new IllegalArgumentException("Logarithm is not defined for zero or negative numbers");
        }
        double result = Math.log(num);
        logger.info("Natural log of {} is {}", num, result);
        return result;
    }

    public double power(double x, double b) {
        double result = Math.pow(x, b);
        logger.info("{} raised to the power {} is {}", x, b, result);
        return result;
    }
}
