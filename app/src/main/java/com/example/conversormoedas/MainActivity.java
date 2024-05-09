package com.example.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double valorDolar = 5.30;
    double valorEuro = 5.77;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ConverterValores(View view) {
        EditText edtValorEntrada;
        TextView txtValorSaidaDolar, txtValorSaidaEuro;

        //associação das variaveis com os elementos visuais da tela
        edtValorEntrada = findViewById(R.id.edtValorReal);
        txtValorSaidaDolar = findViewById(R.id.txtValorDolar);
        txtValorSaidaEuro = findViewById(R.id.txtValorEuro);

        double valorEmReais = Double.parseDouble(edtValorEntrada.getText().toString());

        //converter dolar
        double auxiliar = valorEmReais / valorDolar;
        txtValorSaidaDolar.setText("U$ " + String.format("%.2f", auxiliar));

        //converter euro
        auxiliar = valorEmReais / valorEuro;
        txtValorSaidaEuro.setText("E$ " + String.format("%.2f", auxiliar));
    }
}