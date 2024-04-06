package com.example.calculadora30;

public class Fibonacci {
    public static float fibonacci(float n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
