package com.example.calculadora30;

public class Potencia {

    public static float calcularPotencia(float base, float exponente) {
        if (exponente == 0) {
            return 1; // Cualquier número elevado a 0 es 1
        } else if (exponente == 1) {
            return base; // La potencia de cualquier número a la 1 es el mismo número
        } else if (exponente > 0) {
            return Multiplicacion.CalcularProducto(base, calcularPotencia(base, exponente - 1)); // Recursión para calcular la potencia
        } else {
            return 1 / (int) Multiplicacion.CalcularProducto(base, calcularPotencia(base, -exponente - 1)); // Manejo de exponentes negativos
        }
    }

}
