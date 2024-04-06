package com.example.calculadora30;

public class Factorial {
    public static float calcularFactorial(float n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calcularFactorial(n - 1); // Llamada recursiva para calcular el factorial
        }
    }
}
