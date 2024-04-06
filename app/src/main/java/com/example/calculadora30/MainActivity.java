package com.example.calculadora30;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText valor1;
    private EditText valor2;
    private String operacion;
    private float resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        valor1 = findViewById(R.id.numero1);
        valor2 = findViewById(R.id.numero2);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void sumar(View view){

        String textoValor1 = valor1.getText().toString();
        String textoValor2 = valor2.getText().toString();
        operacion= "suma";

        if (textoValor1.isEmpty() || textoValor2.isEmpty()) {
            // Mostrar una alerta de error indicando que algún campo está vacío
            mostrarAlertaError("Uno de los campos está vacío");
            cerrarTeclado();
            return; // Salir del método ya que no se puede realizar la suma
        }

        try {
            float r = Suma.sumar( Float.parseFloat(textoValor1), Float.parseFloat(textoValor2));
            String resultado = String.valueOf(r);

            Intent intent = new Intent(this, MainActivity2.class);
            Bundle bundle = new Bundle();
            Calculadora calculadora = new Calculadora(textoValor1, textoValor2, operacion, resultado);
            bundle.putSerializable("Per",calculadora);
            intent.putExtras(bundle);
            startActivity(intent);

        } catch (NumberFormatException e) {
            // Mostrar una alerta de error indicando que uno de los valores no es válido
            mostrarAlertaError("Uno de los valores no es válido");
            cerrarTeclado();
        }
    }




    public void restar(View view){
        String textoValor1 = valor1.getText().toString();
        String textoValor2 = valor2.getText().toString();
        operacion= "resta";

        if (textoValor1.isEmpty() || textoValor2.isEmpty()) {
            // Mostrar una alerta de error indicando que algún campo está vacío
            mostrarAlertaError("Uno de los campos está vacío");
            cerrarTeclado();
            return; // Salir del método ya que no se puede realizar
        }

        try {
            float r = Resta.restar( Float.parseFloat(textoValor1), Float.parseFloat(textoValor2));
            String resultado = String.valueOf(r);

            Intent intent = new Intent(this, MainActivity2.class);
            Bundle bundle = new Bundle();
            Calculadora calculadora = new Calculadora(textoValor1, textoValor2, operacion, resultado);
            bundle.putSerializable("Per",calculadora);
            intent.putExtras(bundle);
            startActivity(intent);


        } catch (NumberFormatException e) {
            // Mostrar una alerta de error indicando que uno de los valores no es válido
            mostrarAlertaError("Uno de los valores no es válido");
            cerrarTeclado();
        }


    }
    public void multiplicar(View view){
        String textoValor1 = valor1.getText().toString();
        String textoValor2 = valor2.getText().toString();
        operacion= "multiplicacion";

        if (textoValor1.isEmpty() || textoValor2.isEmpty()) {
            // Mostrar una alerta de error indicando que algún campo está vacío
            mostrarAlertaError("Uno de los campos está vacío");
            cerrarTeclado();
            return; // Salir del método ya que no se puede realizar
        }
        try {
            float r = Multiplicacion.CalcularProducto(Float.parseFloat(textoValor1), Float.parseFloat(textoValor2));
            String resultado = String.valueOf(r);

            Intent intent = new Intent(this, MainActivity2.class);
            Bundle bundle = new Bundle();
            Calculadora calculadora = new Calculadora(textoValor1, textoValor2, operacion, resultado);
            bundle.putSerializable("Per",calculadora);
            intent.putExtras(bundle);
            startActivity(intent);

        } catch (NumberFormatException e) {
            // Mostrar una alerta de error indicando que uno de los valores no es válido
            mostrarAlertaError("Uno de los valores no es válido");
            cerrarTeclado();
        }

    }
    public void dividir(View view){
        String textoValor1 = valor1.getText().toString();
        String textoValor2 = valor2.getText().toString();
        operacion= "division";

        if (textoValor1.isEmpty() || textoValor2.isEmpty()) {
            // Mostrar una alerta de error indicando que algún campo está vacío
            mostrarAlertaError("Uno de los campos está vacío");
            cerrarTeclado();
            return; // Salir del método ya que no se puede realizar
        }
        try {
            float r = Division.Dividir(Float.parseFloat(textoValor1), Float.parseFloat(textoValor2));
            String resultado = String.valueOf(r);

            Intent intent = new Intent(this, MainActivity2.class);
            Bundle bundle = new Bundle();
            Calculadora calculadora = new Calculadora(textoValor1, textoValor2, operacion, resultado);
            bundle.putSerializable("Per",calculadora);
            intent.putExtras(bundle);
            startActivity(intent);

        } catch (NumberFormatException e) {
            // Mostrar una alerta de error indicando que uno de los valores no es válido
            mostrarAlertaError("Uno de los valores no es válido");
            cerrarTeclado();
        }

    }
    public void factorial(View view){
        String textoValor1 = valor1.getText().toString();
        String textoValor2 = valor2.getText().toString();
        operacion= "factorial";

        if (textoValor1.isEmpty() && textoValor2.isEmpty()) {
            // Mostrar una alerta de error indicando que algún campo está vacío
            mostrarAlertaError("Los campos estan vacios");
            cerrarTeclado();
            return; // Salir del método ya que no se puede realizar
        } else if(!textoValor1.isEmpty() && !textoValor2.isEmpty()) {
            // Mostrar una alerta de error indicando que algún campo está vacío
            mostrarAlertaError("Solo usa un espacio");
            cerrarTeclado();
            return; // Salir del método ya que no se puede realizar
        }

        if(textoValor1.isEmpty()){
            textoValor1 = textoValor2;
        }else{
            textoValor2 = textoValor1;
        }


        try {
            float valor = Float.parseFloat(textoValor1);
            if (valor < 0) {
                // Mostrar una alerta de error indicando que el valor es negativo
                mostrarAlertaError("No se permite ingresar números negativos");
                cerrarTeclado();
                return; // Salir del método ya que no se puede realizar
            }

            float r= Factorial.calcularFactorial(Float.parseFloat(textoValor1));
            String resultado = String.valueOf(r);

            Intent intent = new Intent(this, MainActivity2.class);
            Bundle bundle = new Bundle();
            Calculadora calculadora = new Calculadora(textoValor1, textoValor2, operacion, resultado);
            bundle.putSerializable("Per",calculadora);
            intent.putExtras(bundle);
            startActivity(intent);

        } catch (NumberFormatException e) {
            // Mostrar una alerta de error indicando que uno de los valores no es válido
            mostrarAlertaError("El valor no es válido");
            cerrarTeclado();
        }


    }
    public void potencia(View view){
        String textoValor1 = valor1.getText().toString();
        String textoValor2 = valor2.getText().toString();
        operacion= "potencia";

        if (textoValor1.isEmpty() || textoValor2.isEmpty()) {
            // Mostrar una alerta de error indicando que algún campo está vacío
            mostrarAlertaError("Uno de los campos está vacío");
            cerrarTeclado();
            return; // Salir del método ya que no se puede realizar
        }

        try {

            float valor = Float.parseFloat(textoValor2);
            if (valor < 0) {
                // Mostrar una alerta de error indicando que el valor es negativo
                mostrarAlertaError("No se permite ingresar exponentes negativos");
                cerrarTeclado();
                return; // Salir del método ya que no se puede realizar
            }

            float r = Potencia.calcularPotencia(Float.parseFloat(textoValor1), Float.parseFloat(textoValor2));
            String resultado = String.valueOf(r);

            Intent intent = new Intent(this, MainActivity2.class);
            Bundle bundle = new Bundle();
            Calculadora calculadora = new Calculadora(textoValor1, textoValor2, operacion, resultado);
            bundle.putSerializable("Per",calculadora);
            intent.putExtras(bundle);
            startActivity(intent);

        } catch (NumberFormatException e) {
            // Mostrar una alerta de error indicando que uno de los valores no es válido
            mostrarAlertaError("El valor no es válido");
            cerrarTeclado();
        }
    }

    public void fibonacci(View view){
        String textoValor1 = valor1.getText().toString();
        String textoValor2 = valor2.getText().toString();
        operacion= "fibonacci";

        if (textoValor1.isEmpty() && textoValor2.isEmpty()) {
            // Mostrar una alerta de error indicando que algún campo está vacío
            mostrarAlertaError("Los campos estan vacios");
            cerrarTeclado();
            return; // Salir del método ya que no se puede realizar
        } else if(!textoValor1.isEmpty() && !textoValor2.isEmpty()) {
            // Mostrar una alerta de error indicando que algún campo está vacío
            mostrarAlertaError("Solo usa un espacio");
            cerrarTeclado();
            return; // Salir del método ya que no se puede realizar
        }

        if(textoValor1.isEmpty()){
            textoValor1 = textoValor2;
        }else{
            textoValor2 = textoValor1;
        }

        try {
            float valor = Float.parseFloat(textoValor1);
            if (valor < 0) {
                // Mostrar una alerta de error indicando que el valor es negativo
                mostrarAlertaError("No se permite ingresar números negativos");
                cerrarTeclado();
                return; // Salir del método ya que no se puede realizar
            }

            float r= Fibonacci.fibonacci(Float.parseFloat(textoValor1));
            String resultado = String.valueOf(r);

            Intent intent = new Intent(this, MainActivity2.class);
            Bundle bundle = new Bundle();
            Calculadora calculadora = new Calculadora(textoValor1, textoValor2, operacion, resultado);
            bundle.putSerializable("Per",calculadora);
            intent.putExtras(bundle);
            startActivity(intent);

        } catch (NumberFormatException e) {
            // Mostrar una alerta de error indicando que uno de los valores no es válido
            mostrarAlertaError("El valor no es válido");
            cerrarTeclado();
        }

    }

    private void mostrarAlertaError(String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setMessage(mensaje);
        builder.setCancelable(true); // Permitir cerrar la alerta al tocar fuera de ella

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // Cerrar la alerta
            }
        });

        // Mostrar la alerta
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void cerrarTeclado() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void limpiarEditTexts(View view) {
        EditText editText1 = findViewById(R.id.numero1);
        EditText editText2 = findViewById(R.id.numero2);

        editText1.setText(""); // Establecer el texto vacío en el primer EditText
        editText2.setText(""); // Establecer el texto vacío en el segundo EditText

        editText1.requestFocus();

        // Obtener el servicio InputMethodManager
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        // Mostrar el teclado virtual
        imm.showSoftInput(editText1, InputMethodManager.SHOW_IMPLICIT);
    }

}

