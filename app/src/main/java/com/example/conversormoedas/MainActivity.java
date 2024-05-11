package com.example.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner convertFromUnitTypeSpinner;
    Spinner converToUnitTypeSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //associação das variaveis com os elementos visuais da tela
        convertFromUnitTypeSpinner = findViewById(R.id.spinnerEntrada);
        converToUnitTypeSpinner = findViewById((R.id.spinnerSaida));
    }

    public void onClickConverterButtonEvent(View view){

        //declarar variáveis
        double beginningQty;
        double endingQty;
        String beginningUnitType;
        String endingUnitType;

        //declarar componentes
        EditText qtyEditText = (EditText)findViewById(R.id.qtyEditText);
        TextView resultOutputTextView = (TextView)findViewById(R.id.resultOutputTextView);

        Length_Conversion lengthConverter = new Length_Conversion();

        //obter dados de entrada
        beginningQty = Double.parseDouble(qtyEditText.getText().toString());
        beginningUnitType = convertFromUnitTypeSpinner.getSelectedItem().toString();
        endingUnitType = converToUnitTypeSpinner.getSelectedItem().toString();

        //inserir dados em objetos
        lengthConverter.setBeginningQty(beginningQty);
        lengthConverter.setBeginningUnitType(beginningUnitType);
        lengthConverter.setEndingUnitType(endingUnitType);

        //calcular a conversão
        endingQty = lengthConverter.calculateEndingQty();
        lengthConverter.setEndingQty(endingQty);

        //retornar o resultado para o console
        resultOutputTextView.setText(lengthConverter.toString());
    }
}