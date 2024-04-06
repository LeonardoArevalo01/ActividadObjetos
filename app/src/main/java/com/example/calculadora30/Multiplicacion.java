package com.example.calculadora30;

public class Multiplicacion {

    public static float CalcularProducto(float num1, float contador) {
        if (contador == 0) {
            return 0;
        } else if (contador > 0) {
            return num1 + CalcularProducto(num1, contador - 1);
        } else {
            return -CalcularProducto(num1, -contador);
        }
    }
}
