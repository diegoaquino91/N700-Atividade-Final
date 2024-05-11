package com.example.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerEntrada;
    private Spinner spinnerSaida;
    private EditText qtyEditText;
    private TextView resultOutputTextView;
    private Length_Conversion lengthConverter;


    Spinner convertFromUnitTypeSpinner;
    Spinner converToUnitTypeSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //associação das variaveis com os elementos visuais da tela
        spinnerEntrada = findViewById(R.id.spinnerEntrada);
        spinnerSaida = findViewById(R.id.spinnerSaida);
        qtyEditText = findViewById(R.id.qtyEditText);
        resultOutputTextView = findViewById(R.id.resultOutputTextView);

        // Inicialização do conversor
        lengthConverter = new Length_Conversion();
    }

    public void onClickConverterButtonEvent(View view) {
        // Obtenção dos dados de entrada
        String inputText = qtyEditText.getText().toString();

        // Verificar se o campo de entrada não está vazio
        if (!inputText.isEmpty()) {
            try {
                double beginningQty = Double.parseDouble(inputText);
                String beginningUnitType = spinnerEntrada.getSelectedItem().toString();
                String endingUnitType = spinnerSaida.getSelectedItem().toString();

                // Configuração dos dados no conversor
                lengthConverter.setBeginningQty(beginningQty);
                lengthConverter.setBeginningUnitType(beginningUnitType);
                lengthConverter.setEndingUnitType(endingUnitType);

                // Cálculo da conversão
                double endingQty = lengthConverter.calculateEndingQty();

                // Exibição do resultado da conversão
                resultOutputTextView.setText(String.valueOf(endingQty));
            } catch (NumberFormatException e) {
                // Se ocorrer um erro ao converter o valor de entrada para double
                resultOutputTextView.setText("Valor de entrada inválido");
            }
        } else {
            // Se o campo de entrada estiver vazio
            resultOutputTextView.setText("Por favor, insira um valor para converter");
        }
    }
}