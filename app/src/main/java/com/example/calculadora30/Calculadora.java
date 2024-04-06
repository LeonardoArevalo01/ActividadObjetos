package com.example.calculadora30;

import java.io.Serializable;

public class Calculadora implements Serializable {
    String valor1;
    String Valor2;
    String Operacion;
    String Resultado;

    public Calculadora() {
    }

    public Calculadora(String valor1, String valor2, String operacion, String resultado) {
        this.valor1 = valor1;
        Valor2 = valor2;
        Operacion = operacion;
        Resultado = resultado;
    }

    public String getValor1() {
        return valor1;
    }

    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }

    public String getValor2() {
        return Valor2;
    }

    public void setValor2(String valor2) {
        Valor2 = valor2;
    }

    public String getOperacion() {
        return Operacion;
    }

    public void setOperacion(String operacion) {
        Operacion = operacion;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String resultado) {
        Resultado = resultado;
    }
}