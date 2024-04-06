package com.example.calculadora30;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {


    private float valor1;
    private float valor2;
    private TextView resultado;
    private String operacion;
    private float confirmar;
    private View regresar;
    private ImageView regresarImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        resultado = findViewById(R.id.respuesta);



        Calculadora calculadora = (Calculadora) getIntent().getSerializableExtra("Per");

        valor1 = Float.parseFloat(calculadora.getValor1());
        valor2 = Float.parseFloat(calculadora.getValor2());
        operacion = calculadora.getOperacion();

        regresarImg = (ImageView) findViewById(R.id.imageView9);
        regresarImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });

        regresar = findViewById(R.id.regresarBtn);
        regresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });

        switch (operacion.toLowerCase()) {
            case "suma":
                 confirmar = Suma.sumar(valor1, valor2);
                break;
            case "resta":
                 confirmar = Resta.restar(valor1, valor2);
                break;
            case "multiplicacion":
                 confirmar = Multiplicacion.CalcularProducto(valor1, valor2);
                break;
            case "division":
                 confirmar = Division.Dividir(valor1, valor2);
                break;
            case "factorial":
                 confirmar = Factorial.calcularFactorial(valor1);
                break;
            case "potencia":
                 confirmar = Potencia.calcularPotencia(valor1, valor2);
                break;
            case "fibonacci":
                 confirmar = Fibonacci.fibonacci(valor1);
                break;
        }

        if (confirmar==Float.parseFloat(calculadora.getResultado()))
            resultado.setText(confirmar+"");


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}